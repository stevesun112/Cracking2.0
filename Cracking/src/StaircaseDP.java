/* Cracking 9.1
 * Also from 鬼混：Day7: 
 * Be careful with the bound of the Integer Type in the language you use.
   A child is running up a staircase with n steps, and can hop either 1 
   step, 2 steps or 3 steps at a time. Implement a method to count 
   how many possible ways the child can run up the stairs. */

public class StaircaseDP {

        public static int possibleWays(int n){
                int ways;
                if (n <= 0)
                        return 0;
                else if(n == 1)
                        ways = 1;
                else if (n == 2)
                        ways = 2;
                else if (n == 3)
                        ways = 4;
                else 
                        ways = possibleWays(n-1) + possibleWays(n-2) + possibleWays(n-3); 
                return ways;
        }
        
        
        
        public static void main(String args[]){
                StaircaseDP test = new StaircaseDP();
                System.out.println(test.possibleWays(-1));
        }
}