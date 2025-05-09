//don't forget to import anything else you need (ArrayLists, HashMaps, Scanners, etc)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.beans.Transient;
import java.io.*;

import javax.smartcardio.Card;

public class ProblemSetTest {

   //Create your tests here if you want any

   /*

   //Example Test
   
   @Test
   public void exampleTest()
   {
      Cat cat = new Cat();
      assertEquals("whiskers", cat.getName());
   }
   */

@Test
public void testCardGetters()
{
   Card card = new Card ("Queen", "Diamonds", 12);
      assertEquals("Queen", card.getName());
      assertEquals("Diamonds", card.getSuit());
      assertEquals(12,card.getValue());
   }

   @Test
   public void testCardToString()
   {
      Card card = new Card(" Ace", "Hearts", 14);
       assertEquals("Ace of Hearts", card.toString());
   }

   @Test
   public void testCardEquals()
   {
       Card card1 = new Card("10","Clubs",10);
       Card card2 = new Card("10","Clubs",10);
       Card card3 = new Card("9","Clubs",9);
   
   assertTrue(card1.equals(card2));

   assertFalse(card1.equals(card3));
   }

   @Test 
   public void
testDeckInitialization()
   {
      Deck deck = new Deck();
      assertEquals(52,deck.size());
      assertFalse(deck.isEmpty());
         }
   @Test 
   public void testDeckDrawCard()
   {
      Deck deck = new Deck();
      Card card = deck.drawCard();
      assertNotNull(card);
      assertEquals(51,deck.size());
   }
}
