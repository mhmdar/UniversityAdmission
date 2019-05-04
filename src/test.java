import java.io.*;

public class test {
	public static String [] a = new String [3];
	
	public static void myMethod() {
		
		a[0]="0";
		a[1]="1";
		a[2]="2";
		set(0,"x");
		for (int i=0 ; i<3 ; i++){
			//System.out.println(a[i]);
			System.out.println(get(i));
		}
		System.out.printf("%-34s%-4s%4s%-2s", "Name" , "from" , "", "to\n");
		System.out.printf("%-34s%-2.1f%4s%-2.1f", "ali" , 83.6f,"", 9f);
		System.out.println("\n-----------------------");
		
		
	}	
	
	public static void set(int i , String f){
		a[i]=f;
	}
	
	public static String get(int i){
		return a[i];
	}
	
	

}
