package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу

        try {
            File your_file_name = File.createTempFile("1.txt", null);
            OutputStream outputStream = new FileOutputStream("1.txt");
            InputStream inputStream = new FileInputStream("1.txt");
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss", Locale.ENGLISH);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут


            User user1 = new User();
            user1.setFirstName("Artem");
            user1.setLastName("Khrolenko");
            user1.setBirthDate(dateFormat.parse("13.01.1988 10:12:10"));
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user1);

            User user2 = new User();
            user2.setFirstName("Max");
            user2.setLastName("Stepanko");
            user2.setBirthDate(dateFormat.parse("15.05.1998 22:34:11"));
            user2.setMale(false);
            user2.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            for (int i =0; i < loadedObject.users.size(); i++) {
                System.out.println(loadedObject.users.get(i).getFirstName());
                System.out.println(loadedObject.users.get(i).getLastName());
                System.out.println(loadedObject.users.get(i).getBirthDate());
                System.out.println(loadedObject.users.get(i).isMale());
                System.out.println(loadedObject.users.get(i).getCountry().getDisplayedName());
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss", Locale.ENGLISH);

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);

            for (User anUsers : users) {
                printWriter.println("----------");

                printWriter.println(anUsers.getFirstName() == null ? "firstNameNotExist" : anUsers.getFirstName());
                printWriter.println(anUsers.getLastName() == null ? "lastNameNotExist" : anUsers.getLastName());
                printWriter.println(dateFormat.format(anUsers.getBirthDate().getTime()));
                printWriter.println(String.valueOf(anUsers.isMale()));
                printWriter.println(anUsers.getCountry());

            }

            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready()) {
                if (reader.readLine().equals("----------")){
                    User user = new User();

                    String firstName = reader.readLine();
                    user.setFirstName(firstName.equals("firstNameNotExist") ? null : firstName);
                    String lastName = reader.readLine();
                    user.setLastName(lastName.equals("lastNameNotExist") ? null : lastName);
                    user.setBirthDate(dateFormat.parse(reader.readLine()));
                    user.setMale(reader.readLine().equals("true"));
                    user.setCountry(User.Country.valueOf(reader.readLine()));

                    users.add(user);
                }
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
