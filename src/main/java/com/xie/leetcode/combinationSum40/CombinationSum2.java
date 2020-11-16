package com.xie.leetcode.combinationSum40;

import java.util.*;

public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 s = new CombinationSum2();
        int[] candidates = {10,1,2,7,6,1,5};
        System.out.println(s.combinationSum2(candidates, 8));
    }

    private int[] preCal;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        preCal = new int[candidates.length];
        for (int i = 1; i < candidates.length; i++) {
            if (candidates[i - 1] == candidates[i]) {
                preCal[i] = preCal[i - 1] + 1;
            }
        }
        help(candidates, result, new int[candidates.length], 0, target, 0, new HashSet<>());
        return result;
    }

    private void help(int[] candidates, List<List<Integer>> result, int[] deque, int index, int target, int start, Set<String> dupSet) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            List<Integer> list = new ArrayList<>();
            for (int i : deque) {
                if (i > 0) {
                    list.add(i);
                } else {
                    break;
                }
            }
            result.add(list);
            return;
        }
        for (int i = start; i <= candidates.length - 1; i++) {
            if (preCal[i] != 0 && (index < preCal[i] || deque[index - preCal[i]] != candidates[i])) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            deque[index] = candidates[i];
            help(candidates, result, deque, index + 1, target - candidates[i], i + 1, dupSet);
            deque[index] = 0;
        }
    }
}
