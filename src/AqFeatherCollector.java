
import AqScripts.AqFeatherCollector.AqTasks.AqKillChicken;
import AqScripts.AqFeatherCollector.AqTasks.AqPickupFeathers;
import AqScripts.AqUtil.AqMousePaint;
import AqScripts.Framework.AqTask;
import AqScripts.Randoms.Death;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
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

@Script.Manifest(name = "AqFeatherCollector",
				 description = "TBA",
				 properties = "client = 6")
public
class AqFeatherCollector extends PollingScript<ClientContext> implements PaintListener
{
	private boolean _scriptStarted = false;

	private AqMousePaint _aqPaint;

	private List<AqTask> _aqTaskList = new ArrayList<AqTask>();

	@Override
	public
	void start()
	{
		if (! ctx.game.loggedIn()) { this.stop(); }

		this._aqPaint = new AqMousePaint(this.ctx);
		this._aqPaint.setMouseLineColor(new Color(0, 255, 0));

		this._aqTaskList.add(new AqPickupFeathers(this.ctx, this._aqPaint));
		this._aqTaskList.add(new AqKillChicken(this.ctx, this._aqPaint));
		this._aqTaskList.add(new Death(this.ctx, this._aqPaint));
		this._scriptStarted = true;
	}

	@Override
	public
	void poll() { for (AqTask aqTask : this._aqTaskList) { if (aqTask.activate()) { aqTask.execute(); } } }

	@Override
	public
	void repaint(Graphics g)
	{
		if (this._scriptStarted) { this._aqPaint.paint(g); }
	}
}
