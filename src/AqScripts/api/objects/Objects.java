package AqScripts.api.objects;

import org.powerbot.script.Filter;
import org.powerbot.script.rt6.ClientContext;

/**
 * Objects.java
 *
 * Objects.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/18/2015.
 * @author Anonrate
 */
public
class Objects extends org.powerbot.script.rt6.Objects
{
	/**
	 * Creates a extension of the { @link Objects } class.
	 *
	 * @param ctx The chained { @link ClientContext }.
	 */
	public
	Objects(ClientContext ctx) { super(ctx); }

	/**
	 * { @link peek }s the nearest given { @link GameObject }.
	 *
	 * @param ids The id of the { @link GameObject } which you want to { @link peek }.
	 * @return Returns the { @link nearest } { @link GameObject } if the { @link Query } is not { @link empty },
	 * while keeping it in the { @link Query }.  If the { @link Query } is { @link empty }, { @link objects.nil }
	 * will be returned.
	 */
	public
	GameObject peekNearest(int... ids)
	{
		org.powerbot.script.rt6.GameObject gO = ctx.objects.select().id(ids).nearest().peek();
		return new GameObject(this.ctx, gO.internal(), gO.type());
	}

	/**
	 * { @link poll }s the nearest given { @link GameObject }.
	 *
	 * @param ids The id of the { @link GameObject } which you want to { @link poll }.
	 * @return Returns the { @link nearest } { @link GameObject } if the { @link Query } is not empty, followed by
	 * discarding it out of the { @link Query }.  Otherwise if the { @link Query } is { @link empty },
	 * { @link objects.nil } will be returned.
	 */
	public
	GameObject pollNearest(int... ids)
	{
		org.powerbot.script.rt6.GameObject gO = ctx.objects.select().id(ids).nearest().poll();
		return new GameObject(this.ctx, gO.internal(), gO.type());
	}

	/**
	 * { @link select }s the specific { @link GameObject } using the given { @link Filter }s condition and
	 * { @link peek }s to it keeping it in the { @link Query }.
	 *
	 * @param filter The { @link Filter } to use to determine the specific { @link GameObject } to { @link poll}.
	 * @return Returns if condition is met, the specific { @link GameObject } which was chosen using the given
	 * { @link Filter } condition; otherwise returns { @link objects.nil }.
	 */
	public
	GameObject peekNearest(Filter<org.powerbot.script.rt6.GameObject> filter)
	{
		org.powerbot.script.rt6.GameObject gO = ctx.objects.select().select(filter).nearest().peek();
		return new GameObject(this.ctx, gO.internal(), gO.type());
	}

	/**
	 * { @link select }s the specific { @link GameObject } using the given { @link Filter }s condition and
	 * { @link poll }s it discarding it from the { @link Query }.
	 *
	 * @param filter The { @link Filter } to use to determine the specific { @link GameObject } to { @link poll}.
	 * @return Returns if condition is met, the specific { @link GameObject } which was chosen using the given
	 * { @link Filter } condition; otherwise returns { @link objects.nil }.
	 */
	public
	GameObject pollNearest(Filter<org.powerbot.script.rt6.GameObject> filter)
	{
		org.powerbot.script.rt6.GameObject gO = ctx.objects.select().select(filter).nearest().peek();
		return new GameObject(this.ctx, gO.internal(), gO.type());
	}

	/**
	 * { @link select }s the specific { @link GameObject } using the given { @link Filter }s condition and
	 * the given ids, followed by  { @link peek }ing to it keeping it in the { @link Query }.
	 *
	 * @param filter The { @link Filter } to use to determine the specific { @link GameObject } to { @link poll}.
	 * @param ids    The ids of the { @link GameObject } to help further select the correct { @link GameObject }.
	 * @return Returns if condition is met and if { @link Query } is not empty, the specific { @link GameObject }
	 * which was chosen using the given { @link Filter }s condition and id; otherwise returns { @link objects.nil }.
	 */
	public
	GameObject peekNearest(Filter<org.powerbot.script.rt6.GameObject> filter, int... ids)
	{
		org.powerbot.script.rt6.GameObject gO = ctx.objects.select().select(filter).id(ids).nearest().peek();
		return new GameObject(this.ctx, gO.internal(), gO.type());
	}


	/**
	 * { @link select }s the specific { @link GameObject } using the given { @link Filter }s condition and
	 * the given ids, followed by  { @link poll }ing it discarding it from the { @link Query }.
	 *
	 * @param filter The { @link Filter } to use to determine the specific { @link GameObject } to { @link poll}.
	 * @param ids    The ids of the { @link GameObject } to help further select the correct { @link GameObject }.
	 * @return Returns if condition is met and if { @link Query } is not empty, the specific { @link GameObject }
	 * which was chosen using the given { @link Filter }s condition and id; otherwise returns { @link objects.nil }.
	 */
	public
	GameObject pollNearest(Filter<org.powerbot.script.rt6.GameObject> filter, int... ids)
	{
		org.powerbot.script.rt6.GameObject gO = ctx.objects.select().select(filter).id(ids).nearest().peek();
		return new GameObject(this.ctx, gO.internal(), gO.type());
	}
}
