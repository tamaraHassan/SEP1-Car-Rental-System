package doc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import ui.AddBookingPage;
import ui.ManageVehicle;
import ui.UserInterface;
import ui.VehicleMaintenancePage;


/**
 * 
 * Creating FamilyCar
 *
 */

public class FamilyCars extends Vehicle implements Serializable
{

   private String numberOfDoors;
   private String numberOfSeats;
   private String childSeat;
   private String trunkCapacity;
   private String trailerCoupling;
   private String roofStorage;
   private VehicleActionListener listener;//****NEW

 
   /* regNo, color, vehicleStatus, model, maker, transmission,
   numberOfKm, year, horsePower, numberOfGears,
   remainingKm, engineSize, fuelConsumption,
   navigationSystem, cruiseControl,price*/
   /**
    * Constructor to initialize the family car
    * @param regNo
    * @param color
    * @param vehicleStatus
    * @param model
    * @param maker
    * @param transmission
    * @param numberOfKm
    * @param year
    * @param horsePower
    * @param remainingKm
    * @param engineSize
    * @param fuelConsumption
    * @param navigationSystem
    * @param cruiseControl
    * @param numberOfDoors
    * @param numberOfSeats
    * @param childSeat
    * @param trunkCapacity
    * @param trailerCoupling
    * @param roofStorage
    * @param price
    */
   public FamilyCars(String regNo, String color, String vehicleStatus,
         String model, String maker, String transmission, String numberOfKm,
         String year, String horsePower, String remainingKm, String engineSize, String fuelConsumption,
         String navigationSystem, String cruiseControl, String numberOfDoors,
         String numberOfSeats, String childSeat,
         String trunkCapacity, String trailerCoupling, String roofStorage,String price)
   {
      super(regNo, color, vehicleStatus, model, maker, transmission,
            numberOfKm, year, horsePower,remainingKm, engineSize, fuelConsumption,
            navigationSystem, cruiseControl,price);
      this.numberOfDoors = numberOfDoors;
      this.numberOfSeats = numberOfSeats;
      this.childSeat = childSeat;
      this.trunkCapacity = trunkCapacity;
      this.trailerCoupling = trailerCoupling;
      this.roofStorage = roofStorage;
      
      UIManager UI=new UIManager();
	   UI.put("OptionPane.background",new ColorUIResource(255, 228, 181));
	   UI.put("Panel.background",new ColorUIResource(255, 255, 255));

   }
   //PANEL WITH RESERVE BUTTON 
   @Override
   /**
    * JPanel with reserve and view button
    */
   public JPanel getVehiclePanel() {
	    JPanel car= new JPanel(new GridLayout(1,3,0,0));
		car.setBorder(new EmptyBorder(10,10,20,10));
		JPanel carDetailsText= new JPanel(new GridLayout(2,1,0,0));
		JPanel carButtons= new JPanel(new GridLayout(1,2,10,10));
		JLabel carDetailRow1= new JLabel("Maker: "+super.getMaker()+", Model: "+super.getModel()+",  Reg. no: "+super.getRegNo()+", Year: "+super.getYear()+", ");
		JLabel carDetailRow2= new JLabel("Transmision: "+super.getTransmission()+", Color: "+super.getColor()+", Fuel ef.: "+super.getFuelConsumption());
		JButton buttonView= new JButton("View");
		JButton buttonReserve= new JButton("Reserve");
		carDetailsText.add(carDetailRow1);
		carDetailsText.add(carDetailRow2);
		carButtons.add(buttonView);
		carButtons.add(buttonReserve);
		car.add(carDetailsText);
		car.add(new JLabel("PRICE: "+getPrice()));
		car.add(carButtons);
		
		Font buttonFont=new Font("Abel", Font.BOLD, 18);
		buttonView.setFont(buttonFont);
		buttonView.setForeground(new Color(0, 0, 128));
		buttonView.setBackground(new Color(255, 228, 181));
		buttonView.addActionListener(new ShowCarDetails());
		
		buttonReserve.setFont(buttonFont);
		buttonReserve.setForeground(new Color(0, 0, 128));
		buttonReserve.setBackground(new Color(255, 228, 181));
		buttonReserve.addActionListener(new addReservation());
   	return car;
   }
   /**
    * JPanel with remove and view button
    */
   //PANEL WITH REMOVE BUTTON 
   public JPanel getVehicleWithRemovePanel() {
      JPanel car= new JPanel(new GridLayout(1,3,0,0));
     car.setBorder(new EmptyBorder(10,10,20,10));
     JPanel carDetailsText= new JPanel(new GridLayout(2,1,0,0));
     JPanel carButtons= new JPanel(new GridLayout(1,2,10,10));
     JLabel carDetailRow1= new JLabel("Maker: "+super.getMaker()+", Model: "+super.getModel()+",  Reg. no: "+super.getRegNo()+", Year: "+super.getYear()+", ");
     JLabel carDetailRow2= new JLabel("Transmision: "+super.getTransmission()+", Color: "+super.getColor()+", Fuel ef.: "+super.getFuelConsumption());
     JButton buttonView= new JButton("View");
     JButton buttonRemove= new JButton("Remove");
     //***********NEW
     listener=new VehicleActionListener(UserInterface.getVehicleList(), this,buttonRemove);
     buttonRemove.addActionListener(listener);
     //-------------
     carDetailsText.add(carDetailRow1);
     carDetailsText.add(carDetailRow2);
     carButtons.add(buttonView);
     carButtons.add(buttonRemove);
     car.add(carDetailsText);
     car.add(new JLabel("PRICE: "+getPrice()));
     car.add(carButtons);
     
     Font buttonFont=new Font("Abel", Font.BOLD, 18);
     buttonView.setFont(buttonFont);
     buttonView.setForeground(new Color(0, 0, 128));
     buttonView.setBackground(new Color(255, 228, 181));
     buttonView.addActionListener(new ShowCarDetails());
     
     buttonRemove.setFont(buttonFont);
     buttonRemove.setForeground(new Color(0, 0, 128));
     buttonRemove.setBackground(new Color(255, 228, 181));
     return car;
  }
   //-----------------
   
