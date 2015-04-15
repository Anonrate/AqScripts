package AqScripts.Framework;

import java.awt.*;

/**
 * IAqPainter
 * <p/>
 * IAqPainter is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 * <p/>
 * Created and Coded on 4/14/2015.
 *
 * @author Anonrate
 */
public interface IAqPainter
{
    /**
     * Creates a chained { @link Graphics2D } to be used a base paint for the derived Script.
     *
     * @param g1 The chained { @link Graphics2D }.
     */
    void paint(Graphics g1);
}
