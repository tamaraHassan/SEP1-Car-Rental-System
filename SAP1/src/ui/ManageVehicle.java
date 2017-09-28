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
import javax.swing.JComponent;
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


public class ManageVehicle implements Serializable{

/// FIELDS START///////////////////////////////////////////////////////////////////////
   JPanel mainPanelCardLayaout;
   JPanel panelMenuGrid;
   VehicleList vehicleList;   
   
   JPanel manageVehiclePage;
   
   JPanel titlePanel;
   
   JPanel backButtonPanel;
   JButton btnBack;
   
   JPanel searchButtonAreaPanel;
   JButton btnSearch;
   JTextField searchField;
   
   JButton btnShowAll;
   
   JPanel listViewScrollContainer;
   
   static JPanel listView;
   JScrollPane scrollPane;
   
   TitledBorder titleSearch = BorderFactory.createTitledBorder("Search");
   TitledBorder titleDisplayArea = BorderFactory.createTitledBorder("Manage vehicles area");
   
   JLabel lblManageVehicles= new JLabel("Manage vehicles");
   
   JButton btnAddVehicle;
   
///FIELDS END///////////////////////////////////////////////////////////////////////////////
   
   
   

/// CONSTRUCTOR (THIS SHOULD INCLUDE THE BUILD PAGE METHOD) 
public ManageVehicle(JPanel mainPanelCardLayaout, JPanel panelMenuGrid, VehicleList vehicleList){
   this.mainPanelCardLayaout=mainPanelCardLayaout;
   this.panelMenuGrid= panelMenuGrid;
   this.vehicleList=vehicleList;
   this.manageVehiclePage= new JPanel();
   this.backButtonPanel= new JPanel();
   this.btnBack= new JButton("Back");
   this.searchButtonAreaPanel= new JPanel();
   this.searchField= new JTextField(40);
   this.btnSearch= new JButton("Search");
   this.btnShowAll=new JButton("Show all vehicles");
   this.btnAddVehicle=new JButton("Add new vehicle");
   this.titlePanel= new JPanel();
   this.listViewScrollContainer= new JPanel();
   this.listView= new JPanel();
   btnBack.addActionListener(new ToFirstPage());
   buildManageVehicles();
   System.out.println("VEHICLE LIST SIZE ON MANAGE VEHICLES: "+vehicleList.size());
}


public static void showAllVehicles(){
	System.out.println("VEHICLE LIST SIZE ON MANAGE VEHICLES: "+UserInterface.getVehicleList().size());
	listView.removeAll();
	listView.repaint();
	listView.revalidate();
	if(UserInterface.getVehicleList().size()>0){
	for(int i=0; i<UserInterface.getVehicleList().size(); i++){
		listView.add(UserInterface.getVehicleList().get(i).getVehicleWithRemovePanel());
		System.out.println("COUNTER "+i);
	}
	listView.repaint();
	listView.revalidate();}
	else{
		listView.add(new JLabel("No vehicles to display yet...."));
		listView.repaint();
		listView.revalidate();
	}
}


/// RETURNS THE PAGE MAIN PANEL TO THE MAIN MENU CLASS FOR CONTROL PURPOSES
public JPanel getManageVehiclePage(){
   return manageVehiclePage;
}



/// MAIN CLASS THAT BUILDS THE PAGE GUI
public void buildManageVehicles(){
   
   GridBagConstraints c= new GridBagConstraints();
   GridBagLayout searchPanelGridBag= new GridBagLayout();
   
   manageVehiclePage.setLayout(searchPanelGridBag);
   searchPanelGridBag.setConstraints(manageVehiclePage,c);
   
   btnAddVehicle.addActionListener(new AddVehicleButtonAction());

   c.weighty=0.5;
   
   c.fill= GridBagConstraints.HORIZONTAL;
   c.anchor= GridBagConstraints.LAST_LINE_START;
   
   
   c.gridx=0;
   c.gridy=0;
   c.gridwidth = 3;
   c.weightx = 0.5;
   manageVehiclePage.add(backButtonPanel,c);
   
   c.gridx=0;
   c.gridy=1;
   c.gridwidth = 3;
   c.weightx = 0.5;
   manageVehiclePage.add(titlePanel,c);
   
   c.gridx=0;
   c.gridy=2;
   c.gridwidth = 3;
   c.weightx = 0.5;
   manageVehiclePage.add(searchButtonAreaPanel,c);
   
   
   c.gridx=0;
   c.gridy=3;
   c.gridwidth = 3;
   c.weightx = 0.5;
   c.ipady= 100;
   manageVehiclePage.add(listViewScrollContainer,c);
   
   c.gridx=0;
   c.gridy=4;
   c.gridwidth = 3;
   c.weightx = 0.5;
   c.ipady= 50;
   manageVehiclePage.add(new JLabel(""),c);
   

   addElementsToSearchPanel();
   addElementsToBackPanel();
   addElementsToTitlePanel();
   buildScrollPanel();
   customizePageTemplate();
   

}

///ADD ELEMENTS TO PANELS AREA START
public void addElementsToTitlePanel(){
   titlePanel.add(lblManageVehicles);
}

public void addElementsToSearchPanel() {
   searchButtonAreaPanel.add(new JLabel("Search by reg. number")).setFont(new Font("Abel", Font.BOLD, 14));
   searchButtonAreaPanel.add(searchField);
   searchButtonAreaPanel.add(new JLabel("     "));
   searchButtonAreaPanel.add(btnSearch);
   searchButtonAreaPanel.add(new JLabel("     "));
   searchButtonAreaPanel.add(btnShowAll);
}
/// ADD ELEMENTS TO PANEL AREA END


public void addElementsToBackPanel(){
   backButtonPanel.add(btnBack);
}


// LIGHT PAGE CUSTOMIZATION (IT WILL BE IGNORED WHEN A STYLE SHEET CLASS WILL BE ADDED)
public void customizePageTemplate(){
   
   lblManageVehicles.setFont(new Font("Tahoma", Font.BOLD, 32));
   titlePanel.setBackground(Color.WHITE);
   manageVehiclePage.setBackground(Color.WHITE);
   backButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
   backButtonPanel.setBackground(Color.WHITE);
   searchButtonAreaPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

   searchButtonAreaPanel.setBackground(Color.WHITE);
   
   Font buttonFont=new Font("Abel", Font.BOLD, 22);
   btnSearch.setFont(buttonFont);
   btnSearch.setForeground(new Color(0, 0, 128));
   btnSearch.setBackground(new Color(255, 228, 181));
   btnSearch.addActionListener(new SearchForRegNo());
   
   btnBack.setForeground(new Color(0, 0, 128));
   btnBack.setBackground(new Color(255, 228, 181));
   btnBack.setFont(buttonFont);
   
   btnShowAll.setForeground(new Color(0, 0, 128));
   btnShowAll.setBackground(new Color(255, 228, 181));
   btnShowAll.setFont(buttonFont);
   btnShowAll.addActionListener(new ShowAllVehicles());
   
   btnAddVehicle.setForeground(new Color(0, 0, 128));
   btnAddVehicle.setBackground(new Color(255, 228, 181));
   btnAddVehicle.setFont(buttonFont);
   
   searchButtonAreaPanel.setBorder(titleSearch);
   Font font14Abel=new Font("Abel", Font.BOLD, 14);
   searchField.setFont(font14Abel);
   
   listViewScrollContainer.setBackground(Color.WHITE);
   listViewScrollContainer.setBorder(titleDisplayArea);
   //listViewScrollContainer.setLayout(new GridLayout(1,1,0,0));
   
   
   listViewScrollContainer.setBackground(Color.WHITE);
   listView.setBackground(Color.WHITE);
   listView.setBorder(new EmptyBorder(10,10,10,10));
   titleDisplayArea.setTitleFont(font14Abel);
   titleSearch.setTitleFont(font14Abel);
   manageVehiclePage.setBorder(new EmptyBorder(20, 30, 20, 30));
   
   
}

///SCROLL AREA OF THE PAGE WHERE ALL THE ELEMENTS ARE SHOWN FROM THE ARRAY LIST
public void buildScrollPanel(){
   scrollPane= new JScrollPane(listView,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
   listViewScrollContainer.setSize(new Dimension(900, 400));
   listViewScrollContainer.setLayout(new BorderLayout());
   JPanel panelAddVehicle= new JPanel();
   panelAddVehicle.setLayout(new FlowLayout(FlowLayout.RIGHT));
   panelAddVehicle.add(btnAddVehicle);
   listViewScrollContainer.add(panelAddVehicle, BorderLayout.NORTH);
   listViewScrollContainer.add(scrollPane,BorderLayout.CENTER);
   scrollPane.setPreferredSize(new Dimension(900, 400));
   //listView.setPreferredSize(new Dimension(900, 100));
   listView.setLayout(new GridLayout(0,1,5,5));
   showAllVehicles();
}


// METHOD THAT CONTROLS THE BACK BUTTON
private class ToFirstPage implements ActionListener{
   public void actionPerformed(ActionEvent e){
      mainPanelCardLayaout.removeAll();
      mainPanelCardLayaout.add(panelMenuGrid);
      UserInterface.saveFile();
      mainPanelCardLayaout.repaint();
      mainPanelCardLayaout.revalidate();
   }
   
}

// METHOD THAT CONTROLS THE SEARCH BUTTON
private class SearchForRegNo implements ActionListener{
	   public void actionPerformed(ActionEvent e){
		
		   if(vehicleList.getVehiclesByRegNo(searchField.getText())!=null){
			listView.removeAll();
			listView.add((vehicleList.getVehiclesByRegNo(searchField.getText())).getVehicleWithRemovePanel());
			searchField.setText("");
			listView.repaint();
			listView.revalidate();
		   }
		   else{
			JOptionPane.showMessageDialog(null,"There is no car with that registration number","Search result",JOptionPane.PLAIN_MESSAGE);
			searchField.setText("");
		   }
		
	   }
	   
	}


//METHOD THAT SHOWS ALL VEHICLES
private class ShowAllVehicles implements ActionListener{
	   public void actionPerformed(ActionEvent e){
		   showAllVehicles();
		   searchField.setText("");
	   }
	   
	}


//METHOD THAT CONTROLS THE ADD VEHICLE BUTTON
public void addVehicleButtonAction(){
	AddVehiclePage addVehiclePagePopUp = new AddVehiclePage(vehicleList,this);
	JOptionPane.showOptionDialog(null, addVehiclePagePopUp.getAddVehiclePanel(),"Add a car", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
	}


private class AddVehicleButtonAction implements ActionListener{
public void actionPerformed(ActionEvent e){
	addVehicleButtonAction();
}

}

}