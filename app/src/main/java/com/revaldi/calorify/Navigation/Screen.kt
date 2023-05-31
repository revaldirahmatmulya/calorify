package com.revaldi.calorify.Navigation

sealed class Screen(val route: String) {
    object Splash : Screen(route="splash_screen")
    object Onboarding : Screen(route = "onboarding_screen")
    object Login : Screen(route = "login_screen")
    object Greeting : Screen(route = "greeting_screen")
    object GenderPersonalization : Screen(route = "gender_personalization_screen")
    object HeightPersonalization : Screen(route = "height_personalization_screen")
    object WeightPersonalization : Screen(route = "weight_personalization_screen")
    object ActivityPersonalization : Screen(route = "activity_personalization_screen")
    object BirthAndPlacePersonalization : Screen(route = "birth_and_place_personalization_screen")
    object Home : Screen("home_screen")
}