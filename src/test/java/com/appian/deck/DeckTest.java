package com.appian.deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.appian.deck.Card;
import com.appian.deck.Deck;

public class DeckTest {
	@Test
	public void shouldRemoveCardFromDeck() {
		Deck deck = new Deck();
		Optional<Card> card = deck.dealOneCard();
		Assert.assertTrue(card.isPresent());

		Assert.assertFalse(deck.getCardList().contains(card.get()));
	}
	
	@Test
	public void shouldReturnOnlyFiftyTwoCards() {
		Deck deck = new Deck();
		
		for (int i = 0; i < 52; i++) {
			Optional<Card> card = deck.dealOneCard();
			Assert.assertTrue(card.isPresent());
		}
		
		Assert.assertFalse(deck.dealOneCard().isPresent());
	}
	
	@Test
	public void shouldContainSameCardsWhenShuffled() {
		Deck deck = new Deck();
		List<Card> originalCards = new ArrayList<Card>(deck.getCardList());
		
		deck.shuffle();

		Assert.assertTrue(deck.getCardList().containsAll(originalCards));
	}
	
	@Test
	public void shouldStillShuffleWithAfterDealingCards() {
		Deck deck = new Deck();
		for (int i = 0; i < 10; i++) {
			deck.dealOneCard();
		}
		
		List<Card> originalCards = new ArrayList<Card>(deck.getCardList());
		
		deck.shuffle();

		Assert.assertTrue(deck.getCardList().containsAll(originalCards));
	}
}
