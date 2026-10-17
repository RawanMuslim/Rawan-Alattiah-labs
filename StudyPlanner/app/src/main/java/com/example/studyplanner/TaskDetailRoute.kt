
package com.example.studyplanner

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun TaskDetailRoute(
    title: String,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current

    TaskDetailScreen(
        uiState = TaskDetailUiState(title = title),
        onShareClick = {
            shareTask(context, title)
        },
        onBackClick = onBackClick
    )
}

private fun shareTask(
    context: Context,
    title: String
) {
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(
            Intent.EXTRA_TEXT,
            "Today I'm studying: $title"
        )
    }

    val chooser = Intent.createChooser(
        sendIntent,
        "Share study task"
    )

    context.startActivity(chooser)
}
