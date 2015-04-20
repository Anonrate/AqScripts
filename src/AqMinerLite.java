import AqScripts.AqMiner.AqMinerLite.AqGlobals;
import AqScripts.AqMiner.AqMinerLite.AqPaint;
import AqScripts.AqMiner.AqMinerLite.AqTasks.miningStrategies.AqHybrid;
import AqScripts.AqMiner.gui.AqMinerLiteGUI;
import AqScripts.Framework.AqTask;
import AqScripts.Framework.Interfaces.IAqPainter;
import AqScripts.Framework.Interfaces.IStartable;
import AqScripts.api.context.AqContext;
import org.powerbot.script.*;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Constants;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * AqMinerLite.java
 *
 * AqMinerLite.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/19/2015.
 * @author Anonrate
 */

@Script.Manifest(name = "AqMinerLite",
				 description = "TBA",
				 properties = "client = 6")
public
class AqMinerLite extends PollingScript<AqContext> implements PaintListener, MessageListener, IStartable
{
	private
	boolean _canStart      = false;

	private
	boolean _scriptStarted = false;

	private
	List<AqTask> _aqTaskList = new ArrayList<AqTask>();

	private
	AqPaint _aqPaint;

	@Override
	public
	void start()
	{
		if (! ctx.game.loggedIn()) { this.stop(); }

		AqMinerLiteGUI aqMinerLiteGUI = new AqMinerLiteGUI(this);

		while (aqMinerLiteGUI.isVisible() && !ctx.controller.isStopping());

		if (!this._canStart) { this.stop(); }

		this._aqPaint = new AqPaint(this.ctx, Constants.SKILLS_MINING, "AqMinerLite");

		this._aqTaskList.add(new AqHybrid(this.ctx, this._aqPaint));

		this._scriptStarted = true;
	}

	@Override
	public
	void poll() { for (AqTask aqTask : this._aqTaskList) { if (aqTask.activate()) { aqTask.execute(); } } }

	@Override
	public
	void setCanStart(boolean canStart) { this._canStart = canStart; }

	@Override
	public
	void messaged(MessageEvent mE)
	{
		if (mE.text().startsWith("You manage to mine some "))
		{
			AqGlobals.setOresMined(AqGlobals.getOresMined() + 1);
			this._aqPaint.setStatus("Ore Mined!");
		}
	}

	@Override
	public
	void repaint(Graphics g)
	{
		if (this._scriptStarted)
		{
			this._aqPaint.paint(g);
		}
	}
}
