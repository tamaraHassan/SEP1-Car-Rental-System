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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;
import javax.swing.border.EmptyBorder;

import ui.CheckTodayBooking;
import ui.EditBookingPage;
import ui.ManageBookings;
import ui.ReturnedVehicle;
import ui.UserInterface;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * class to Create a booking 
 * 
 *
 */
public class Booking implements Serializable{

   private Vehicle vehicle;
   private Customer customer;
   private MyDate startDate;
   private MyDate endDate;			
	
	private String pickUpTime;
	private String dropOffTime;
	private String pickUpLocation;
	private String dropOffLocation;
	private String bookingStatus;
	private JPanel returnPopUpPanel;
	private JLabel returnKmNo;
	private JTextField returnKmNoField;
	private JButton btnCalculate;
	private JLabel extraPrice;
	private JLabel priceShow;
	private JButton btnAddKmToVehicle;
	private boolean flag;
	
	public Booking(){
		
	}
	/**
	 * Constructor to initialize the booking 
	 * @param vehicle
	 * @param customer
	 * @param startDate
	 * @param endDate
	 * @param pickUpTime
	 * @param dropOffTime
	 * @param pickUpLocation
	 * @param dropOffLocation
	 * @param bookingStatus
	 */
	public Booking(Vehicle vehicle,Customer customer, MyDate startDate, MyDate endDate, String pickUpTime,
			String dropOffTime, String pickUpLocation, String dropOffLocation, String bookingStatus)
	{
		this.vehicle=vehicle;
		this.customer=customer;
		this.startDate=startDate;
		this.endDate=endDate;
		this.pickUpTime = pickUpTime;
		this.dropOffTime = dropOffTime;
		this.pickUpLocation = pickUpLocation;
		this.dropOffLocation = dropOffLocation;
		this.bookingStatus= bookingStatus;
	}
	
	public String getBookingStatus() {
		return bookingStatus;
	}


	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	/**
	 * check if the vehicle is booked within period
	 *   Booking     Start |-------------------| End
    *  case0       Start |-------------------| End
    *  case1             Start|-----------|End
    *  case2  Start|-------------------------------|End
    *  case3  Start|-----------|End
    *  case4                      Start|------------|End
    * if we don't want to rent the vehicle the day it comes back to check its situation:
    * if startDateFromSearch.equals(endDate)
	 * @param start Date From Search
	 * @param end Date From Search
	 * @return boolean if the vehicle is booked 
	 */
	

public boolean isBooked(MyDate startDateFromSearch, MyDate endDateFromSearch){
	if(startDateFromSearch.equals(endDate)||startDate.equals(startDateFromSearch)||endDateFromSearch.equals(endDate)||
	      startDate.isBefore(startDateFromSearch)&&endDateFromSearch.isBefore(endDate)||
	      startDateFromSearch.isBefore(startDate)&&endDate.isBefore(endDateFromSearch)||
	      startDateFromSearch.isBefore(startDate)&&startDate.isBefore(endDateFromSearch)||
	      startDateFromSearch.isBefore(endDate)&&endDate.isBefore(endDateFromSearch)){
	 
		return true;
		
	}
	else return false;
}

	
	public MyDate getStartDate()
	{
		return startDate;
	}
	
	public Customer getCustomer()
	{
		return customer;
	}
	
	public Vehicle getVehicle()
	{
		return vehicle;
	}
	
	public void setPickUpTime(String pickUpTime)
	{
		this.pickUpTime = pickUpTime;
	}
	
	public void setDropOffTime(String dropOffTime)
	{
		this.dropOffTime = dropOffTime;
	}
	
	public void setPickUpLocation(String pickUpLocation)
	{
		this.pickUpLocation = pickUpLocation;
	}
	
	public void setDropOffLocation(String dropOffLocation)
	{
		this.dropOffLocation = dropOffLocation;
	}
	
	public boolean checkInterval(MyDate startDateFromUser, MyDate endDateFromUser)
	{
		if(endDate.isBefore(startDateFromUser)||endDateFromUser.isBefore(startDate))
		{
			return true;
		}
		else return false;
	}


