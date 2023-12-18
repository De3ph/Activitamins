package com.example.activitamins.presentation.components.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.activitamins.R
import java.text.DateFormat
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SimpleDateFormat")
@Composable
fun ActivityCard(
    index: Int?,
    title: String,
    date: Date,
    organizer: String,
    isFavourite: Boolean?,
    navController: NavController?,
    toggleFavourite: ((Int) -> Unit)?
) {

    var isFavouriteState by remember {
        mutableStateOf(isFavourite)
    }

    Card(
        onClick = {
            navController?.navigate("details/$index")
        },
        modifier = Modifier.fillMaxWidth(0.95f),
        shape = MaterialTheme.shapes.extraSmall,
    ) {
        Column(
            modifier = Modifier.padding(
                bottom = 20.dp
            ),
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painterResource(id = R.drawable.activity1),
                        contentDescription = "activity1"
                    )

                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)

                ) {
                    Text(
                        text = title,
                        fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Column {
                    IconButton(
                        onClick = {
                            if (isFavouriteState !== null && index !== null && toggleFavourite !== null) {
                                isFavouriteState = !isFavouriteState!!
                                toggleFavourite(index)
                            }
                        }) {
                        Icon(
                            Icons.Outlined.Star,
                            contentDescription = "fav",
                            tint = if (isFavouriteState !== null && isFavouriteState == true) Color.Yellow else Color.Black
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = DateFormat.getDateInstance().format(date),
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = MaterialTheme.typography.bodyMedium.fontWeight
                )

                Text(
                    modifier = Modifier.wrapContentWidth(),
                    text = organizer,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    softWrap = true,
                    maxLines = 1
                )

            }
        }
    }
}