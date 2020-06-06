//面试题 08.12. 八皇后
//设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
//
//注意：本题相对原题做了扩展
//
//示例:
//
// 输入：4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/eight-queens-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solveNQueens12 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0){
            return null;
        }

        char[][] board = new char[n][n];
        for (int i = 0; i< board.length; i++){
            Arrays.fill(board[i], '.');
        }
        dfs(board, 0, res);
        return res;
    }

    public void dfs(char[][] board, int row, List<List<String>> res){
        if (row == board.length){
            List<String> tmp = new ArrayList<>();
            for (char[] chars : board){
                tmp.add(String.valueOf(chars));
            }
            res.add(tmp);
            return;
        }

        for (int i = 0; i< board.length; i++){
            if (judge(board, row, i) == false){
                continue;
            }

            board[row][i] = 'Q';
            dfs(board, row+1, res);
            board[row][i] = '.';
        }

    }

    public boolean judge(char[][] board, int row, int col){
        for (char[] chars : board){
            if (chars[col] == 'Q'){
                return false;
            }
        }

        for (int i = row-1, j = col-1; i>=0 && j >= 0; i--, j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }

        for (int i = row-1, j = col+1; i>=0 && j< board[0].length; i--, j++){
            if (board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
}
