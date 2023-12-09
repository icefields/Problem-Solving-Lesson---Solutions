package org.hungrytessy.interviewquestions.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.hungrytessy.interviewquestions.solutions.NQueen
import org.hungrytessy.interviewquestions.solutions.getMatching
import org.hungrytessy.interviewquestions.solutions.isAnagram

@Composable
@Destination(start = true)
fun HomeScreen(
    navigator: DestinationsNavigator,
    name: String = "android",
    modifier: Modifier = Modifier
) {
    val s1 = "lucitappferu"
    val s2 = "ifluucperpat"
    var list1 = listOf<Int>(1,4,2,7,5,6,3,1,1,5,6,7,4,4,4,3,5,1,44,54,12,0,3,0)
    val n = 5
    Column() {
        Text(
            text = "getMatching ${getMatching(list1)}",
            modifier = modifier
        )

        Text(
            text = "isAnagram ${isAnagram(s1, s2 )}",
            modifier = modifier
        )
        Text(
            text = "nQueen problem size: $n  solution: ${NQueen.nQueen(n)}",
            modifier = modifier
        )

    }

}
