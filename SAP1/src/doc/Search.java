package doc;

import java.io.Serializable;
import java.util.ArrayList;

import ui.SearchPage;
import ui.UserInterface;
import doc.*;
import doc.FamilyCars;
import doc.MovingTrucks;
import doc.Vans;
import doc.VehicleList;

public class Search implements Serializable
{
	private VehicleList vehicles;
	private SearchPage searchPage;

	private ArrayList<String> allFamilyCarStrings;
	private ArrayList<String> allVanCarStrings;
	private ArrayList<String> allMovingTruckCarStrings;
	private ArrayList<String> allAutoCamperCarStrings;
	
	private VehicleList newVehicleList;
	private BookingList bookingList;
	/**
	 * constructor to initiate the search
	 * @param vehicle list
	 * @param GUI searchPage
	 * @param bookingList
	 */
	public Search (SearchPage searchPage){
	   this.bookingList=UserInterface.getBookingList();
	   this.searchPage=searchPage;
	   this.vehicles=UserInterface.getVehicleList();
	   allFamilyCarStrings = new ArrayList<String>();
	   allVanCarStrings= new ArrayList<String>();
	   allMovingTruckCarStrings= new ArrayList<String>();
	   allAutoCamperCarStrings= new ArrayList<String>();
	   
	  
	   
	   //get all familycar Strings
	}
	   /**
	    * filter the vehicle list to the options chosen
	    * @return list of vehicles match the search options
	    */
	   public VehicleList searchFamily(){
	  
		   VehicleList tempVehicleList= new VehicleList();
	   tempVehicleList=vehicles;
	   int countTheAny=0;
	   for(int i=0; i<searchPage.getAllFamilyCarSpecs().size(); i++){
		   if(!(searchPage.getAllFamilyCarSpecs().get(i).getSelectedItem().equals("any"))){
		   newVehicleList= new VehicleList();
		   countTheAny++;
		   for(int pos=0; pos<tempVehicleList.size(); pos++){
			  
				   if(tempVehicleList.get(pos) instanceof FamilyCars){ 
					   allFamilyCarStrings.clear();
					   allFamilyCarStrings.add(tempVehicleList.get(pos).getMaker());
					   allFamilyCarStrings.add(tempVehicleList.get(pos).getModel());
					   allFamilyCarStrings.add(tempVehicleList.get(pos).getColor());
					   allFamilyCarStrings.add(tempVehicleList.get(pos).getTransmission());
					   allFamilyCarStrings.add(tempVehicleList.get(pos).getYear());
					   allFamilyCarStrings.add(tempVehicleList.get(pos).getEngineSize());
					   allFamilyCarStrings.add(tempVehicleList.get(pos).getFuelConsumption());
					   allFamilyCarStrings.add(tempVehicleList.get(pos).isNavigationSystem());
					   allFamilyCarStrings.add(tempVehicleList.get(pos).isCruiseControl());
					   allFamilyCarStrings.add(((FamilyCars) tempVehicleList.get(pos)).getNumberOfDoors());
					   allFamilyCarStrings.add(((FamilyCars) tempVehicleList.get(pos)).getNumberOfSeats());
					   allFamilyCarStrings.add(((FamilyCars) tempVehicleList.get(pos)).isChildSeat());
					   allFamilyCarStrings.add(((FamilyCars) tempVehicleList.get(pos)).getTrunkCapacity());
					   allFamilyCarStrings.add(((FamilyCars) tempVehicleList.get(pos)).isTrailerCoupling());
					   allFamilyCarStrings.add(((FamilyCars) tempVehicleList.get(pos)).isRoofStorage()); 	   
				   
			   
				if(searchPage.getAllFamilyCarSpecs().get(i).getSelectedItem().equals(allFamilyCarStrings.get(i))){
					  newVehicleList.add(tempVehicleList.get(pos));  
		   }
		   }}
		   tempVehicleList=newVehicleList;
	   }
	   }
		if(countTheAny!=0){
		return getVehiclesNotBooked(tempVehicleList);
		}
		else{
			VehicleList allCarsOfAKind= new VehicleList();
			for(int count=0; count<vehicles.size(); count++){
				if(vehicles.get(count) instanceof FamilyCars){
					allCarsOfAKind.add(vehicles.get(count));	
				}
			}
				
			return getVehiclesNotBooked(allCarsOfAKind);
		}
		}
	
	   
	   /**
       * filter the vehicle list to the options chosen
       * @return list of vehicles match the search options
       */
	   public VehicleList searchVan(){
		   VehicleList tempVehicleList= new VehicleList();	  
	   tempVehicleList= new VehicleList();
	   tempVehicleList=vehicles;
	   int countTheAny=0;
	   for(int i=0; i<searchPage.getAllVanCarSpecs().size(); i++){
		   if(!(searchPage.getAllVanCarSpecs().get(i).getSelectedItem().equals("any"))){
		   newVehicleList= new VehicleList();
		   countTheAny++;
		   for(int pos=0; pos<tempVehicleList.size(); pos++){
			   
				   if(tempVehicleList.get(pos) instanceof Vans){ 
					   allVanCarStrings.clear();
					   allVanCarStrings.add(tempVehicleList.get(pos).getMaker());
					   allVanCarStrings.add(tempVehicleList.get(pos).getModel());
					   allVanCarStrings.add(tempVehicleList.get(pos).getColor());
					   allVanCarStrings.add(tempVehicleList.get(pos).getTransmission());
					   allVanCarStrings.add(tempVehicleList.get(pos).getYear());
					   allVanCarStrings.add(tempVehicleList.get(pos).getEngineSize());
					   allVanCarStrings.add(tempVehicleList.get(pos).getFuelConsumption());
					   allVanCarStrings.add(tempVehicleList.get(pos).isNavigationSystem());
					   allVanCarStrings.add(tempVehicleList.get(pos).isCruiseControl());
					   allVanCarStrings.add(((Vans) tempVehicleList.get(pos)).getNumberOfDoors());
					   allVanCarStrings.add(((Vans) tempVehicleList.get(pos)).getNumberOfSeats());
					   allVanCarStrings.add(((Vans) tempVehicleList.get(pos)).getDriverLicense());
					   allVanCarStrings.add(((Vans) tempVehicleList.get(pos)).isRoofStorage());
					   allVanCarStrings.add(((Vans) tempVehicleList.get(pos)).getHorsePower());
					   allVanCarStrings.add(((Vans) tempVehicleList.get(pos)).getCargoSize());
					   allVanCarStrings.add(((Vans) tempVehicleList.get(pos)).getLoadCapacity()); 	   
				  
			   
				if(searchPage.getAllVanCarSpecs().get(i).getSelectedItem().equals(allVanCarStrings.get(i))){
					  newVehicleList.add(tempVehicleList.get(pos));  
		   }
		   }}
		   tempVehicleList=newVehicleList;
	   }
	   }
		if(countTheAny!=0){
			return getVehiclesNotBooked(tempVehicleList);
		}
		else{
			VehicleList allCarsOfAKind= new VehicleList();
			for(int count=0; count<vehicles.size(); count++){
				if(vehicles.get(count) instanceof Vans){
					allCarsOfAKind.add(vehicles.get(count));	
				}
			}
				
			return getVehiclesNotBooked(allCarsOfAKind);
		}
		}
	   
   
	
