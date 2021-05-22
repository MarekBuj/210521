package Movies;

public class Actor extends Staff{

    public Actor(String firstName, String lastName, double salary) {
        super(firstName, lastName, salary);
        setSalary(salary);
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary*2;
    }
}
