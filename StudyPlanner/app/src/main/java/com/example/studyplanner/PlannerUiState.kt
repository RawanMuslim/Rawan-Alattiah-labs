package com.example.studyplanner

data class PlannerUiState(
    val greeting: String = "Hello!",
    val tasks: List<StudyTask> = emptyList()
)