	   /**
       * filter the vehicle list to the options chosen
       * @return list of vehicles match the search options
       */
	   public VehicleList searchMovingTruck(){
		   VehicleList tempVehicleList= new VehicleList();	  
	   tempVehicleList= new VehicleList();
	   tempVehicleList=vehicles;
	   int countTheAny=0;
	   for(int i=0; i<searchPage.getAllMovingTruckCarSpecs().size(); i++){
		   if(!(searchPage.getAllMovingTruckCarSpecs().get(i).getSelectedItem().equals("any"))){
		   newVehicleList= new VehicleList();
		   countTheAny++;
		   for(int pos=0; pos<tempVehicleList.size(); pos++){
			   
				   if(tempVehicleList.get(pos) instanceof MovingTrucks){ 
					   allMovingTruckCarStrings.clear();
					   allMovingTruckCarStrings.add(tempVehicleList.get(pos).getMaker());
					   allMovingTruckCarStrings.add(tempVehicleList.get(pos).getModel());
					   allMovingTruckCarStrings.add(tempVehicleList.get(pos).getColor());
					   allMovingTruckCarStrings.add(tempVehicleList.get(pos).getTransmission());
					   allMovingTruckCarStrings.add(tempVehicleList.get(pos).getYear());
					   allMovingTruckCarStrings.add(tempVehicleList.get(pos).getEngineSize());
					   allMovingTruckCarStrings.add(tempVehicleList.get(pos).getFuelConsumption());
					   allMovingTruckCarStrings.add(tempVehicleList.get(pos).isNavigationSystem());
					   allMovingTruckCarStrings.add(tempVehicleList.get(pos).isCruiseControl());
					   allMovingTruckCarStrings.add(((MovingTrucks) tempVehicleList.get(pos)).getDriverLicense());
					   allMovingTruckCarStrings.add(((MovingTrucks) tempVehicleList.get(pos)).getHorsePower());
					   allMovingTruckCarStrings.add(((MovingTrucks) tempVehicleList.get(pos)).getCargoSize());
					   allMovingTruckCarStrings.add(((MovingTrucks) tempVehicleList.get(pos)).getLoadCapacity());
					   allMovingTruckCarStrings.add(((MovingTrucks) tempVehicleList.get(pos)).getExteriorDimensions());	   
				   
			   
				if(searchPage.getAllMovingTruckCarSpecs().get(i).getSelectedItem().equals(allMovingTruckCarStrings.get(i))){
					  newVehicleList.add(tempVehicleList.get(pos));  
		   }
		   }}
		   tempVehicleList=newVehicleList;
	   }
	   }
		if(countTheAny!=0){
		return getVehiclesNotBooked(tempVehicleList);
		}
		else{
			VehicleList allCarsOfAKind= new VehicleList();
			for(int count=0; count<vehicles.size(); count++){
				if(vehicles.get(count) instanceof MovingTrucks){
					allCarsOfAKind.add(vehicles.get(count));	
				}
			}
				
			return getVehiclesNotBooked(allCarsOfAKind);
		}
		}
   
	     
	   /**
       * filter the vehicle list to the options chosen
       * @return list of vehicles match the search options
       */
	   public VehicleList searchAutoCamper(){
		   VehicleList tempVehicleList= new VehicleList();	  
	   tempVehicleList= new VehicleList();
	   tempVehicleList=vehicles;
	   int countTheAny=0;
	   for(int i=0; i<searchPage.getAllAutoCamperCarSpecs().size(); i++){
		   if(!(searchPage.getAllAutoCamperCarSpecs().get(i).getSelectedItem().equals("any"))){
		   newVehicleList= new VehicleList();
		   countTheAny++;
		   for(int pos=0; pos<tempVehicleList.size(); pos++){
			   
				   if(tempVehicleList.get(pos) instanceof AutoCamper){ 
					   allAutoCamperCarStrings.clear();
					   allAutoCamperCarStrings.add(tempVehicleList.get(pos).getMaker());
					   allAutoCamperCarStrings.add(tempVehicleList.get(pos).getModel());
					   allAutoCamperCarStrings.add(tempVehicleList.get(pos).getColor());
					   allAutoCamperCarStrings.add(tempVehicleList.get(pos).getTransmission());
					   allAutoCamperCarStrings.add(tempVehicleList.get(pos).getEngineSize());
					   allAutoCamperCarStrings.add(tempVehicleList.get(pos).getFuelConsumption());
					   allAutoCamperCarStrings.add(tempVehicleList.get(pos).isNavigationSystem());
					   allAutoCamperCarStrings.add(tempVehicleList.get(pos).isCruiseControl());
					   allAutoCamperCarStrings.add(((AutoCamper) tempVehicleList.get(pos)).getNumberOfPeople());
					   allAutoCamperCarStrings.add(((AutoCamper) tempVehicleList.get(pos)).getSizeSpecifications());
					   allAutoCamperCarStrings.add(((AutoCamper) tempVehicleList.get(pos)).getDriverLicense());
					   allAutoCamperCarStrings.add(((AutoCamper) tempVehicleList.get(pos)).isRefrigerator());
					   allAutoCamperCarStrings.add(((AutoCamper) tempVehicleList.get(pos)).isTv());
					   allAutoCamperCarStrings.add(((AutoCamper) tempVehicleList.get(pos)).isHeatedWater()); 
					   allAutoCamperCarStrings.add(((AutoCamper) tempVehicleList.get(pos)).getBatterySize()); 
					   allAutoCamperCarStrings.add(((AutoCamper) tempVehicleList.get(pos)).getBatteryChatger()); 
					   allAutoCamperCarStrings.add(((AutoCamper) tempVehicleList.get(pos)).isGenerator()); 
					   allAutoCamperCarStrings.add(((AutoCamper) tempVehicleList.get(pos)).isBicycleStand()); 
					   allAutoCamperCarStrings.add(((AutoCamper) tempVehicleList.get(pos)).getNumberOfBeds()); 
					   allAutoCamperCarStrings.add(((AutoCamper) tempVehicleList.get(pos)).isMicrowave());
					   allAutoCamperCarStrings.add(((AutoCamper) tempVehicleList.get(pos)).isRoofHatch()); 	   
				   
			   
				if(searchPage.getAllAutoCamperCarSpecs().get(i).getSelectedItem().equals(allAutoCamperCarStrings.get(i))){
					  newVehicleList.add(tempVehicleList.get(pos));  
		   }
		   }}
		   tempVehicleList=newVehicleList;
	   }
	   }
		if(countTheAny!=0){
		return getVehiclesNotBooked(tempVehicleList);
		}
		else{
			VehicleList allCarsOfAKind= new VehicleList();
			for(int count=0; count<vehicles.size(); count++){
				if(vehicles.get(count) instanceof AutoCamper){
					allCarsOfAKind.add(vehicles.get(count));	
				}
			}
				
			return getVehiclesNotBooked(allCarsOfAKind);
		}
		}
	   
	  
	   /**
	    * filter down the search by dates
	    * check if the received list valid for being booked
	    * if a vehicle is booked it will not be in the list viewing 
	    * @param vehicles filtered by specs
	    * @return vehicles filtered by date
	    */
	   public VehicleList getVehiclesNotBooked(VehicleList vehicles){
		   
           
	         MyDate startDate;
	         MyDate endDate;
	         if(((String)searchPage.getComboStartYear().getSelectedItem()).equals("any")||
	               ((String)searchPage.getComboEndYear().getSelectedItem()).equals("any")){
	             startDate=MyDate.today();
	             endDate= MyDate.today();// show if or restrict the search
	            endDate.nextDay();
	         }
	         else{
	            
	          startDate=new MyDate(
	                Integer.parseInt((String)searchPage.getComboStartDay().getSelectedItem()),
	                Integer.parseInt((String)searchPage.getComboStartMonth().getSelectedItem()),
	                Integer.parseInt((String)searchPage.getComboStartYear().getSelectedItem()));
	          endDate=new MyDate(
	                Integer.parseInt((String)searchPage.getComboEndDay().getSelectedItem()),
	                Integer.parseInt((String)searchPage.getComboEndMonth().getSelectedItem()),
	                Integer.parseInt((String)searchPage.getComboEndYear().getSelectedItem()));
	            
	         }
		    
		   
		   VehicleList vehiclesNotBooked=new VehicleList();
		   
		   for(int i=0;i<vehicles.size();i++){
		      
		      boolean flag=true;
		      for(int j=0;j<bookingList.size();j++){

		         if(bookingList.get(j).getVehicle()!=null&&vehicles.get(i)!=null)
		         if(bookingList.get(j).getVehicle().equals(vehicles.get(i))){
	   	         if(bookingList.get(j).isBooked(startDate, endDate)){
	   	           flag=false;
	   	           
	   	            
	   	         }
		         }
		         
		      }
	   	      if(flag){
	   	         vehiclesNotBooked.add(vehicles.get(i));
	   	      }else{
	   	         
	   	      }
		      
		      
		   }
		   System.out.println("VEHICLES START: " +vehicles.size());
		   System.out.println("VEHICLES END: " +vehiclesNotBooked.size());
		   return vehiclesNotBooked;
		   
		}
	   
	   
	   
	   
}
		   
		
