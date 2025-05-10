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

  public static class Card {
     private final String name;
     private final String suit;
     private final int value;


     public Card(String name, String suit, int value) {
      this.name = name;
      this.suit = suit;
      this.value = value;
     }

     public String getName() {
      return name;
     }

     public String getSuit() {
      return suit;
     }

     public int getValue() {
      return value;
     }

     @Override
     public String toString() {
     return name + " of " + suit;
     }


     @Override
     public boolean equals(Object obj) {
      if (!(obj instanceof Card)) return false;
      Card other = (Card) obj;
      return name.equals(other.name) && suit.equals(other.suit) && value == other.value;
       }

    }

     public static class Deck {
      private final List<Card> cards;
   
      public Deck() {
    cards = new ArrayList<>();
     String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
      String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
      for (String suit : suits) {
    for (int i = 0; i < names.length; i++) {
     cards.add(new Card(names[i], suit, i + 1));
           }
        }
     }

      public void shuffle() {
        Collections.shuffle(cards);
     }

     public Card draw() {
      if (!cards.isEmpty()) return cards.remove(0);
      return null;
     }

     public void add(Card card) {
      cards.add(card);
     }

     public int size() {
      return cards.size();
       }
    }

    public static class DiscardPile {
        private final List<Card> pile = new ArrayList<>();

        public void discard(Card card) {
            pile.add(card);
        }
    }

    public static class Player {
        private final String name;
        private final List<Card> hand;

        public Player(String name) {
            this.name = name;
            this.hand = new ArrayList<>();
        }

        public int size() {
            return hand.size();
        }

        public void draw(Deck deck) {
            Card card = deck.draw();
            if (card != null) hand.add(card);
        }

        public boolean discard(Card card, DiscardPile pile) {
            if (hand.remove(card)) {
                pile.discard(card);
                return true;
            }
            return false;
        }

        public boolean returnCard(Card card, Deck deck) {
            if (hand.remove(card)) {
                deck.add(card);
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
      StringBuilder sb = new StringBuilder(name + ", " + hand.size() + ", ");
            for (Card card : hand) sb.append(card.toString()).append(", ");
            return sb.toString().trim();
        }
    }

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
   public void testDeckInitialization()
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
 public static class DiscardPile {
        private final List<Card> pile = new ArrayList<>();

        public void discard(Card card) {
            pile.add(card);
        }
    }

    public static class Player {
        private final String name;
        private final List<Card> hand;

        public Player(String name) {
            this.name = name;
            this.hand = new ArrayList<>();
        }

        public int size() {
            return hand.size();
        }

        public void draw(Deck deck) {
            Card card = deck.draw();
            if (card != null) hand.add(card);
        }

        public boolean discard(Card card, DiscardPile pile) {
            if (hand.remove(card)) {
                pile.discard(card);
                return true;
            }
            return false;
        }

        public boolean returnCard(Card card, Deck deck) {
            if (hand.remove(card)) {
                deck.add(card);
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(name + ", " + hand.size() + ", ");
            for (Card card : hand) sb.append(card.toString()).append(", ");
            return sb.toString().trim();
        }
    }
