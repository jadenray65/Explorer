import java.util.Scanner;
/**
 * Write a description of class hw09 here.
 * 
 * @author Zac Douglass 
 * @version 11/14/12
 */
public class hw09 {

    public static void main ( String[] args ) {
        
        int[] nums = new int[101];
        
        System.out.println("Enter a number:");
        
        Scanner s = new Scanner (System.in);
        
        
        while ( s.hasNext() ) {
            int n = s.nextInt();
            if ( n >= 1 && n <= 100 ) {
                nums[n] +=1;
                
            }
        
       }
       //you dont need to say hw09 if youre in hw09
       hw09.printMeth(nums);
   }
   
   static void printMeth( int[] nums ) {
       //why do you want to say this twice? You already got the input from the user in during main()
       System.out.println("Please enter a number:");
       
       //right now, we're looping through every single index of nums - which is good
       //and then printing a line for each index - which is bad.
       //how can we say "for groups 1-10, print this, groups 11-20, print this" etc?
       //i have an idea. you need to print these out in sections right? 1-10, 11-20, right? 
       //lets consider the lower end of the section to be the bottom and the higher end of the section to be the top
       //so in this case, i, since it starts out being 0 would be considered the bottom wouldnt it?
       //then do we want to go all the way through the whole array in one go? or do we want to go to top?
       //what if we said int top = 10; for(int i = 0; i<top; i++) bottom+=10;?
       //That way, we start at 0, then go through just 10 times, then increment bottom by ten so we cant go anymore.
       //
       for ( int i = 0; i < nums.length; i +=1 ) {
           //now that we would be going through every index, we need to go through the individual groups of ten.
           //remember, the for loop from before gives you every single index and makes a top and bottom which are ten apart
           //we need a loop now, then, that goes through bottom to top one at a time.
           //so how would we say while bottom is less than top and then increment bottom by one? 
           //how about while(top<bottom) bottom++;
           //you need to figure out how many stars each section has right? that sounds like we need a total
           //outside both the while and the for loops initiate the total variable because we dont want to make a new variable every time
           //then inside the while loop, say something to the effect of 
           //total is now total plus the array we have at the index we are in.
           //now that we are in the index, and we're in the group of ten, and we have the total number of times one of those
           //numbers has been used, we need to say print the section we're in and the total (we'll switch it to stars later)
           //but we're in the while loop right now arent we? im pretty sure we only want to print this once per group of ten
           //and if its in the while loop, wont it print for every single index? Lets move it to just under the end of the 
           //while loop and inside the for loop. 
           //alright, lets look at what the print line will be. we said print the section we're in and the total.
           //the section we're in is the lower and the upper right? which we said was bottom and top right? and then 
           //a simple \t element for editing and then the total.
           if ( nums[i] > 0) {
               System.out.println( i + " " + nums[i] );
           } 
         
       }
    
   }
}
/**EX 8.1 Which of the following are valid declarations? Which instantiate an array object? Explain your *answers.  *int primes = {2, 3, 4, 5, 7, 11}; *float elapsedTimes[] = {11.47, 12.04, 11.72, 13.88}; 
 *int[] scores = int[30]; *int[] primes = new {2,3,5,7,11}; *int[] scores = new int[30]; *char grades[] = {'a', 'b', 'c', 'd', 'f'}; char[] grades = new char[];
 *The following are valid declarations:
 *double[] elapsedTimes = {11.47, 12.04, 11.72, 13.88};
 *int[] scores = int[30];
 *int[] scores = new int[30];
 *char grades[] = {'a', 'b', 'c', 'd', 'f'}; char[] grades = new char[];
 *The following instantiate an array object:
 *int[] primes = new {2,3,5,7,11};  *int[] scores = new int[30];    *char grades[] = {'a', 'b', 'c', 'd', 'f'}; char[] grades = new char[];
 *This are instantiated, because they have the new operator which creates a new array
 * Ex. 8.4 Describe what problem occurs in the following code. What modifications should be made to it to   *eliminate the problem?
 *int[] numbers = {3, 2, 3, 6, 9, 10, 12, 32, 3, 12, 6}; 
 *for (int count = 1; count <= numbers.length; count++)
 *System.out.println (numbers[count]);
 *The problem with the code is that the condition cannot have an equal sign, because that would give it an  *index out of bounds error. Take the equals sign out to fix the problem.

 */

