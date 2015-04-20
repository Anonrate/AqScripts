package AqScripts.AqUtil.enums;

/**
 * AqMiningStrategies.java
 *
 * AqMiningStrategies.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/19/2015.
 * @author Anonrate
 */
public
enum AqMiningStrategies
{
	Normal("Normal", ""),
	Hover("Hover", "Hovers over next rock."),
	Smart_Hover("Smart Hover", "Hovers over next rock, opening menu."),
	Smart_M1D1("Smart M1D1", "Mine one Drop One."),
	Hybrid("Hybrid", "Mix of Smart Hover and Smart M1D1."),
	Alternate("Alternate", "Alternates using each one randomly.");

	private final String _Name;
	private final String _Description;


	AqMiningStrategies(String name, String description)
	{
		this._Name = name;
		this._Description = description;
	}

	public
	String getName() { return this._Name; }

	public
	String getDecription() { return this._Description; }
}
