package displaycards;

import java.util.ArrayList;

import displaycards.Card.Suit;

abstract class Cards {
	public ArrayList<Card> cards;

	Cards(int maxNumber) {
		cards = new ArrayList<Card>(maxNumber);
	}
	
	protected void swap(int index1, int index2) {
		Card c = cards.get(index1);
		cards.set(index1, cards.get(index2));
		cards.set(index2, c);
	}

	public int getTotal() {
		int total = 0;
		for (Card c: cards)
			total += c.value();
		return total;
	}
	
	public String toString() {
		if (cards.size() == 0)
			return "";
		
		StringBuilder sb = new StringBuilder();
		Suit suit = cards.get(0).getSuit();
		sb.append(suit.getName());
		for (int index = 0; index < cards.size(); index++) {
			Card c = cards.get(index);
			if (c.getSuit() != suit) {
				suit = c.getSuit();
				sb.append("\n" + suit.getName());
			}
			sb.append(" " + c.getRank().getName());
		}
		return sb.toString();
	}
	
	public void print() {
		for (Card c: cards)
			c.print();
	}
}
