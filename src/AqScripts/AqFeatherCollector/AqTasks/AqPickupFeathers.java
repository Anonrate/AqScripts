package AqScripts.AqFeatherCollector.AqTasks;

import AqScripts.Framework.AqPainter;
import AqScripts.Framework.AqTask;
import AqScripts.Framework.IAqPainter;
import org.powerbot.script.rt6.ClientContext;

/**
 * AqPickupFeathers
 *
 * AqPickupFeathers is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/14/2015.
 * @author Anonrate
 */
public class AqPickupFeathers extends AqTask
{
    /**
     * Creates a chained { @link ClientContext } and { @link AqPainter }.
     *
     * @param ctx     The Chained { @link ClientContext }.
     * @param aqPaint The Chained { @link AqPainter }.
     */
    public AqPickupFeathers(ClientContext ctx, IAqPainter aqPaint)
    {
        super(ctx, aqPaint);
    }

    @Override
    public boolean activate()
    {
        return ctx.game.loggedIn() && !ctx.groundItems.select().name("Feather").isEmpty() && ctx.players.local().inMotion();
    }

    @Override
    public void execute()
    {
        if (ctx.groundItems.select().name("Feather").isEmpty())
        {
            return;
        }

        if (ctx.groundItems.nearest().peek().interact("Take"))
        {
            ctx.camera.turnTo(ctx.groundItems.nearest().poll());
            this.sleep(452, 800);
        }
    }
}
