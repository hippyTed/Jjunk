package cardplay;

public class PlayCards {
	
	public static void main(String[] args) {
		int PLAYERS = 4;
		int SHUFFLE_COUNT = 50;
		
		Deck cards = new Deck();
		cards.shuffle(SHUFFLE_COUNT);
		cards.cut();

		int cardsEach = Deck.cardsInDeck/PLAYERS;
		Hand[] hand = new Hand[PLAYERS];
		
		for (int h = 0; h < PLAYERS; h++) 
			hand[h] = new Hand(cardsEach);
		
		for (int i = 0; i < cardsEach; i++) {
			for (int player = 0; player < PLAYERS; player++) {
				Card c = cards.deal();
				hand[player].addCard(c);
			}
		}
		
		for (int player = 0; player < PLAYERS; player++) {
			System.out.println("\nPlayer" + (player+1) 
					+ " has " + hand[player].sizeOf() + " cards:");
			hand[player].print();
		}
	}
}