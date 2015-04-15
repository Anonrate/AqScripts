package AqScripts.Framework.Interfaces;

import java.awt.*;

/**
 * IAqPainter
 *
 * IAqPainter is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/14/2015.
 * @author Anonrate
 */
public interface IAqPainter
{
    /**
     * Gets the { @link Color } of the line for the mouse paint.
     *
     * @return Returns the { @link Color } of the line for the mouse paint.
     */
    Color getMouseLineColor();

    /**
     * Gets the decoration { @link Color } of the line for the mouse paint.
     *
     * @return Returns the decoration { @link Color } of the line for the mouse paint.
     */
    Color getMouseLineDecorColor();

    /**
     * Gets the { @link Color } of the mouse point.
     *
     * @return Returns the { @link Color } of the mouse point.
     */
    Color getMousePointColor();

    /**
     * Gets the normal { @link Font } { @link Color }.
     *
     * @return Returns the normal { @link Font } { @link Color }.
     */
    Color getNormalFontColor();

    /**
     * Gets the { @link Font } { @link Color } for the status label.
     *
     * @return Returns the { @link Font } { @link Color } for the status label.
     */
    Color getStatusLabelFontColor();

    /**
     * Gets and Sets the new { @link Color } of the line for the mouse paint.
     *
     * @param color The { @link Color } to change line of the mouse paint too.
     *
     * @return Returns the updated { @link Color } of the line for the mouse paint.
     */
    Color setMouseLineColor(Color color);

    /**
     * Gets and Sets the new decoration { @link Color } for the line of the mouse paint.
     *
     * @param color The { @link Color } to change the decorated line of the mouse paint too.
     *
     * @return Returns the updated decorated { @link Color } for the line of the mouse paint.
     */
    Color setMouseLineDecorColor(Color color);

    /**
     * Gets and Sets the { @link Color } of the mouse point.
     *
     * @param color The { @link Color } to change the mouse point too.
     *
     * @return Returns the updated { @link Color } of the mouse point.
     */
    Color setMousePointColor(Color color);

    /**
     * Gets and Sets the new { @link Color } of the normal { @link Font }.
     *
     * @param color The { @link Color } to change the normal { @link Font } too.
     *
     * @return Returns the updated { @link Color } of the normal { @link Font }.
     */
    Color setNormalFontColor(Color color);

    /**
     * Gets and Sets the { @link Color } of the { @link Font } for the status label.
     *
     * @param color The { @link Color } to change the { @link Font } of the status label too.
     *
     * @return Returns the updated { @link Color } for the { @link Font } of the status label.
     */
    Color setStatusLabelFontColor(Color color);

    /**
     * Gets the { @link Font } for the normal text.
     *
     * @return Returns the { @link Font } of the normal text.
     */
    Font getNormalFont();

    /**
     * Gets the { @link Font } for the status label text.
     *
     * @return Returns the { @link Font } of the status label text.
     */
    Font getStatusLabelFont();

    /**
     * Gets the current duration of the script in milliseconds.
     *
     * @return Returns the current duration of the script in milliseconds.
     */
    long getRuntime();

    /**
     * Gets the current status of the script.
     *
     * @return Returns the current status of the script.
     */
    String getStatus();

    /**
     * Gets and Sets the status of the script.
     *
     * @param status The status to updated to scripts status too.
     *
     * @return Returns the updated scripts status.
     */
    String setStatus(String status);

    /**
     * Formats the given amount of milliseconds into a more readable time format.
     *
     * @param mS The total amount of milliseconds to be converted into a time format.
     * @return   Returns the total given amount of milliseconds converted into a time format.
     */
    String msToTime(long mS);

    /**
     * Creates a chained { @link Graphics2D } to be used a base paint for the derived Script.
     *
     * @param g1 The chained { @link Graphics2D }.
     */
    void paint(Graphics g1);
}
