package AqScripts.AqMiner.AqMinerLite;

import AqScripts.AqMiner.gui.MiningLocations;
import AqScripts.AqUtil.enums.AqMiningModes;
import AqScripts.AqUtil.enums.AqMiningStrategies;

/**
 * AqGlobals.java
 *
 * AqGlobals.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/19/2015.
 * @author Anonrate
 */
public
class AqGlobals
{
	private static AqMiningModes _aqMiningMode          = AqMiningModes.Bank;
	private static AqMiningStrategies _aqMiningStrategy = AqMiningStrategies.Alternate;

	private static boolean _cutGems  = false;
	private static boolean _dropGems = false;

	private static int _gemsFound  = 0;
	private static int _oresMined = 0;

	private static MiningLocations _miningLocation = MiningLocations.Rimmington_Mining_Site;

	// TODO Need to make rock Enum.

	public static
	boolean canCutGems() { return _cutGems; }

	public static
	boolean canDropGems() { return _dropGems; }

	public static
	AqMiningModes getAqMiningMode() { return _aqMiningMode; }

	public static
	AqMiningStrategies getAqMiningStrategy() { return _aqMiningStrategy; }

	public static
	int getGemsFound() { return _gemsFound; }

	public static
	int getOresMined() { return _oresMined; }

	public static
	MiningLocations getMiningLocation() { return _miningLocation; }

	public static
	boolean setCanCutGems(boolean cutGems) { return _cutGems = cutGems; }

	public static
	boolean setCanDropGems(boolean dropGems) { return _dropGems = dropGems; }

	public static
	AqMiningModes setMiningMode(AqMiningModes aqMiningMode) { return _aqMiningMode = aqMiningMode; }

	public static
	AqMiningStrategies setAqMiningStrategy(AqMiningStrategies aqMiningStrategy) {
		return _aqMiningStrategy = aqMiningStrategy; }

	public static
	int setGemsFound(int amount) { return _gemsFound = amount; }

	public static
	int setOresMined(int amount) { return _oresMined = amount; }

	public static
	MiningLocations setMiningLocation(MiningLocations miningLocation) { return _miningLocation = miningLocation; }
}
