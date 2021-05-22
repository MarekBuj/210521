package Movies;

public class Director extends Staff{

    public Director(String firstName, String lastName, double salary) {
        super(firstName, lastName, salary);
        setSalary(salary);
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary*3;
    }

//    Director stevenSpilberg;
//    stevenSpilberg.setSalary(1000);
}
