package leetcode;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int[] indices = twoSum(array, 9);
        System.out.println("[" + indices[0] + ", " + indices[1] + "]");
    }

//    public static int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No 2 sum solution");
    }
}
