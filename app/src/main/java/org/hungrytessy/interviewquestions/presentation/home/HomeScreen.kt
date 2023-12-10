package org.hungrytessy.interviewquestions.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.hungrytessy.interviewquestions.presentation.nqueen.components.NQueenBoard
import org.hungrytessy.interviewquestions.solutions.NQueen
import org.hungrytessy.interviewquestions.solutions.Sudoku
import org.hungrytessy.interviewquestions.solutions.getMatching
import org.hungrytessy.interviewquestions.solutions.isAnagram

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val s1 = "lucitappferu"
    val s2 = "ifluucperpat"
    var list1 = listOf<Int>(1,4,2,7,5,6,3,1,1,5,6,7,4,4,4,3,5,1,44,54,12,0,3,0)
    val n = 5
    Column(
        modifier = modifier
    ) {
        Text(text = "getMatching ${getMatching(list1)}")
        Divider(modifier = Modifier.height(4.dp))
        Text(text = "isAnagram ${isAnagram(s1, s2 )}")
        Divider(modifier = Modifier.height(4.dp))
        Text(text = "nQueen problem size: $n  solution: ${NQueen.nQueen(n)}")
        Divider(modifier = Modifier.height(4.dp))
        Text(text = "Validate sudoku board: ${Sudoku().validateBoard()}")
        Divider(modifier = Modifier.height(4.dp))
    }
}
