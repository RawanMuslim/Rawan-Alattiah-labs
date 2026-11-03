package com.example.studyplanner


import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun PlannerHomeRoute(
    onTaskClick: (String) -> Unit
) {
    var uiState by remember {
        mutableStateOf(
            PlannerUiState(
                greeting = "Hello!",
                tasks = listOf(
                    StudyTask(1, "Lab 5 report", "CSC 402"),
                    StudyTask(2, "Review Lecture 4", "CSC 402"),
                    StudyTask(3, "Complete assignment", "CSC 307"),
                    StudyTask(4, "Study Android Navigation", "CSC 402"),
                    StudyTask(5, "Prepare for exam", "CSC 307")
                )
            )
        )
    }

    PlannerHomeScreen(
        uiState = uiState,
        onTaskClick = { id ->
            val task = uiState.tasks.find { it.id == id }
            if (task != null) {
                onTaskClick(task.title)
            }
        },
        onDoneChange = { id, checked ->
            uiState = uiState.copy(
                tasks = uiState.tasks.map { task ->
                    if (task.id == id) {
                        task.copy(isDone = checked)
                    } else {
                        task
                    }
                }
            )
        }
    )
}