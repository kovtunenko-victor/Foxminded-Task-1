package ua.com.foxminded.anagram;

public class AnagramMaker {
   private static final String WORDS_SEPARATOR = " ";
   
   public String makeAnagram(String sentence) {
      validate(sentence);
      
      final String[] words = sentence.split(WORDS_SEPARATOR);

      for (int i = 0; i < words.length; i++) {
         words[i] = reverseWord(words[i]);
      }

      return String.join(WORDS_SEPARATOR, words);
   }

   private void validate(String sentence) {
      if (sentence == null) {
         throw new IllegalArgumentException("Sentence is null");
      }
      if (sentence.trim().isEmpty()) {
         throw new IllegalArgumentException("Sentence is empty or contains only tabulation symbols");
      }
   }
   
   private boolean isSymbolValid (int indexLeftToRight, int indexRightToLeft, char symbol) {
      return indexLeftToRight < indexRightToLeft && !Character.isLetter(symbol);
   }

   private String reverseWord(String word) {
      final char[] symbols = word.toCharArray();

      int indexLeftToRight = 0;
      int indexRightToLeft = word.length() - 1;
      while (indexLeftToRight < indexRightToLeft) {
         while (isSymbolValid(indexLeftToRight, indexRightToLeft, word.charAt(indexLeftToRight))) {
            indexLeftToRight++;
         }
         while (isSymbolValid(indexLeftToRight, indexRightToLeft, word.charAt(indexRightToLeft))) {
            indexRightToLeft--;
         }
         char buffer = symbols[indexLeftToRight];
         symbols[indexLeftToRight] = symbols[indexRightToLeft];
         symbols[indexRightToLeft] = buffer;
         indexLeftToRight++;
         indexRightToLeft--;
      }

      return new String(symbols);
   }
}
