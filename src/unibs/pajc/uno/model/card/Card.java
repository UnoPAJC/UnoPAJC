package unibs.pajc.uno.model.card;

import java.io.Serializable;

/**
 * 
 * @author Stefano Valloncini, Ye Yuhang, Luigi Amarante
 *
 *         Card interface. Every card has a type and a color (enums)
 */
public interface Card extends Serializable
{
	CardType getType();

	CardColor getColor();
}
