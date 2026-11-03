package com.example.studyplanner

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TaskItem(
    task: StudyTask,
    onTaskClick: (Int) -> Unit,
    onDoneChange: (Int, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onTaskClick(task.id)
            }
    ) {
        Checkbox(
            checked = task.isDone,
            onCheckedChange = { checked ->
                onDoneChange(task.id, checked)
            }
        )

        Column {
            Text(text = task.title)
            Text(text = task.course)
        }
    }
}

@Preview(showBackground = true, name = "Task Not Done")
@Composable
fun TaskItemNotDonePreview() {
    TaskItem(
        task = StudyTask(1, "Lab 5 report", "CSC 402", false),
        onTaskClick = {},
        onDoneChange = { _, _ -> }
    )
}

@Preview(showBackground = true, name = "Task Done")
@Composable
fun TaskItemDonePreview() {
    TaskItem(
        task = StudyTask(2, "Review Lecture 4", "CSC 402", true),
        onTaskClick = {},
        onDoneChange = { _, _ -> }
    )
}