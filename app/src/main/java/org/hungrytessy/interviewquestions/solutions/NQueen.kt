package org.hungrytessy.interviewquestions.solutions

/**
 * The n-queens puzzle is the problem of placing n queens on a (n×n) chessboard such that no two
 * queens can attack each other.
 * Given an integer n, find all distinct solutions to the n-queens puzzle. Each solution
 * contains distinct board configurations of the n-queens’ placement, where the solutions are
 * a permutation of [1,2,3..n] in increasing order, here the number in the ith place denotes
 * that the ith-column queen is placed in the row with that number. For eg below figure
 * represents a chessboard [3 1 4 2].
 *
 * Complete the function nQueen() which takes n as input parameter and returns a list
 * containing all the possible chessboard configurations in sorted order. Return an
 * empty list if no solution exists.
 *
 * Constraints:
 * 1 ≤ n ≤ 10
 */
object NQueen {
    private var result: MutableList<List<Int>> = ArrayList()

    // cols[i] = true if there is a queen previously placed at ith column
    private lateinit var cols: BooleanArray

    // leftDiagonal[i] = true if there is a queen previously placed at i = (row + col )th left diagonal
    private lateinit var leftDiagonal: BooleanArray

    // rightDiagonal[i] = true if there is a queen previously placed at i = (row - col + n - 1)th
    // rightDiagonal diagonal
    private lateinit var rightDiagonal: BooleanArray

    fun nQueen(n: Int): List<List<Int>> {
        cols = BooleanArray(n)
        leftDiagonal = BooleanArray(2 * n)
        rightDiagonal = BooleanArray(2 * n)
        result = ArrayList()
        val temp: MutableList<Int> = ArrayList()
        for (i in 0 until n) temp.add(0)
        solveNQUtil(result, n, 0, temp)
        return result
    }

    private fun solveNQUtil(
        result: MutableList<List<Int>>,
        n: Int,
        row: Int,
        comb: MutableList<Int>
    ) {
        if (row == n) {
            // if row==n it means we have successfully placed all n queens.
            // hence add current arrangement to our answer
            // comb represent current combination
            result.add(ArrayList(comb))
            return
        }
        for (col in 0 until n) {
            // if we have a queen previously placed in the current column
            // or in current left or right diagonal we continue
            if (cols[col] || leftDiagonal[row + col] || rightDiagonal[row - col + n]) continue
            // otherwise we place a queen at cell[row][col] and
            //make current column, left diagonal and right diagonal true
            rightDiagonal[row - col + n] = true
            leftDiagonal[row + col] = rightDiagonal[row - col + n]
            cols[col] = leftDiagonal[row + col]
            comb[col] = row + 1
            // then we goto next row
            solveNQUtil(result, n, row + 1, comb)
            // then we backtrack and remove our currently placed queen
            rightDiagonal[row - col + n] = false
            leftDiagonal[row + col] = rightDiagonal[row - col + n]
            cols[col] = leftDiagonal[row + col]
        }
    }
}
