package com.first;
import java.sql.*;


public class temp {

    public static void main(String[] args) throws SQLException {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learnmysql", "root", "12345678");

        CallableStatement stmt=con.prepareCall("{? = call getMaxSalary()}");
        stmt.registerOutParameter(1,Types.INTEGER);

        stmt.execute();
        System.out.println("Max Salary: " + stmt.getInt(1)); // Max Salary: 10
    }
}
