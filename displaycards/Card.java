package displaycards;

import java.awt.Color;

public class Card implements Comparable<Card> {

	public static final int cardsInDeck = 52;

	// How to add 2 Jokers?
	public static enum Rank {
		Two("2"), Three("3"), Four("4"), Five("5"), Six("6"), Seven("7"),
		Eight("8"), Nine("9"), Ten("10"), Jack("J"), Queen("Q"), King("K"), Ace("A");

		private String rank;

		private Rank(String r) { rank = r; }
		
		public String getName() { return rank; }
	}
	
	public static enum Suit {	// Unicode symbols
		Club("\u2663"), Diamond("\u2666"), Heart("\u2665"), Spade("\u2660");
		
		private String name;
		
		private Suit(String s) { name = s; }
		
		public String getName() { return name; }
		public Color getColour() {
			return (this == Club || this == Spade)? Color.BLACK: Color.RED;
		}
	}

	private Rank rank;
	private Suit suit;
	
	public Card(Card c) {
		rank = c.rank;
		suit = c.suit;
	}
	
	public Card(Rank r, Suit s) {
		rank = r;
		suit = s;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public boolean isEqual(Card c) {
		return rank == c.rank && suit == c.suit;
	}

	public int compareTo(Card c) {
		int suitComp = suit.compareTo(c.suit);
		return (suitComp == 0)? rank.compareTo(c.rank): suitComp;
	}
	
	public String toString() {
		return suit.getName() + rank.getName();
	}
	
	protected int value() {
		return 13*suit.ordinal() + rank.ordinal();
	}
	
	public void print() {
		System.out.println(this);
	}
}
