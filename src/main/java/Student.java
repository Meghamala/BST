
class Student {
    String firstName;
    String lastName;
    int redId;
    double gpa;

    public Student(String firstName, String lastName, int redId, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.redId = redId;
        this.gpa = setRoundedGpa(gpa);
    }

    public Student(int redId) {
        this.redId = redId;
    }

    public Student(String lastName) {
        this.lastName = lastName;
    }

    public Student(double gpa) {
        this.gpa = setRoundedGpa(gpa);
    }

    public double setRoundedGpa(double gpa) {
        return Math.round(gpa*100.0)/100.0;
    }
}