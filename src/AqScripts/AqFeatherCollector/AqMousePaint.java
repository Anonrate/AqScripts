package AqScripts.AqFeatherCollector;

import AqScripts.Framework.AqMousePainter;
import org.powerbot.script.rt6.ClientContext;

import java.awt.*;

/**
 * AqMousePaint
 * <p/>
 * AqMousePaint is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 * <p/>
 * Created and Coded on 4/14/2015.
 *
 * @author Anonrate
 */
public class AqMousePaint extends AqMousePainter
{

    public AqMousePaint(ClientContext ctx)
    {
        super(ctx);
        this.setMouseLineColor(new Color(255, 255, 0));
    }
}
