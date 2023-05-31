package com.revaldi.calorify.Screen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun WeightPersonalization(navController: NavHostController) {
    var weightText = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(width = 390.dp)
            .padding(start = 8.dp, top = 19.dp, bottom = 30.dp)
    ) {
        Spacer(modifier = Modifier.height(height = 77.dp))
        Text(
            text = "How weight are you?",
            color = Color(0xff3b3b3b),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Black
            )
        )
        Spacer(modifier = Modifier.height(height = 20.dp))
        Text(
            text = "We will depend on it",
            color = Color(0xff3b3b3b),
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 18.sp),
            modifier = Modifier.width(width = 298.dp)
        )
        Spacer(modifier = Modifier.height(height = 38.dp))

        // Text Field for Weight Input
        TextField(
            value = weightText.value,
            onValueChange = { value -> weightText.value = value },
            label = { Text(text = "Enter your weight") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(height = 113.dp))
        Divider(color = Color(0xffd3d7ff))
        Spacer(modifier = Modifier.height(height = 95.dp))
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .width(width = 346.dp)
                .height(height = 103.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                // Display the entered weight
                Text(
                    text = weightText.value,
                    color = Color(0xff3b3b3b),
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontSize = 18.sp)
                )
            }
        }

        Spacer(modifier = Modifier.height(height = 60.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* Handle back button click here */ },
                shape = RoundedCornerShape(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xff6e7bfb)),
                modifier = Modifier.padding(horizontal = 50.dp, vertical = 15.dp)
            ) {
                Text(
                    text = "Back",
                    color = Color.White,
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Black)
                )
            }

            Button(
                onClick = { navController.navigate("birth_and_place_personalization_screen") },
                shape = RoundedCornerShape(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xff6f7cfc)),
                modifier = Modifier.padding(horizontal = 50.dp, vertical = 15.dp)
            ) {
                Text(
                    text = "Next",
                    color = Color.White,
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Black)
                )
            }
        }
    }
}
