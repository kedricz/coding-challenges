/* 
 * This method takes a number and returns the number at that position in the fibonacci sequence 
 *
 * @param - the position number
 * @return - number at the nth position in the fibonacci sequence
 *
 * Time complexity is O(n) where n is the position number
 * Space complexity is O(1)
 */
 public int fibonacci(int n) {
        
     /** Check if the position is valid */
     if(n < 0) return -1;
        
     /* 
      * First two numbers in Fibonacci sequence. 
      * These two variables will keep track of two previous numbers 
      */
     int a = 0; 
     int b = 1;
     
     if(n==0) return a;
     if(n==1) return b;
  
     /** Keep adds two previous number until it is reached to the given position */
     for(int i=2; i<=n; i++) {
	 int c = a+b; // c = ith fibonacci number at current iteration
	 a = b;
	 b = c;
     }

     return b;
 }