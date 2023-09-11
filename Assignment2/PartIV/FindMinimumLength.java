//Yudi Yang, Section I, Dean Christakos, 2023.2.9, A2p4
import java.io.*;
import java.util.*;

class FindMinimumLength {
    public static int minSubArrayLen(int goal, int[] nums) {
        
        int left = 0, right = 0, sum = 0, minimumLength = Integer.MAX_VALUE;
              
        int check = 0;       
        for (int num : nums) check += num;
     
        if (check < goal) return 0;
        else{
	        while (right < nums.length) {
	            sum += nums[right++];
	            while (sum >= goal) {
	            	minimumLength = Math.min(minimumLength, right - left);
	                sum -= nums[left++];
	            }
	        }
	    }
        
        //print
        System.out.print("intArray = ");
        System.out.println(Arrays.toString(nums));
        System.out.println("goal = " + goal);
      
        return minimumLength;
    }
    
    public static void main(String[] args) {
    	int minLen1, minLen2;
    	
    	int[] array1 =   {10,2,3,11}; 	
    	minLen1 = minSubArrayLen(11, array1);
    	System.out.println("minimumLength = " + minLen1);
    	
    	int[] array2 =   {5, 6, 8, 2};
    	minLen2 = minSubArrayLen(15, array2);
    	System.out.println("minimumLength = " + minLen2);
    }
}
