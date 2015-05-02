package TehPirate.notPackaged.moduled;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

/**
 * CutTree.java
 *
 * CutTree.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/26/2015.
 * @author Anonrate
 */
public
class CutTree extends Task
{
	private final int[] _TreeIds = { 0, 1, 2, 3 };

	// This just needs to be here just because.
	public
	CutTree(ClientContext ctx)
	{
		super(ctx);
	}

	@Override
	public
	boolean activate()
	{
		/*
		 * Checks if backpack is 'NOT' empty using the '!' at the front of the statement
		 * and check to see if the query is 'NOT' empty of the _TreeIds
		 * In other words, if checks if your backpack is full, and if there is any tree that contains _TreeIds
		 */
		return !ctx.backpack.select().isEmpty() && !ctx.objects.select().id(this._TreeIds).isEmpty();
	}

	@Override
	public
	void execute()
	{
		/*
		 * Just using this as a double check and as an example to teach you something about the query system.
		 * What this is going to do is check to see if there is any tree available with the specified id.
		 * If there isn't, it will this will be true because it is empty and there for no need to continue so
		 * I am returning out of this method; or in other words breaking if you like to think it of as a for or
		 * while loop.
		 *
		 * But if this returns false, it will not get to the return part of the condition.
		 */
		if (ctx.objects.select().id(this._TreeIds).isEmpty())
		{
			return;
		}

		/*
		 * Every single time you call select() parameterless it refreshes the query, so you don't need to do it every time.
		 *
		 * So since the condition above return false because the query wasn't empty, you just need to do this.
		 */

		/*
		 * This just poll's or takes the nearest object from the query so it is not there anymore, so the next one you
		 * poll will be either be the second nearest one if the previous one isn't nil, or the nearest if it is.
		 */
		GameObject gameObject = ctx.objects.nearest().poll();

		if (!gameObject.inViewport() && !ctx.players.local().inMotion())
		{
			ctx.movement.step(gameObject);
			ctx.camera.turnTo(gameObject);
		}

		if (gameObject.inViewport() && ctx.players.local().animation() == -1 && !ctx.players.local().inMotion())
		{
			gameObject.interact("Chop");
		}
	}
}
