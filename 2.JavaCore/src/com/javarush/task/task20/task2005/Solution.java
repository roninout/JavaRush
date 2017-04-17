package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Странные ошибки
*/

//        Что помогло мне и может помочь другим:
//        1) Если у записываемого объекта string1 null, а string2 не null, то у загруженного объекта должно быть точно так же. Проверьте и другие комбинации.
//        3) countStrings не должен измениться после выполнения загрузки объектов (вот это реально телепатия, без форума в жизни бы не догадался).
//        4) если записать в файл стринги с индексом 3 и 4 (например), то загрузиться должны стринги с этими же индексами, а не, например, 1 и 2
//
//        Когда все эти условия выполнились, валидатор засчитал.

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("1.txt");
            InputStream inputStream = new FileInputStream("1.txt");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return false;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name == null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            //return (int) (Math.random() * 100);
            return result;
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            //printWriter.println(this.name);

            String YesOrNot = name != null ? "yes" : "no"; // проверяем на существование имени
            printWriter.println(YesOrNot); // результат записываем в файл

/*            if (this.assets.size() > 0) {
                for (Asset current : this.assets)
                    printWriter.println(current.getName());
            }*/

            if ("yes".equals(YesOrNot)) {
                printWriter.println(name);
                for (Asset as : this.assets) {
                    printWriter.println(as.getName());
                }
            }


            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

/*            this.name = reader.readLine();
            String assetName;
            while ((assetName = reader.readLine()) != null)
                this.assets.add(new Asset(assetName));*/

            String YesOrNot = reader.readLine();

            if (YesOrNot.equals("yes"))
            {
                name = reader.readLine();
                while (reader.ready())
                    assets.add(new Asset(reader.readLine()));
            }

            reader.close();
        }
    }
}
