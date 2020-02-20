package Matrix;

public class MatrixSpiral {
    private int[][] array;
    private int[][] coords = new int[1][2];
    private int currentArrow = 0;
    private int countChangingArrows;
    private int[][] arrowsArr = new int[][]{
            {0,  1}, //right
            {1,  0}, // down
            {0, -1}, // left
            {-1, 0} //up
    };


    public MatrixSpiral(int size) {
        array = new int[size][size];
    }

    public static void main(String[] args) {
        MatrixSpiral matrix = new MatrixSpiral(5);
        matrix.fillArr(0, 0);
    }

    private void fillArr(int beginX, int beginY){
        if (isBeginningCordUnValid(beginX, beginY)){
            System.out.println("Не верные координаты: диапазон от 0 до " + (array.length - 1));
            return;
        }

        coords[0][0] = beginX;
        coords[0][1] = beginY;

        for (int i = 1; i <= array.length * array.length; i++) {
            if (isTriingAllArrows())
                break;
            int x = coords[0][0];
            int y = coords[0][1];
            array[x][y] = i;
            updateCoords();
        }

        print();
    }

    private void updateCoords(){
        int x = coords[0][0];
        int y = coords[0][1];

        int nextArrowX = arrowsArr[currentArrow][0];
        int nextArrowY = arrowsArr[currentArrow][1];

        int nextX = x + nextArrowX;
        int nextY = y + nextArrowY;

        if (isNextCoordsUnValid(nextX, nextY)){
            changeArrow();
            if (!isTriingAllArrows())
                updateCoords();
        } else {
            countChangingArrows = 0;
            coords[0][0] = nextX;
            coords[0][1] = nextY;
        }
    }

    private void changeArrow(){
        countChangingArrows++;

        if (++currentArrow == arrowsArr.length)
            currentArrow = 0;
    }

    private boolean isCordOutOfBoundary(int value){
        boolean result = false;

        if (value == array.length || value < 0){
            result = true;
        }
        return result;
    }

    private boolean isCellFull(int x, int y){
        return array[x][y] != 0;
    }

    private boolean isBeginningCordUnValid(int beginX, int beginY){
        boolean result = false;
        int maxValidSize = array.length - 1;

        if (beginX > maxValidSize || beginY > maxValidSize || beginX < 0 || beginY < 0){
            result = true;
        }
        return result;
    }

    private boolean isNextCoordsUnValid(int nextX, int nextY){
        boolean result = false;
        
        if (isCordOutOfBoundary(nextX) || isCordOutOfBoundary(nextY) || isCellFull(nextX, nextY)){
            result = true;
        }
        return result;
    }

    private boolean isTriingAllArrows(){
        boolean result = false;

        if (countChangingArrows == arrowsArr.length){
            result = true;
        }
        return result;
    }

    public void print(){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(String.format("%3d", array[i][j]));
            }
            System.out.println();
        }
    }
}
