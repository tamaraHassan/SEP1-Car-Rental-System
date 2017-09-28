package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import java.awt.GridBagConstraints;

import javax.swing.JComboBox;

import doc.*;

public class AddVehiclePage implements Serializable{

	
	//fields START
	JTextField regNoField;
	JTextField colorField;
	JTextField modelField;
	JTextField makerField;
	JTextField sizeSpecificationsField;
	JTextField driverLicenseField;
	JTextField batterySizeField;
	JTextField batteryChargerField;
	JTextField trunkCapacityField;
	JTextField exteriorDimensionsField;
	JTextField cargoSizeField;
	JTextField numberOfPeopleField;
	JTextField numberOfBedsField;
	JTextField numberOfKmField;
	JTextField yearField;
	JTextField horsePowerField;
	JTextField maintenanceRemainingKmField;
	JTextField numberOfDoorsField;
	JTextField numberOfSeatsField;
	JTextField engineSizeField;
	JTextField fuelConsumptionField;
	JTextField priceField;
	JTextField loadCapacityField;
	JComboBox<String> roofStorageCombo;
	JComboBox<String> transmissionCombo;
	JComboBox<String> navigationSystemCombo;
	JComboBox<String> cruiseControlCombo;
	JComboBox<String> refrigeratorCombo;
	JComboBox<String> tvCombo;
	JComboBox<String> heatedWaterCombo;
	JComboBox<String> generatorCombo;
	JComboBox<String> bicycleStandCombo;
	JComboBox<String> microwaveCombo;
	JComboBox<String> roofHatchCombo;
	JComboBox<String> childSeatCombo;
	JComboBox<String> trailerCouplingCombo;
	
