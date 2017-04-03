package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)
    {
        int argsLenght = args.length;
        String name;

        //start here - начни тут
        switch (args[0])
        {
            case "-c":
                if (argsLenght == 4 || argsLenght == 5)
                {
                    name = args[2].equals("м") || args[2].equals("ж") ? args[1] : args[1] + " " + args[2];
                    AddPerson(name, args[argsLenght - 2], args[argsLenght - 1]);
                    break;
                }
                break;
            case "-u":
                if ((argsLenght == 5 || argsLenght == 6) && Integer.parseInt(args[1]) < allPeople.size())
                {
                    name = args[3].equals("м") || args[3].equals("ж") ? args[2] : args[2] + " " + args[3];
                    UpdatePerson(Integer.parseInt(args[1]), name, args[argsLenght - 2], args[argsLenght - 1]);
                    break;
                }
                break;
            case "-d":
                if (argsLenght == 2 && Integer.parseInt(args[1]) < allPeople.size())
                {
                    RemovePerson(Integer.parseInt(args[1]));
                    break;
                }
                break;
            case "-i":
                if (argsLenght == 2 && Integer.parseInt(args[1]) < allPeople.size())
                {
                    ShowPerson(Integer.parseInt(args[1]));
                    break;
                }
                break;
            default:
                System.out.println("Неизвестный параметр");
        }
    }

    public static void ShowPerson(int id)
    {
        Person person = allPeople.get(id);
        if (person.getName()==null) return;//don't show info about logically deleted records
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);

        String name = person.getName();
        String sex = person.getSex() == Sex.MALE ? "м" : "ж";
        String data = simpleFormat.format(person.getBirthDay());

        System.out.println(name + " " + sex + " " + data);
    }

    public static void AddPerson(String name, String sex, String bd)
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

    public  static void RemovePerson(int id)
    {
        Person person = allPeople.get(id);
        if (allPeople.contains(person))
        {
            person.setName(null);
            person.setSex(null);
            person.setBirthDay(null);
        }
        //ShowAllPersons();
    }

    public static void UpdatePerson(int id, String name, String sex, String bd)
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

    public static void ShowAllPersons()
    {
        for (int i = 0; i < allPeople.size(); i++)
            ShowPerson(i);
    }

    public static Date parseDate(String date) throws ParseException{
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
}

