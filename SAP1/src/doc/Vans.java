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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;



import ui.AddBookingPage;
import ui.ManageVehicle;
import ui.UserInterface;
import ui.VehicleMaintenancePage;


/**
 * 
 * Create a Van
 *
 */

public class Vans extends Vehicle implements Serializable {

	private String driverLicense, cargoSize;
	private String numberOfSeats, numberOfDoors, price;
	private String loadCapacity;
	private String roofStorage;
	private VehicleActionListener listener;//****NEW
	
	
	//constructor
	public String getDriverLicense() {
		return driverLicense;
	}
	/**
	 * constructor to initialize the the Van
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
	 * @param price
	 * @param driverLicense
	 * @param cargoSize
	 * @param numberOfSeats
	 * @param numberOfDoors
	 * @param loadCapacity
	 * @param roofStorage
	 */
	public Vans(String regNo, String color, String vehicleStatus, String model,
			String maker, String transmission, String numberOfKm, String year,
			String horsePower, String remainingKm,
			String engineSize, String fuelConsumption,
			String navigationSystem, String cruiseControl, String price,
			String driverLicense, String cargoSize, String numberOfSeats,
			String numberOfDoors, String loadCapacity,
			String roofStorage) {
		super(regNo, color, vehicleStatus, model, maker, transmission,
				numberOfKm, year, horsePower, remainingKm, engineSize, fuelConsumption,
				navigationSystem, cruiseControl, price);
		this.driverLicense = driverLicense;
		this.cargoSize = cargoSize;
		this.numberOfSeats = numberOfSeats;
		this.numberOfDoors = numberOfDoors;
		this.loadCapacity = loadCapacity;
		this.roofStorage = roofStorage;
		 UIManager UI=new UIManager();
		   UI.put("OptionPane.background",new ColorUIResource(255, 228, 181));
		   UI.put("Panel.background",new ColorUIResource(255, 255, 255));
	}
	
	@Override
	/**
	 * JPanel with view and reserve buttons
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
	 * JPanel with view and remove button
	 */
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
       listener=new VehicleActionListener(UserInterface.getVehicleList(), this,  buttonRemove);
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
	 //--------------
	 
	 
	 //PANEL WITH SERVICE BUTTON 
	   @Override
	   /**
	    * JPanel with service and view buttons
	    */
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
	    * creating the car view
	    * @return JPanel to view car details
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
			carDescription.add(new JLabel("Kilometers: "));
			carDescription.add(new JLabel(super.getNumberOfKm())).setFont(font);
			carDescription.add(new JLabel("Hp: "));
			carDescription.add(new JLabel(super.getHorsePower())).setFont(font);
			carDescription.add(new JLabel("License: "));
			carDescription.add(new JLabel(driverLicense)).setFont(font);
			carDescription.add(new JLabel("Seats: "));
			carDescription.add(new JLabel(numberOfSeats)).setFont(font);
			carDescription.add(new JLabel("Cargo size: "));
			carDescription.add(new JLabel(cargoSize)).setFont(font);
			carDescription.add(new JLabel("Doors: "));
			carDescription.add(new JLabel(numberOfDoors)).setFont(font);
			carDescription.add(new JLabel("Load cap.: "));
			carDescription.add(new JLabel(loadCapacity)).setFont(font);
			carDescription.add(new JLabel("Roof storage: "));
			carDescription.add(new JLabel(roofStorage)).setFont(font);



			return eachCarPanel;
		}


	   
	   private class ShowCarDetails implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null,constructCarView(),"Car Information",JOptionPane.PLAIN_MESSAGE);
			}
	}
	   
	   
	   
	 //RESERVE PAGE COMPONENTS

	   
	   //SERVICE RES PAGE COMPONENTS
	   /**
	    * resetting the km to 20.000 and pop up success message
	    */
	   public void addServicePanelCalling(){
	      super.setRemainingKm("20000");
	      JOptionPane.showMessageDialog(null,"Maintenance done, km were reseted to 20.000.","Reset kilometers",JOptionPane.PLAIN_MESSAGE);
	      VehicleMaintenancePage.showVehiclesByRemKm();
	   }
	   
	   
	   private class addServiceReservation implements ActionListener{
	      public void actionPerformed(ActionEvent e){
	    	  addServicePanelCalling();
	   
	      }
	}
	 //SERVICE RES PAGE COMPONENTS   
	   
	   
	
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
	
	
	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}
	public String getCargoSize() {
		return cargoSize;
	}
	public void setCargoSize(String cargoSize) {
		this.cargoSize = cargoSize;
	}
	public String getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(String numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public String getNumberOfDoors() {
		return numberOfDoors;
	}
	public void setNumberOfDoors(String numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}
	public String getPriceCategory() {
		return price;
	}
	public void setPriceCategory(String price) {
		this.price = price;
	}
	public String getLoadCapacity() {
		return loadCapacity;
	}
	public void setLoadCapacity(String loadCapacity) {
		this.loadCapacity = loadCapacity;
	}
	public String isRoofStorage() {
		return roofStorage;
	}
	public void setRoofStorage(String roofStorage) {
		this.roofStorage = roofStorage;
	}
	
	/**
	 * check if obj is equal and returning boolean
	 */
	public boolean equals(Object obj){
		if(!(obj instanceof Vans))
			return false;
		
		else{
			Vans other= (Vans) obj;
			if(super.equals(other)&&driverLicense.equals(other.driverLicense)&&cargoSize.equals(other.cargoSize)&&
					numberOfSeats==other.numberOfSeats&&numberOfDoors==other.numberOfDoors&&price==other.price&&loadCapacity==other.loadCapacity&&
					roofStorage==other.roofStorage)
				return true;
			else return false;
		}
	}	
	
}
