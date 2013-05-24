package displaycards;

import displaycards.Deck;

public class PlayCards {

	public static final int PLAYERS = 4;
	public static final int SHUFFLE_COUNT = 100;

	public Deck deck;
	public static Hand[] hand;

	PlayCards() {
		deck = new Deck();
		hand = new Hand[PLAYERS];
	}

	public void dealCards(int players) {
		int cardsEach = Card.cardsInDeck/players;

		deck.shuffle(SHUFFLE_COUNT);
		deck.cut();

		for (int h = 0; h < players; h++) 
			hand[h] = new Hand(cardsEach);

		for (int i = 0; i < cardsEach; i++)
			for (Hand h: hand)
				h.addCard(deck.deal());
	}	
}
