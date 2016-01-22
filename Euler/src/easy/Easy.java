package easy;
import java.util.ArrayList;

public class Easy {
	//Challenge 1
	public static int mult(int range){
		int sum = 0;
		for (int i=0;i<range;i++){
			if (i%3==0 || i%5==0){
				sum+=i;
			}
		}
		return sum;
	}
	//Challenge 1-Better Solution
	public static int mult1(int target,int div){
		int max_divis = (int) target/div;
		int sum = div*max_divis*(1+max_divis)/2;
		return sum;
	}
	
	//Challenge 2-Even Fibonacci Numbers
	public static int fibEven(){
		int sum = 2;
		int val1 = 1;
		int val2 = 2;
		int tmp = 0;
		while (val2 < 4000000){
			tmp = val2;
			val2 = val1+val2;
			val1 = tmp;
			if (val2%2==0){
				sum+=val2;
			}
		}
		return sum;
	}
	//Challenge 2-Even Fibonacci Numbers Better
	public static int fibEven1(){
		int sum = 0;
		int a = 1;
		int b = 1;
		int c = 2;
		while (c < 4000000){
			sum+=c;
			a = b + c;
			b = c + a;
			c = b + a;
		}
		
		return sum;
	}
	
	//Challenge 3-Largest Prime Factor
	public static long lpf(){
		int m = 0;
		long total = 600851475143L;
		
		return total;
	}
	
	public static void main(String[] args){
		// Sol1
		   //System.out.println(mult(1000));
		// Better Sol1
		System.out.println(mult1(999,3)+mult1(999,5)-mult1(999,15));
		System.out.println(fibEven());
		System.out.println(fibEven1());
		System.out.println(lpf());
	}

}