   /**
    * JPanel with service and view button
    */
   //PANEL WITH SERVICE BUTTON 
   @Override
   public JPanel getVehicleWithServicePanel() {
	    JPanel car= new JPanel(new GridLayout(1,3,0,0));
		car.setBorder(new EmptyBorder(10,10,20,10));
		JPanel carDetailsText= new JPanel(new GridLayout(2,1,0,0));
		JPanel carButtons= new JPanel(new GridLayout(1,2,10,10));
		JLabel carDetailRow1= new JLabel("Maker: "+super.getMaker()+", Model: "+super.getModel()+", Reg. no: "+super.getRegNo()+", Year: "+super.getYear()+", ");
		JLabel carDetailRow2= new JLabel("Transmision: "+super.getTransmission()+", Color: "+super.getColor()+", Fuel ef.: "+super.getFuelConsumption());
		JButton buttonView= new JButton("View");
		JButton buttonService= new JButton("Reset km.");
		carDetailsText.add(carDetailRow1);
		carDetailsText.add(carDetailRow2);
		carButtons.add(buttonView);
		carButtons.add(buttonService);
		car.add(carDetailsText);
		car.add(new JLabel("Remaining km.: "+getRemainingKm()));
		car.add(carButtons);
		
		Font buttonFont=new Font("Abel", Font.BOLD, 18);
		buttonView.setFont(buttonFont);
		buttonView.setForeground(new Color(0, 0, 128));
		buttonView.setBackground(new Color(255, 228, 181));
		buttonView.addActionListener(new ShowCarDetails());
		
		buttonService.setFont(buttonFont);
		buttonService.setForeground(new Color(0, 0, 128));
		buttonService.setBackground(new Color(255, 228, 181));
		buttonService.addActionListener(new addServiceReservation());
   	return car;
   }
   
   
   /**
    *  viewing cars info
    * @return each car Panel
    */
   public JPanel constructCarView(){
	   
		Font font=new Font("Abel", Font.BOLD, 22);
		Font font2=new Font("Abel", Font.BOLD, 36);
		JPanel eachCarPanel= new JPanel();
		eachCarPanel.setBackground(Color.WHITE);
		JPanel carDescription= new JPanel();
		carDescription.setLayout(new GridLayout(0,2,30,20));
		JLabel carTitle= new JLabel(super.getMaker()+" "+super.getModel()+"",SwingConstants.CENTER);
		carTitle.setFont(font2);
		carDescription.setBackground(Color.WHITE);
		carDescription.setBorder(new EmptyBorder(30,160,30,160));
		eachCarPanel.setLayout(new BorderLayout());
		eachCarPanel.add(carTitle,BorderLayout.NORTH);
		eachCarPanel.add(carDescription,BorderLayout.CENTER);
		carDescription.add(new JLabel("Registration no: "));
		carDescription.add(new JLabel(super.getRegNo())).setFont(font);
		carDescription.add(new JLabel("Price: "));
		carDescription.add(new JLabel(super.getPrice())).setFont(font);
		carDescription.add(new JLabel("Engine: "));
		carDescription.add(new JLabel(super.getEngineSize())).setFont(font);
		carDescription.add(new JLabel("Transmision:"));
		carDescription.add(new JLabel(super.getTransmission())).setFont(font);
		carDescription.add(new JLabel("Doors: "));
		carDescription.add(new JLabel(numberOfDoors)).setFont(font);
		carDescription.add(new JLabel("Seats: "));
		carDescription.add(new JLabel(numberOfSeats)).setFont(font);
		carDescription.add(new JLabel("Trunk: "));
		carDescription.add(new JLabel(trunkCapacity)).setFont(font);
		carDescription.add(new JLabel("Kilometers: "));
		carDescription.add(new JLabel(super.getNumberOfKm())).setFont(font);
		carDescription.add(new JLabel("Hp: "));
		carDescription.add(new JLabel(super.getHorsePower())).setFont(font);
		carDescription.add(new JLabel("Roof storage: "));
		carDescription.add(new JLabel(roofStorage)).setFont(font);
		carDescription.add(new JLabel("Trailer ready: "));
		carDescription.add(new JLabel(trailerCoupling)).setFont(font);
		carDescription.add(new JLabel("Child seat: "));
		carDescription.add(new JLabel(childSeat)).setFont(font);
		return eachCarPanel;
	}
   

