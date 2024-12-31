package com.example.audiosocial.utils

import android.content.Context
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.exceptions.NoCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException

object GoogleSignInManager {
    private lateinit var credentialManager: CredentialManager

    suspend fun googleSignIn(
        context: Context,
        clientId: String,
        filterByAuthorizedAccounts: Boolean,
        doOnSuccess: (GoogleUser) -> Unit,
        doOnError: (Exception) -> Unit,
    ) {

        if (::credentialManager.isInitialized.not()) {
            credentialManager = CredentialManager
                .create(context)
        }

        val googleIdOption: GetGoogleIdOption = GetGoogleIdOption
            .Builder()
            .setFilterByAuthorizedAccounts(false)
            .setServerClientId(clientId)
            .setAutoSelectEnabled(false)
            .build()

        val request: GetCredentialRequest = GetCredentialRequest
            .Builder()
            .addCredentialOption(googleIdOption)
            .build()

        requestSignIn(
            context,
            request,
            clientId,
            filterByAuthorizedAccounts,
            doOnSuccess,
            doOnError
        )
    }

    private suspend fun requestSignIn(
        context: Context,
        request: GetCredentialRequest,
        apiKey: String,
        filterByAuthorizedAccounts: Boolean,
        doOnSuccess: (GoogleUser) -> Unit,
        doOnError: (Exception) -> Unit,
    ) {
        try {
            val result: GetCredentialResponse = credentialManager.getCredential(
                request = request,
                context = context,
            )
            val googleUser = handleCredentials(result.credential)
            googleUser?.let {
                doOnSuccess(it)
            } ?: doOnError(Exception("Invalid user"))
        } catch (e: Exception){
            if (e is NoCredentialException && filterByAuthorizedAccounts) {
                googleSignIn(
                    context,
                    apiKey,
                    false,
                    doOnSuccess,
                    doOnError
                )
            } else {
                doOnError(e)
            }
        }
    }

    private fun handleCredentials(credential: Credential): GoogleUser? {
        when (credential) {

            // GoogleIdToken credential
            is CustomCredential -> {
                if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                    try {
                        // Use googleIdTokenCredential and extract id to validate and
                        // authenticate on your server.
                        val googleIdTokenCredential = GoogleIdTokenCredential
                            .createFrom(credential.data)
                        val email = googleIdTokenCredential.displayName
                        val mobileNumber = googleIdTokenCredential.phoneNumber
                        val firstName = googleIdTokenCredential.displayName
                        val profilePicture = googleIdTokenCredential.profilePictureUri

                        return GoogleUser(
                            email = email,
                            firstName = firstName,
                            lastName = "",
                            mobile = mobileNumber,
                            profilePictureUri = profilePicture.toString()
                        )
                    } catch (e: GoogleIdTokenParsingException) {
                        println("Received an invalid google id token response $e")
                    }
                } else {
                    // Catch any unrecognized custom credential type here.
                    println("Unexpected type of credential")
                }
            }

            else -> {
                // Catch any unrecognized credential type here.
                println("Unexpected type of credential")
            }
        }
        return null
    }
}

data class GoogleUser(
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val mobile: String?,
    val profilePictureUri: String?,
)