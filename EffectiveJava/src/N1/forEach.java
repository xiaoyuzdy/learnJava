package N1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * P184
 * 
 * @author he
 *
 */

enum Suit {
	CLUB, DIAMOND, HEART, SPADE
}

enum Rank {
	ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

class Card {
	private Suit suit;
	private Rank rank;

	public Card(Suit suit2, Rank rank2) {
		this.suit = suit2;
		this.rank = rank2;
	}
}

public class forEach {
	public static void main(String[] args) {
		Collection<Suit> suits = Arrays.asList(Suit.values());
		Collection<Rank> ranks = Arrays.asList(Rank.values());

		List<Card> deck = new ArrayList<Card>();
		for (Iterator<Suit> i = suits.iterator(); i.hasNext();)
			for (Iterator<Rank> j = ranks.iterator(); j.hasNext();)
				/*******************************************************************
				 * 这里有bug，应为在new Card()时，会不断的调用i.next,而枚举类Suit中的元素数量明显少于枚举类
				 * Rank中的元素数量，这将导致Suit中的元素已经没有了，而Rank中的元素还有会出现异常
				 * java.util.NoSuchElementException
				 * 
				 *******************************************************************/
				deck.add(new Card(i.next(), j.next()));

		/**
		 * for-each正确
		 */
		// for(Suit suit:suits)
		// for(Rank rank:ranks)
		// deck.add(new Card(suit, rank));

	}

}
