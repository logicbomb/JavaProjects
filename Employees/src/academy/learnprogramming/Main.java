package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

            Employee e1 = new Employee("Rukon Khan", 21);
            Employee e2 = new Employee("Rukon 2", 22);
            Employee e3 = new Employee("Rukon 3", 23);
            Employee e4 = new Employee("Ripon 1", 34);
            Employee e5 = new Employee("Ripon 1", 31);
            List<Employee> employess = new ArrayList<Employee>();

            employess.add(e1);
            employess.add(e2);
            employess.add(e3);
        employess.add(e4);
        employess.add(e5);

        Function<Employee, String>  getlastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(" ") + 1);
        };

        Function<String, String> toUCase = name -> name.toUpperCase();

        Function chainedFunction  = getlastName.andThen(toUCase);

        System.out.println(chainedFunction.apply(employess.get(0)));

        String lastName = getlastName.apply(employess.get(2));
        System.out.println(lastName);

      
//            printEmpByAge(employess, "Over 30", employee -> (employee.getAge()>30));
//        printEmpByAge(employess, "Under 30", employee -> (employee.getAge()<30));
//                printEmpByAge(employess, "Under 25", new Predicate<Employee>() {
//                            @Override
//                            public boolean test(Employee employee) {
//                                return employee.getAge() < 25;
//                            }
//                        });
//
//
//                Predicate<Integer> predicate = i -> i >10;
//
//        System.out.println(predicate.test(2));


                        // write your code here
    }

    public static void printEmpByAge(List<Employee> employees, String ageText, Predicate<Employee> predicate){
        System.out.println(ageText);
        System.out.println("=========");
        for(Employee employee:employees ){

            if(predicate.test(employee)){
                System.out.println(employee.getName());
            }
        }
    }
}
