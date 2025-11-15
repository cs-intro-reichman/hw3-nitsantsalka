// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x1 == 0) {
			x1 = x2;
		}
		else if (x2 < 0 ){
			for (int num=x2 ; num < 0 ; num++ ){
				x1--;
			}
		}
		else {
			for (int num = x2 ; num > 0 ; num--){
				x1++;
			}
		}

		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {		
		if (x2 > 0) {
			for (int num = x2 ; num > 0 ; num--){
				x1--;
			}
		}
		else {
			for (int num = x2 ; num < 0 ; num++){
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int add = x1;
		if ((x1 == 0) || (x2 == 0)){
			return 0;
		}
		if (x1 < 0){
			if (x2 < 0){
				x2 = minus(minus(x2,x2), x2);
				x1 = minus(minus(x1,x1), x1);
				add = x1;
				for (int num = (x2 - 1); num > 0 ; num--){
					x1 = plus (x1 , add) ;
				}
			}
			else {
				for (int num = (x2 - 1); num > 0 ; num--){
					x1 = plus (x1 , add) ;
				}
			}
		}
		else if (x2 < 0){
				for (int num = (x2 -1); num < 0 ; num++){
					x1 = minus(x1 , add) ;
				}
			}
		else {
			for (int num = (x2-1); num > 0 ; num--){
				x1 = plus (x1 , add) ;
			}
		}
			
		return x1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int add = x;
		if (n == 0){
			return 1;
		}
		else {
			for (int num = n-1 ; num > 0 ; num--){
				x = times(x , add);
		}
	}
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int sum = 0;
		if (x1 < 0){
			if (x2 < 0){
				x2 = minus(minus(x2,x2), x2);
				x1 = minus(minus(x1,x1), x1);
				if (x1 >= x2){
					while (x1 >= x2 ){
						x1 = minus(x1, x2);
						sum++;
					}
				}
				else {
					return 0;
				}					
			}
			else{
				x2 = minus(minus(x2,x2),x2);
				while (x1 <= x2){
					x1 = minus(x1, x2);
					sum--;
				}
			}
		}
		else if(x2 < 0){
			x1 = minus(minus(x1,x1),x1);
			if (x1 <= x2){
				while (x1 <= x2){
					x1 = minus(x1, x2);
					sum--;
				}
			}
			else{
				return 0;
			}
		}
		else{
			while (x1 >= x2 ){
				x1 = minus(x1, x2);
				sum++;
			}
		}
		return sum;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		x1 = minus(x1, times(x2, div(x1, x2)));
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int sum = 0;
		int num = 1;
		if (x == 0){
			return 0;
		}
		if (x <= 3 ){
			return 1;
		}
		else{
			while (x > sum){
				sum = pow(num,2);
				num++;
			}
			if (x == sum)
			{
				num--;
			}
			else{
				num = num - 2 ;
			}
		}
		return num;
	}	  	  
}
