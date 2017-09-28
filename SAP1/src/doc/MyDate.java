package doc;


import java.io.Serializable;
import java.util.GregorianCalendar;
/**
 * 
 * Creating date object 
 *
 */
public class MyDate implements Serializable
{

   private int day;
   private int month;
   private int year;

   public MyDate()
   {
      MyDate today = today();

      day = today.day;
      month = today.month;
      year = today.year;

   }
   /**
    * initiate the created date to the giving date
    * @param date obj
    */
   public MyDate(MyDate obj)
   {
      day = obj.day;
      month = obj.month;
      year = obj.year;
   }

   public int getDay()
   {
      return day;
   }

   public int getMonth()
   {
      return month;
   }

   public int getYear()
   {
      return year;
   }
   /**
    * initiate the date to the given parameters
    * @param day
    * @param month
    * @param year
    */
   public MyDate(int day, int month, int year)
   {
      if (year > 0 && year < 3000)
      {
         this.year = year;
         if (month > 0 && month < 13)
         {
            this.month = month;
            if (day > 0 && day <= daysInMonth())//////////////////////////////NEWNEWNEWNEWNEW
            {
               this.day = day;

            }
            else
            {
               this.day=28;
               throw new IllegalDateException();

            }
         }
         else
         {
            throw new IllegalDateException();

         }
      }
      else
      {
         throw new IllegalDateException();

      }
   }

   public void setDay(int d)
   {
      day = d;
   }

   public void setMonth(int m)
   {

      month = m;
   }

