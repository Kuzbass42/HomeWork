package javaSE01.t05;

public class Matrix {
    private int colNum;
    private int rowNum;

    int[][]     matrix;

    public Matrix(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;

        matrix      = new int[rowNum][colNum];
    }

    public void makeMatrix() {
        int firstRowPosition;
        int lastRowPosition;

        for (int i = 0; i < rowNum / 2; i++) {

            firstRowPosition = calcFirstRowPosition(i);
            lastRowPosition  = calcLastRowPosition(colNum - i - 1);

            matrix[i][firstRowPosition]                 = 1;
            matrix[i][lastRowPosition]                  = 1;

            matrix[rowNum - i - 1][firstRowPosition]    = 1;
            matrix[rowNum - i - 1][lastRowPosition]     = 1;
        }

        if (rowNum % 2 != 0){
            matrix[rowNum / 2][calcFirstRowPosition(rowNum / 2)]                = 1;

            matrix[rowNum / 2][calcLastRowPosition(colNum - rowNum / 2 - 1)]    = 1;
        }

    }

    private int calcFirstRowPosition(int firstRowPosition){

        while (firstRowPosition >= colNum){
            firstRowPosition -= colNum;
        }

        return firstRowPosition;
    }

    private int calcLastRowPosition(int lastRowPosition){
        while (lastRowPosition < 0){
            lastRowPosition += colNum;
        }
        return lastRowPosition;
    }

    @Override
    public String toString() {
        String ret = "";

        for (int i = 0; i < rowNum; i++)
        {
            for (int j = 0; j < colNum; j++)
            {
                ret += matrix[i][j];
            }

            ret += "\n";
        }

        return ret;
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix(8, 4);

        matrix.makeMatrix();

        System.out.println(matrix.toString());
    }
}
