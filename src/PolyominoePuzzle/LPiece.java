package PolyominoePuzzle;

/**
 *
 * @author Faraz
 */
public class LPiece extends Piece {

    int state;
    int sLimit;
    int tempX, tempY;
    String name;

    public LPiece(Board board, int axisX, int axisY, String name) {
        super(board, axisX, axisY, name);
        state = 0;
        axisX--;
        axisY--;
        tempX = -axisX;
        tempY = -axisY;
        sLimit = 3;
        this.name = name;

    }

    @Override
    public void RotateRight() {

        switch (state) {

            case 0:
                swap(axisX, axisY);
                tempX = 0;
                tempY = -axisY;
                state = 1;
//                System.out.println("L rotated to state: " + state);
                break;

            case 1:
                swap(axisX, axisY);
                tempX = 0;
                tempY = 0;
                state = 2;
//                System.out.println("L rotated to state: " + state);
                break;

            case 2:
                swap(axisX, axisY);
                tempX = -axisX;
                tempY = 0;
                state = 3;
//                System.out.println("L rotated to state: " + state);
                break;

            case 3:
                swap(axisX, axisY);
                tempX = -axisX;
                tempY = -axisY;
                state = 0;
//                System.out.println("L rotated to state: " + state);
                break;

        }
    }

    @Override
    public boolean Plotable(int x, int y) {

        if (x + tempX >= board.getN() || x + tempX < 0
                || y + tempY >= board.getN() || y + tempY < 0) {
//            System.out.println(x + " " + tempX + " " + y + " " + tempY);
//            System.out.println("L is not plottable");
            return false;
        }
        x += tempX;
        for (int i = 0; i < axisX; i++) {
            if (!board.isAvailable(x + i, y)) {

                return false;
            }
        }
        x -= tempX;
        y += tempY;
        for (int j = 0; j < axisY; j++) {
            if (!board.isAvailable(x, y + j)) {

                return false;
            }
        }
        y -= tempY;

        return true;
    }

    public void Place(int x, int y) {

        x += tempX;
        for (int i = 0; i < axisX; i++) {

            board.fill(name, x + i, y);
        }
        x -= tempX;
        y += tempY;
        for (int j = 0; j < axisY; j++) {

            board.fill(name, x, y + j);
        }
        y -= tempY;

        placed = true;
//        board.IncS();

//        System.out.println("L Placed At " + x + " " + y + " State of " + state);
    }

    public void missPlace(int x, int y) {

        x += tempX;
        for (int i = 0; i < axisX; i++) {

            board.empty(x + i, y);
        }
        x -= tempX;
        y += tempY;
        for (int j = 0; j < axisY; j++) {

            board.empty(x, y + j);
        }
        y -= tempY;

        placed = false;

//        board.DecS();
        System.out.println("missPlaced from " + x + " " + y);
    }

    public void swap(int x, int y) {

        int temp = x;
        x = y;
        y = temp;
    }

    public int getState() {

        return state;
    }
}
