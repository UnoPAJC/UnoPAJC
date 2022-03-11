package unibs.pajc.uno.model.card;

import java.util.Objects;

/**
 * 
 * @author Stefano Valloncini, Ye Yuhang, Luigi Amarante
 * 
 *         Class defining pecial cards, extends AbstractCard
 *
 */
public class ActionCard extends AbstractCard
{
	public ActionCard(CardType type, CardColor color)
	{
		super(type, color);
		CardUtil.validateActionType(type);
		CardUtil.validateColor(color);
	}

	@Override
	public boolean equals(Object object)
	{
		if (this == object)
		{
			return true;
		}
		if (object == null || getClass() != object.getClass())
		{
			return false;
		}
		ActionCard theActionCard = (ActionCard) object;

		return getType() == theActionCard.getType() && getColor() == theActionCard.getColor();
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(getType(), getColor());
	}

	@Override
	public String toString()
	{
		return "ActionCard{" + getType() + ", " + getColor() + '}';
	}
}
