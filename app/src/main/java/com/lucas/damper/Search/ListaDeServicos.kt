package com.lucas.damper.Search

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.lucas.damper.Home.CardService
import com.lucas.damper.Home.CardServiceList
import com.lucas.damper.Home.ServiceItem
import com.lucas.damper.R

@Composable
fun ListService(){
    val services = listOf(
        ServiceItem(
            title = "House Cleaning Service",
            description = "Includes dusting, vacuuming, etc.",
            location = "Brooklyn, NY",
            priceRange = "$100 - $200",
            imageResource = R.drawable.imageonbording1
        ),
        // Adicione mais ServiceItem aqui
    )

    Column(){


            Text(text = "Limpeza")



        CardServiceList(serviceItems = services)

    }
}