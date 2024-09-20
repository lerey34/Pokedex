package com.example.pokedex.viewmodel

import com.example.pokedex.R

object PaletteGenerator {
    fun returnColor(type: String): Int{
        return when(type){
            "Combat" -> R.color.combat
            "Vol" -> R.color.vol
            "Poison" -> R.color.poison
            "Sol" -> R.color.sol
            "Roche" -> R.color.roche
            "Insect" -> R.color.insect
            "Spectre" -> R.color.spectre
            "Acier" -> R.color.acier
            "Feu" -> R.color.feu
            "Eau" -> R.color.eau
            "Plante" -> R.color.plante
            "Électrik" -> R.color.electrik
            "Psy" -> R.color.psy
            "Glace" -> R.color.glace
            "Dragon" -> R.color.dragon
            "Ténèbres" -> R.color.tenebre
            "Fée" -> R.color.fee
            else -> R.color.normal
        }
    }
}