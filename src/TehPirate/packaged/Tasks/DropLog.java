package TehPirate.packaged.Tasks;

import TehPirate.packaged.framework.Task;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;

/**
 * DropLog.java
 *
 * DropLog.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/27/2015.
 * @author Anonrate
 */
public
class DropLog extends Task
{
	private final int _LogId = 1;

	// This just needs to be there just because.
	public
	DropLog(ClientContext ctx)
	{
		super(ctx);
	}

	@Override
	public
	boolean activate()
	{
		/*
		 * Checks if you backpack has 28 items (Does not include the amount of items that are stacked)
		 * And if you backpack is 'NOT' empty of the _LogId.
		 */
		return ctx.backpack.select().count() == 28 && !ctx.backpack.select().id(this._LogId).isEmpty();
	}

	@Override
	public
	void execute()
	{
		/*
		 * Not to sure if this works, but it is just going to go through your backpack, only selecting the Items with
		 * the _LogId and dropping them.
		 */
		for (Item item : ctx.backpack.select().id(this._LogId))
		{
			item.interact("Drop");
		}
	}
}
