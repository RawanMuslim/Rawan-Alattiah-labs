package com.example.studyplanner

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TaskCount(count: Int) {
    Text(text = "You have $count study tasks")
}

@Composable
fun AddTaskRow(
    text: String,
    onTextChange: (String) -> Unit,
    onAdd: () -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            label = { Text("New task") },
            modifier = Modifier.weight(1f)
        )

        Button(onClick = onAdd) {
            Text("Add")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddTaskRowPreview() {
    AddTaskRow(
        text = "Read Ch. 2",
        onTextChange = {},
        onAdd = {}
    )
}