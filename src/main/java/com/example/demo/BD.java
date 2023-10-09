package com.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BD {
    public BD() {
    }
    String error_register = "No se pudo registrar el empleado";
    String error_leader = "No se pudo registrar el lider";
    String error_department = "No se pudo registrar el empleado en la tabla departamento";
    String error_update = "No se encontro el empleado para actualizar";

    public Users Register(String code, String name, String code_leader, String responsibility) {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/registerbd";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            // Sentencia INSERT
            String sql = "INSERT INTO users (code , name, code_leader, responsibility) VALUES (?, ?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, code_leader);
            preparedStatement.setString(4, responsibility);

            // Ejecutar la sentencia
            int files = preparedStatement.executeUpdate();

            if (files > 0) {
                System.out.println("Empleado registrado de manera exitosa.");
                return new Users(code, name, code_leader, responsibility);
            } else {
                System.out.println(error_register);
            }

            preparedStatement.close();
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Users(null, null, null, null);
    }


    public leader Register_Leader(String code, String name, String cod_department, String hiring_date) {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/registerbd";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM leader");

            // Sentencia INSERT
            String sql = "INSERT INTO leader (code , name, cod_department, hiring_date) VALUES (?, ?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, cod_department);
            preparedStatement.setString(4, hiring_date);

            // Ejecutar la sentencia
            int files = preparedStatement.executeUpdate();

            if (files > 0) {
                System.out.println("Empleado registrado de manera exitosa.");
                return new leader(code, name, cod_department, hiring_date);
            } else {
                System.out.println(error_leader);
            }

            preparedStatement.close();
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new leader(null, null, null, null);
    }

    public department Register_department(String code, String name, String area) {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/registerbd";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM leader");

            // Sentencia INSERT
            String sql = "INSERT INTO department (code , name, area) VALUES (?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, area);

            // Ejecutar la sentencia
            int files = preparedStatement.executeUpdate();

            if (files > 0) {
                System.out.println("Empleado registrado de manera exitosa.");
                return new department(code, name, area);
            } else {
                System.out.println(error_department);
            }

            preparedStatement.close();
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new department(null, null, null);
    }

    public Users Edit(String code, String name, String code_leader, String responsibility) throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/registerbd";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        String consult = "UPDATE users SET name = ?, code_leader = ?, responsibility = ? WHERE code = ?";

        PreparedStatement preparedStatement = connection2.prepareStatement(consult);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, code_leader);
        preparedStatement.setString(3, responsibility);
        preparedStatement.setString(4, code);

        int files = preparedStatement.executeUpdate();
        if (files > 0) {
            System.out.println("Operador actualizado de manera exitosa");
            return new Users(code, name, code_leader, responsibility);
        } else {
            System.out.println(error_update);
        }
        preparedStatement.close();
        connection2.close();
        return new Users(null, null, null, null);
    }

    public List<Users> Search_all() throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/registerbd";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM users");

        List<Users> list = new ArrayList<>();

        while (resultSet2.next()) {
            String code = resultSet2.getString("code");
            String name = resultSet2.getString("name");
            String code_leader = resultSet2.getString("code_leader");
            String responsibility = resultSet2.getString("responsibility");
            if (code_leader.equals("2598") || code_leader.equals("1547")){
                Users users = new Users(code, name, code_leader, responsibility);
                list.add(users);
            }
        }
        return list;
    }

    public static String Select_Leader(String code_leader) throws ClassNotFoundException, SQLException {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/registerbd";
        String username = "root";
        String password = "";

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String consult_SQL = "SELECT * FROM leader WHERE code = ?";

        PreparedStatement statement = connection.prepareStatement(consult_SQL);
        statement.setString(1, code_leader); // Establecer el valor del parámetro

        // Ejecutar la consulta
        ResultSet resultSet2 = statement.executeQuery();

        // Procesar el resultado si existe
        if (resultSet2.next()) {

            String cod_department = resultSet2.getString("cod_department");

            return cod_department;
        }
        // Cerrar recursos
        resultSet2.close();
        statement.close();
        connection.close();

        return "";
    }

    public String Select_department(String cod_department) throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/registerbd";
        String username = "root";
        String password = "";

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String consult_SQL = "SELECT * FROM department WHERE code = ?";

        PreparedStatement statement = connection.prepareStatement(consult_SQL);
        statement.setString(1, cod_department); // Establecer el valor del parámetro

        // Ejecutar la consulta
        ResultSet resultSet2 = statement.executeQuery();

        // Procesar el resultado si existe
        if (resultSet2.next()) {

            String name = resultSet2.getString("name");

            return name;
        }
        // Cerrar recursos
        resultSet2.close();
        statement.close();
        connection.close();

        return "";
    }
}




