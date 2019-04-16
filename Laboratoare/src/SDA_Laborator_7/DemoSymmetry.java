package SDA_Laborator_7;

public class DemoSymmetry {
    public static void main(String[] args) {

        int a[][] = new int[4][4];
        //a kind of circle
        a[0][1] = 1;
        a[0][2] = 1;
        a[1][0] = 1;
        a[2][0] = 1;
        a[3][1] = 1;
        a[3][2] = 1;
        a[2][3] = 1;
        a[1][3] = 1;


        SymmetryCheck.Init(a);

        SymmetryCheck.ComputeHorizontalSymetry(0,0 ,a.length);
        SymmetryCheck.ComputeVerticalSymetry(0,0 ,a.length);
        //we take the total count and we scale it to the size of the matrix
        System.out.println("Horizontal Symmetry: " + SymmetryCheck.countH/(double)(a.length*a.length));
        System.out.println("Vertical Symmetry: " + SymmetryCheck.countV/(double)(a.length*a.length));

    }
}
