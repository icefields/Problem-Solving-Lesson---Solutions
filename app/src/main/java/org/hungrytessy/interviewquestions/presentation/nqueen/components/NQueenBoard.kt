package org.hungrytessy.interviewquestions.presentation.nqueen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NQueenBoard(
    solution: List<Int>,
    modifier: Modifier = Modifier
) {
    val gridSize = solution.size
    Column(modifier = modifier) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            text = "$solution"
        )

        Divider(modifier = Modifier.height(4.dp))

        LazyColumn(modifier = modifier) {
            items(gridSize) { i ->
                val queenAt = solution[i] - 1
                LazyRow(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .background(Color.DarkGray)
                ) {
                    items(gridSize) {
                        ChessSquare(
                            isQueenHere = it == queenAt,
                            modifier = Modifier
                                .height(55.dp)
                                .aspectRatio(1.0f, true)
                                .border(2.dp, color = Color.Black)
                        )
                    }
                }
            }
        }

    }
}

@Composable
fun ChessSquare(
    isQueenHere: Boolean,
    modifier: Modifier = Modifier
) {
    val color = if (isQueenHere) { Color.Blue } else { Color.Yellow }
    val iconTransparency = if (isQueenHere) { 1.0f } else { 0.0f }

    Box(modifier = modifier.background(color)) {
        Icon(
            modifier = Modifier
               // .fillParentMaxSize()
                .align(Alignment.Center)
                .alpha(iconTransparency),
            imageVector =Icons.Filled.AccountCircle,
            contentDescription = "queen here"
        )
    }
}
