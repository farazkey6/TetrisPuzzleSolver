package PolyominoePuzzle;

/**
 *
 * @author Faraz
 */
public class TetraDFS {

    static Board board;
    static LPiece L;
    static Piece A, B, C;
    static int Limit = 10000;
    static int Variable = 0;

    public static void main(String[] args) {

        board = new Board(8);
        A = new Piece(board, 3, 8, "A");
        B = new Piece(board, 5, 2, "B");
        L = new LPiece(board, 5, 6, "L");
        C = new Piece(board, 4, 5, "C");

        RandInput(A);
//        System.out.println(L.Plotable(7,7));
        board.Print();

    }

    public static void RandInput(Piece piece) {

        for (int i = 0; i < 1000; i++) {

            int x = (int) (Math.random() * 8);
            int y = (int) (Math.random() * 8);
            Variable += 1;

            if (piece.Plotable(x, y) && !piece.placed) {

                piece.Place(x, y);
                board.IncS();
                break;
            } else if (i == 250 || i == 500 || i == 750) {

                piece.RotateRight();
            }
        }

        if (piece.placed) {

            switch (board.getS()) {

                case 1:
                    RandInput(B);
                    break;
                case 2:
                    RandInput(L);
                    break;
                case 3:
                    RandInput(C);
                    break;
            }
        } else if (Variable < Limit) {

            Backtrack();
        } else {

            switch (board.getS()) {

                case 1:
                    A.missPlace();
                    Variable = 0;
                    board.setState(0);
                    RandInput(A);
                    break;
                case 2:
                    A.missPlace();
                    B.missPlace();
                    Variable = 0;
                    board.setState(0);
                    RandInput(A);
                    break;
                case 3:
                    A.missPlace();
                    B.missPlace();
                    L.missPlace();
                    Variable = 0;
                    board.setState(0);
                    RandInput(A);
                    break;
            }
        }
    }

    private static void Backtrack() {

        switch (board.getS()) {

            case 0:

                System.out.println("Error: Limit reached");
                RandInput(A);
                break;
            case 1:

                if (A.getState() != 1) {
                    A.missPlace();
                    A.RotateRight();
//                    board.DecS();
                    RandInput(A);
                } else {
//
                    A.missPlace();
                    board.DecS();
                    Backtrack();
                }
                break;
            case 2:
                if (B.getState() != 1) {

                    B.missPlace();
                    B.RotateRight();
                    board.DecS();
                    RandInput(B);
                } else {

                    B.missPlace();
                    board.DecS();
                    Backtrack();
                }
                break;

            case 3:
                if (L.getState() != 3) {

                    L.missPlace();
                    L.RotateRight();
                    board.DecS();
                    RandInput(L);
                    //restart

                } else {

                    L.missPlace();
                    board.DecS();
                    Backtrack();
                }
                break;
        }
    }
}
