package cards;

public class Card {
	// How to add 2 Jokers?
	protected static enum Rank {Two, Three, Four, Five, Six, Seven,
				Eight, Nine, Ten, Jack, Queen, King, Ace};
	protected static enum Suit {Club, Diamond, Heart, Spade};
	
	private Rank rank;
	private Suit suit;
	
	Card(Card c) {
		rank = c.rank;
		suit = c.suit;
	}
	
	Card(Rank r, Suit s) {
		rank = r;
		suit = s;
	}
	
	protected final boolean isEqual(Card c) {
		return rank == c.rank && suit == c.suit;
	}
	
	protected int compareTo(Card c) {
		int suitComp = suit.compareTo(c.suit);
		
		return (suitComp == 0)? rank.compareTo(c.rank): suitComp;
	}
	
	protected int value() {
		return 13*suit.ordinal() + rank.ordinal() + 1;
	}
	
	public final void print() {
		System.out.println(rank.toString() + " of " + suit.toString() + "s");
	}	
}
