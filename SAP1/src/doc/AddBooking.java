package doc;

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

import ui.*;

/**
 * This Class is to Add a Booking to the bookinList
 */
public class AddBooking implements Serializable
{
  
	//variables
	private String firstName;
	private String lastName;
	private String licenseNumber;
	private String address;
	private String phoneNumber;
	
	//booking info
	private String pickUpTime;
	private String dropOffTime;
	private String pickUpLocation;
	private String dropOffLocation;
	
	//price calculations
	private double discountedDays;
	private double discount;
	private int numberOfDays;
	private double totalPrice;

	//Search object
	private SearchPage search;
	
	//customer
	private Customer customer;
	
	
	//Vehicle object
	private Vehicle vehicle;
	
	//AddBookingPage Object
	private AddBookingPage addBookingPage;
	

	
	//MyDate object
	private MyDate startDate;
	private MyDate endDate;
	
	//reading date combo boxes
	private String startDay;
	private String startMonth;
	private String startYear;
	private String endDay;
	private String endMonth;
	private String endYear;
	
	private String bookingStatus="Incomplete";
	
	//PopulateComboBoxes object
	private PopulateComboBoxes pop;
	
	//temps
	private int tempInt;
	
	/**
	 * Constructor initializing the add booking
	 * @param takes a vehicle,  and 
	 * @param search GUI SearchPage
	 * @param addBookingPage the GUI of AddBookingPage
	 */
	public AddBooking(Vehicle vehicle, SearchPage search, AddBookingPage addBookingPage)
	{
		this.vehicle = vehicle;
		this.addBookingPage= addBookingPage;
		this.search = search;

		startDate = new MyDate(Integer.parseInt((String)(search.getComboStartDay().getSelectedItem())), Integer.parseInt((String)(search.getComboStartMonth().getSelectedItem())),
				Integer.parseInt((String)(search.getComboStartYear().getSelectedItem())));
		endDate = new MyDate(Integer.parseInt((String)(search.getComboEndDay().getSelectedItem())), Integer.parseInt((String)(search.getComboEndMonth().getSelectedItem())), 
				Integer.parseInt((String)(search.getComboEndYear().getSelectedItem())));
		
		startDay = (String)search.getComboStartDay().getSelectedItem();
		startMonth = (String)search.getComboStartMonth().getSelectedItem();
		startYear = (String)search.getComboStartYear().getSelectedItem();
		endDay = (String)search.getComboEndDay().getSelectedItem();
		endMonth = (String)search.getComboEndMonth().getSelectedItem();
		endYear = (String)search.getComboEndYear().getSelectedItem();
	}	
	/**
	 * Validate add booking fields 
	 * @return number of errors(empty Strings) and sets the labels to red
	 */
	public int checkStrings()
	{
		
		
		//Strings
		firstName = addBookingPage.getFirstName().getText();
		lastName = addBookingPage.getLastName().getText();
		address = addBookingPage.getAddress().getText();
		int temp= (Integer)search.getComboPiclupTime().getSelectedItem();
		pickUpTime =  temp +"";
		dropOffTime = addBookingPage.getDropOffTime().getText();
		//ints
		licenseNumber = addBookingPage.getLicenseNumber().getText();
		phoneNumber = addBookingPage.getPhoneNumber().getText();
		
		//reading variables from search page
	
		pickUpLocation = (String) search.getComboPickupLocation().getSelectedItem();
		dropOffLocation = (String) search.getComboDropLocation().getSelectedItem();
		
		

		startDay = (String)search.getComboStartDay().getSelectedItem();
		startMonth = (String)search.getComboStartMonth().getSelectedItem();
		startYear = (String)search.getComboStartYear().getSelectedItem();
		endDay = (String)search.getComboEndDay().getSelectedItem();
		endMonth = (String)search.getComboEndMonth().getSelectedItem();
		endYear = (String)search.getComboEndYear().getSelectedItem();
		
		int stringErrors = 0;
		
		if(firstName.equals(""))
		{
			addBookingPage.getFirstNameLabel().setForeground(Color.red);
			stringErrors++;
		}
		if(lastName.equals(""))
		{
			addBookingPage.getLastNameLabel().setForeground(Color.red);
			stringErrors++;
		}
		if(address.equals(""))
		{
			addBookingPage.getAddressLabel().setForeground(Color.red);
			stringErrors++;
		}

		if(licenseNumber.equals(""))
		{
			bookingStatus="Incomplete";
		}
		else{
			bookingStatus="Completed";
		}
		
		
		if(phoneNumber.equals(""))
		{
			addBookingPage.getPhoneNumberLabel().setForeground(Color.red);
			stringErrors++;
		}
		return stringErrors;
	}
	
