package TehPirate.notPackaged.notModuled;

import org.powerbot.script.PollingScript;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * TreeCutter.java
 *
 * TreeCutter.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/26/2015.
 * @author Anonrate
 */
public
class TreeCutter extends PollingScript<ClientContext>
{
	private List<Task> _taskList = new ArrayList<Task>();

	@Override
	public
	void start()
	{
		this._taskList.add(new CutTree(this.ctx));
		this._taskList.add(new DropLog(this.ctx));
	}

	@Override
	public
	void poll()
	{
		for (Task task : this._taskList)
		{
			if (task.activate())
			{
				task.execute();
			}
		}
	}

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
}

