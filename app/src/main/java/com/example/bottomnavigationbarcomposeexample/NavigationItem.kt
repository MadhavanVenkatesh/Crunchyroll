package com.example.bottomnavigationbarcomposeexample

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object Music : NavigationItem("music", R.drawable.ic_music, "MyList")
    object Movies : NavigationItem("movies", R.drawable.ic_baseline_search_24, "Browse")
    object Books : NavigationItem("books", R.drawable.ic_baseline_star_outline_24, "Cast")
    object Profile : NavigationItem("profile", R.drawable.ic_profile, "Profile")
}