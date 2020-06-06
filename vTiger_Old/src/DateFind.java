import java.util.Date;

public class DateFind {

	public static void main(String[] args) {
		Date d=new Date();
		System.out.println(d);
		
		String compltD=d.toString();
		System.out.println(compltD);

		System.out.println(d);
		
		String[] st=compltD.split(" ");
		System.out.println(st[1]);
		
		System.out.println(d.getDate());
		
		System.out.println(d.getMonth());
		

	}

}