	public MyDate getEndDate() {
		return endDate;
	}
	/**
	 * get the booking panel with edit and remove buttons
	 * @return booking panel
	 */
	public JPanel getBookingPanel() {
		  JPanel booking= new JPanel(new GridLayout(1,3,0,0));
		  booking.setBorder(new EmptyBorder(10,10,20,10));
		  JPanel bookingDetailsText= new JPanel(new GridLayout(2,1,0,0));
		  JPanel bookingButtons= new JPanel(new GridLayout(1,2,10,10));
		  JLabel bookingDetailRow2= new JLabel("Maker: "+vehicle.getMaker()+", Model: "+vehicle.getModel());
		  JLabel bookingDetailRow1= new JLabel("Customer:  "+customer.getFirstName()+", "+customer.getLastName());
		  JLabel bookingDetailRow3= new JLabel("License nr:  "+customer.getLicenseNumber());
		  JLabel bookingDetailRow4= new JLabel("BOOKING STATUS: "+getBookingStatus());
		  JButton buttonEdit= new JButton("Edit");
		  JButton buttonCancel= new JButton("Remove");
		  bookingDetailsText.add(bookingDetailRow1);
		  bookingDetailsText.add(bookingDetailRow2);
		  bookingButtons.add(buttonEdit);
		  bookingButtons.add(buttonCancel);
		  booking.add(bookingDetailsText);
		  JPanel bookingStatus= new JPanel();
		  bookingStatus.setLayout(new GridLayout(2,0,0,0));
		  bookingStatus.setBorder(new EmptyBorder(10,30,10,10));
		  if(getBookingStatus().equals("Incomplete")){
			  bookingStatus.setBackground(new Color(240,180,180));  
		  }
		  else{
			  bookingStatus.setBackground(new Color(190,255,180));
			 
		  }
		  if(getCustomer().getFirstName().equals("Service")){
			  bookingStatus.setBackground(new Color(240,240,180));  
			  bookingDetailRow4= new JLabel("BOOKING STATUS: IN SERVICE");
		  }
		  bookingStatus.add(bookingDetailRow3);
		  bookingStatus.add(bookingDetailRow4);
		  JPanel date= new JPanel();
		  date.setLayout(new GridLayout(2,0,0,0));
		  date.add(new JLabel("Start date:"+startDate.displayDate()));
		  date.add(new JLabel("End date:"+endDate.displayDate()));
		  booking.add(date);
		  booking.add(bookingStatus);
		  booking.add(bookingButtons);
		  
		  Font buttonFont=new Font("Abel", Font.BOLD, 18);
		  buttonEdit.setFont(buttonFont);
		  buttonEdit.setForeground(new Color(0, 0, 128));
		  buttonEdit.setBackground(new Color(255, 228, 181));
		  buttonEdit.addActionListener(new EditBookingAction());
		  
		  
		  buttonCancel.setFont(buttonFont);
		  buttonCancel.setForeground(new Color(0, 0, 128));
		  buttonCancel.setBackground(new Color(255, 228, 181));
		  buttonCancel.addActionListener(new RemoveBookingAction());
		  return booking;
		}

	
	/**
	 *  get the booking with return button
	 * @return JPanel for returning a car
	 */
	//BOOKING PANEL FOR RETURN VEHICLE
	public JPanel getBookingForReturnVehiclePanel() {
		  JPanel booking= new JPanel(new GridLayout(1,3,0,0));
		  booking.setBorder(new EmptyBorder(10,10,20,10));
		  JPanel bookingDetailsText= new JPanel(new GridLayout(2,1,0,0));
		  JPanel bookingButtons= new JPanel(new GridLayout(1,2,10,10));
		  JLabel bookingDetailRow2= new JLabel("Maker: "+vehicle.getMaker()+", Model: "+vehicle.getModel());
		  JLabel bookingDetailRow1= new JLabel("Customer:  "+customer.getFirstName()+", "+customer.getLastName());
		  JLabel bookingDetailRow3= new JLabel("Reg. no:  "+vehicle.getRegNo());
		  JLabel bookingDetailRow4= new JLabel("Nr. of KM: "+getVehicle().getNumberOfKm());
		  JButton buttonCancel= new JButton("Return vehicle");
		  bookingDetailsText.add(bookingDetailRow1);
		  bookingDetailsText.add(bookingDetailRow2);
		  bookingButtons.add(buttonCancel);
		  booking.add(bookingDetailsText);
		  JPanel bookingStatus= new JPanel();
		  bookingStatus.setLayout(new GridLayout(2,0,0,0));
		  bookingStatus.setBorder(new EmptyBorder(10,30,10,10));
		  if(getBookingStatus().equals("Incomplete")){
			  bookingStatus.setBackground(new Color(240,180,180));  
		  }
		  else{
			  bookingStatus.setBackground(new Color(190,255,180));
			 
		  }
		  if(getCustomer().getFirstName().equals("Service")){
			  bookingStatus.setBackground(new Color(240,240,180));  
			  bookingDetailRow4= new JLabel("BOOKING STATUS: IN SERVICE");
		  }
		  bookingStatus.add(bookingDetailRow3);
		  bookingStatus.add(bookingDetailRow4);
		  JPanel date= new JPanel();
		  date.setLayout(new GridLayout(2,0,0,0));
		  date.add(new JLabel("Start date:"+startDate.displayDate()));
		  date.add(new JLabel("End date:"+endDate.displayDate()));
		  booking.add(date);
		  booking.add(bookingStatus);
		  booking.add(bookingButtons);
		  
		  Font buttonFont=new Font("Abel", Font.BOLD, 18);		  
		  
		  buttonCancel.setFont(buttonFont);
		  buttonCancel.setForeground(new Color(0, 0, 128));
		  buttonCancel.setBackground(new Color(255, 228, 181));
		  buttonCancel.addActionListener(new ReturnVehicleAction());
		  return booking;
		}
	
	
	
	
	public void EditBookingAction(){
		EditBookingPage editBooking = new EditBookingPage(this);
		JOptionPane.showMessageDialog(null,editBooking.getAddBookingPanel(),
				"Editing booking...",JOptionPane.PLAIN_MESSAGE);
		
	}
	

