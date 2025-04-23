package simple;

import java.util.Scanner;

public class vidu {
	public static void main(String[] args) {
		Scanner inputkb = new Scanner(System.in);
		System.out.println("Nhap: ");
		String s = inputkb.nextLine();
		
		String cp[] = s.split(" ");
		
		
		System.out.println(cp[0]);
		System.out.println(cp[1]);
		System.out.println(cp[2]);
	}
}
