/*TC: O(n)
*SC: O(n)
*   Sorted the inp strings to form a key that would be the same for all the anagrams.
    Used that key to hold multiple anagrams as values.
    Returned those anagrams together inside a list at the end.
*/ 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i=0; i<strs.length; i++){
            char ch[] = strs[i].toCharArray();//convert the current string to char array
            Arrays.sort(ch);  //sort the letters in the char array
            String newstr = new String(ch);    //convert the char array back to string
            
            map.putIfAbsent(newstr, new ArrayList<>());
            map.get(newstr).add(strs[i]);

        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args){
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams p = new groupAnagrams();
        System.out.println(p.groupAnagrams(strs));
    }
}