package com.appian.application;

import java.util.Optional;

import com.appian.deck.Card;
import com.appian.deck.Deck;

public class App {
	 public static void main(String[] args) {
		Deck deck = new Deck();
		
		deck.shuffle();

		Optional<Card> card = deck.dealOneCard();
		while (card.isPresent()) {
			System.out.println(card.get().toString());
			card = deck.dealOneCard();
		}
	}
}
