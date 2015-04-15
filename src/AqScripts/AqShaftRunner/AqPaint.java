package AqScripts.AqShaftRunner;

import AqScripts.Framework.AqPainter;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GeItem;

import java.awt.*;
import java.text.DecimalFormat;

/**
 * AqPaint.java
 *
 * AqPaint.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/14/2015.
 * @author Anonrate
 */
public
class AqPaint extends AqPainter
{
	private final int _ShaftPrice;

	private final DecimalFormat _DF = new DecimalFormat("#.#");

	private int _logsCount   = 0;
	private int _shaftsCount = 0;

	/**
	 * Creates a chained { @link ClientContext } and a base paint for the derived Script.
	 *
	 * @param ctx         The chained { @link ClientContext }.
	 * @param scriptTitle The title of the current Script.
	 */
	public
	AqPaint(ClientContext ctx, String scriptTitle)
	{
		super(ctx, scriptTitle);

		// Moved this variable to local scope; if issues arise move back to global scope.
		int _ShaftId = 52;
		
		this._ShaftPrice = GeItem.price(_ShaftId);
	}

	/**
	 * Gets the current amount of logs chopped.
	 *
	 * @return Returns the current amount of logs that have been chopped.
	 */
	public
	int getLogsCount() { return this._logsCount; }

	/**
	 * Gets the amount of shafts that have been fletched.
	 *
	 * @return Returns the amount of shafts that have  been fletched.
	 */
	public
	int getShaftsCount() { return this._shaftsCount; }

	/**
	 * Gets and Sets the amount of logs that have been chopped.
	 *
	 * @param amount The amount of logs that have now been chopped.
	 *
	 * @return Returns updated amount of logs that now have been chopped.
	 */
	public
	int setLogsCount(int amount) { return this._logsCount = amount; }

	/**
	 * Gets and Sets the amount of shafts that have been fletched.
	 *
	 * @param amount The amount of shafts that have now been fletched.
	 *
	 * @return Returns the updated amount of shafts that now have been fletched.
	 */
	public
	int setShaftsCount(int amount) { return this._shaftsCount = amount; }

	/**
	 * Creates a chained { @link Graphics2D } to be used for derived Script.
	 *
	 * @param g The chained { @link Graphics2D }.
	 */
	@Override
	public
	void repaint(Graphics2D g)
	{
		double logsPerHour   = this.getXPerHour(this._logsCount);
		double shaftsPerHour = this.getXPerHour(this._shaftsCount);

		double profit = this._shaftsCount == 0 ? 0 : this._shaftsCount * this._ShaftPrice;

		/*
		 * Gets the sum of this.logsCount and this.shaftsCount.
		 * If the sum equals 0, then 0d is returned.
		 */
		double profitPerHour = this._logsCount + this._shaftsCount == 0 ? 0d : (3600000d
																				/ this.getRuntime()
																				* (this._logsCount + this._shaftsCount)
																			   ) * this._ShaftPrice;

		g.drawString(this.getStatus(), 236, 345);
		g.drawString(Integer.toString(this._logsCount), 68, 364);
		g.drawString(String.format("%.0f", logsPerHour), 236, 364);
		g.drawString(Integer.toString(this._shaftsCount), 68, 383);
		g.drawString(String.format("%.0f", shaftsPerHour), 236, 383);
		g.drawString(String.format("%1$s%2$s",
								   _DF.format(profit > 0d ? profit >= 1000d ? profit / 1000d : profit : 0d),
								   profit >= 1000d ? "K" : "gp"), 68, 402) ;

		g.drawString(String.format("%sK", _DF.format(profitPerHour / 1000d)), 236, 402);

		g.setFont(this.getStatusLabelFont());
		g.setColor(this.getStatusLabelFontColor());
		g.drawString("Status:", 155, 345);
		g.drawString("Logs:", 8, 364);
		g.drawString("Logs/Hour:", 155, 364);
		g.drawString("Shafts:", 8, 383);
		g.drawString("Shafts/Hour:", 155, 383);
		g.drawString("Profit:", 8, 402);
		g.drawString("Profit/Hour:", 155, 402);
	}
}
