package com.example.lab8


import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun TodayRoute(
    viewModel: TodayViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    TodayScreen(
        uiState = uiState,
        onTaskCheckedChange = { task: StudyTask, done: Boolean ->
            viewModel.onTaskCheckedChange(task, done)
        },
        onMessageShown = {
            viewModel.onMessageShown()
        }
    )
}

@Composable
fun TodayScreen(
    uiState: TodayUiState,
    onTaskCheckedChange: (StudyTask, Boolean) -> Unit,
    onMessageShown: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(uiState.message) {
        val message = uiState.message
        if (message != null) {
            snackbarHostState.showSnackbar(message)
            onMessageShown()
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "Today",
                    Modifier.weight(1f),
                    style = MaterialTheme.typography.headlineMedium
                )

                TextButton(onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            "Tick a task when you finish it"
                        )
                    }
                }) {
                    Text("Help")
                }
            }

            if (uiState.isLoading) {
                CircularProgressIndicator()
            } else {
                uiState.tasks.forEach { task ->
                    TaskRow(task, onTaskCheckedChange)
                }
            }
        }
    }}

@Composable
fun TaskRow(
    task: StudyTask,
    onCheckedChange: (StudyTask, Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = task.isDone,
            onCheckedChange = { done ->
                onCheckedChange(task, done)
            }
        )

        Column {
            Text(task.title)
            Text(
                task.course,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
