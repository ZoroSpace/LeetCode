class Solution {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        
        int row = grid.length;
        int col = grid[0].length;
        

        for(int i = 0;i<row;i++) {
        sum += grid[i][0];
        sum += grid[i][col - 1];
        }

        for(int i = 0;i<col;i++) {
        sum += grid[0][i];
        sum += grid[row - 1][i];
        }

        for(int i = 1;i<row;i++) {
            for(int j = 0;j<col;j++) {
                if(grid[i][j] != grid[i-1][j]) sum++;
            }
        }
        
        for(int i = 1;i<col;i++) {
            for(int j = 0;j<row;j++) {
                if(grid[j][i] != grid[j][i-1]) sum++;
            }
        }

        return sum;
    }
}
