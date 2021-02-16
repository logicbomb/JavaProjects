package com.rukon.Steams;

import java.sql.*;

public class Main {
    public static final String connectionUrl = "jdbc:sqlserver://it-sql17-s-dsl:1433;databaseName=DWReporting;user=BoomiLocal;password=4OzIl2qQ6iiMK4LF@";
    public static void main(String[] args) throws Exception {
       //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");


        try (Connection con = DriverManager.getConnection(connectionUrl);) {


            String SQL = "SELECT TOP 100 * FROM xStudentNameAddress where Student = ?";
            System.out.println(SQL.hashCode());

            PreparedStatement preparedStatement = con.prepareStatement(SQL);
            preparedStatement.setString(1, "0000694249");
            ResultSet rs = preparedStatement.executeQuery();
            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("Student") + " " + rs.getString("DisplayFirstName") + " " + rs.getString("DisplayLastName"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }





    }
}
