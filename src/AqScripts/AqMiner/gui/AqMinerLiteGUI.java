package AqScripts.AqMiner.gui;

import AqScripts.Framework.Interfaces.IStartable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * AqMinerLiteGUI.java
 *
 * AqMinerLiteGUI.java is Created and Coded by Anonrate, and is to be used only with the project AqScripts.
 *
 * Created and Coded on 4/18/2015.
 * @author Anonrate
 */

public
class AqMinerLiteGUI extends JDialog implements ActionListener
{
	private JPanel       contentPane;
	private JButton      buttonStartScript;
	private JButton      buttonCancelScript;
	private JRadioButton modeBankRB;
	private JRadioButton modePowerMineRB;
	private JLabel       cBAOptionLabel;
	private JComboBox    cBA;
	private JLabel       cBBOptionLabel;
	private JComboBox    cBB;
	private JCheckBox    gemCheck;

	private final IStartable _Script;

	/**
	 * Initializes a new GUI for the given script.
	 *
	 * @param script The script which this gui is applicable too.
	 */
	public
	AqMinerLiteGUI(IStartable script)
	{
		this._Script = script;

		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(buttonStartScript);

		this.modeBankRB.addActionListener(this);
		this.modePowerMineRB.addActionListener(this);

		buttonStartScript.addActionListener(new ActionListener()
		{
			public
			void actionPerformed(ActionEvent e) { onOK(); }
		});

		buttonCancelScript.addActionListener(new ActionListener()
		{
			public
			void actionPerformed(ActionEvent e) { onCancel(); }
		});

		// call onCancel() when cross is clicked
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
			public
			void windowClosing(WindowEvent e) { onCancel(); }
		});

		// call onCancel() on ESCAPE
		contentPane.registerKeyboardAction(new ActionListener()
		{
			public
			void actionPerformed(ActionEvent e) { onCancel(); }
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

		this.modeBankRB.setSelected(true);



		this.setResizable(false);
		this.pack();

		this.setLocationRelativeTo(null);

		this.setVisible(true);
	}

	/**
	 * Called when the start but is clicked.
	 */
	private
	void onOK()
	{
		this._Script.setCanStart(true);
		dispose();
	}

	/**
	 * Called when either the cancel button is clicked or when this dialog is closed.
	 */
	private
	void onCancel()
	{
		this._Script.setCanStart(false);
		dispose();
	}

	/**
	 * Triggered when the specified { @link Component } have had their { @link ActionEvent } fired.
	 * @param aE The { @link ActionEvent } that the { @link Component } has fired.
	 */
	@Override
	public
	void actionPerformed(ActionEvent aE)
	{
		this.cBAOptionLabel.setText(this.modeBankRB.isSelected() ? "Locations:" : "Rocks:");
		this.cBBOptionLabel.setText(this.modeBankRB.isSelected() ? "Rocks:" : "Strategy:");
		this.gemCheck.setText(this.modeBankRB.isSelected() ? "Drop Gems" : "Cut Gems");
		DefaultComboBoxModel cBAModel = new DefaultComboBoxModel();
		DefaultComboBoxModel cBBModel = new DefaultComboBoxModel();

		String tempStr = "";

		if (this.modeBankRB.isSelected())
		{
			for (MiningLocations e : MiningLocations.values())
			{
				tempStr = String.format("%1$s (%2$s%3$s%4$s%5$s%6$s%7$s%8$s%9$s%10$s%11$s)",
										e.getTitle(),
										e.getClayAmount() > 0 ? "Clay(" + e.getClayAmount() + "), " : "",
										e.getCopperAmount() > 0 ? "Copper(" + e.getCopperAmount() + "), " : "",
										e.getTinAmount() > 0 ? "Tin(" + e.getTinAmount() + "), " : "",
										e.getIronAmount() > 0 ? "Iron(" + e.getIronAmount() + "), " : "",
										e.getSilverAmount() > 0 ? "Silver(" + e.getSilverAmount() + "), " : "",
										e.getCoalAmount() > 0 ? "Coal(" + e.getCoalAmount() + "), " : "",
										e.getGoldAmount() > 0 ? "Gold(" + e.getGoldAmount() + "), " : "",
										e.getMithrilAmount() > 0 ? "Mithril(" + e.getMithrilAmount() + "), " : "",
										e.getAdamantiteAmount() > 0 ? "Adamantite(" + e.getAdamantiteAmount() + "), "
																	: "",
										e.getRuniteAmount() > 0 ? "Runite(" + e.getRuniteAmount() + ")" : "");

				cBAModel.addElement(tempStr.endsWith(", )") ? tempStr.replace(", )", ")") : tempStr);
			}

			this.cBA.setModel(cBAModel);

			for (String str : tempStr.substring(tempStr.indexOf("(") + 1, tempStr.lastIndexOf(")") - 1).split(", "))
			{
				cBBModel.addElement(str);
			}

			this.cBB.setModel(cBBModel);
		}
		else
		{
			cBAModel.addElement("Clay");
			cBAModel.addElement("Copper");
			cBAModel.addElement("Tin");
			cBAModel.addElement("Iron");
			cBAModel.addElement("Silver");
			cBAModel.addElement("Coal");
			cBAModel.addElement("Gold");
			cBAModel.addElement("Mithril");
			cBAModel.addElement("Adamantite");
			cBAModel.addElement("Runite");

			this.cBA.setModel(cBAModel);

			cBBModel.addElement("Normal");
			cBBModel.addElement("Hover - Hovers over next rock.");
			cBBModel.addElement("Smart Hover - Hovers over next rock, opening menu.");
			cBBModel.addElement("Smart M1D1 - Mine one Drop One.");
			cBBModel.addElement("Hybrid - Mix of Smart Hover and Smart M1D1.");
			cBBModel.addElement("Alternate - Alternates using each one randomly.");

			this.cBB.setModel(cBBModel);
		}
	}
}
