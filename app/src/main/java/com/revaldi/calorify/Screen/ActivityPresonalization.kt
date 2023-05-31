package com.revaldi.calorify.Screen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.revaldi.calorify.Navigation.Screen
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun ActivityPersonalization(navController: NavHostController) {
    var selectedOption by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(width = 390.dp)
            .padding(start = 8.dp, end = 7.dp, top = 12.dp, bottom = 30.dp)
    ) {
        Spacer(modifier = Modifier.height(height = 77.dp))
        Text(
            text = "Rate your activity",
            color = Color(0xff3b3b3b),
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Black)
        )
        Spacer(modifier = Modifier.height(height = 20.dp))
        Text(
            text = "Excluding exercise",
            color = Color(0xff3b3b3b),
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 18.sp),
            modifier = Modifier.width(width = 298.dp)
        )
        Spacer(modifier = Modifier.height(height = 61.dp))

        RadioButtonCard(
            isSelected = selectedOption == "Not Very Active",
            onClick = { selectedOption = "Not Very Active" },
            label = "Not Very Active",
            description = "Lorem ipsum dolor sit amet consectetur."
        )

        Spacer(modifier = Modifier.height(height = 44.dp))

        RadioButtonCard(
            isSelected = selectedOption == "Somewhat Active",
            onClick = { selectedOption = "Somewhat Active" },
            label = "Somewhat Active",
            description = "Lorem ipsum dolor sit amet consectetur."
        )

        Spacer(modifier = Modifier.height(height = 44.dp))

        RadioButtonCard(
            isSelected = selectedOption == "Active",
            onClick = { selectedOption = "Active" },
            label = "Active",
            description = "Lorem ipsum dolor sit amet consectetur."
        )

        Spacer(modifier = Modifier.height(height = 44.dp))

        RadioButtonCard(
            isSelected = selectedOption == "Very Active",
            onClick = { selectedOption = "Very Active" },
            label = "Very Active",
            description = "Lorem ipsum dolor sit amet consectetur."
        )

        Spacer(modifier = Modifier.height(height = 91.dp))

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
                onClick = {  navController.navigate(Screen.HeightPersonalization.route) },
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


@Composable
fun RadioButtonCard(
    isSelected: Boolean,
    onClick: () -> Unit,
    label: String,
    description: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(width = 342.dp)
            .height(height = 95.dp)
            .clickable(onClick = onClick)
            .background(if (isSelected) Color(0xff6f7cfc) else Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = label,
            color = if (isSelected) Color.White else Color(0xff6371ff),
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(height = 8.dp))
        Text(
            text = description,
            color = Color.Black,
            style = TextStyle(fontSize = 14.sp)
        )
    }
}