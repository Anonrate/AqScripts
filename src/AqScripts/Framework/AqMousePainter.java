package AqScripts.Framework;

import AqScripts.AqUtil.AqCalc;
import AqScripts.Framework.Interfaces.IAqPainter;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;

import java.awt.*;

/**
 * AqMousePainter
 *
 * AqMousePainter is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/14/2015.
 * @author Anonrate
 */
public
class AqMousePainter extends ClientAccessor implements IAqPainter
{
    private final long _StartTime;

    private final Stroke _NormalStroke = new BasicStroke(1);
    private final Stroke _DecorStroke  = new BasicStroke(2);

    private Color _mouseLineColor      = new Color(0, 0, 255);
    private Color _mouseLineDecorColor = new Color(0, 0, 0);
    private Color _mousePointColor     = new Color(0, 0, 0);

    private Color _normalFontColor      = new Color(255, 255, 255);
    private Color _statusLabelFontColor = new Color(128, 128, 128);

    private Font _normalFont      = new Font("Candara", 0, 15);
    private Font _statusLabelFont = new Font("Candara", 1, 15);

    private int _runTimeX = 8;
    private int _runTimeY = 345;

    private int _statusX = 155;
    private int _statusY = 345;

    private long _runTime = 0l;

    private String _status = "";

    /**
     * Creates a chained { @link ClientContext } and a base mouse paint for the derived Script.
     *
     * @param ctx The chained { @link ClientContext }.
     */
    public
    AqMousePainter(ClientContext ctx)
    {
        super(ctx);
        this._StartTime = System.currentTimeMillis();
    }

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

    @Override
    public
    long getRuntime() { return this._runTime; }

    /**
     * Gets the current status of the script.
     *
     * @return Returns the current status of the script.
     */
    public
    String getStatus() { return this._status; }

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
     * Gets the x { @link Point } for the runtime text.
     *
     * @return Returns the x { @link Point } of the runtime text.
     */
    public
    int getRunTimeX() { return this._runTimeX; }

    /**
     * Gets the y { @link Point } for the runtime text.
     *
     * @return Returns the y { @link Point } of the runtime text.
     */
    public
    int getRunTimeY() { return this._runTimeY; }

    /**
     * Gets the x { @link Point } for the status text.
     *
     * @return Returns the x { @link Point } of the status text.
     */
    public
    int getStatusX() { return this._statusX; }

    /**
     * Gets the y { @link Point } for the status text.
     *
     * @return Returns the y { @link Point } of the status text.
     */
    public
    int getStatusY() { return this._statusY; }

    /**
     * Gets and Sets the x { @link Point } for the runtime text
     *
     * @param x The value to change the x { @link Point } of the runtime text too.
     *
     * @return Returns the updated x { @link Point } for the runtime text.
     */
    public
    int setRunTimeX(int x) { return this._runTimeX = x; }

    /**
     * Gets and Sets the y { @link Point } for the runtime text
     *
     * @param y The value to change the y { @link Point } of the runtime text too.
     *
     * @return Returns the updated y { @link Point } for the runtime text.
     */
    public
    int setRunTimeY(int y) { return this._runTimeY = y; }

    /**
     * Gets and Sets the x { @link Point } for the status text
     *
     * @param x The value to change the x { @link Point } of the status text too.
     *
     * @return Returns the updated x { @link Point } for the status text.
     */
    public
    int setStatusX(int x) { return this._statusX = x; }

    /**
     * Gets and Sets the y { @link Point } for the status text
     *
     * @param y The value to change the y { @link Point } of the status text too.
     *
     * @return Returns the updated y { @link Point } for the status text.
     */
    public
    int setStatusY(int y) { return this._statusY = y; }

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

        this._runTime = System.currentTimeMillis() - this._StartTime;

        g.setFont(this._statusLabelFont);
        g.setColor(this._statusLabelFontColor);
        g.drawString("Runtime:", this._runTimeX, this._runTimeY);

        g.setFont(this._normalFont);
        g.setColor(this._normalFontColor);
        g.drawString(this.msToTime(this._runTime), this._runTimeX + 60, this._runTimeY);
        g.drawString(this._status, this._statusX, this._statusY);
    }
}
