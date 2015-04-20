package AqScripts.AqMiner.AqMinerLite.AqTasks.miningStrategies;

import AqScripts.Framework.AqPainter;
import AqScripts.Framework.AqTask;
import AqScripts.Framework.Interfaces.IAqPainter;
import AqScripts.api.context.AqContext;
import AqScripts.api.objects.GameObject;
import org.powerbot.script.Filter;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Menu;

/**
 * AqHybrid.java
 *
 * AqHybrid.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/20/2015.
 * @author Anonrate
 */

public
class AqHybrid
	extends AqTask
{
	private final int[] _CopperOreIds = { 72099, 72100, 72098 };

	private final int _MiningAnimation = 625;

	private GameObject _curRock = null;
	private GameObject _nearestRock = null;

	public
	AqHybrid(AqContext aqx, IAqPainter aqPaint)
	{
		super(aqx, aqPaint);
	}

	@Override
	public
	boolean activate()
	{
		return ctx.game.loggedIn();
	}

	private boolean _menuOpened = false;

	private boolean _miningMenuOpened = false;

	@Override
	public
	void execute()
	{
		if (ctx.objects.select().id(this._CopperOreIds).isEmpty())
		{
			return;
		}

		this._nearestRock = ctx.objects.pollNearest(this._CopperOreIds);

		this._curRock = this._curRock == null ? this._nearestRock : this._curRock;

		// Not null
		if (ctx.objects.select().at(this._curRock).poll().equals(this._curRock))
		{
			// Mining
			if (ctx.players.local().animation() == this._MiningAnimation)
			{
				// Contains Rock
				if (ctx.backpack.select().id(436).count() > 0)
				{
					// Opens Menu
					if (ctx.backpack.select().id(436).shuffle().poll().click(false))
					{
						if (!this._menuOpened)
						{

							// Hovers Drop Option
							this._menuOpened = ctx.menu.hover(new Filter<Menu.Command>()
							{
								@Override
								public
								boolean accept(Menu.Command command)
								{
									return command.action.startsWith("Drop");
								}
							});

						}
					}

					return;
				}

				// Gets here only if backpack doesn't contain rock
				// Checks for nextNearest rock
				if (ctx.objects.select().select(new Filter<org.powerbot.script.rt6.GameObject>() {
					@Override
					public
					boolean accept(org.powerbot.script.rt6.GameObject gameObject)
					{
						return !gameObject.tile().equals(_curRock.tile());
					}
				}).id(this._CopperOreIds).isEmpty())
				{
					return;
				}

				// Gets next nearest rock
				this._nearestRock = ctx.objects.pollNearest(new Filter<org.powerbot.script.rt6.GameObject>() {
					@Override
					public
					boolean accept(org.powerbot.script.rt6.GameObject gameObject)
					{
						return !gameObject.tile().equals(_curRock.tile());
					}
				}, this._CopperOreIds);

				this._nearestRock.turnTo();

				if (this._curRock.inViewport())
				{
					if (this._curRock.click(false))
					{
						this._miningMenuOpened = ctx.menu.hover(new Filter<Menu.Command>() {
							@Override
							public
							boolean accept(Menu.Command command)
							{
								return command.action.startsWith("Mine");
							}
						});
					}
				}

				return;
			}

			if (this._curRock.inViewport())
			{
				this._curRock.interact("Mine");
				this._curRock.turnTo();
			}
			else
			{
				this._curRock.stepTo();
				this._curRock.turnTo();
			}


		}
		else
		{
			if (this._menuOpened)
			{
				ctx.input.click(true);
				this._menuOpened = false;
			}

			if (this._miningMenuOpened)
			{
				ctx.input.click(true);
				this._miningMenuOpened = false;
			}

			this._curRock = this._nearestRock;
		}


	}
}
