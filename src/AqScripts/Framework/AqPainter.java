package AqScripts.Framework;

import AqScripts.AqUtil.AqCalc;
import AqScripts.Framework.Interfaces.IAqPainter;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;

import java.awt.*;

/**
 * AqPainter.java
 *
 * AqPainter.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/14/2015.
 * @author Anonrate
 */
public abstract class AqPainter extends ClientAccessor implements IAqPainter
{
	private final long _StartTime;

	private final String _ScriptTitle;

	private final Stroke _NormalStroke = new BasicStroke(1);
	private final Stroke _DecorStroke  = new BasicStroke(2);

	private Color _backColor = new Color(0, 0, 0, 200);

	private Color _mouseLineColor      = new Color(0, 0, 255);
	private Color _mouseLineDecorColor = new Color(0, 0, 0);
	private Color _mousePointColor     = new Color(0, 0, 0);

	private Color _normalFontColor      = new Color(255, 255, 255);
	private Color _statusLabelFontColor = new Color(128, 128, 128);

	private Font _normalFont      = new Font("Candara", 0, 15);
	private Font _statusLabelFont = new Font("Candara", 1, 15);
	private Font _titleFont       = new Font("Candara", 1, 30);

	private long _runTime = 0l;

	private Polygon _paintPoly = new Polygon(new int[]
												 {
													 2,
													 2,
													 402,
													 402,
													 216,
													 216
												 },
											 new int[]
												 {
													 294,
													 408,
													 408,
													 328,
													 328,
													 294
												 },
											 6);

	private String _status = "...";

	/**
	 * Creates a chained { @link ClientContext } and a base paint for the derived Script.
	 *
	 * @param ctx         The chained { @link ClientContext }.
	 * @param scriptTitle The title of the current Script.
	 */
	public AqPainter(ClientContext ctx, String scriptTitle)
	{
		super(ctx);
		this._ScriptTitle = scriptTitle;
		this._StartTime = System.currentTimeMillis();
	}

	/**
	 * Gets the background paint { @link Color }.
	 *
	 * @return Returns the { @link Color } of the background paint.
	 */
	public
	Color getBackColor() { return this._backColor; }

	/**
	 * Gets the { @link Color } of the line for the mouse paint.
	 *
	 * @return Returns the { @link Color } of the line for the mouse paint.
	 */
	public
	Color getMouseLineColor() { return this._mouseLineColor; }

	/**
	 * Gets the decoration { @link Color } of the line for the mouse paint.
	 *
	 * @return Returns the decoration { @link Color } of the line for the mouse paint.
	 */
	public
	Color getMouseLineDecorColor() { return this._mouseLineDecorColor; }

	/**
	 * Gets the { @link Color } of the mouse point.
	 *
	 * @return Returns the { @link Color } of the mouse point.
	 */
	public
	Color getMousePointColor() { return this._mousePointColor; }

	/**
	 * Gets the normal { @link Font } { @link Color }.
	 *
	 * @return Returns the normal { @link Font } { @link Color }.
	 */
	public
	Color getNormalFontColor() { return this._normalFontColor; }

	/**
	 * Gets the { @link Font } { @link Color } for the status label.
	 *
	 * @return Returns the { @link Font } { @link Color } for the status label.
	 */
	public
	Color getStatusLabelFontColor() { return this._statusLabelFontColor; }

	/**
	 * Gets and Sets the new background { @link Color }.
	 *
	 * @param color The { @link Color } to change the background paint too.
	 *
	 * @return Returns the updated { @link Color } of the background paint.
	 */
	public
	Color setBackColor(Color color) { return this._backColor = color; }

	/**
	 * Gets and Sets the new { @link Color } of the line for the mouse paint.
	 *
	 * @param color The { @link Color } to change line of the mouse paint too.
	 *
	 * @return Returns the updated { @link Color } of the line for the mouse paint.
	 */
	public
	Color setMouseLineColor(Color color) { return this._mouseLineColor = color; }

	/**
	 * Gets and Sets the new decoration { @link Color } for the line of the mouse paint.
	 * 
	 * @param color The { @link Color } to change the decorated line of the mouse paint too.
	 *
	 * @return Returns the updated decorated { @link Color } for the line of the mouse paint.
	 */
	public
	Color setMouseLineDecorColor(Color color) { return this._mouseLineDecorColor = color; }

	/**
	 * Gets and Sets the { @link Color } of the mouse point.
	 * 
	 * @param color The { @link Color } to change the mouse point too.
	 *
	 * @return Returns the updated { @link Color } of the mouse point.
	 */
	public
	Color setMousePointColor(Color color) { return this._mousePointColor = color; }

	/**
	 * Gets and Sets the new { @link Color } of the normal { @link Font }.
	 *
	 * @param color The { @link Color } to change the normal { @link Font } too.
	 *
	 * @return Returns the updated { @link Color } of the normal { @link Font }.
	 */
	public
	Color setNormalFontColor(Color color) { return this._normalFontColor = color; }

