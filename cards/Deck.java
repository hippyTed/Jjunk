package cards;

import java.util.ArrayList;
import java.util.Random;
import cards.Card.Rank;
import cards.Card.Suit;

public final class Deck extends Cards {
	public static final int cardsInDeck = 52;
	private static Random rand = new Random();

	public Deck() {
		super(cardsInDeck);
		for (Suit s: Suit.values())
			for (Rank r: Rank.values())
				cards.add(new Card(r, s));
	}

	public void shuffle(int count) {
		int halfCards = cards.size()/2;
		
		for (int i = 0; i < count; i++) {			
			int c1 = rand.nextInt(halfCards);
			int c2 = rand.nextInt(halfCards) + halfCards;
			
			swap(c1, c2);
			if ((i+1)%10 == 0)
				cut();
		}
	}

	public void cut() {
		ArrayList<Card> newCards = new ArrayList<Card>(cards.size());
		int firstHalf = cards.size()/4 + rand.nextInt(cards.size()/2);

		for (int i = firstHalf; i < cards.size(); i++)
			newCards.add(cards.remove(i));
		while (cards.size() > 0) 
			newCards.add(cards.remove(0));
		
		cards = newCards;
	}
	
	public Card deal() {
		if (cards.size() > 0)
			return cards.remove(0);
		else {
			System.out.println("The deck is empty!");
			return null;
		}
	}
}