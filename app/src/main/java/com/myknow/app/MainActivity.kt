package com.myknow.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.myknow.app.ui.MyKnowAppRoot
import com.myknow.app.ui.theme.MyKnowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyKnowTheme {
                MyKnowAppRoot()
            }
        }
    }
}
