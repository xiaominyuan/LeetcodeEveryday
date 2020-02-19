//79. 单词搜索
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//示例:
//
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true.
//给定 word = "SEE", 返回 true.
//给定 word = "ABCB", 返回 false.
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/word-search
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package ershua;

public class exist79 {

    int[] rowDirect = {1,-1,0,0};
    int[] colDirect = {0,0,1,-1};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0){
            return word.isEmpty();
        }

        int row = board.length;
        int col = board[0].length;
        boolean[][] record = new boolean[row][col];

        for (int i = 0; i< row; i++){
            for (int j = 0; j< col; j++){
                if (judge(board, word, 0, i, j, record)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean judge(char[][] board, String word, int index, int i, int j, boolean[][] record){
        if (index == word.length()-1 && board[i][j] == word.charAt(index)){
            return true;
        }

        if (board[i][j] != word.charAt(index)){
            return false;
        }

        record[i][j] = true;

        for (int count = 0; count<4; count++){
            int rowStep = i + rowDirect[count];
            int colStep = j + colDirect[count];
            if (rowStep >= 0 && rowStep < board.length && colStep >= 0 && colStep < board[0].length && !record[rowStep][colStep]){
                if (judge(board, word, index+1, rowStep, colStep, record)){
                    return true;
                }
            }
        }

        record[i][j] = false;
        return false;
    }
}
