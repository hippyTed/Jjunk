package cards;

public final class Hand extends Cards {
	private int fullHand = 0;
	
	public Hand(int size) {
		super(size);
		fullHand = size;
	}
	
	public void addCard(Card c) {
		if (cards.size() < fullHand) {
			// keep them sorted
			int where = 0;
			for (where = 0; where < cards.size(); where++)
				if (cards.get(where).compareTo(c) > 0)
					break;
			cards.add(where, c);
		}
		else 
			System.out.println("I already have a full hand!");
	}
	
	public void deleteCard(Card c) {
		if (cards.size() > 0) {
			int i;
			if ((i = cards.indexOf(c)) >= 0) 
				cards.remove(i);
			else 
				System.out.println("I don't have a " + c.toString() + "!");
		}
		else 
			System.out.println("My hand is already empty!");
	}
}
