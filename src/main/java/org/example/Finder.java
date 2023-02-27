package org.example;




import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Finder {
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

            JSONArray students = (JSONArray) JObj.get("students");

            List<String> list = new ArrayList<>();

            String response = "Студент не найден";

            for (Object st: students){
                JSONObject student = (JSONObject) st;


                String nameStudent = (String) student.get("name");
                Long IDStudent = (Long) student.get("id");

                Student S = new Student(IDStudent, nameStudent);
                if (S.id.equals(ID)) {
                    response = "Студент найден! " + S.name;
                    break;
                }
                list.add(S.getName());

            }

            System.out.println(response);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return "";
    }



   }


