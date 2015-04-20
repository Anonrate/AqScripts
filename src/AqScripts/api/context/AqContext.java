package AqScripts.api.context;

import AqScripts.api.objects.GameObject;
import AqScripts.api.objects.Objects;
import AqScripts.api.players.Players;
import org.powerbot.script.rt6.ClientContext;


/**
 * AqContext.java
 *
 * AqContext.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/18/2015.
 * @author Anonrate
 */
public
class AqContext extends ClientContext
{
	public final Objects objects;

	public final Players players;

	public
	AqContext(ClientContext ctx)
	{
		super(ctx);
		this.objects = new AqScripts.api.objects.Objects(this);
		this.players = new AqScripts.api.players.Players(this);
	}
}
