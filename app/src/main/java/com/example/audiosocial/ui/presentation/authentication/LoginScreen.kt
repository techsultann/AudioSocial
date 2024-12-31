package com.example.audiosocial.ui.presentation.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
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
fun LoginScreen(
    gotoSignup: () -> Unit,
    gotoHomeScreen: () -> Unit
){
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var checked by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.microphone),
            contentDescription = "microphone image",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(200.dp)
        )
        Text(
            text = "Welcome back!!",
            fontWeight = FontWeight.Bold,
            style = AppTypography.headlineLarge,
            modifier = Modifier
        )
        Text(
            text = "Please, log in to your account.",
            style = AppTypography.bodyMedium,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Email",
            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
            textAlign = TextAlign.Start
        )
        AppTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
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
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
            Text(
                text = "Remember me",
                modifier = Modifier,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Forgot Password?",
                color = secondaryLight
            )
        }
        AppButton(
            onClick = { gotoHomeScreen() },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.small
        ) {
            Text(
                text = "Log in",
                style = AppTypography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = buildAnnotatedString {
                append("Don't have an account?")
                withStyle(
                    style = SpanStyle(
                        color = secondaryLight,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                ){
                    append(" Sign up.")
                }
            },
        )
    }
}
@Preview
@Composable
fun PreviewLoginScreen(){
    LoginScreen(
        gotoHomeScreen = {},
        gotoSignup = {}
    )
}