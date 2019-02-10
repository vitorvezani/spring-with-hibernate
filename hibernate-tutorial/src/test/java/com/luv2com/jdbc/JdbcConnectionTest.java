package com.luv2com.jdbc;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class JdbcConnectionTest {

  @Test
  void testConnection() throws SQLException {

    String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSLL=false";
    String user = "hbstudent";
    String pass = "hbstudent";

    Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
    System.out.println("Connection Successfull!");

  }

  @Test
  void testConnectionFail() throws SQLException {

    String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSLL=false";
    String user = "hbstudent";
    String pass = "hbstudentz";

    Executable exec = () -> DriverManager.getConnection(jdbcUrl, user, pass);
    assertThrows(SQLException.class, exec, "a message");
  }

}
