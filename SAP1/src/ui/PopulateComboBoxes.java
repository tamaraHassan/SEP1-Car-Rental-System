package ui;

import java.io.Serializable;

import javax.swing.JComboBox;

import doc.AutoCamper;
import doc.FamilyCars;
import doc.MovingTrucks;
import doc.MyDate;
import doc.Vans;
import doc.VehicleList;

public class PopulateComboBoxes implements Serializable
{
   private VehicleList vehicles;
   private SearchPage fromSearch;

   // **********New**********
   private MyDate startDate;
   private MyDate endDate;

   // ----------------------

   public PopulateComboBoxes(VehicleList vehicles, SearchPage fromSearch)
   {
      this.vehicles = vehicles;
      this.fromSearch = fromSearch;

      // ******New*********
      startDate = MyDate.today();
      int nextYear = startDate.getYear() + 1;
      endDate = new MyDate(startDate.getDay(), startDate.getMonth(), nextYear);
      // -------------------

   }

   private boolean checkForDoublication(JComboBox<String> box, String item)
   {
      boolean exists = false;
      for (int index = 0; index < box.getItemCount() && !exists; index++)
      {
         if (item.equals(box.getItemAt(index)))
         {
            return true;
         }
      }
      return false;
   }

   // ********************************
   // to have models of the chosen maker
   public void filterModel(String makerBox, int type)
   {
      if (makerBox != null)
         if (makerBox.equals("any"))
         {
            removeAllCombos();
            populateCombos();
         }
         else
         {
            if (type == 0)
            {
               fromSearch.getComboModel().removeAllItems();
               fromSearch.getComboColor().removeAllItems();
               fromSearch.getComboEngineSize().removeAllItems();
               if (!(checkForDoublication(fromSearch.getComboModel(),"any")))
               {
                  fromSearch.getComboModel().addItem("any");
               }
               if (!(checkForDoublication(fromSearch.getComboColor(),"any")))
               {
                  fromSearch.getComboColor().addItem("any");
               }
               if (!(checkForDoublication(fromSearch.getComboEngineSize(),"any")))
               {
                  fromSearch.getComboEngineSize().addItem("any");
               }
              
               for (int i = 0; i < vehicles.size(); i++)
               {  if(vehicles.get(i) instanceof FamilyCars){
                  if (!(checkForDoublication(fromSearch.getComboModel(),
                        vehicles.get(i).getModel()))
                        && vehicles.get(i).getMaker().equals(makerBox))
                  {
                     fromSearch.getComboModel().addItem(vehicles.get(i).getModel());
                  }
                  if (!(checkForDoublication(fromSearch.getComboColor(),
                        vehicles.get(i).getColor()))
                        && vehicles.get(i).getMaker().equals(makerBox))
                  {
                     fromSearch.getComboColor().addItem(vehicles.get(i).getColor());
                  }
                  if (!(checkForDoublication(fromSearch.getComboEngineSize(),
                        vehicles.get(i).getEngineSize()))
                        && vehicles.get(i).getMaker().equals(makerBox))
                  {
                     fromSearch.getComboEngineSize().addItem(vehicles.get(i).getEngineSize());
                  }
               }
               }
            }else if (type == 1)
            {
               fromSearch.getComboModel1().removeAllItems();
               fromSearch.getComboColor1().removeAllItems();
               fromSearch.getComboEngineSize1().removeAllItems();
               if (!(checkForDoublication(fromSearch.getComboModel1(),"any")))
               {
                  fromSearch.getComboModel1().addItem("any");
               }
               if (!(checkForDoublication(fromSearch.getComboColor1(),"any")))
               {
                  fromSearch.getComboColor1().addItem("any");
               }
               if (!(checkForDoublication(fromSearch.getComboEngineSize1(),"any")))
               {
                  fromSearch.getComboEngineSize1().addItem("any");
               }
               for (int i = 0; i < vehicles.size(); i++)
               { if(vehicles.get(i) instanceof Vans){
                  if (!(checkForDoublication(fromSearch.getComboModel1(),
                        vehicles.get(i).getModel()))
                        && vehicles.get(i).getMaker().equals(makerBox))
                  {
                     fromSearch.getComboModel1().addItem(vehicles.get(i).getModel());
                  }
                  if (!(checkForDoublication(fromSearch.getComboColor1(),
                        vehicles.get(i).getColor()))
                        && vehicles.get(i).getMaker().equals(makerBox))
                  {
                     fromSearch.getComboColor1().addItem(vehicles.get(i).getColor());
                  }
                  if (!(checkForDoublication(fromSearch.getComboEngineSize1(),
                        vehicles.get(i).getEngineSize()))
                        && vehicles.get(i).getMaker().equals(makerBox))
                  {
                     fromSearch.getComboEngineSize1().addItem(vehicles.get(i).getEngineSize());
                  }
                  
               }
               }
            }
            else if (type == 2)
            {
               fromSearch.getComboModel2().removeAllItems();
               fromSearch.getComboColor2().removeAllItems();
               fromSearch.getComboEngineSize2().removeAllItems();
               if (!(checkForDoublication(fromSearch.getComboModel2(),"any")))
               {
                  fromSearch.getComboModel2().addItem("any");
               }
               if (!(checkForDoublication(fromSearch.getComboColor2(),"any")))
               {
                  fromSearch.getComboColor2().addItem("any");
               }
               if (!(checkForDoublication(fromSearch.getComboEngineSize2(),"any")))
               {
                  fromSearch.getComboEngineSize2().addItem("any");
               }
               for (int i = 0; i < vehicles.size(); i++)
               { if(vehicles.get(i) instanceof MovingTrucks){
                  if (!(checkForDoublication(fromSearch.getComboModel2(),
                        vehicles.get(i).getModel()))
                        && vehicles.get(i).getMaker().equals(makerBox))
                  {
                     fromSearch.getComboModel2().addItem(vehicles.get(i).getModel());
                  }
                  if (!(checkForDoublication(fromSearch.getComboColor2(),
                        vehicles.get(i).getColor()))
                        && vehicles.get(i).getMaker().equals(makerBox))
                  {
                     fromSearch.getComboColor2().addItem(vehicles.get(i).getColor());
                  }
                  if (!(checkForDoublication(fromSearch.getComboEngineSize2(),
                        vehicles.get(i).getEngineSize()))
                        && vehicles.get(i).getMaker().equals(makerBox))
                  {
                     fromSearch.getComboEngineSize2().addItem(vehicles.get(i).getEngineSize());
                  }
                  
               }
               }
            }
            else if (type == 4)
            {
               fromSearch.getComboModel4().removeAllItems();
               fromSearch.getComboColor4().removeAllItems();
               fromSearch.getComboEngineSize4().removeAllItems();
               if (!(checkForDoublication(fromSearch.getComboModel4(),"any")))
               {
                  fromSearch.getComboModel4().addItem("any");
               }
               if (!(checkForDoublication(fromSearch.getComboColor4(),"any")))
               {
                  fromSearch.getComboColor4().addItem("any");
               }
               if (!(checkForDoublication(fromSearch.getComboEngineSize4(),"any")))
               {
                  fromSearch.getComboEngineSize4().addItem("any");
               }
               for (int i = 0; i < vehicles.size(); i++)
               { if(vehicles.get(i) instanceof AutoCamper){
                  if (!(checkForDoublication(fromSearch.getComboModel4(),
                        vehicles.get(i).getModel()))
                        && vehicles.get(i).getMaker().equals(makerBox))
                  {
                     fromSearch.getComboModel4().addItem(vehicles.get(i).getModel());
                  }
                  if (!(checkForDoublication(fromSearch.getComboColor4(),
                        vehicles.get(i).getColor()))
                        && vehicles.get(i).getMaker().equals(makerBox))
                  {
                     fromSearch.getComboColor4().addItem(vehicles.get(i).getColor());
                  }
                  if (!(checkForDoublication(fromSearch.getComboEngineSize4(),
                        vehicles.get(i).getEngineSize()))
                        && vehicles.get(i).getMaker().equals(makerBox))
                  {
                     fromSearch.getComboEngineSize4().addItem(vehicles.get(i).getEngineSize());
                  }
                  
               }
               }
               
            }

         }
   }
   /*
   public void filterByModel(String model, int type){
      String maker="";
      for(int j=0;j<vehicles.size();j++){
        if(vehicles.get(j).getModel().equals(model)){
          maker= vehicles.get(j).getMaker();
        }
      }
      
      if(type==0){
      for( int i=0; i<fromSearch.getComboMake().getItemCount();i++){
         System.out.println(fromSearch.getComboMake().getItemAt(i));
         if(fromSearch.getComboMake().getItemAt(i).equals(maker)){
            fromSearch.getComboMake().setSelectedIndex(i);
            break;
         }
      }
      }else if(type==1){
         for( int i=0; i<fromSearch.getComboMake1().getItemCount();i++){
            if(fromSearch.getComboMake1().getItemAt(i).equals(maker)){
               fromSearch.getComboMake1().setSelectedIndex(i);
               break;
            }
         }
      }else if(type==2){
         for( int i=0; i<fromSearch.getComboMake2().getItemCount();i++){
            if(fromSearch.getComboMake2().getItemAt(i).equals(maker)){
               fromSearch.getComboMake2().setSelectedIndex(i);
               break;
            }
         }
      }else if(type==4){
         for( int i=0; i<fromSearch.getComboMake4().getItemCount();i++){
            if(fromSearch.getComboMake4().getItemAt(i).equals(maker)){
               fromSearch.getComboMake4().setSelectedIndex(i);
               break;
            }
         }
      }
      
   }*/
/*
   private void filterYear(String modelBox)
   {

      fromSearch.getComboYear().removeAllItems();
      for (int i = 0; i < vehicles.size(); i++)
      {
         if (!(checkForDoublication(fromSearch.getComboYear(), vehicles.get(i)
               .getYear()))
               && vehicles.get(i).getModel().equals(modelBox))
         {
            fromSearch.getComboYear().addItem(vehicles.get(i).getYear());
         }
      }

   }
*/
   // *******************************
   public void removeAllCombos() // update it is actually populate combo box
   {
      fromSearch.getComboPickupLocation().removeAllItems();
      fromSearch.getComboDropLocation().removeAllItems();
      fromSearch.getComboPiclupTime().removeAllItems();

      // familyCars combo boxes
      fromSearch.comboPrice.removeAllItems();
      fromSearch.comboMake.removeAllItems(); //
      fromSearch.comboModel.removeAllItems(); //
      fromSearch.comboColor.removeAllItems(); //
      fromSearch.comboTransmition.removeAllItems(); //
      fromSearch.comboYear.removeAllItems(); //
      fromSearch.comboEngineSize.removeAllItems(); //
      fromSearch.comboFuelConsumption.removeAllItems(); //
      fromSearch.comboNavigation.removeAllItems();//
      fromSearch.comboCruiseControl.removeAllItems(); //
      fromSearch.comboNumberOfDoors.removeAllItems();

      fromSearch.comboNumberOfSeats.removeAllItems();
      fromSearch.comboChildSeat.removeAllItems();
      fromSearch.comboTruncCapacity.removeAllItems();
      fromSearch.comboTrailerCopling.removeAllItems();
      fromSearch.comboRoofStorage.removeAllItems();
      fromSearch.comboHp.removeAllItems();

      // familyCars combo boxes

      // **************************New***************************
      // Vans combo boxes
      fromSearch.comboMake1.removeAllItems();
      fromSearch.comboModel1.removeAllItems();
      fromSearch.comboColor1.removeAllItems();
      fromSearch.comboTransmition1.removeAllItems();
      fromSearch.comboYear1.removeAllItems();
      fromSearch.comboEngineSize1.removeAllItems();
      fromSearch.comboFuelConsumption1.removeAllItems();
      fromSearch.comboNavigation1.removeAllItems();
      fromSearch.comboCruiseControl1.removeAllItems();
      fromSearch.comboNumberOfDoors1.removeAllItems();
      fromSearch.comboNumberOfSeats1.removeAllItems();
      fromSearch.comboDrLicense1.removeAllItems();
      fromSearch.comboRoofStorage1.removeAllItems();
      fromSearch.comboHp1.removeAllItems();
      fromSearch.comboCargoSize.removeAllItems();
      fromSearch.comboLoadCapacity.removeAllItems();
      fromSearch.comboRoofStorage.removeAllItems();
      // Vans combo boxes

      // Moving Trucks combo boxes
      fromSearch.comboMake2.removeAllItems();
      fromSearch.comboModel2.removeAllItems();
      fromSearch.comboColor2.removeAllItems();
      fromSearch.comboTransmition2.removeAllItems();
      fromSearch.comboYear2.removeAllItems();
      fromSearch.comboEngineSize2.removeAllItems();
      fromSearch.comboFuelConsumption2.removeAllItems();
      fromSearch.comboNavigation2.removeAllItems();
      fromSearch.comboCruiseControl2.removeAllItems();
      fromSearch.comboDrLicense2.removeAllItems();
      fromSearch.comboHp2.removeAllItems();
      fromSearch.comboCargoSize2.removeAllItems();
      fromSearch.comboLoadCapacity2.removeAllItems();
      fromSearch.comboExtDim2.removeAllItems();
      // Moving Trucks combo boxes

      // AutoCamper combo boxes
      fromSearch.comboMake4.removeAllItems(); //
      fromSearch.comboModel4.removeAllItems(); //
      fromSearch.comboColor4.removeAllItems();//
      fromSearch.comboTransmition4.removeAllItems(); //
      fromSearch.comboYear4.removeAllItems(); //
      fromSearch.comboEngineSize4.removeAllItems(); //
      fromSearch.comboFuelConsumption4.removeAllItems(); //
      fromSearch.comboNavigation4.removeAllItems();//
      fromSearch.comboCruiseControl4.removeAllItems(); //
      fromSearch.comboNrOfPeople.removeAllItems();
      fromSearch.comboExtSize.removeAllItems();
      fromSearch.comboDrLicense4.removeAllItems();
      fromSearch.comboRefregerator.removeAllItems();
      fromSearch.comboTv.removeAllItems();
      fromSearch.comboHeatedWater.removeAllItems();
      fromSearch.comboBattery.removeAllItems();
      fromSearch.comboBatteryCharger.removeAllItems();
      fromSearch.comboGenerator.removeAllItems();
      fromSearch.comboBicicleStand.removeAllItems();
      fromSearch.comboNumberOfBeds.removeAllItems();
      fromSearch.comboMicrowave.removeAllItems();
      fromSearch.comboRoofHatch.removeAllItems();
   }

