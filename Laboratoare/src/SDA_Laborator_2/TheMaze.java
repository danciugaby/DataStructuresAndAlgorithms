package SDA_Laborator_2;

import java.util.Stack;

public class TheMaze {

    int[][] entry;
    int[][] visited;
    int finali;
    int finalj;
    boolean mazedsolved;
    Stack<SDA_Laborator_2.Point> mystack;

    public TheMaze(int[][] entry, int[][] visited, int finali, int finalj)
    {
        this.entry = entry;
        this.visited = visited;
        mystack = new Stack<SDA_Laborator_2.Point>();
        this.finali = finali;
        this.finalj = finalj;
        mazedsolved = false;
    }
    void Check(int i, int j) {
        if (i == finali && j == finalj) {
            System.out.println("The maze was solved!");
            mazedsolved = true;
            return;
        }
        if (Valid(i - 1, j)) {
            mystack.push(new Point(i - 1, j));
            visited[i-1][j]=1;
            Check(i - 1, j);
        }
        if (Valid(i, j + 1)) {
            mystack.push(new Point(i, j + 1));
            visited[i][j+1]=1;
            Check(i, j + 1);
        }
        if (Valid(i + 1, j)) {
            mystack.push(new Point(i + 1, j));
            visited[i+1][j]=1;
            Check(i + 1, j);
        }
        if (Valid(i, j - 1)) {
            mystack.push(new Point(i, j - 1));
            visited[i][j-1]=1;
            Check(i, j - 1);
        }
        if (!mazedsolved)
            mystack.pop();
    }
    boolean Valid(int i, int j)
    {
        if (i < 0)
            return false;
        if (j <0 )
            return false;
        if (i >= entry.length)
            return false;
        if (j >= entry[0].length)
            return false;

        if (entry[i][j] == 1 && visited[i][j]==0)
            return true;
        return false;
    }

}
