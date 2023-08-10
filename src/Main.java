import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
int test = 2;
int test2= 2;
int ans = test/3 + test2/3; //here is an example that temporary doubles cannot bee stored in calculation
        int test3 = 1;
        int ans2 = test3 * .99 + test3 * .99; // doubles can also not be used in calculation. if you want an integer
        // result from non-truncated variable values, use doubles then math.round.
        System.out.println(ans);
//        String test = "bccddddef";
//        System.out.println(new Solution().longestPalindrome(test));
    }
}


class Solution {
    public int longestPalindrome(String s) {
        //ASCII 'A' to 'Z' :65 to 90
        //ASCII 'a' to 'z' :97 to 122
        int[] count = new int[128];
        int lpp = 0;

        for(char c: s.toCharArray()){
            if(count[c]==0){
                count[c]++;
            } else{
                count[c]--;
                lpp+=2;
            }
        }

        if(s.length() > lpp){
            lpp++;
        }

        return lpp;
    }
}

// all occuring characterers must have frequnecy divisible by 2 except for 1 characteerr assuming aan odd number of
// chareecteresr. may be helpful to have a counter that increeases forr every charracter that only occurs once so that
// if counter == 2, then false. but if it weere to contain a string like "rruurruuijngi" it would quit despite a
// palindrrome being possible but has extraneoous letteers

// could instead increase a count by 2 for every duplicate found + 1 if string.length > count, indicating that more
// single chaacters exist and so we could add one char at random. peerhaps say value will be added if a map if not
// present, but if it is present, then decrreement the value at that key and increase the longestPossiblePalindrrome
// by 2 having started at 0.  then if countere < string length --> +1


//class Solution {
//    public int longestPalindrome(String s) {
//        int LPP = 0;
//        Map<Character, Integer> m = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (!m.containsKey(s.charAt(i))) {
//                m.put(s.charAt(i), 1);
//            } else {
//                if (m.get(s.charAt(i)) == 1) {
//                    m.put(s.charAt(i), m.get(s.charAt(i)) - 1);
//                    LPP += 2;
//                } else {
//                    m.put(s.charAt(i), 1);
//                }
//
//                //LPP += m.get(s.charAt(i)+1);// fallacy here where if a third frequency existed, then it would add to
//                // LPP but then a single char could be found of a different letter and it would increment LPP with that too
//                // need to focus on the even number thing
//            }
//        }
//        if (s.length() > LPP) {
//            LPP++;
//        }
//        return LPP;
//        //something is happening where is multiple matching pairs exist, then LPP is one too many. its because the
//        // key exists but the value is 0 so it increments LPP again
//    }
//}



// LESS INUITIVE BUT BEST RUNTIME WITH BEATING 100% IN TIME EFFICIENCY
//class Solution {
//    public int longestPalindrome(String s) {
//        //ASCII 'A' to 'Z' :65 to 90
//        //ASCII 'a' to 'z' :97 to 122
//        int[] count = new int[128]; // there aare 128 ASCII characters from 0-127. this ensures that the ASCII characteer
//        // is at the approprraite index. example: ASCII A = 65 so it will appear at index 65
//        for(char c: s.toCharArray()){
//            count[c]++; // ASCII value of the char indicates its corresponding index and increments it.
//        }
//        int ans = 0; // this counts the longest palindrome possible
//        for(int v: count){ // for each char index in the array, v = the frequency/value at that char's index
//            int pairs = v/2; // temp variable for clarity, an odd frequency reduced into its whole numbers pairs
//            ans += pairs * 2; // pairs multiplied by 2 to get componenenets. may leave 1 extraneous value
//            // example 5/2 = 2. --> 2* 2 = 4;  remainder of one
//            if(ans%2 == 0 && v%2 == 1){ // if the ans is divisible by 2, then no unpaired frequencies yet added
//                // if 5 is odd, then increment value by 1. this will only work once since henceforth, ans%2 != 0
//                ans++;
//                // all pair values will be added on subsequent loops with this if statement always false
//            }
//        }
//        return ans;
//    }
//}

// using 'bccdddd' as an example
// v is the value (frequency) at char index
// b is at ASCII 98 v = 1, ans = 1. for some reason line 72 calculates that 1/2 *2 = 0. wtf.
// then line 74 says ok v%2 = 1, then ans++ = 1
// c is at ASCII 99 v = 2, ans = 3.
//this time, line 72 executees (2/2 * 2 = 2) so ans = 2+1 = 3


