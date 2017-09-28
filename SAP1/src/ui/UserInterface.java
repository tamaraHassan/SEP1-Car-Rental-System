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
import java.awt.event.WindowAdapter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;
import javax.swing.border.EmptyBorder;

//import com.sun.glass.events.WindowEvent;

import doc.*;

/**
 * 
 * @author Group 4
 *
 */



public class UserInterface{

	
	
	static VehicleList vehicleList;
	static BookingList bookingList;
	
	
	//OBJECTS FOR STORAGE CLASSES START
	
	//OBJECTS FOR STORAGE CLASSES END

	JFrame mainFrame;
	
	//declare title
	
	JLabel firstPageTitle= new JLabel();
	JLabel bottomLabel= new JLabel("ALEX");
	
	
	//declare first page buttons
	JButton buttonReserveVehicle= new JButton("Reserve a vehicle");
	JButton buttonManageBooking= new JButton("Manage bookings");
	JButton buttonVehicleMentenance= new JButton("Vehicle maintenance");
	JButton buttonReturnVehicle= new JButton("Return a vehicle");
	JButton buttonManageVehicle= new JButton("Manage vehicles");
	JButton buttonCheckBooking= new JButton("Check today's bookings");
	
	
	//declare first page panels
	JPanel panelHeaderPanel= new JPanel();
	JPanel panelMenuGrid= new JPanel();
	
	
	
	////////////////////////////////////////////////////////////////
	//declare PANELS inside the page and the titles for each panel////
	////////////////////////////////////////////////////////////////
	
	JPanel reserveAVihiclePageMainPanel= new JPanel();
	JPanel reserve01Panel=new JPanel();
	
	TitledBorder titleReserve = BorderFactory.createTitledBorder("Reserve a vehicle");
	JPanel reserve02Panel=new JPanel();
	
	TitledBorder titleType = BorderFactory.createTitledBorder("Car type");
	JPanel reserve03Panel=new JPanel();
	
	TitledBorder titleCarOptions = BorderFactory.createTitledBorder("Car option");
	CardLayout cl01= new CardLayout();
	JPanel reserve04Panel=new JPanel(cl01);
	
	TitledBorder titlePrice= BorderFactory.createTitledBorder("Select price");
	JPanel reserve05Panel=new JPanel();
	
	TitledBorder titleDate= BorderFactory.createTitledBorder("Select date");
	JPanel reserve06Panel=new JPanel();
	
	TitledBorder titleLocation= BorderFactory.createTitledBorder("Location");
	JPanel reserve07Panel=new JPanel();
	
	JPanel reserve08Panel=new JPanel();
	
	
	//declare buttons
	JButton backFromReserve= new JButton("Back");
	
	
	//declare main panel with car layout
	CardLayout cl;
	JPanel mainPanelCardLayaout= new JPanel();
	
	
	static //create other pages through objects
	SearchPage searchPage;
	
	ManageBookings manageBookingsPage;
	
	
	VehicleMaintenancePage vehicleMaintenancePage;
	
	ReturnedVehicle returnedVehiclePage;
	ManageVehicle manageVehiclePage;
	CheckTodayBooking checkTodayBookingPage;



	private JPanel bottomPanel;
	
