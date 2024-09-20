package com.example.pokedex.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomProgressBar(width: Int, backgroundColor: Color, foregroundColor: Color, values: Int, modifier: Modifier) {

    var dp by remember { mutableIntStateOf(0) }

    dp = values * width / 300

    Box(
        modifier = modifier
            .background(backgroundColor)
            .width(width.dp)
    ) {
        Box(
            modifier = modifier
                .background(foregroundColor)
                .width(dp.dp)
        ){
            Text(
                text = "$values",
                modifier = Modifier.fillMaxWidth().padding(end = 4.dp),
                textAlign = TextAlign.End,
                fontSize = 12.sp,
                color = Color.White
            )
        }
    }
}