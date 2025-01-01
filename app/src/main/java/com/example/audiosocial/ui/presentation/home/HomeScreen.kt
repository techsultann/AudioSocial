package com.example.audiosocial.ui.presentation.home

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.audiosocial.component.HomePageItem
import com.example.audiosocial.component.RecordBottomSheet

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(){
    val showBottomSheet = remember { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play icon"
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(10){
                HomePageItem()
            }
        }
    }
    if (showBottomSheet.value){
        RecordBottomSheet(
            showBottomSheet = showBottomSheet
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewHomeScreen(){
    HomeScreen()
}