import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        find(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    public void find(int[] candidates, int target, int index,
                     List<Integer> list,
                     List<List<Integer>> result) {

        // Target reached
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        // Target exceeded
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Choose
            list.add(candidates[i]);

            // i is passed again because same number can be reused
            find(candidates, target - candidates[i],
                 i, list, result);

            // Backtrack
            list.remove(list.size() - 1);
        }
    }
}