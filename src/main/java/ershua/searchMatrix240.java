package ershua;

public class searchMatrix240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int x = 0;
        int y = row-1;

        while (y>= 0 && x<col){
            if (matrix[y][x] < target){
                x++;
            }else if (matrix[y][x] > target){
                y--;
            }else{
                return true;
            }
        }

        return false;
    }
}