	//SAVE FIELDS
		private static MyFileIO mfio= new MyFileIO();
		private static String fileVehicleList="vehicleListFile.bin";
		private static String fileBookingList="bookingListFile.bin";
	
	
public UserInterface(){
	vehicleList= new VehicleList();
	bookingList= new BookingList();
	UserInterface.loadFile();
	
	
	
		
		//Create pages
		searchPage= new SearchPage(mainPanelCardLayaout,panelMenuGrid,vehicleList);
		manageBookingsPage= new ManageBookings(mainPanelCardLayaout, panelMenuGrid, bookingList);
		vehicleMaintenancePage= new VehicleMaintenancePage(mainPanelCardLayaout, panelMenuGrid, vehicleList);
		returnedVehiclePage= new ReturnedVehicle(mainPanelCardLayaout, panelMenuGrid, bookingList);
		manageVehiclePage= new ManageVehicle(mainPanelCardLayaout, panelMenuGrid, vehicleList);
		checkTodayBookingPage=new CheckTodayBooking(mainPanelCardLayaout, panelMenuGrid, bookingList);
	
		System.out.println("first page");

		
		
		
		mainFrame= new JFrame("WeBook");
		mainFrame.setBackground(new Color(255, 255, 255));
		mainFrame.setForeground(new Color(255, 255, 255));
		buildMainPanel();
		
		//first page customization
		mainFrame.getContentPane().setBackground(Color.WHITE );
		mainFrame.setSize(1400, 1000);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout flowLayout = (FlowLayout) panelHeaderPanel.getLayout();
		flowLayout.setHgap(30);
		flowLayout.setVgap(20);
		flowLayout.setAlignment(FlowLayout.LEADING);
		panelHeaderPanel.setBackground(new Color(255, 255, 255));
		
		JPanel mainFrameContentThatScrolls= new JPanel();
		JScrollPane scrollMain= new JScrollPane(mainFrameContentThatScrolls,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollMain.setPreferredSize(new Dimension(1400, 1000));
		mainFrame.getContentPane().add(scrollMain);
		mainFrameContentThatScrolls.setLayout(new BorderLayout());
		mainFrameContentThatScrolls.add(panelHeaderPanel,BorderLayout.NORTH);
		mainFrameContentThatScrolls.add(mainPanelCardLayaout,BorderLayout.CENTER);
		
		this.bottomPanel= new JPanel();
		bottomPanel.setLayout(new GridLayout());
		bottomPanel.add(bottomLabel);
		bottomPanel.setBackground(new Color(0, 0, 128));
		mainFrameContentThatScrolls.add(bottomPanel,BorderLayout.SOUTH);
		
		firstPageTitle.setIcon(new ImageIcon("LOGO.png"));
		
		mainFrame.setVisible(true);
		


	}


// UserInterface.saveFile();
public static void saveFile(){
	
		try
		{
		mfio.writeToFile(fileVehicleList, vehicleList);
		}
		catch (FileNotFoundException e)
		{
		System.out.println("VehicleList file not found");
		}
		catch (IOException e)
		{
		System.out.println("IO Error writing to file");
		e.printStackTrace();
		}

		
		try
		{
		mfio.writeToFile(fileBookingList, bookingList);
		}
		catch (FileNotFoundException e)
		{
		System.out.println("BookingList file not found");
		}
		catch (IOException e)
		{
		System.out.println("IO Error writing to file");
		e.printStackTrace();
		}

		
}

public static void loadFile(){
	
	System.out.println(vehicleList.size());
	try
	{
	vehicleList = (VehicleList)mfio.readObjectFromFile(fileVehicleList);
	}
	catch(FileNotFoundException e)
	{
	System.out.println("VehicleList file not found (load)");
	}
	catch(IOException e)
	{
	System.out.println("VehicleList IO Error reading file (load)");
	}
	catch(ClassNotFoundException e)
	{
	System.out.println("VehicleList Class Not Found (load)");
	}

	
	try
	{
	bookingList = (BookingList)mfio.readObjectFromFile(fileBookingList);
	}
	catch(FileNotFoundException e)
	{
	System.out.println("BookingList file not found (load)");
	}
	catch(IOException e)
	{
	System.out.println("BookingList IO Error reading file (load)");
	}
	catch(ClassNotFoundException e)
	{
	System.out.println("BookingList Class Not Found (load)");
	}

}

public static VehicleList getVehicleList(){
	   return vehicleList;
	}

public static BookingList getBookingList(){
	   return bookingList;
	}
	
public static SearchPage getSearchPage(){
	return searchPage;
}

	public void buildMainPanel(){
		
		
		//the panel where all pages will appear

		mainPanelCardLayaout.setLayout(new GridLayout(1,1,0,0));
		
		firstPageTitle.setForeground(new Color(0, 0, 128));
		
		
		
		//title customization
		//firstPageTitle.setFont(new Font("Abel", Font.BOLD, 72));;
		
		Font buttonFont=new Font("Abel", Font.BOLD, 36);
		buttonReserveVehicle.setForeground(new Color(0, 0, 128));
		buttonReserveVehicle.setBackground(new Color(255, 228, 181));
		
		//button customization
		buttonReserveVehicle.setFont(buttonFont);
		buttonManageBooking.setForeground(new Color(0, 0, 128));
		buttonManageBooking.setBackground(new Color(255, 228, 181));
		buttonManageBooking.setFont(buttonFont);
		buttonVehicleMentenance.setForeground(new Color(0, 0, 128));
		buttonVehicleMentenance.setBackground(new Color(255, 228, 181));
		buttonVehicleMentenance.setFont(buttonFont);
		buttonReturnVehicle.setForeground(new Color(0, 0, 128));
		buttonReturnVehicle.setBackground(new Color(255, 228, 181));
		buttonReturnVehicle.setFont(buttonFont);

		buttonManageVehicle.setForeground(new Color(0, 0, 128));
		buttonManageVehicle.setBackground(new Color(255, 228, 181));
		buttonManageVehicle.setFont(buttonFont);
		buttonCheckBooking.setForeground(new Color(0, 0, 128));
		buttonCheckBooking.setBackground(new Color(255, 228, 181));
		buttonCheckBooking.setFont(buttonFont);
		panelMenuGrid.setBackground(new Color(255, 255, 255));
		panelMenuGrid.setForeground(new Color(0, 0, 0));
		panelMenuGrid.setBorder(new EmptyBorder(30, 30, 30, 30));
		
		
		//set menu layout
		panelMenuGrid.setLayout(new GridLayout(4,2,20,20));
		
		//card layout building
		mainPanelCardLayaout.add(panelMenuGrid);
		
	
		
		//add first page button
		panelMenuGrid.add(buttonReserveVehicle);
		panelMenuGrid.add(buttonReturnVehicle);
		panelMenuGrid.add(buttonManageBooking);
		panelMenuGrid.add(buttonCheckBooking);
		panelMenuGrid.add(buttonVehicleMentenance);
		panelMenuGrid.add(buttonManageVehicle);

		
		
		//add title to header
		panelHeaderPanel.add(firstPageTitle);
		reserveAVihiclePageMainPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		
		
		//actions to buttons
		
				
		buttonReserveVehicle.addActionListener(new AddSearchPage());
		backFromReserve.addActionListener(new FirstPage());
		buttonManageBooking.addActionListener(new AddManageBookingsPage());
		buttonVehicleMentenance.addActionListener(new AddVehicleMaintenancePage());
		buttonReturnVehicle.addActionListener(new AddReturnedVehiclePage());
		buttonManageVehicle.addActionListener(new AddManageVehiclePage());
		buttonCheckBooking.addActionListener(new AddCheckTodaysBookingsPage());
		
	}
	
	
	
	
	
	
	///MAIN ACTIONS ZONE
	
	
	private class FirstPage implements ActionListener{
		public void actionPerformed(ActionEvent e){
			mainPanelCardLayaout.removeAll();
			mainPanelCardLayaout.add(panelMenuGrid);
			mainPanelCardLayaout.repaint();
			mainPanelCardLayaout.revalidate();
		}
	}

	
	private class AddSearchPage implements ActionListener{
		public void actionPerformed(ActionEvent e){
			mainPanelCardLayaout.removeAll();
			mainPanelCardLayaout.add(searchPage.getSearchPagePanel());
			System.out.println("search page button pressed");
			SearchPage.removeAllVehiclesFromSearchDisplay();
			mainPanelCardLayaout.repaint();
			mainPanelCardLayaout.revalidate();
		}
	}
	
	public void refreshManageBookingsPage(){
		ManageBookings.showAllBookings();
	}
	
	
	private class AddManageBookingsPage implements ActionListener{
		public void actionPerformed(ActionEvent e){
			mainPanelCardLayaout.removeAll();
			mainPanelCardLayaout.add(manageBookingsPage.getManageBookingsPage());
			refreshManageBookingsPage();
			System.out.println("ManageBookings button pressed");
			mainPanelCardLayaout.repaint();
			mainPanelCardLayaout.revalidate();
		}
	}
	
	
	private class AddVehicleMaintenancePage implements ActionListener{
		public void actionPerformed(ActionEvent e){
			mainPanelCardLayaout.removeAll();
			mainPanelCardLayaout.add(vehicleMaintenancePage.getVehicleMaintenancePage());
			VehicleMaintenancePage.showVehiclesByRemKm();
			System.out.println("ManageBookings button pressed");
			mainPanelCardLayaout.repaint();
			mainPanelCardLayaout.revalidate();
		}
	}
	
	private class AddReturnedVehiclePage implements ActionListener{
		public void actionPerformed(ActionEvent e){
			mainPanelCardLayaout.removeAll();
			mainPanelCardLayaout.add(returnedVehiclePage.getReturnedVehiclePage());
			ReturnedVehicle.showAllBookings();
			System.out.println("ReturnedVehicle button pressed");
			mainPanelCardLayaout.repaint();
			mainPanelCardLayaout.revalidate();
		}
	}
	
	private class AddManageVehiclePage implements ActionListener{
		public void actionPerformed(ActionEvent e){
			mainPanelCardLayaout.removeAll();
			mainPanelCardLayaout.add(manageVehiclePage.getManageVehiclePage());
			System.out.println("ManageVehicle button pressed");
			mainPanelCardLayaout.repaint();
			mainPanelCardLayaout.revalidate();
		}
	}
	
	public void AddCheckTodaysBookingsPage(){
		CheckTodayBooking.showTodayBookings();
	}
	
	
	private class AddCheckTodaysBookingsPage implements ActionListener{
		public void actionPerformed(ActionEvent e){
			mainPanelCardLayaout.removeAll();
			mainPanelCardLayaout.add(checkTodayBookingPage.getCheckTodayBookingPage());
			AddCheckTodaysBookingsPage();
			System.out.println("ManageVehicle button pressed");
			mainPanelCardLayaout.repaint();
			mainPanelCardLayaout.revalidate();
		}
	}
	
	
	public static void main(String[] args) {
		
		UserInterface firstPage= new UserInterface();
		
		
		
	}
	

}

