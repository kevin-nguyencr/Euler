package easy;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

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
	
	//Challenge 3-Largest Prime Factor 1st solution
	public static long lpf(){
		int maxf = 2;
		int lastfactor = 1;
		long total = 600851475143L;
		
		if (total %maxf==0){
			lastfactor = maxf;
			total = total / maxf;
			while (total%maxf ==0){
				total = total / maxf;
			}
			lastfactor = maxf;
		}
		maxf = 3;
		while (total>1){
			if (total % maxf == 0){
				lastfactor = maxf;
				total = total / maxf;
				while (total%maxf ==0){
					total = total / maxf;
				}
			}
			maxf+=2;
		}
		return lastfactor;
	}
	
	public static long lpf1(){
		int maxf = 2;
		int lastfactor = 1;
		long total = 600851475143L;
		
		if (total %maxf==0){
			lastfactor = maxf;
			total = total / maxf;
			while (total%maxf ==0){
				total = total / maxf;
			}
			lastfactor = maxf;
		}
		double limit = Math.sqrt(total);
		maxf = 3;
		while (total>1 && maxf<limit){
			if (total % maxf == 0){
				lastfactor = maxf;
				total = total / maxf;
				while (total%maxf ==0){
					total = total / maxf;
				}
				limit = Math.sqrt(total);
			}
			
			maxf+=2;
		}
		if (total == 1){
			return lastfactor;
		}
		else{
			return total;
		}
	}
	
	//Challenge 4-Largest Palindrome product 1st solution
	public static int lpp(){
		int result = 0;
		for (int i =100;i<1000;i++){
			for (int j = 100;j<1000;j++){
				int prod = i*j;
				if (prod> result && isPal(prod)){
					result = prod;
				}
			}
		}
		return result;
	}
	
	//Challenge 4-Helper
	public static boolean isPal(int num){
		String strprod = String.valueOf(num);
		int max = strprod.length();
		for (int i = 0;i<=max/2;i++){
			if (strprod.charAt(i) != strprod.charAt(max-1-i)){
				return false;
			}
		}
		return true;
	}
	
	//Challenge 4-Better Solution
	public static int lpp1(){
		int result = 0;
		int i = 999;
		while (i>100){
			int j = 999;
			while (j>=i){
				int prod = i*j;
				if (prod<result){
					break;
				}
				if (prod>result && isPal(prod)){
					result = prod;
				}
				j=j-1;
			}
			i=i-1;
		}
		return result;
	}
	
	//Challenge 4-Modular
	public static int lpp2(){
		int result = 0;
		int i = 999;
		int dj = 1;
		while (i>100){
			int j =999;
			if (i% 11 ==0){
				dj = 1;
			}
			else{
				j =990;
				dj = 11;
			}
			while (j>=i){
				int prod = i*j;
				if (prod<result){
					break;
				}
				if (prod>result && isPal(prod)){
					result = prod;
				}
				j=j-dj;
			}
			i=i-1;
		}
		return result;
	}
	
	//Challenge 5-EvenlyDivisible
	public static int ed(){
		int start = 20;
		int[] ar = {1,3,5,7,11,13,17,19,2,4,6,8,9,10,12,14,15,16,18,20};
		boolean cont = true;
		while (cont){
			cont = false;
			for (int a: ar){
				if (start%a!=0)
					cont = true;
			}
			start+=20;
			//System.out.println(start);
		}
		return start;
	}
	
	//Challenge 5-findPrimes Brute force
	public static boolean isPrime(int num){
		for (int i= 2;i<num;i++){
			if (num%i==0){
				return false;
			}
		}
		return true;
	}
	//Challenge 5-BetterSolution
	public static double ed(int max){
		int result =1;
		boolean maxExp = true;
		for (int i =2;i<max+1;i++){
			if (isPrime(i)){
				if (maxExp){
					double e = 1;
					double i2 = i;
					while (Math.pow(i2, e)<max){
						e+=1;
					}
					e=e-1;
					if (e==1){
						maxExp = false;
					}
					System.out.println((int)Math.pow(i2, e));

					result = result*(int)Math.pow(i2, e);
				}
				else{
					System.out.println(i);
					result = result*i;
				}
			}
		}
		return result;
	}
	
	//Challenge 6-Difference Sum of Squares and Square of Sum
	public static int ssd(int num){
		int small = 0;
		int de = 1;
		int base = 0;
		for (int i = 1;i<num+1;i++){
			base += de;
			small = small + base;
			de +=2;
		}
		double a_sum = 1.0*(1+num)*num/2;
		int big = (int)Math.pow(a_sum, 2);
		
		return big-small;
	}
	
	//Challenge 7-10001 prime number
	public static int prime(int nth){
		int result = 2;
		int prime_count = 1;
		int num = 3;
		while (prime_count<nth){
			if (isPrime(num)){
				result = num;
				prime_count++;
			}
			num+=2;
		}
		return result ;
	}
	
	public static int highSeq(String file){
		File f = new File(file);
		int max = 0; 
		int front = 0;
		int back = 0;
		try{
			Scanner s = new Scanner(f);
	
			while (s.hasNext()){
				String line = s.next();
				int lmax = 0;
				int dif = 0;
				int start = 0;
				int index = 0;
				boolean searching = true;
				while (searching){
					int val = Integer.valueOf(line.charAt(start+index));
					if (val == 0){
						start = start+index;
						index = 0;
						lmax = 0;
						//unless 0 is past end of line
					}
					if (index ==0){
						front = val;
					}
					lmax+= val;
					if (index ==12){
						back = val;
						start = start+index+1;
						index = 0;
						searching = false;
					}
				}
				searching = true;
				while (searching){
					int val = Integer.valueOf(line.charAt(start+index));
					if (val == 0){
						start = start+index;
						index = 0;
						lmax = 0;
						//unless 0 is past end of line
					}
					if (index ==0){
						front = val;
					}
					lmax+= val;
					if (index ==12){
						back = val;
						searching = false;
					}
				}
				for (int i=13; i<line.length();i++){
					int valb = Integer.valueOf(line.charAt(i));
					int valf = Integer.valueOf(line.charAt(i));
					dif += (valb - back) + (valf - front);
					if (dif > 0){
						lmax+=dif;
						dif = 0;
					}
					back = valb;
					front = valf;
				}
				if (lmax>max){
					max =lmax;
				}
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args){
		// Sol1
		   //System.out.println(mult(1000));
		// Better Sol1
		//System.out.println(mult1(999,3)+mult1(999,5)-mult1(999,15));
		//System.out.println(fibEven());
		//System.out.println(fibEven1());
		//System.out.println(lpf());
		//System.out.println(lpf1());
		//System.out.println(lpp());
		//System.out.println(lpp1());
		//System.out.println(lpp2());
		//System.out.println(ed());
		//System.out.println(ed(20));
		//System.out.println(ssd(100));
		System.out.println(prime(10001));
	}

}
