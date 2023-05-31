package com.revaldi.calorify.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.revaldi.calorify.Navigation.Screen
import com.revaldi.calorify.R

@Composable
fun Login(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(width = 390.dp)
                .padding(start = 24.dp,
                    end = 24.dp,
                    top = 105.dp,
                    bottom = 41.dp)
                .fillMaxHeight(),

            verticalArrangement = Arrangement.SpaceBetween

        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Group 7",
                colorFilter = ColorFilter.tint(Color(0xff6e7bfb)),
                modifier = Modifier
                    .width(width = 146.dp)
                    .height(height = 33.dp))
            Spacer(
                modifier = Modifier
                    .height(height = 52.dp))
            Text(text = "Already have an account?",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp))
            Text(text = "Sign In and start tracking your calories",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp))

            RoundedTextField(
                hint = "Revaldiaye@gmail.com",
                label = "Email",
                value = "",
                onValueChange = { }
            )
            RoundedTextField(
                hint = "Password",
                label = "Password",
                value = "",
                onValueChange = { }
            )
            Spacer(
                modifier = Modifier
                    .height(height = 16.dp))
            SignInButton(){
                navController.navigate(Screen.Greeting.route)
            }
            Spacer(
                modifier = Modifier
                    .height(height = 16.dp))
            GoogleButton()

        }
    }



}

//make a new composable function for the text field with hint

@Composable
fun RoundedTextField(
    hint: String,
    label:String,
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    Text(
        text = label,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        textStyle = TextStyle(color = Color.Black),
        shape = RoundedCornerShape(30.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.Black,
            disabledIndicatorColor = Color.Transparent

        ),
        placeholder = {
            Text(
                text = hint,
                style = TextStyle(color = Color.Gray)
            )
        }
    )
}


@Composable
fun SignInButton(
    onClick: () -> Unit
) {
    Button(
        onClick =  onClick ,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(Color(0xff7884fc)),
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 60.dp)
            .padding(horizontal = 24.dp,
                vertical = 8.dp)
    ) {
        Text(
            text = "Sign In",
            color = Color.White,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp))
    }
}

@Composable
fun GoogleButton() {
    Button(
        onClick = { },
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(Color.White),
        modifier = Modifier
            .width(width = 262.dp)
            .height(height = 60.dp)
            .padding(start = 35.dp,
                end = 40.dp,
                top = 8.dp,
                bottom = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_google),
            contentDescription = "google icon 1",
            colorFilter = ColorFilter.tint(Color(0xff4280ef)),
            modifier = Modifier
                .height(height = 24.dp))
        Spacer(
            modifier = Modifier
                .width(width = 8.dp))
        Text(
            text = "Sign in with Google",
            color = Color.Black,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 14.sp))
    }
}

@Preview
@Composable
fun LoginPreview() {
    Login(navController = NavHostController(LocalContext.current))
}