	/**
	 * set the labels  back to black
	 */
	public void changeLabelsToBlack()
	{
		addBookingPage.getFirstNameLabel().setForeground(Color.black);
		addBookingPage.getLastNameLabel().setForeground(Color.black);
		addBookingPage.getLicenseNumberLabel().setForeground(Color.black);
		addBookingPage.getAddressLabel().setForeground(Color.black);
		addBookingPage.getPhoneNumberLabel().setForeground(Color.black);
	}
	
	/**
	 * Create a customer 
	 */
	public void addCustomer()
	{
		changeLabelsToBlack();
		customer = new Customer(firstName, lastName, licenseNumber, address, phoneNumber);
	}
	/**
	 * It calculate the total price including discount 
	 * @return the total price 
	 */
	public double calculateTotalPrice()
	{
		numberOfDays = getNumOfDays(startYear, startMonth,startDay , endYear, endMonth, endDay );
		totalPrice = (numberOfDays*(Integer.parseInt(vehicle.getPrice())))-calculateDiscount();
		//totalPrice = (2 * (Integer.parseInt(vehicle.getPrice())) + (calculateDiscount()));
		
		return totalPrice;
	}
	/**
	 * Calculate the discount
	 * @return the amount of discount 
	 */
	
	public double calculateDiscount()
	{
		discount=0;
		numberOfDays = getNumOfDays(startYear, startMonth,startDay , endYear, endMonth, endDay );
		if(numberOfDays>2){
		discountedDays = (numberOfDays - 2);
		discount = (((discountedDays) * (Double.parseDouble(vehicle.getPrice()))*0.3));
		}
		return discount;
	}
	
	/**
	 * Adds the booking to the list of bookings
	 */
	public void addBookingToList()
	{
		
		if(checkStrings() == 0)
		{
		addCustomer();
		//Vehicle vehicle,Customer customer, MyDate startDate, MyDate endDate
		Booking booking = new Booking(vehicle, customer, startDate, endDate, pickUpTime,
				dropOffTime, pickUpLocation, dropOffLocation, bookingStatus);
		UserInterface.getBookingList().addBooking(0,booking);
		SearchPage.removeAllVehiclesFromSearchDisplay();
		JOptionPane.showMessageDialog(null,"The reservation was added successfully!","Reserve...",JOptionPane.PLAIN_MESSAGE);}
		else{
		JOptionPane.showMessageDialog(null,"Please fill out required fields","Reserve error...",JOptionPane.PLAIN_MESSAGE);
		}
	}
	   /**
	    * Calculating the Number of Days a vehicle booked for
	    * @param startYearcombo
	    * @param startMonthcombo
	    * @param startDaycombo
	    * @param endYearcombo
	    * @param endMonthcombo
	    * @param endDaycombo
	    * @return Number of booked days
	    */
	   public int getNumOfDays(String startYearcombo, String startMonthcombo,
		         String startDaycombo, String endYearcombo, String endMonthcombo,
		         String endDaycombo)
		   {
		      if (!(startYearcombo == null && startMonthcombo == null
		            && startDaycombo == null && endYearcombo == null
		            && endMonthcombo == null && endDaycombo == null))
		      {
		         if (!(startYearcombo.equals("any") && startMonthcombo.equals("any")
		               && startDaycombo.equals("any") && endYearcombo.equals("any")
		               && endMonthcombo.equals("any") && endDaycombo.equals("any")))
		         {
		            int startYear = Integer.parseInt(startYearcombo);
		            int startMonth = Integer.parseInt(startMonthcombo);
		            int startDay = Integer.parseInt(startDaycombo);
		            int endYear = Integer.parseInt(endYearcombo);
		            int endMonth = Integer.parseInt(endMonthcombo);
		            int endDay = Integer.parseInt(endDaycombo);
		            System.out.println(startDay+" "+startMonth+" "+startYear+" ");
		            MyDate startDate = new MyDate(startDay, startMonth, startYear);
		            MyDate endDate = new MyDate(endDay, endMonth, endYear);

		            if (startDate.isBefore(endDate))
		                                            
		            {

		               MyDate tempdate = startDate.copy();
		               int numOfDays = 0;
		               while (tempdate.isBefore(endDate))
		               {
		                  numOfDays++;
		                  tempdate.nextDay();
		               }
		               System.out.println("return statement Number of Days:    "
		                     + numOfDays);
		               return numOfDays;
		            }
		            else

		               return 0;
		         }
		         else

		            return 0;
		      }

		      return 0;

		   }
}
