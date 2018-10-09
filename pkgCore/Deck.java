package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() throws DeckException {

		if (cardsInDeck.size() == 0)
		{
			throw new DeckException(this);
		}
		return cardsInDeck.remove(0);

	}

	public Card Draw(eSuit eSuit) {
		for (Card c : cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return (c);
			}
		}
		return (null);
	}

	public int getiDeckCount()
	{
		return cardsInDeck.size();
	}

	public Object getRemaining(Object eNum) {
		int suitcount=0;
		int rankcount=0;
		int returnval=0;
		if(eNum instanceof eSuit) {
			for (Card c : cardsInDeck) {
				if(c.geteSuit().equals(eNum)) {
					suitcount++;
				}
			}
			returnval = suitcount;
		}
		if(eNum instanceof eRank) {
			for (Card c : cardsInDeck) {
				if(c.geteRank().equals(eNum)) {
					rankcount++;
				}
			}
			returnval = rankcount;
		}
		return returnval;
	}
}