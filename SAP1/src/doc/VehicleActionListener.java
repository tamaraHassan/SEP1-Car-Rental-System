package doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import ui.*;
import doc.*;

public class VehicleActionListener implements ActionListener, Serializable
{
   private VehicleList vehicles;
   private BookingList bookings;
   private Vehicle vehicle;
   private JButton remove;
   private JButton reserve;
   private int vehiclesSize;
   private ManageVehicle manageVehicles;
   
   public VehicleActionListener(VehicleList vehicles,  Vehicle vehicle,JButton remove){
      this.manageVehicles=manageVehicles;
      this.vehicles=vehicles;
      this.bookings=bookings;
      this.vehicle=vehicle;
      this.remove=remove;
      this.reserve=reserve;
      vehiclesSize=0;
     // managevehicle=new ManageVehicle(mainPanelCardLayaout, panelMenuGrid, vehicleList)
      
   }
   
   
   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == remove)
      {
         if(UserInterface.getVehicleList()!=null){
         vehiclesSize=UserInterface.getVehicleList().size();
         UserInterface.getVehicleList().removeVehicle(vehicle);
         if(UserInterface.getVehicleList().size()<vehiclesSize){
            JOptionPane.showMessageDialog(null,
                  "Vehicle Removed successfully","Remove Vehicle",
                  JOptionPane.WARNING_MESSAGE);
            UserInterface.saveFile();
         }
         vehiclesSize=vehicles.size();
         ManageVehicle.showAllVehicles();
         }
      }
      if (e.getSource() == reserve)
      {
         
      }
      
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

}
