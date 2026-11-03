package com.example.studyplanner

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PlannerHomeRoute(
    onTaskClick: (String) -> Unit
) {
    val viewModel: StudyPlannerViewModel = viewModel()
    val uiState = viewModel.uiState

    var draft by rememberSaveable {
        mutableStateOf("")
    }

    PlannerHomeScreen(
        uiState = uiState,
        draft = draft,
        onDraftChange = { newText ->
            draft = newText
        },
        onAddTask = {
            viewModel.addTask(draft)
            draft = ""
        },
        onTaskClick = { id ->
            val task = uiState.tasks.find { it.id == id }
            if (task != null) {
                onTaskClick(task.title)
            }
        },
        onDoneChange = { id, checked ->
            viewModel.updateTaskDone(id, checked)
        }
    )
}