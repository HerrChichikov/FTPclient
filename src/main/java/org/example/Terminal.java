package org.example;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Scanner;
public class Terminal {
    public static String file = null;

    static void terminal() throws IOException, ParseException {
        Scanner in = new Scanner(System.in);
        FtpClient N = new FtpClient();
        Parser parser = new Parser();


        String port = "21";
        String server = "localhost";
        String login = "max";
        String password = "1";



//        System.out.println("Введите порт: ");
//        String port = in.nextLine();
//
//        System.out.print("Введите сервер: ");
//        String server = in.nextLine();
//
//        System.out.print("Введите логин: ");
//        String login = in.nextLine();
//
//        System.out.print("Введите пароль: ");
//        String password = in.nextLine();
//
/*        System.out.print("Введите путь до файла (ftp://login@x.x.x.x/ + ваш ответ): ");
        String unload = ("ftp://" + login + "@" + server + "/" + in.nextLine());              */

//        System.out.print("Введите путь куда хотите скачать файл: (/home/ваше имя/Downloads/)"); Возможно даже не пригодится, если повезёт
//        String load = in.nextLine();

        System.out.print("Введите имя файла (ftp://login@x.x.x.x/ + ваш ответ): ");
        file = (in.nextLine());
        String unload = ("ftp://" + login + "@" + server + "/");


        N.setPort(Integer.parseInt(port));
        N.setServer(server);
        N.setUser(login);
        N.setPassword(password);
        N.open();

        try {
      N.downloadFile(file,file);


        } catch (IOException ex) {
           System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();}




        while (true) {
            System.out.println("Выберите пункт меню: \n" +
                    "1. Получение списка студентов по имени\n" +
                    "2. Получение информации о студенте по id \n" +
                    "3. Добавление студента ( id генерируется автоматически)\n" +
                    "4. Удаление студента по id\n" +
                    "5. Завершение работы");
            int num = in.nextInt();
            switch (num){
                case 1:
                    System.out.println("Ты нажал 1, молодец!");

                    System.out.println(parser.parse());

                    break;

                case 2:
                    System.out.println("Ты нажал 2, молодец!");

                    Finder finder = new Finder();

                    finder.parse();

                    break;

                case 3:
                    System.out.println("Ты нажал 3, молодец!");
                    Convert d = new Convert();
                    d.Convert();

                    break;

                case 4:
                    System.out.println("Ты нажал 4, молодец!");

                    Deleter deleter = new Deleter();
                    deleter.parse();

                    break;
                case 5:
                    System.out.println("Ты нажал 5, молодец! Пока!");
                    File file1 = new File(file);
                    N.putFileToPath(file1, file);
                    System. exit(0);

                    break;
            }
        }







}

    String getFile(){
        return file;
    }

}
