package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int mat[][] = {
                { 10, 2, 1, 8 },
                { 3, 9, 2, 5},
                { 1, 2, 3, 4},
                { 15, 6, 7, 8}
        };
        Matching m = new Matching();
        m.PerformMatching(mat);
    }
}
