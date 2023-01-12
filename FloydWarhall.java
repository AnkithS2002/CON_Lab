import java.util.Scanner;

public class FloydWarhall {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of routers: ");
		int num = scanner.nextInt();
		int temp = num;
		
		int[][] matrix = new int[num][num];
		char[][] dest = new char[num][num];
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		
		for(int k=0; k<matrix.length; k++){
			for(int i=0; i<matrix.length; i++){
	            for(int j=0; j<matrix.length; j++){
	               if(matrix[i][k] != 99 && matrix[k][j] != 99 ){
	                  if(matrix[i][k]+matrix[k][j] < matrix[i][j] || matrix[i][j]==99)
	                     matrix[i][j] = matrix[i][k]+matrix[k][j];
	               }    
	            }
	        }
	    }
		char[] charmat = {'A','B','C','D','E'};
		for (int i = 0; i < num; i++) {
			System.out.println("Router table entries for router "+charmat[i]+": ");
			System.out.println("Destination router: A B C D E"); 
			System.out.print("         Hop count: "); 
			for (int j = 0; j < num; j++) {
				System.out.print(matrix[i][j]+" ");
				
			}
			System.out.println("\n");
		}
	}

}
