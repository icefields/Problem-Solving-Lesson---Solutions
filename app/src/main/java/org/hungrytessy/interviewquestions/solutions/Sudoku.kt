package org.hungrytessy.interviewquestions.solutions

import android.net.Network
import android.util.Log
import org.hungrytessy.interviewquestions.solutions.Sudoku.Companion.testInput1

/**
 * Given an incomplete Sudoku configuration in terms of a 9 x 9  2-D square matrix (grid[][]),
 * the task is to find a solved Sudoku. For simplicity, assume that there will be only
 * one unique solution.
 *
 * A sudoku solution must satisfy all of the following rules:
 *     Each of the digits 1-9 must occur exactly once in each row.
 *     Each of the digits 1-9 must occur exactly once in each column.
 *     Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 *
 * Zeros in the grid indicates blanks, which are to be filled with some number between 1-9.
 * You cannot replace the element in the cell which is not blank.
 *
 *
 * Example 1:
 *
 * Input:
 * grid[][] =
 * [[3 0 6 5 0 8 4 0 0],
 * [5 2 0 0 0 0 0 0 0],
 * [0 8 7 0 0 0 0 3 1 ],
 * [0 0 3 0 1 0 0 8 0],
 * [9 0 0 8 6 3 0 0 5],
 * [0 5 0 0 9 0 6 0 0],
 * [1 3 0 0 0 0 2 5 0],
 * [0 0 0 0 0 0 0 7 4],
 * [0 0 5 2 0 6 3 0 0]]
 *
 * Output:
 * True
 * 3 1 6 5 7 8 4 9 2
 * 5 2 9 1 3 4 7 6 8
 * 4 8 7 6 2 9 5 3 1
 * 2 6 3 4 1 5 9 8 7
 * 9 7 4 8 6 3 1 2 5
 * 8 5 1 7 9 2 6 4 3
 * 1 3 8 9 4 7 2 5 6
 * 6 9 2 3 5 1 8 7 4
 * 7 4 5 2 8 6 3 1 9
 *
 * Explanation:
 * There exists a valid Sudoku for the input grid, which is shown in output.
 *
 *
 * Example 2:
 *
 * Input:
 * grid[][] =
 * [[3 6 6 5 0 8 4 0 0],
 * [5 2 0 0 0 0 0 0 0],
 * [0 8 7 0 0 0 0 3 1 ],
 * [0 0 3 0 1 0 0 8 0],
 * [9 0 0 8 6 3 0 0 5],
 * [0 5 0 0 9 0 6 0 0],
 * [1 3 0 0 0 0 2 5 0],
 * [0 0 0 0 0 0 0 7 4],
 * [0 0 5 2 0 6 3 0 0]]
 *
 * Output:
 * False
 *
 * Explanation:
 * There does not exists a valid Sudoku for the input grid, since there are two 6s in the
 * first row.Which cannot replaced.
 *
 *
 * Main functions:
 *
 * SolveSudoku(): Takes a grid as its argument and returns true if a solution is possible and
 * false if it is not, on returning false driver will print "No solution exists".
 *
 * printGrid(): Takes a grid as its argument and prints the 81 numbers of the solved Sudoku in a
 * single line with space separation. Do not give a new line character after printing the grid.
 *
 * Expected Time Complexity: O(9N*N).
 * Expected Auxiliary Space: O(N*N).
 *
 * Constraints:
 * 0 ≤ grid[i][j] ≤ 9
 *
 */

typealias IsValidBoard = Boolean
typealias Count = Int
typealias Value = Int
class Sudoku {

companion object {
    val testInput1 = arrayOf(
        arrayOf(3, 0, 6, 5, 0, 8, 4, 0, 0),
        arrayOf(5, 2, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 8, 7, 0, 0, 0, 0, 3, 1),
        arrayOf(0, 0, 3, 0, 1, 0, 0, 8, 0),
        arrayOf(9, 0, 0, 8, 6, 3, 0, 0, 5),
        arrayOf(0, 5, 0, 0, 9, 0, 6, 0, 0),
        arrayOf(1, 3, 0, 0, 0, 0, 2, 5, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 5, 2, 0, 6, 3, 0, 0),
    )
}

    private val subSquares: List<HashSet<Int>> = arrayListOf(
        HashSet<Int>(),
        HashSet<Int>(),
        HashSet<Int>(),
        HashSet<Int>(),
        HashSet<Int>(),
        HashSet<Int>(),
        HashSet<Int>(),
        HashSet<Int>(),
        HashSet<Int>(),
    )

    /**
     * Takes a grid as its argument and returns true if a solution is possible and
     * false if it is not, on returning false driver will print "No solution exists".
     */
    fun validateBoard(input: Array<Array<Int>> = testInput1): Boolean =
        generateSubSquares(input)
            && validateColumns(input)
            && validateRows(input)


    private fun validateColumns(input: Array<Array<Int>>): Boolean {
        for(i in 0 ..< 9) {
            // verify if numbers repeat on the same column
            // create array with column index and test it
            val columnArr = HashSet<Int>()
            for(j in 0 ..< 9) {
                val value = input[j][i]
                if (value != 0) {
                    if (!columnArr.add(value)) {
                        // if set already contains element return false
                        return false
                    }
                }
            }
        }
        return true
    }

    private fun validateRows(input: Array<Array<Int>>): Boolean {
        // validate rows
        input.forEachIndexed { index, lineArr ->
            // verify if numbers repeat on the same row
            val noZerosList = lineArr.filter { key: Int -> key != 0 }
            val noZeroSet = HashSet(noZerosList)
            if (noZerosList.size != noZeroSet.size) {
                return false
            }
        }
        return true
    }

    private fun generateSubSquares(input: Array<Array<Int>>):IsValidBoard {
        var isValidBoard = true
        //validate sub-squares
        for(i in 0 ..< 9) {
            var setIndex = if(i/3 == 1) {
                3
            } else if(i/3 == 2) {
                6
            } else 0
            // verify if numbers repeat on the same column
            // create array with column index and test it
            for(j in 0 ..< 9) {
                val value = input[j][i]
                if ((j) % 3 == 0) {
                    setIndex += 1
                }
                if (value!=0 && !subSquares[setIndex-1].add(value)) {
                    // if set already contains element return false
                    isValidBoard = false
                }
            }
        }
        return isValidBoard
    }

    /**
     * Takes a grid as its argument and prints the 81 numbers of the solved Sudoku in a
     * single line with space separation. Do not give a new line character after printing the grid.
     *
     * * A sudoku solution must satisfy all of the following rules:
     * Each of the digits 1-9 must occur exactly once in each row.
     * Each of the digits 1-9 must occur exactly once in each column.
     * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
     */
    fun printSolution() {

    }
}
