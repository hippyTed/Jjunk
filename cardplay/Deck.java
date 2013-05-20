package cardplay;

import java.util.Random;
import cardplay.Card.Rank;
import cardplay.Card.Suit;

public class Deck {
	public static final int cardsInDeck = 52;
	private int cardsLeft = 0;
	private Card[] deck = null;
	private Random rand = new Random();
	
	public Deck() {
		deck = new Card[cardsInDeck];
		cardsLeft = 0;
		for (Suit s: Suit.values()) {
			for (Rank r: Rank.values()) {
				deck[cardsLeft] = new Card(r, s);
				cardsLeft++;
			}
		}
	}

	public void shuffle(int count) {
		int halfCards = cardsLeft/2;
		
		for (int i = 0; i < count; i++) {
			if ((i + 1)%10 == 0)
				cut();
	
			int c1 = rand.nextInt(halfCards);
			int c2 = rand.nextInt(halfCards) + halfCards;

			Card c = deck[c1];
			deck[c1] = deck[c2];
			deck[c2] = c;
		}
	}

	public void cut() {
		Card[] newDeck = new Card[cardsInDeck];
		int firstHalf = cardsInDeck/4 + rand.nextInt(cardsInDeck/2);
		int secondHalf = cardsInDeck - firstHalf;
		
		for (int i = 0; i < secondHalf; i++) 
			newDeck[i] = deck[firstHalf + i];
		
		for (int i = 0; i < firstHalf; i++)
			newDeck[secondHalf + i] = deck[i];

		deck = newDeck;
	}
	
	public Card deal() {
		if (cardsLeft > 0) {
			Card c = deck[cardsLeft - 1];
			cardsLeft--;
			return c;
		}
		else {
			System.out.println("The deck is empty");
			return null;
		}
	}
		
	public void print() {
		for (Card c: deck) {
			c.print();
		}
	}
}
