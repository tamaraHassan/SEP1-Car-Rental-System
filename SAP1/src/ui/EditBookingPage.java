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

public class EditBookingPage implements Serializable{

	
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
private Booking booking;
private JButton btnBookingVehicle;






public EditBookingPage(Booking booking){
	this.booking= booking;
	firstName= new JTextField (20);
	firstName.setText(booking.getCustomer().getFirstName());
	firstName.setEditable(false);
	lastName= new JTextField (20);
	lastName.setText(booking.getCustomer().getLastName());
	lastName.setEditable(false);
	licenseNumber= new JTextField (20);
	address= new JTextField (20);
	address.setText(booking.getCustomer().getAddress());
	address.setEditable(false);
	phoneNumber= new JTextField (20);
	phoneNumber.setText(booking.getCustomer().getPhoneNumber());
	phoneNumber.setEditable(false);
	firstNameLabel= new JLabel("First name: ");
	lastNameLabel= new JLabel("Last name: ");
	licenseNumberLabel= new JLabel("License number: ");
	licenseNumber.setText(booking.getCustomer().getLicenseNumber());
	addressLabel= new JLabel("Address: ");
	phoneNumberLabel= new JLabel("Phone number: ");

	dropOffTimeLabel=new JLabel("Return time: ");

	getAddBookingPanel();
}

public void EditBookingButtonAction(){
	if(!(licenseNumber.getText().equals(""))){
	booking.getCustomer().setLicenseNumber(licenseNumber.getText());
	booking.setBookingStatus("Completed");
	JOptionPane.showMessageDialog(null,"Update successfull","Done!",JOptionPane.PLAIN_MESSAGE);
	UserInterface.saveFile();
	ManageBookings.showAllBookings();
	}
	else{
		JOptionPane.showMessageDialog(null,"Fill license number field","Error saving...",JOptionPane.PLAIN_MESSAGE);
	}
}


private class AddBookingButtonAction implements ActionListener{
	public void actionPerformed(ActionEvent e){
		EditBookingButtonAction();
	}
	}



public JPanel getAddBookingPanel(){
	   
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
	
	this.btnBookingVehicle= new JButton("Save changes");
	Font buttonFont=new Font("Abel", Font.BOLD, 22);
	btnBookingVehicle.setFont(buttonFont);
	btnBookingVehicle.setForeground(new Color(0, 0, 128));
	btnBookingVehicle.setBackground(new Color(255, 228, 181));
	btnBookingVehicle.addActionListener(new AddBookingButtonAction());
	

	bookingDescription.removeAll();
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


	bookingDescription.add(new JLabel(""));
	bookingDescription.add(new JLabel(""));
	bookingDescription.add(new JLabel(""));
	bookingDescription.add(btnBookingVehicle);
	bookingDescription.repaint();
	bookingDescription.revalidate();
	
	

	
	eachBookingPanel.add(northHolder,BorderLayout.NORTH);
	eachBookingPanel.add(bookingDescription,BorderLayout.CENTER);
	
	
	

	
	return eachBookingPanel;
}



/*
public static void main(String[] args){
	EditBookingPage addBookingPage= new EditBookingPage(new Booking((new FamilyCars("MV24167", "black", "available", "A120", "Audi", "manual", "134540", "2012","109", "7000", "2345","12km/l",   "no", "yes", "5", "5", "no", "510l", "no", "yes", "300")), new Customer("BASHAR", "BASHAR", "123123", "address", "123123"), new MyDate(1, 6, 2016), new MyDate(4, 6, 2016), "8", "16", "HORSENS", "HORSENS", "Complete"));
	JFrame mainframe= new JFrame("TEST FOR ADD BOOKING");
	mainframe.setSize(new Dimension(700,800));
	mainframe.getContentPane().add(addBookingPage.getAddBookingPanel(1));
	
	mainframe.setVisible(true);
}
*/

	
}
