import java.util.Scanner;

public class CRC16_new {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter dividend: ");
		int dividend = Integer.parseInt(scan.nextLine(), 2);
		System.out.println("Enter dividsor: ");
		int divisor = Integer.parseInt(scan.nextLine(), 2);
		if(divisor != 0) {
			System.out.println("\nquotient is: "+(dividend/divisor)+" and remainder is: "+(dividend%divisor));
			String quotient = Integer.toBinaryString((dividend/divisor));
			String remainder = Integer.toBinaryString((dividend%divisor));
			System.out.println("\nquotient is: "+quotient+" and remainder is: "+remainder);
		}
		else 
            System.out.println("\ndivisor can't be zero!");
		
		int rem1 = (dividend%divisor)+dividend;
		String rem1String = Integer.toBinaryString(rem1);
		System.out.println("new str: "+rem1String+"");
		
		System.out.println("check error: 1:yes 2:no >> ");
		int usrInput = scan.nextInt();
		if(usrInput == 1) {
			System.out.println("Enter error position: ");
			int pos = scan.nextInt();
			if(rem1String.charAt(pos) == '1') {
				rem1String = rem1String.substring(0,pos) + "0" + rem1String.substring(pos+1);
			}
			else {
				rem1String = rem1String.substring(0,pos) + "1" + rem1String.substring(pos+1);

			}
			System.out.println("Errorneous data: "+rem1String);

            System.out.println("Error detected");
		}
		else {
			
		}
		
		scan.close();
	}

}
