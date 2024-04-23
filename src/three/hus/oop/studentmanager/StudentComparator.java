package three.hus.oop.studentmanager;

import java.util.Comparator;

public interface StudentComparator extends Comparator<Student> {

    @Override
    int compare(Student left, Student right);

    static Comparator<Student> byId() {
        return Comparator.comparing(Student::getId);
    }

    static Comparator<Student> byFirstName() {
        return Comparator.comparing(Student::getFirstname);
    }

    static Comparator<Student> byLastName() {
        return Comparator.comparing(Student::getLastname);
    }

    static Comparator<Student> byYearOfBirth() {
        return Comparator.comparingInt(Student::getYearOfBirth);
    }

    static Comparator<Student> byMathsGrade() {
        return Comparator.comparingDouble(Student::getMathsGrade);
    }

    static Comparator<Student> byPhysicsGrade() {
        return Comparator.comparingDouble(Student::getPhysicsGrade);
    }

    static Comparator<Student> byChemistryGrade() {
        return Comparator.comparingDouble(Student::getChemistryGrade);
    }

}
