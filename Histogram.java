import java.util.Scanner;
/**
 * Count how many numbers there are in a string and print an asterisk for every five in a group of ten.
 * 
 * @author JC Cheek 
 */
public class Histogram
{
    public static void main(){
        
      Scanner scan = new java.util.Scanner(System.in);
      
      System.out.println("Please enter a bunch of integers\n");
      
      int[] kismet = counter(scan.nextLine());
      
      printCount(kismet);
    }
    
    static int[] counter(String numbers){
        int[] kismet = new int[100];
        int value = 0;
        String delims = "[ ]+";
        String[] tokens = numbers.split(delims);
        for(int i = 0; i<tokens.length; i++){
            value = Integer.parseInt(tokens[i]);
            kismet[value] += 1; 
        }
        return kismet;
    }
    
    static String drawStar(int[] kismet, int bottom, int top){
        String stars = "";
        int total = 0;
        int dividedTotal = 0;
       
        for( int i = bottom; i<top; i++){
            if(bottom != 100 && top != 110){
                total += kismet[i];
            }
        }
        dividedTotal = total/5;
        for(int k = 0; k<dividedTotal; k++){
            stars += "*";
        }
        return stars;
    }
    
    static void printCount(int[] kismet){
        int top = 10;
        int bottom = 1;
        String stars = "";
        for(int i = 0; i<top; i+=10){
            stars = drawStar(kismet, bottom, top);
            System.out.println(bottom+"-"+top+"\t|"+stars);
            bottom = top+1;
            if(top<110){
                top += 10;
            }
        }
        
    }
    
//     Which of the following are valid declarations? Which instantiate
//  * 	an array object? Explain your answers.
//  * 	
//  *- int primes = {2 , 3 , 4 , 5 , 7 , 11};
//  * No, because there are no [] signifying that it is an array.
// 
//  *- double[] elapsedTimes = {11.47, 12.04, 11.72, 13.88};
//  *Yes.
//  *- int[] scores = int[30];
//  *no, no "new"
//  *
// 
//  *- int[] primes = new {2, 3, 5, 7, 11};
//  *new what? no.
//  *- int[] scores = new int[30];
//  *yes.
//  *- char grades[] = {'a', 'b', 'c', 'd', 'f'};
//  *yes.
//  *- char[] grades = new char[];
//  *no, need to specify how large.
//  * 	
//  *
//  * Ex 7.3 Describe what problem occurs in the following code. What modifications
//  * 	should be made to it to eliminate the problem?
//  * 	
//  * 	int[] numbers = {3, 2, 3, 6, 9, 10, 12, 32, 3, 12, 6};
//  * 	for (int count = 1; count <= numbers.length; count ++)
//  * 		System.out.println(numbers[count]);
//  * 		you dont catch the first number in the array and you get an index out of
//  * 		bounds error because numbers[numbers.length] doesnt exist.
}
