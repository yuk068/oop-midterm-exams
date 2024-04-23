package three.hus.oop.studentmanager;

public interface StudentComparable extends Comparable<Student> {

    @Override
    int compareTo(Student another);

}
