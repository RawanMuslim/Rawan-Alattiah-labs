package com.example.lab8


data class TodayUiState(
    val isLoading: Boolean = true,
    val tasks: List<StudyTask> = emptyList(),
    val message: String? = null
)