package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution extends Thread {
    public volatile static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        int argsLenght = args.length;

        switch (args[0])
        {
            case "-c":
                synchronized (allPeople){
                    for (int i = 1; i < argsLenght; i += 3)
                    {
                        try{
                            AddPerson(args[i], args[i+1], args[i+2]);
                        }
                        catch (NumberFormatException e){
                            System.out.println("Некорректный ID");
                        }
                    }
                    //ShowAllPersons();
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < argsLenght; i += 4) {
                        try {
                            UpdatePerson(parseID(args[i]), args[i + 1], args[i + 2], args[i + 3]);
                        } catch (NumberFormatException e) {
                            System.out.println("Некорректный ID");
                        }
                    }
                    //ShowAllPersons();
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < argsLenght; i++) {
                        try {
                            RemovePerson(parseID(args[i]));
                        } catch (NumberFormatException e) {
                            System.out.println("Некорректный ID");
                        }
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < argsLenght; i++) {
                        try {
                            ShowPerson(parseID(args[i]));
                        } catch (NumberFormatException e) {
                            System.out.println("Некорректный ID");
                        }
                    }
                    break;
                }
            default:
                synchronized (allPeople) {
                    System.out.println("Неизвестный параметр");
                }
        }
    }


    // ------------------------------------------------------------------------------------------
    public synchronized static void ShowPerson(int id)
    {
        Person person = allPeople.get(id);
        if (person.getName()==null) return;//don't show info about logically deleted records
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);

        String name = person.getName();
        String sex = person.getSex() == Sex.MALE ? "м" : "ж";
        String data = simpleFormat.format(person.getBirthDay());

        System.out.println(name + " " + sex + " " + data);
    }

    public synchronized static void AddPerson(String name, String sex, String bd)
    {
        try
        {
            if (!(sex.equals("м") || sex.equals("ж"))) return;
            Date date = parseDate(bd);
            allPeople.add(sex.equals("м") ? Person.createMale(name, date) : Person.createFemale(name, date));
            System.out.println(allPeople.size() - 1);
            //ShowAllPersons();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    public synchronized  static void RemovePerson(int id)
    {
        Person person = allPeople.get(id);
        if (allPeople.contains(person))
        {
            person.setName(null);
            person.setSex(null);
            person.setBirthDay(null);
        }
    }

    public synchronized static void UpdatePerson(int id, String name, String sex, String bd)
    {
        try
        {
            if (!(sex.equals("м") || sex.equals("ж"))) return;
            Date date = parseDate(bd);
            allPeople.set(id, sex.equals("м") ? Person.createMale(name, date) : Person.createFemale(name, date));
            //ShowAllPersons();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    public synchronized static void ShowAllPersons()
    {
        for (int i = 0; i < allPeople.size(); i++)
            ShowPerson(i);
    }

    public static Date parseDate(String date) throws ParseException {
        String pattern = "dd/MM/yyyy";
        Date birthDate=null;
        SimpleDateFormat df = new SimpleDateFormat(pattern, Locale.ENGLISH);
        try
        {
            birthDate = df.parse(date);
        }catch (Exception e)
        {
            System.out.println("ERROR: wrong date format");
        }
        return birthDate;
    }

    public static int parseID(String id)
    {
        int ID = Integer.parseInt(id);
        if (ID < allPeople.size())
            return ID;
        else
            throw new NumberFormatException();
    }
}

