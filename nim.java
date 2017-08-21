// two player nim
import java.util.Scanner;

public class nim
{
	public static void main(String[] args)
	{
		Scanner key = new Scanner(System.in);
		System.out.print("Player 1, enter your name: ");
		String p1 = key.next();
		System.out.print("Player 2, enter your name: ");
		String p2 = key.next();
		System.out.print("Okay let us begin playing Nim! Following are the 3 piles!");
		int a = 3;
		int b= 4;
		int c=5;
		int max;
		String star_a=""; //for vertical display
		String star_b="";
		String star_c="";
		String pile;
		int decrease;
		int x=a; //pile a or b or c
		String lastplayer;
		int n=1; //number of turns played
		String p; //player which is playing
		do
		{
		  if (n%2==0) { p=p2;}
			else {p=p1;}
         
			//System.out.print("\nA: \n");
			//for (int i=a; i>0; i--) {System.out.print("*");} //for horizontal display
                        //System.out.print(" B: "+b+" C: "+c);

			if(a>=b && a>=c) {max=a;}
			else if(b>=a && b>=c) {max=b;}
			else {max=c;}
			//System.out.println("max is "+ max);
			for (int i=max; i>0; i--) {  //FOR VERTICAL DISPLAY
					if (a-i<0) {star_a="  ";} 
					if (a-i>=0) {star_a="* ";}
					if (b-i<0) {star_b="  ";}
					if (b-i>=0) {star_b="* ";}
					if (c-i<0) {star_c=" ";}
					if (c-i>=0) {star_c="*";}
					System.out.println(star_a+star_b+star_c);	
				}
			System.out.println("A B C");

			System.out.println("\n"+p + ", choose a pile: ");
			pile = key.next();
			System.out.println("How many to remove from pile "+pile+": ");
			decrease = key.nextInt();
			if (pile.equals("A")) {x=a;}
			if (pile.equals("B")) {x=b;}
			if (pile.equals("C")) {x=c;}
			if (decrease<=0) {System.out.println("\n"+ p + ", you should remove at least 1");continue;}
			if ((x-decrease)>=0 && x!=0)
			{
				x = x-decrease;
				
			}
			else if ( x==0)
			{
				System.out.println("\n"+ p + ", this pile is empty!! choose another pile please!");
				continue;
				
			}
			else if ((x-decrease)<0)
			{
				System.out.println("\n"+ p + ", this pile does not have that many counters! Try again!");
				continue;
				
			}
			if (pile.equals("A")) {a=x;}
			if (pile.equals("B")) {b=x;}
			if (pile.equals("C")) {c=x;}
			
			lastplayer = p;
			n +=1;
			
		}while(a+b+c!=1);
		System.out.println("\nSince only one counter is left. Congratulations,"+p + " because you win!!");
	}
}