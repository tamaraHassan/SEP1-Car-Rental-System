package doc;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ui.PopulateComboBoxes;
import ui.SearchButtonListener;
import ui.SearchPage;
/**
 * 
 * Class to return a vehicle
 *
 */
public class ReturnVehicle implements Serializable
{
	private static String km;
	private static double price;
	private static int oldKM;
	private static int newKM;
	private static int kmDriven;
	private static int numberOfDays;
	private static int extraKM;
	
	private String startDay;
	private String startMonth;
	private String startYear;
	private String endDay;
	private String endMonth;
	private String endYear;
	
	private static int tempInt;
	
	private Booking booking;

	
	private ReturnVehiclePage returnVehiclePage;
	
	private AddBooking addBooking;
	
	public class ReturnVehiclePage
	{
	}
	/**
	 * constructor to initialize the class 
	 * @param booking
	 * @param returnPopUpPanel
	 */
	public ReturnVehicle(Booking booking, JPanel returnPopUpPanel)
	{
		this.booking = booking;
		this.returnVehiclePage = returnVehiclePage;
	}
	/**
	 * validate for KM on at the time of return
	 * @param kmFromInput
	 * @return number of errors 
	 */
	public static int checkKm(String kmFromInput)
	{
		int errors = 0;
		if(kmFromInput.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Please fill in the number of km.",
					"Wrong number of km...",JOptionPane.PLAIN_MESSAGE);
					errors++;
		}
		else
		{
			try
			{
				tempInt = Integer.parseInt(kmFromInput);
			}
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null,"Please insert a valid number without coma",
						"Wrong number of km...",JOptionPane.PLAIN_MESSAGE);
				errors++;
			}
		}
		return errors;
	}
	
	/*public void returnVehicle()
	{
		if(checkKm() == 0)
		{
			booking.getVehicle().setNumberOfKm(km);
			bookingList.removeBooking(booking);
		}
	}*/
	/**
	 * calculate the extra price if vehicle driven more that it should
	 * @param kmFromInput
	 * @param booking
	 * @return extra price to be paid
	 */
	public static double calculatePrice(String kmFromInput, Booking booking)
	{
		if(checkKm(kmFromInput)==0){
		oldKM = Integer.parseInt(booking.getVehicle().getNumberOfKm());
		//booking.getVehicle().setNumberOfKm(km);
		newKM = Integer.parseInt(kmFromInput);
		kmDriven = newKM - oldKM;
		
		numberOfDays = getNumOfDays( (String)(booking.getStartDate().getYear()+""), (String)(booking.getStartDate().getMonth()+""),(String)(booking.getStartDate().getDay()+""),
				 (String)(booking.getEndDate().getYear()+""), (String)(booking.getEndDate().getMonth()+""),(String)(booking.getEndDate().getDay()+""));
		extraKM = kmDriven - (numberOfDays*100);
		
		if(extraKM > 0)
		{
			if(numberOfDays>2){
				price= (extraKM/100)*(Double.parseDouble(booking.getVehicle().getPrice()))-((extraKM/100)*(Double.parseDouble(booking.getVehicle().getPrice()))*0.3);
			}
			else{
			price= (extraKM/100)*(Double.parseDouble(booking.getVehicle().getPrice()));
			}
		}
		else if(extraKM <= 0)
		{
			price = 0;
		}
		return price;
	}
	
	else{
		return 0;
	}}
	/**
	 * get the number of days a vehicle is booked for
	 * @param startYearcombo
	 * @param startMonthcombo
	 * @param startDaycombo
	 * @param endYearcombo
	 * @param endMonthcombo
	 * @param endDaycombo
	 * @return calculated number of days
	 */
	public static int getNumOfDays(String startYearcombo, String startMonthcombo,
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
