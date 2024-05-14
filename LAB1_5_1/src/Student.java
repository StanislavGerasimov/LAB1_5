public class Student {
    private String lastName;
    private String firstName;
    private String middleName;
    private int studentID;
    private boolean militaryTraining;

    // Конструктор для створення студента
    public Student(String lastName, String firstName, String middleName, int studentID, boolean militaryTraining) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.studentID = studentID;
        this.militaryTraining = militaryTraining;
    }

    // Геттери та сеттери
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public boolean hasMilitaryTraining() {
        return militaryTraining;
    }

    public void setMilitaryTraining(boolean militaryTraining) {
        this.militaryTraining = militaryTraining;
    }

    @Override
    public String toString() {
        return "Прізвище: " + lastName +
                ", Ім'я: " + firstName +
                ", По батькові: " + middleName +
                ", Номер залікової книжки: " + studentID +
                ", Військова підготовка: " + (militaryTraining ? "Так" : "Ні");
    }
}
