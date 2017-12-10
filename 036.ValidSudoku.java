class Solution {
	public boolean isValidSudoku(char[][] board) {
		int n = board.length;
		boolean result = true;
		char[] line = new char[n];
		//行
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < n;j++) {
				line[j] = board[i][j];
			}
			Arrays.sort(line);
			for(int j = n-1;j > -1;j--) {
				if(line[j] == '.') break;
				if(line[j] == line[j-1]) return false;
			}
		}
		//列
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < n;j++) {
				line[j] = board[j][i];
			}
			Arrays.sort(line);
			for(int j = n-1;j > -1;j--) {
				if(line[j] == '.') break;
				if(line[j] == line[j-1]) return false;
			}
		}
        //子块
        int counter = 0;
        while(counter < 3) {
            for(int i = 0;i < 3;i++) {
                for(int j = counter * 3;j < counter * 3+3;j++) {
                    line[i+3*(j-3*counter)] = board[j][i];
                }
                
            }
            Arrays.sort(line);
            for(int j = n-1;j > -1;j--) {
				if(line[j] == '.') break;
				if(line[j] == line[j-1]) return false;
			}
            counter++;
        }
        counter = 0;
        while(counter < 3) {
            for(int i = 3;i < 6;i++) {
                for(int j = counter * 3;j < counter * 3+3;j++) {
                    line[i-3+3*(j-3*counter)] = board[j][i];
                }
                
            }
            Arrays.sort(line);
            for(int j = n-1;j > -1;j--) {
				if(line[j] == '.') break;
				if(line[j] == line[j-1]) return false;
			}
            counter++;
        }
        counter = 0;
        while(counter < 3) {
            for(int i = 6;i < 9;i++) {
                for(int j = counter * 3;j < counter * 3+3;j++) {
                    line[i-6+3*(j-3*counter)] = board[j][i];
                }
                
            }
            Arrays.sort(line);
            for(int j = n-1;j > -1;j--) {
				if(line[j] == '.') break;
				if(line[j] == line[j-1]) return false;
			}
            counter++;
        }
		return true;
	}
}

