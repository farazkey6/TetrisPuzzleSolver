package PolyominoePuzzle;

/**
 *
 * @author Faraz
 */
public class OctaHeuristic {

    static Board board;
    static Piece A;
    static QPiece Q;
    static T1Piece T1;
    static T2Piece T2;
    static UPiece U;
    static VPiece V;
    static ZPiece Z;
    static PPiece P;
    static DataBase DB;
    static int n;

    public static void main(String[] args) {

        board = new Board(8);
        DB = new DataBase();
        n = 8;

        A = new Piece(board, 2, 4, "A");
        Q = new QPiece(board, 2, 5, "Q");
        T1 = new T1Piece(board, 3, 4, "T");
        T2 = new T2Piece(board, 3, 4, "t");
        U = new UPiece(board, 3, 4, "U");
        V = new VPiece(board, 3, 3, "V");
        Z = new ZPiece(board, 3, 4, "Z");
        P = new PPiece(board, 3, 4, "P");

        DB.addBoard(board);
//        Expand(board);
//        System.out.println(P.Plotable(0, 6));
//        P.Place(0, 4);
//        T2.RotateRight();
//        T2.RotateRight();
//        T2.RotateRight();
//        P.Place(0, 0);
//        for (int i = -50; i < 50; i++) {
//
//            for (int j = -50; j < 50; j++) {
//
//                if (T2.Plotable(i, j)) {
//
//                    T2.Place(i, j);
//                }
//            }
//        }
//        board.Print();
        while (DB.min != 0) {

            Expand(DB.findMin());
            System.out.println(DB.min);
            DB.findMin().Print();

        }
//        DB.findMin().Print();

    }

