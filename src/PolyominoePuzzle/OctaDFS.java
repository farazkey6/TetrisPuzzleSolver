package PolyominoePuzzle;

/**
 *
 * @author Faraz
 */
public class OctaDFS {

    static Board board;
    static Piece A;
    static QPiece Q;
    static T1Piece T1;
    static T2Piece T2;
    static UPiece U;
    static VPiece V;
    static ZPiece Z;
    static PPiece P;

    static int Limit = 10000;
    static int Variable = 0;

    public static void main(String[] args) {

        board = new Board(8);
        A = new Piece(board, 2, 4, "A");
        Q = new QPiece(board, 2, 5, "Q");
        T1 = new T1Piece(board, 3, 4, "T1");
        T2 = new T2Piece(board, 3, 4, "T2");
        U = new UPiece(board, 3, 4, "U");
        V = new VPiece(board, 3, 3, "V");
        Z = new ZPiece(board, 3, 4, "Z");
        P = new PPiece(board, 3, 4, "P");

        RandInput(P);

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
                    RandInput(A);
                    break;

                case 2:
                    RandInput(Q);
                    break;

                case 3:
                    RandInput(T1);
                    break;

                case 4:
                    RandInput(T2);
                    break;

                case 5:
                    RandInput(U);
                    break;

                case 6:
                    RandInput(V);
                    break;

                case 7:
                    RandInput(Z);
                    break;

            }
        } else if (Variable < Limit) {

            Backtrack();
        } else {

            switch (board.getS()) {

                case 1:
                    P.missPlace();
                    Variable = 0;
                    board.setState(0);
                    RandInput(P);
                    break;

                case 2:
                    A.missPlace();
                    P.missPlace();
                    Variable = 0;
                    board.setState(0);
                    RandInput(P);
                    break;

                case 3:
                    Q.missPlace();
                    A.missPlace();
                    P.missPlace();
                    Variable = 0;
                    board.setState(0);
                    RandInput(P);
                    break;

                case 4:
                    T1.missPlace();
                    Q.missPlace();
                    A.missPlace();
                    P.missPlace();
                    Variable = 0;
                    board.setState(0);
                    RandInput(P);
                    break;

                case 5:
                    T2.missPlace();
                    T1.missPlace();
                    Q.missPlace();
                    A.missPlace();
                    P.missPlace();
                    Variable = 0;
                    board.setState(0);
                    RandInput(P);
                    break;

                case 6:
                    U.missPlace();
                    T2.missPlace();
                    T1.missPlace();
                    Q.missPlace();
                    A.missPlace();
                    P.missPlace();
                    Variable = 0;
                    board.setState(0);
                    RandInput(P);
                    break;

                case 7:
                    V.missPlace();
                    U.missPlace();
                    T2.missPlace();
                    T1.missPlace();
                    Q.missPlace();
                    A.missPlace();
                    P.missPlace();
                    Variable = 0;
                    board.setState(0);
                    RandInput(P);
                    break;

            }
        }
    }

    public static void Backtrack() {
        
        switch (board.getS()) {

            case 0:

                System.out.println("Error: Limit reached");
                RandInput(P);
                break;
            case 1:

                if (P.getState() != 1) {
                    P.missPlace();
                    P.RotateRight();
//                    board.DecS();
                    RandInput(P);
                } else {
//
                    P.missPlace();
                    board.DecS();
                    Backtrack();
                }
                break;
            case 2:
                if (A.getState() != 2) {

                    A.missPlace();
                    A.RotateRight();
                    board.DecS();
                    RandInput(A);
                } else {

                    A.missPlace();
                    board.DecS();
                    Backtrack();
                }
                break;

            case 3:
                if (Q.getState() != 3) {

                    Q.missPlace();
                    Q.RotateRight();
                    board.DecS();
                    RandInput(Q);
                    //restart

                } else {

                    Q.missPlace();
                    board.DecS();
                    Backtrack();
                }
                break;
             case 4:
                if (T1.getState() != 4) {

                    T1.missPlace();
                    T1.RotateRight();
                    board.DecS();
                    RandInput(T1);
                    //restart

                } else {

                    T1.missPlace();
                    board.DecS();
                    Backtrack();
                }
                break;
              case 5:
                if (T2.getState() != 5) {

                    T2.missPlace();
                    T2.RotateRight();
                    board.DecS();
                    RandInput(T2);
                    //restart

                } else {

                    T2.missPlace();
                    board.DecS();
                    Backtrack();
                }
                break;
            case 6:
                if (U.getState() != 6) {

                    U.missPlace();
                    U.RotateRight();
                    board.DecS();
                    RandInput(U);
                    //restart

                } else {

                    U.missPlace();
                    board.DecS();
                    Backtrack();
                }
                break;
            case 7:
                if (V.getState() != 7) {

                    V.missPlace();
                    V.RotateRight();
                    board.DecS();
                    RandInput(V);
                    //restart

                } else {

                    V.missPlace();
                    board.DecS();
                    Backtrack();
                }
                break;
        }
    }
    }

