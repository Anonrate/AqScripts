package AqScripts.Framework;

import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;

import java.awt.*;

/**
 * AqMousePainter
 * <p/>
 * AqMousePainter is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 * <p/>
 * Created and Coded on 4/14/2015.
 *
 * @author Anonrate
 */
public class AqMousePainter extends ClientAccessor implements IAqPainter
{
    private final Stroke _NormalStroke = new BasicStroke(1);
    private final Stroke _DecorStroke  = new BasicStroke(2);

    private Color _mouseLineColor      = new Color(0, 0, 255);
    private Color _mouseLineDecorColor = new Color(0, 0, 0);
    private Color _mousePointColor     = new Color(0, 0, 0);

    /**
     * Creates a chained { @link ClientContext } and a base mouse paint for the derived Script.
     *
     * @param ctx The chained { @link ClientContext }.
     */
    public AqMousePainter(ClientContext ctx)
    {
        super(ctx);
    }

    /**
     * Gets the { @link Color } of the line for the mouse paint.
     *
     * @return Returns the { @link Color } of the line for the mouse paint.
     */
    public Color getMouseLineColor() { return this._mouseLineColor; }

    /**
     * Gets the decoration { @link Color } of the line for the mouse paint.
     *
     * @return Returns the decoration { @link Color } of the line for the mouse paint.
     */
    public Color getMouseLineDecorColor() { return this._mouseLineDecorColor; }

    /**
     * Gets the { @link Color } of the mouse point.
     *
     * @return Returns the { @link Color } of the mouse point.
     */
    public Color getMousePointColor() { return this._mousePointColor; }

    /**
     * Gets and Sets the new { @link Color } of the line for the mouse paint.
     *
     * @param color The { @link Color } to change line of the mouse paint too.
     *
     * @return Returns the updated { @link Color } of the line for the mouse paint.
     */
    public Color setMouseLineColor(Color color) { return this._mouseLineColor = color; }

    /**
     * Gets and Sets the new decoration { @link Color } for the line of the mouse paint.
     *
     * @param color The { @link Color } to change the decorated line of the mouse paint too.
     *
     * @return Returns the updated decorated { @link Color } for the line of the mouse paint.
     */
    public Color setMouseLineDecorColor(Color color) { return this._mouseLineDecorColor = color; }

    /**
     * Gets and Sets the { @link Color } of the mouse point.
     *
     * @param color The { @link Color } to change the mouse point too.
     *
     * @return Returns the updated { @link Color } of the mouse point.
     */
    public Color setMousePointColor(Color color) { return this._mousePointColor = color; }

    /**
     * Creates a chained { @link Graphics2D } to be used a base paint for the derived Script.
     *
     * @param g1 The chained { @link Graphics2D }.
     */
    public void paint(Graphics g1)
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
    }
}
