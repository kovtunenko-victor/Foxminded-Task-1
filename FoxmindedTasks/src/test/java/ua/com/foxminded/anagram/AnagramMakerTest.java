package ua.com.foxminded.anagram;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AnagramMakerTest {
   @Rule
   public ExpectedException thrown = ExpectedException.none();

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
      thrown.expect(IllegalArgumentException.class);
      thrown.expectMessage(is("Sentence is empty or contains only tabulation symbols"));
      
      anagramMaker.makeAnagram("");
   }
   
   @Test
   public void makeAnagramShouldThrowExceptionIfSentenceConsistsOfTabulation() {
      thrown.expect(IllegalArgumentException.class);
      thrown.expectMessage(is("Sentence is empty or contains only tabulation symbols"));
      
      anagramMaker.makeAnagram("    ");
   }

   @Test
   public void makeAnagramShouldThrowExceptionIfSentenceIsNull() {
      thrown.expect(IllegalArgumentException.class);
      thrown.expectMessage(is("Sentence is null"));
      
      anagramMaker.makeAnagram(null);
   }
}
