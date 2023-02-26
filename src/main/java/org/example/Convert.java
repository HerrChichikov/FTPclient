package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class Convert {
    private static final String TAG_STUDENT = "students";
    private static final String TAG_ID_STUDENT = "id";
    private static final String TAG_NAME_STUDENT = "name";
    String Convert() throws IOException, ParseException {

        Terminal file = new Terminal();

        ObjectMapper mapper = new ObjectMapper();
        JSONParser parser = new JSONParser();


        FileReader reader = new FileReader(file.getFile());

        JSONObject JObj = (JSONObject) parser.parse(reader);

            JSONArray studentsJSON = (JSONArray) JObj.get("students");

        List<Student> listToUp = new ArrayList<>();

            for (Object st : studentsJSON) {

                JSONObject student = (JSONObject) st;


                String nameStudent = (String) student.get("name");
                Long IDStudent = (Long) student.get("id");

                Student S = new Student(IDStudent, nameStudent);

                listToUp.add(S);

            }


        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя нового студента: ");
        String name = (in.nextLine());
        Parser count = new Parser();
        Student stud = new Student((long) count.count()+1, name);

        listToUp.add(stud);

      //  mapper.writeValue(new File(file.getFile()), listToUp);

        studentsJSON.clear();

        studentsJSON.add(listToUp);
        JObj.clear();
        JObj.put("students", listToUp);



       // String UpToStud = mapper.writeValueAsString(listToUp);

        mapper.writeValue(new File(file.getFile()), JObj);

        return "";
    }}
