//CISC3150 
//XIN GUAN
//09/21/2015
//
//I'm using backtracking method to solve the problem.
//I learned some of this method from:
//https://www.youtube.com/watch?v=p4_QnaTIxkQ
//https://developers.google.com/optimization/puzzles/queens?hl=en
//
//Short Description:
//Since in N_Queen problem, at lease each row has only one Queen,
//so I use only an unary array. the index represents the row,
// and the value of that index represents the column. for example, 
// queen[0]=2 means in the row 0, the 3rd position:
// . . 1 . . . .
// . . . . . . .
// . . . . . . .
// ....
// if a queen array is {0, 2, 4, 1, 3}, that will show the chess board like:
// 1 . . . .
// . . 1 . .
// . . . . 1
// . 1 . . .
// . . . 1 .

import java.util.*;

public class HW3NQueens{
	
	public static void main(String[] args) {
		
		//ask user to enter the number of queens
		Scanner sc= new Scanner(System.in);
		System.out.println("how many queens do you want? ");
		int n= sc.nextInt();
		
		//make an array for queen's position in each row
		int[] queen= new int[n]; 
		int solutions=0; //counter of solutions
		
		//put queens in each row and check if they are safe.
		int row = 0;
		queen[row]= -1;
		while (row>=0) {
			queen[row]++;
			//find a noThreatn position for the current row.
			while(noThreaten(queen, row)){
				if(queen[row]<n)
					queen[row]++;
				else
					break;
			}
			//if the position is inside the board
			if (queen[row] < n) {
				//go to the next row
				if (row<n-1) {
					row++;
					queen[row]= -1;
				}
				//if there is no next row, we got all the queens.
				//then print out the chess board
				else{
					solutions++;
					System.out.println(" solution "+ solutions);
					printSolution(queen);
				}
			}
			//else the position is beyond board, backtrack to the last queen
			else{
				row--;
			}
				
		}
		//print out the total solutions
		System.out.println("There are "+solutions+ " solutions.");
	}
	
	//if the new add queen[a] is the same/+1/-1 column as the last one, queen[a-1]
	//	or same/+2/-2 as the one before last one, queen[a-2] ...... 
	//	that will make a threaten.
	//else it is safe to put there.
	static boolean noThreaten(int[] q, int a){
		for(int i=1; i<=a; i++){
			if(q[a]==q[a-i]||q[a]-i==q[a-i]||q[a]+i==q[a-i]){
				return true;
			}
		}
		return false;
	}
	
	//print out the chess board, 1 means Queen's position.
	public static void printSolution(int[] q){
		for(int i = 0; i < q.length; i++){
			for(int j = 0; j < q.length; j++){
				if(q[i]==j)
					System.out.print(" 1");//1 represents Queen
				else
					System.out.print(" .");//0 represents empty space
			}
			System.out.println();
		}
		System.out.println();
		
	}

  
}