package com.example.pokedex.ui.composables

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import coil.compose.AsyncImage
import com.example.pokedex.R
import com.example.pokedex.model.Pokemon
import com.example.pokedex.viewmodel.PaletteGenerator

@Composable
fun DetailPokemon(type: Pokemon){
    val context = LocalContext.current

    val config = LocalConfiguration.current
    val height = config.screenHeightDp
    val width = config.screenWidthDp

    Column {
        Surface(
            modifier = Modifier
                .height(height = (height / 3).dp)
                .fillMaxWidth(),
            color = Color(ContextCompat.getColor(context, PaletteGenerator.returnColor(type.apiTypes[0].name))),
            shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
        ) {
            AsyncImage(
                model = type.image,
                contentDescription = type.name,
                placeholder = painterResource(id = R.drawable.pokeball)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = type.name,
            style = MaterialTheme.typography.displaySmall,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height((height / 10).dp)
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            type.apiTypes.forEach { 
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Surface(
                        color = Color.White,
                        modifier = Modifier
                            .height(25.dp)
                            .width(100.dp),
                        shape = RoundedCornerShape(20.dp),

                    ) {
                        Text(text = it.name, textAlign = TextAlign.Center)
                    }
                    AsyncImage(model = it.image, contentDescription = null, modifier = Modifier
                        .height(500.dp)
                        .width(50.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Stats",
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        stats(width = width, value = type.stats.HP, text = "HP", context, color = R.color.feu)
        Spacer(modifier = Modifier.height(8.dp))
        stats(width = width, value = type.stats.attack, text = "ATK", context, color = R.color.electrik)
        Spacer(modifier = Modifier.height(8.dp))
        stats(width = width, value = type.stats.defense, text = "DEF", context, color = R.color.eau)
        Spacer(modifier = Modifier.height(8.dp))
        stats(width = width, value = type.stats.speed, text = "SPD", context, color = R.color.acier)
    }
}

@Composable
fun stats(width: Int, value: Int, text: String, context: Context, color: Int){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly) {
        Surface(modifier = Modifier.width((width / 10).dp)) {
            Text(text = text, color = Color.White)
        }
        CustomProgressBar(
            width = (width * 2 / 3),
            backgroundColor = Color.White,
            foregroundColor = Color(ContextCompat.getColor(context, color)),
            values = value,
            modifier = Modifier
                .height(15.dp)
                .clip(RoundedCornerShape(percent = 50)))
    }
}