   public void populateCombos() // update it is actually populate combo box
   {
      // POPULATING PICKUP PLACE PICKUP TIME AND DELIVERY
      removeAllCombos();
      fromSearch.getComboPickupLocation().addItem("Holstebro");
      fromSearch.getComboPickupLocation().addItem("Horsens");
      fromSearch.getComboPickupLocation().addItem("Århus");
      fromSearch.getComboPickupLocation().addItem("Copenhagen");
      fromSearch.getComboPickupLocation().addItem("Odense");

      fromSearch.getComboDropLocation().addItem("Holstebro");
      fromSearch.getComboDropLocation().addItem("Horsens");
      fromSearch.getComboDropLocation().addItem("Århus");
      fromSearch.getComboDropLocation().addItem("Copenhagen");
      fromSearch.getComboDropLocation().addItem("Odense");
      for (int i = 8; i < 18; i++)
      {
         fromSearch.getComboPiclupTime().addItem(i);
      }

      // *****************************************************************
      // ---------------------------------------------------------------
      // **************************New***************************
      // Vans combo boxes
      if (!(checkForDoublication(fromSearch.comboMake1,"any")))
      {
         fromSearch.comboMake1.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboModel1,"any")))
      {
         fromSearch.comboModel1.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboColor1,"any")))
      {
         fromSearch.comboColor1.addItem("any");
      }
      
      if (!(checkForDoublication(fromSearch.comboTransmition1,"any")))
      {
         fromSearch.comboTransmition1.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboYear1,"any")))
      {
         fromSearch.comboYear1.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboEngineSize1,"any")))
      {
         fromSearch.comboEngineSize1.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboFuelConsumption1,"any")))
      {
         fromSearch.comboFuelConsumption1.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboNavigation1,"any")))
      {
         fromSearch.comboNavigation1.addItem("any");
      }
      
      if (!(checkForDoublication(fromSearch.comboCruiseControl1,"any")))
      {
         fromSearch.comboCruiseControl1.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboNumberOfDoors1,"any")))
      {
         fromSearch.comboNumberOfDoors1.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboNumberOfSeats1,"any")))
      {
         fromSearch.comboNumberOfSeats1.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboDrLicense1,"any")))
      {
         fromSearch.comboDrLicense1.addItem("any");
      }
      
      
      if (!(checkForDoublication(fromSearch.comboRoofStorage1,"any")))
      {
         fromSearch.comboRoofStorage1.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboHp1,"any")))
      {
         fromSearch.comboHp1.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboCargoSize,"any")))
      {
         fromSearch.comboCargoSize.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboLoadCapacity,"any")))
      {
         fromSearch.comboLoadCapacity.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboRoofStorage,"any")))
      {
         fromSearch.comboRoofStorage.addItem("any");
      }
      
      // Vans combo boxes

      // Moving Trucks combo boxes
      if (!(checkForDoublication(fromSearch.comboMake2,"any")))
      {
         fromSearch.comboMake2.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboModel2,"any")))
      {
         fromSearch.comboModel2.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboColor2,"any")))
      {
         fromSearch.comboColor2.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboTransmition2,"any")))
      {
         fromSearch.comboTransmition2.addItem("any");
      }
      
      if (!(checkForDoublication(fromSearch.comboYear2,"any")))
      {
         fromSearch.comboYear2.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboEngineSize2,"any")))
      {
         fromSearch.comboEngineSize2.addItem("any");;
      }
      if (!(checkForDoublication(fromSearch.comboFuelConsumption2,"any")))
      {
         fromSearch.comboFuelConsumption2.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboNavigation2,"any")))
      {
         fromSearch.comboNavigation2.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboCruiseControl2,"any")))
      {
         fromSearch.comboCruiseControl2.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboDrLicense2,"any")))
      {
         fromSearch.comboDrLicense2.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboHp2,"any")))
      {
         fromSearch.comboHp2.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboCargoSize2,"any")))
      {
         fromSearch.comboCargoSize2.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboLoadCapacity2,"any")))
      {
         fromSearch.comboLoadCapacity2.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboExtDim2,"any")))
      {
         fromSearch.comboExtDim2.addItem("any");
      }
 // Moving Trucks combo boxes

      // AutoCamper combo boxes
      if (!(checkForDoublication(fromSearch.comboMake4,"any")))
      {
         fromSearch.comboMake4.addItem("any"); //
      }
      if (!(checkForDoublication(fromSearch.comboModel4,"any")))
      {
         fromSearch.comboModel4.addItem("any"); //
      }
      if (!(checkForDoublication(fromSearch.comboColor4,"any")))
      {
         fromSearch.comboColor4.addItem("any");//
      }
      if (!(checkForDoublication(fromSearch.comboTransmition4,"any")))
      {
         fromSearch.comboTransmition4.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboYear4,"any")))
      {
         fromSearch.comboYear4.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboEngineSize4,"any")))
      {
         fromSearch.comboEngineSize4.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboFuelConsumption4,"any")))
      {
         fromSearch.comboFuelConsumption4.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboNavigation4,"any")))
      {
         fromSearch.comboNavigation4.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboCruiseControl4,"any")))
      {
         fromSearch.comboCruiseControl4.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboNrOfPeople,"any")))
      {
         fromSearch.comboNrOfPeople.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboExtSize,"any")))
      {
         fromSearch.comboExtSize.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboDrLicense4,"any")))
      {
         fromSearch.comboDrLicense4.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboRefregerator,"any")))
      {
         fromSearch.comboRefregerator.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboTv,"any")))
      {
         fromSearch.comboTv.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboHeatedWater,"any")))
      {
         fromSearch.comboHeatedWater.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboBattery,"any")))
      {
         fromSearch.comboBattery.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboBatteryCharger,"any")))
      {
         fromSearch.comboBatteryCharger.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboGenerator,"any")))
      {
         fromSearch.comboGenerator.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboBicicleStand,"any")))
      {
         fromSearch.comboBicicleStand.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboNumberOfBeds,"any")))
      {
         fromSearch.comboNumberOfBeds.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboMicrowave,"any")))
      {
         fromSearch.comboMicrowave.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboRoofHatch,"any")))
      {
         fromSearch.comboRoofHatch.addItem("any");
      }     
      // *****************************************************************
      // ---------------------------------------------------------------

      // *****************NEW*************
      /*
      if (!(checkForDoublication(fromSearch.comboStartDay,"any")))
      {
         fromSearch.comboStartDay.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboStartMonth,"any")))
      {
         fromSearch.comboStartMonth.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboStartYear,"any")))
      {
         fromSearch.comboStartYear.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboEndDay,"any")))
      {
         fromSearch.comboEndDay.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboEndMonth,"any")))
      {
         fromSearch.comboEndMonth.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboEndYear,"any")))
      {
         fromSearch.comboEndYear.addItem("any");
      }*/
      if (!(checkForDoublication(fromSearch.comboStartYear,("" + startDate.getYear()))))
      {
         fromSearch.comboStartYear.addItem(("" + startDate.getYear()));
      }
      if (!(checkForDoublication(fromSearch.comboStartYear,("" + endDate.getYear()))))
      {
         fromSearch.comboStartYear.addItem(("" + endDate.getYear()));
      }
      if (!(checkForDoublication(fromSearch.comboEndYear,("" + startDate.getYear()))))
      {
         fromSearch.comboEndYear.addItem(("" + startDate.getYear()));
      }
      if (!(checkForDoublication(fromSearch.comboEndYear,("" + endDate.getYear()))))
      {
         fromSearch.comboEndYear.addItem(("" + endDate.getYear()));
      }
      if (!(checkForDoublication(fromSearch.comboMake,"any")))
      {
         fromSearch.comboMake.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboModel,"any")))
      {
         fromSearch.comboModel.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboYear,"any")))
      {
         fromSearch.comboYear.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboHp,"any")))
      {
         fromSearch.comboHp.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboColor,"any")))
      {
         fromSearch.comboColor.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboFuelConsumption,"any")))
      {
         fromSearch.comboFuelConsumption.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboTransmition,"any")))
      {
         fromSearch.comboTransmition.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboNavigation,"any")))
      {
         fromSearch.comboNavigation.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboCruiseControl,"any")))
      {
         fromSearch.comboCruiseControl.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboPrice,"any")))
      {
         fromSearch.comboPrice.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboEngineSize,"any")))
      {
         fromSearch.comboEngineSize.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboNumberOfDoors,"any")))
      {
         fromSearch.comboNumberOfDoors.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboNumberOfSeats,"any")))
      {
         fromSearch.comboNumberOfSeats.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboChildSeat,"any")))
      {
         fromSearch.comboChildSeat.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboTruncCapacity,"any")))
      {
         fromSearch.comboTruncCapacity.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboTrailerCopling,"any")))
      {
         fromSearch.comboTrailerCopling.addItem("any");
      }
      if (!(checkForDoublication(fromSearch.comboRoofStorage,"any")))
      {
         fromSearch.comboRoofStorage.addItem("any");
      }
  


      for (int i = 0; i < vehicles.size(); i++)
      {
         if (vehicles.get(i) instanceof FamilyCars)
         {
            // if(vehicles.get(i).getVehicleStatus().equals("Available")){//use
            // thus condition

            if (!(checkForDoublication(fromSearch.comboMake, vehicles.get(i)
                  .getMaker())))
            {
               fromSearch.comboMake.addItem(vehicles.get(i).getMaker());
            }

            if (!(checkForDoublication(fromSearch.comboModel, vehicles.get(i)
                  .getModel())))
            {
               fromSearch.comboModel.addItem(vehicles.get(i).getModel());
            }

            if (!(checkForDoublication(fromSearch.comboYear, vehicles.get(i)
                  .getYear())))
            {
               fromSearch.comboYear.addItem(vehicles.get(i).getYear());
            }

            if (!(checkForDoublication(fromSearch.comboHp, vehicles.get(i)
                  .getHorsePower())))
            {
               fromSearch.comboHp.addItem(vehicles.get(i).getHorsePower());
            }

            if (!(checkForDoublication(fromSearch.comboColor, vehicles.get(i)
                  .getColor())))
            {
               fromSearch.comboColor.addItem(vehicles.get(i).getColor());
            }

            if (!(checkForDoublication(fromSearch.comboFuelConsumption,
                  vehicles.get(i).getFuelConsumption())))
            {
               fromSearch.comboFuelConsumption.addItem(vehicles.get(i)
                     .getFuelConsumption());
            }

            if (!(checkForDoublication(fromSearch.comboTransmition, vehicles
                  .get(i).getTransmission())))
            {
               fromSearch.comboTransmition.addItem(vehicles.get(i)
                     .getTransmission());
            }
            if (!(checkForDoublication(fromSearch.comboEngineSize, vehicles
                  .get(i).getEngineSize())))
            {
               fromSearch.comboEngineSize.addItem(vehicles.get(i)
                     .getEngineSize());
            }

            if (!(checkForDoublication(fromSearch.comboNavigation, vehicles
                  .get(i).isNavigationSystem())))
            {
               fromSearch.comboNavigation.addItem(vehicles.get(i)
                     .isNavigationSystem());
            }

            if (!(checkForDoublication(fromSearch.comboCruiseControl, vehicles
                  .get(i).isCruiseControl())))
            {
               fromSearch.comboCruiseControl.addItem(vehicles.get(i)
                     .isCruiseControl());
            }

            if (!(checkForDoublication(fromSearch.comboPrice, vehicles.get(i)
                  .getPrice())))
            {
               fromSearch.comboPrice.addItem(vehicles.get(i).getPrice());
            }
            // Casting to Family car to call get methods
            FamilyCars famcar;
            famcar = (FamilyCars) vehicles.get(i);
            if (!(checkForDoublication(fromSearch.comboNumberOfDoors,
                  (famcar.getNumberOfDoors()))))
            {
               fromSearch.comboNumberOfDoors
                     .addItem((famcar.getNumberOfDoors()));
            }
            if (!(checkForDoublication(fromSearch.comboNumberOfSeats,
                  famcar.getNumberOfSeats())))
            {
               fromSearch.comboNumberOfSeats.addItem(famcar.getNumberOfSeats());
            }
            if (!(checkForDoublication(fromSearch.comboChildSeat,
                  famcar.isChildSeat())))
            {
               fromSearch.comboChildSeat.addItem(famcar.isChildSeat());
            }
            if (!(checkForDoublication(fromSearch.comboTruncCapacity,
                  famcar.getTrunkCapacity())))
            {
               fromSearch.comboTruncCapacity.addItem(famcar.getTrunkCapacity());
            }
            if (!(checkForDoublication(fromSearch.comboTrailerCopling,
                  famcar.isTrailerCoupling())))
            {
               fromSearch.comboTrailerCopling.addItem(famcar
                     .isTrailerCoupling());
            }
            if (!(checkForDoublication(fromSearch.comboRoofStorage,
                  famcar.isRoofStorage())))
            {
               fromSearch.comboRoofStorage.addItem(famcar.isRoofStorage());
            }
         }

         // **************************New***************************
         // Vans combo boxes
         else if (vehicles.get(i) instanceof Vans)
         {
            if (!(checkForDoublication(fromSearch.comboMake1, vehicles.get(i)
                  .getMaker())))
            {
               fromSearch.comboMake1.addItem(vehicles.get(i).getMaker());
            }
            if (!(checkForDoublication(fromSearch.comboModel1, vehicles.get(i)
                  .getModel())))
            {
               fromSearch.comboModel1.addItem(vehicles.get(i).getModel());
            }

            if (!(checkForDoublication(fromSearch.comboColor1, vehicles.get(i)
                  .getColor())))
            {
               fromSearch.comboColor1.addItem(vehicles.get(i).getColor());
            }
            if (!(checkForDoublication(fromSearch.comboTransmition1, vehicles
                  .get(i).getTransmission())))
            {
               fromSearch.comboTransmition1.addItem(vehicles.get(i)
                     .getTransmission());
            }
            if (!(checkForDoublication(fromSearch.comboYear1, vehicles.get(i)
                  .getYear())))
            {
               fromSearch.comboYear1.addItem(vehicles.get(i).getYear());
            }
            if (!(checkForDoublication(fromSearch.comboEngineSize1, vehicles
                  .get(i).getEngineSize())))
            {
               fromSearch.comboEngineSize1.addItem(vehicles.get(i)
                     .getEngineSize());
            }
            if (!(checkForDoublication(fromSearch.comboFuelConsumption1,
                  vehicles.get(i).getFuelConsumption())))
            {
               fromSearch.comboFuelConsumption1.addItem(vehicles.get(i)
                     .getFuelConsumption());
            }
            if (!(checkForDoublication(fromSearch.comboNavigation1, vehicles
                  .get(i).isNavigationSystem())))
            {
               fromSearch.comboNavigation1.addItem(vehicles.get(i)
                     .isNavigationSystem());
            }
            if (!(checkForDoublication(fromSearch.comboCruiseControl1, vehicles
                  .get(i).isCruiseControl())))
            {
               fromSearch.comboCruiseControl1.addItem(vehicles.get(i)
                     .isCruiseControl());
            }

            // Casting to Van
            Vans vancar;
            vancar = (Vans) vehicles.get(i);

            if (!(checkForDoublication(fromSearch.comboNumberOfDoors1,
                  vancar.getNumberOfDoors())))
            {
               fromSearch.comboNumberOfDoors1
                     .addItem(vancar.getNumberOfDoors());
            }
            if (!(checkForDoublication(fromSearch.comboNumberOfSeats1,
                  vancar.getNumberOfSeats())))
            {
               fromSearch.comboNumberOfSeats1
                     .addItem(vancar.getNumberOfSeats());
            }

            if (!(checkForDoublication(fromSearch.comboDrLicense1,
                  vancar.getDriverLicense())))
            {
               fromSearch.comboDrLicense1.addItem(vancar.getDriverLicense());
            }
            if (!(checkForDoublication(fromSearch.comboRoofStorage1,
                  vancar.isRoofStorage())))
            {
               fromSearch.comboRoofStorage1.addItem(vancar.isRoofStorage());
            }
            if (!(checkForDoublication(fromSearch.comboHp1,
                  vancar.getHorsePower())))
            {
               fromSearch.comboHp1.addItem(vancar.getHorsePower());
            }
            if (!(checkForDoublication(fromSearch.comboCargoSize,
                  vancar.getCargoSize())))
            {
               fromSearch.comboCargoSize.addItem(vancar.getCargoSize());
            }
            if (!(checkForDoublication(fromSearch.comboLoadCapacity,
                  vancar.getLoadCapacity())))
            {
               fromSearch.comboLoadCapacity.addItem(vancar.getLoadCapacity());
            }
            if (!(checkForDoublication(fromSearch.comboRoofStorage,
                  vancar.isRoofStorage())))
            {
               fromSearch.comboRoofStorage.addItem(vancar.isRoofStorage());
            }
            // Vans combo boxes
         }

         // Moving Truck
         else if (vehicles.get(i) instanceof MovingTrucks)
         {
            if (!(checkForDoublication(fromSearch.comboMake2, vehicles.get(i)
                  .getMaker())))
            {
               fromSearch.comboMake2.addItem(vehicles.get(i).getMaker());
            }
            if (!(checkForDoublication(fromSearch.comboModel2, vehicles.get(i)
                  .getModel())))
            {
               fromSearch.comboModel2.addItem(vehicles.get(i).getModel());
            }

            if (!(checkForDoublication(fromSearch.comboColor2, vehicles.get(i)
                  .getColor())))
            {
               fromSearch.comboColor2.addItem(vehicles.get(i).getColor());
            }
            if (!(checkForDoublication(fromSearch.comboTransmition2, vehicles
                  .get(i).getTransmission())))
            {
               fromSearch.comboTransmition2.addItem(vehicles.get(i)
                     .getTransmission());
            }
            if (!(checkForDoublication(fromSearch.comboYear2, vehicles.get(i)
                  .getYear())))
            {
               fromSearch.comboYear2.addItem(vehicles.get(i).getYear());
            }
            if (!(checkForDoublication(fromSearch.comboEngineSize2, vehicles
                  .get(i).getEngineSize())))
            {
               fromSearch.comboEngineSize2.addItem(vehicles.get(i)
                     .getEngineSize());
            }
            if (!(checkForDoublication(fromSearch.comboFuelConsumption2,
                  vehicles.get(i).getFuelConsumption())))
            {
               fromSearch.comboFuelConsumption2.addItem(vehicles.get(i)
                     .getFuelConsumption());
            }
            if (!(checkForDoublication(fromSearch.comboNavigation2, vehicles
                  .get(i).isNavigationSystem())))
            {
               fromSearch.comboNavigation2.addItem(vehicles.get(i)
                     .isNavigationSystem());
            }
            if (!(checkForDoublication(fromSearch.comboCruiseControl2, vehicles
                  .get(i).isCruiseControl())))
            {
               fromSearch.comboCruiseControl2.addItem(vehicles.get(i)
                     .isCruiseControl());
            }

            // Casting to Moving Trucks
            MovingTrucks movingTrucks;
            movingTrucks = (MovingTrucks) vehicles.get(i);

            if (!(checkForDoublication(fromSearch.comboDrLicense2,
                  movingTrucks.getDriverLicense())))
            {
               fromSearch.comboDrLicense2.addItem(movingTrucks
                     .getDriverLicense());
            }
            if (!(checkForDoublication(fromSearch.comboHp2,
                  movingTrucks.getHorsePower())))
            {
               fromSearch.comboHp2.addItem(movingTrucks.getHorsePower());
            }
            if (!(checkForDoublication(fromSearch.comboCargoSize2,
                  movingTrucks.getCargoSize())))
            {
               fromSearch.comboCargoSize2.addItem(movingTrucks.getCargoSize());
            }
            if (!(checkForDoublication(fromSearch.comboLoadCapacity2,
                  movingTrucks.getLoadCapacity())))
            {
               fromSearch.comboLoadCapacity2.addItem(movingTrucks
                     .getLoadCapacity());
            }
            if (!(checkForDoublication(fromSearch.comboExtDim2,
                  movingTrucks.getExteriorDimensions())))
            {
               fromSearch.comboExtDim2.addItem(movingTrucks
                     .getExteriorDimensions());
            }

         }
         // Auto Camper

         else if (vehicles.get(i) instanceof AutoCamper)
         {
            if (!(checkForDoublication(fromSearch.comboMake4, vehicles.get(i)
                  .getMaker())))
            {
               fromSearch.comboMake4.addItem(vehicles.get(i).getMaker());
            }
            if (!(checkForDoublication(fromSearch.comboModel4, vehicles.get(i)
                  .getModel())))
            {
               fromSearch.comboModel4.addItem(vehicles.get(i).getModel());
            }

            if (!(checkForDoublication(fromSearch.comboColor4, vehicles.get(i)
                  .getColor())))
            {
               fromSearch.comboColor4.addItem(vehicles.get(i).getColor());
            }
            if (!(checkForDoublication(fromSearch.comboTransmition4, vehicles
                  .get(i).getTransmission())))
            {
               fromSearch.comboTransmition4.addItem(vehicles.get(i)
                     .getTransmission());
            }
            if (!(checkForDoublication(fromSearch.comboYear4, vehicles.get(i)
                  .getYear())))
            {
               fromSearch.comboYear4.addItem(vehicles.get(i).getYear());
            }
            if (!(checkForDoublication(fromSearch.comboEngineSize4, vehicles
                  .get(i).getEngineSize())))
            {
               fromSearch.comboEngineSize4.addItem(vehicles.get(i)
                     .getEngineSize());
            }
            if (!(checkForDoublication(fromSearch.comboFuelConsumption4,
                  vehicles.get(i).getFuelConsumption())))
            {
               fromSearch.comboFuelConsumption4.addItem(vehicles.get(i)
                     .getFuelConsumption());
            }
            if (!(checkForDoublication(fromSearch.comboNavigation4, vehicles
                  .get(i).isNavigationSystem())))
            {
               fromSearch.comboNavigation4.addItem(vehicles.get(i)
                     .isNavigationSystem());
            }
            if (!(checkForDoublication(fromSearch.comboCruiseControl4, vehicles
                  .get(i).isCruiseControl())))
            {
               fromSearch.comboCruiseControl4.addItem(vehicles.get(i)
                     .isCruiseControl());
            }

            // Casting to Moving Trucks
            AutoCamper autoCamper;
            autoCamper = (AutoCamper) vehicles.get(i);

            if (!(checkForDoublication(fromSearch.comboDrLicense4,
                  autoCamper.getDriverLicense())))
            {
               fromSearch.comboDrLicense4
                     .addItem(autoCamper.getDriverLicense());
            }
            if (!(checkForDoublication(fromSearch.comboNrOfPeople,
                  autoCamper.getNumberOfPeople())))
            {
               fromSearch.comboNrOfPeople.addItem(autoCamper
                     .getNumberOfPeople());
            }
            if (!(checkForDoublication(fromSearch.comboExtSize,
                  autoCamper.getSizeSpecifications())))
            {
               fromSearch.comboExtSize.addItem(autoCamper
                     .getSizeSpecifications());
            }
            if (!(checkForDoublication(fromSearch.comboRefregerator,
                  autoCamper.isRefrigerator())))
            {
               fromSearch.comboRefregerator
                     .addItem(autoCamper.isRefrigerator());
            }
            if (!(checkForDoublication(fromSearch.comboTv, autoCamper.isTv())))
            {
               fromSearch.comboTv.addItem(autoCamper.isTv());
            }
            if (!(checkForDoublication(fromSearch.comboHeatedWater,
                  autoCamper.isHeatedWater())))
            {
               fromSearch.comboHeatedWater.addItem(autoCamper.isHeatedWater());
            }
            if (!(checkForDoublication(fromSearch.comboBattery,
                  autoCamper.getBatterySize())))
            {
               fromSearch.comboBattery.addItem(autoCamper.getBatterySize());
            }
            if (!(checkForDoublication(fromSearch.comboBatteryCharger,
                  autoCamper.getBatteryChatger())))
            {
               fromSearch.comboBatteryCharger.addItem(autoCamper
                     .getBatteryChatger());
            }
            if (!(checkForDoublication(fromSearch.comboGenerator,
                  autoCamper.isGenerator())))
            {
               fromSearch.comboGenerator.addItem(autoCamper.isGenerator());
            }
            if (!(checkForDoublication(fromSearch.comboBicicleStand,
                  autoCamper.isBicycleStand())))
            {
               fromSearch.comboBicicleStand
                     .addItem(autoCamper.isBicycleStand());
            }
            if (!(checkForDoublication(fromSearch.comboNumberOfBeds,
                  autoCamper.getNumberOfBeds())))
            {
               fromSearch.comboNumberOfBeds.addItem(autoCamper
                     .getNumberOfBeds());
            }
            if (!(checkForDoublication(fromSearch.comboMicrowave,
                  autoCamper.isMicrowave())))
            {
               fromSearch.comboMicrowave.addItem(autoCamper.isMicrowave());
            }
            if (!(checkForDoublication(fromSearch.comboRoofHatch,
                  autoCamper.isRoofHatch())))
            {
               fromSearch.comboRoofHatch.addItem(autoCamper.isRoofHatch());
            }
            // *****************************************************************

         }

      }

   }

   // ***************New********
   public void yearHasChanged(String yearCombo, JComboBox<String> month)
   {
      month.removeAllItems();
      if (!(yearCombo.equals("any")))
      {
         int year = Integer.parseInt(yearCombo);

         if (year == startDate.getYear())
         {
            for (int i = startDate.getMonth(); i <= 12; i++)
            {
               if (!(checkForDoublication(month, (i + ""))))
               {
                  month.addItem(i + "");
               }

            }
         }
         else if (year == endDate.getYear())
         {

            for (int i = 1; i <= endDate.getMonth(); i++)
            {
               if (!(checkForDoublication(month, (i + ""))))
               {
                  month.addItem(i + "");
               }
            }
         }

      }
      else
      {
         month.addItem("any");
      }
   }

   public void setBacktoAny()
   {
      fromSearch.getComboStartYear().setSelectedIndex(0);
      fromSearch.getComboStartMonth().setSelectedIndex(0);
      fromSearch.getComboStartDay().setSelectedIndex(0);
      fromSearch.getComboEndYear().setSelectedIndex(0);

   }

   public void monthHasChanged(String yearCombo, String monthCombo,
         JComboBox<String> day)
   {
      day.removeAllItems();
      if ((monthCombo != null))
      {
         if (!(monthCombo.equals("any")))
         {

            int month = Integer.parseInt(monthCombo);
            int year = Integer.parseInt(yearCombo);

            if (year == startDate.getYear() && month == startDate.getMonth())
            {
               MyDate tempdate = startDate.copy();
               // System.out.println(tempdate.daysInMonth());
               while (tempdate.getDay() < tempdate.daysInMonth())
               {
                  // System.out.println(tempdate.getDay());
                  // System.out.println("Here");
                  if (!(checkForDoublication(day, (tempdate.getDay() + ""))))
                  {
                     day.addItem(tempdate.getDay() + "");
                  }
                  tempdate.nextDay();
               }
               day.addItem(tempdate.getDay() + "");
            }
            else if (year == endDate.getYear() && month == endDate.getMonth())
            {
               MyDate tempdate = new MyDate(1, endDate.getMonth(),
                     endDate.getYear());
               while (tempdate.getDay() < endDate.getDay())
               {
                  if (!(checkForDoublication(day, (tempdate.getDay() + ""))))
                  {
                     day.addItem(tempdate.getDay() + "");
                  }
                  tempdate.nextDay();
               }
               day.addItem(tempdate.getDay() + "");
            }
            else
            {
               MyDate tempdate = new MyDate(1, month, year);
               while (tempdate.getDay() < tempdate.daysInMonth())
               {
                  if (!(checkForDoublication(day, (tempdate.getDay() + ""))))
                  {
                     day.addItem(tempdate.getDay() + "");
                  }
                  tempdate.nextDay();
               }
               day.addItem(tempdate.getDay() + "");
            }

         }
         else
         {
            day.addItem("any");
         }
      }
   }

   public int getNumOfDays(String startYearcombo, String startMonthcombo,
         String startDaycombo, String endYearcombo, String endMonthcombo,
         String endDaycombo)
   {
      if (!(startYearcombo == null && startMonthcombo == null
            && startDaycombo == null && endYearcombo == null
            && endMonthcombo == null && endDaycombo == null))
      {
         if (!(startYearcombo.equals("any") && startMonthcombo.equals("any")
               && startDaycombo.equals("any") && endYearcombo.equals("any")
               && endMonthcombo.equals("any") && endDaycombo.equals("any")))
         {
            int startYear = Integer.parseInt(startYearcombo);
            int startMonth = Integer.parseInt(startMonthcombo);
            int startDay = Integer.parseInt(startDaycombo);
            int endYear = Integer.parseInt(endYearcombo);
            int endMonth = Integer.parseInt(endMonthcombo);
            int endDay = Integer.parseInt(endDaycombo);

            MyDate startDate = new MyDate(startDay, startMonth, startYear);
            MyDate endDate = new MyDate(endDay, endMonth, endYear);
            // System.out.println("Start *****: "+startDate.getDay()+"/"+startDate.getMonth());
            // System.out.println("End:   "+endDate.getDay());
            if (startDate.isBefore(endDate))// only if start date is before end
                                            // date
            {

               MyDate tempdate = startDate.copy();
               int numOfDays = 0;
               while (tempdate.isBefore(endDate))
               {
                  numOfDays++;
                  tempdate.nextDay();
               }
               System.out.println("return statement Number of Days:    "
                     + numOfDays);
               return numOfDays;
            }
            else

               return 0;
         }
         else

            return 0;
      }

      return 0;

   }
}
