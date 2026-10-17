
package com.example.studyplanner

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskDetailScreen(
    uiState: TaskDetailUiState,
    onShareClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = uiState.title,
            style = MaterialTheme.typography.headlineMedium
        )

        Button(
            onClick = onShareClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Share")
        }

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TaskDetailPreviewLabReport() {
    TaskDetailScreen(
        uiState = TaskDetailUiState("Lab 5 report"),
        onShareClick = {},
        onBackClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun TaskDetailPreviewExam() {
    TaskDetailScreen(
        uiState = TaskDetailUiState("Review for CSC 402 exam"),
        onShareClick = {},
        onBackClick = {}
    )
}
