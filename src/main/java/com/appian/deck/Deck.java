package com.appian.deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * A representation of a 52-{@link Card} deck
 */
public class Deck {
	private List<Card> deckList;
	
	/**
	 * Construct a deck containing 52-cards.
	 * <ul>
	 * <li>Four suits: Clubs, Hearts, Spades, Diamonds
	 * <li>Thirteen face values: Ace, 2-10, Jack, Queen, and King
	 * </ul>
	 */
	public Deck() {
		deckList = new ArrayList<Card>();
		
		for (Suit suit : Suit.values()) {
			for (FaceValue value : FaceValue.values()) {
				deckList.add(new Card(suit, value));
			}
		}
	}
	
	/**
	 * Shuffle the remaining cards in the deck.
	 */
	public void shuffle() {
		for (int i = deckList.size() - 1; i > 0; i--)
		{
			int rand = ThreadLocalRandom.current().nextInt(i + 1);
			deckList.set(i, deckList.set(rand, deckList.get(i)));
		}
	}
	
	
	/**
	 * Removes the top card from the deck and returns it
	 * @return {@link java.util.Optional} when the deck is non-empty,
	 * {@link java.util.Optional#EMPTY} otherwise
	 */
	public Optional<Card> dealOneCard() {
		return deckList.isEmpty() ? Optional.empty() : Optional.of(deckList.remove(0));
	}
	
	/**
	 * @return the {@link java.util.List} of cards in the deck
	 */
	public List<Card> getCardList() {
		return deckList;
	}
	
	@Override
	public String toString() {
		if (deckList.isEmpty()) {
			return "The deck is empty.";
		}

		return deckList
			.stream()
			.map(card -> card.toString())
			.collect(Collectors.joining(", "));
	}
}
