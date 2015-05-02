package TehPirate.packaged.framework;

import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;

/**
 * Task.java
 *
 * Task.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/26/2015.
 * @author Anonrate
 */
public abstract
class Task extends ClientAccessor
{
	public
	Task(ClientContext ctx)
	{
		super(ctx);
	}

	public abstract
	boolean activate();

	public abstract
	void execute();
}
