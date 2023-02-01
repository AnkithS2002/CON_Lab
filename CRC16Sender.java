import java.util.Scanner;

public class CRC16Sender {

	public static void main(String[] args) {
		String msg, crc, encoded="";
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the message: ");
		msg = scan.nextLine();
		System.out.println("Enter the crc generator polyn: ");
		crc = scan.nextLine();
		int m = msg.length(); 
		int n = crc.length();
		
		encoded += msg;
		
		for(int i=1; i<=n-1; i++) {
			encoded+='0';
		}
		System.out.println("Initially msg after adding zeros: "+encoded);
		char[] encodedArray = encoded.toCharArray();
		
		for(int i=0; i<=encodedArray.length-n; ) {
			for(int j=0; j<n; j++) 
				encodedArray[i+j] = (encodedArray[i+j] == crc.charAt(j)? '0':'1');
			for(;i<encodedArray.length && encodedArray[i] != '1'; i++);
		}
		StringBuilder sb_obj = new StringBuilder();
		for(int i = 0; i < encodedArray.length; i++){
            sb_obj.append(encodedArray[i]);
        }
		System.out.println("After generating CRC using XOR operation (division): ");
		System.out.println("message sent: "+msg+sb_obj.substring(sb_obj.length()-n+1));
		System.out.println("crc: "+sb_obj.substring(sb_obj.length()-n+1));

	}

}
