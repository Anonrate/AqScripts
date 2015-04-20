package AqScripts.Framework;

import AqScripts.Framework.Interfaces.IAqPainter;
import AqScripts.api.context.AqAccessor;
import AqScripts.api.context.AqContext;
import org.powerbot.script.Random;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;

/**
 * AqTask.java
 *
 * AqTask.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/14/2015.
 * @author Anonrate
 */
public
abstract class AqTask extends AqAccessor
{
	private final IAqPainter _AqPaint;

	public
	AqTask(AqContext aqx, IAqPainter aqPaint)
	{
		super(aqx);
		this._AqPaint = aqPaint;
	}

	/**
	 * Creates a chained { @link ClientContext } and { @link IAqPainter }.
	 *
	 * @param ctx     The Chained { @link ClientContext }.
	 * @param aqPaint The Chained { @link IAqPainter }.
	 */


	/**
	 * Gets the current { @link IAqPainter } used to paint this task.
	 *
	 * @return Returns the current { @link IAqPainter } used to paint this task.
	 */
	public
	IAqPainter getAqPaint() { return this._AqPaint; }

	/**
	 * Halts the current thread for a { @link Random } amount of milliseconds within the given range.
	 *
	 * @param minMs The minimum amount of time to sleep in milliseconds.
	 * @param maxMs The maximum amount of time to sleep in milliseconds.
	 */
	public
	void sleep(int minMs, int maxMs)
	{
		try { Thread.sleep(Random.nextInt(minMs, maxMs)); }
		catch (InterruptedException e) { e.printStackTrace(); }
	}

	/**
	 * Specifies with the given condition when this task can be executed.
	 *
	 * @return Returns whether or not this task can be executed.
	 */
	public
	abstract boolean activate();

	/**
	 * The code to be executed when this task is activated.
	 */
	public
	abstract void execute();
}
