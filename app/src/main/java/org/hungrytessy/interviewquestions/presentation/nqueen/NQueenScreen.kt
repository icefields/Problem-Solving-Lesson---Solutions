package org.hungrytessy.interviewquestions.presentation.nqueen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.hungrytessy.interviewquestions.presentation.nqueen.components.NQueenBoard
import org.hungrytessy.interviewquestions.solutions.NQueen

@Composable
fun NQueenScreen(
    gridSize: Int,
    modifier: Modifier = Modifier
) {
    val solutions = NQueen.nQueen(gridSize)

    LazyColumn(modifier = modifier) {
        items(solutions.size) { i ->
            NQueenBoard(
                solution = solutions[i],
                modifier = Modifier
                    .aspectRatio(1.0f)
                    .background(Color.LightGray)
            )
        }
    }
}
