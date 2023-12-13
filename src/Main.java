import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    List<Assessment> assessments;

    public Student(String name, List<Assessment> assessments) {
        this.name = name;
        this.assessments = assessments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", assessments=" + assessments +
                '}';
    }
}
class Assessment {
    String name;
    int grade;

    public Assessment(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("abc", new ArrayList<>(List.of(new Assessment("English", 99), new Assessment("Maths", 100), new Assessment("Science", 95), new Assessment("Social Studies", 90))));
        Student s2 = new Student("def", new ArrayList<>(List.of(new Assessment("English", 94), new Assessment("Maths", 94), new Assessment("Science", 92), new Assessment("Social Studies", 78))));
        Student s3 = new Student("ghi", new ArrayList<>(List.of(new Assessment("English", 95), new Assessment("Maths", 90), new Assessment("Science", 93), new Assessment("Social Studies", 72))));
        Student s4 = new Student("jkl", new ArrayList<>(List.of(new Assessment("English", 96), new Assessment("Maths", 80), new Assessment("Science", 89), new Assessment("Social Studies", 89))));
        List<Student> students = new ArrayList<>(List.of(s1, s2, s3, s4));

        Map<String, Double> studentsToAverages = students.stream().collect(Collectors.toMap(stu -> stu.getName(), stu -> stu.getAssessments().stream().mapToDouble(a -> a.getGrade()).average().getAsDouble()));
        System.out.println(studentsToAverages);
        Student bestStudent = students.stream().sorted((student1, student2) -> ((Double)student1.getAssessments().stream().mapToInt(a -> a.getGrade()).average().getAsDouble()).compareTo((Double)student2.getAssessments().stream().mapToInt(a -> a.getGrade()).average().getAsDouble())).findFirst().get();
        System.out.println(bestStudent);
    }
}


//student class -> name, list<Assessment>

//Assessment -> name, grade

//find the list of students whose average grade is the best