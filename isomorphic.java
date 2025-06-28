/*TC: O(n)
*SC: O(1)
*   Did a double mapping for string s and string t using a Hashmap and hashset.
    used conditional checking to check whether the char in string s is first present in the HM, if not then checked if character in 
    t string is in the set, if not added in the set and map. if it was present then we check the mapping of value of the key with the value to be added.
*/ 

import java.util.HashMap;
import java.util.HashSet;

class isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        //Using one HM and one Hashset
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);

            if (map.containsKey(schar)) { //Key (schar) present in Hashmap
                //now since key(schar) is present, we check that the value 
                //already mapped to it is the same as the value that we are about to map it.
                if (map.get(schar) != tchar)
                    return false; //if not we return false.
            }
            //Key (schar) not present in Hashmap
            else {
                //we check that if the value(tchar) for the key (schar) is already present in the HashSet.
                //if its already present that means that the value is already mapped to some other key earlier in the
                //HashMap. So we return false here.              
                if (set.contains(tchar)) {
                    return false;
                }
                //if the set doesnt have the value , this means the value (tchar) is new and was not mapped earlier
                //to any key present in the Hashmap.
                //so we can add it in the map as well as the set.
                map.put(schar, tchar);
                set.add(tchar);
            }
        }
        return true;
    }

    public static void main(String[] args){
        String s = "egg", t = "add";
        isomorphic p = new isomorphic();
        System.out.println(p.isIsomorphic(s,t));
    }
}