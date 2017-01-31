package com.appian.deck;

import org.junit.Test;

import com.appian.deck.Card;
import com.appian.deck.FaceValue;
import com.appian.deck.Suit;

import org.junit.Assert;

public class CardTest {
	@Test
	public void shouldBeEqual() {
		Card firstCard = new Card(Suit.Spades, FaceValue.Ace);
		Card secondCard = new Card(Suit.Spades, FaceValue.Ace);
		
		Assert.assertTrue(firstCard.equals(secondCard));
	}
	
	@Test
	public void shouldNotBeEqual() {
		Card firstCard = new Card(Suit.Spades, FaceValue.Ace);
		Card secondCard = new Card(Suit.Clubs, FaceValue.Two);
		
		Assert.assertFalse(firstCard.equals(secondCard));
	}
	
	@Test
	public void shouldHaveSameHash() {
		Card firstCard = new Card(Suit.Spades, FaceValue.Ace);
		Card secondCard = new Card(Suit.Spades, FaceValue.Ace);
		
		Assert.assertEquals(firstCard.hashCode(), secondCard.hashCode());
	}
	
	@Test
	public void shouldHaveDifferentHash() {
		Card firstCard = new Card(Suit.Spades, FaceValue.Ace);
		Card secondCard = new Card(Suit.Clubs, FaceValue.Two);
		
		Assert.assertNotEquals(firstCard.hashCode(), secondCard.hashCode());
	}
}
