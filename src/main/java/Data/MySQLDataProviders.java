package data;

import serviceClasses.MyConfig;
import org.testng.annotations.DataProvider;

import java.sql.*;

/**
 * MySQLDataProviders defines data providers for TestNG tests.
 *
 * @author Evgenii Iavorovich evgenii.iavorovich@qolsys.com
 */

public class MySQLDataProviders {


   /**
    * Method to get usernames data from database.
    * Returns two-dimensions array, each subarray contains node_port, adb_panel_id, adc_customer_id, adc_user_login, adc_user_password
    */
   @DataProvider
   public static Object[][] usernames() {

      String query = "select * from Credentials;";
      return getObjects(query);
   }

   private static Object[][] getObjects(String query) {
      Object[][] data = null;
      int rowCount = 0;
      int columnCount = 0;
      Connection connection;
      try {
         connection = MyConfig.getSQLConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query);
         ResultSetMetaData resultSet_metaData = resultSet.getMetaData();
         columnCount = resultSet_metaData.getColumnCount();
         while (resultSet.next()) {
            rowCount++;
         }
         data = new Object[rowCount][columnCount];
         resultSet.beforeFirst();
         for (int row = 0; row < rowCount; row++) {
            resultSet.next();
            for (int col = 1; col <= columnCount; col++)
               data[row][col - 1] = resultSet.getString(col);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return data;
   }


}
