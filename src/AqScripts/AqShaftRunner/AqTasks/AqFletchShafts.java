package AqScripts.AqShaftRunner.AqTasks;

import AqScripts.AqShaftRunner.AqConstants;
import AqScripts.Framework.AqTask;
import AqScripts.Framework.Interfaces.IAqPainter;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Hud;

/**
 * AqFletchShafts.java
 *
 * AqFletchShafts.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/14/2015.
 * @author Anonrate
 */

public class AqFletchShafts extends AqTask
{
	private final int _ArrowShaftWidgetId       = 1371;
	private final int _ArrowShaftSubComponentId = 0;
	private final int _ArrowShaftComponentId    = 44;

	private final int _ToolWidgetId    = 1179;
	private final int _ToolComponentId = 34;

	/**
	 * Creates a chained { @link ClientContext } and { @link IAqPainter }.
	 *
	 * @param ctx     The Chained { @link ClientContext }.
	 * @param aqPaint The Chained { @link IAqPainter }.
	 */
	public
	AqFletchShafts(ClientContext ctx, IAqPainter aqPaint) { super(ctx, aqPaint); }

	/**
	 * Specifies with the given condition when this task can be executed.
	 *
	 * @return Returns whether or not this task can be executed.
	 */
	@Override
	public
	boolean activate()
	{
		return ctx.game.loggedIn()
			   && (ctx.backpack.select().id(AqConstants.OakLogId).count() == 0)
			   && !ctx.widgets.component(AqConstants.FletchingWidgetId, AqConstants.FletchingComponentId).visible()
			   && !ctx.widgets.component(AqConstants.CloseWidgetIdA, AqConstants.CloseComponentIdA).visible()
			   && !ctx.widgets.component(AqConstants.CloseWidgetIdB, AqConstants.CloseComponentIdB)
							  .component(AqConstants.CloseSubComponentIdB)
							  .visible()
			   && ctx.hud.opened(Hud.Window.BACKPACK)
			   && ((ctx.backpack.select().count() == 28)
				   || ctx.widgets.component(this._ToolWidgetId, this._ToolComponentId).visible()
				   || ctx.widgets.component(this._ArrowShaftWidgetId,
											this._ArrowShaftComponentId)
								 .component(this._ArrowShaftSubComponentId)
								 .visible());
	}

	/**
	 * The code to be executed when this task is activated.
	 */
	@Override
	public void execute()
	{
		// Moved these variables to local scope; if issues arise move back to global scope.
		int fletchingOptionComponentId = 56;
		int fletchingOptionWidgetId = 1370;

		if (ctx.widgets.component(this._ToolWidgetId, this._ToolComponentId).visible())
		{
			if (ctx.widgets.component(this._ToolWidgetId, this._ToolComponentId).interact("Select"))
			{
				this.getAqPaint().setStatus("Selecting Knife...");
				this.sleep(758, 1001);
			}

			return;
		}
		else if (ctx.widgets.component(fletchingOptionWidgetId, fletchingOptionComponentId).visible())
		{
			if (!ctx.widgets.component(fletchingOptionWidgetId, fletchingOptionComponentId)
							.text()
							.equals("Arrow shaft x15"))
			{
				if (ctx.widgets.component(this._ArrowShaftWidgetId, this._ArrowShaftComponentId)
							   .component(this._ArrowShaftSubComponentId)
							   .interact("Select"))
				{
					this.getAqPaint().setStatus("Selecting Arrow Shafts...");
					this.sleep(744, 1022);
				}

				return;
			}

			// Moved this variable to local scope; if issues arise move back to global scope.
			int fletchingAmountComponentId = 74;
			int fletchButtonComponentId = 20;

			if (ctx.widgets.component(fletchingOptionWidgetId, fletchButtonComponentId)
						   .interact("Make "
									 + ctx.widgets.component(fletchingOptionWidgetId,
															 fletchingAmountComponentId).text()
									 + " Arrow shaft"))
			{
				this.getAqPaint().setStatus("Selecting Fletch Shafts...");
				this.sleep(789, 999);
			}

			return;
		}

		// Moved this variable to local scope; if issues arise move back to global scope.
		int _LogId = 1511;

		if (ctx.backpack.select().id(_LogId).count() > 0)
		{
			if (ctx.backpack.shuffle().poll().interact("Craft"))
			{
				this.getAqPaint().setStatus("Interacting with log...");
				this.sleep(761, 991);
			}
		}
	}
}
