package PolyominoePuzzle;

/**
 *
 * @author Faraz
 */
public class TetraHeuristic {

    static Board board;
    static LPiece L;
    static Piece A, B, C;
    static DataBase DB;
    static int n;

    public static void main(String[] args) {

        board = new Board(8);
        DB = new DataBase();
        n = 8;
        A = new Piece(board, 3, 8, "A");
        B = new Piece(board, 5, 2, "B");
        L = new LPiece(board, 4, 6, "L");
        C = new Piece(board, 4, 5, "C");

        DB.addBoard(board);
        Expand(board);

        while (DB.min != 0) {

            Expand(DB.findMin());
            System.out.println(DB.min);
        }
        DB.findMin().Print();
    }

    public static void Expand(Board board) {

        switch (board.getS()) {

            case 0:

                for (int i = 0; i <= A.sLimit; i++) {

                    for (int j = 0; j < board.getN(); j++) {

                        for (int k = 0; k < board.getN(); k++) {

                            if (A.Plotable(j, k)) {

                                Board tempBoard = new Board(n);
                                board.copyTo(tempBoard);

                                Piece tempA = new Piece(tempBoard, 3, 8, "A");
                                while (tempA.state != A.state) {
                                    tempA.RotateRight();
                                }
                                tempA.Place(j, k);
                                tempBoard.IncS();

                                DB.addBoard(tempBoard);
                            }
                        }
                    }

                    A.RotateRight();
                }

                A.RotateRight();
                DB.removeBoard(board);

                break;
            case 1:

                for (int i = 0; i <= B.sLimit; i++) {

                    for (int j = 0; j < board.getN(); j++) {

                        for (int k = 0; k < board.getN(); k++) {

                            if (B.Plotable(j, k)) {

                                Board tempBoard = new Board(n);
                                board.copyTo(tempBoard);

                                Piece tempB = new Piece(tempBoard, 5, 2, "B");
                                while (tempB.state != B.state) {
                                    tempB.RotateRight();
                                }
                                tempB.Place(j, k);
                                tempBoard.IncS();

                                DB.addBoard(tempBoard);
                            }
                        }
                    }

                    B.RotateRight();
                }

                B.RotateRight();
                DB.removeBoard(board);

                break;
            case 2:

                for (int i = 0; i <= L.sLimit; i++) {

                    for (int j = 0; j < board.getN(); j++) {

                        for (int k = 0; k < board.getN(); k++) {

                            if (L.Plotable(j, k)) {

                                Board tempBoard = new Board(n);
                                board.copyTo(tempBoard);

                                LPiece tempL = new LPiece(tempBoard, 4, 6, "L");
                                while (tempL.state != L.state) {
                                    tempL.RotateRight();
                                }
                                tempL.Place(j, k);
                                tempBoard.IncS();

                                DB.addBoard(tempBoard);
                            }
                        }
                    }

                    L.RotateRight();
                }

                L.RotateRight();
                DB.removeBoard(board);

                break;
            case 3:

                for (int i = 0; i <= C.sLimit; i++) {

                    for (int j = 0; j < board.getN(); j++) {

                        for (int k = 0; k < board.getN(); k++) {

                            if (C.Plotable(j, k)) {

                                Board tempBoard = new Board(n);
                                board.copyTo(tempBoard);

                                Piece tempC = new Piece(tempBoard, 4, 5, "C");
                                while (tempC.state != C.state) {
                                    tempC.RotateRight();
                                }
                                tempC.Place(j, k);
                                tempBoard.IncS();

                                DB.addBoard(tempBoard);
                            }
                        }
                    }

                    C.RotateRight();
                }

                C.RotateRight();
                DB.removeBoard(board);

                break;
        }
    }
}
