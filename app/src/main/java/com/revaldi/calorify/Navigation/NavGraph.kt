package com.revaldi.calorify.Navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.revaldi.calorify.AnimatedSplashScreen
import com.revaldi.calorify.Screen.*

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            AnimatedSplashScreen(navController = navController)
        }
        composable(route = Screen.Onboarding.route) {
            OnboardingScreen(navController = navController)
        }
        composable(route = Screen.Login.route) {
            Login(navController = navController)
        }
        composable(route = Screen.Greeting.route) {
            GreetingPage(navController = navController)
        }
        composable(route = Screen.GenderPersonalization.route) {
            GenderPersonalization(navController = navController)
        }
        composable(route = Screen.ActivityPersonalization.route) {
            ActivityPersonalization(navController = navController)
        }
        composable(route = Screen.HeightPersonalization.route) {
            HeightPersonalization(navController = navController)
        }
        composable(route = Screen.WeightPersonalization.route) {
            WeightPersonalization(navController = navController)
        }
        composable(route = Screen.BirthAndPlacePersonalization.route) {
            BirthAndPlacePersonalization(navController = navController)
        }
        composable(route = Screen.Home.route) {
            Box(modifier = Modifier.fillMaxSize())
        }
    }
}