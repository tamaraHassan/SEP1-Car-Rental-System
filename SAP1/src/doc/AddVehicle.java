package doc;
import java.awt.Color;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import ui.*;
/**
 * Add a vehicle to the vehicle list after validation
 */
public class AddVehicle implements Serializable
{

	
	//Strings
	private String regNo;
	private String color;
	private String model;
	private String maker;
	private String transmission;
	private String sizeSpecifications;
	private String driverLicense;
	private String batterySize;
	private String batteryCharger;
	private String trunkCapacity;
	private String exteriorDimensions;
	private String cargoSize;
	
	//ints
	private String numberOfPeople;
	private String numberOfBeds;
	private String numberOfKm;
	private String year;
	private String horsePower;
	private String remainingKm;
	private String numberOfDoors;
	private String numberOfSeats;
	
	//doubles
	private String engineSize;
	private String fuelConsumption;
	private String price;
	private String loadCapacity;
	
	//booleans
	private String navigationSystem;
	private String cruiseControl;
	private String refrigerator;
	private String tv;
	private String heatedWater;
	private String generator;
	private String bicycleStand;
	private String microwave;
	private String roofHatch;
	private String roofStorage;
	private String childSeat;
	private String trailerCoupling;

	//GUI ADD VEHICLE PAGE
	AddVehiclePage addVehiclePage;
	
	//temp
	private int tempInt;
	private double tempDouble;
	private boolean tempBoolean;
	
	//associations
	
