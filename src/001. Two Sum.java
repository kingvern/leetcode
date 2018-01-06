/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] original = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            original[i] = nums[i];
        }
        
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int num1 = -1;
        int num2 = -1;
        while(start != end){
            int sum = nums[start] + nums[end];
            if(sum == target){
                num1 = nums[start];
                num2 = nums[end];
                break;
            }else if(sum < target){
                start++;
            }else{
                end--;
            }
            
        }
        //Find the num1, num2 in original array and record the index
        int[] rst = new int[2];
        rst[0] = -1;
        rst[1] = -1;
        for(int i = 0; i < original.length; i++){
            if(original[i] == num1 || original[i] == num2){
                if(rst[0] == -1){
                    rst[0] = i;
                }else{
                    rst[1] = i;
                    break;
                }
            }
        }
        return rst;
        
    }
}