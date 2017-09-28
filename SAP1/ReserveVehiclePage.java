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
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import java.awt.GridBagConstraints;

import javax.swing.JComboBox;

/**
 * 
 * @author Group 4
 *
 */

public class ReserveVehiclePage{

	
//declare RESERVE VEHICLE PAGE
	private JPanel searchPanel = new JPanel();
	private JFrame mainFrame;
	
	
//search option zone
		JPanel reserve00Panel=new JPanel();
		JPanel reserve01Panel=new JPanel();
		TitledBorder titleReserve = BorderFactory.createTitledBorder("Reserve a vehicle");
		JPanel reserve02Panel=new JPanel();
		TitledBorder titleType = BorderFactory.createTitledBorder("Car type");
		CardLayout cardCarOption;
		JPanel reserve03Panel;
		TitledBorder titleCarOptions = BorderFactory.createTitledBorder("Family car option");
		TitledBorder titleCarOptions2 = BorderFactory.createTitledBorder("Van car option");
		TitledBorder titleCarOptions3 = BorderFactory.createTitledBorder("Moving Truck car option");
		TitledBorder titleCarOptions4 = BorderFactory.createTitledBorder("Autocamper car option");
		JPanel reserve04Panel=new JPanel();
		TitledBorder titlePrice= BorderFactory.createTitledBorder("Select price");
		JPanel reserve05Panel=new JPanel();
		TitledBorder titleDate= BorderFactory.createTitledBorder("Select date");
		JPanel reserve06Panel=new JPanel();
		TitledBorder titleLocation= BorderFactory.createTitledBorder("Pickup/Drop Location");
		JPanel reserve07Panel=new JPanel();
		JPanel reserve08Panel=new JPanel();	
		
		JButton btnSearch = new JButton("Search");
//search option zone end
			
		
//car type
		 JLabel lblReserveACar = new JLabel("Reserve a car");
		 JRadioButton rdbtnFamilyCar = new JRadioButton("Family car");
		 JRadioButton rdbtnMovingTruck = new JRadioButton("Moving truck");
		 JRadioButton rdbtnVan = new JRadioButton("Van");
		 JRadioButton rdbtnAutoCamper = new JRadioButton("Auto camper");
		 JButton btnBack = new JButton("Back");
//car type end
		
	
// panel for FamilyCars, Vans, Moving Trucks, Auto Campers start
		 JPanel familyCarsOptions= new JPanel();
		 JPanel vansOptions= new JPanel();
		 JPanel movingTrucksOptions= new JPanel();
		 JPanel autoCampersOptions= new JPanel();
// panel for FamilyCars, Vans, Moving Trucks, Auto Campers end
			

//price combo box
		 JComboBox comboPrice= new JComboBox();
		 

//date combo date START
		 JComboBox comboStartDay= new JComboBox();
		 JComboBox comboStartMonth= new JComboBox();
		 JComboBox comboStartYear= new JComboBox();
		 
