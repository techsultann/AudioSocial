package com.example.audiosocial.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.example.audiosocial.ui.theme.onSecondaryLight
import com.example.audiosocial.ui.theme.secondaryLight

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    shape: Shape = ButtonDefaults.shape,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = secondaryLight,
        contentColor = onSecondaryLight
    ),
    content: @Composable() (RowScope.() -> Unit),

){
    Button(
        modifier = modifier,
        onClick = onClick,
        content = content,
        shape = shape,
        enabled = enabled,
        colors = colors
    )
}