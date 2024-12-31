package com.example.audiosocial.ui.presentation.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.audiosocial.R
import com.example.audiosocial.component.AppButton
import com.example.audiosocial.component.AppTextField
import com.example.audiosocial.ui.theme.AppTypography
import com.example.audiosocial.ui.theme.secondaryLight

@Composable
fun SignupScreen(
    gotoSignIn: () -> Unit,
){
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var handle by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var confirmPasswordVisible by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.microphone),
            contentDescription = "microphone image",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(200.dp)
        )
        Text(
            text = "Create an account",
            fontWeight = FontWeight.Bold,
            style = AppTypography.headlineLarge,
            modifier = Modifier
        )
        Text(
            text = "Please, setup your account to start voicing",
            style = AppTypography.bodyMedium,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Firstname",
            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
            textAlign = TextAlign.Start
        )
        AppTextField(
            value = firstName,
            onValueChange = { firstName = it },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            placeholder = {
                Text("First name")
            }
        )
        Text(
            text = "Lastname",
            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
            textAlign = TextAlign.Start
        )
        AppTextField(
            value = lastName,
            onValueChange = { lastName = it },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            placeholder = {
                Text("Last name")
            }
        )
        Text(
            text = "Handle",
            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
            textAlign = TextAlign.Start
        )
        AppTextField(
            value = handle,
            onValueChange = { handle = it },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            placeholder = {
                Text("handle")
            }
        )
        Text(
            text = "Email",
            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
            textAlign = TextAlign.Start
        )
        AppTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            placeholder = {
                Text("youremail@account.com")
            }
        )
        Text(
            text = "Password",
            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
            textAlign = TextAlign.Start
        )
        AppTextField(
            value = password,
            onValueChange = { password = it },
            trailingIcon = {
                IconButton(
                    onClick = { passwordVisible = !passwordVisible }
                ) {
                    val passwordVisibleIcon = if (passwordVisible) painterResource(R.drawable.visibility) else painterResource(R.drawable.visibility_off)
                    Icon(
                        painter = passwordVisibleIcon,
                        contentDescription = "password visible icon"
                    )
                }
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            placeholder = {
                Text("password")
            }
        )
        Text(
            text = "Confirm Password",
            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
            textAlign = TextAlign.Start
        )
        AppTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            trailingIcon = {
                IconButton(
                    onClick = { confirmPasswordVisible = !confirmPasswordVisible }
                ) {
                    val passwordVisibleIcon = if (confirmPasswordVisible) painterResource(R.drawable.visibility) else painterResource(R.drawable.visibility_off)
                    Icon(
                        painter = passwordVisibleIcon,
                        contentDescription = "password visible icon"
                    )
                }
            },
            visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            placeholder = {
                Text("Confirm Password")
            }
        )
        AppButton(
            onClick = { gotoSignIn() },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.small
        ) {
            Text(
                text = "Sign up",
                style = AppTypography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = buildAnnotatedString {
                append("Already have an account?")
                withStyle(
                    style = SpanStyle(
                        color = secondaryLight,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                ){
                    append(" Sign in.")
                }
            },
            modifier = Modifier.navigationBarsPadding()
        )
    }
}

@Preview
@Composable
fun PreviewSignup(){
    SignupScreen(
        gotoSignIn = {}
    )
}