   public void setYear(int y)
   {
      year = y;
   }
   /**
    * customize the displaying of the date
    * @return String of date formatted
    */
   public String displayDate()
   {
      return day + "/" + month + "/" + year;
   }
   /**
    * checks if the year is leap
    * @return boolean
    */
   public boolean isLeapYear()
   {
      if (year % 4 == 0)
      {

         if (year % 100 == 0)
         {
            if (year % 400 == 0)
            {
               return true;
            }
            else
               return false;
         }
         else
         {
            return true;
         }

      }
      else
      {
         return false;
      }
   }
   /**
    * calculate how many day in that month
    * @return days in month
    */
   public int daysInMonth()
   {
      int numOfDays;
      if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
            || month == 10 || month == 12)
      {
         numOfDays = 31;
         return numOfDays;
      }
      else if (month == 4 || month == 6 || month == 9 || month == 11)
      {
         numOfDays = 30;
         return numOfDays;
      }
      else if (month == 2 && isLeapYear())
      {
         numOfDays = 29;
         return numOfDays;
      }
      else if (month == 2 && !(isLeapYear()))
      {
         numOfDays = 28;
         return numOfDays;
      }
      else
         return 0;

   }
   /**
    * gives the AstroSign
    * @return AstroSign
    */
   public String getAstroSign()
   {
      if ((month == 3 && day >= 21) || (month == 4 && day <= 19))
      {
         return "Aries";
      }
      else if ((month == 4 && day >= 20) || (month == 5 && day <= 20))
      {
         return "Taurus";
      }
      else if ((month == 5 && day >= 21) || (month == 6 && day <= 20))
      {
         return "Gemini";
      }
      else if ((month == 6 && day >= 21) || (month == 7 && day <= 22))
      {
         return "Cancer";
      }
      else if ((month == 7 && day >= 23) || (month == 8 && day <= 22))
      {
         return "Leo";
      }
      else if ((month == 8 && day >= 23) || (month == 9 && day <= 22))
      {
         return "Virgo";
      }
      else if ((month == 9 && day >= 23) || (month == 10 && day <= 22))
      {
         return "Libra";
      }
      else if ((month == 10 && day >= 23) || (month == 11 && day <= 21))
      {
         return "Scorpio";
      }
      else if ((month == 11 && day >= 22) || (month == 12 && day <= 21))
      {
         return "Sagittarius";
      }
      else if ((month == 12 && day >= 22) || (month == 1 && day <= 19))
      {
         return "Capricorn";
      }
      else if ((month == 1 && day >= 20) || (month == 2 && day <= 18))
      {
         return "Aquarius";
      }
      else if ((month == 2 && day >= 19) || (month == 3 && day <= 20))
      {
         return "Pisces";
      }
      else
         return "Error";

   }
   /**
    * calculate which day of the week is it
    * @return day of the week
    */
   public String dayOfWeek()
   {
      int q = day;
      int m = month;
      int y = year;
      if (month == 1 || month == 2)
      {
         y -= 1;
         m += 12;
      }
      int k = y % 100;
      int j = y / 100;
      int result;
      result = ((q) + (13 * (m + 1) / 5) + k + (k / 4) + (j / 4) + (5 * j)) % 7;
      if (result == 0)
         return "Saturday";
      else if (result == 1)
         return "Sunday";
      else if (result == 2)
         return "Monday";
      else if (result == 3)
         return "Tuesday";
      else if (result == 4)
         return "Wednesday";
      else if (result == 5)
         return "Thursday";
      else if (result == 6)
         return "Friday";
      else
         return "Error";

   }
   /**
    * 
    * @return month name
    */
   public String getMonthName()
   {
      switch (month)
      {
         case 1:
            return "January";
         case 2:
            return "February";
         case 3:
            return "March";
         case 4:
            return "April";
         case 5:
            return "May";
         case 6:
            return "June";
         case 7:
            return "July";
         case 8:
            return "August";
         case 9:
            return "September";
         case 10:
            return "October";
         case 11:
            return "November";
         case 12:
            return "December";
         default:
            return "Error";

      }
   }
   /**
    * add number of  days to give date
    * @param how many days to add 
    */
   public void nextDay(int days)
   {

      for (int i = 1; i <= days; i++)
      {
         nextDay();
      }

   }
   /**
    * add number one day to give date
    * 
    */
   public void nextDay()
   {
      day++;
      if (day > daysInMonth())
      {
         month++;
         day = 1;

         if (month > 12)
         {
            month = 1;
            year++;
         }

      }

      /*
       * else if(month>12){ year++; month=1; day=1; }
       */
   }
   /**
    * check if two date is equal
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof MyDate))
      {
         return false;
      }
      MyDate other = (MyDate) obj;
      return day == other.day && month == other.month && year == other.year;

   }
   /**
    * copy a date object
    * @return copy of the date
    */
   public MyDate copy()
   {
      return new MyDate(day, month, year);
   }
   /**
    * gives today's date
    * @return today's date
    */
   public static MyDate today()
   {
      GregorianCalendar currentDate = new GregorianCalendar();
      int currentDay = currentDate.get(GregorianCalendar.DATE);
      int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
      int currentYear = currentDate.get(GregorianCalendar.YEAR);
      System.out.println(currentDay+" "+currentMonth+" "+ currentYear);
      MyDate today = new MyDate(currentDay, currentMonth, currentYear);
      return today;
   }
   /**
    * check if date1 is before date 2
    * @param date2
    * @return boolean
    */
   public boolean isBefore(MyDate date2)
   {
      if(year>date2.year)
      {
         return false;
      }
      else if (year==date2.year)
      {
         if(month<date2.month)
         {
            return true;
         }
         else if (month==date2.month)
         {
            if(day<date2.day)
            {
               return true;
            }
            else
            {
               return false;
            }
         }
         else
         {
            return false;
         }
      }
      else if(year<date2.year)
      {
         return true;
      }
      else
      {
         return false;
      }
   }

   public String toString()
   {
      return "\nthis is toString statement" + "The RESULT " + day + "/" + month
            + "/" + year + "\nLeap Year check=  " + isLeapYear()
            + "\nNumber of days in the month: " + daysInMonth()
            + "\nThe Astrological Sign: " + getAstroSign()
            + "\nThe day of the week is: " + dayOfWeek()
            + "\nThe month name  is: " + getMonthName();
   }
}