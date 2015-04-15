package AqScripts.AqFeatherCollector.AqTasks;

import AqScripts.Framework.AqTask;
import AqScripts.Framework.Interfaces.IAqPainter;
import org.powerbot.script.Filter;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Npc;

/**
 * AqKillChicken
 *
 * AqKillChicken is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/14/2015.
 * @author Anonrate
 */
public
class AqKillChicken extends AqTask
{
    /**
     * Creates a chained { @link ClientContext } and { @link IAqPainter }.
     *
     * @param ctx     The Chained { @link ClientContext }.
     * @param aqPaint The Chained { @link IAqPainter }.
     */
    public
    AqKillChicken(ClientContext ctx, IAqPainter aqPaint) { super(ctx, aqPaint); }

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
               && ctx.groundItems.select().id(314).isEmpty()
               && !ctx.players.local().inMotion()
               && !ctx.players.local().inCombat();
    }

    /**
     * The code to be executed when this task is activated.
     */
    @Override
    public
    void execute()
    {
        if (!ctx.npcs.select().select(new Filter<Npc>() {
            @Override
            public boolean accept(Npc npc) { return !npc.inCombat(); }
        }).id(41, 1017).isEmpty())
        {
            if (ctx.npcs.nearest().peek().interact("Attack"))
            {
                ctx.camera.turnTo(ctx.npcs.nearest().poll());
                this.sleep(444, 587);
            }

            return;
        }

        if (!ctx.npcs.select().id(41, 1017).isEmpty())
        {
            if (ctx.npcs.nearest().peek().interact("Attack"))
            {
                ctx.camera.turnTo(ctx.npcs.nearest().poll());
                this.sleep(548, 682);
            }
        }
    }
}
