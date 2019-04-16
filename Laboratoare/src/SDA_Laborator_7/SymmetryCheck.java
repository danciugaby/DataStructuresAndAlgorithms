package SDA_Laborator_7;

public class SymmetryCheck {
    static int countH,countV;
    static int[][] matrix;
    static void Init(int[][] A)
    {
        //To Do: a validation test is recommended
        matrix = new int[A.length][A.length];
        for(int i=0;i<A.length;i++)
            for(int j=0;j<A.length;j++)
                matrix[i][j] = A[i][j];
        countH = 0;
        countV = 0;
    }
    //assuming matrix is quadratic with size power of 2
    static void ComputeHorizontalSymetry(int x, int y, int width)
    {
        if (width < 2)
            return;

        for (int i=x;i<width;i++)
            if (matrix[i][y]==matrix[i][width-1])
                countH++;
        ComputeHorizontalSymetry(0,0, width/2);
        ComputeHorizontalSymetry(0,y/2, width/2);
        ComputeHorizontalSymetry(x/2,0, width/2);
        ComputeHorizontalSymetry(x/2,y/2, width/2);

    }
    static void ComputeVerticalSymetry(int x, int y, int width)
    {
        if (width < 2)
            return;

        for (int i=y;i<width;i++)
            if (matrix[x][i]==matrix[width-1][i])
                countV++;
        ComputeVerticalSymetry(0,0, width/2);
        ComputeVerticalSymetry(0,y/2, width/2);
        ComputeVerticalSymetry(x/2,0, width/2);
        ComputeVerticalSymetry(x/2,y/2, width/2);

    }
}
