package PolyominoePuzzle;

import java.util.ArrayList;

/**
 *
 * @author Faraz
 */
public class DataBase {

    static int min;
    Board board;
    ArrayList<Board> alpha;
    ArrayList<Board> bravo;
    ArrayList<Board> charlie;

    public DataBase() {

        min = 10000;
        alpha = new ArrayList<Board>();
        bravo = new ArrayList<Board>();
        charlie = new ArrayList<Board>();
    }

    public void addBoard(Board board) {
//        System.out.println(board.BoardRate());
        if (board.BoardRate() < 5) {

            alpha.add(board);
//            if (board.BoardRate() < min) {
//
//                min = board.BoardRate();
//            }
        } else if (board.BoardRate() < 50) {

            bravo.add(board);
//            if (board.BoardRate() < min) {
//
//                min = board.BoardRate();
//            }
        } else if (board.BoardRate() < 500) {

            charlie.add(board);
//            if (board.BoardRate() < min) {
//
//                min = board.BoardRate();
//            }
        }
//        System.out.println("Board added");
    }

    public void removeBoard(Board board) {

        if (board.BoardRate() < 5) {
            for (int i = 0; i < alpha.size(); i++) {

                if (alpha.get(i).BoardRate() == board.BoardRate()) {
                    alpha.remove(board);
                }
            }
        } else if (board.BoardRate() < 50) {

            for (int i = 0; i < bravo.size(); i++) {

                if (bravo.get(i).BoardRate() == board.BoardRate()) {
                    bravo.remove(board);
                }
            }
        } else if (board.BoardRate() < 500) {

            for (int i = 0; i < charlie.size(); i++) {

                if (charlie.get(i).BoardRate() == board.BoardRate()) {
                    charlie.remove(board);
                }
            }
        }
        
//        System.out.println("Board removed");
    }

    public Board findMin() {

        min = 1000;
        int pointer = 0;

        if (!alpha.isEmpty()) {

            for (int i = 0; i < alpha.size(); i++) {

                if (alpha.get(i).BoardRate() < min) {

                    min = alpha.get(i).BoardRate();
                    pointer = i;
                }
            }
            return alpha.get(pointer);

        } else if (!bravo.isEmpty()) {

            for (int i = 0; i < bravo.size(); i++) {

                if (bravo.get(i).BoardRate() < min) {

                    min = bravo.get(i).BoardRate();
                    pointer = i;
                }
            }
            return bravo.get(pointer);

        } else if (!charlie.isEmpty()) {

            for (int i = 0; i < charlie.size(); i++) {

                if (charlie.get(i).BoardRate() < min) {

                    min = charlie.get(i).BoardRate();
                    pointer = i;
                }
            }
        }
        return charlie.get(pointer);
    }
}
