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
import javax.swing.JScrollPane;
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
 * Class to Create autoCamper 
 *
 */
public class AutoCamper extends Vehicle implements Serializable 
{
   private String numberOfPeople;
   private String sizeSpecifications;
   private String driverLicense;
   private String refrigerator;
   private String tv;
   private String heatedWater;
   private String batterySize;
   private String batteryChatger;
   private String generator;
   private String bicycleStand;
   private String numberOfBeds;
   private String microwave;
   private String roofHatch;
   private String roofStorage;
   private VehicleActionListener listener;//****NEW
   
   
   
   /**
    * Constructor to initialize the autoCamper
    * @param regNo :Vehicle Registration Number
    * @param color: Color
    * @param vehicleStatus: the status of the vehicle
    * @param model: Vehicle model
    * @param maker: Vehicle maker
    * @param transmission: Vehicle transmission( auto/manual)
    * @param numberOfKm: (the number on the dash board of driven KM)
    * @param year : Year of Make
    * @param horsePower: vehicle horse Power HK
    * @param remainingKm: the remaining KM out of 20.000 to the Maintenance 
    * @param engineSize: Engine size ex.1.6 
    * @param fuelConsumption : fuel Consumption
    * @param navigationSystem: navigation system (yes/no)
    * @param cruiseControl: cruise Control (yes/no)
    * @param numberOfPeople: number of people fit in a vehicle
    * @param sizeSpecifications : vehicle dimensions 
    * @param driverLicense: the type of the driving license required for the vehicle
    * @param refrigerator : refrigerator (yes/no)
    * @param tv: tv (yes/no)
    * @param heatedWater: heated Water (yes/no)
    * @param batterySize: battery Size
    * @param batteryChatger: battery Charger (yes/no)
    * @param generator: generator (yes/no)
    * @param bicycleStand: bicycle Stand (yes/no)
    * @param numberOfBeds: number Of Beds
    * @param microwave: microwave (yes/no)
    * @param roofHatch: roofHatch (yes/no)
    * @param roofStorage: roof Storage (yes/no)
    * @param price: daily renting cost
    */
   public AutoCamper(String regNo, String color, String vehicleStatus,
         String model, String maker, String transmission, String numberOfKm,
         String year, String horsePower,
         String remainingKm, String engineSize, String fuelConsumption,
         String navigationSystem, String cruiseControl, String numberOfPeople,
         String sizeSpecifications, String driverLicense, String refrigerator,
         String tv, String heatedWater, String batterySize,
         String batteryChatger, String generator, String bicycleStand,
         String numberOfBeds, String microwave, String roofHatch,
         String roofStorage,String price)
   {
      super(regNo, color, vehicleStatus, model, maker, transmission,
            numberOfKm, year, horsePower, remainingKm, engineSize, fuelConsumption,
            navigationSystem, cruiseControl,price);
      this.numberOfPeople = numberOfPeople;
      this.sizeSpecifications = sizeSpecifications;
      this.driverLicense = driverLicense;
      this.refrigerator = refrigerator;
      this.tv = tv;
      this.heatedWater = heatedWater;
      this.batterySize = batterySize;
      this.batteryChatger = batteryChatger;
      this.generator = generator;
      this.bicycleStand = bicycleStand;
      this.numberOfBeds = numberOfBeds;
      this.microwave = microwave;
      this.roofHatch = roofHatch;
      this.roofStorage = roofStorage;
      
      UIManager UI=new UIManager();
	   UI.put("OptionPane.background",new ColorUIResource(255, 228, 181));
	   UI.put("Panel.background",new ColorUIResource(255, 255, 255));
   }
   @Override
   /**
    * JPanel to get the vehicle with view and reserve buttons
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
    * JPanel to get a Vehicle with view and remoce buttons
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
//-----------------
   
   
   //PANEL WITH SERVICE BUTTON 
   @Override
   /**
    * JPanel to get vehicle with view and reset KM panel
    */
   public JPanel getVehicleWithServicePanel() {
	    JPanel car= new JPanel(new GridLayout(1,3,0,0));
		car.setBorder(new EmptyBorder(10,10,20,10));
		JPanel carDetailsText= new JPanel(new GridLayout(2,1,0,0));
		JPanel carButtons= new JPanel(new GridLayout(1,2,10,10));
		JLabel carDetailRow1= new JLabel("Maker: "+super.getMaker()+", Model: "+super.getModel()+",  Reg. no: "+super.getRegNo()+", Year: "+super.getYear()+", ");
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
    * 
    * @return JPanel with all the details of the vehicle
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
		carDescription.setBorder(new EmptyBorder(30,110,30,110));
		eachCarPanel.setLayout(new BorderLayout());
		eachCarPanel.add(carTitle,BorderLayout.NORTH);
		JScrollPane scrollPane= new JScrollPane(carDescription,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(450,600));
		eachCarPanel.add(scrollPane,BorderLayout.CENTER);
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
		carDescription.add(new JLabel("Nr. people: "));
		carDescription.add(new JLabel(numberOfPeople)).setFont(font);
		carDescription.add(new JLabel("Car size: "));
		carDescription.add(new JLabel(sizeSpecifications)).setFont(font);
		carDescription.add(new JLabel("License: "));
		carDescription.add(new JLabel(driverLicense)).setFont(font);
		carDescription.add(new JLabel("Refrigerator: "));
		carDescription.add(new JLabel(refrigerator)).setFont(font);
		carDescription.add(new JLabel("Television: "));
		carDescription.add(new JLabel(tv)).setFont(font);
		carDescription.add(new JLabel("Heated water: "));
		carDescription.add(new JLabel(heatedWater)).setFont(font);
		carDescription.add(new JLabel("Battery size: "));
		carDescription.add(new JLabel(batterySize)).setFont(font);
		carDescription.add(new JLabel("Charger type: "));
		carDescription.add(new JLabel(batteryChatger)).setFont(font);
		carDescription.add(new JLabel("Generator: "));
		carDescription.add(new JLabel(generator)).setFont(font);
		carDescription.add(new JLabel("Bicicle stand: "));
		carDescription.add(new JLabel(bicycleStand)).setFont(font);
		carDescription.add(new JLabel("Nr. of beds: "));
		carDescription.add(new JLabel(numberOfBeds)).setFont(font);
		carDescription.add(new JLabel("Microwave oven: "));
		carDescription.add(new JLabel(microwave)).setFont(font);
		carDescription.add(new JLabel("Roof hatch: "));
		carDescription.add(new JLabel(roofHatch)).setFont(font);
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
    * resetting the KM to 20,000 and show success message
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
   
   public String getNumberOfPeople()
   {
      return numberOfPeople;
   }




   public void setNumberOfPeople(String numberOfPeople)
   {
      this.numberOfPeople = numberOfPeople;
   }




   public String getSizeSpecifications()
   {
      return sizeSpecifications;
   }




   public void setSizeSpecifications(String sizeSpecifications)
   {
      this.sizeSpecifications = sizeSpecifications;
   }




   public String getDriverLicense()
   {
      return driverLicense;
   }




   public void setDriverLicense(String driverLicense)
   {
      this.driverLicense = driverLicense;
   }




   public String isRefrigerator()
   {
      return refrigerator;
   }




   public void setRefrigerator(String refrigerator)
   {
      this.refrigerator = refrigerator;
   }




   public String isTv()
   {
      return tv;
   }




   public void setTv(String tv)
   {
      this.tv = tv;
   }




   public String isHeatedWater()
   {
      return heatedWater;
   }




   public void setHeatedWater(String heatedWater)
   {
      this.heatedWater = heatedWater;
   }




   public String getBatterySize()
   {
      return batterySize;
   }




   public void setBatterySize(String batterySize)
   {
      this.batterySize = batterySize;
   }




   public String getBatteryChatger()
   {
      return batteryChatger;
   }




   public void setBatteryChatger(String batteryChatger)
   {
      this.batteryChatger = batteryChatger;
   }




   public String isGenerator()
   {
      return generator;
   }




   public void setGenerator(String generator)
   {
      this.generator = generator;
   }




   public String isBicycleStand()
   {
      return bicycleStand;
   }




   public void setBicycleStand(String bicycleStand)
   {
      this.bicycleStand = bicycleStand;
   }




   public String getNumberOfBeds()
   {
      return numberOfBeds;
   }




   public void setNumberOfBeds(String numberOfBeds)
   {
      this.numberOfBeds = numberOfBeds;
   }




   public String isMicrowave()
   {
      return microwave;
   }




   public void setMicrowave(String microwave)
   {
      this.microwave = microwave;
   }




   public String isRoofHatch()
   {
      return roofHatch;
   }




   public void setRoofHatch(String roofHatch)
   {
      this.roofHatch = roofHatch;
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
    * check if two vehicles are equals 
    * take an object and it should me autoCamper
    */
   public boolean equals(Object obj){
		if(!(obj instanceof AutoCamper))
			return false;
		
		else{
			AutoCamper other= (AutoCamper) obj;
			if(super.equals(other)&&numberOfPeople==other.numberOfPeople&&sizeSpecifications.equals(other.sizeSpecifications)&&
					driverLicense.equals(other.driverLicense)&&refrigerator==other.refrigerator&&tv==other.tv&&heatedWater==other.heatedWater&&
					batterySize.equals(other.batterySize)&&batteryChatger.equals(other.batteryChatger)&&generator==other.generator&&
					bicycleStand==other.bicycleStand&&numberOfBeds==other.numberOfBeds&&microwave==other.microwave&&roofHatch==other.roofHatch&&
					roofStorage==other.roofStorage)
				return true;
			else return false;
		}
	}	
   

}
