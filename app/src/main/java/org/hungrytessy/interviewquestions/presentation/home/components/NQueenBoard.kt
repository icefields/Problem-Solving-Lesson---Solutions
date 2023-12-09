package org.hungrytessy.interviewquestions.presentation.home.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.hungrytessy.interviewquestions.solutions.NQueen

@Composable
fun NQueenBoard(
    gridSize: Int,
    modifier: Modifier = Modifier
) {
    val solution = NQueen.nQueen(gridSize)
    Column(modifier = modifier) {
        LazyColumn {
            items(solution.size) {
                Text(text = "${solution[it]}")
            }
        }
        Divider(modifier = Modifier.height(4.dp))
        LazyColumn(modifier = modifier) {
            val firstSolution = solution[0]
            items(gridSize) { i ->
                val queenAt = firstSolution[i] - 1
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green)
                ) {
                    items(gridSize) {
                        Box(modifier = Modifier
                            .height(55.dp)
                            .aspectRatio(1.0f, true)
                            .border(4.dp, color = Color.Black)
                            .background(
                                if (it == queenAt) {
                                    Color.Blue
                                } else {
                                    Color.Yellow
                                }
                            ))
                    }
                }
            }
        }
    }
}
