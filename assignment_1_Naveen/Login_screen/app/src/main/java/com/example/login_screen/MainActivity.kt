package com.example.login_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login_screen.ui.theme.Login_screenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login_screenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    Login()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Login() {

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.login_bg),
            contentDescription = "Login",
            modifier = Modifier
                .fillMaxSize()
                .blur(6.dp),
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
            .alpha(0.6f)
            .clip(
                CutCornerShape(
                    topStart = 8.dp,
                    topEnd = 16.dp,
                    bottomStart = 16.dp,
                    bottomEnd = 8.dp
                )
            )
            .background(MaterialTheme.colorScheme.background)
        )

        Column(
            Modifier
                .fillMaxSize()
                .padding(48.dp),
        horizontalAlignment  = Alignment.CenterHorizontally
        ) {
            LoginHeader()

            LoginFields(username, password,
                onUsernameChange = {
                    username = it
                },
                onPasswordChange = {
                    password = it
                },
                onForgotPasswordClick = {

                })
            LoginFooter(
                onSignInClick = {},
                onSignUpClick = {}
            )
        }
    }
}

@Composable
fun LoginHeader() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome Back", fontSize = 36.sp, fontWeight = FontWeight.ExtraBold)
        Text(text = "Sign in to continue", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun ColumnScope.LoginFields(username: String,
                password: String,
                onUsernameChange: (String) -> Unit, 
                onPasswordChange: (String) -> Unit,
                onForgotPasswordClick: () -> Unit,
                ) {
    Demofield(value = username, 
        label = "Username",
        placeholder = "Enter your email address", 
        onValueChange = onUsernameChange,
        leadingIcon = {
            Icon(Icons.Default.Email, contentDescription = "Email")
        }
    )
    
    Spacer(modifier = Modifier.height(8.dp))
    Demofield(value = password,
        label = "Password",
        placeholder = "Enter Password",
        onValueChange = onPasswordChange,
        leadingIcon = {
            Icon(Icons.Default.Lock, contentDescription = "Password")
        }
    )
    TextButton(onClick = onForgotPasswordClick, modifier = Modifier.align(Alignment.End)) {
        Text(text = "Forgot Password?")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Demofield(value: String,
              label: String,
              placeholder: String,
              visualTransformation: VisualTransformation = VisualTransformation.None,
              keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
              leadingIcon: @Composable (() -> Unit)? = null,
              trailingIcon: @Composable (() -> Unit)? = null,
              onValueChange: (String) -> Unit){

    OutlinedTextField(value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeholder)
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )
}

@Composable
fun LoginFooter(
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = onSignInClick, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Sign in")
        }
        TextButton(onClick = onSignUpClick) {
            Text(text = "Don't have an account, click here")
        }
    }
}