	/**
	 * Adding vehicle to the List
	 * @param addVehiclePage the GUI
	 * @param vehicleList the list of vehicles
	 */
	public AddVehicle(AddVehiclePage addVehiclePage)
	{
		this.addVehiclePage = addVehiclePage;
		
		//Strings
		regNo = addVehiclePage.getRegNoField().getText();
		color = addVehiclePage.getColorField().getText();
		model = addVehiclePage.getModelField().getText();
		maker = addVehiclePage.getMakerField().getText();
		sizeSpecifications = addVehiclePage.getSizeSpecificationsField().getText();
		driverLicense = addVehiclePage.getDriverLicenseField().getText();
		batterySize = addVehiclePage.getBatterySizeField().getText();
		batteryCharger = addVehiclePage.getBatteryChargerField().getText();
		trunkCapacity = addVehiclePage.getTrunkCapacityField().getText();
		exteriorDimensions = addVehiclePage.getExteriorDimensionsField().getText();
		cargoSize = addVehiclePage.getCargoSizeField().getText();
		
		//ints
		numberOfPeople = addVehiclePage.getNumberOfPeopleField().getText();
		numberOfBeds = addVehiclePage.getNumberOfBedsField().getText();
		numberOfKm = addVehiclePage.getNumberOfKmField().getText();
		year = addVehiclePage.getYearField().getText();
		horsePower = addVehiclePage.getHorsePowerField().getText();
		remainingKm = addVehiclePage.getMaintenanceRemainingKmField().getText();
		numberOfDoors = addVehiclePage.getNumberOfDoorsField().getText();
		numberOfSeats = addVehiclePage.getNumberOfSeatsField().getText();
		
		//doubles
		engineSize = addVehiclePage.getEngineSizeField().getText();
		fuelConsumption = addVehiclePage.getFuelConsumptionField().getText();
		price = addVehiclePage.getPriceField().getText();
		loadCapacity = addVehiclePage.getLoadCapacityField().getText();
		
		//booleans
		this.transmission = (String) addVehiclePage.getTransmissionCombo().getSelectedItem();
		this.navigationSystem = (String) addVehiclePage.getNavigationSystemCombo().getSelectedItem();
		this.cruiseControl = (String) addVehiclePage.getCruiseControlCombo().getSelectedItem();
		this.refrigerator = (String) addVehiclePage.getRefrigeratorCombo().getSelectedItem();
		this.tv = (String) addVehiclePage.getTvCombo().getSelectedItem();
		this.heatedWater = (String) addVehiclePage.getHeatedWaterCombo().getSelectedItem();
		this.generator = (String) addVehiclePage.getGeneratorCombo().getSelectedItem();
		this.bicycleStand = (String) addVehiclePage.getBicycleStandCombo().getSelectedItem();
		this.microwave = (String) addVehiclePage.getMicrowaveCombo().getSelectedItem();
		this.roofHatch = (String) addVehiclePage.getRoofHatchCombo().getSelectedItem();
		this.roofStorage = (String) addVehiclePage.getRoofStorageCombo().getSelectedItem();
		this.childSeat = (String) addVehiclePage.getChildSeatCombo().getSelectedItem();
		this.trailerCoupling = (String) addVehiclePage.getTrailerCouplingCombo().getSelectedItem();
		
		
		addVehicleToList();
	}
	/**
	 * Validate the fields and if any empty then sets label to red
	 * @return number of errors
	 */
	public int checkEmptyStrings()
	{
		int stringErrors = 0;
		
		if(addVehiclePage.getRegNoField().getText().equals(""))
		{
			addVehiclePage.getRegNoLabel().setForeground(Color.red);
			stringErrors++;
		}
		if(addVehiclePage.getColorField().getText().equals(""))
		{
			addVehiclePage.getColorLabel().setForeground(Color.red);
			stringErrors++;
		}
		if(addVehiclePage.getModelField().getText().equals(""))
		{
			addVehiclePage.getModelLabel().setForeground(Color.red);
			stringErrors++;
		}
		if(addVehiclePage.getMakerField().getText().equals(""))
		{
			addVehiclePage.getMakerLabel().setForeground(Color.red);
			stringErrors++;
		}
		if(addVehiclePage.getRdbtnAutoCamper().isSelected() || addVehiclePage.getRdbtnMovingTruck().isSelected() || 
				addVehiclePage.getRdbtnVan().isSelected())
		{
			if(addVehiclePage.getDriverLicenseField().getText().equals(""))
			{
				addVehiclePage.getDriverLicenseLabel().setForeground(Color.red);
				stringErrors++;
			}
		}
		if(addVehiclePage.getRdbtnAutoCamper().isSelected())
		{
			if(addVehiclePage.getSizeSpecificationsField().getText().equals(""))
			{
				addVehiclePage.getSizeSpecificationsLabel().setForeground(Color.red);
				stringErrors++;
			}
		}
		if(addVehiclePage.getRdbtnMovingTruck().isSelected())
		{
			if(addVehiclePage.getExteriorDimensionsField().getText().equals(""))
			{
				addVehiclePage.getExteriorDimensionsLabel().setForeground(Color.red);
				stringErrors++;
			}
		}
		if(addVehiclePage.getRdbtnMovingTruck().isSelected() || addVehiclePage.getRdbtnVan().isSelected())
		{
			if(addVehiclePage.getCargoSizeField().getText().equals(""))
			{
				addVehiclePage.getCargoSizeLabel().setForeground(Color.red);
				stringErrors++;
			}
		}
		return stringErrors;
	}
	/**
    * Check if the field is empty if yes, it change label to red
    * if not, Parse the field that needs calculation to int
    * exceptions if there is error with parsing that mean the field didn't get a number
    * @return the number of errors
    */
	public int parseToInt()
	{
		int intErrors = 0;
		if(numberOfKm.equals(""))
		{
			addVehiclePage.getNumberOfKmLabel().setForeground(Color.red);
			intErrors++;
		}
		else
		{
			try
			{
				tempInt = Integer.parseInt(numberOfKm);
			}
			catch (NumberFormatException e)
			{
				addVehiclePage.getNumberOfKmField().setText("");
				addVehiclePage.getNumberOfKmLabel().setForeground(Color.red);
				intErrors++;
			}
		}
		if(year.equals(""))
		{
			addVehiclePage.getYearLabel().setForeground(Color.red);
			intErrors++;
		}
		else
		{
			try
			{
				tempInt = Integer.parseInt(year);
			}
			catch (NumberFormatException e)
			{
				addVehiclePage.getYearField().setText("");
				addVehiclePage.getYearLabel().setForeground(Color.red);
				intErrors++;
			}
		}
		
		if(horsePower.equals(""))
		{
			addVehiclePage.getHorsePowerLabel().setForeground(Color.red);
			intErrors++;
		}
		else
		{
			try
			{
				tempInt = Integer.parseInt(horsePower);
			}
			catch (NumberFormatException e)
			{
				addVehiclePage.getHorsePowerField().setText("");
				addVehiclePage.getHorsePowerLabel().setForeground(Color.red);
				intErrors++;
			}
		}
		
		if(addVehiclePage.getRdbtnAutoCamper().isSelected())
		{
			if(numberOfPeople.equals(""))
			{
				addVehiclePage.getNumberOfPeopleLabel().setForeground(Color.red);
				intErrors++;
			}
			else
			{
				try
				{
					tempInt = Integer.parseInt(numberOfPeople);
				}
				catch (NumberFormatException e)
				{
					addVehiclePage.getNumberOfPeopleField().setText("");
					addVehiclePage.getNumberOfPeopleLabel().setForeground(Color.red);
					intErrors++;
				}
			}
			if(numberOfBeds.equals(""))
			{
				addVehiclePage.getNumberOfBedsLabel().setForeground(Color.red);
				intErrors++;
			}
			else
			{
				try
				{
					tempInt = Integer.parseInt(numberOfBeds);
				}
				catch (NumberFormatException e)
				{
					addVehiclePage.getNumberOfBedsField().setText("");
					addVehiclePage.getNumberOfBedsLabel().setForeground(Color.red);
					intErrors++;
				}
			}
		}
		
		if(addVehiclePage.getRdbtnFamilyCar().isSelected() || addVehiclePage.getRdbtnVan().isSelected())
		{
			if(numberOfDoors.equals(""))
			{
				addVehiclePage.getNumberOfDoorsLabel().setForeground(Color.red);
				intErrors++;
				System.out.println("DOORS");
			}
			else
			{
				try
				{
					tempInt = Integer.parseInt(numberOfDoors);
				}
				catch (NumberFormatException e)
				{
					addVehiclePage.getNumberOfDoorsField().setText("");
					addVehiclePage.getNumberOfDoorsLabel().setForeground(Color.red);
					intErrors++;
				}
			}
			if(numberOfSeats.equals(""))
			{
				addVehiclePage.getNumberOfSeatsLabel().setForeground(Color.red);
				intErrors++;
			}
			else
			{
				try
				{
					tempInt = Integer.parseInt(numberOfSeats);
				}
				catch (NumberFormatException e)
				{
					addVehiclePage.getNumberOfSeatsField().setText("");
					addVehiclePage.getNumberOfSeatsLabel().setForeground(Color.red);
					intErrors++;
				}	
			}	
		}
		System.out.println("TOTAL ERRORS: " + intErrors);
		return intErrors;
	}
	/**
	 * Check if the field is empty if yes, it change label to red
	 * if not, Parse the field that needs calculation to double
	 * exceptions if there is error with parsing that mean the field didn't get number
	 * @return the number of errors
	 */
	public int parseToDouble()
	{
		int doubleErrors = 0;
		
		if(addVehiclePage.getRdbtnAutoCamper().isSelected())
		{
			if(batterySize.equals(""))
			{
				addVehiclePage.getBatterySizeLabel().setForeground(Color.red);
				doubleErrors++;
			}
			else
			{
				try
				{
					tempDouble = Double.parseDouble(batterySize);
				}
				catch(NumberFormatException e)
				{
					addVehiclePage.getBatterySizeField().setText("");
					addVehiclePage.getBatterySizeLabel().setForeground(Color.red);
					doubleErrors++;
				}
			}
			if(batteryCharger.equals(""))
			{
				addVehiclePage.getBatteryChargerLabel().setForeground(Color.red);
				doubleErrors++;
			}
			else
			{
				try
				{
					tempDouble = Double.parseDouble(batteryCharger);
				}
				catch (NumberFormatException e)
				{
					addVehiclePage.getBatteryChargerField().setText("");
					addVehiclePage.getBatteryChargerLabel().setForeground(Color.red);
					doubleErrors++;
				}
			}
		}
		
		if(engineSize.equals(""))
		{
			addVehiclePage.getEngineSizeLabel().setForeground(Color.red);
			doubleErrors++;
			System.out.println("ENGINE SIZE");
		}
		else
		{
			try
			{
				tempDouble = Double.parseDouble(engineSize);
			}
			catch (NumberFormatException e)
			{
				addVehiclePage.getEngineSizeField().setText("");
				addVehiclePage.getEngineSizeLabel().setForeground(Color.red);
				doubleErrors++;
				System.out.println("ENGINE SIZE CATCH");
			}
		}
		
		
		if(fuelConsumption.equals(""))
		{
			addVehiclePage.getFuelConsumptionLabel().setForeground(Color.red);
			doubleErrors++;
		}
		else
		{
			try
			{
				tempDouble = Double.parseDouble(fuelConsumption);
			}
			catch (NumberFormatException e)
			{
				addVehiclePage.getFuelConsumptionField().setText("");
				addVehiclePage.getFuelConsumptionLabel().setForeground(Color.red);
				doubleErrors++;
			}
		}
		
		if(price.equals(""))
		{
			addVehiclePage.getPriceLabel().setForeground(Color.red);
			doubleErrors++;
			System.out.println("PRICE");
		}
		else
		{
			try
			{
				tempDouble = Double.parseDouble(price);
			}
			catch (NumberFormatException e)
			{
				addVehiclePage.getPriceField().setText("");
				addVehiclePage.getPriceLabel().setForeground(Color.red);
				doubleErrors++;
				System.out.println("PRICE CATCH");
			}
		}
		
		if(addVehiclePage.getRdbtnFamilyCar().isSelected())
		{
			if(trunkCapacity.equals(""))
			{
				addVehiclePage.getTrunkCapacityLabel().setForeground(Color.red);
				doubleErrors++;
				System.out.println("TRUNK CAPACITY");
			}
			else
			{
				try
				{
					tempDouble = Double.parseDouble(trunkCapacity);
				}
				catch (NumberFormatException e)
				{
					addVehiclePage.getTrunkCapacityField().setText("");
					addVehiclePage.getTrunkCapacityLabel().setForeground(Color.red);
					doubleErrors++;
					System.out.println("TRUNK CAPACITY CATCH");
				}		
			}
		}
		if(addVehiclePage.getRdbtnMovingTruck().isSelected() || addVehiclePage.getRdbtnVan().isSelected())
		{
			if(loadCapacity.equals(""))
			{
				addVehiclePage.getEngineSizeLabel().setForeground(Color.red);
				doubleErrors++;
				System.out.println("LOAD CAPACITY");
			}
			else
			{
				try
				{
					tempDouble = Double.parseDouble(loadCapacity);
				}
				catch (NumberFormatException e)
				{
					addVehiclePage.getLoadCapacityField().setText("");
					addVehiclePage.getLoadCapacityLabel().setForeground(Color.red);
					doubleErrors++;
					System.out.println("LOAD CAPACITY CATCH");
				}
			}
		}
		return doubleErrors;
	}
	/**
    * 
    * Parse the field to boolean 
    * 
    * @return the number of errors
    */
	public int parseToBoolean()
	{
		int booleanErrors = 0;
		
		if(navigationSystem.equals("Yes"))
		{
			navigationSystem = "True";
			tempBoolean = Boolean.parseBoolean(navigationSystem);
		}
		else if(navigationSystem.equals("No"))
		{
			navigationSystem = "False";
			tempBoolean = Boolean.parseBoolean(navigationSystem);
		}

		if(cruiseControl.equals("Yes"))
		{
			cruiseControl = "True";
			tempBoolean = Boolean.parseBoolean(cruiseControl);
		}
		else if(cruiseControl.equals("No"))
		{
			cruiseControl = "False";
			tempBoolean = Boolean.parseBoolean(cruiseControl);
		}
		
		if(addVehiclePage.getRdbtnAutoCamper().isSelected())
		{
			if(refrigerator.equals("Yes"))
			{
				refrigerator = "True";
				tempBoolean = Boolean.parseBoolean(refrigerator);
			}
			else if(refrigerator.equals("No"))
			{
				refrigerator = "False";
				tempBoolean = Boolean.parseBoolean(refrigerator);
			}
			if(tv.equals("Yes"))
			{
				tv = "True";
				tempBoolean = Boolean.parseBoolean(tv);
			}
			else if(tv.equals("No"))
			{
				tv = "False";
				tempBoolean = Boolean.parseBoolean(tv);
			}
		
			if(heatedWater.equals("Yes"))
			{
				heatedWater = "True";
				tempBoolean = Boolean.parseBoolean(heatedWater);
			}
			else if(heatedWater.equals("No"))
			{
				heatedWater = "False";
				tempBoolean = Boolean.parseBoolean(heatedWater);
			}
			if(generator.equals("Yes"))
			{
				generator = "True";
				tempBoolean = Boolean.parseBoolean(generator);
			}
			else if(generator.equals("No"))
			{
				generator = "False";
				tempBoolean = Boolean.parseBoolean(generator);
			}
			
			if(bicycleStand.equals("Yes"))
			{
				bicycleStand = "True";
				tempBoolean = Boolean.parseBoolean(bicycleStand);
			}
			else if(bicycleStand.equals("No"))
			{
				bicycleStand = "False";
				tempBoolean = Boolean.parseBoolean(bicycleStand);
			}
			
			if(microwave.equals("Yes"))
			{
				microwave = "True";
				tempBoolean = Boolean.parseBoolean(microwave);
			}
			else if(microwave.equals("No"))
			{
				microwave = "False";
				tempBoolean = Boolean.parseBoolean(microwave);
			}
			
			if(roofHatch.equals("Yes"))
			{
				roofHatch = "True";
				tempBoolean = Boolean.parseBoolean(roofHatch);
			}
			else if(roofHatch.equals("No"))
			{
				roofHatch = "False";
				tempBoolean = Boolean.parseBoolean(roofHatch);
			}
			
			if(roofStorage.equals("Yes"))
			{
				roofStorage = "True";
				tempBoolean = Boolean.parseBoolean(roofStorage);
			}
			else if(roofStorage.equals("No"))
			{
				roofStorage = "False";
				tempBoolean = Boolean.parseBoolean(roofStorage);
			}
		}
		if(addVehiclePage.getRdbtnFamilyCar().isSelected())
		{
			if(childSeat.equals("Yes"))
			{
				childSeat = "True";
				tempBoolean = Boolean.parseBoolean(childSeat);
			}
			else if(childSeat.equals("No"))
			{
				childSeat = "False";
				tempBoolean = Boolean.parseBoolean(childSeat);
			}
			if(trailerCoupling.equals("Yes"))
			{
				trailerCoupling = "True";
				tempBoolean = Boolean.parseBoolean(trailerCoupling);
			}
			else if(trailerCoupling.equals("No"))
			{
				trailerCoupling = "False";
				tempBoolean = Boolean.parseBoolean(trailerCoupling);
			}
		}
		return booleanErrors;
	}
	/**
	 * switch the label to black after getting valid data in fields
	 */
	public void changeLabelsToBlack()
	{
		addVehiclePage.getRegNoLabel().setForeground(Color.black);
		addVehiclePage.getColorLabel().setForeground(Color.black);
		addVehiclePage.getModelLabel().setForeground(Color.black);
		addVehiclePage.getMakerLabel().setForeground(Color.black);
		addVehiclePage.getTransmissionLabel().setForeground(Color.black);
		addVehiclePage.getSizeSpecificationsLabel().setForeground(Color.black);
		addVehiclePage.getDriverLicenseLabel().setForeground(Color.black);
		addVehiclePage.getBatterySizeLabel().setForeground(Color.black);
		addVehiclePage.getBatteryChargerLabel().setForeground(Color.black);
		addVehiclePage.getTrunkCapacityLabel().setForeground(Color.black);
		addVehiclePage.getExteriorDimensionsLabel().setForeground(Color.black);
		addVehiclePage.getCargoSizeLabel().setForeground(Color.black);
		addVehiclePage.getNumberOfPeopleLabel().setForeground(Color.black);
		addVehiclePage.getNumberOfBedsLabel().setForeground(Color.black);
		addVehiclePage.getNumberOfKmLabel().setForeground(Color.black);
		addVehiclePage.getYearLabel().setForeground(Color.black);
		addVehiclePage.getHorsePowerLabel().setForeground(Color.black);
		addVehiclePage.getMaintenanceRemainingKmLabel().setForeground(Color.black);
		addVehiclePage.getNumberOfDoorsLabel().setForeground(Color.black);
		addVehiclePage.getNumberOfSeatsLabel().setForeground(Color.black);
		addVehiclePage.getEngineSizeLabel().setForeground(Color.black);
		addVehiclePage.getFuelConsumptionLabel().setForeground(Color.black);
		addVehiclePage.getPriceLabel().setForeground(Color.black);
		addVehiclePage.getLoadCapacityLabel().setForeground(Color.black);
		addVehiclePage.getNavigationSystemLabel().setForeground(Color.black);
		addVehiclePage.getCruiseControlLabel().setForeground(Color.black);
		addVehiclePage.getRefrigeratorLabel().setForeground(Color.black);
		addVehiclePage.getTvLabel().setForeground(Color.black);
		addVehiclePage.getHeatedWaterLabel().setForeground(Color.black);
		addVehiclePage.getGeneratorLabel().setForeground(Color.black);
		addVehiclePage.getBicycleStandLabel().setForeground(Color.black);
		addVehiclePage.getMicrowaveLabel().setForeground(Color.black);
		addVehiclePage.getRoofHatchLabel().setForeground(Color.black);
		addVehiclePage.getRoofStorageLabel().setForeground(Color.black);
		addVehiclePage.getChildSeatLabel().setForeground(Color.black);
		addVehiclePage.getTrailerCouplingLabel().setForeground(Color.black);
	}
	/**
	 * Adding the Vehicle to the list of vehicles
	 */
	public void addVehicleToList()
	{	

		if(checkEmptyStrings() == 0 && parseToDouble() == 0 && parseToInt() == 0 && parseToBoolean() == 0)
		{System.out.println("adding a vehicle");
			if(addVehiclePage.getRdbtnFamilyCar().isSelected())
			{	
				Vehicle familyCar = new FamilyCars(regNo, color, "Available", model, maker, transmission,
						numberOfKm, year, horsePower, "20000", engineSize,
						fuelConsumption, navigationSystem, cruiseControl, numberOfDoors, numberOfSeats,
						childSeat, trunkCapacity, trailerCoupling, roofStorage, price); 
				UserInterface.getVehicleList().addVehicle(0,familyCar);
			}
			else if(addVehiclePage.getRdbtnMovingTruck().isSelected())
			{
				Vehicle movingTruck = new MovingTrucks(regNo, color, "Available", model, maker, transmission,
						numberOfKm, year, horsePower, "20000", engineSize,
						fuelConsumption, navigationSystem, cruiseControl, price, exteriorDimensions,
						cargoSize, driverLicense, loadCapacity);
				UserInterface.getVehicleList().addVehicle(0,movingTruck);
			}
			else if(addVehiclePage.getRdbtnVan().isSelected())
			{
				Vehicle van = new Vans(regNo, color, "Available", model, maker, transmission, numberOfKm,
						year, horsePower, "20000", engineSize, fuelConsumption,
						navigationSystem, cruiseControl, price, driverLicense, cargoSize, numberOfSeats,
						numberOfDoors, loadCapacity, roofStorage);
				UserInterface.getVehicleList().addVehicle(0,van);
			}
			else if(addVehiclePage.getRdbtnAutoCamper().isSelected())
			{
				Vehicle autoCamper = new AutoCamper(regNo, color, "Available", model, maker, transmission,
						numberOfKm, year, horsePower, "20000", engineSize,
						fuelConsumption, navigationSystem, cruiseControl, numberOfPeople, sizeSpecifications,
						driverLicense, refrigerator, tv, heatedWater, batterySize, batteryCharger, generator,
						bicycleStand, numberOfBeds, microwave, roofHatch, roofStorage, price);
				UserInterface.getVehicleList().addVehicle(0,autoCamper);
			}
			UserInterface.saveFile();
			JOptionPane.showMessageDialog(null,"The vehicle was added successfully!","Car adding...",JOptionPane.PLAIN_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Make sure all fields are filled correctly",
					"Error adding vehicle",
        		    JOptionPane.WARNING_MESSAGE);
		}
	}
}
