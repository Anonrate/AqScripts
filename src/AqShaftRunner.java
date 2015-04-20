import AqScripts.AqShaftRunner.AqPaint;
import AqScripts.AqShaftRunner.AqTasks.AqAntiBan;
import AqScripts.AqShaftRunner.AqTasks.AqChop;
import AqScripts.AqShaftRunner.AqTasks.AqDrop;
import AqScripts.AqShaftRunner.AqTasks.AqFletchShafts;
import AqScripts.Framework.AqTask;
import org.powerbot.script.*;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Constants;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * AqShaftRunner.java
 *
 * AqShaftRunner.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/14/2015.
 * @author Anonrate
 */

@Script.Manifest(name = "AqShaftRunner",
				 description = "Runs around, chops trees then fletches them into Arrow Shafts.",
				 properties = "client = 6")
public
class AqShaftRunner extends PollingScript<ClientContext> implements PaintListener, MessageListener
{
	private AqChop     _aqChop;
	private AqPaint _aqPaint;

	private boolean _scriptStarted = false;

	private List<AqTask> _aqTaskList = new ArrayList<AqTask>();

	@Override
	public
	void start()
	{
		if (! ctx.game.loggedIn()) { this.stop(); }

		this._aqPaint = new AqPaint(this.ctx, Constants.SKILLS_FLETCHING, "AqShaftRunner");

		// Needs to be declared first as an issue may arise.
		this._aqTaskList.add(this._aqChop = new AqChop(this.ctx, this._aqPaint));

		this._aqTaskList.add(new AqAntiBan(this.ctx, this._aqPaint));
		this._aqTaskList.add(new AqDrop(this.ctx, this._aqPaint));
		this._aqTaskList.add(new AqFletchShafts(this.ctx, this._aqPaint));

		this._scriptStarted = true;
	}

	@Override
	public
	void poll()
	{
		for (AqTask aqTask : this._aqTaskList) { if (aqTask.activate()) { aqTask.execute(); } }
	}

	@Override
	public
	void repaint(Graphics g)
	{
		if (this._scriptStarted) { this._aqPaint.paint(g); }
	}

	@Override
	public
	void messaged(MessageEvent mE)
	{
		if (mE.text().equals("You can't reach that."))
		{
			this._aqChop.setReachable(false);
		}

		if (mE.text().equals("You carefully cut the wood into 15 arrow shafts."))
		{
			this._aqPaint.setShaftsCount(this._aqPaint.getShaftsCount() + 15);
			this._aqPaint.setStatus("Fletching Shafts...");
		}
		else if (mE.text().equals("You get some logs."))
		{
			this._aqChop.setReachable(true);
			this._aqPaint.setLogsCount(this._aqPaint.getLogsCount() + 1);
			this._aqPaint.setStatus("Got some logs!");
		}
	}
}
