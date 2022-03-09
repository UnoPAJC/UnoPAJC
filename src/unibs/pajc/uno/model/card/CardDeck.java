package unibs.pajc.uno.model.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck
{
	private final List<Card> cards = new ArrayList<>(108);

	public CardDeck()
	{
		createCards();
	}

	public List<Card> getImmutableCards()
	{
		return Collections.unmodifiableList(cards);
	}

	/**
	 * Calls method to call cards creators
	 */
	private void createCards()
	{
		createNumberCards();
		createActionCards();
		createWildCards();
	}

	/**
	 * Method to create all cards representing a number
	 */
	private void createNumberCards()
	{
		for (CardColor color : CardColor.values())
		{
			cards.add(new NumberCard(0, color));

			for (int i = 1; i <= 9; i++)
			{
				cards.add(new NumberCard(i, color));
				cards.add(new NumberCard(i, color));
			}
		}
	}

	/**
	 * Method to create action cards
	 */
	private void createActionCards()
	{
		for (CardColor color : CardColor.values())
		{
			for (var i = 0; i < 2; i++)
			{
				cards.add(new ActionCard(CardType.SKIP, color));
				cards.add(new ActionCard(CardType.REVERSE, color));
				cards.add(new ActionCard(CardType.DRAW_TWO, color));
			}
		}
	}

	/**
	 * Method to create WildCards
	 */
	private void createWildCards()
	{
		for (int i = 0; i < 4; i++)
		{
			cards.add(new WildCard(CardType.WILD_COLOR));
			cards.add(new WildCard(CardType.WILD_DRAW_FOUR));
		}
	}
}
