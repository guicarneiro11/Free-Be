package com.guicarneirodev.freebe.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.guicarneirodev.freebe.android.presentation.navigation.FreeBeeNavGraph
import com.guicarneirodev.freebe.android.presentation.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FreeBeeNavGraph()
                }
            }
        }
    }
}