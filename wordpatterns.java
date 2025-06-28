/*TC: O(n)
*SC: O(n)
*   Did a double mapping for string s and string t using a Hashmap and hashset.
    used conditional checking to check whether the char in string s is first present in the HM, if not then checked if string is present in 
    the set, if not added in the set and map. if it was present then we check the mapping of value of the key with the value to be added.
*/ 


import java.util.HashMap;
import java.util.HashSet;


class wordpatterns {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if(pattern.length()!=words.length){
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<words.length; i++){
            char pchar = pattern.charAt(i);

            if(map.containsKey(pchar)){
                if (!map.get(pchar).equals(words[i])){  //equals() method is used to compare values 
                    return false;
                }
            }
            else{
                if(set.contains(words[i])){
                    return false;
                }
                set.add(words[i]);
                map.put(pchar,words[i]);
            }
        }
    return true;
    }

    public static void main(String[] args){
        String s = "abba", t = "dog cat cat dog";
        wordpatterns p = new wordpatterns();
        System.out.println(p.wordPattern(s,t));
    }
}