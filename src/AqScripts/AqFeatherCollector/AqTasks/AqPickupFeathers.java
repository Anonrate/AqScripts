package AqScripts.AqFeatherCollector.AqTasks;

import AqScripts.Framework.AqTask;
import AqScripts.Framework.Interfaces.IAqPainter;
import org.powerbot.script.rt6.ClientContext;

/**
 * AqPickupFeathers
 *
 * AqPickupFeathers is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/14/2015.
 * @author Anonrate
 */
public
class AqPickupFeathers extends AqTask
{
    /**
     * Creates a chained { @link ClientContext } and { @link IAqPainter }.
     *
     * @param ctx     The Chained { @link ClientContext }.
     * @param aqPaint The Chained { @link IAqPainter }.
     */
    public
    AqPickupFeathers(ClientContext ctx, IAqPainter aqPaint) { super(ctx, aqPaint); }

    /**
     * Specifies with the given condition when this task can be executed.
     *
     * @return Returns whether or not this task can be executed.
     */
    @Override
    public
    boolean activate()
    {
        return ctx.game.loggedIn() && !ctx.groundItems.select().id(314).isEmpty() && !ctx.players.local().inMotion();
    }

    /**
     * The code to be executed when this task is activated.
     */
    @Override
    public
    void execute()
    {
        if (ctx.groundItems.select().id(314).isEmpty())
        {
            return;
        }

        if (ctx.groundItems.nearest().peek().interact("Take", "Feather"))
        {
            ctx.camera.turnTo(ctx.groundItems.nearest().poll());
            this.sleep(452, 800);
        }
    }
}
