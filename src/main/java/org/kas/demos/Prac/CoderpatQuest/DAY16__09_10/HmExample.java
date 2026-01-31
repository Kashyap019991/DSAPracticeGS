package org.kas.demos.Prac.CoderpatQuest.DAY16__09_10;
import java.util.HashMap;
import java.util.Objects;


class Employee{
    int id;
    String name;
    Employee(int id, String name)
    {
        this.name= name;
        this.id=id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Employee)) return false;

        Employee e = (Employee) o;

        return id == e.id && Objects.equals(name, e.name);

    }
    @Override
    public int hashCode() {

        //return id ;
        //return Objects.hash(id, name);
        return 1;

    }
}

public class HmExample {

    public static void main(String[] args) {
        HashMap<Employee, String> map = new HashMap<>();
        Employee e1 = new Employee(1, "John");
        Employee e2 = new Employee(1, "John");

        map.put(e1, "Developer");
       // map.put(e2, "Developer1");
        System.out.println(map.get(e2) +" "+ e1.hashCode() +" "+e2.hashCode());
        //map.put(e, "Developer");

        //e1.name = "Mike"; // mutate after insert

        System.out.println(map.get(e2));
    }

}
