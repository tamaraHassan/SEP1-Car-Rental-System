package doc;

import java.io.Serializable;
import java.util.ArrayList;

import ui.UserInterface;
/**
 * 
 * Regarding maintaining a vehicle and resetting remaining KM
 *
 */
public class VehicleMaintenance implements Serializable
{

	/**
	 * constructor to initiate the VehicleMaintenance
	 * @param vehicle list
	 */
	
	/**
	 *list in ascending order of remaining KM to service

	 * @return list in ascending order 
	 */
	public static VehicleList orderListByKilometers()
	   
	 
	 {	
		  VehicleList vehicles=UserInterface.getVehicleList();
	      VehicleList vehicleshelper=new VehicleList();
	      for(int p=0;p<vehicles.size();p++){
	         vehicleshelper.add(vehicles.get(p));
	      }
	      VehicleList orderListByKilometers= new  VehicleList();
	      int index=-1;
	      int lowest;
	   for(int j=0;j<vehicles.size();j++)
	   {
	      lowest = Integer.parseInt(vehicleshelper.get(0).getRemainingKm());
	   for (int i = 0; i < vehicleshelper.size(); i++)
	   {
		  
	   if (Integer.parseInt(vehicleshelper.get(i).getRemainingKm()) < lowest)
	   {
	      index=i;
	   lowest = (Integer.parseInt(vehicleshelper.get(i).getRemainingKm()));
	   
	   }
	   }
	   
	   orderListByKilometers.add(vehicleshelper.get(index));
	   if(vehicleshelper.size()>1){
	   vehicleshelper.removeVehicle(index);
	   index=0;
	   }
	   }
	   return orderListByKilometers;
}
		
		
	 }
	
	
	
	

	