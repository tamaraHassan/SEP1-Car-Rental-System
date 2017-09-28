package doc;
import java.io.*;
import java.util.ArrayList;
/**
 * 
 * Creating a booking list
 *
 */
public class BookingList implements Serializable
{
	private ArrayList<Booking> bookings;
	
	/**
	 * No-argument constructor initializing the list
	 */
	public BookingList()
	{
		bookings = new ArrayList<Booking>();
	}
	/**
	 * add booking to the list
	 * @param booking
	 */
	public void addBooking(Booking booking)
	{
		bookings.add(booking);
	}
	/**
	 * removes a booking from the list
	 * @param booking
	 */
	public void removeBooking(Booking booking)
	{
		bookings.remove(booking);
	}
	/////////////////////NEW
	/**
	 * gives the size of the list
	 * @return size
	 */
	public int size(){
	   return bookings.size();
	}
	/**
	 * returns a booking at the requested index
	 * @param index
	 * @return booking
	 */
	public Booking get(int index)
   {
      if(index<bookings.size())
      {
         return bookings.get(index);
      }
      else
      {
         return null;
      }
   }
	
	/**
	 * add booking at required index
	 * @param index
	 * @param booking
	 */
	public void addBooking(int index, Booking booking)
	{
		bookings.add(index, booking);
	}	
	
	/**
	 * Search all the booking list for the last name of a customer
	 * @param lastName
	 * @return List of bookings under this last name
	 */
	public BookingList getBookingByLastName(String lastName)
	{
		BookingList temp= new BookingList();
		
		for(int i=0; i<bookings.size(); i++)
		{
			if(lastName.toLowerCase().equals(bookings.get(i).getCustomer().getLastName().toLowerCase()))
			{
				temp.addBooking(bookings.get(i));
			}
		}
		return temp;
	}
}
