package AqScripts.AqMiner.AqMinerLite;

import AqScripts.AqUtil.AqCalc;
import AqScripts.Framework.AqPainter;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Constants;
import org.powerbot.script.rt6.Skills;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;

/**
 * AqPaint.java
 *
 * AqPaint.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/19/2015.
 * @author Anonrate
 */
public
class AqPaint extends AqPainter
{
	private final int _OrePrice = 113;

	private final DecimalFormat _DF = new DecimalFormat("#.#");

	private final Font _PercentFont = new Font("Candara", 0, 12);
	private final Font _ExtraFont   = new Font("Candara", 1, 12);

	private final FontMetrics _FM = ctx.client().getCanvas().getGraphics().getFontMetrics(this._PercentFont);

	/**
	 * Creates a chained { @link ClientContext } and a base paint for the derived Script.
	 * @param ctx         The chained { @link ClientContext }.
	 * @param scriptTitle The title of the current Script.
	 */
	public
	AqPaint(ClientContext ctx, int skillIndex, String scriptTitle)
	{
		super(ctx, skillIndex, scriptTitle);
		this.setPaintPolygon(new Polygon(new int[] { 2, 2, 549, 549, 176, 176 },
										 new int[] { 294, 408, 408, 328, 328, 294 },
										 6));

		this.setRunTimeX(86);
		this.setBackColor(new Color(0, 0, 0, 100));
	}

	@Override
	public
	void repaint(Graphics2D g)
	{
		double oresPerHour   = this.getXPerHour(AqGlobals.getOresMined());
		double expPerHour    = this.getXPerHour(this.getExpGained());

		int profit = AqGlobals.getOresMined() == 0 ? 0 : AqGlobals.getOresMined() * this._OrePrice;

		double profitPerHour = AqGlobals.getOresMined() == 0
							   ? 0d
							   : (3600000d / this.getRuntime() * AqGlobals.getOresMined()) * this._OrePrice;

		g.setColor(this.getBackColor());
		g.fillRect(178, 296, 370, 30);

		g.setStroke(this.getDecorStroke());
		g.setColor(this.getMouseLineDecorColor());
		g.drawRect(178, 296, 370, 30);

		g.setStroke(this.getNormalStroke());
		g.setColor(this.getMouseLineColor());
		g.drawRect(178, 296, 370, 30);

		g.setColor(new Color(255, 0, 0, 100));
		g.fillRect(180, 311, 100, 13);

		g.setColor(new Color(0, 255, 0, 100));
		g.fillRect(180, 311, (int)this.getPercentToNextLevel(), 13);

		String percent = this._DF.format(this.getPercentToNextLevel()) + "%";
		Rectangle2D percentBounds = this._FM.getStringBounds(percent, ctx.client().getCanvas().getGraphics());

		g.setColor(this.getNormalFontColor());
		g.setFont(this._PercentFont);
		g.drawString(percent, (int)(230 - percentBounds.getWidth() / 2), (int)(317 +
																			   percentBounds.getY() +
																			   percentBounds.getHeight()
		));

		g.drawString(Integer.toString(AqGlobals.getOresMined()), 323, 308);
		g.drawString(Integer.toString(profit >= 10000 ? profit / 1000 : profit) +
					 (profit >= 10000 ? "K" : "gp"), 323, 322);

		g.drawString(Integer.toString((int)oresPerHour), 439, 308);
		g.drawString(this._DF.format(profitPerHour >= 10000d ? profitPerHour / 1000d : profitPerHour) +
					 (profitPerHour >= 10000d ? "K" : "gp"), 439, 322);

		g.setColor(this.getStatusLabelFontColor());
		g.setFont(this._ExtraFont);

		g.drawString("Ores:", 285, 308);
		g.drawString("Profit:", 285, 322);

		g.drawString("Ores/H:", 390, 308);
		g.drawString("Profit/H:", 390, 322);

		g.setColor(new Color(255, 255, 255, 25));
		g.fillRect(180, 311, 100, 6);

		g.setColor(Color.BLACK);
		g.drawRect(180, 311, 100, 13);

		g.setColor(this.getNormalFontColor());
		g.setFont(this.getNormalFont());
		g.drawString(this.getStatus(), 266, this.getRunTimeY());

		g.drawString(this.getExpGained() > 0
					 ? AqCalc.msToTime((long)(this.getExpTNL() / expPerHour * 3600000D))
					 : "00:00:00",
					 86, 364);
		g.drawString(Integer.toString(this.getExpTNL()), 266 , 364);

		String expPerHourStr = this._DF.format(expPerHour >= 10000d ? expPerHour / 1000d : expPerHour) +
							   (expPerHour >= 10000d ? "K" : "");

		g.drawString(expPerHourStr, 446, 364);


		g.drawString(Integer.toString(this.getStartExp()), 86, 383);
		g.drawString(Integer.toString(this.getCurExp()), 266, 383);
		g.drawString(Integer.toString(this.getExpGained()), 446, 383);

		g.drawString(Integer.toString(this.getStartLevel()), 86, 402);
		g.drawString(Integer.toString(this.getCurLevel()), 266, 402);
		g.drawString(Integer.toString(this.getLevelsGained()), 446, 402);

		g.setFont(this.getStatusLabelFont());
		g.setColor(this.getStatusLabelFontColor());

		g.drawString("Status:", 170, this.getRunTimeY());

		g.drawString("Time TNL:", 8, 364);
		g.drawString("Exp TNL:", 170, 364);
		g.drawString("Exp/Hour:", 350, 364);

		g.drawString("Start Exp:", 8, 383);
		g.drawString("Current Exp:", 170, 383);
		g.drawString("Exp Gained:", 350, 383);

		g.drawString("Start Level:", 8, 402);
		g.drawString("Current Level:", 170, 402);
		g.drawString("Levels Gained:", 350, 402);
	}
}
