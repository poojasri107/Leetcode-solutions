import java.util.*;

class Solution {

    HashMap<Integer, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        return solve(s, 0, wordDict);
    }

    public List<String> solve(String s, int start, List<String> wordDict) {

        if (start == s.length()) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> answer = new ArrayList<>();

        for (String word : wordDict) {

            if (s.startsWith(word, start)) {

                List<String> remaining =
                    solve(s, start + word.length(), wordDict);

                for (String r : remaining) {

                    if (r.equals("")) {
                        answer.add(word);
                    } else {
                        answer.add(word + " " + r);
                    }
                }
            }
        }

        memo.put(start, answer);

        return answer;
    }
}