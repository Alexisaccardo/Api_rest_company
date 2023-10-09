package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class Controlador {

    String error_leader = "el codigo especificado para lider, no existe";
    String error_department = "No existe un departamento con el codigo ingresado";

    @PostMapping("/register_users")
    public Users register_users(@RequestBody Users users) throws SQLException, ClassNotFoundException {

        String code = users.getCode();
        String name = users.getName();
        String code_leader = users.getCode_leader();
        String responsibility = users.getResponsibility();

        if (code == null || code.equals("") || code.length() < 0 || name == null || name.equals("") || name.length() < 0 ||
                code_leader == null || code_leader.equals("") || code_leader.length() < 0 || responsibility == null || responsibility.equals("") ||
                responsibility.length() < 0) {

            return new Users(null, null, null, null);
        } else {
            BD bd = new BD();
            String cod_department = bd.Select_Leader(code_leader);
            String department = bd.Select_department(cod_department);
            if (cod_department.equals("") || department.equals("")) {
                return new Users(null, null, error_leader, null);
            } else {
                users = bd.Register(code, name, code_leader, responsibility);
            }
        }
        return users;
    }

    @PostMapping("/edit")
    public Users edit(@RequestBody Users users) throws SQLException, ClassNotFoundException {

        String code = users.getCode();
        String name = users.getName();
        String code_leader = users.getCode_leader();
        String responsibility = users.getResponsibility();

        if (code == null || code.equals("") || code.length() < 0 || name == null || name.equals("") || name.length() < 0 ||
                code_leader == null || code_leader.equals("") || code_leader.length() < 0 || responsibility == null || responsibility.equals("") ||
                responsibility.length() < 0) {

            return new Users(null, null, null, null);
        } else {
            BD bd = new BD();
            String cod_department = bd.Select_Leader(code_leader);
            String department = bd.Select_department(cod_department);
            if (cod_department.equals("") && department.equals("")) {
                return new Users(null, null, error_leader, null);
            } else {
                users = bd.Edit(code, name, code_leader, responsibility);
            }
        }
        return users;
    }

    @GetMapping("/search")
    public List<Users> search() throws SQLException, ClassNotFoundException {
        BD bd = new BD();
        List<Users> list = bd.Search_all();

        return list;
    }


    @PostMapping("/register_leader")
    public leader register_leader(@RequestBody leader leader) throws SQLException, ClassNotFoundException {

        String code = leader.getCode();
        String name = leader.getName();
        String cod_department = leader.getCod_department();
        String hiring_date = leader.getHiring_date();

        if (code == null || code.equals("") || code.length() < 0 || name == null || name.equals("") || name.length() < 0 ||
                cod_department == null || cod_department.equals("") || cod_department.length() < 0 || hiring_date == null ||
                hiring_date.equals("") || hiring_date.length() < 0) {

            return new leader(null, null, null, null);
        } else {
            BD bd = new BD();
            String department = bd.Select_department(cod_department);
            if (department.equals("")) {
                return new leader(null, null, error_department, null);
            } else {
                leader = bd.Register_Leader(code, name, cod_department, hiring_date);
            }
        }
        return leader;
    }


    @PostMapping("/register_department")
    public department register_department(@RequestBody department department) throws SQLException, ClassNotFoundException {

        String code = department.getCode();
        String name = department.getName();
        String area = department.getArea();

        if (code == null || code.equals("") || code.length() < 0 || name == null || name.equals("") || name.length() < 0 ||
                area == null || area.equals("") || area.length() < 0) {

            return new department(null, null, null);
        } else {
            BD bd = new BD();
            department = bd.Register_department(code, name, area);

        }
        return department;
    }


}


