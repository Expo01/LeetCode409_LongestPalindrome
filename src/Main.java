import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String test = "bccddddef";
        System.out.println(new Solution().longestPalindrome(test));
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
class Solution {
    public int longestPalindrome(String s) {
        //ASCII 'A' to 'Z' :65 to 90
        //ASCII 'a' to 'z' :97 to 122
        int counter = 0;//fluff
        int[] count = new int[128]; // there aare 128 ASCII characters from 0-127. this ensures that the ASCII characteer
        // is at the approprraite index. example: ASCII A = 65 starts so it will appear at index 65
        for(char c: s.toCharArray()){
            count[c]++; // char is used as the index instead of the value and it increments the value at th char index
            // for example, count['b'] = 0. then count['b']++ meeans that count[b] = 1;
        }
        int ans = 0; // this counts the longest palindrome possible
        for(int v: count){ // for each char index in the array
           counter++;//fluff
            System.out.println("is v " + v);//fluff
            System.out.println("is ans 1 = " + ans);
            ans += v/2 *2; // what the heck am i not understanding about order of operations here?
            // on the first occurence where v=1 and ans = 0 --> ans += 1/2 * 2. Is this not 0.5 * 2 = 1?
            // how is it 0? what's the point?
            System.out.println("is ans 2 = " + ans);//fluff
            if(ans%2 == 0 && v%2 == 1){
                ans++;
                System.out.println("is ans 3 = " + ans);//fluff
            }
            System.out.println(counter);
            // using 'bccdddd' as an example
                // v is the value (frequency) at char index
                // b is at ASCII 98 v = 1, ans = 1. for some reason line 72 calculates that 1/2 *2 = 0. wtf.
                    // then line 74 says ok v%2 = 1, then ans++ = 1
                // c is at ASCII 99 v = 2, ans = 3.
                    //this time, line 72 executees (2/2 * 2 = 2) so ans = 2+1 = 3
                // d is at ASCII 100 v = 4, ans = 7
                    // line 72 executes again ans+= (4/2 * 2 = 4) so ans = 3+4 = 7
                // all other ASCII values empty, v = 0, ans = 7
                // it appears that line 74 can only execute once where ans can be incremented by 1
                // only if ans is currently even and the char index has an odd frequency value such that
                // an occurence of 3 for the char 'b' would ans += 2, then because ans is divisible by 2
                // and the frequency is odd at char 'b', this one time execution happens
        }
        return ans;
    }
}


