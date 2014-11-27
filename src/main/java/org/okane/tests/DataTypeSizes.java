package org.okane.tests;
import static java.lang.System.out;
import java.lang.reflect.Field;

/**
 * Demonstrate JDK 8's easy programmatic access to size of basic Java data types.
 */
public class DataTypeSizes
{
   /**
    * Print values of certain fields (assumed to be constant) for provided class.
    * The fields that are printed are SIZE, BYTES, MIN_VALUE, and MAX_VALUE.
    * 
    * @param clazz Class which may have static fields SIZE, BYTES, MIN_VALUE,
    *    and/or MAX_VALUE whose values will be written to standard output.
    */
   private static void printDataTypeDetails(final Class<? extends Object> clazz)
   {
      out.println("\nDatatype (Class): " + clazz.getCanonicalName() + ":");
      final Field[] fields = clazz.getDeclaredFields();
      for (final Field field : fields)
      {
         final String fieldName = field.getName();
         try  
         {
            switch (fieldName)
            {
               case "SIZE" :  // generally introduced with 1.5 (twos complement)
                  out.println("\tSize (in bits):  " + field.get(null));
                  break;
               case "BYTES" : // generally introduced with 1.8 (twos complement)
                  out.println("\tSize (in bytes): " + field.get(null));
                  break;
               case "MIN_VALUE" :
                  out.println("\tMinimum Value:   " + field.get(null));
                  break;
               case "MAX_VALUE" :
                  out.println("\tMaximum Value:   " + field.get(null));
                  break;
               default :
                  break;
            }
         }
         catch (IllegalAccessException illegalAccess)
         {
            out.println("ERROR: Unable to reflect on field " + fieldName);
         }
      }
   }

   /**
    * Demonstrate JDK 8's ability to easily programmatically access the size of
    * basic Java data types.
    * 
    * @param arguments Command-line arguments: none expected.
    */
   public static void main(final String[] arguments)
   {
      printDataTypeDetails(Byte.class);
      printDataTypeDetails(Short.class);
      printDataTypeDetails(Integer.class);
      printDataTypeDetails(Long.class);
      printDataTypeDetails(Float.class);
      printDataTypeDetails(Double.class);
      printDataTypeDetails(Character.class);
      printDataTypeDetails(Boolean.class);
   }
}