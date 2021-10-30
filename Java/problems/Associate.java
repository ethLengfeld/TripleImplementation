package problems;

public class Associate {

    private static int numAssociates;

    private String firstName;
    private String lastName;
    private int birthMonth;
    private int birthDay;
    private int birthYear;
    private long salary;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthMonth() {
        return this.birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }


    public long getSalary() {
        return this.salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public static int getNumAssociates() {
        return Associate.numAssociates;
    }

    public static void setNumAssociates(int numAssociates) {
        Associate.numAssociates = numAssociates;
    }

}
