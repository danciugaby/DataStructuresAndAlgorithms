package SDA_Laborator_2;

public class Stive {

    public static void main(String[] args)
    {
        //Entry a matrix with 1 and 0
        //You can only walk on 1s in direction up down left right
        //0s are walls
        //Starting form a given point: example coordinates (1 0)
        //The exit point is also given: example coordinates (4 5)
        //Find the road that will allow you to exit the maze
        
        //this is the maze
        int[][] mymaze = new int[5][6];
        //this is where I have been to
        int[][] myplaces = new int[5][6];        
        mymaze[0][2]=1;
        mymaze[0][4]=1;
        mymaze[1][0]=1;
        mymaze[1][1]=1;
        mymaze[1][2]=1;
        mymaze[1][4]=1;
        mymaze[2][0]=1;
        mymaze[2][2]=1;
        mymaze[2][3]=1;
        mymaze[2][4]=1;
        mymaze[3][0]=1;
        for(int i=0;i<=5;i++)
            mymaze[4][i]=1;
        TheMaze maze = new TheMaze(mymaze,myplaces,4,5);
        maze.Check(1,0);
        System.out.println("Result: ");
        System.out.println(maze.mystack);
    }
}
//To do: 
//Fix small bug related to adding Point 1 1
//Display the road through the maze: each point is displayed on one row. The order is 1 0
                                                                                    //2 0
                                                                                    //3 0
                                                                                    //...
                                                                                    //4 5
//Try the algorithm using other samples (other matrix)