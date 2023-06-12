package com.revaldi.calorify.Navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.revaldi.calorify.AnimatedSplashScreen
import com.revaldi.calorify.Data.Article
import com.revaldi.calorify.Data.UserViewModel
import com.revaldi.calorify.Screen.*

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    val viewModel: UserViewModel = viewModel()
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
        composable(route = Screen.Register.route) {
           Register(navController = navController,viewModel = viewModel)
        }
        composable(route = Screen.Login.route) {
            Login(navController = navController,viewModel = viewModel)
        }
        composable(route = Screen.UsernamePersonalization.route) {
            UsernamePersonalization(navController = navController,viewModel = viewModel)
        }
        composable(route = Screen.Greeting.route) {
            GreetingPage(navController = navController)
        }
        composable(route = Screen.GenderPersonalization.route) {
            GenderPersonalization(navController = navController,viewModel = viewModel)
        }
        composable(route = Screen.ActivityPersonalization.route) {
            ActivityPersonalization(navController = navController,viewModel = viewModel)
        }
        composable(route = Screen.HeightWeightPersonalization.route) {
            HeightWeightPersonalization(navController = navController,viewModel = viewModel)
        }

        composable(route = Screen.BirthAndPlacePersonalization.route) {
            BirthAndPlacePersonalization(navController = navController,viewModel = viewModel)
        }
        //homepage
        composable(route = BotNav.Homepage.route) {
            Homepage(navController = navController)
        }
        composable(route = Screen.Home.route) {
            Box(modifier = Modifier.fillMaxSize())
        }
        composable(route = Screen.DetailNews.route) {
            NewsDetail(article = it.arguments?.getParcelable<Article>("article")!!,navController = navController)
        }
        composable(route = BotNav.News.route) {
            NewsScreen(navController= navController)
        }
    }
}