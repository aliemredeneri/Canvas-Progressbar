package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.example.myapplication.ui.CustomComponent
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
              Column(modifier = Modifier.fillMaxSize(),
              horizontalAlignment = Alignment.CenterHorizontally) {
                  var value by remember { mutableStateOf(0) }

                  CustomComponent(indicatorValue = value)
                  TextField(value = value.toString(), onValueChange = {
                      value = if (it.isNotEmpty()) { it.toInt() } else { 0 }
                  },
                      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
              }

            }
        }
    }
}

