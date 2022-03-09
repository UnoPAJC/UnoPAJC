package unibs.pajc.uno.model.card;

/**
 * 
 * @author Stefano Valloncini, Ye Yuhang, Luigi Amarante
 *
 */
public class AbstractCard implements Card
{
	private final CardType type;
	private final CardColor color;

	private AbstractCard(CardType type, CardColor color)
	{
		this.type = type;
		this.color = color;
	}

	@Override
	public CardType getType()
	{
		return type;
	}

	@Override
	public CardColor getColor()
	{
		return color;
	}
}
