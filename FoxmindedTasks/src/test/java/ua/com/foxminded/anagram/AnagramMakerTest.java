package ua.com.foxminded.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AnagramMakerTest {
   private final AnagramMaker anagramMaker = new AnagramMaker();

   @Test
   public void makeAnagramShouldReturnSourceStringIfSentenceContainsOnlyNumbers() {
      String expected = "1234 5678";
      String actual = anagramMaker.makeAnagram("1234 5678");

      assertEquals(expected, actual);
   }

   @Test
   public void makeAnagramShouldReturnRevertedSymbolsIfSentenceContainsOnlyLetterSymbols() {
      String expected = "dcba hgfe";
      String actual = anagramMaker.makeAnagram("abcd efgh");

      assertEquals(expected, actual);
   }

   @Test
   public void makeAnagramShouldReturnRevertedLetterSymbolsAndNonLetterStayedInPlaceIfSentenceContainsMixedLetterAndNonLetterSymbols() {
      String expected = "d1cba hgf!e";
      String actual = anagramMaker.makeAnagram("a1bcd efg!h");

      assertEquals(expected, actual);
   }

   @Test
   public void makeAnagramShouldReturnSourceSymbolIfSourceStringIsOneSymbol() {
      String expected = "a";
      String actual = anagramMaker.makeAnagram("a");

      assertEquals(expected, actual);
   }

   @Test
   public void makeAnagramShouldReturnSourceStringIfWordContainsSameSymbols() {
      String expected = "aaaa";
      String actual = anagramMaker.makeAnagram("aaaa");

      assertEquals(expected, actual);
   }

   @Test
   public void makeAnagramShouldReturnRevertedSymbolsIfWordContainsLetterSymbols() {
      String expected = "abcd";
      String actual = anagramMaker.makeAnagram("dcba");

      assertEquals(expected, actual);
   }

   @Test
   public void makeAnagramShouldReturnNotRevertedSymbolsIfWordContainsNonLetterSymbols() {
      String expected = "!@#$%";
      String actual = anagramMaker.makeAnagram("!@#$%");

      assertEquals(expected, actual);
   }

   @Test
   public void makeAnagramShouldThrowExceptionIfSentenceIsEmptyString() {
      Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
         anagramMaker.makeAnagram("");
      });

      assertEquals("Sentence is empty or contains only tabulation symbols", exception.getMessage());
   }
   
   @Test
   public void makeAnagramShouldThrowExceptionIfSentenceConsistsOfTabulation() {
      Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
         anagramMaker.makeAnagram("    ");
      });

      assertEquals("Sentence is empty or contains only tabulation symbols", exception.getMessage());
   }
   
   @Test
   public void makeAnagramShouldThrowExceptionIfSentenceIsNull() {
      Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
         anagramMaker.makeAnagram(null);
      });

      assertEquals("Sentence is null", exception.getMessage());
   }

}