	JLabel regNoLabel;
	JLabel colorLabel;
	JLabel modelLabel;
	JLabel makerLabel;
	JLabel sizeSpecificationsLabel;
	JLabel driverLicenseLabel;
	JLabel batterySizeLabel;
	JLabel batteryChargerLabel;
	JLabel trunkCapacityLabel;
	JLabel exteriorDimensionsLabel;
	JLabel cargoSizeLabel;
	JLabel numberOfPeopleLabel;
	JLabel numberOfBedsLabel;
	JLabel numberOfKmLabel;
	JLabel yearLabel;
	JLabel horsePowerLabel;
	JLabel maintenanceRemainingKmLabel;
	JLabel numberOfDoorsLabel;
	JLabel numberOfSeatsLabel;
	JLabel engineSizeLabel;
	JLabel fuelConsumptionLabel;
	JLabel priceLabel;
	JLabel loadCapacityLabel;
	JLabel transmissionLabel;
	JLabel navigationSystemLabel;
	JLabel cruiseControlLabel;
	JLabel refrigeratorLabel;
	JLabel tvLabel;
	JLabel heatedWaterLabel;
	JLabel generatorLabel;
	JLabel bicycleStandLabel;
	JLabel microwaveLabel;
	JLabel roofHatchLabel;
	JLabel childSeatLabel;
	JLabel trailerCouplingLabel;
	JLabel roofStorageLabel;
	private JRadioButton RdbtnFamilyCar;
	private JRadioButton RdbtnVan;
	private JRadioButton RdbtnMovingTruck;
	private JRadioButton RdbtnAutoCamper;
	private TitledBorder titleTypePanel;
	private JPanel typePanel;
	private Font categoryTitleFont;
	private ButtonGroup rdbGroup;
	private JPanel carDescription;
	private JPanel eachCarPanel;
	private JLabel carTitle;
	private JPanel northHolder;
	private JPanel scrollContainer;
	private JScrollPane scroll;
	private JButton btnAddVehicle;
	private VehicleList vehicleList;
	private ManageVehicle manageVehicle;
	
	
	public AddVehiclePage(VehicleList vehicleList, ManageVehicle manageVehicle){
		this.manageVehicle=manageVehicle;
		this.vehicleList= vehicleList;
		this.RdbtnFamilyCar= new JRadioButton("Family car");
		this.RdbtnVan= new JRadioButton("Van");
		this.RdbtnMovingTruck= new JRadioButton("Moving truck");
		this.RdbtnAutoCamper= new JRadioButton("Auto camper");
		this.rdbGroup= new ButtonGroup();
		rdbGroup.add(RdbtnFamilyCar);
		rdbGroup.add(RdbtnVan);
		rdbGroup.add(RdbtnMovingTruck);
		rdbGroup.add(RdbtnAutoCamper);
		
		this.categoryTitleFont= new Font("Abel",Font.BOLD, 14);
		this.titleTypePanel= new TitledBorder("Chose car type to add");
		this.titleTypePanel.setTitleFont(categoryTitleFont);
		this.typePanel= new JPanel();
		this.typePanel.setBorder(titleTypePanel);
		
		this.regNoField= new JTextField(30);
		this.colorField= new JTextField(30);
		this.modelField= new JTextField(30);
		this.makerField= new JTextField(30);
		this.sizeSpecificationsField= new JTextField(30);
		this.driverLicenseField= new JTextField(30);
		this.batterySizeField= new JTextField(30);
		this.batteryChargerField= new JTextField(30);
		this.trunkCapacityField= new JTextField(30);
		this.exteriorDimensionsField= new JTextField(30);
		this.cargoSizeField= new JTextField(30);
		this.numberOfPeopleField= new JTextField(30);
		this.numberOfBedsField= new JTextField(30);
		this.numberOfKmField= new JTextField(30);
		this.yearField= new JTextField(30);
		this.horsePowerField= new JTextField(30);
		this.maintenanceRemainingKmField= new JTextField(30);
		this.numberOfDoorsField= new JTextField(30);
		this.numberOfSeatsField= new JTextField(30);
		this.engineSizeField= new JTextField(30);
		this.fuelConsumptionField= new JTextField(30);
		this.priceField= new JTextField(30);
		this.loadCapacityField= new JTextField(30);
		this.transmissionCombo= new JComboBox<String>();
		transmissionCombo.addItem("Manual");
		transmissionCombo.addItem("Automatic");
		this.navigationSystemCombo= new JComboBox<String>();
		navigationSystemCombo.addItem("Yes");
		navigationSystemCombo.addItem("No");
		this.cruiseControlCombo= new JComboBox<String>();
		cruiseControlCombo.addItem("Yes");
		cruiseControlCombo.addItem("No");
		this.refrigeratorCombo= new JComboBox<String>();
		refrigeratorCombo.addItem("Yes");
		refrigeratorCombo.addItem("No");
		this.tvCombo= new JComboBox<String>();
		tvCombo.addItem("Yes");
		tvCombo.addItem("No");
		this.heatedWaterCombo= new JComboBox<String>();
		heatedWaterCombo.addItem("Yes");
		heatedWaterCombo.addItem("No");
		this.generatorCombo= new JComboBox<String>();
		generatorCombo.addItem("Yes");
		generatorCombo.addItem("No");
		this.bicycleStandCombo= new JComboBox<String>();
		bicycleStandCombo.addItem("Yes");
		bicycleStandCombo.addItem("No");
		this.microwaveCombo= new JComboBox<String>();
		microwaveCombo.addItem("Yes");
		microwaveCombo.addItem("No");
		this.roofHatchCombo= new JComboBox<String>();
		roofHatchCombo.addItem("Yes");
		roofHatchCombo.addItem("No");
		this.roofStorageCombo= new JComboBox<String>();
		roofStorageCombo.addItem("Yes");
		roofStorageCombo.addItem("No");
		this.childSeatCombo= new JComboBox<String>();
		childSeatCombo.addItem("Yes");
		childSeatCombo.addItem("No");
		this.trailerCouplingCombo= new JComboBox<String>();
		trailerCouplingCombo.addItem("Yes");
		trailerCouplingCombo.addItem("No");
		this.roofStorageCombo= new JComboBox<String>();
		roofStorageCombo.addItem("Yes");
		roofStorageCombo.addItem("No");
		this.regNoLabel= new JLabel("Reg. number: ");
		this.colorLabel= new JLabel("Color: ");
		this.modelLabel= new JLabel("Model: ");
		this.makerLabel= new JLabel("Maker: ");
		this.sizeSpecificationsLabel= new JLabel("Ext. dimensions: ");
		this.driverLicenseLabel= new JLabel("Dr.license: ");
		this.batterySizeLabel= new JLabel("Batteri size: ");
		this.batteryChargerLabel= new JLabel("Batteri charger: ");
		this.trunkCapacityLabel= new JLabel("Trunk capacity: ");
		this.roofStorageLabel= new JLabel("Roof storage: ");
		this.exteriorDimensionsLabel= new JLabel("Ext. dimensions: ");
		this.cargoSizeLabel= new JLabel("Cargo size: ");
		this.numberOfPeopleLabel= new JLabel("Nr. of people: ");
		this.numberOfBedsLabel= new JLabel("Nr. of beds: ");
		this.numberOfKmLabel= new JLabel("Kilometers: ");
		this.yearLabel= new JLabel("Year: ");
		this.horsePowerLabel= new JLabel("Hp: ");
		this.maintenanceRemainingKmLabel= new JLabel("Remaining km: ");
		this.numberOfDoorsLabel= new JLabel("Nr. of doors");
		this.numberOfSeatsLabel= new JLabel("Nr. of seats");
		this.engineSizeLabel= new JLabel("Engine: ");
		this.fuelConsumptionLabel= new JLabel("Fuel consumption: ");
		this.priceLabel= new JLabel("Price: ");
		this.loadCapacityLabel= new JLabel("Load capacity: ");
		this.transmissionLabel= new JLabel("Transmission: ");
		this.navigationSystemLabel= new JLabel("Navigation: ");
		this.cruiseControlLabel= new JLabel("Cruise control: ");
		this.refrigeratorLabel= new JLabel("Refrigerator: ");
		this.tvLabel= new JLabel("Tv: ");
		this.heatedWaterLabel= new JLabel("Heated watter: ");
		this.generatorLabel= new JLabel("Generator: ");
		this.bicycleStandLabel= new JLabel("Bike stand: ");
		this.microwaveLabel= new JLabel("Microwave: ");
		this.roofHatchLabel= new JLabel("Roof hatch: ");
		this.childSeatLabel= new JLabel("Child seat: ");
		this.trailerCouplingLabel= new JLabel("Trailer ready: ");		
	}
	
	
	
	
	public JPanel getAddVehiclePanel(){
		   
			Font font=new Font("Abel", Font.BOLD, 22);
			Font font2=new Font("Abel", Font.BOLD, 36);
			this.eachCarPanel= new JPanel();
			eachCarPanel.setBackground(Color.WHITE);
			this.carDescription= new JPanel();
			carDescription.setLayout(new GridLayout(0,2,30,20));
			this.carTitle= new JLabel("Add vehicle",SwingConstants.CENTER);
			this.northHolder= new JPanel();
			northHolder.setBackground(Color.WHITE);
			typePanel.setBackground(Color.WHITE);
			carTitle.setFont(font2);
			carDescription.setBackground(Color.WHITE);
			carDescription.setBorder(new EmptyBorder(30,160,30,160));
			
			typePanel.add(RdbtnFamilyCar);
			typePanel.add(RdbtnVan);
			typePanel.add(RdbtnMovingTruck);
			typePanel.add(RdbtnAutoCamper);
			
			northHolder.setLayout(new GridLayout(0,1,0,0));
			northHolder.add(carTitle);
			northHolder.add(typePanel);
			
			this.scrollContainer= new JPanel();
			this.scroll= new JScrollPane(carDescription,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scroll.setPreferredSize(new Dimension(920,400));
			this.btnAddVehicle= new JButton("Add the vehicle");
			Font buttonFont=new Font("Abel", Font.BOLD, 22);
			btnAddVehicle.setFont(buttonFont);
			btnAddVehicle.setForeground(new Color(0, 0, 128));
			btnAddVehicle.setBackground(new Color(255, 228, 181));
			btnAddVehicle.addActionListener(new AddVehicleButtonAction());
			scrollContainer.add(scroll);
			scrollContainer.add(btnAddVehicle);
			eachCarPanel.setLayout(new BorderLayout());
			eachCarPanel.add(northHolder,BorderLayout.NORTH);
			eachCarPanel.add(scrollContainer,BorderLayout.CENTER);
			
			//bind actions to radio buttons
			AddElementsToCarDescription action = new AddElementsToCarDescription();
			RdbtnFamilyCar.addActionListener(action);
			RdbtnVan.addActionListener(action);
			RdbtnMovingTruck.addActionListener(action);
			RdbtnAutoCamper.addActionListener(action);
			
			
			
			RdbtnFamilyCar.setSelected(true);
			addFamilyCarFields();
			
			return eachCarPanel;
		}
	
	public void addFamilyCarFields(){
		carDescription.add(regNoLabel);
		carDescription.add(regNoField);
		carDescription.add(makerLabel);
		carDescription.add(makerField);
		carDescription.add(modelLabel);
		carDescription.add(modelField);
		carDescription.add(priceLabel);
		carDescription.add(priceField);
		carDescription.add(engineSizeLabel);
		carDescription.add(engineSizeField);
		
		carDescription.add(fuelConsumptionLabel);
		carDescription.add(fuelConsumptionField);
		carDescription.add(yearLabel);
		carDescription.add(yearField);
		carDescription.add(colorLabel);
		carDescription.add(colorField);
		
		carDescription.add(transmissionLabel);
		carDescription.add(transmissionCombo);		
		carDescription.add(navigationSystemLabel);
		carDescription.add(navigationSystemCombo);		
		carDescription.add(cruiseControlLabel);
		carDescription.add(cruiseControlCombo);
		
		carDescription.add(numberOfDoorsLabel);
		carDescription.add(numberOfDoorsField);
		carDescription.add(numberOfSeatsLabel);
		carDescription.add(numberOfSeatsField);
		carDescription.add(trunkCapacityLabel);
		carDescription.add(trunkCapacityField);
		carDescription.add(numberOfKmLabel);
		carDescription.add(numberOfKmField);
		carDescription.add(horsePowerLabel);
		carDescription.add(horsePowerField);
		carDescription.add(roofStorageLabel);
		carDescription.add(roofStorageCombo);
		carDescription.add(trailerCouplingLabel);
		carDescription.add(trailerCouplingCombo);
		carDescription.add(childSeatLabel);
		carDescription.add(childSeatCombo);
	}
	
	public void addVanFields(){
		carDescription.add(regNoLabel);
		carDescription.add(regNoField);
		carDescription.add(makerLabel);
		carDescription.add(makerField);
		carDescription.add(modelLabel);
		carDescription.add(modelField);
		carDescription.add(priceLabel);
		carDescription.add(priceField);
		carDescription.add(engineSizeLabel);
		carDescription.add(engineSizeField);
		
		carDescription.add(fuelConsumptionLabel);
		carDescription.add(fuelConsumptionField);
		carDescription.add(yearLabel);
		carDescription.add(yearField);
		carDescription.add(colorLabel);
		carDescription.add(colorField);
		
		carDescription.add(numberOfKmLabel);
		carDescription.add(numberOfKmField);
		carDescription.add(horsePowerLabel);
		carDescription.add(horsePowerField);
		
		carDescription.add(transmissionLabel);
		carDescription.add(transmissionCombo);		
		carDescription.add(navigationSystemLabel);
		carDescription.add(navigationSystemCombo);		
		carDescription.add(cruiseControlLabel);
		carDescription.add(cruiseControlCombo);
		carDescription.add(driverLicenseLabel);
		carDescription.add(driverLicenseField);
		carDescription.add(cargoSizeLabel);
		carDescription.add(cargoSizeField);
		carDescription.add(numberOfSeatsLabel);
		carDescription.add(numberOfSeatsField);
		carDescription.add(numberOfDoorsLabel);
		carDescription.add(numberOfDoorsField);
		carDescription.add(loadCapacityLabel);
		carDescription.add(loadCapacityField);
		carDescription.add(roofStorageLabel);
		carDescription.add(roofStorageCombo);
	}
	
	public void addMovingTruckFields(){
		carDescription.add(regNoLabel);
		carDescription.add(regNoField);
		carDescription.add(makerLabel);
		carDescription.add(makerField);
		carDescription.add(modelLabel);
		carDescription.add(modelField);
		carDescription.add(priceLabel);
		carDescription.add(priceField);
		carDescription.add(engineSizeLabel);
		carDescription.add(engineSizeField);
		
		carDescription.add(fuelConsumptionLabel);
		carDescription.add(fuelConsumptionField);
		carDescription.add(yearLabel);
		carDescription.add(yearField);
		carDescription.add(colorLabel);
		carDescription.add(colorField);
		
		carDescription.add(numberOfKmLabel);
		carDescription.add(numberOfKmField);
		carDescription.add(horsePowerLabel);
		carDescription.add(horsePowerField);
		
		carDescription.add(transmissionLabel);
		carDescription.add(transmissionCombo);		
		carDescription.add(navigationSystemLabel);
		carDescription.add(navigationSystemCombo);		
		carDescription.add(cruiseControlLabel);
		carDescription.add(cruiseControlCombo);
		carDescription.add(driverLicenseLabel);
		carDescription.add(driverLicenseField);
		carDescription.add(cargoSizeLabel);
		carDescription.add(cargoSizeField);
		carDescription.add(loadCapacityLabel);
		carDescription.add(loadCapacityField);
		carDescription.add(exteriorDimensionsLabel);
		carDescription.add(exteriorDimensionsField);
		
	}
	
	public void addAutoCamperFields(){
		carDescription.add(regNoLabel);
		carDescription.add(regNoField);
		carDescription.add(makerLabel);
		carDescription.add(makerField);
		carDescription.add(modelLabel);
		carDescription.add(modelField);
		carDescription.add(priceLabel);
		carDescription.add(priceField);
		carDescription.add(engineSizeLabel);
		carDescription.add(engineSizeField);
		
		carDescription.add(fuelConsumptionLabel);
		carDescription.add(fuelConsumptionField);
		carDescription.add(yearLabel);
		carDescription.add(yearField);
		carDescription.add(colorLabel);
		carDescription.add(colorField);
		
		carDescription.add(numberOfKmLabel);
		carDescription.add(numberOfKmField);
		carDescription.add(horsePowerLabel);
		carDescription.add(horsePowerField);

		
		carDescription.add(transmissionLabel);
		carDescription.add(transmissionCombo);		
		carDescription.add(navigationSystemLabel);
		carDescription.add(navigationSystemCombo);		
		carDescription.add(cruiseControlLabel);
		carDescription.add(cruiseControlCombo);
		carDescription.add(driverLicenseLabel);
		carDescription.add(driverLicenseField);
		carDescription.add(roofStorageLabel);
		carDescription.add(roofStorageCombo);
		carDescription.add(numberOfPeopleLabel);
		carDescription.add(numberOfPeopleField);
		carDescription.add(sizeSpecificationsLabel);
		carDescription.add(sizeSpecificationsField);
		carDescription.add(refrigeratorLabel);
		carDescription.add(refrigeratorCombo);
		carDescription.add(tvLabel);
		carDescription.add(tvCombo);
		carDescription.add(heatedWaterLabel);
		carDescription.add(heatedWaterCombo);
		carDescription.add(batterySizeLabel);
		carDescription.add(batterySizeField);
		carDescription.add(batteryChargerLabel);
		carDescription.add(batteryChargerField);
		carDescription.add(generatorLabel);
		carDescription.add(generatorCombo);
		carDescription.add(bicycleStandLabel);
		carDescription.add(bicycleStandCombo);
		carDescription.add(numberOfBedsLabel);
		carDescription.add(numberOfBedsField);
		carDescription.add(microwaveLabel);
		carDescription.add(microwaveCombo);
		carDescription.add(roofHatchLabel);
		carDescription.add(roofHatchCombo);
	}
	
	
	public void resetAllFields(){
		changeLabelsToBlack();
		regNoField.setText("");
		colorField.setText("");
		modelField.setText("");
		makerField.setText("");
		sizeSpecificationsField.setText("");
		driverLicenseField.setText("");
		batterySizeField.setText("");
		batteryChargerField.setText("");
		trunkCapacityField.setText("");
		exteriorDimensionsField.setText("");
		cargoSizeField.setText("");
		numberOfPeopleField.setText("");
		numberOfBedsField.setText("");
		numberOfKmField.setText("");
		yearField.setText("");
		horsePowerField.setText("");
		maintenanceRemainingKmField.setText("");
		numberOfDoorsField.setText("");
		numberOfSeatsField.setText("");
		engineSizeField.setText("");
		fuelConsumptionField.setText("");
		priceField.setText("");
		loadCapacityField.setText("");
	}
	
	public void addVehicleButtonAction(){
			checkForEmptyStrings();
			AddVehicle addVechileFunctionality= new AddVehicle(this);
		    manageVehicle.showAllVehicles();
		
	}
	
	
	
	
	
	public boolean checkForEmptyStrings(){
		boolean flag=true;

		changeLabelsToBlack();

		
		
		if(regNoField.getText().equals("")){
			regNoLabel.setForeground(Color.RED);
			flag=false;}
		if(colorField.getText().equals("")){
			colorLabel.setForeground(Color.RED);
			flag=false;}
		if(modelField.getText().equals("")){
			modelLabel.setForeground(Color.RED);
			flag=false;}
		if(makerField.getText().equals("")){
			makerLabel.setForeground(Color.RED);
			flag=false;}
		if(sizeSpecificationsField.getText().equals("")){
			sizeSpecificationsLabel.setForeground(Color.RED);
			flag=false;}
		if(driverLicenseField.getText().equals("")){
			driverLicenseLabel.setForeground(Color.RED);
			flag=false;}
		if(batterySizeField.getText().equals("")){
			batterySizeLabel.setForeground(Color.RED);
			flag=false;}
		if(batteryChargerField.getText().equals("")){
			batteryChargerLabel.setForeground(Color.RED);
			flag=false;}
		if(trunkCapacityField.getText().equals("")){
			trunkCapacityLabel.setForeground(Color.RED);
			flag=false;}
		if(exteriorDimensionsField.getText().equals("")){
			exteriorDimensionsLabel.setForeground(Color.RED);
			flag=false;}
		if(cargoSizeField.getText().equals("")){
			cargoSizeLabel.setForeground(Color.RED);
			flag=false;}
		if(numberOfPeopleField.getText().equals("")){
			numberOfPeopleLabel.setForeground(Color.RED);
			flag=false;}
		if(numberOfBedsField.getText().equals("")){
			numberOfBedsLabel.setForeground(Color.RED);
			flag=false;}
		if(numberOfKmField.getText().equals("")){
			numberOfKmLabel.setForeground(Color.RED);
			flag=false;}
		if(yearField.getText().equals("")){
			yearLabel.setForeground(Color.RED);
			flag=false;}
		if(yearField.getText().equals("")){
			yearLabel.setForeground(Color.RED);
			flag=false;}
		if(horsePowerField.getText().equals("")){
			horsePowerLabel.setForeground(Color.RED);
			flag=false;}
		if(maintenanceRemainingKmField.getText().equals("")){
			maintenanceRemainingKmLabel.setForeground(Color.RED);
			flag=false;}
		if(numberOfDoorsField.getText().equals("")){
			numberOfDoorsLabel.setForeground(Color.RED);
			flag=false;}
		if(numberOfSeatsField.getText().equals("")){
			numberOfSeatsLabel.setForeground(Color.RED);
			flag=false;}
		if(engineSizeField.getText().equals("")){
			engineSizeLabel.setForeground(Color.RED);
			flag=false;}
		if(fuelConsumptionField.getText().equals("")){
			fuelConsumptionLabel.setForeground(Color.RED);
			flag=false;}
		if(priceField.getText().equals("")){
			priceLabel.setForeground(Color.RED);
			flag=false;}
		
		return flag;	
		}
	
	
	
	private void changeLabelsToBlack() {
		regNoLabel.setForeground(Color.BLACK);
		colorLabel.setForeground(Color.BLACK);
		modelLabel.setForeground(Color.BLACK);
		makerLabel.setForeground(Color.BLACK);
		sizeSpecificationsLabel.setForeground(Color.BLACK);
		driverLicenseLabel.setForeground(Color.BLACK);
		batterySizeLabel.setForeground(Color.BLACK);
		batteryChargerLabel.setForeground(Color.BLACK);
		trunkCapacityLabel.setForeground(Color.BLACK);
		exteriorDimensionsLabel.setForeground(Color.BLACK);
		cargoSizeLabel.setForeground(Color.BLACK);
		numberOfPeopleLabel.setForeground(Color.BLACK);
		numberOfBedsLabel.setForeground(Color.BLACK);
		numberOfKmLabel.setForeground(Color.BLACK);
		yearLabel.setForeground(Color.BLACK);
		yearLabel.setForeground(Color.BLACK);
		horsePowerLabel.setForeground(Color.BLACK);
		maintenanceRemainingKmLabel.setForeground(Color.BLACK);
		numberOfDoorsLabel.setForeground(Color.BLACK);
		numberOfSeatsLabel.setForeground(Color.BLACK);
		engineSizeLabel.setForeground(Color.BLACK);
		fuelConsumptionLabel.setForeground(Color.BLACK);
		priceLabel.setForeground(Color.BLACK);
		
	}



	private class AddVehicleButtonAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			addVehicleButtonAction();
		}
		}
	
	

	
	
	private class AddElementsToCarDescription implements ActionListener{
		public void actionPerformed(ActionEvent e){
			 if(RdbtnFamilyCar.isSelected()){
				 carDescription.removeAll();
				 carDescription.repaint();
				 carDescription.revalidate();
				 resetAllFields();
				 addFamilyCarFields();
				 carDescription.repaint();
				 carDescription.revalidate();
			}
			 if(RdbtnVan.isSelected()){
				 carDescription.removeAll();
				 carDescription.repaint();
				 carDescription.revalidate();
				 resetAllFields();
				 addVanFields();
				 carDescription.repaint();
				 carDescription.revalidate();
			}
			 if(RdbtnMovingTruck.isSelected()){
				 carDescription.removeAll();
				 carDescription.repaint();
				 carDescription.revalidate();
				 resetAllFields();
				 addMovingTruckFields();
				 carDescription.repaint();
				 carDescription.revalidate();
			}
			 if(RdbtnAutoCamper.isSelected()){
				 carDescription.removeAll();
				 carDescription.repaint();
				 carDescription.revalidate();
				 resetAllFields();
				 addAutoCamperFields();
				 carDescription.repaint();
				 carDescription.revalidate();
			}
		}
	}
	



	public JTextField getRegNoField() {
		return regNoField;
	}




	public JTextField getColorField() {
		return colorField;
	}




	public JTextField getModelField() {
		return modelField;
	}




	public JTextField getMakerField() {
		return makerField;
	}




	public JTextField getSizeSpecificationsField() {
		return sizeSpecificationsField;
	}




	public JTextField getDriverLicenseField() {
		return driverLicenseField;
	}




	public JTextField getBatterySizeField() {
		return batterySizeField;
	}




	public JTextField getBatteryChargerField() {
		return batteryChargerField;
	}




	public JTextField getTrunkCapacityField() {
		return trunkCapacityField;
	}




	public JTextField getExteriorDimensionsField() {
		return exteriorDimensionsField;
	}




	public JTextField getCargoSizeField() {
		return cargoSizeField;
	}




	public JTextField getNumberOfPeopleField() {
		return numberOfPeopleField;
	}




	public JTextField getNumberOfBedsField() {
		return numberOfBedsField;
	}




	public JTextField getNumberOfKmField() {
		return numberOfKmField;
	}




	public JTextField getYearField() {
		return yearField;
	}




	public JTextField getHorsePowerField() {
		return horsePowerField;
	}




	public JTextField getMaintenanceRemainingKmField() {
		return maintenanceRemainingKmField;
	}




	public JTextField getNumberOfDoorsField() {
		return numberOfDoorsField;
	}




	public JTextField getNumberOfSeatsField() {
		return numberOfSeatsField;
	}




	public JTextField getEngineSizeField() {
		return engineSizeField;
	}




	public JTextField getFuelConsumptionField() {
		return fuelConsumptionField;
	}




	public JTextField getPriceField() {
		return priceField;
	}




	public JTextField getLoadCapacityField() {
		return loadCapacityField;
	}




	public JComboBox<String> getRoofStorageCombo() {
		return roofStorageCombo;
	}




	public JComboBox<String> getTransmissionCombo() {
		return transmissionCombo;
	}




	public JComboBox<String> getNavigationSystemCombo() {
		return navigationSystemCombo;
	}




	public JComboBox<String> getCruiseControlCombo() {
		return cruiseControlCombo;
	}




	public JComboBox<String> getRefrigeratorCombo() {
		return refrigeratorCombo;
	}




	public JComboBox<String> getTvCombo() {
		return tvCombo;
	}




	public JComboBox<String> getHeatedWaterCombo() {
		return heatedWaterCombo;
	}




	public JComboBox<String> getGeneratorCombo() {
		return generatorCombo;
	}




	public JComboBox<String> getBicycleStandCombo() {
		return bicycleStandCombo;
	}




	public JComboBox<String> getMicrowaveCombo() {
		return microwaveCombo;
	}




	public JComboBox<String> getRoofHatchCombo() {
		return roofHatchCombo;
	}




	public JComboBox<String> getChildSeatCombo() {
		return childSeatCombo;
	}




	public JComboBox<String> getTrailerCouplingCombo() {
		return trailerCouplingCombo;
	}




	public JLabel getRegNoLabel() {
		return regNoLabel;
	}




	public JLabel getColorLabel() {
		return colorLabel;
	}




	public JLabel getModelLabel() {
		return modelLabel;
	}




	public JLabel getMakerLabel() {
		return makerLabel;
	}




	public JLabel getSizeSpecificationsLabel() {
		return sizeSpecificationsLabel;
	}




	public JLabel getDriverLicenseLabel() {
		return driverLicenseLabel;
	}




	public JLabel getBatterySizeLabel() {
		return batterySizeLabel;
	}




	public JLabel getBatteryChargerLabel() {
		return batteryChargerLabel;
	}




	public JLabel getTrunkCapacityLabel() {
		return trunkCapacityLabel;
	}




	public JLabel getExteriorDimensionsLabel() {
		return exteriorDimensionsLabel;
	}




	public JLabel getCargoSizeLabel() {
		return cargoSizeLabel;
	}




	public JLabel getNumberOfPeopleLabel() {
		return numberOfPeopleLabel;
	}




	public JLabel getNumberOfBedsLabel() {
		return numberOfBedsLabel;
	}




	public JLabel getNumberOfKmLabel() {
		return numberOfKmLabel;
	}




	public JLabel getYearLabel() {
		return yearLabel;
	}




	public JLabel getHorsePowerLabel() {
		return horsePowerLabel;
	}




	public JLabel getMaintenanceRemainingKmLabel() {
		return maintenanceRemainingKmLabel;
	}




	public JLabel getNumberOfDoorsLabel() {
		return numberOfDoorsLabel;
	}




	public JLabel getNumberOfSeatsLabel() {
		return numberOfSeatsLabel;
	}




	public JLabel getEngineSizeLabel() {
		return engineSizeLabel;
	}




	public JLabel getFuelConsumptionLabel() {
		return fuelConsumptionLabel;
	}




	public JLabel getPriceLabel() {
		return priceLabel;
	}




	public JLabel getLoadCapacityLabel() {
		return loadCapacityLabel;
	}




	public JLabel getTransmissionLabel() {
		return transmissionLabel;
	}




	public JLabel getNavigationSystemLabel() {
		return navigationSystemLabel;
	}




	public JLabel getCruiseControlLabel() {
		return cruiseControlLabel;
	}




	public JLabel getRefrigeratorLabel() {
		return refrigeratorLabel;
	}




	public JLabel getTvLabel() {
		return tvLabel;
	}




	public JLabel getHeatedWaterLabel() {
		return heatedWaterLabel;
	}




	public JLabel getGeneratorLabel() {
		return generatorLabel;
	}




	public JLabel getBicycleStandLabel() {
		return bicycleStandLabel;
	}




	public JLabel getMicrowaveLabel() {
		return microwaveLabel;
	}




	public JLabel getRoofHatchLabel() {
		return roofHatchLabel;
	}




	public JLabel getChildSeatLabel() {
		return childSeatLabel;
	}




	public JLabel getTrailerCouplingLabel() {
		return trailerCouplingLabel;
	}




	public JLabel getRoofStorageLabel() {
		return roofStorageLabel;
	}




	public JRadioButton getRdbtnFamilyCar() {
		return RdbtnFamilyCar;
	}




	public JRadioButton getRdbtnVan() {
		return RdbtnVan;
	}




	public JRadioButton getRdbtnMovingTruck() {
		return RdbtnMovingTruck;
	}




	public JRadioButton getRdbtnAutoCamper() {
		return RdbtnAutoCamper;
	}




	public TitledBorder getTitleTypePanel() {
		return titleTypePanel;
	}




	public JPanel getTypePanel() {
		return typePanel;
	}




	public Font getCategoryTitleFont() {
		return categoryTitleFont;
	}




	public ButtonGroup getRdbGroup() {
		return rdbGroup;
	}




	public JPanel getCarDescription() {
		return carDescription;
	}




	public JPanel getEachCarPanel() {
		return eachCarPanel;
	}




	public JLabel getCarTitle() {
		return carTitle;
	}




	public JPanel getNorthHolder() {
		return northHolder;
	}




	public JPanel getScrollContainer() {
		return scrollContainer;
	}




	public JScrollPane getScroll() {
		return scroll;
	}
	
	
}
