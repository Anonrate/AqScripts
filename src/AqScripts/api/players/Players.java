package AqScripts.api.players;

import org.powerbot.script.rt6.ClientContext;

/**
 * Players.java
 *
 * Players.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/18/2015.
 * @author Anonrate
 */
public
class Players extends org.powerbot.script.rt6.Players
{
	public
	Players(ClientContext ctx)
	{
		super(ctx);
	}

	public Player getLocal() { return new Player(this.ctx, this.ctx.client().getMyRSPlayer()); }
}
