package com.example.studyplanner

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class StudyPlannerViewModel : ViewModel() {

    var uiState by mutableStateOf(
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
        private set

    fun addTask(title: String) {
        if (title.isNotBlank()) {
            val newId = (uiState.tasks.maxOfOrNull { it.id } ?: 0) + 1

            val newTask = StudyTask(
                id = newId,
                title = title.trim(),
                course = "General"
            )

            uiState = uiState.copy(
                tasks = uiState.tasks + newTask
            )
        }
    }

    fun updateTaskDone(id: Int, checked: Boolean) {
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
}