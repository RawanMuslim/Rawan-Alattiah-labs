package com.example.lab3

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab3.ui.theme.Lab3Theme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.weight
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.draw.clip
import androidx.compose.material3.MaterialTheme
import android.content.res.Configuration
data class Student(
    val name: String,
    val program: String,
    val gpa: String,
    val email: String,
    val city: String
)
val sampleStudent = Student(
    name = "Rawan Alattiah",
    program = "Computer Science",
    gpa = "4.5",
    email = "rawan@example.com",
    city = "Dammam"
)
val students = listOf(
    Student("Rawan Alattiah", "Computer Science", "4.5", "rawan@example.com", "Dammam"),
    Student("Sara Ahmed", "Computer Science", "4.2", "sara@example.com", "Riyadh"),
    Student("Noura Ali", "Information Systems", "4.7", "noura@example.com", "Jubail"),
    Student("Lama Mohammed", "Cyber Security", "4.0", "lama@example.com", "Khobar"),
    Student("Huda Hassan", "Computer Science", "4.3", "huda@example.com", "Dhahran")
)
@Composable
fun StudentCard(
    student: Student,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.size(52.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF52836A)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "RA",
                            color = Color.White
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(14.dp)
                            .align(Alignment.BottomEnd)
                            .background(MaterialTheme.colorScheme.tertiary, CircleShape)
                            .border(2.dp, Color.White, CircleShape)
                    )
                }
                Spacer(Modifier.width(12.dp))
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = student.name,
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(text = student.program, color = MaterialTheme.colorScheme.onSurfaceVariant
                        ,style = MaterialTheme.typography.bodyMedium)
                }
                Text(
                    text = student.gpa,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            HorizontalDivider()
            Text(text = student.email,color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(text = student.city,color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium)
        }
    }}
@Preview(name = "Light", showBackground = true)
@Preview(
    name = "Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun StudentCardPreview() {
    Lab3Theme {
        StudentCard(
            student = Student(
                name = "Rawan Alattiah",
                program = "Computer Science",
                gpa = "4.5",
                email = "rawan@example.com",
                city = "Dammam"
            )
        )
    }
}