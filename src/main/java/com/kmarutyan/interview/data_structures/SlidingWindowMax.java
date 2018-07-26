package com.kmarutyan.interview.data_structures;

import java.util.*;

public class SlidingWindowMax {

    public static int[]  slidingWindow(int wsize, List<Integer> nums){
        final int[] max_per_range= new int[nums.size()];
        final int[] ans = new int[nums.size() - wsize + 1];


        for(int i = 0 , w = 0, curMax = Integer.MIN_VALUE; i < nums.size(); i++){
            curMax = Math.max(curMax, nums.get(i));
            max_per_range[i] = curMax;
            w++;
            if(w == wsize){
                curMax =  Integer.MIN_VALUE;
                w = 0;
            }
        }

        for(int i = 0; i< ans.length;  i++){
            ans[i] = Math.max(max_per_range[i], max_per_range[i+wsize-1]);

        }


        return ans;

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];
        if(nums.length == 0) return new int[0];
        Queue<Integer> queue = new PriorityQueue<Integer>((Integer i, Integer j) ->  (-1)*(i.compareTo(j)));

        for(int i = 0; i < k; i ++){
            queue.add(nums[i]);
        }
        result[0] = queue.peek();
        for(int i = k; i < len; i ++){
            queue.remove(nums[i - k]);
            queue.add(nums[i]);
            result[i - k + 1] = queue.peek();
        }

        return result;
    }
    public static void main(String [] args){

        List<Integer> vals = Arrays.asList(new Integer[] {1,3,-1,-3,5,3,6,7});
        Arrays.stream(slidingWindow(3, vals)).forEach(l -> System.out.print(l+"\t"));
        System.out.println();
//        Arrays.stream(maxSlidingWindow( new int[] {1,3,-1,-3,5,3,6,7}, 3)).
//           forEach(l -> System.out.print(l+"\t"));

    }
}


