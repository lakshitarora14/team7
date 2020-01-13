package com.training.teamseven.controller;
import com.training.teamseven.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@RestController
@RequestMapping("/employee")
public class CsvController {
//    @Override
    @GetMapping("csv")
    public  void read() {
        String csvFile = "/Users/lakshitarora/Downloads/employee.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] c = line.split(cvsSplitBy);
                double exp = new Double(c[3]);

                Date date = new SimpleDateFormat("MM/dd/yy").parse(c[2]);
                Employee e = new Employee(c[0], c[1], date, exp);
//                    MyCollection.add(e);
                System.out.println(e);
            }
//                System.out.println(MyCollection.writeCounter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

//        @Override
//        public  void write() throws IOException, ClassNotFoundException, SQLException {
//            Class.forName(“org.postgresql.Driver”);
//            Connection connection=DriverManager.getConnection(“jdbc:postgresql://localhost:5432/myprojectdb”,“training”,“training”);
//            Statement statement=connection.createStatement();
//            for(int i=0;i<100;i++) {
//                Employee e = MyCollection.get();
//                DateFormat dateFormat = new SimpleDateFormat(“MM/dd/yy”);
//                String strDate = dateFormat.format(e.getDateOfBirth());
//                statement.executeUpdate(“insert into employee(first_name,last_name,dob,experience) values(‘” + e.getFirstName() + “‘,’” + e.getLastName() + “‘,’” + strDate + “‘,’” + String.valueOf(e.getExperience()) + “’)“);
//            }
//            statement.close();
//            connection.close();
//            System.out.println(MyCollection.readCounter);

