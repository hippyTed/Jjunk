package displaycards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import displaycards.Card.Rank;
import displaycards.Card.Suit;

public final class Deck extends Cards {
	private static Random rand = new Random();

	public Deck() {
		super(Card.cardsInDeck);
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
		int firstHalf = cards.size()/4 + rand.nextInt(cards.size()/2);

		List<Card> list = cards.subList(firstHalf, cards.size());
		list.addAll(cards.subList(0, firstHalf));
		
		cards = new ArrayList<Card>(list);
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
