import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        find(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    public void find(int[] candidates, int target, int index,
                     List<Integer> list,
                     List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Skip duplicate numbers
            if (i > index && candidates[i] == candidates[i - 1])
                continue;

            // Number is bigger than target
            if (candidates[i] > target)
                break;

            // Choose
            list.add(candidates[i]);

            // i + 1 because each number can be used only once
            find(candidates, target - candidates[i],
                 i + 1, list, result);

            // Backtrack
            list.remove(list.size() - 1);
        }
    }
}