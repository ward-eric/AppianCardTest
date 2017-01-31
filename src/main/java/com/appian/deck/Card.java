package com.appian.deck;

import java.util.Objects;

/**
 * A representation of a playing card
 */
public class Card {
	private final Suit suit;
	private final FaceValue value;
	
	/**
	 * @param suit {@link Suit} of the card
	 * @param value {@link FaceValue} of the card
	 */
	public Card (Suit suit, FaceValue value) {
		this.suit = suit;
		this.value = value;
	}
	
	/**
	 * @return the suit of the card
	 */
	public Suit getSuit() {
		return suit;
	}
	
	/**
	 * @return the face value of the card
	 */
	public FaceValue getFaceValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value.name() + " of " + suit.name();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (suit != other.suit)
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }
}
