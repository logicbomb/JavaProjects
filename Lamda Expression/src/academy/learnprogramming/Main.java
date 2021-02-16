package academy.learnprogramming;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Thread(()-> {
            System.out.println("Running from Lamda expressions");
            Employee e1 = new Employee("Rukon 5", 21);
            Employee e2 = new Employee("Rukon 2", 22);
            Employee e3 = new Employee("Rukon 3", 23);

            List<Employee> employess = new ArrayList<Employee>();

            employess.add(e1);
            employess.add(e2);
            employess.add(e3);

            Collections.sort(employess, (o1, o2) -> o1.getName().compareTo(o2.getName()));

//            Collections.sort(employess, new Comparator<Employee>() {
//                @Override
//                public int compare(Employee o1, Employee o2) {
//                    return o1.getName().compareTo(o2.getName());
//                }
//
//            });

            employess.forEach(employee -> System.out.println(employee.getName()));


            UpperC uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
            String value = doStuff(uc, employess.get(1).getName(), employess.get(1).getName());
            System.out.println("The ucase name is" + value);

            AnotherClass anotherClass = new AnotherClass();
            System.out.println(anotherClass.doSomething());

        }).start();




    }

    public final static String doStuff(UpperC uc, String s1, String s2){
        return uc.toUcase(s1, s2);
    }
}


class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Just do the thing! .....");
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperC {
    String toUcase(String s1, String s2);
}

class AnotherClass {
    public String doSomething(){
       int i =0;
       UpperC uc = (s1, s2) -> {
           System.out.println("The lamda expressions class is " + getClass().getName());
           String result = s1.toLowerCase() + s2.toUpperCase();
           return result;
       };
        System.out.println("Another class name is " + getClass().getName());
        return Main.doStuff(uc, "String1", "String2");
    }
}