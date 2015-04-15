package AqScripts.AqShaftRunner.AqTasks;

import AqScripts.AqShaftRunner.AqConstants;
import AqScripts.Framework.AqPainter;
import AqScripts.Framework.AqTask;
import org.powerbot.script.Filter;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Hud.Window;

/**
 * AqChop.java
 *
 * AqChop.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/14/2015.
 * @author Anonrate
 */

public class AqChop extends AqTask
{
	private final AqPainter _AqPaint;

	private boolean _reachable = true;

	private GameObject _curTree     = null;

	/**
	 * Creates a chained { @link ClientContext } and { @link AqPainter }.
	 *
	 * @param ctx     The Chained { @link ClientContext }.
	 * @param aqPaint The Chained { @link AqPainter }.
	 */
	public AqChop(ClientContext ctx, AqPainter aqPaint)
	{
		super(ctx, aqPaint);
		this._AqPaint = aqPaint;
	}

	/**
	 * Gets and Sets if the given tree is reachable.
	 *
	 * @param reachable True or false if the given tree is reachable.
	 *
	 * @return Returns true if the give tree is reachable; otherwise returns false.
	 */
	public boolean setReachable(boolean reachable) { return this._reachable = reachable; }

	/**
	 * Specifies with the given condition when this task can be executed.
	 *
	 * @return Returns whether or not this task can be executed.
	 */
	@Override
	public boolean activate()
	{
		return ctx.game.loggedIn()
			   && ctx.hud.opened(Window.BACKPACK)
			   && ctx.backpack.select().id(AqConstants.OakLogId).count() == 0
			   && ctx.backpack.select().count() < 28
			   && !ctx.widgets.component(AqConstants.FletchingWidgetId, AqConstants.FletchingComponentId).visible()
			   && !ctx.widgets.component(AqConstants.CloseWidgetIdA, AqConstants.CloseComponentIdA).visible()
			   && !ctx.widgets.component(AqConstants.CloseWidgetIdB, AqConstants.CloseComponentIdB)
							  .component(AqConstants.CloseSubComponentIdB)
							  .visible()
			   && ctx.hud.opened(Window.BACKPACK);
	}

	/**
	 * The code to be executed when this task is activated.
	 */
	@Override
	public void execute()
	{
		if (ctx.objects.select().id(AqConstants.TreeIds).isEmpty())
		{
			return;
		}

		// Moved this variable to local scope; if issues arise move back to global scope.
		GameObject _nearestTree = ctx.objects.nearest().poll();
		this._curTree = this._curTree == null ? _nearestTree : this._curTree;

		if (!this._reachable)
		{
			this._AqPaint.setStatus("Current Tree Un-Reachable!");
			if (ctx.objects.select().select(new Filter<GameObject>()
			{
				@Override
				public boolean accept(GameObject tree) { return !tree.equals(_curTree); }
			}).id(AqConstants.TreeIds).isEmpty())
			{
				return;
			}

			this._curTree = _nearestTree = ctx.objects.nearest().poll();
		}

		if (_nearestTree.tile().equals(this._curTree.tile()))
		{
			if (ctx.players.local().inMotion()
				|| ctx.players.local().animation() == AqConstants.ChoppingAnimationA
				|| ctx.players.local().animation() == AqConstants.ChoppingAnimationB
				|| ctx.players.local().animation() == AqConstants.ChoppingAnimationC)
			{
				if (ctx.players.local().inMotion())
				{
					this._AqPaint.setStatus("Walking to tree...");
					return;
				}

				this._AqPaint.setStatus("Chopping tree...");
				return;
			}

			if (!this._curTree.inViewport())
			{
				this._AqPaint.setStatus("Stepping Towards Tree...");
				ctx.movement.step(this._curTree);
				ctx.camera.turnTo(this._curTree);
				this.sleep(68, 120);
				return;
			}
		}

		this._curTree = _nearestTree;

		if (this._curTree.interact("Chop"))
		{
			this._AqPaint.setStatus("Interacting with tree...");
			this.sleep(903, 1228);
			ctx.camera.turnTo(this._curTree);
			return;
		}

		ctx.camera.turnTo(this._curTree);
	}
}