	/**
	 * Gets and Sets the { @link Color } of the { @link Font } for the status label.
	 *
	 * @param color The { @link Color } to change the { @link Font } of the status label too.
	 *
	 * @return Returns the updated { @link Color } for the { @link Font } of the status label.
	 */
	public
	Color setStatusLabelFontColor(Color color) { return this._statusLabelFontColor = color; }
	
	
	/**
	 * Calculates the given value on its rate per hour using the current instances runtime.
	 *
	 * @param  xValue The value to be calculated of its rate per hour.
	 * @return        Returns the rate per hour of the given value.
	 */
	public
	double getXPerHour(int xValue)
	{
		return xValue == 0 ? 0d : 3600000d / this._runTime * xValue;
	}

	/**
	 * Gets the { @link Font } for the normal text.
	 * 
	 * @return Returns the { @link Font } of the normal text.
	 */
	public
	Font getNormalFont() { return this._normalFont; }

	/**
	 * Gets the { @link Font } for the status label text.
	 * 
	 * @return Returns the { @link Font } of the status label text.
	 */
	public
	Font getStatusLabelFont() { return this._statusLabelFont; }

	/**
	 * Gets the { @link Font } for the text of the script title.
	 * 
	 * @return Returns the { @link Font } for the text of the script title.
	 */
	public
	Font getTitleFont() { return this._titleFont; }

	/**
	 * Gets the current duration of the script in milliseconds.
	 * 
	 * @return Returns the current duration of the script in milliseconds.
	 */
	public
	long getRuntime() { return this._runTime; }

	/**
	 * Gets the { @link Polygon } used for the paint.
	 * 
	 * @return Returns the { @link Polygon } used for the paint.
	 */
	public
	Polygon getPaintPolygon() { return this._paintPoly; }

	/**
	 * Gets and Sets { @link Polygon } for the paint.
	 * 
	 * @param polygon The { @link Polygon } to change paint too.
	 *
	 * @return Returns the updated { @link Polygon } for the paint.
	 */
	public
	Polygon setPaintPolygon(Polygon polygon) { return this._paintPoly = polygon; }

	/**
	 * Gets the current scripts title.
	 * 
	 * @return Returns the current scripts title.
	 */
	public
	String getScriptTitle() { return this._ScriptTitle; }

	/**
	 * Gets the current status of the script.
	 * 
	 * @return Returns the current status of the script.
	 */
	public
	String getStatus() { return this._status; }

	/**
	 * Gets and Sets the status of the script.
	 * 
	 * @param status The status to updated to scripts status too.
	 *
	 * @return Returns the updated scripts status.
	 */
	public
	String setStatus(String status) { return this._status = status; }

	/**
	 * Formats the given amount of milliseconds into a more readable time format.
	 *
	 * @param mS The total amount of milliseconds to be converted into a time format.
	 * @return   Returns the total given amount of milliseconds converted into a time format.
	 */
	public
	String msToTime(long mS) { return AqCalc.msToTime(mS); }

	/**
	 * Creates a chained { @link Graphics2D } to be used for derived Script.
	 *
	 * @param g The chained { @link Graphics2D }.
	 */
	public
	abstract void repaint(Graphics2D g);

	/**
	 * Creates a chained { @link Graphics2D } to be used a base paint for the derived Script.
	 *
	 * @param g1 The chained { @link Graphics2D }.
	 */
	public
	void paint(Graphics g1)
	{
		Graphics2D g = (Graphics2D)g1;
		Point mouseP = ctx.input.getLocation();

		g.setStroke(this._DecorStroke);
		g.setColor(this._mouseLineDecorColor);
		g.drawLine(0, mouseP.y, ctx.game.dimensions().width, mouseP.y);
		g.drawLine(mouseP.x, 0, mouseP.x, ctx.game.dimensions().height);

		g.setStroke(this._NormalStroke);
		g.setColor(this._mouseLineColor);
		g.drawLine(0, mouseP.y, ctx.game.dimensions().width, mouseP.y);
		g.drawLine(mouseP.x, 0, mouseP.x, ctx.game.dimensions().height);

		g.setColor(this._mousePointColor);
		g.fillRect(mouseP.x - 2, mouseP.y - 2, 5, 5);

		g.setColor(this._backColor);
		g.fillPolygon(this._paintPoly);

		g.setFont(this._normalFont);
		g.setColor(this._normalFontColor);

		this._runTime = System.currentTimeMillis() - this._StartTime;

		g.setFont(this._statusLabelFont);
		g.setColor(this._statusLabelFontColor);
		g.drawString("Runtime:", 8, 345);

		g.setFont(this._normalFont);
		g.setColor(this._normalFontColor);
		g.drawString(this.msToTime(this._runTime), 68, 345);
		this.repaint(g);

		g.setColor(this._normalFontColor);
		g.setFont(this._titleFont);

		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.drawString(this._ScriptTitle, 9, 322 );
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);

		g.setStroke(this._DecorStroke);
		g.setColor(this._mouseLineDecorColor);
		g.drawPolygon(this._paintPoly);

		g.setStroke(this._NormalStroke);
		g.setColor(this._mouseLineColor);
		g.drawPolygon(this._paintPoly);
	}
}
