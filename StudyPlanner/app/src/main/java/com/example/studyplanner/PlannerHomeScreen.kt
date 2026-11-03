package com.example.studyplanner

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    draft: String,
    onDraftChange: (String) -> Unit,
    onAddTask: () -> Unit,
    onTaskClick: (Int) -> Unit,
    onDoneChange: (Int, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Study Planner")

        Text(
            text = "${uiState.tasks.count { it.isDone }} of ${uiState.tasks.size} done"
        )

        TaskCount(count = uiState.tasks.size)

        AddTaskRow(
            text = draft,
            onTextChange = onDraftChange,
            onAdd = onAddTask
        )

        LazyColumn {
            items(
                items = uiState.tasks,
                key = { it.id }
            ) { task ->
                TaskItem(
                    task = task,
                    onTaskClick = onTaskClick,
                    onDoneChange = onDoneChange
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlannerHomeScreenPreview() {
    PlannerHomeScreen(
        uiState = PlannerUiState(
            greeting = "Hello!",
            tasks = listOf(
                StudyTask(1, "Lab 5 report", "CSC 402", true),
                StudyTask(2, "Review Lecture 4", "CSC 402"),
                StudyTask(3, "Complete assignment", "CSC 307")
            )
        ),
        draft = "",
        onDraftChange = {},
        onAddTask = {},
        onTaskClick = {},
        onDoneChange = { _, _ -> }
    )
}