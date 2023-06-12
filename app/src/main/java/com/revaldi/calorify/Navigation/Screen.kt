package com.revaldi.calorify.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home

sealed class Screen(val route: String) {
    object Splash : Screen(route="splash_screen")
    object Onboarding : Screen(route = "onboarding_screen")
    object Register : Screen(route = "register_screen")
    object Login : Screen(route = "login_screen")
    object UsernamePersonalization : Screen(route = "username_personalization_screen")
    object Greeting : Screen(route = "greeting_screen")
    object GenderPersonalization : Screen(route = "gender_personalization_screen")
    object HeightWeightPersonalization : Screen(route = "heightweight_personalization_screen")

    object ActivityPersonalization : Screen(route = "activity_personalization_screen")
    object BirthAndPlacePersonalization : Screen(route = "birth_and_place_personalization_screen")

    object Home : Screen("home_screen")
    object DetailNews : Screen("detail/{article}")

}