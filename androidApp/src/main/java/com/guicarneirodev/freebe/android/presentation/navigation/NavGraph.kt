package com.guicarneirodev.freebe.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.guicarneirodev.freebe.android.presentation.screens.registration.DriverRegistrationScreen
import com.guicarneirodev.freebe.android.presentation.screens.roleselection.RoleSelectionScreen

sealed class Screen(val route: String) {
    object RoleSelection : Screen("role_selection")
    object DriverRegistration : Screen("driver_registration")
}

@Composable
fun FreeBeeNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.RoleSelection.route
    ) {
        composable(Screen.RoleSelection.route) {
            RoleSelectionScreen(
                onDriverSelected = {
                    navController.navigate(Screen.DriverRegistration.route)
                },
                onCompanySelected = { /* Implementar depois */ },
                onLoginClick = { /* Implementar depois */ }
            )
        }

        composable(Screen.DriverRegistration.route) {
            DriverRegistrationScreen()
        }
    }
}