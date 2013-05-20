package cardplay;

public final class Card {
	enum Rank {Two, Three, Four, Five, Six, Seven,
				Eight, Nine, Ten, Jack, Queen, King, Ace};
	enum Suit {Club, Diamond, Heart, Spade};
	
	Rank rank;
	Suit suit;
	
	Card(Card c) {
		rank = c.rank;
		suit = c.suit;
	}
	
	Card(Rank r, Suit s) {
		rank = r;
		suit = s;
	}
	
	public final boolean isEqual(Card c) {
		return rank == c.rank && suit == c.suit;
	}
	
	public int compareTo(Card c) {
		int suitComp = suit.compareTo(c.suit);
		
		if (suitComp == 0) 
			return rank.compareTo(c.rank);
		else
			return suitComp;
	}
	
	public final void print() {
		System.out.println(rank.toString() + " of " + suit.toString() + "s");
	}
	
}