   private class ShowCarDetails implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null,constructCarView(),"Car Information",JOptionPane.PLAIN_MESSAGE);
	
		}
}
	
	

 //RESERVE PAGE COMPONENTS
   public void addReservationPanelCalling(){
      AddBookingPage addBooking = new AddBookingPage(UserInterface.getBookingList(), this, UserInterface.getSearchPage());
      JOptionPane.showMessageDialog(null,addBooking.getAddBookingPanel(1),"Add Booking",JOptionPane.PLAIN_MESSAGE);
   }
   
   
   private class addReservation implements ActionListener{
      public void actionPerformed(ActionEvent e){
         addReservationPanelCalling();
   
      }
}
 //RESERVE PAGE COMPONENTS

   
   //SERVICE RES PAGE COMPONENTS
   /**
    * resetting the remaining KM to 20,000 and showing success message
    */
   public void addServicePanelCalling(){
      super.setRemainingKm("20000");
      UserInterface.saveFile();
      JOptionPane.showMessageDialog(null,"Maintenance done, km were reseted to 20.000.","Reset kilometers",JOptionPane.PLAIN_MESSAGE);
      VehicleMaintenancePage.showVehiclesByRemKm();
   }
   
   
   private class addServiceReservation implements ActionListener{
      public void actionPerformed(ActionEvent e){
    	  addServicePanelCalling();
   
      }
}
 //SERVICE RES PAGE COMPONENTS   
   
   
   public String getNumberOfDoors()
   {
      return numberOfDoors;
   }




   public void setNumberOfDoors(String numberOfDoors)
   {
      this.numberOfDoors = numberOfDoors;
   }




   public String getNumberOfSeats()
   {
      return numberOfSeats;
   }




   public void setNumberOfSeats(String numberOfSeats)
   {
      this.numberOfSeats = numberOfSeats;
   }



   public String isChildSeat()
   {
      return childSeat;
   }




   public void setChildSeat(String childSeat)
   {
      this.childSeat = childSeat;
   }




   public String getTrunkCapacity()
   {
      return trunkCapacity;
   }




   public void setTrunkCapacity(String trunkCapacity)
   {
      this.trunkCapacity = trunkCapacity;
   }




   public String isTrailerCoupling()
   {
      return trailerCoupling;
   }




   public void setTrailerCoupling(String trailerCoupling)
   {
      this.trailerCoupling = trailerCoupling;
   }




   public String isRoofStorage()
   {
      return roofStorage;
   }




   public void setRoofStorage(String roofStorage)
   {
      this.roofStorage = roofStorage;
   }


   /**
    * check if a car equal to the object and return boolen
    */
   public boolean equals(Object obj){
		if(!(obj instanceof FamilyCars))
			return false;
		
		else{
			FamilyCars other= (FamilyCars) obj;
			if(super.equals(other)&&numberOfDoors==other.numberOfDoors&&numberOfSeats==other.numberOfSeats&&childSeat==other.childSeat&&
					trunkCapacity.equals(other.trunkCapacity)&&trailerCoupling==other.trailerCoupling&&roofStorage==other.roofStorage)
				return true;
			else return false;
		}

		
		
}



}   
