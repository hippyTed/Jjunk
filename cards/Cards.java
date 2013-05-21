package cards;

import java.util.ArrayList;

abstract class Cards {
	protected ArrayList<Card> cards;

	Cards(int maxNumber) {
		cards = new ArrayList<Card>(maxNumber);
	}
	
	protected void swap(int index1, int index2) {
		Card c = cards.get(index1);
		cards.set(index1, cards.get(index2));
		cards.set(index2, c);
	}

	public int total() {
		int total = 0;
		for (Card c: cards)
			total += c.value();
		return total;
	}
	
	protected void print() {
		for (Card c: cards)
			c.print();
	}
}