package AqScripts.Randoms;

import AqScripts.Framework.AqTask;
import AqScripts.Framework.Interfaces.IAqPainter;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Npc;

/**
 * Death.java
 *
 * Death.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/15/2015.
 * @author Anonrate
 */

public
class Death extends AqTask
{
	/**
	 * Creates a chained { @link ClientContext } and { @link IAqPainter }.
	 *
	 * @param ctx     The Chained { @link ClientContext }.
	 * @param aqPaint The Chained { @link IAqPainter }.
	 */
	public
	Death(ClientContext ctx, IAqPainter aqPaint) { super(ctx, aqPaint); }

	/**
	 * Specifies with the given condition when this task can be executed.
	 *
	 * @return Returns whether or not this task can be executed.
	 */
	@Override
	public
	boolean activate()
	{
		return ctx.game.loggedIn() && ! ctx.npcs.select().id(7910).isEmpty() || ctx.widgets.component(18, 28)
																						   .visible();
	}

	//92119
	/**
	 * The code to be executed when this task is activated.
	 */
	@Override
	public
	void execute()
	{
		if (ctx.widgets.component(18, 28).visible())
		{
			if (ctx.widgets.component(18, 28).interact("Confirm"))
			{
				this.sleep(879, 1258);
			}
		}

		if (ctx.npcs.select().id(7910).isEmpty())
		{
			return;
		}

		if (ctx.widgets.component(1184, 11).visible())
		{
			if (ctx.widgets.component(1184, 11).interact("Continue"))
			{
				this.sleep(444, 887);
			}

			return;
		}
		else if (ctx.widgets.component(1188, 3).visible())
		{
			if (ctx.widgets.component(1188, 3).interact("Continue"))
			{
				this.sleep(358, 488);
			}
			return;
		}
		else if (ctx.widgets.component(1188, 4).visible())
		{
			if (ctx.widgets.component(1188, 4).interact("Continue"))
			{
				this.sleep(207, 843);
			}

			return;
		}
		else if (ctx.widgets.component(1191, 7).visible())
		{
			if (ctx.widgets.component(1191, 7).interact("Continue"))
			{
				this.sleep(255, 308);
			}

			return;
		}
		else if (ctx.widgets.component(1186, 5).visible())
		{
			if (ctx.widgets.component(1186, 5).interact("Continue"))
			{
				this.sleep(678, 854);
			}

			return;
		}

		Npc death = ctx.npcs.nearest().poll();

		if (!death.inViewport())
		{
			if (ctx.movement.step(death))
			{
				ctx.camera.turnTo(death);
				this.sleep(487, 845);
			}

			return;
		}

		if (death.interact("Talk-to", "Death"))
		{
			this.sleep(1238, 1588);
			return;
		}

		ctx.camera.turnTo(death);
	}
}