	private class EditBookingAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			EditBookingAction();
		}
		}
	
	
	
	///REMOVE BOOKING ACTION SPACE
	private void RemoveBookingAction() {
		UserInterface.getBookingList().removeBooking(this);
		UserInterface.saveFile();
		ManageBookings.showAllBookings();
		
	}
	
	private class RemoveBookingAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			RemoveBookingAction();
			JOptionPane.showMessageDialog(null,"Booking was removed successfully!",
					"Remove booking...",JOptionPane.PLAIN_MESSAGE);
			CheckTodayBooking.showTodayBookings();
		}

		}
	
	
	public JPanel getReturnVehiclePopUp(){
		this.flag= false;
		Font buttonFont=new Font("Abel", Font.BOLD, 18);	
		this.returnPopUpPanel= new JPanel();
		returnPopUpPanel.setBorder(new EmptyBorder(30,30,30,30));
		returnPopUpPanel.setLayout(new GridLayout(0,1,10,10));
		returnPopUpPanel.setBackground(Color.WHITE);
		this.returnKmNo= new JLabel("Please fill in km. number: ");
		returnKmNo.setFont(buttonFont);
		this.returnKmNoField= new JTextField(20);
		returnKmNoField.setFont(buttonFont);
		this.btnCalculate= new JButton("Calculate price");
		this.btnAddKmToVehicle= new JButton("Add km to vehicle");
		btnCalculate.setFont(buttonFont);
		btnCalculate.setForeground(new Color(0, 0, 128));
		btnCalculate.setBackground(new Color(255, 228, 181));
		btnCalculate.addActionListener(new CalculatePrice());
		btnAddKmToVehicle.setFont(buttonFont);
		btnAddKmToVehicle.setForeground(new Color(0, 0, 128));
		btnAddKmToVehicle.setBackground(new Color(255, 228, 181));
		btnAddKmToVehicle.addActionListener(new addKmToVehicles());
		this.extraPrice= new JLabel("Extra price: ");
		extraPrice.setFont(buttonFont);
		this.priceShow= new JLabel();
		priceShow.setFont(buttonFont);
		returnPopUpPanel.add(returnKmNo);
		returnPopUpPanel.add(returnKmNoField);
		returnPopUpPanel.add(btnCalculate);
		returnPopUpPanel.add(extraPrice);
		returnPopUpPanel.add(priceShow);
		returnPopUpPanel.add(btnAddKmToVehicle);
		return returnPopUpPanel;
		
	}
	/**
	 * calculate  if there is extra price need to be payed
	 */
	public void calculatePrice(){
		priceShow.setText(ReturnVehicle.calculatePrice(returnKmNoField.getText(), this)+"");
		priceShow.repaint();
		priceShow.revalidate();
	}
	
	
	private class CalculatePrice implements ActionListener{
		public void actionPerformed(ActionEvent e){
			calculatePrice();
		}

		}
	
	/**
	 * updating the vehicle KM after it is returned 
	 */
	public void addKmToVehicles(){
		
		if(Integer.parseInt(returnKmNoField.getText())>=Integer.parseInt(this.getVehicle().getNumberOfKm())){
		
		if(flag==false){
		int initialKm=Integer.parseInt(this.getVehicle().getNumberOfKm());
		this.getVehicle().setNumberOfKm(((Integer.parseInt((returnKmNoField.getText()))-initialKm)+initialKm)+"");
		int initialRemKm=Integer.parseInt(this.getVehicle().getRemainingKm());
		this.getVehicle().setRemainingKm(initialRemKm-((Integer.parseInt((returnKmNoField.getText()))-initialKm))+"");
		ReturnedVehicle.showAllBookings();
		JOptionPane.showMessageDialog(null,"Km added successfully",
				"Adding km...",JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null,"Car was successfully returned!",
				"Remove booking...",JOptionPane.PLAIN_MESSAGE);
		UserInterface.getBookingList().removeBooking(this);
		UserInterface.saveFile();
		flag=true;}
		else{
			JOptionPane.showMessageDialog(null,"Km already added",
					"Adding km error...",JOptionPane.PLAIN_MESSAGE);
		}
		}
		else{
			JOptionPane.showMessageDialog(null,"Km entered are fewer than the car has",
					"Adding km error...",JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
	
	private class addKmToVehicles implements ActionListener{
		public void actionPerformed(ActionEvent e){
			addKmToVehicles();
		}

		}
	
	
	private void ReturnVehicleAction() {
		JOptionPane.showMessageDialog(null,getReturnVehiclePopUp(),
				"Returning procedure",JOptionPane.PLAIN_MESSAGE);
		ReturnedVehicle.showAllBookings();
		
	}
	
	private class ReturnVehicleAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ReturnVehicleAction();
			
			
		}

		}
	
	
}
