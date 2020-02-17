anagram的定义：只改变字母顺序的两个字符串，所以长度必然一样，字母和频率都一样

HashMap参数只能是引用数据类型，不能是基础数据类型

HashMap方法的熟练使用：get（），put（），containsKey（），values（）

char转换成String：String str = String.valueOf(char);

Integer不能转换成Boolean，所以不能 if（Integer）而得用 if（Integer != 0）

方法：1、HashMap 2、Hash Table 3、Sort

JAVA SOLUTION: HASHMAP

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<char, int> map = new HashMap<char, int>();
        for (int i = 0; i < s.length(); i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }
        }
        for (int i = 0; i < t.length(); i++){
            if (!map.containsKey(t.charAt(i))){
                return false;
            }
        }
        return true;
}

