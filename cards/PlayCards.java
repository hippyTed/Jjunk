package cards;

public class PlayCards {
	
	public static void main(String[] args) {
		final int PLAYERS = 4;
		final int SHUFFLE_COUNT = 100;
		
		Deck deck = new Deck();
		deck.shuffle(SHUFFLE_COUNT);
		deck.cut();
		
		int cardsEach = Deck.cardsInDeck/PLAYERS;
		Hand[] hand = new Hand[PLAYERS];
		
		for (int h = 0; h < PLAYERS; h++) 
			hand[h] = new Hand(cardsEach);
		
		for (int i = 0; i < cardsEach; i++)
			for (Hand h: hand)
				h.addCard(deck.deal());
		
		for (int player = 0; player < PLAYERS; player++) {
			System.out.println("\nPlayer" + (player+1) 
				+ " has " + hand[player].cards.size()
				+ " cards, totalling " + hand[player].total());
			hand[player].print();
		}
	}
}
