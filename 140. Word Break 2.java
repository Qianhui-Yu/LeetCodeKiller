2维dp + dfs
dp负责存valid word的起始index而不是存单词了
dfs用来取单词
这样保证了O(n^2)
注意嵌套List的创建内部list，add前要判断此处是否有list还是null
注意dfs 变量的变动，是写在程序里还是参数里，防止回退时变量没有回退

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        //注意链表数组的创建
        List<Integer>[] starts = new List[s.length() + 1];
        starts[0] = new ArrayList<Integer>();
        
        Set<String> set = new HashSet<>();
        for (String word: wordDict) {
            set.add(word);
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 注意空指针错误
                /*
                if (starts[j] != null && set.contains(s.substring(j, i)))
                    starts[i].add(j);
                */
                // 要先判断j前面是否ok，再判断j后面是否是词，最后判断是否已经创建内部list
                if (starts[j] == null) continue;
                if (set.contains(s.substring(j, i))) {
                    if (starts[i] == null) 
                        starts[i] = new ArrayList<Integer>();
                    starts[i].add(j);
                }
            }
        }
        
        List<String> res = new ArrayList<>();
        if (starts[s.length()] == null)
            return res;
        dfs(res, "", starts, s.length(), s);
        
        return res;
    }
    
    private static void dfs(List<String> res, String alreadyWords, List<Integer>[] starts, int end, String s) {
        if (end == 0) {
            res.add(alreadyWords.substring(1));
            return;
        }
        for (int start: starts[end]) {
            String word = s.substring(start, end);
            //注意这里不能把alreadyWords单拎出来变，不然loop的时候会叠加之前的word
            //alreadyWords = " " + word + alreadyWords;
            //dfs(res, alreadyWords, starts, start, s);
            dfs(res, " " + word + alreadyWords, starts, start, s);
        }
    }
}