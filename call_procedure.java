package com.first;
import java.sql.*;

public class temp {

    public static void main(String[] args) throws SQLException {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learnmysql", "root", "12345678");

        int salary = 4;
        CallableStatement stmt=con.prepareCall("{call emp_pr_2(?, ?)}");
        stmt.setInt(1, salary);
        stmt.registerOutParameter(1,Types.INTEGER);
        stmt.registerOutParameter(2,Types.CHAR);

        stmt.execute();
        System.out.println("Salary: " + stmt.getInt(1) + "    Country: " + stmt.getString(2));
    }
}
