package cardplay;

public class Hand {
	private Card[] hand = null;
	private int maxCards = 0;
	private int cardsLeft = 0;
	
	public Hand(int size) {
		hand = new Card[size];
		maxCards = size;
		cardsLeft = 0;
	}
	
	public int sizeOf() {
		return cardsLeft;
	}

	public void addCard(Card c) {
		if (cardsLeft < maxCards) {
			int where = 0;
			for (where = 0; where < cardsLeft; where++)
				if (hand[where].compareTo(c) > 0)
					break;
			
			for (int i = cardsLeft; i > where; i--)
				hand[i] = hand[i - 1];
			
			hand[where] = new Card(c);
			cardsLeft++;
		}
		else 
			System.out.println("My hand already has " 
				+ cardsLeft + "/" + maxCards + " cards!");
	}
	
	private int findCard(Card c) {
		for (int i = 0; i < cardsLeft; i++) {
			if (hand[i].isEqual(c)) 
				return i;
		}
		return -1;
	}
	
	public void deleteCard(Card c) {
		int i = findCard(c);
		if (i >= 0) {
			for (int j = i; j < cardsLeft-2; j++)
				hand[j] = hand[j+1];
			hand[cardsLeft-1] = null;
			cardsLeft--;
		}
		else 
			System.out.println("I don't have a " + c.toString() + "!");
	}
	
	void print() {
		for (Card c: hand)
			c.print();
	}
}