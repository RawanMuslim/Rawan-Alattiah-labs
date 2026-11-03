package com.example.studyplanner

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.studyplanner.navigation.PlannerHome
import com.example.studyplanner.navigation.TaskDetail

@Composable
fun StudyPlannerApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PlannerHome
    ) {
        composable<PlannerHome> {
            PlannerHomeRoute(
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