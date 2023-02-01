import java.util.Scanner;

public class CRC16Reciever {

	public static void main(String[] args) {
		String crc, encoded="";
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Recieved message: ");
		encoded = scan.nextLine();
		System.out.println("Enter the crc generator polyn: ");
		crc = scan.nextLine();
		char[] encodedArray = encoded.toCharArray();
		for(int i=0; i<=encodedArray.length-crc.length(); ) {
			for(int j=0; j<crc.length(); j++) 
				encodedArray[i+j] = (encodedArray[i+j] == crc.charAt(j)? '0':'1');
			for(;i<encodedArray.length && encodedArray[i] != '1'; i++);
		}
		StringBuilder sb_obj = new StringBuilder();
		for(int i = 0; i < encodedArray.length; i++){
            sb_obj.append(encodedArray[i]);
        }
		System.out.println(sb_obj.substring(sb_obj.length()-crc.length()));
		for (char c : sb_obj.substring(sb_obj.length()-crc.length()).toCharArray()) {
			if(c != '0') {
				System.out.println("Error in communication");
				return;
			}
		}
		System.out.println("No error in the message");
	}

}
