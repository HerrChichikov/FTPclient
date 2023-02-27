package org.example;




import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Deleter {
    Terminal file = new Terminal();

    private static final String TAG_STUDENT = "students";
    private static final String TAG_ID_STUDENT = "id";
    private static final String TAG_NAME_STUDENT = "name";

    public Object parse() throws IOException, ParseException {
        ObjectMapper mapper = new ObjectMapper();
        JSONParser parser = new JSONParser();

        Scanner in = new Scanner(System.in);
        System.out.println("Введите ID студента: ");
        Long ID = Long.valueOf((in.nextLine()));

        try(FileReader reader = new FileReader(file.getFile())){

            JSONObject JObj = (JSONObject) parser.parse(reader);

            JSONArray studentsJSON = (JSONArray) JObj.get("students");


            List<Student> listToUp = new ArrayList<>();

            for (Object st : studentsJSON) {

                JSONObject student = (JSONObject) st;

                String nameStudent = (String) student.get("name");
                Long IDStudent = (Long) student.get("id");

                if (!ID.equals(IDStudent)){



                    Student S = new Student(IDStudent, nameStudent);

                    listToUp.add(S);
                }

            }



            JObj.clear();
            studentsJSON.clear();
            studentsJSON.add(listToUp);

            JObj.put("students", listToUp);

            mapper.writeValue(new File(file.getFile()), JObj);

        } catch (Exception e) {
            e.printStackTrace();
        }




        return "";
    }



}


