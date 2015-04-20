package AqScripts.api.players;

import org.powerbot.bot.rt6.client.RSCharacter;
import org.powerbot.bot.rt6.client.RSPlayer;
import org.powerbot.script.rt6.Actor;
import org.powerbot.script.rt6.ClientContext;

import java.awt.*;

/**
 * Player.java
 *
 * Player.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/18/2015.
 * @author Anonrate
 */
public
class Player extends org.powerbot.script.rt6.Player
{
	/**
	 * Creates an extension of the { @link Player } class.
	 *
	 * @param ctx The chained { @link ClientContext }.
	 * @param rsPlayer The internal { @link RSPlayer } used to created a new usable instance of { @link Player }
	 */
	public
	Player(ClientContext ctx, RSPlayer rsPlayer)
	{
		super(ctx, rsPlayer);
	}

	public boolean isChopping()
	{
		return this.animation() == 21177 || this.animation() == 21191 || this.animation() == 21192;
	}
}
