import AqScripts.AqFeatherCollector.AqMousePaint;
import AqScripts.AqFeatherCollector.AqTasks.AqKillChicken;
import AqScripts.AqFeatherCollector.AqTasks.AqPickupFeathers;
import AqScripts.Framework.AqTask;
import AqScripts.Framework.IAqPainter;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt6.ClientContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * AqFeatherCollector
 *
 * AqFeatherCollector is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/14/2015.
 * @author Anonrate
 */
public class AqFeatherCollector extends PollingScript<ClientContext> implements PaintListener
{
    private List<AqTask> _aqTaskList = new ArrayList<AqTask>();

    private IAqPainter _aqMousePainter;

    private boolean _scriptStarted = false;

    public void start()
    {
        if (!ctx.game.loggedIn()) { this.stop(); }

        this._aqTaskList.add(new AqPickupFeathers(this.ctx, this._aqMousePainter = new AqMousePaint(this.ctx)));
        this._aqTaskList.add(new AqKillChicken(this.ctx, this._aqMousePainter));
    }


    @Override
    public void poll()
    {
        for (AqTask aqTask : this._aqTaskList) { if (aqTask.activate()) { aqTask.execute(); } }
    }

    @Override
    public void repaint(Graphics g)
    {
        if (this._scriptStarted) { this._aqMousePainter.paint(g); }
    }
}
