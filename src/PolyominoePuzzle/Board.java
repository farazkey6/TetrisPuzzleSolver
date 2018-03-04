package PolyominoePuzzle;

/**
 *
 * @author Faraz
 */
public class Board {

    String board[][];
    int state;
    int n;

    public Board(int n) {

        state = 0;
        this.n = n;

        board = new String[n][n];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                board[i][j] = "$";
            }
        }
    }

    public void fill(String name ,int x, int y) {

        board[x][y] = name;
    }

    public void empty(int x, int y) {

        board[x][y] = "$";
    }

    public boolean isAvailable(int x, int y) {

        if (x >= n || y >= n
                || x < 0 || y < 0) {
            return false;
        }
        if (!"$".equals(board[x][y])) {

            return false;

        }
        return true;
    }

    public void IncS() {

        state++;
    }

    public void DecS() {

        state--;
    }

    public int getS() {

        return state;
    }

    public int getN() {

        return n;
    }

    public void setState(int s) {

        state = s;
    }

    public void copyTo(Board ClipBoard) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                ClipBoard.board[i][j] = board[i][j];
            }
        }
        ClipBoard.setState(state);
    }

    public boolean isHole(int x, int y) {

        if (!isAvailable(x, y)) {

            return false;
        } else if (x == 0 && y == 0
                && !isAvailable(x + 1, y)
                && !isAvailable(x, y + 1)) {

            return true;
        } else if (x == n - 1 && y == 0
                && !isAvailable(x - 1, y)
                && !isAvailable(x, y + 1)) {

            return true;
        } else if (x == 0 && y == n - 1
                && !isAvailable(x, y - 1)
                && !isAvailable(x + 1, y)) {

            return true;
        } else if (x == n - 1 && y == n - 1
                && !isAvailable(x - 1, y)
                && !isAvailable(x, y - 1)) {

            return true;
        } else if (x == 0
                && !isAvailable(x, y - 1)
                && !isAvailable(x, y + 1)
                && !isAvailable(x + 1, y)) {

            return true;
        } else if (x == n - 1
                && !isAvailable(x, y - 1)
                && !isAvailable(x, y + 1)
                && !isAvailable(x - 1, y)) {

            return true;
        } else if (y == 0
                && !isAvailable(x + 1, y)
                && !isAvailable(x - 1, y)
                && !isAvailable(x, y + 1)) {

            return true;
        } else if (y == n - 1
                && !isAvailable(x + 1, y)
                && !isAvailable(x - 1, y + 1)
                && !isAvailable(x, y - 1)) {

            return true;
        } else if (!isAvailable(x + 1, y)
                && !isAvailable(x - 1, y)
                && !isAvailable(x, y + 1)
                && !isAvailable(x, y - 1)) {

            return true;
        }

        return false;
    }

    public int Rate(int x, int y) {

        if (!isAvailable(x, y)) {

            return 0;
        } else if (isHole(x, y)) {

            return 1000;
        } else if (!isAvailable(x + 1, y)
                && !isAvailable(x - 1, y)
                && !isAvailable(x, y + 1)) {

            return 4;
        } else if (!isAvailable(x + 1, y)
                && !isAvailable(x - 1, y)
                && !isAvailable(x, y - 1)) {

            return 4;
        } else if (!isAvailable(x + 1, y)
                && !isAvailable(x, y - 1)
                && !isAvailable(x, y + 1)) {

            return 4;
        } else if (!isAvailable(x, y - 1)
                && !isAvailable(x - 1, y)
                && !isAvailable(x, y + 1)) {

            return 4;
        } else if (!isAvailable(x, y - 1)
                && !isAvailable(x, y + 1)) {

            return 3;
        } else if (!isAvailable(x + 1, y)
                && !isAvailable(x - 1, y)) {

            return 3;
        } else if (!isAvailable(x - 1, y)
                && !isAvailable(x, y - 1)) {

            return 3;
        } else if (!isAvailable(x, y - 1)
                && !isAvailable(x + 1, y)) {

            return 3;
        } else if (!isAvailable(x + 1, y)
                && !isAvailable(x, y + 1)) {

            return 3;
        } else if (!isAvailable(x, y + 1)
                && !isAvailable(x - 1, y)) {

            return 3;
        } else if (!isAvailable(x, y + 1)) {

            return 2;
        } else if (!isAvailable(x, y - 1)) {

            return 2;
        } else if (!isAvailable(x + 1, y)) {

            return 2;
        } else if (!isAvailable(x - 1, y)) {

            return 2;
        }

        return 1;
    }

    public int BoardRate() {

        int temp = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                temp += Rate(i, j);
            }
        }

        return temp;
    }
    
    public void Print(){
        
        for (int i = 0; i < n; i++){
            
            for (int j = 0; j < n; j++){
                
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
