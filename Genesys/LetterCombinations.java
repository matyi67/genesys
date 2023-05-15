import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



    public class LetterCombinations {
        
        private static final Map<Character, String> digitToLetters = new HashMap<>();

        static {
            digitToLetters.put('2', "abc");
            digitToLetters.put('3', "def");
            digitToLetters.put('4', "ghi");
            digitToLetters.put('5', "jkl");
            digitToLetters.put('6', "mno");
            digitToLetters.put('7', "pqrs");
            digitToLetters.put('8', "tuv");
            digitToLetters.put('9', "wxyz");
        }
    
        public List<String> letterCombinations(String digits) {
            List<String> combinations = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
                return combinations;
            }
            backtrack(combinations, new StringBuilder(), digits, 0);
            Collections.sort(combinations); // Sort the combinations in ascending order
            return combinations;
        }
    
        private void backtrack(List<String> combinations, StringBuilder current, String digits, int index) {
            if (index == digits.length()) {
                combinations.add(current.toString());
                return;
            }
    
            char digit = digits.charAt(index);
            String letters = digitToLetters.get(digit);
    
            for (int i = 0; i < letters.length(); i++) {
                current.append(letters.charAt(i));
                backtrack(combinations, current, digits, index + 1);
                current.deleteCharAt(current.length() - 1);
            }
        }
        public static void main(String[] args) {
            LetterCombinations letterCombinations = new LetterCombinations();
    
            String digits = "23";
            List<String> combinations = letterCombinations.letterCombinations(digits);
            System.out.println(combinations);
    
            digits = "";
            combinations = letterCombinations.letterCombinations(digits);
            System.out.println(combinations);
    
            digits = "2";
            combinations = letterCombinations.letterCombinations(digits);
            System.out.println(combinations);
        }
    }  
         

