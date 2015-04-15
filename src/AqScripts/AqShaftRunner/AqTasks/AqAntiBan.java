package AqScripts.AqShaftRunner.AqTasks;

import AqScripts.AqShaftRunner.AqConstants;
import AqScripts.Framework.AqPainter;
import AqScripts.Framework.AqTask;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Hud.Window;

/**
 * AqAntiBan.java
 *
 * AqAntiBan.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/14/2015.
 * @author Anonrate
 */

public class AqAntiBan extends AqTask
{
	private final AqPainter _AqPaint;

	private GameObject curTree     = null;

	/**
	 * Creates a chained { @link ClientContext } and { @link AqPainter }.
	 *
	 * @param ctx     The Chained { @link ClientContext }.
	 * @param aqPaint The Chained { @link AqPainter }.
	 */
	public AqAntiBan(ClientContext ctx, AqPainter aqPaint)
	{
		super(ctx, aqPaint);
		this._AqPaint = aqPaint;
	}

	/**
	 * Specifies with the given condition when this task can be executed.
	 *
	 * @return Returns whether or not this task can be executed.
	 */
	@Override
	public boolean activate()
	{
		return ctx.game.loggedIn() && (ctx.widgets.component(AqConstants.CloseWidgetIdA,
															 AqConstants.CloseComponentIdA).visible()
									  || ctx.widgets.component(AqConstants.FletchingWidgetId,
															   AqConstants.FletchingComponentId).visible()
									  || ctx.widgets.component(AqConstants.CloseWidgetIdB,
															   AqConstants.CloseComponentIdB)
													.component(AqConstants.CloseSubComponentIdB).visible()
									  || !ctx.hud.opened(Window.BACKPACK));
	}

	/**
	 * The code to be executed when this task is activated.
	 */
	@Override
	public void execute()
	{
		if (ctx.widgets.component(AqConstants.CloseWidgetIdA, AqConstants.CloseComponentIdA).visible())
		{
			if (ctx.widgets.component(AqConstants.CloseWidgetIdA, AqConstants.CloseComponentIdA).interact("Close"))
			{
				this._AqPaint.setStatus("Closing Window...");
				this.sleep(422, 808);
			}
		}
		else if (ctx.widgets.component(AqConstants.FletchingWidgetId, AqConstants.FletchingComponentId).visible())
		{
			if (ctx.objects.select().id(AqConstants.TreeIds).isEmpty())
			{
				return;
			}

			// Moved this variable to local scope; if issues arise move back to global scope.
			GameObject nearestTree = ctx.objects.nearest().poll();

			if (this.curTree == null)
			{
				this.curTree = nearestTree;
				ctx.camera.turnTo(this.curTree);
				return;
			}
			else if (nearestTree.tile().equals(this.curTree.tile()))
			{
				return;
			}

			ctx.camera.turnTo(nearestTree);
		}
		else if (ctx.widgets.component(AqConstants.CloseWidgetIdB, AqConstants.CloseComponentIdB)
							.component(AqConstants.CloseSubComponentIdB)
							.visible())
		{
			if (ctx.widgets.component(AqConstants.CloseWidgetIdB, AqConstants.CloseComponentIdB)
						   .component(AqConstants.CloseSubComponentIdB).interact("Close Window"))
			{
				this._AqPaint.setStatus("Closing Window...");
				this.sleep(455, 789);
			}
		}
		else if (!ctx.hud.opened(Window.BACKPACK))
		{
			this._AqPaint.setStatus("Opening Backpack...");
			ctx.hud.open(Window.BACKPACK);
		}
	}
}
