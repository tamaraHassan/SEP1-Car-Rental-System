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

public class AddBookingPage implements Serializable {

	
private JPanel eachBookingPanel;
private JPanel bookingDescription;
private JLabel bookingTitle;
private JPanel northHolder;
private JPanel typePanel;
private JRadioButton rdbCustomerType;
private JRadioButton rdbServiceType;

private JTextField firstName;
private JTextField lastName;
private JTextField licenseNumber;
private JTextField address;
private JTextField phoneNumber;

private JLabel firstNameLabel;
private JLabel lastNameLabel;
private JLabel licenseNumberLabel;
private JLabel addressLabel;
private JLabel phoneNumberLabel;

//booking info
private JTextField dropOffTime;
private JLabel dropOffTimeLabel;
private BookingList bookingList;
private Vehicle vehicle;
private JButton btnBookingVehicle;
private SearchPage searchPage;
private JComboBox<String> dropOffCombo;
private AddBooking addBooking;


public AddBookingPage(BookingList bookingList, Vehicle vehicle, SearchPage searchPage){
	this.dropOffCombo= new JComboBox<String>();
	this.searchPage=searchPage;
	this.bookingList= bookingList;
	this.vehicle= vehicle;
	this.rdbCustomerType= new JRadioButton("Customer");
	this.rdbServiceType= new JRadioButton("Service and maintenance");
	addBooking= new AddBooking(vehicle, searchPage, this);
	firstName= new JTextField (20);
	lastName= new JTextField (20);
	licenseNumber= new JTextField (20);
	address= new JTextField (20);
	phoneNumber= new JTextField (20);
	
	firstNameLabel= new JLabel("First name: ");
	lastNameLabel= new JLabel("Last name: ");
	licenseNumberLabel= new JLabel("License number: ");
	addressLabel= new JLabel("Address: ");
	phoneNumberLabel= new JLabel("Phone number: ");

	dropOffTime= new JTextField();
	dropOffTimeLabel=new JLabel("Return time: ");

	getAddBookingPanel(1);
	
}

public void AddBookingButtonAction(){
	AddBooking addBooking= new AddBooking(vehicle, searchPage, this);
	addBooking.addBookingToList();
}


private class AddBookingButtonAction implements ActionListener, Serializable{
	public void actionPerformed(ActionEvent e){
		AddBookingButtonAction();
	}
	}


public void populateDropOffTimeCombo(){
for (int i = 8; i < 18; i++)
{
   dropOffCombo.addItem(i+"");
}
}
public JPanel getAddBookingPanel(int i){
	   
	Font font=new Font("Abel", Font.BOLD, 22);
	Font font2=new Font("Abel", Font.BOLD, 36);
	this.eachBookingPanel= new JPanel();
	eachBookingPanel.setBackground(Color.WHITE);
	this.bookingDescription= new JPanel();
	bookingDescription.setLayout(new GridLayout(0,2,30,20));
	this.bookingTitle= new JLabel(" Add a booking",SwingConstants.CENTER);
	this.northHolder= new JPanel();
	northHolder.setBackground(Color.WHITE);
	//this.typePanel=new JPanel();
	//typePanel.setBackground(Color.WHITE);
	bookingTitle.setFont(font2);
	bookingDescription.setBackground(Color.WHITE);
	bookingDescription.setBorder(new EmptyBorder(30,160,30,160));
	
	//typePanel.add(rdbCustomerType);
	//typePanel.add(rdbServiceType);
	
	
	northHolder.setLayout(new GridLayout(0,1,0,0));
	northHolder.add(bookingTitle);
	
	//northHolder.add(typePanel);
	
	this.btnBookingVehicle= new JButton("Reserve");
	Font buttonFont=new Font("Abel", Font.BOLD, 22);
	btnBookingVehicle.setFont(buttonFont);
	btnBookingVehicle.setForeground(new Color(0, 0, 128));
	btnBookingVehicle.setBackground(new Color(255, 228, 181));
	btnBookingVehicle.addActionListener(new AddBookingButtonAction());
	
	double totalPrice=addBooking.calculateTotalPrice();
	double discount=addBooking.calculateDiscount();
	
	northHolder.add(new JLabel("    Discount: "+discount+""));
	northHolder.add(new JLabel("    Total price: "+totalPrice+""));
	
	populateDropOffTimeCombo();
	if(i==1){
	bookingDescription.removeAll();
	firstName.setEditable(true);
	lastName.setEditable(true);
	licenseNumber.setEditable(true);
	address.setEditable(true);
	phoneNumber.setEditable(true);
	bookingDescription.add(firstNameLabel);
	bookingDescription.add(firstName);
	bookingDescription.add(lastNameLabel);
	bookingDescription.add(lastName);
	bookingDescription.add(licenseNumberLabel);
	bookingDescription.add(licenseNumber);
	bookingDescription.add(addressLabel);
	bookingDescription.add(address);
	bookingDescription.add(phoneNumberLabel);
	bookingDescription.add(phoneNumber);

	bookingDescription.add(dropOffTimeLabel);
	bookingDescription.add(dropOffCombo);

	bookingDescription.add(new JLabel(""));
	bookingDescription.add(new JLabel(""));
	bookingDescription.add(new JLabel(""));
	bookingDescription.add(btnBookingVehicle);
	bookingDescription.repaint();
	bookingDescription.revalidate();
	
	}
	
	if(i==2){
		bookingDescription.removeAll();
		firstName.setEditable(false);
		lastName.setEditable(false);
		licenseNumber.setEditable(false);
		address.setEditable(false);
		phoneNumber.setEditable(false);
		bookingDescription.add(firstNameLabel);
		bookingDescription.add(firstName);
		bookingDescription.add(lastNameLabel);
		bookingDescription.add(lastName);
		bookingDescription.add(licenseNumberLabel);
		bookingDescription.add(licenseNumber);
		bookingDescription.add(addressLabel);
		bookingDescription.add(address);
		bookingDescription.add(phoneNumberLabel);
		bookingDescription.add(phoneNumber);

		bookingDescription.add(dropOffTimeLabel);
		bookingDescription.add(dropOffCombo);

		bookingDescription.add(new JLabel(""));
		bookingDescription.add(new JLabel(""));
		bookingDescription.add(new JLabel(""));
		bookingDescription.add(btnBookingVehicle);

		firstName.setText("Service");
		lastName.setText("Service");
		licenseNumber.setText("NOT AVAILABLE");
		address.setText("-");
		phoneNumber.setText("-");

		firstName.setEditable(false);
		lastName.setEditable(false);
		licenseNumber.setEditable(false);
		address.setEditable(false);
		phoneNumber.setEditable(false);
		
		bookingDescription.repaint();
		bookingDescription.revalidate();
	}

	
	eachBookingPanel.add(northHolder,BorderLayout.NORTH);
	eachBookingPanel.add(bookingDescription,BorderLayout.CENTER);
	
	
	

	
	return eachBookingPanel;
}

public JPanel getEachBookingPanel() {
	return eachBookingPanel;
}

public JPanel getBookingDescription() {
	return bookingDescription;
}

public JLabel getBookingTitle() {
	return bookingTitle;
}

public JPanel getNorthHolder() {
	return northHolder;
}

public JPanel getTypePanel() {
	return typePanel;
}

public JRadioButton getRdbCustomerType() {
	return rdbCustomerType;
}

public JRadioButton getRdbServiceType() {
	return rdbServiceType;
}

public JTextField getFirstName() {
	return firstName;
}

public JTextField getLastName() {
	return lastName;
}

public JTextField getLicenseNumber() {
	return licenseNumber;
}

public JTextField getAddress() {
	return address;
}

public JTextField getPhoneNumber() {
	return phoneNumber;
}

public JLabel getFirstNameLabel() {
	return firstNameLabel;
}

public JLabel getLastNameLabel() {
	return lastNameLabel;
}

public JLabel getLicenseNumberLabel() {
	return licenseNumberLabel;
}

public JLabel getAddressLabel() {
	return addressLabel;
}

public JLabel getPhoneNumberLabel() {
	return phoneNumberLabel;
}

public JTextField getDropOffTime() {
	return dropOffTime;
}

public JLabel getDropOffTimeLabel() {
	return dropOffTimeLabel;
}

public BookingList getBookingList() {
	return bookingList;
}

public Vehicle getVehicle() {
	return vehicle;
}

public JButton getBtnBookingVehicle() {
	return btnBookingVehicle;
}






/*
public static void main(String[] args){
	AddBookingPage addBookingPage= new AddBookingPage();
	JFrame mainframe= new JFrame("TEST FOR ADD BOOKING");
	mainframe.setSize(new Dimension(600,600));
	mainframe.getContentPane().add(addBookingPage.getAddBookingPanel(2));
	
	mainframe.setVisible(true);
}

*/
	
}
