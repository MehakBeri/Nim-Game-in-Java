// one player nim against intelligent computer
import java.util.Scanner;
import java.util.Random;

public class nimcc
{
	public static void main(String[] args)
	{
		Random r = new Random();
		Scanner key = new Scanner(System.in);
		System.out.print("Player 1, enter your name: ");
		String p1 = key.next();
		
		System.out.println("Hey, " + p1 + "! You will be playing nim against the computer!");
		
		System.out.println("Okay let us begin playing Nim! Following are the 3 piles!");
		int a = 3;
		int b= 4;
		int c=5;
		int max; //current max number of stones in a pile
		String star_a=""; //for vertical display
		String star_b="";
		String star_c="";
		String pile="A"; //initializing pile
		int decrease;
		int pile_int;
		int x=a; //pile a or b or c
		String lastplayer;
		int n=1; //number of turns played
		String p; //player which is playing
		do
		{       
			if(a>=b && a>=c) {max=a;}
			else if(b>=a && b>=c) {max=b;}
			else {max=c;}
			//FOR VERTICAL DISPLAY
			for (int i=max; i>0; i--) {  
					if (a-i<0) {star_a="  ";} 
					if (a-i>=0) {star_a="* ";}
					if (b-i<0) {star_b="  ";}
					if (b-i>=0) {star_b="* ";}
					if (c-i<0) {star_c=" ";}
					if (c-i>=0) {star_c="*";}
					System.out.println(star_a+star_b+star_c);	
				}
			System.out.println("A B C");
			//choose which player is playing
			if (n%2==0) 
			{ 
			p = "Computer";
			System.out.println("\n"+p + " will choose a pile now...");
//computer winning startegy, convert all numbers to binary. xor of all numbers gives a number. and that number obtained with all numbers, subtract the numbr from that numbr with which th and of it produces non zero qty by that non zero qty. 
			
			if((a^b^c) != 0) 
			{
			  int strategy = a^b^c;
			  if ((strategy&a) != 0) { pile = "A"; decrease = a- strategy; break;}
			  else if ((strategy&b) != 0) { pile = "B"; decrease = b- strategy; break;}
			  else if ((strategy&c) != 0) { pile = "C"; decrease = c- strategy; break;}
			  else {System.out.println("There is something wrong... "); break;}
			}
		else{
			if(a==0 && b!=0 && c!=0){ pile_int = r.nextInt(2)+1; if (pile_int==1) {pile="C"; x=c;} if (pile_int==2) {pile="B"; x=b;}   }
			else if(a!=0 && b==0 && c!=0){pile_int=r.nextInt(2) + 1; if (pile_int==1) {pile="A"; x=a;} if (pile_int==2) {pile="C"; x=c;}}
			else if(a!=0 && b!=0 && c==0){pile_int=r.nextInt(2) + 1;if (pile_int==1) {pile="A"; x=a;} if (pile_int==2) {pile="B"; x=b;}}
			else if(a==0 && b==0 && c!=0){pile="C"; x=c;}
			else if(a==0 && b!=0 && c==0){pile="B"; x=b;}
			else if(a!=0 && b==0 && c==0){pile="A"; x=a;}
			else {pile_int=r.nextInt(3) + 1; if (pile_int==1) {pile="A"; x=a;} if (pile_int==2) {pile="B"; x=b;} if (pile_int==3) {pile="C"; x=c;}}
			
			decrease = r.nextInt(x) + 1; //one drawback, comp has no dignity, so might take up all pebbles
		   }
			System.out.println("I chose pile " + pile);
			System.out.println("I will remove " + Integer.toString(decrease) + " from the pile");
			}
			else 
			{
			p=p1;
			System.out.println("\n"+p + ", choose a pile: ");
			pile = key.next();
			System.out.println("How many to remove from pile "+pile+": ");
			decrease = key.nextInt(); 
			
			if (pile.equals("A")) {x=a;}
			if (pile.equals("B")) {x=b;}
			if (pile.equals("C")) {x=c;}
			}
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
			
		}while(a+b+c!=0);
		String pp; //previous player
		if(p.equals(p1)){pp="Computer";} else {pp=p1;}
		System.out.println("\nCongratulations "+pp + ", you win!!");
	}
}