package com.example.lab1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1.ui.theme.AndroidGreen
import com.example.lab1.ui.theme.Navy
import com.example.lab1.ui.theme.ScreenBackground

data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val days: String
)

@Composable
fun CourseListScreen(modifier: Modifier = Modifier) {

    val courses = remember {
        listOf(
            Course(
                code = "CSC 402",
                title = "Mobile Application Programming",
                credits = 3,
                days = "Sun / Tue"
            ),
            Course(
                code = "ARTI 404",
                title = "Image Processing",
                credits = 3,
                days = "Mon / Wed"
            ),
            Course(
                code = "CIS 307",
                title = "Research Methods",
                credits = 3,
                days = "Sun / Tue"
            ),
            Course(
                code = "SWE 301",
                title = "Software Engineering",
                credits = 3,
                days = "Mon / Wed"
            ),
            Course(
                code = "MATH 201",
                title = "Discrete Mathematics",
                credits = 3,
                days = "Thu"
            ),
            Course(
                code = "PHYS 105",
                title = "General Physics II",
                credits = 4,
                days = "Sun / Tue"
            ),
            Course(
                code = "ISLM 101",
                title = "Islamic Culture",
                credits = 2,
                days = "Thu"
            )
        )
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(ScreenBackground),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(courses) { course ->
            CourseRow(course)
        }
    }
}

@Composable
fun CourseRow(course: Course) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(
                modifier = Modifier
                    .width(5.dp)
                    .height(70.dp)
                    .background(
                        color = AndroidGreen,
                        shape = RoundedCornerShape(4.dp)
                    )
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = course.code,
                    color = Navy,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = course.title,
                    color = Color.Black,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = course.days,
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "${course.credits} cr",
                modifier = Modifier
                    .background(
                        color = AndroidGreen,
                        shape = RoundedCornerShape(50.dp)
                    )
                    .padding(
                        horizontal = 12.dp,
                        vertical = 6.dp
                    ),
                color = Color.Black,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseListScreenPreview() {
    CourseListScreen()
}
