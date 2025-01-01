package com.example.audiosocial.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.audiosocial.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordBottomSheet(
    showBottomSheet: MutableState<Boolean>
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    if (showBottomSheet.value){
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet.value = false },
            sheetState = sheetState,
            sheetMaxWidth = Dp.Unspecified,
            modifier = Modifier.fillMaxHeight(),
            shape = RectangleShape
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Cancel",
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth()
                )


                Image(
                    painter = painterResource(R.drawable.microphone),
                    contentDescription = "User image",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(35.dp)
                )

                Text(
                    text = "What's the gist?",
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Hit record.",
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .border(1.dp, MaterialTheme.colorScheme.secondary, CircleShape)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.mic),
                        contentDescription = "Microphone icon"
                    )
                }
            }
        }
    }
}