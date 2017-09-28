package doc;

import java.io.Serializable;

/**
 * Illegad Date Exception
 *
 *
 */
public class IllegalDateException extends RuntimeException implements Serializable
{
   public IllegalDateException()
   {
      super("Invalid Date");
   }

   public IllegalDateException(String msg)
   {
      super("Invalid Date: " + msg);
   }

}
