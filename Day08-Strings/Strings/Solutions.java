import java.util.Arrays;
import java.util.HashMap;

public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: Palindrome Checker ----
        String word = "madam";
        String reversedWord = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }
        boolean isPalindrome = word.equals(reversedWord);
        System.out.println(word + " reversed is " + reversedWord);
        System.out.println("Is palindrome? " + isPalindrome);
        System.out.println("---");

        // ---- Exercise 2: Count vowels and consonants ----
        String sentence = "Java is a fun language";
        int vowelCount = 0, consonantCount = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == ' ') continue; // skip spaces
            if (vowels.indexOf(ch) != -1) {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }
        System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonants: " + consonantCount);
        System.out.println("---");

        // ---- Exercise 3: Reverse each word in a sentence ----
        String sentence2 = "Java is fun";
        String[] words = sentence2.split(" ");
        StringBuilder result = new StringBuilder();
        for (String w : words) {
            String reversedW = "";
            for (int i = w.length() - 1; i >= 0; i--) {
                reversedW += w.charAt(i);
            }
            result.append(reversedW).append(" ");
        }
        System.out.println("Reversed words: " + result.toString().trim());
        System.out.println("---");

        // ---- Exercise 4: Anagram check ----
        String s1 = "listen";
        String s2 = "silent";
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);
        boolean isAnagram = Arrays.equals(s1Chars, s2Chars);
        System.out.println(s1 + " and " + s2 + " are anagrams? " + isAnagram);
        System.out.println("---");

        // ---- Exercise 5: Word frequency counter ----
        String text = "the cat sat on the mat the cat ran";
        String[] textWords = text.split(" ");
        HashMap<String, Integer> frequency = new HashMap<>();
        for (String w : textWords) {
            frequency.put(w, frequency.getOrDefault(w, 0) + 1);
        }
        System.out.println("Word frequencies:");
        for (String key : frequency.keySet()) {
            System.out.println(key + ": " + frequency.get(key));
        }
    }
}
