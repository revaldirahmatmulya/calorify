package com.revaldi.calorify.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.revaldi.calorify.R
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.revaldi.calorify.Navigation.Screen

@Composable
fun MyUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        Row( modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(PaddingValues(0.dp, 60.dp, 0.dp, 0.dp)),
            horizontalArrangement = Arrangement.Center,

        ) {
            Image(
                painter = painterResource(id = R.drawable.logo), contentDescription = "Group 7",
                modifier = Modifier
                    .width(130.dp)
                    .height(30.dp)
                    .align(alignment = Alignment.Top))
        }
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(PaddingValues(24.dp, 30.dp, 0.dp, 24.dp)),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_dummy),
                contentDescription = "Group 7",
                modifier = Modifier
                    .width(72.dp)
                    .height(72.dp)
            )
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(PaddingValues(16.dp, 0.dp, 0.dp, 0.dp)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                Text(text = "Hi, Indira",
                    modifier = Modifier
                        .wrapContentSize(),
                    color = androidx.compose.ui.graphics.Color.Black,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    fontSize = 16.sp,
                )
                Text(text = "Happy to see you!",
                    modifier = Modifier
                        .wrapContentSize(),
                    color = androidx.compose.ui.graphics.Color.Black,
                    fontSize = 14.sp,
                )
            }
        }
        Text(
            text = "Today,20 June",
            modifier = Modifier
                .wrapContentSize()
                .padding(PaddingValues(24.dp, 20.dp, 0.dp, 9.dp)),
            color = androidx.compose.ui.graphics.Color.Black,
            fontSize = 20.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            textAlign = androidx.compose.ui.text.style.TextAlign.Start
        )
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            Image(
                painter = painterResource(id = R.drawable.chart1),
                contentDescription = "Group 7",
                modifier = Modifier
                    .wrapContentSize()
            )
            Image(
                painter = painterResource(id = R.drawable.chart2),
                contentDescription = "Group 7",
                modifier = Modifier
                    .wrapContentSize()
            )
        }
        Row( modifier =  Modifier
            .padding(PaddingValues(24.dp, 20.dp, 24.dp, 15.dp))
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            ) {
            Text(
                text = "Statistics",
                modifier = Modifier
                    .wrapContentSize(),

                color = androidx.compose.ui.graphics.Color.Black,
                fontSize = 20.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                textAlign = androidx.compose.ui.text.style.TextAlign.Start
            )
            Button(modifier = Modifier
                .border(0.5.dp, Color.Black, RoundedCornerShape(10.dp))
                .width(95.dp)
                .height(35.dp)
                ,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(10.dp),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "See All",
                    color = androidx.compose.ui.graphics.Color.Black,
                    fontSize = 14.sp,
                )
            }

        }
        Image(
            painter = painterResource(id = R.drawable.chart3),
            contentDescription = "Group 7",
            modifier = Modifier
                .width(342.dp)
                .height(260.dp)
                .padding(PaddingValues(24.dp, 10.dp, 24.dp, 0.dp))
        )
    }
}



@Composable
fun Homepage(navController: NavHostController) {

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(65.dp)
                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
                cutoutShape = CircleShape,
                backgroundColor = Color(0xff6f7cfc),
                elevation = 22.dp,
            ) {
                BottomNav(navController = navController)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = {

                },
                contentColor = Color.White,
                backgroundColor = Color(0xff6f7cfc),
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add icon")
            }
        }
    ) {
            innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            MyUI()
        }
    }
}
@Composable
fun BottomNav(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination
    BottomNavigation(
        modifier = Modifier
            .padding(12.dp, 0.dp, 12.dp, 0.dp)
            .height(100.dp)

            ,
        backgroundColor = Color(0xff6f7cfc),
        elevation = 0.dp
    ) {
        items.forEach {
            BottomNavigationItem(
                icon = {
                    it.icon?.let {
                        Icon(
                            imageVector = it,
                            contentDescription = "",
                            modifier = Modifier.size(35.dp),
                            tint = Color.White

                        )
                    }
                },
                label = {
                    it.title?.let {
                        Text(
                            text = it,
                            color = Color.White
                        )
                    }
                },
                selected = currentRoute?.hierarchy?.any { it.route == it.route } == true,

                onClick = {

                }
            )
        }
    }
}
sealed class BotNav(val route: String, val title: String, val icon: ImageVector) {
    object Homepage : BotNav(route = "homepage_screen", "Home", Icons.Default.Home)
    object News : BotNav(route = "news_screen", "News", Icons.Default.List)
}
val items = listOf(
    BotNav.Homepage,
    BotNav.News
)





@Preview
@Composable
fun PreviewHomepage() {
    Homepage(navController = NavHostController(LocalContext.current))
}

