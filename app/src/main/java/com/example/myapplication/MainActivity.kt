package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) { // Ми більше не передаємо 'name'
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            // Центруємо вміст колонки (зображення і текст)
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // 1. Рядок для прапора та герба
            Row(
                // Додає відступ 16.dp між елементами
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // ПРАПОР
                Image(
                    painter = painterResource(id = R.drawable.flag),
                    contentDescription = stringResource(id = R.string.flag_description),
                    modifier = Modifier.size(120.dp) // Розмір прапора
                )
                // ГЕРБ
                Image(
                    painter = painterResource(id = R.drawable.coat_of_arms),
                    contentDescription = stringResource(id = R.string.coat_of_arms_description),
                    modifier = Modifier.size(120.dp) // Розмір герба
                )
            }

            // 2. Відступ між зображеннями та текстом
            Spacer(modifier = Modifier.height(24.dp))

            // 3. Прізвище (з ресурсів)
            Text(
                // Завантажуємо текст з R.string.last_name
                text = stringResource(id = R.string.last_name),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting()
    }
}