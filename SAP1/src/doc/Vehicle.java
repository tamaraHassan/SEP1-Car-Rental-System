package doc;

import java.io.Serializable;

import javax.swing.JPanel;

import ui.ManageVehicle;

/**
 * 
 * Vehicle abstract class
 *
 */
public abstract class Vehicle implements Serializable{

//fields
	
private String regNo, color, vehicleStatus, model, maker, transmission;
private String numberOfKm, year, horsePower, remainingKm;
private String engineSize, fuelConsumption, price;
private String navigationSystem, cruiseControl;


//constructor

public Vehicle(){
	this.regNo = "";
	this.color = "";
	this.vehicleStatus = "";
	this.model = "";
	this.maker = "";
	this.transmission = "";
	this.numberOfKm = "";
	this.year = "";
	this.horsePower = "";

	this.remainingKm = "";
	this.engineSize = "";
	this.fuelConsumption = "";
	this.navigationSystem = "";
	this.cruiseControl = "";
	this.price="";
}

public Vehicle(String regNo, String color, String vehicleStatus, String model,
		String maker, String transmission, String numberOfKm, String year,
		String horsePower, String remainingKm,
		String engineSize, String fuelConsumption, String navigationSystem,
		String cruiseControl, String price) {
	this.regNo = regNo;
	this.color = color;
	this.vehicleStatus = vehicleStatus;
	this.model = model;
	this.maker = maker;
	this.transmission = transmission;
	this.numberOfKm = numberOfKm;
	this.year = year;
	this.horsePower = horsePower;
	this.remainingKm = remainingKm;
	this.engineSize = engineSize;
	this.fuelConsumption = fuelConsumption;
	this.navigationSystem = navigationSystem;
	this.cruiseControl = cruiseControl;
	this.price=price;
}


public String getRegNo() {
	return regNo;
}


public void setRegNo(String regNo) {
	this.regNo = regNo;
}


public String getColor() {
	return color;
}


public void setColor(String color) {
	this.color = color;
}


public String getVehicleStatus() {
	return vehicleStatus;
}


public void setVehicleStatus(String vehicleStatus) {
	this.vehicleStatus = vehicleStatus;
}


public String getModel() {
	return model;
}


public void setModel(String model) {
	this.model = model;
}


public String getMaker() {
	return maker;
}


public void setMaker(String maker) {
	this.maker = maker;
}


public String getTransmission() {
	return transmission;
}


public void setTransmission(String transmission) {
	this.transmission = transmission;
}


public String getNumberOfKm() {
	return numberOfKm;
}


public void setNumberOfKm(String numberOfKm) {
	this.numberOfKm = numberOfKm;
}


public String getYear() {
	return year;
}


public void setYear(String year) {
	this.year = year;
}


public String getHorsePower() {
	return horsePower;
}


public void setHorsePower(String horsePower) {
	this.horsePower = horsePower;
}


public String getRemainingKm() {
	return remainingKm;
}


public void setRemainingKm(String remainingKm) {
	this.remainingKm = remainingKm;
}


public String getEngineSize() {
	return engineSize;
}


public void setEngineSize(String engineSize) {
	this.engineSize = engineSize;
}


public String getFuelConsumption() {
	return fuelConsumption;
}


public void setFuelConsumption(String fuelConsumption) {
	this.fuelConsumption = fuelConsumption;
}


public String isNavigationSystem() {
	return navigationSystem;
}


public void setNavigationSystem(String navigationSystem) {
	this.navigationSystem = navigationSystem;
}


public String isCruiseControl() {
	return cruiseControl;
}


public void setCruiseControl(String cruiseControl) {
	this.cruiseControl = cruiseControl;
}

public void setPrice(String price){
	this.price=price;
}

public String getPrice(){
	return price;
}

public abstract JPanel getVehiclePanel();

public abstract JPanel getVehicleWithRemovePanel();

public abstract JPanel getVehicleWithServicePanel();
	
public boolean equals(Object obj){
	if(!(obj instanceof Vehicle))
		return false;
	else{
		Vehicle other= (Vehicle) obj;
	if(regNo==other.regNo&&color.equals(other.color)&&vehicleStatus.equals(other.vehicleStatus)&&model.equals(other.model)&&
			maker.equals(other.maker)&&transmission.equals(other.transmission)&&numberOfKm.equals(other.numberOfKm)&&year==other.year&&
			horsePower.equals(other.horsePower)&&remainingKm.equals(other.remainingKm)&&
			engineSize.equals(other.engineSize)&&fuelConsumption.equals(other.fuelConsumption)&&navigationSystem.equals(other.navigationSystem)&&
			cruiseControl.equals(other.cruiseControl)&&price.equals(other.price))
		return true;
	else return false;
	}
}

}
