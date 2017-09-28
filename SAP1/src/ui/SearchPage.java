package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
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

/**
 * 
 * @author Group 4
 *
 */

public class SearchPage implements Serializable{
//label for the text shown before any search is done
	JLabel searchTextDisplayedInsideCarListSpace= new JLabel("No vehicles to display yet. Waiting for search...");
	
//declare RESERVE VEHICLE PAGE
	private JPanel searchPanel = new JPanel();
	private VehicleList vehicleList;
	private BookingList bookingList= new BookingList();
	//private SearchButtonListener listener;
	
	
	
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
		 JComboBox<String> comboPrice= new JComboBox();
		 

//date combo date START
		 JComboBox<String> comboStartDay= new JComboBox();
		 JComboBox<String> comboStartMonth= new JComboBox();
		 JComboBox<String> comboStartYear= new JComboBox();
		 
		 JComboBox<String> comboEndDay= new JComboBox();
		 JComboBox<String> comboEndMonth= new JComboBox();
		 JComboBox<String> comboEndYear= new JComboBox();
//date combo date END
		 
		 
//pickup location START	
		 JComboBox<String> comboPickupLocation= new JComboBox();
		 JComboBox<String> comboDropLocation= new JComboBox();
		 JComboBox<String> comboPiclupTime= new JComboBox();
//pickup location START

		 
//display the cars that fit the requirements START
		 static  JPanel  displayCarsInList= new JPanel();
		 JScrollPane scrollPane = new JScrollPane(displayCarsInList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 TitledBorder titleForDisplayCarsInList= new TitledBorder("Chose the vehicle to reserve");
		 
//display the cars that fit the requirements START
		 
		 
		 
//familyCars combo boxes
		 JComboBox<String> comboMake = new JComboBox(); //
		 JComboBox<String> comboModel = new JComboBox(); //
		 JComboBox<String> comboColor = new JComboBox(); //
		 JComboBox<String> comboTransmition = new JComboBox(); //
		 JComboBox<String> comboYear = new JComboBox(); //
		 JComboBox<String> comboEngineSize = new JComboBox(); //
		 JComboBox<String> comboFuelConsumption = new JComboBox(); //
		 JComboBox<String> comboNavigation = new JComboBox(); //
		 JComboBox<String> comboCruiseControl = new JComboBox(); //
		 JComboBox<String> comboNumberOfDoors = new JComboBox();
		 JComboBox<String> comboNumberOfSeats = new JComboBox();
		 JComboBox<String> comboChildSeat = new JComboBox();
		 JComboBox<String> comboTruncCapacity = new JComboBox();
		 JComboBox<String> comboTrailerCopling = new JComboBox();
		 JComboBox<String> comboRoofStorage = new JComboBox();	
		 JComboBox<String> comboHp = new JComboBox();
//familyCars combo boxes
		 
		 
//Vans combo boxes
		 JComboBox<String> comboMake1 = new JComboBox();
		 JComboBox<String> comboModel1 = new JComboBox();
		 JComboBox<String> comboColor1 = new JComboBox();
		 JComboBox<String> comboTransmition1 = new JComboBox();
		 JComboBox<String> comboYear1 = new JComboBox();
		 JComboBox<String> comboEngineSize1 = new JComboBox();
		 JComboBox<String> comboFuelConsumption1 = new JComboBox();
		 JComboBox<String> comboNavigation1 = new JComboBox();
		 JComboBox<String> comboCruiseControl1 = new JComboBox();
		 JComboBox<String> comboNumberOfDoors1 = new JComboBox();
		 JComboBox<String> comboNumberOfSeats1 = new JComboBox();
		 JComboBox<String> comboDrLicense1 = new JComboBox();
		 JComboBox<String> comboRoofStorage1 = new JComboBox();	
		 JComboBox<String> comboHp1 = new JComboBox();
		 JComboBox<String> comboCargoSize = new JComboBox();
		 JComboBox<String> comboLoadCapacity = new JComboBox();
		 //JComboBox comboRoofStorage = new JComboBox();
//Vans combo boxes		 
	

		 
//Moving Trucks combo boxes
		 JComboBox<String> comboMake2 = new JComboBox();
		 JComboBox<String> comboModel2 = new JComboBox();
		 JComboBox<String> comboColor2 = new JComboBox();
		 JComboBox<String> comboTransmition2 = new JComboBox();
		 JComboBox<String> comboYear2 = new JComboBox();
		 JComboBox<String> comboEngineSize2 = new JComboBox();
		 JComboBox<String> comboFuelConsumption2 = new JComboBox();
		 JComboBox<String> comboNavigation2 = new JComboBox();
		 JComboBox<String> comboCruiseControl2 = new JComboBox();
		 JComboBox<String> comboDrLicense2 = new JComboBox();
		 JComboBox<String> comboHp2 = new JComboBox();
		 JComboBox<String> comboCargoSize2 = new JComboBox();
		 JComboBox<String> comboLoadCapacity2 = new JComboBox();
		 JComboBox<String> comboExtDim2 = new JComboBox();
//Moving Trucks	 combo boxes	 
		 
		 
//AutoCamper combo boxes	
		 JComboBox<String> comboMake4 = new JComboBox(); //
		 JComboBox<String> comboModel4 = new JComboBox(); //
		 JComboBox<String> comboColor4 = new JComboBox(); //
		 JComboBox<String> comboTransmition4 = new JComboBox(); //
		 JComboBox<String> comboYear4 = new JComboBox(); //
		 JComboBox<String> comboEngineSize4 = new JComboBox(); //
		 JComboBox<String> comboFuelConsumption4 = new JComboBox(); //
		 JComboBox<String> comboNavigation4 = new JComboBox(); //
		 JComboBox<String> comboCruiseControl4 = new JComboBox(); //
		 JComboBox<String> comboNrOfPeople = new JComboBox();
		 JComboBox<String> comboExtSize = new JComboBox();
		 JComboBox<String> comboDrLicense4 = new JComboBox();
		 JComboBox<String> comboRefregerator = new JComboBox();
		 JComboBox<String> comboTv = new JComboBox();
		 JComboBox<String> comboHeatedWater = new JComboBox();
		 JComboBox<String> comboBattery = new JComboBox();
		 JComboBox<String> comboBatteryCharger = new JComboBox();
		 JComboBox<String> comboGenerator = new JComboBox();
		 JComboBox<String> comboBicicleStand = new JComboBox();
		 JComboBox<String> comboNumberOfBeds = new JComboBox();
		 JComboBox<String> comboMicrowave = new JComboBox();
		 JComboBox<String> comboRoofHatch = new JComboBox();
//AutoCamper combo boxes		 
	
	ArrayList<JComboBox> allFamilyCarComboboxes= new ArrayList<JComboBox>();
	ArrayList<JComboBox> allVansComboboxes=new ArrayList<JComboBox>();
	ArrayList<JComboBox> allMovingTrucksComboboxes=new ArrayList<JComboBox>();
	ArrayList<JComboBox> allAutoCampersComboboxes=new ArrayList<JComboBox>();
		 
		
//main panel where the page is added
	JPanel mainPanelCardLayaout;
	JPanel panelMenuGrid;
	ShowBestCarOptions action = new ShowBestCarOptions();
	PopulateComboBoxes populate;
	SearchButtonListener listener;
	
	
	

public SearchPage(JPanel mainPanelCardLayaout, JPanel panelMenuGrid, VehicleList vehicleList){
	System.out.println("search page created");
	this.mainPanelCardLayaout=mainPanelCardLayaout;
	this.panelMenuGrid=panelMenuGrid;
	this.vehicleList=vehicleList;
	buildSearchPage();
	populate=new PopulateComboBoxes(this.vehicleList,this);
	System.out.println(this.vehicleList.size()+"");
	populate.populateCombos();
	
}



public JPanel getSearchPagePanel(){
	//POPUILATE COMBOS EACH TIME
	if(populate!=null){
	populate.populateCombos();}
	//RETURN PANEL
	return searchPanel;
}


public void buildSearchPage(){

	actionBackButton();
	listener=new SearchButtonListener(vehicleList, this, bookingList);
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
	locationCategoryAddElements();
	dateCategoryAddElements();
	addSearchButton();
	addBackButton();
	addActionListenersToAllComboBoxes();
	customizeInterfaceSearchPage();
	buildCarListPanel();
}






public void addActionListenersToAllComboBoxes(){
	//*-*-*-*-*-*-**-*-*-*-*-*-*-*-*-*-*-**-*
		//****************************************************
	   //Adding actionListener to all combo boxes in case needed
	    //----------------------------------------------------
		
	///THIS IS THE SEARCH BUTTON LISTENER
	btnSearch.addActionListener(listener);
	///THIS IS THE SEARCH BUTTON LISTENER
	
	
	
	comboPrice.addActionListener(listener);
	    

	  //date combo date START
	         comboStartDay.addActionListener(listener);
	         comboStartMonth.addActionListener(listener);
	         comboStartYear.addActionListener(listener);
	         
	         comboEndDay.addActionListener(listener);
	         comboEndMonth.addActionListener(listener);
	         comboEndYear.addActionListener(listener);
	  //date combo date END
	         
	         
	  //pickup location START 
	         comboPickupLocation.addActionListener(listener);
	         comboDropLocation.addActionListener(listener);
	         comboPiclupTime.addActionListener(listener);
	  //pickup location START
	         
	         
	  //familyCars combo boxes
	         comboMake .addActionListener(listener); //
	         comboModel .addActionListener(listener); //
	         comboColor .addActionListener(listener); //
	         comboTransmition .addActionListener(listener); //
	         comboYear .addActionListener(listener); //
	         comboEngineSize .addActionListener(listener); //
	         comboFuelConsumption .addActionListener(listener); //
	         comboNavigation .addActionListener(listener); //
	         comboCruiseControl .addActionListener(listener); //
	         comboNumberOfDoors .addActionListener(listener);
	         comboNumberOfSeats .addActionListener(listener);
	         comboChildSeat .addActionListener(listener);
	         comboTruncCapacity .addActionListener(listener);
	         comboTrailerCopling .addActionListener(listener);
	         comboRoofStorage .addActionListener(listener);   
	         comboHp .addActionListener(listener);
	  //familyCars combo boxes
	         
	         
	  //Vans combo boxes
	         comboMake1 .addActionListener(listener);
	         comboModel1 .addActionListener(listener);
	         comboColor1 .addActionListener(listener);
	         comboTransmition1 .addActionListener(listener);
	         comboYear1 .addActionListener(listener);
	         comboEngineSize1 .addActionListener(listener);
	         comboFuelConsumption1 .addActionListener(listener);
	         comboNavigation1 .addActionListener(listener);
	         comboCruiseControl1 .addActionListener(listener);
	         comboNumberOfDoors1 .addActionListener(listener);
	         comboNumberOfSeats1 .addActionListener(listener);
	         comboDrLicense1 .addActionListener(listener);
	         comboRoofStorage1 .addActionListener(listener);  
	         comboHp1 .addActionListener(listener);
	         comboCargoSize .addActionListener(listener);
	         comboLoadCapacity .addActionListener(listener);
	         //JComboBox comboRoofStorage .addActionListener(listener);
	  //Vans combo boxes       
	     

	         
	  //Moving Trucks combo boxes
	         comboMake2 .addActionListener(listener);
	         comboModel2 .addActionListener(listener);
	         comboColor2 .addActionListener(listener);
	         comboTransmition2 .addActionListener(listener);
	         comboYear2 .addActionListener(listener);
	         comboEngineSize2 .addActionListener(listener);
	         comboFuelConsumption2 .addActionListener(listener);
	         comboNavigation2 .addActionListener(listener);
	         comboCruiseControl2 .addActionListener(listener);
	         comboDrLicense2 .addActionListener(listener);
	         comboHp2 .addActionListener(listener);
	         comboCargoSize2 .addActionListener(listener);
	         comboLoadCapacity2 .addActionListener(listener);
	         comboExtDim2 .addActionListener(listener);
	  //Moving Trucks    combo boxes    
	         
	         
	  //AutoCamper combo boxes   
	         comboMake4 .addActionListener(listener); //
	         comboModel4 .addActionListener(listener); //
	         comboColor4 .addActionListener(listener); //
	         comboTransmition4 .addActionListener(listener); //
	         comboYear4 .addActionListener(listener); //
	         comboEngineSize4 .addActionListener(listener); //
	         comboFuelConsumption4 .addActionListener(listener); //
	         comboNavigation4 .addActionListener(listener); //
	         comboCruiseControl4 .addActionListener(listener); //
	         comboNrOfPeople .addActionListener(listener);
	         comboExtSize .addActionListener(listener);
	         comboDrLicense4 .addActionListener(listener);
	         comboRefregerator .addActionListener(listener);
	         comboTv .addActionListener(listener);
	         comboHeatedWater .addActionListener(listener);
	         comboBattery .addActionListener(listener);
	         comboBatteryCharger .addActionListener(listener);
	         comboGenerator .addActionListener(listener);
	         comboBicicleStand .addActionListener(listener);
	         comboNumberOfBeds .addActionListener(listener);
	         comboMicrowave .addActionListener(listener);
	         comboRoofHatch .addActionListener(listener);
	    //*****************************************************************
	    //---------------------------------------------------------------
	    
	    
	   
	   
	   
	   //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	         
	   
	        
}

public ArrayList<JComboBox> getAllFamilyCarSpecs(){
	return allFamilyCarComboboxes;
}
public ArrayList<JComboBox> getAllVanCarSpecs(){
	return allVansComboboxes;
}
public ArrayList<JComboBox> getAllMovingTruckCarSpecs(){
	return allMovingTrucksComboboxes;
}
public ArrayList<JComboBox> getAllAutoCamperCarSpecs(){
	return allAutoCampersComboboxes;
}


public void buildCarListPanel(){
	Font categoryTitleFont= new Font("Abel",Font.BOLD, 14);
	titleForDisplayCarsInList.setTitleFont(categoryTitleFont);
	reserve08Panel.setBorder(titleForDisplayCarsInList);
	reserve08Panel.setLayout(new GridLayout(1,1,0,0));
	displayCarsInList.setBorder(new EmptyBorder(10,10,10,10));
	displayCarsInList.setPreferredSize(new Dimension(900, 100));
	scrollPane.setPreferredSize(new Dimension(900, 100));
	displayCarsInList.setBackground(Color.WHITE);
	displayCarsInList.setLayout(new GridLayout(0,1,5,5));
	reserve08Panel.add(scrollPane);
	displayCarsInList.add(searchTextDisplayedInsideCarListSpace);
}


public void displayAvailableCarList(VehicleList vehicleList){
	displayCarsInList.removeAll();
	displayCarsInList.repaint();
	displayCarsInList.revalidate();
	System.out.println("display start");
	System.out.println("number of vehicles "+vehicleList.size());
	displayCarsInList.remove(searchTextDisplayedInsideCarListSpace);
	displayCarsInList.repaint();
	displayCarsInList.revalidate();
	System.out.println("text removed");
	if(vehicleList.size()>1){
		System.out.println("if>1 true");
	displayCarsInList.setPreferredSize(new Dimension(900, vehicleList.size()*100));
	displayCarsInList.repaint();
	displayCarsInList.revalidate();}
	else{System.out.println("if<1 true");
		displayCarsInList.setPreferredSize(new Dimension(900, 100));
		displayCarsInList.repaint();
		displayCarsInList.revalidate();}
	

	ArrayList<Vehicle> vehicleListArray= vehicleList.getAllVehicles();
	///increase the size of scrollable area according to number of vehicles
	for(int i=0; i<vehicleListArray.size(); i++){
		System.out.println("car "+i);
		displayCarsInList.add(vehicleListArray.get(i).getVehiclePanel());
	}
	displayCarsInList.repaint();
	displayCarsInList.revalidate();
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
	reserve05Panel.setBorder(titleDate);			
	reserve06Panel.setBorder(titleLocation);
	
	
	
	
	
	//set some layouts
	reserve00Panel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
	
}





private void dateCategoryAddElements(){
	reserve05Panel.setLayout(new FlowLayout(FlowLayout.LEADING));
	reserve05Panel.add(new JLabel("Start date:  "));
	reserve05Panel.add(comboStartDay);
	reserve05Panel.add(comboStartMonth);
	reserve05Panel.add(comboStartYear);
	reserve05Panel.add(new JLabel(" End date:  "));
	reserve05Panel.add(comboEndDay);
	reserve05Panel.add(comboEndMonth);
	reserve05Panel.add(comboEndYear);
	
}

private void locationCategoryAddElements() {
	reserve06Panel.setLayout(new FlowLayout(FlowLayout.LEADING));
	reserve06Panel.add(new JLabel("Pick-up:  "));
	reserve06Panel.add(comboPickupLocation);
	reserve06Panel.add(new JLabel("  Return: "));
	reserve06Panel.add(comboDropLocation);
	reserve06Panel.add(new JLabel(" pick-up time:  "));
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

public static void removeAllVehiclesFromSearchDisplay(){
	displayCarsInList.removeAll();
	displayCarsInList.repaint();
	displayCarsInList.revalidate();
}


private class ToFirstPage implements ActionListener{
	public void actionPerformed(ActionEvent e){
		mainPanelCardLayaout.removeAll();
		mainPanelCardLayaout.add(panelMenuGrid);
		populate.populateCombos();
		UserInterface.saveFile();
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
	searchPanel.add(reserve05Panel,c);
	
	c.gridx=1;
	c.gridy=4;
	c.gridwidth = 1;
	c.weightx=0.5;
	searchPanel.add(reserve06Panel,c);
	
	c.gridx=0;
	c.gridy=5;
	c.gridwidth = 1;
	c.weightx=0.5;
	searchPanel.add(new JLabel(""),c);
	
	c.gridx=1;
	c.gridy=5;
	c.gridwidth = 1;
	c.weightx=0.5;
	searchPanel.add(reserve07Panel,c);
	
	c.gridx=0;
	c.gridy=6;
	c.gridwidth = 3;
	c.ipady = 170;
	c.weightx=0.5;
	searchPanel.add(reserve08Panel,c);
	
}





private class ShowBestCarOptions implements ActionListener{
	public void actionPerformed(ActionEvent e){
		 if(rdbtnFamilyCar.isSelected()){
			 cardCarOption.show(reserve03Panel, "familyCars");
			 reserve03Panel.setBorder(titleCarOptions);
		}
		 if(rdbtnVan.isSelected()){
			 System.out.println("Van radio button pushed");
			 cardCarOption.show(reserve03Panel, "vans");
			 reserve03Panel.setBorder(titleCarOptions2);

		}
		 if(rdbtnMovingTruck.isSelected()){
			 System.out.println("Moving Truck radio button pushed");
			 cardCarOption.show(reserve03Panel, "movingTrucks");
			 reserve03Panel.setBorder(titleCarOptions3);

		}
		 if(rdbtnAutoCamper.isSelected()){
			 System.out.println("Auto camper radio button pushed");
			 cardCarOption.show(reserve03Panel, "autoCampers");
			 reserve03Panel.setBorder(titleCarOptions4);

		}
	}
}
	

	


//////////////////////////////////////////////////////////////
///////GET ALL COMBOBOXES/////////////////////////////////////
//////////////////////////////////////////////////////////////

public JComboBox getComboPrice()
{
   return comboPrice;
}

public JComboBox getComboStartDay()
{
   return comboStartDay;
}

public JComboBox getComboStartMonth()
{
   return comboStartMonth;
}

public JComboBox getComboStartYear()
{
   return comboStartYear;
}

public JComboBox getComboEndDay()
{
   return comboEndDay;
}

public JComboBox getComboEndMonth()
{
   return comboEndMonth;
}

public JComboBox getComboEndYear()
{
   return comboEndYear;
}

public JComboBox getComboPickupLocation()
{
   return comboPickupLocation;
}

public JComboBox getComboDropLocation()
{
   return comboDropLocation;
}

public JComboBox getComboPiclupTime()
{
   return comboPiclupTime;
}

public JComboBox getComboMake()
{
   return comboMake;
}

public JComboBox getComboModel()
{
   return comboModel;
}

public JComboBox getComboColor()
{
   return comboColor;
}

public JComboBox getComboTransmition()
{
   return comboTransmition;
}

public JComboBox getComboYear()
{
   return comboYear;
}

public JComboBox getComboEngineSize()
{
   return comboEngineSize;
}

public JComboBox getComboFuelConsumption()
{
   return comboFuelConsumption;
}

public JComboBox getComboNavigation()
{
   return comboNavigation;
}

public JComboBox getComboCruiseControl()
{
   return comboCruiseControl;
}

public JComboBox getComboNumberOfDoors()
{
   return comboNumberOfDoors;
}

public JComboBox getComboNumberOfSeats()
{
   return comboNumberOfSeats;
}

public JComboBox getComboChildSeat()
{
   return comboChildSeat;
}

public JComboBox getComboTruncCapacity()
{
   return comboTruncCapacity;
}

public JComboBox getComboTrailerCopling()
{
   return comboTrailerCopling;
}

public JComboBox getComboRoofStorage()
{
   return comboRoofStorage;
}

public JComboBox getComboHp()
{
   return comboHp;
}

public JComboBox getComboMake1()
{
   return comboMake1;
}

public JComboBox getComboModel1()
{
   return comboModel1;
}

public JComboBox getComboColor1()
{
   return comboColor1;
}

public JComboBox getComboTransmition1()
{
   return comboTransmition1;
}

public JComboBox getComboYear1()
{
   return comboYear1;
}

public JComboBox getComboEngineSize1()
{
   return comboEngineSize1;
}

public JComboBox getComboFuelConsumption1()
{
   return comboFuelConsumption1;
}

public JComboBox getComboNavigation1()
{
   return comboNavigation1;
}

public JComboBox getComboCruiseControl1()
{
   return comboCruiseControl1;
}

public JComboBox getComboNumberOfDoors1()
{
   return comboNumberOfDoors1;
}

public JComboBox getComboNumberOfSeats1()
{
   return comboNumberOfSeats1;
}



public JComboBox getComboDrLicense1()
{
   return comboDrLicense1;
}

public JComboBox getComboRoofStorage1()
{
   return comboRoofStorage1;
}

public JComboBox getComboHp1()
{
   return comboHp1;
}

public JComboBox getComboCargoSize()
{
   return comboCargoSize;
}

public JComboBox getComboLoadCapacity()
{
   return comboLoadCapacity;
}

public JComboBox getComboMake2()
{
   return comboMake2;
}

public JComboBox getComboModel2()
{
   return comboModel2;
}

public JComboBox getComboColor2()
{
   return comboColor2;
}

public JComboBox getComboTransmition2()
{
   return comboTransmition2;
}

public JComboBox getComboYear2()
{
   return comboYear2;
}

public JComboBox getComboEngineSize2()
{
   return comboEngineSize2;
}

public JComboBox getComboFuelConsumption2()
{
   return comboFuelConsumption2;
}

public JComboBox getComboNavigation2()
{
   return comboNavigation2;
}

public JComboBox getComboCruiseControl2()
{
   return comboCruiseControl2;
}

public JComboBox getComboDrLicense2()
{
   return comboDrLicense2;
}

public JComboBox getComboHp2()
{
   return comboHp2;
}

public JComboBox getComboCargoSize2()
{
   return comboCargoSize2;
}

public JComboBox getComboLoadCapacity2()
{
   return comboLoadCapacity2;
}

public JComboBox getComboExtDim2()
{
   return comboExtDim2;
}

public JComboBox getComboMake4()
{
   return comboMake4;
}

public JComboBox getComboModel4()
{
   return comboModel4;
}

public JComboBox getComboColor4()
{
   return comboColor4;
}

public JComboBox getComboTransmition4()
{
   return comboTransmition4;
}

public JComboBox getComboYear4()
{
   return comboYear4;
}

public JComboBox getComboEngineSize4()
{
   return comboEngineSize4;
}

public JComboBox getComboFuelConsumption4()
{
   return comboFuelConsumption4;
}

public JComboBox getComboNavigation4()
{
   return comboNavigation4;
}

public JComboBox getComboCruiseControl4()
{
   return comboCruiseControl4;
}

public JComboBox getComboNrOfPeople()
{
   return comboNrOfPeople;
}

public JComboBox getComboExtSize()
{
   return comboExtSize;
}

public JComboBox getComboDrLicense4()
{
   return comboDrLicense4;
}

public JComboBox getComboRefregerator()
{
   return comboRefregerator;
}

public JComboBox getComboTv()
{
   return comboTv;
}

public JComboBox getComboHeatedWater()
{
   return comboHeatedWater;
}

public JComboBox getComboBattery()
{
   return comboBattery;
}

public JComboBox getComboBatteryCharger()
{
   return comboBatteryCharger;
}

public JComboBox getComboGenerator()
{
   return comboGenerator;
}

public JComboBox getComboBicicleStand()
{
   return comboBicicleStand;
}

public JComboBox getComboNumberOfBeds()
{
   return comboNumberOfBeds;
}

public JComboBox getComboMicrowave()
{
   return comboMicrowave;
}

public JComboBox getComboRoofHatch()
{
   return comboRoofHatch;
}


public void AddComboboxesToArraylist(){
	
	allFamilyCarComboboxes.clear();
	//ADD ELEMENTS TO ARRAYLIST FAMILY CAR
    allFamilyCarComboboxes.add(comboMake); //
    allFamilyCarComboboxes.add(comboModel); //
    allFamilyCarComboboxes.add(comboColor); //
    allFamilyCarComboboxes.add(comboTransmition); //
    allFamilyCarComboboxes.add(comboYear); //
    allFamilyCarComboboxes.add(comboEngineSize); //
    allFamilyCarComboboxes.add(comboFuelConsumption); //
    allFamilyCarComboboxes.add(comboNavigation); //
    allFamilyCarComboboxes.add(comboCruiseControl); //
    allFamilyCarComboboxes.add(comboNumberOfDoors);
    allFamilyCarComboboxes.add(comboNumberOfSeats);
    allFamilyCarComboboxes.add(comboChildSeat);
    allFamilyCarComboboxes.add(comboTruncCapacity);
    allFamilyCarComboboxes.add(comboTrailerCopling);
    allFamilyCarComboboxes.add(comboRoofStorage);	      
    
// ADD ELEMENTS TO ARRAYLIST VANS
   allVansComboboxes.clear();
   allVansComboboxes.add(comboMake1);
   allVansComboboxes.add(comboModel1);
   allVansComboboxes.add(comboColor1 );
   allVansComboboxes.add(comboTransmition1);
   allVansComboboxes.add(comboYear1);
   allVansComboboxes.add(comboEngineSize1);
   allVansComboboxes.add(comboFuelConsumption1);
   allVansComboboxes.add(comboNavigation1);
   allVansComboboxes.add(comboCruiseControl1);
   allVansComboboxes.add(comboNumberOfDoors1);
   allVansComboboxes.add(comboNumberOfSeats1);
   allVansComboboxes.add(comboDrLicense1);
   allVansComboboxes.add(comboRoofStorage1);  
   allVansComboboxes.add(comboHp1);
   allVansComboboxes.add(comboCargoSize);
   allVansComboboxes.add(comboLoadCapacity);
   
//ADD ELEMENTS TO ARRAYLIST MOVING TRUCKS
   //Moving Trucks combo boxes
   allMovingTrucksComboboxes.clear();
   allMovingTrucksComboboxes.add(comboMake2);
   allMovingTrucksComboboxes.add(comboModel2);
   allMovingTrucksComboboxes.add(comboColor2);
   allMovingTrucksComboboxes.add(comboTransmition2);
   allMovingTrucksComboboxes.add(comboYear2);
   allMovingTrucksComboboxes.add(comboEngineSize2);
   allMovingTrucksComboboxes.add(comboFuelConsumption2);
   allMovingTrucksComboboxes.add(comboNavigation2);
   allMovingTrucksComboboxes.add(comboCruiseControl2);
   allMovingTrucksComboboxes.add(comboDrLicense2);
   allMovingTrucksComboboxes.add(comboHp2);
   allMovingTrucksComboboxes.add(comboCargoSize2 );
   allMovingTrucksComboboxes.add(comboLoadCapacity2);
   allMovingTrucksComboboxes.add(comboExtDim2);
//Moving Trucks    combo boxes 
   
//ADD ELEMENTS TO ARRAYLIST AUTOCAMPER
 //AutoCamper combo boxes   
   	allAutoCampersComboboxes.clear();
    allAutoCampersComboboxes.add(comboMake4); //
    allAutoCampersComboboxes.add(comboModel4); //
    allAutoCampersComboboxes.add(comboColor4); //
    allAutoCampersComboboxes.add(comboTransmition4); //
    allAutoCampersComboboxes.add(comboEngineSize4); //
    allAutoCampersComboboxes.add(comboFuelConsumption4); //
    allAutoCampersComboboxes.add(comboNavigation4); //
    allAutoCampersComboboxes.add(comboCruiseControl4); //
    allAutoCampersComboboxes.add(comboNrOfPeople);
    allAutoCampersComboboxes.add(comboExtSize);
    allAutoCampersComboboxes.add(comboDrLicense4);
    allAutoCampersComboboxes.add(comboRefregerator);
    allAutoCampersComboboxes.add(comboTv);
    allAutoCampersComboboxes.add(comboHeatedWater);
    allAutoCampersComboboxes.add(comboBattery);
    allAutoCampersComboboxes.add(comboBatteryCharger);
    allAutoCampersComboboxes.add(comboGenerator);
    allAutoCampersComboboxes.add(comboBicicleStand);
    allAutoCampersComboboxes.add(comboNumberOfBeds);
    allAutoCampersComboboxes.add(comboMicrowave);
    allAutoCampersComboboxes.add(comboRoofHatch);
}

	
}