    public static void Expand(Board board) {

        switch (board.getS()) {

            case 0:
                System.out.println("P");
                for (int i = 0; i <= P.sLimit; i++) {

                    for (int j = 0; j < board.getN(); j++) {

                        for (int k = 0; k < board.getN(); k++) {

                            if (P.Plotable(j, k)) {
//                                System.out.println(j+" "+k);
                                Board tempBoard = new Board(n);
                                board.copyTo(tempBoard);

                                PPiece tempP = new PPiece(tempBoard, 3, 4, "P");
                                while (tempP.state != P.state) {
                                    tempP.RotateRight();
                                }
                                //
//                                System.out.println(j + " " + k);
                                tempP.Place(j, k);
                                tempBoard.IncS();

                                DB.addBoard(tempBoard);
                            }
                        }
                    }

                    P.RotateRight();
                }

                P.RotateRight();
                DB.removeBoard(board);

                break;

            case 1:
                System.out.println("A");
                for (int i = 0; i <= A.sLimit; i++) {

                    for (int j = 0; j < board.getN(); j++) {

                        for (int k = 0; k < board.getN(); k++) {

                            if (A.Plotable(j, k)) {

                                Board tempBoard = new Board(n);
                                board.copyTo(tempBoard);

                                Piece tempA = new Piece(tempBoard, 2, 4, "A");
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

            case 2:
                System.out.println("Q");
                for (int i = 0; i <= Q.sLimit; i++) {

                    for (int j = 0; j < board.getN(); j++) {

                        for (int k = 0; k < board.getN(); k++) {

                            if (Q.Plotable(j, k)) {

                                Board tempBoard = new Board(n);
                                board.copyTo(tempBoard);

                                QPiece tempQ = new QPiece(tempBoard, 2, 5, "Q");
                                while (tempQ.state != Q.state) {
                                    tempQ.RotateRight();
                                }
                                tempQ.Place(j, k);
                                tempBoard.IncS();

                                DB.addBoard(tempBoard);
                            }
                        }
                    }

                    Q.RotateRight();
                }

                Q.RotateRight();
                DB.removeBoard(board);

                break;

            case 3:
                System.out.println("T1");
                for (int i = 0; i <= T1.sLimit; i++) {

                    for (int j = 0; j < board.getN(); j++) {

                        for (int k = 0; k < board.getN(); k++) {

                            if (T1.Plotable(j, k)) {
//                                System.out.println("T1 plot");
                                Board tempBoard = new Board(n);
                                board.copyTo(tempBoard);

                                T1Piece tempT1 = new T1Piece(tempBoard, 3, 4, "T");
                                while (tempT1.state != T1.state) {
                                    tempT1.RotateRight();
//                                    System.out.println(tempT1.state);
                                }
                                tempT1.Place(j, k);
                                tempBoard.IncS();

                                DB.addBoard(tempBoard);
                            }
                        }
                    }

                    T1.RotateRight();
                }

                T1.RotateRight();
                DB.removeBoard(board);

                break;

            case 4:
                System.out.println("T2");
                for (int i = 0; i <= T2.sLimit; i++) {

                    for (int j = 0; j < board.getN(); j++) {

                        for (int k = 0; k < board.getN(); k++) {

                            if (T2.Plotable(j, k)) {

                                Board tempBoard = new Board(n);
                                board.copyTo(tempBoard);

                                T2Piece tempT2 = new T2Piece(tempBoard, 3, 4, "t");
                                while (tempT2.state != T2.state) {
                                    tempT2.RotateRight();
                                }
                                tempT2.Place(j, k);
                                tempBoard.IncS();

                                DB.addBoard(tempBoard);
                            }
                        }
                    }

                    T2.RotateRight();
                }

                T2.RotateRight();
                DB.removeBoard(board);

                break;

            case 5:
                System.out.println("U");
                for (int i = 0; i <= U.sLimit; i++) {

                    for (int j = 0; j < board.getN(); j++) {

                        for (int k = 0; k < board.getN(); k++) {

                            if (U.Plotable(j, k)) {

                                Board tempBoard = new Board(n);
                                board.copyTo(tempBoard);

                                UPiece tempU = new UPiece(tempBoard, 3, 4, "U");
                                while (tempU.state != U.state) {
                                    tempU.RotateRight();
                                }
                                tempU.Place(j, k);
                                tempBoard.IncS();

                                DB.addBoard(tempBoard);
                            }
                        }
                    }

                    U.RotateRight();
                }

                U.RotateRight();
                DB.removeBoard(board);

                break;

            case 6:
                System.out.println("V");
                for (int i = 0; i <= V.sLimit; i++) {

                    for (int j = 0; j < board.getN(); j++) {

                        for (int k = 0; k < board.getN(); k++) {

                            if (V.Plotable(j, k)) {

                                Board tempBoard = new Board(n);
                                board.copyTo(tempBoard);

                                VPiece tempV = new VPiece(tempBoard, 3, 3, "V");
                                while (tempV.state != V.state) {
                                    tempV.RotateRight();
                                }
                                tempV.Place(j, k);
                                tempBoard.IncS();

                                DB.addBoard(tempBoard);
                            }
                        }
                    }

                    V.RotateRight();
                }

                V.RotateRight();
                DB.removeBoard(board);

                break;

            case 7:
                System.out.println("Z");
                for (int i = 0; i <= Z.sLimit; i++) {

                    for (int j = 0; j < board.getN(); j++) {

                        for (int k = 0; k < board.getN(); k++) {

                            if (Z.Plotable(j, k)) {

                                Board tempBoard = new Board(n);
                                board.copyTo(tempBoard);

                                ZPiece tempZ = new ZPiece(tempBoard, 3, 4, "Z");
                                while (tempZ.state != Z.state) {
                                    tempZ.RotateRight();
                                }
                                tempZ.Place(j, k);
                                tempBoard.IncS();

                                DB.addBoard(tempBoard);
                            }
                        }
                    }

                    Z.RotateRight();
                }

                Z.RotateRight();
                DB.removeBoard(board);

                break;
                
            case 8:
                
                System.out.println("Error");
                break;
        }
    }
}
