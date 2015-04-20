package AqScripts.AqUtil.enums;

/**
 * AqMiningModes.java
 *
 * AqMiningModes.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/19/2015.
 * @author Anonrate
 */
public
enum AqMiningModes
{
	Bank("Bank"),
	Powermine("Powermine");

	private final String _Name;

	AqMiningModes(String name) { this._Name = name; }

	public
	String getName() { return this._Name; }
}
