package com.example.lab3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChainA(modifier: Modifier = Modifier) {
    Text(
        "content",
        modifier = modifier
            .background(Color(0xFF3DDC84))
            .padding(24.dp)
    )
}
@Composable
fun ChainB(modifier: Modifier = Modifier) {
    Text(
        "content",
        modifier = modifier
            .padding(24.dp)
            .background(Color(0xFF3DDC84))
    )
}
@Composable
fun ChainC(modifier: Modifier = Modifier) {
    Text(
        "content",
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF3DDC84))
    )
}
@Preview(showBackground = true)
@Composable
fun OrderPuzzlePreview() {
    Column {
        ChainA()
        ChainB()
        ChainC()
    }
}