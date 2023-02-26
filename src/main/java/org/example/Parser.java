package org.example;




import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parser {
    Terminal file = new Terminal();
    private static int count = 0;
    private static final String TAG_STUDENT = "students";
    private static final String TAG_ID_STUDENT = "id";
    private static final String TAG_NAME_STUDENT = "name";

    public Object parse() throws FileNotFoundException {

        ObjectMapper mapper = new ObjectMapper();
        JSONParser parser = new JSONParser();

        try(FileReader reader = new FileReader(file.getFile())){

            JSONObject JObj = (JSONObject) parser.parse(reader);

            JSONArray students = (JSONArray) JObj.get("students");

            List<String> list = new ArrayList<>();

            for (Object st: students){
                count += 1;
                JSONObject student = (JSONObject) st;


                String nameStudent = (String) student.get("name");
                Long IDStudent = (Long) student.get("id");

                Student S = new Student(IDStudent, nameStudent);

                list.add(S.getName());
                Collections.sort(list);

            }

            String jsonStudent = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);

            System.out.println("Список студентов по имени: " + jsonStudent);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return "";
    }

    int count(){
        return count;
    }

public String listToUp() throws FileNotFoundException {

    ObjectMapper mapper = new ObjectMapper();
    JSONParser parser = new JSONParser();

    try(FileReader reader = new FileReader(file.getFile())){

        JSONObject JObj = (JSONObject) parser.parse(reader);

        JSONArray students = (JSONArray) JObj.get("students");

        List<Student> listToUp = new ArrayList<>();

        for (Object st: students){

            JSONObject student = (JSONObject) st;


            String nameStudent = (String) student.get("name");
            Long IDStudent = (Long) student.get("id");

            Student S = new Student(IDStudent, nameStudent);

            listToUp.add(S);


        }

       // String jsonStudent = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listToUp);



    } catch (Exception e) {
        e.printStackTrace();
    }


    return "";
}}


