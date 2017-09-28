package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import ui.*;
import doc.*;

public class SearchButtonListener implements ActionListener, Serializable
{
   private final SearchPage fromSearch;
   private VehicleList vehicles;
   private PopulateComboBoxes pop;
   private BookingList bookingList;

  

   public SearchButtonListener(VehicleList vehicles, SearchPage searchPage, BookingList bookingList)
   {
	  this.bookingList=UserInterface.getBookingList();
      this.fromSearch = searchPage;
      this.vehicles = UserInterface.getVehicleList();
      pop = new PopulateComboBoxes(vehicles, fromSearch);
      fromSearch.AddComboboxesToArraylist();
      
   }

   

   
   
   
   
   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == fromSearch.btnSearch)
      {
         Search fc;
         VehicleList temp=null;
         
         int numOfDays=pop.getNumOfDays((String)fromSearch.getComboStartYear().getSelectedItem(),
               (String)fromSearch.getComboStartMonth().getSelectedItem(),
               (String)fromSearch.getComboStartDay().getSelectedItem(),
               (String)fromSearch.getComboEndYear().getSelectedItem(),
               (String)fromSearch.getComboEndMonth().getSelectedItem(),
               (String)fromSearch.getComboEndDay().getSelectedItem());
   


         if (fromSearch.rdbtnFamilyCar.isSelected())
         {
            
            if(numOfDays<1){
               pop.setBacktoAny();
               JOptionPane.showMessageDialog(null,
              		    "Please select valid perioud of time",
              		    "Wrong date selected",
              		    JOptionPane.WARNING_MESSAGE);
            }
            else{
            fc = new Search(fromSearch);
            temp=fc.searchFamily();
            fromSearch.displayAvailableCarList(temp);
            }
         }
         else if (fromSearch.rdbtnVan.isSelected())
         {  
            if(numOfDays<1){
               pop.setBacktoAny();
               JOptionPane.showMessageDialog(null,
              		    "Please select valid perioud of time",
              		    "Wrong date selected",
              		    JOptionPane.WARNING_MESSAGE);
            }
            else{
            fc = new Search(fromSearch);
            temp=fc.searchVan();
            fromSearch.displayAvailableCarList(temp);
            }
            
         }
         else if (fromSearch.rdbtnMovingTruck.isSelected())
         {  
            if(numOfDays<1){
               pop.setBacktoAny();
               JOptionPane.showMessageDialog(null,
           		    "Please select valid perioud of time",
           		    "Wrong date selected",
           		    JOptionPane.WARNING_MESSAGE);
            }
            else{
            fc = new Search(fromSearch);
            temp=fc.searchMovingTruck();
            fromSearch.displayAvailableCarList(temp);}
         }
         else if (fromSearch.rdbtnAutoCamper.isSelected())
         {
        	 if(numOfDays!=2&&numOfDays!=7){
                 pop.setBacktoAny();
                 JOptionPane.showMessageDialog(null,
                		    "Please select a perioud of time of a week, or a weekend",
                		    "Wrong date selected",
                		    JOptionPane.WARNING_MESSAGE);
              }
        	 else{
        	 fc = new Search(fromSearch);
        	 temp=fc.searchAutoCamper();
        	 fromSearch.displayAvailableCarList(temp);
        	 }
         }

         

      }
      if (e.getSource() == fromSearch.getComboColor2())
      {

      }
    
      if (e.getSource() == fromSearch.getComboStartYear())
      {
            pop.yearHasChanged((String)fromSearch.getComboStartYear().getSelectedItem(),
                  fromSearch.getComboStartMonth());
      }
      if (e.getSource() == fromSearch.getComboStartMonth())
      {
            pop.monthHasChanged((String)fromSearch.getComboStartYear().getSelectedItem(),
                  (String)fromSearch.getComboStartMonth().getSelectedItem(), fromSearch.getComboStartDay());
      }
      if (e.getSource() == fromSearch.getComboEndYear())
      {
         pop.yearHasChanged((String)fromSearch.getComboEndYear().getSelectedItem(),
               fromSearch.getComboEndMonth());
      }
      if (e.getSource() == fromSearch.getComboEndMonth())
      {
         pop.monthHasChanged((String)fromSearch.getComboEndYear().getSelectedItem(),
               (String)fromSearch.getComboEndMonth().getSelectedItem(), fromSearch.getComboEndDay());

      }
      if (e.getSource() == fromSearch.getComboMake())
      {  
         /*if(((String)fromSearch.getComboMake().getSelectedItem()).equals("any")){
         pop.removeAllCombos();
         pop.populateCombos();
         }*/
        pop.filterModel((String)fromSearch.getComboMake().getSelectedItem(),0);
         
      }
      if (e.getSource() == fromSearch.getComboMake1())
      {
         
         pop.filterModel((String)fromSearch.getComboMake1().getSelectedItem(),1);
      }
      if (e.getSource() == fromSearch.getComboMake2())
      {
        
         pop.filterModel((String)fromSearch.getComboMake2().getSelectedItem(),2);
      }
      if (e.getSource() == fromSearch.getComboMake4())
      {
        
         pop.filterModel((String)fromSearch.getComboMake4().getSelectedItem(),4);
      }

   }
}
