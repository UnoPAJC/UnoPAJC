package unibs.pajc.uno.model.card;

import java.io.Serializable;

/**
 * 
 * @author Stefano Valloncini, Ye Yuhang, Luigi Amarante
 *
 *         Card interface.
 */
public interface Card extends Serializable
{
	CardType getType();

	CardColor getColor();
}