		 JComboBox comboEndDay= new JComboBox();
		 JComboBox comboEndMonth= new JComboBox();
		 JComboBox comboEndYear= new JComboBox();
//date combo date END
		 
		 
//pickup location START	
		 JComboBox comboPickupLocation= new JComboBox();
		 JComboBox comboDropLocation= new JComboBox();
		 JComboBox comboPiclupTime= new JComboBox();
//pickup location START

		 
//display the cars that fit the requirements START
		 JPanel displayCarsInList= new JPanel();
		 JScrollPane scrollPane = new JScrollPane(displayCarsInList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 TitledBorder titleForDisplayCarsInList= new TitledBorder("Chose the vehicle to reserve");
		 
//display the cars that fit the requirements START
		 
		 
		 
//familyCars combo boxes
		 JComboBox comboMake = new JComboBox(); //
		 JComboBox comboModel = new JComboBox(); //
		 JComboBox comboColor = new JComboBox(); //
		 JComboBox comboTransmition = new JComboBox(); //
		 JComboBox comboYear = new JComboBox(); //
		 JComboBox comboEngineSize = new JComboBox(); //
		 JComboBox comboFuelConsumption = new JComboBox(); //
		 JComboBox comboNavigation = new JComboBox(); //
		 JComboBox comboCruiseControl = new JComboBox(); //
		 JComboBox comboNumberOfDoors = new JComboBox();
		 JComboBox comboNumberOfSeats = new JComboBox();
		 JComboBox comboChildSeat = new JComboBox();
		 JComboBox comboTruncCapacity = new JComboBox();
		 JComboBox comboTrailerCopling = new JComboBox();
		 JComboBox comboRoofStorage = new JComboBox();	
		 JComboBox comboHp = new JComboBox();
//familyCars combo boxes
		 
		 
//Vans combo boxes
		 JComboBox comboMake1 = new JComboBox();
		 JComboBox comboModel1 = new JComboBox();
		 JComboBox comboColor1 = new JComboBox();
		 JComboBox comboTransmition1 = new JComboBox();
		 JComboBox comboYear1 = new JComboBox();
		 JComboBox comboEngineSize1 = new JComboBox();
		 JComboBox comboFuelConsumption1 = new JComboBox();
		 JComboBox comboNavigation1 = new JComboBox();
		 JComboBox comboCruiseControl1 = new JComboBox();
		 JComboBox comboNumberOfDoors1 = new JComboBox();
		 JComboBox comboNumberOfSeats1 = new JComboBox();
		 JComboBox comboChildSeat1 = new JComboBox();
		 JComboBox comboDrLicense1 = new JComboBox();
		 JComboBox comboRoofStorage1 = new JComboBox();	
		 JComboBox comboHp1 = new JComboBox();
		 JComboBox comboCargoSize = new JComboBox();
		 JComboBox comboLoadCapacity = new JComboBox();
		 //JComboBox comboRoofStorage = new JComboBox();
//Vans combo boxes		 
	

		 
//Moving Trucks combo boxes
		 JComboBox comboMake2 = new JComboBox();
		 JComboBox comboModel2 = new JComboBox();
		 JComboBox comboColor2 = new JComboBox();
		 JComboBox comboTransmition2 = new JComboBox();
		 JComboBox comboYear2 = new JComboBox();
		 JComboBox comboEngineSize2 = new JComboBox();
		 JComboBox comboFuelConsumption2 = new JComboBox();
		 JComboBox comboNavigation2 = new JComboBox();
		 JComboBox comboCruiseControl2 = new JComboBox();
		 JComboBox comboDrLicense2 = new JComboBox();
		 JComboBox comboHp2 = new JComboBox();
		 JComboBox comboCargoSize2 = new JComboBox();
		 JComboBox comboLoadCapacity2 = new JComboBox();
		 JComboBox comboExtDim2 = new JComboBox();
//Moving Trucks	 combo boxes	 
		 
		 
//AutoCamper combo boxes	
		 JComboBox comboMake4 = new JComboBox(); //
		 JComboBox comboModel4 = new JComboBox(); //
		 JComboBox comboColor4 = new JComboBox(); //
		 JComboBox comboTransmition4 = new JComboBox(); //
		 JComboBox comboYear4 = new JComboBox(); //
		 JComboBox comboEngineSize4 = new JComboBox(); //
		 JComboBox comboFuelConsumption4 = new JComboBox(); //
		 JComboBox comboNavigation4 = new JComboBox(); //
		 JComboBox comboCruiseControl4 = new JComboBox(); //
		 JComboBox comboNrOfPeople = new JComboBox();
		 JComboBox comboExtSize = new JComboBox();
		 JComboBox comboDrLicense4 = new JComboBox();
		 JComboBox comboRefregerator = new JComboBox();
		 JComboBox comboTv = new JComboBox();
		 JComboBox comboHeatedWater = new JComboBox();
		 JComboBox comboBattery = new JComboBox();
		 JComboBox comboBatteryCharger = new JComboBox();
		 JComboBox comboGenerator = new JComboBox();
		 JComboBox comboBicicleStand = new JComboBox();
		 JComboBox comboNumberOfBeds = new JComboBox();
		 JComboBox comboMicrowave = new JComboBox();
		 JComboBox comboRoofHatch = new JComboBox();
//AutoCamper combo boxes		 
		 
		
//main panel where the page is added
	JPanel mainPanelCardLayaout;
	JPanel panelMenuGrid;
	ShowBestCarOptions action = new ShowBestCarOptions();

	
	

public ReserveVehiclePage(JPanel mainPanelCardLayaout, JPanel panelMenuGrid){
	this.mainPanelCardLayaout=mainPanelCardLayaout;
	this.panelMenuGrid=panelMenuGrid;
	buildSearchPage();
	
}

public JPanel getSearchPagePanel(){
	return searchPanel;
}


public void buildSearchPage(){

	actionBackButton();
	addBackButton();
	familyCarAreaAddElements();		
	movingTrucksCarOptionsAddElements();
	autoCamperCarOptionsAddElements();
	vanCarOptionsAddElements();
	carOptionsAreaAddCards();
	titleAreaAddElements();
	carTypeAddElements();
	actionsForCarTypeRadioButtons();
	radioButtonsAddToRadioGroup();
	createMainLayoutSearchPage();	

	addSearchButton();
	customizeInterfaceSearchPage();
	displayAvailableCarList();

}

private void displayAvailableCarList(){
	//car example

		
		JPanel car1= new JPanel(new GridLayout(1,4,0,0));
		car1.setBorder(new EmptyBorder(20,10,20,10));
		JPanel carDetailsText= new JPanel(new GridLayout(2,1,0,0));
		JPanel carButtons= new JPanel(new GridLayout(1,2,10,10));
		JLabel carDetail1= new JLabel("Mercedes, C220, 2.2, 23.5km/l");
		JLabel carDetail2= new JLabel("Nav: yes, Autopilot: yes, Seats: 5");
		JButton buttonView= new JButton("View");
		JButton buttonReserve= new JButton("Reserve");
		carDetailsText.add(carDetail1);
		carDetailsText.add(carDetail2);
		carButtons.add(buttonView);
		carButtons.add(buttonReserve);
		car1.add(carDetailsText);
		car1.add(new JLabel(""));
		car1.add(new JLabel(""));
		car1.add(carButtons);
		
		Font buttonFont=new Font("Abel", Font.BOLD, 18);
		buttonView.setFont(buttonFont);
		buttonView.setForeground(new Color(0, 0, 128));
		buttonView.setBackground(new Color(255, 228, 181));
		buttonView.addActionListener(new ShowCarDetails());
		
		buttonReserve.setFont(buttonFont);
		buttonReserve.setForeground(new Color(0, 0, 128));
		buttonReserve.setBackground(new Color(255, 228, 181));
		

		
		//car example
				JPanel car11= new JPanel(new GridLayout(1,4,0,0));
				car11.setBorder(new EmptyBorder(20,10,20,10));
				JPanel carDetailsText1= new JPanel(new GridLayout(2,1,0,0));
				JPanel carButtons1= new JPanel(new GridLayout(1,2,10,10));
				JLabel carDetail11= new JLabel("Mercedes, C220, 2.2, 23.5km/l");
				JLabel carDetail21= new JLabel("Nav: yes, Autopilot: yes, Seats: 5");
				JButton buttonView1= new JButton("View");
				JButton buttonReserve1= new JButton("Reserve");
				carDetailsText1.add(carDetail11);
				carDetailsText1.add(carDetail21);
				carButtons1.add(buttonView1);
				carButtons1.add(buttonReserve1);
				car11.add(carDetailsText1);
				car11.add(new JLabel(""));
				car11.add(new JLabel(""));
				car11.add(carButtons1);
				
				//car example
				JPanel car12= new JPanel(new GridLayout(1,4,0,0));
				car12.setBorder(new EmptyBorder(20,10,20,10));
				JPanel carDetailsText2= new JPanel(new GridLayout(2,1,0,0));
				JPanel carButtons2= new JPanel(new GridLayout(1,2,10,10));
				JLabel carDetail12= new JLabel("Mercedes, C220, 2.2, 23.5km/l");
				JLabel carDetail22= new JLabel("Nav: yes, Autopilot: yes, Seats: 5");
				JButton buttonView2= new JButton("View");
				JButton buttonReserve2= new JButton("Reserve");
				carDetailsText2.add(carDetail12);
				carDetailsText2.add(carDetail22);
				carButtons2.add(buttonView2);
				carButtons2.add(buttonReserve2);
				car12.add(carDetailsText2);
				car12.add(new JLabel(""));
				car12.add(new JLabel(""));
				car12.add(carButtons2);
	
	Font categoryTitleFont= new Font("Abel",Font.BOLD, 14);
	titleForDisplayCarsInList.setTitleFont(categoryTitleFont);
	reserve08Panel.setBorder(titleForDisplayCarsInList);
	reserve08Panel.setLayout(new GridLayout(1,1,0,0));
	//scrollPane.setBounds(0, 0, 1000, 700);
	displayCarsInList.setBorder(new EmptyBorder(10,10,10,10));
	displayCarsInList.setPreferredSize(new Dimension(1000, 300));
	displayCarsInList.setBackground(Color.WHITE);
	displayCarsInList.setLayout(new GridLayout(0,1,5,5));
	//displayCarsInList.add(scrollPane,BorderLayout.CENTER);
	//reserve08Panel.setBounds(0, 0, 1000, 500);
	//reserve08Panel.setPreferredSize(new Dimension(1000, 500));
	displayCarsInList.add(car1);
	displayCarsInList.add(car11);
	displayCarsInList.add(car12);
	reserve08Panel.add(scrollPane);
	
	
	
	
}

public JPanel getCarListPanel(){
	return 	displayCarsInList;
}

private void addSearchButton(){
	reserve07Panel.add(btnSearch);
}

private void addBackButton(){
	reserve00Panel.add(btnBack);
}


private void radioButtonsAddToRadioGroup() {
	ButtonGroup carTypeGroupOfRadioButtons = new ButtonGroup();
	carTypeGroupOfRadioButtons.add(rdbtnFamilyCar);
	carTypeGroupOfRadioButtons.add(rdbtnMovingTruck);
	carTypeGroupOfRadioButtons.add(rdbtnVan);
	carTypeGroupOfRadioButtons.add(rdbtnAutoCamper);
	
}

private void actionBackButton() {
	btnBack.addActionListener(new ToFirstPage());
}

private void actionSearchButton(){
	
	
}


private void actionsForCarTypeRadioButtons() {
	rdbtnFamilyCar.addActionListener(action);
	rdbtnVan.addActionListener(action);
	rdbtnMovingTruck.addActionListener(action);
	rdbtnAutoCamper.addActionListener(action);
}

private void carOptionsAreaAddCards() {
	cardCarOption= new CardLayout();
	reserve03Panel=new JPanel(cardCarOption);
	reserve03Panel.add(familyCarsOptions,"familyCars");
	reserve03Panel.add(vansOptions,"vans");
	reserve03Panel.add(movingTrucksOptions,"movingTrucks");
	reserve03Panel.add(autoCampersOptions,"autoCampers");
	
}

private void customizeInterfaceSearchPage() {
	searchPanel.setBorder(new EmptyBorder(20, 30, 20, 30));
	searchPanel.setBackground(Color.WHITE);
	Font categoryTitleFont= new Font("Abel",Font.BOLD, 14);
	reserve01Panel.setBackground(Color.WHITE);
	lblReserveACar.setHorizontalAlignment(SwingConstants.LEFT);
	lblReserveACar.setFont(new Font("Tahoma", Font.BOLD, 32));
	reserve02Panel.setBackground(Color.WHITE);
	reserve02Panel.setLayout(new FlowLayout(FlowLayout.LEADING));
	reserve07Panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
	
	reserve03Panel.setBackground(Color.WHITE);
	reserve04Panel.setBackground(Color.WHITE);
	reserve05Panel.setBackground(Color.WHITE);
	reserve06Panel.setBackground(Color.WHITE);
	reserve07Panel.setBackground(Color.WHITE);
	reserve08Panel.setBackground(Color.WHITE);
	reserve00Panel.setBackground(Color.WHITE);
	
	familyCarsOptions.setBackground(Color.WHITE);
	vansOptions.setBackground(Color.WHITE);
	movingTrucksOptions.setBackground(Color.WHITE);
	autoCampersOptions.setBackground(Color.WHITE);
	
	Font buttonFont=new Font("Abel", Font.BOLD, 22);
	btnSearch.setFont(buttonFont);
	btnSearch.setForeground(new Color(0, 0, 128));
	btnSearch.setBackground(new Color(255, 228, 181));
	
	btnBack.setForeground(new Color(0, 0, 128));
	btnBack.setBackground(new Color(255, 228, 181));
	btnBack.setFont(buttonFont);
	
	
	
	//place borders and titles for each line
	titleType.setTitleFont(categoryTitleFont);
	titleCarOptions.setTitleFont(categoryTitleFont);
	titleCarOptions2.setTitleFont(categoryTitleFont);
	titleCarOptions3.setTitleFont(categoryTitleFont);
	titleCarOptions4.setTitleFont(categoryTitleFont);
	titlePrice.setTitleFont(categoryTitleFont);
	titleDate.setTitleFont(categoryTitleFont);
	titleLocation.setTitleFont(categoryTitleFont);
	
	reserve02Panel.setBorder(titleType);
	reserve03Panel.setBorder(titleCarOptions);
    reserve04Panel.setBorder(titlePrice);			
	reserve05Panel.setBorder(titleDate);			
	reserve06Panel.setBorder(titleLocation);
	
	
	
	
	
	//set some layouts
	reserve00Panel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
	
}


private void priceCategoryAddElements(){
	reserve04Panel.setLayout(new FlowLayout(FlowLayout.LEADING));
	reserve04Panel.add(new JLabel("Select price:"));
	reserve04Panel.add(comboPrice);
}


private void dateCategoryAddElements(){
	reserve05Panel.setLayout(new FlowLayout(FlowLayout.LEADING));
	reserve05Panel.add(new JLabel("Select start date:  "));
	reserve05Panel.add(comboStartDay);
	reserve05Panel.add(comboStartMonth);
	reserve05Panel.add(comboStartYear);
	reserve05Panel.add(new JLabel("   Select end date:  "));
	reserve05Panel.add(comboEndDay);
	reserve05Panel.add(comboEndMonth);
	reserve05Panel.add(comboEndYear);
	
}

private void locationCategoryAddElements() {
	reserve06Panel.setLayout(new FlowLayout(FlowLayout.LEADING));
	reserve06Panel.add(new JLabel("Select pick-up location:  "));
	reserve06Panel.add(comboPickupLocation);
	reserve06Panel.add(new JLabel("     Select delivery location:  "));
	reserve06Panel.add(comboDropLocation);
	reserve06Panel.add(new JLabel("     Select pick-up time:  "));
	reserve06Panel.add(comboPiclupTime);
	
}

private void carTypeAddElements() {
	rdbtnFamilyCar.setSelected(true);
	reserve02Panel.add(rdbtnFamilyCar);		
	reserve02Panel.add(rdbtnMovingTruck);
	reserve02Panel.add(rdbtnVan);
	reserve02Panel.add(rdbtnAutoCamper);
	
}

private void titleAreaAddElements() {
	reserve01Panel.add(lblReserveACar);	
	
	
}


private void autoCamperCarOptionsAddElements() {

	//set layout
	autoCampersOptions.setLayout(new GridLayout(0, 10, 30, 5));
	
	//add elements
	autoCampersOptions.add(new JLabel("Make: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboMake4);
	autoCampersOptions.add(new JLabel("Model: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboModel4);
	autoCampersOptions.add(new JLabel("Color: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboColor4);
	autoCampersOptions.add(new JLabel("Transmision: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboTransmition4);
	autoCampersOptions.add(new JLabel("Engine: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboEngineSize4);
	autoCampersOptions.add(new JLabel("Consumption: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboFuelConsumption4);
	autoCampersOptions.add(new JLabel("Navigation: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboNavigation4);
	autoCampersOptions.add(new JLabel("Autopilot: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboCruiseControl4);
	autoCampersOptions.add(new JLabel("People nr.: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboNrOfPeople);
	autoCampersOptions.add(new JLabel("Size: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboExtSize);
	autoCampersOptions.add(new JLabel("License: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboDrLicense4);
	autoCampersOptions.add(new JLabel("Refrigerator: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboRefregerator);
	autoCampersOptions.add(new JLabel("Television: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboTv);
	autoCampersOptions.add(new JLabel("Heated water: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboHeatedWater);
	autoCampersOptions.add(new JLabel("Battery cap.: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboBattery);
	autoCampersOptions.add(new JLabel("Charger type: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboBatteryCharger);
	autoCampersOptions.add(new JLabel("Generator: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboGenerator);
	autoCampersOptions.add(new JLabel("Bicycle stand: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboBicicleStand);
	autoCampersOptions.add(new JLabel("Nr. beds: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboNumberOfBeds);
	autoCampersOptions.add(new JLabel("Oven microw.: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboMicrowave);
	autoCampersOptions.add(new JLabel("Roof hatch: ",SwingConstants.RIGHT));
	autoCampersOptions.add(comboRoofHatch);
	
	//border ass padding for the inside card familyCars
	autoCampersOptions.setBorder(new EmptyBorder(10, 0, 10, 10));
}

private void movingTrucksCarOptionsAddElements() {

	//set layout
	movingTrucksOptions.setLayout(new GridLayout(0, 10, 30, 5));
	
	//add elements
	movingTrucksOptions.add(new JLabel("Make: ",SwingConstants.RIGHT));
	movingTrucksOptions.add(comboMake2);
	movingTrucksOptions.add(new JLabel("Model: ",SwingConstants.RIGHT));
	movingTrucksOptions.add(comboModel2);
	movingTrucksOptions.add(new JLabel("Color: ",SwingConstants.RIGHT));
	movingTrucksOptions.add(comboColor2);
	movingTrucksOptions.add(new JLabel("Transmision: ",SwingConstants.RIGHT));
	movingTrucksOptions.add(comboTransmition2);
	movingTrucksOptions.add(new JLabel("Engine: ",SwingConstants.RIGHT));
	movingTrucksOptions.add(comboEngineSize2);
	movingTrucksOptions.add(new JLabel("Consumption: ",SwingConstants.RIGHT));
	movingTrucksOptions.add(comboFuelConsumption2);
	movingTrucksOptions.add(new JLabel("Navigation: ",SwingConstants.RIGHT));
	movingTrucksOptions.add(comboNavigation2);
	movingTrucksOptions.add(new JLabel("Autopilot",SwingConstants.RIGHT));
	movingTrucksOptions.add(comboCruiseControl2);
	movingTrucksOptions.add(new JLabel("License: ",SwingConstants.RIGHT));
	movingTrucksOptions.add(comboDrLicense2);
	movingTrucksOptions.add(new JLabel("Hp: ",SwingConstants.RIGHT));
	movingTrucksOptions.add(comboHp2);
	movingTrucksOptions.add(new JLabel("Cargo size: ",SwingConstants.RIGHT));
	movingTrucksOptions.add(comboCargoSize2);
	movingTrucksOptions.add(new JLabel("Max. load: ",SwingConstants.RIGHT));
	movingTrucksOptions.add(comboLoadCapacity2);
	movingTrucksOptions.add(new JLabel("Dimensions: ",SwingConstants.RIGHT));
	movingTrucksOptions.add(comboExtDim2);
	movingTrucksOptions.add(new JLabel(""));
	movingTrucksOptions.add(new JLabel(""));
	movingTrucksOptions.add(new JLabel(""));
	movingTrucksOptions.add(new JLabel(""));
	movingTrucksOptions.add(new JLabel(""));
	movingTrucksOptions.add(new JLabel(""));
	movingTrucksOptions.add(new JLabel(""));
	movingTrucksOptions.add(new JLabel(""));
	movingTrucksOptions.add(new JLabel(""));
	movingTrucksOptions.add(new JLabel(""));
	movingTrucksOptions.add(new JLabel(""));
	movingTrucksOptions.add(new JLabel(""));
	movingTrucksOptions.add(new JLabel(""));
	movingTrucksOptions.add(new JLabel(""));
	movingTrucksOptions.add(new JLabel(""));
	
	//border padding for the inside card familyCars
	movingTrucksOptions.setBorder(new EmptyBorder(10, 0, 10, 10));
}


private void vanCarOptionsAddElements() {

	//set layout
	vansOptions.setLayout(new GridLayout(0, 10, 30, 5));
	
	//add elements
	vansOptions.add(new JLabel("Make: ",SwingConstants.RIGHT));
	vansOptions.add(comboMake1);
	vansOptions.add(new JLabel("Model: ",SwingConstants.RIGHT));
	vansOptions.add(comboModel1);
	vansOptions.add(new JLabel("Engine: ",SwingConstants.RIGHT));
	vansOptions.add(comboEngineSize1);
	vansOptions.add(new JLabel("Hp: ",SwingConstants.RIGHT));
	vansOptions.add(comboHp1);
	vansOptions.add(new JLabel("Consumption: ",SwingConstants.RIGHT));
	vansOptions.add(comboFuelConsumption1);
	vansOptions.add(new JLabel("Transmision: ",SwingConstants.RIGHT));
	vansOptions.add(comboTransmition1);
	vansOptions.add(new JLabel("Doors: ",SwingConstants.RIGHT));
	vansOptions.add(comboNumberOfDoors1);
	vansOptions.add(new JLabel("Navigation: ",SwingConstants.RIGHT));
	vansOptions.add(comboNavigation1);
	vansOptions.add(new JLabel("Autopilot: ",SwingConstants.RIGHT));
	vansOptions.add(comboCruiseControl1);
	vansOptions.add(new JLabel("Seats: ",SwingConstants.RIGHT));
	vansOptions.add(comboNumberOfSeats1);
	vansOptions.add(new JLabel("Roof storage: ",SwingConstants.RIGHT));
	vansOptions.add(comboRoofStorage1);
	vansOptions.add(new JLabel("License: ",SwingConstants.RIGHT));
	vansOptions.add(comboDrLicense1);
	vansOptions.add(new JLabel("Year: ",SwingConstants.RIGHT));
	vansOptions.add(comboYear1);
	vansOptions.add(new JLabel("Color: ",SwingConstants.RIGHT));
	vansOptions.add(comboColor1);	
	vansOptions.add(new JLabel("Cargo size: ",SwingConstants.RIGHT));
	vansOptions.add(comboCargoSize);
	vansOptions.add(new JLabel("Max. load: ",SwingConstants.RIGHT));
	vansOptions.add(comboLoadCapacity);
	vansOptions.add(new JLabel(""));
	vansOptions.add(new JLabel(""));
	vansOptions.add(new JLabel(""));
	vansOptions.add(new JLabel(""));
	vansOptions.add(new JLabel(""));
	vansOptions.add(new JLabel(""));
	vansOptions.add(new JLabel(""));
	vansOptions.add(new JLabel(""));
	vansOptions.add(new JLabel(""));
	vansOptions.add(new JLabel(""));
	vansOptions.add(new JLabel(""));
	
	//border ass pading for the inside card familyCars
	vansOptions.setBorder(new EmptyBorder(10, 0, 10, 10));
}



private void familyCarAreaAddElements() {
	//set layout
	familyCarsOptions.setLayout(new GridLayout(0, 10, 30, 5));
	
	//familyCarOption content adding START
	familyCarsOptions.add(new JLabel("Make: ",SwingConstants.RIGHT));
	familyCarsOptions.add(comboMake);
	familyCarsOptions.add(new JLabel("Model: ",SwingConstants.RIGHT));
	familyCarsOptions.add(comboModel);
	familyCarsOptions.add(new JLabel("Engine: ",SwingConstants.RIGHT));
	familyCarsOptions.add(comboEngineSize);
	familyCarsOptions.add(new JLabel("Hp: ",SwingConstants.RIGHT));
	familyCarsOptions.add(comboHp);
	familyCarsOptions.add(new JLabel("Consumption: ",SwingConstants.RIGHT));
	familyCarsOptions.add(comboFuelConsumption);
	familyCarsOptions.add(new JLabel("Transmision: ",SwingConstants.RIGHT));
	familyCarsOptions.add(comboTransmition);
	familyCarsOptions.add(new JLabel("Doors: ",SwingConstants.RIGHT));
	familyCarsOptions.add(comboNumberOfDoors);
	familyCarsOptions.add(new JLabel("Navigation: ",SwingConstants.RIGHT));
	familyCarsOptions.add(comboNavigation);
	familyCarsOptions.add(new JLabel("Autopilot: ",SwingConstants.RIGHT));
	familyCarsOptions.add(comboCruiseControl);
	familyCarsOptions.add(new JLabel("Seats: ",SwingConstants.RIGHT));
	familyCarsOptions.add(comboNumberOfSeats);
	familyCarsOptions.add(new JLabel("Child seat: ",SwingConstants.RIGHT));
	familyCarsOptions.add(comboChildSeat);
	familyCarsOptions.add(new JLabel("Trunk size: ",SwingConstants.RIGHT));
	familyCarsOptions.add(comboTruncCapacity);
	familyCarsOptions.add(new JLabel("Roof storage: ",SwingConstants.RIGHT));
	familyCarsOptions.add(comboRoofStorage);
	familyCarsOptions.add(new JLabel("Trailer ready: ",SwingConstants.RIGHT));
	familyCarsOptions.add(comboTrailerCopling);
	familyCarsOptions.add(new JLabel("Year: ",SwingConstants.RIGHT));
	familyCarsOptions.add(comboYear);
	familyCarsOptions.add(new JLabel("Color: ",SwingConstants.RIGHT));
	familyCarsOptions.add(comboColor);	
	familyCarsOptions.add(new JLabel(""));
	familyCarsOptions.add(new JLabel(""));
	familyCarsOptions.add(new JLabel(""));
	familyCarsOptions.add(new JLabel(""));
	familyCarsOptions.add(new JLabel(""));
	familyCarsOptions.add(new JLabel(""));
	familyCarsOptions.add(new JLabel(""));
	familyCarsOptions.add(new JLabel(""));
	familyCarsOptions.add(new JLabel(""));
	familyCarsOptions.add(new JLabel(""));
//familyCarOption content adding END	
	
//border ass padding for the inside card familyCars
	familyCarsOptions.setBorder(new EmptyBorder(10, 0, 10, 10));
	
}



private class ToFirstPage implements ActionListener{
	public void actionPerformed(ActionEvent e){
		mainPanelCardLayaout.removeAll();
		mainPanelCardLayaout.add(panelMenuGrid);
		mainPanelCardLayaout.repaint();
		mainPanelCardLayaout.revalidate();
	}
}


public void createMainLayoutSearchPage(){

	GridBagConstraints c= new GridBagConstraints();
	GridBagLayout searchPanelGridBag= new GridBagLayout();
	
	searchPanel.setLayout(searchPanelGridBag);
	searchPanelGridBag.setConstraints(searchPanel,c);
	

	c.weighty=0.5;
	
	c.fill= GridBagConstraints.HORIZONTAL;
	c.anchor= GridBagConstraints.LAST_LINE_START;
	
	c.gridx=0;
	c.gridy=0;
	c.gridwidth = 2;
	c.weightx = 0.0;
	searchPanel.add(reserve00Panel,c);
	
	
	c.gridx=0;
	c.gridy=1;
	c.gridwidth = 3;
	c.weightx = 0.0;
	searchPanel.add(reserve01Panel,c);
	
	
	c.gridx=0;
	c.gridy=2;
	c.gridwidth = 2;
	c.weightx = 0.0;
	searchPanel.add(reserve02Panel,c);
	
	c.gridx=0;
	c.gridy=3;
	c.gridwidth = 2;
	c.weightx = 0.0;
	searchPanel.add(reserve03Panel,c);
	
	
	c.gridx=0;
	c.gridy=4;
	c.gridwidth = 1;
	c.weightx=0.5;
	searchPanel.add(reserve04Panel,c);
	
	c.gridx=1;
	c.gridy=4;
	c.gridwidth = 1;
	c.weightx=0.5;
	searchPanel.add(reserve05Panel,c);
	
	c.gridx=0;
	c.gridy=5;
	c.gridwidth = 1;
	c.weightx=0.5;
	searchPanel.add(reserve06Panel,c);
	
	c.gridx=1;
	c.gridy=5;
	c.gridwidth = 1;
	c.weightx=0.5;
	searchPanel.add(reserve07Panel,c);
	
	c.gridx=0;
	c.gridy=6;
	c.gridwidth = 3;
	c.ipady = 240;
	c.weightx=0.5;
	searchPanel.add(reserve08Panel,c);
	
}


public JPanel constructPopupFrame(){
	
	Font font=new Font("Abel", Font.BOLD, 22);
	Font font2=new Font("Abel", Font.BOLD, 36);
	JPanel eachCarPanel= new JPanel();
	
	JPanel carDescription= new JPanel();
	carDescription.setLayout(new GridLayout(6,2,30,20));
	eachCarPanel.setPreferredSize(new Dimension(700,400));
	JLabel carTitle= new JLabel("Mercedes"+" "+"C220"+"");
	carTitle.setFont(font2);
	carDescription.setBackground(Color.WHITE);
	carDescription.setBorder(new EmptyBorder(30,30,10,10));
	eachCarPanel.add(carTitle,BorderLayout.NORTH);
	eachCarPanel.add(carDescription,BorderLayout.CENTER);
	carDescription.add(new JLabel("Price: 300kr")).setFont(font);
	carDescription.add(new JLabel("Engine: 1.6 Diesel ")).setFont(font);;
	carDescription.add(new JLabel("Transmision: Automatic")).setFont(font);;
	carDescription.add(new JLabel("Doors: 5")).setFont(font);;
	carDescription.add(new JLabel("Seats: 5")).setFont(font);;
	carDescription.add(new JLabel("Trunk: 200cm x 200cm")).setFont(font);;
	carDescription.add(new JLabel("Kilometers: 140.000")).setFont(font);;
	carDescription.add(new JLabel("Hp: 170")).setFont(font);;
	carDescription.add(new JLabel("Roof storage: No")).setFont(font);;
	carDescription.add(new JLabel("Trailer ready: Yes")).setFont(font);;
	carDescription.add(new JLabel("Child seat: Yes")).setFont(font);;
	return eachCarPanel;
}


private class ShowBestCarOptions implements ActionListener{
	public void actionPerformed(ActionEvent e){
		 if(rdbtnFamilyCar.isSelected()){
			 cardCarOption.show(reserve03Panel, "familyCars");
			 reserve03Panel.setBorder(titleCarOptions);
		}
		 if(rdbtnVan.isSelected()){
			 cardCarOption.show(reserve03Panel, "vans");
			 reserve03Panel.setBorder(titleCarOptions2);

		}
		 if(rdbtnMovingTruck.isSelected()){
			 cardCarOption.show(reserve03Panel, "movingTrucks");
			 reserve03Panel.setBorder(titleCarOptions3);

		}
		 if(rdbtnAutoCamper.isSelected()){
			 cardCarOption.show(reserve03Panel, "autoCampers");
			 reserve03Panel.setBorder(titleCarOptions4);

		}
	}
}
	
private class ShowCarDetails implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null,constructPopupFrame(),"Car Information",JOptionPane.INFORMATION_MESSAGE);
		}
		}
	
	
}


