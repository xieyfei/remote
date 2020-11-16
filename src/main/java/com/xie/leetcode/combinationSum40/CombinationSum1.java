package com.xie.leetcode.combinationSum40;

import java.util.*;

public class CombinationSum1 {

    public static void main(String[] args) {
        CombinationSum1 s = new CombinationSum1();
        int[] candidates = {2,5,2,1,2};
        System.out.println(s.combinationSum2(candidates, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        help(candidates, result, new int[candidates.length], 0, target, 0, new HashSet<>());
        return result;
    }

    private void help(int[] candidates, List<List<Integer>> result, int[] deque, int index, int target, int start, Set<String> dupSet) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            String key = generateKey(deque);
            if (!dupSet.contains(key)) {
                List<Integer> list = new ArrayList<>();
                for (int i : deque) {
                    if (i > 0) {
                        list.add(i);
                    } else {
                        break;
                    }
                }
                result.add(list);
                dupSet.add(key);
            }
            return;
        }
        for (int i = start; i <= candidates.length - 1; i++) {
            if (candidates[i] > target) {
                break;
            }
            deque[index] = candidates[i];
            help(candidates, result, deque, index + 1, target - candidates[i], i + 1, dupSet);
            deque[index] = 0;
        }
    }

    private String generateKey(int[] deque) {
        StringBuilder sb = new StringBuilder();
        for (int j : deque) {
            sb.append(j);
            sb.append(";");
        }
        return sb.toString();
    }
}
