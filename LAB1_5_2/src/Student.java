public class Student {
    String lastName;
    String firstName;
    String middleName;
    int id;
    boolean militaryTraining;

    public Student(String lastName, String firstName, String middleName, int id, boolean militaryTraining) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.id = id;
        this.militaryTraining = militaryTraining;
    }

    // Метод toString() для зручного виведення інформації про студента
    @Override
    public String toString() {
        return  " Прізвище: " + lastName +
                ", Ім'я: " + firstName +
                ", По батьківськи: " + middleName +
                ", Номер залікової книжки: " + id +
                ", Військова підготовка: " + militaryTraining;
    }
}
