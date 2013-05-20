package cardplay;

public class Hand {
	private Card[] hand = null;
	private int cardsInHand = 0;
	
	public Hand(int size) {
		hand = new Card[size];
		cardsInHand = 0;
	}
	
	public int sizeOf() {
		return cardsInHand;
	}

	public void addCard(Card c) {
		if (cardsInHand < hand.length) {
			int where = 0;
			for (where = 0; where < cardsInHand; where++)
				if (hand[where].compareTo(c) > 0)
					break;
			
			for (int i = cardsInHand; i > where; i--)
				hand[i] = hand[i-1];
			
			hand[where] = new Card(c);
			cardsInHand++;
		}
		else 
			System.out.println("Hand already has " + hand.length + " cards!");
	}
	
	private int findCard(Card c) {
		for (int i = 0; i < cardsInHand; i++) {
			if (hand[i].isEqual(c)) 
				return i;
		}
		return -1;
	}
	
	public void deleteCard(Card c) {
		int i = findCard(c);
		if (i >= 0) {
			for (int j = i; j < cardsInHand-2; j++)
				hand[j] = hand[j+1];
			hand[cardsInHand-1] = null;
			cardsInHand--;
		}
		else 
			System.out.println("I don't have a " + c.toString() + "!");
	}
	
	void print() {
		for (Card c: hand)
			c.print();
	}
}