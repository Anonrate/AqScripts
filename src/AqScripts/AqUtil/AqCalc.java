package AqScripts.AqUtil;

import java.util.concurrent.TimeUnit;

/**
 * AqCalc.java
 *
 * AqCalc.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/15/2015.
 * @author Anonrate
 */
public final
class AqCalc
{
	/**
	 * Formats the given amount of milliseconds into a more readable time format.
	 *
	 * @param mS The total amount of milliseconds to be converted into a time format.
	 * @return   Returns the total given amount of milliseconds converted into a time format.
	 */
	public static
	String msToTime(long mS)
	{
		long hr = TimeUnit.MILLISECONDS.toHours(mS);
		long min = TimeUnit.MILLISECONDS.toMinutes(mS - TimeUnit.HOURS.toMillis(hr));
		long sec = TimeUnit.MILLISECONDS.toSeconds(mS - TimeUnit.HOURS.toMillis(hr) - TimeUnit.MINUTES.toMillis(min));
		return String.format("%02d:%02d:%02d", hr, min, sec);
	}
}
