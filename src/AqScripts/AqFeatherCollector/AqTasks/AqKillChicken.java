package AqScripts.AqFeatherCollector.AqTasks;

import AqScripts.Framework.AqPainter;
import AqScripts.Framework.AqTask;
import AqScripts.Framework.IAqPainter;
import org.powerbot.script.Filter;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Npc;

/**
 * AqKillChicken
 * <p/>
 * AqKillChicken is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 * <p/>
 * Created and Coded on 4/14/2015.
 *
 * @author Anonrate
 */
public class AqKillChicken extends AqTask
{
    /**
     * Creates a chained { @link ClientContext } and { @link AqPainter }.
     *
     * @param ctx     The Chained { @link ClientContext }.
     * @param aqPaint The Chained { @link AqPainter }.
     */
    public AqKillChicken(ClientContext ctx, IAqPainter aqPaint)
    {
        super(ctx, aqPaint);
    }

    @Override
    public boolean activate()
    {
        return ctx.game.loggedIn() && ctx.groundItems.select().name("Feather").isEmpty() && !ctx.players.local().inMotion();
    }

    @Override
    public void execute()
    {
        if (!ctx.npcs.select().select(new Filter<Npc>() {
            @Override
            public boolean accept(Npc npc) { return npc.name() == "Chicken" && !npc.inCombat(); }
        }).isEmpty())
        {
            if (ctx.npcs.nearest().peek().interact("Attack"))
            {
                ctx.camera.turnTo(ctx.npcs.nearest().poll());
                this.sleep(444, 587);
            }

            return;
        }

        if (!ctx.npcs.select().name("Chicken").isEmpty())
        {
            if (ctx.npcs.nearest().peek().interact("Attack"))
            {
                ctx.camera.turnTo(ctx.npcs.nearest().poll());
                this.sleep(548, 682);
            }
        }
    }
}
