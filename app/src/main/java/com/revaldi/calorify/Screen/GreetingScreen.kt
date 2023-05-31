package com.revaldi.calorify.Screen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.revaldi.calorify.Navigation.Screen
import com.revaldi.calorify.R


@Composable
fun GreetingPage(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.vector_bg),
            contentDescription = "Vector 5",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.img4),
                contentDescription = "Group 7",
                modifier = Modifier
                    .width(500.dp)
                    .height(500.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Welcome!",
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
            )
            Text(
                text = "Personalize Your Body Condition Based on Your Goals",
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 18.sp),
                modifier = Modifier.width(298.dp)
            )
            Spacer(modifier = Modifier.height(70.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
            contentAlignment = Alignment.BottomEnd
            ) {
                Button(
                    onClick = { navController.navigate(Screen.GenderPersonalization.route) },
                    shape = RoundedCornerShape(40.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier.padding(vertical = 15.dp, horizontal = 50.dp).align(
                        Alignment.BottomEnd)
                ) {
                    Text(
                        text = "Start",
                        color = Color(0xff6f7cfc),
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Black)
                    )
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPagePreview() {
    GreetingPage(navController = NavHostController(LocalContext.current))
}
