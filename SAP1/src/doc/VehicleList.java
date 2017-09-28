package doc;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * Creating Vehicle list
 *
 */
public class VehicleList implements Serializable
{
	ArrayList<Vehicle> vehicles;
	/**
	 * Constructor to create a vehicleList
	 */
	public VehicleList()
	{
		vehicles = new ArrayList<Vehicle>();
	}
	/**
	 * size of vehicle list
	 * @return number of vehicles in list
	 */
	public int size()
   {
      return vehicles.size();
   }
   

	/**
	 * 
	 * @param regNumber of vehicle
	 * @return the index of the vehicle at that reg num
	 */
   public int indexOfRegNumber(String regNumber)
   {
      for(int i = 0; i<vehicles.size(); i++)
      {
         Vehicle temp = vehicles.get(i);
         
         if(temp.getRegNo().equals(regNumber))
         {
            return i;
         }
      }  
      return -1;
   }
   /**
    * 
    * @param index of the wanted vehicle
    * @return vehicle at that index
    */
   public Vehicle get(int index)
   {
      if(index<vehicles.size())
      {
         return vehicles.get(index);
      }
      else
      {
         return null;
      }
   }
   /**
    * get vehilce by registeration number
    * @param regNumber of vehicle
    * @return vehicle that has this RegNo
    */
   public Vehicle getVehiclesByRegNo(String regNumber)
   {
     
         try {
			return vehicles.get(indexOfRegNumber(regNumber));
		} catch (Exception e) {
			return null;
		}
         
   }
   /**
    * Add a vehicle to the list
    * @param vehicle to be added
    */
   public void add(Vehicle car)
   {
     
         vehicles.add(car);
      
   }
   /**
    * display some info about the car
    */
   public String toString()
   {
      String returnStr = "";
   
      for(int i = 0; i<vehicles.size(); i++)
      {     
         returnStr += vehicles.get(i).getMaker()+" "+vehicles.get(i).getModel()+" "+
               vehicles.get(i).getColor()+" "+vehicles.get(i).getYear()+"\n";
      }  
      return returnStr;
   }
	//**********
	/**
	 * adding a vehicle to the list
	 * @param vehicle
	 */
	public void addVehicle(Vehicle vehicle)//can be deleted
	{
		vehicles.add(vehicle);
	}
	/**
	 * remove a vehicle from the list
	 * @param vehicle
	 */
	public void removeVehicle(Vehicle vehicle)
	{
		vehicles.remove(vehicle);
	}	
	/**
	 * remove a vehicle at that index
	 * @param index
	 */
	public void removeVehicle(int index)
	{
		vehicles.remove(index);
	}	
	/**
	 *  gets all the vehicle
	 * @return ArrayList of Vehicles
	 */
	public ArrayList<Vehicle> getAllVehicles(){
		return vehicles;
	}
	/**
	 * add vehicle at that index
	 * @param index
	 * @param vehicle
	 */
	public void addVehicle(int index, Vehicle vehicle)
	{
		vehicles.add(index, vehicle);
	}
	
	
	
	
}
