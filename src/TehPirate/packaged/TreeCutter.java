package TehPirate.packaged;

import TehPirate.packaged.Tasks.CutTree;
import TehPirate.packaged.Tasks.DropLog;
import TehPirate.packaged.framework.Task;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt6.ClientContext;

import java.util.ArrayList;
import java.util.List;

/**
 * TreeCutter.java
 *
 * TreeCutter.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/26/2015.
 * @author Anonrate
 */
public
class TreeCutter extends PollingScript<ClientContext>
{
	private List<Task> _taskList = new ArrayList<Task>();

	@Override
	public
	void start()
	{
		this._taskList.add(new CutTree(this.ctx));
		this._taskList.add(new DropLog(this.ctx));
	}

	@Override
	public
	void poll()
	{
		for (Task task : this._taskList)
		{
			if (task.activate())
			{
				task.execute();
			}
		}
	}

}
