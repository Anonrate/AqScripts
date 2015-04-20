package AqScripts.AqMiner.gui;

/**
 * MiningLocations.java
 *
 * MiningLocations.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/18/2015.
 * @author Anonrate
 */
public
enum MiningLocations
{
	Rimmington_Mining_Site("Rimmington Mining Site", 2, 5, 2, 6, 0, 0, 2, 0, 0, 0);

	private final String _Title;
	private final int _Clay;
	private final int _Copper;
	private final int _Tin;
	private final int _Iron;
	private final int _Silver;
	private final int _Coal;
	private final int _Gold;
	private final int _Mithril;
	private final int _Adamantite;
	private final int _Runite;

	MiningLocations(String title,
					int clay,
					int copper,
					int tin,
					int iron,
					int silver,
					int coal,
					int gold,
					int mithril,
					int adamanitite,
					int runite)
	{
		this._Title      = title;
		this._Clay       = clay;
		this._Copper     = copper;
		this._Tin        = tin;
		this._Iron       = iron;
		this._Silver     = silver;
		this._Coal       = coal;
		this._Gold       = gold;
		this._Mithril    = mithril;
		this._Adamantite = adamanitite;
		this._Runite     = runite;
	}

	/**
	 * Gets the location title.
	 *
	 * @return Returns the location title.
	 */
	public
	String getTitle() { return this._Title; }

	/**
	 * Gets the amount of clay rocks in this location.
	 *
	 * @return Returns the amount of clay rocks in this location.
	 */
	public
	int getClayAmount() { return this._Clay; }

	/**
	 * Gets the amount of copper rocks in this location.
	 *
	 * @return Returns the amount of copper rocks in this location.
	 */
	public
	int getCopperAmount() { return this._Copper; }

	/**
	 * Gets the amount of copper tin in this location.
	 *
	 * @return Returns the amount of tin rocks in this location.
	 */
	public
	int getTinAmount() { return this._Tin; }

	/**
	 * Gets the amount of iron rocks in this location.
	 *
	 * @return Returns the amount of iron rocks in this location.
	 */
	public
	int getIronAmount() { return this._Iron; }

	/**
	 * Gets the amount of silver rocks in this location.
	 *
	 * @return Returns the amount of silver rocks in this location.
	 */
	public
	int getSilverAmount() { return this._Silver; }

	/**
	 * Gets the amount of coal rocks in this location.
	 *
	 * @return Returns the amount of coal rocks in this location.
	 */
	public
	int getCoalAmount() { return this._Coal; }

	/**
	 * Gets the amount of gold rocks in this location.
	 *
	 * @return Returns the amount of gold rocks in this location.
	 */
	public
	int getGoldAmount() { return this._Gold; }

	/**
	 * Gets the amount of mithril rocks in this location.
	 *
	 * @return Returns the amount of mithril rocks in this location.
	 */
	public
	int getMithrilAmount() { return this._Mithril; }

	/**
	 * Gets the amount of adamantite rocks in this location.
	 *
	 * @return Returns the amount of adamantite rocks in this location.
	 */
	public
	int getAdamantiteAmount() { return this._Adamantite; }

	/**
	 * Gets the amount of runite rocks in this location.
	 *
	 * @return Returns the amount of runite rocks in this location.
	 */
	public
	int getRuniteAmount() { return this._Runite; }
}
