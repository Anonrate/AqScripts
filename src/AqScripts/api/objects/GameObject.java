package AqScripts.api.objects;

import org.powerbot.bot.rt6.client.RSObject;
import org.powerbot.script.Filter;
import org.powerbot.script.Locatable;
import org.powerbot.script.rt6.ClientContext;

import java.util.Iterator;

/**
 * GameObject.java
 *
 * GameObject.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/18/2015.
 * @author Anonrate
 */
public
class GameObject extends org.powerbot.script.rt6.GameObject
{
	/**
	 * Creates an extension of the { @link GameObject } class.
	 *
	 * @param ctx The chained { @link ClientContext }.
	 * @param rSO The internal { @link RSObject } used to create a new usable instance { @link GameObject }.
	 * @param T   The { #link Type } of { @link GameObject } that this instance is referring too.
	 */
	public
	GameObject(ClientContext ctx, RSObject rSO, Type T) { super(ctx, rSO, T); }

	public
	org.powerbot.script.rt6.GameObject getGameObject() { return this; }

	/**
	 * Steps towards the current { @link GameObject }.
	 *
	 * @return Returns true if successfully stepped towards current { @link GameObject }; otherwise returns false.
	 */
	public
	boolean stepTo() { return ctx.movement.step(this); }

	/**
	 * Turns the { @link Camera } towards the current { @link GameObject }.
	 */
	public
	void turnTo() { ctx.camera.turnTo(this); }
}
