
package com.example.studyplanner

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.studyplanner.navigation.PlannerHome
import com.example.studyplanner.navigation.TaskDetail
import kotlinx.serialization.Serializable

@Composable
fun StudyPlannerApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PlannerHome
    ) {
        composable<PlannerHome> {
            val uiState = PlannerUiState(
                tasks = listOf(
                    "Lab 5 report",
                    "Review Lecture 4",
                    "Complete CSC 402 assignment"
                )
            )

            PlannerHomeScreen(
                uiState = uiState,
                onTaskClick = { title ->
                    navController.navigate(TaskDetail(title))
                }
            )
        }

        composable<TaskDetail> { backStackEntry ->
            val route = backStackEntry.toRoute<TaskDetail>()

            TaskDetailRoute(
                title = route.title,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
