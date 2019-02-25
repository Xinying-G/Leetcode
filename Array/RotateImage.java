// 48. Rotate Image
// 解决方法：matrix[i][j] = matrix[j][i]
// semmetry 沿着column
// 直觉：同解决方法 
// 要点，难点：1.不能一步到位，要研究出规律
// 归类：Array
// 难点: Array
// 复杂度： O(n)
// 数据结构：matrix，行是i，列是j，要记住
public class RotateImage {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = i; j < matrix[0].length; j++)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length/2; j++)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length -1 -j];
                matrix[i][matrix.length -1 -j] = tmp;
            }
        }
    }
}