package AqScripts.AqShaftRunner.AqTasks;

import AqScripts.AqShaftRunner.AqConstants;
import AqScripts.Framework.AqTask;
import AqScripts.Framework.Interfaces.IAqPainter;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Hud;
import org.powerbot.script.rt6.Item;

/**
 * AqDrop.java
 *
 * AqDrop.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/14/2015.
 * @author Anonrate
 */

public
class AqDrop extends AqTask
{
	/**
	 * Creates a chained { @link ClientContext } and { @link IAqPainter }.
	 *
	 * @param ctx     The Chained { @link ClientContext }.
	 * @param aqPaint The Chained { @link IAqPainter }.
	 */
	public
	AqDrop(ClientContext ctx, IAqPainter aqPaint) { super(ctx, aqPaint); }

	/**
	 * Specifies with the given condition when this task can be executed.
	 *
	 * @return Returns whether or not this task can be executed.
	 */
	@Override
	public
	boolean activate()
	{
		return ctx.game.loggedIn() && ctx.backpack.select().id(AqConstants.OakLogId).count() > 0
			   && !ctx.widgets.component(AqConstants.FletchingWidgetId, AqConstants.FletchingComponentId).visible()
			   && !ctx.widgets.component(AqConstants.CloseWidgetIdA, AqConstants.CloseComponentIdA).visible()
			   && !ctx.widgets.component(AqConstants.CloseWidgetIdB, AqConstants.CloseComponentIdB)
							  .component(AqConstants.CloseSubComponentIdB)
							  .visible()
			   && ctx.hud.opened(Hud.Window.BACKPACK);
	}

	/**
	 * The code to be executed when this task is activated.
	 */
	@Override
	public void execute()
	{
		for (Item item : ctx.backpack.select().id(AqConstants.OakLogId).shuffle())
		{
			this.getAqPaint().setStatus("Dropping Oak Logs...");
			item.interact("Drop");
		}
	}
}
