import java.util.ArrayList;

public class ClassManager {
    private ArrayList<Student> students = new ArrayList<>();
    private StudentOperator studentOperator = new StudentOperatorImpl2();

    public ClassManager() {
        students.add(new Student("sym", '男', 100));
        students.add(new Student("zyf", '女', 90));
        students.add(new Student("swy", '女', 98));
        students.add(new Student("jwx", '男', 83));
        students.add(new Student("wbf", '男', 94));
        students.add(new Student("scz", '男', 84));
        students.add(new Student("hst", '女', 69));
    }
    //打印全部学生信息
    public void printInfo() {
        studentOperator.printAllInfo(students);
    }

    //打印全部学生成绩
    public void printScore(){
        studentOperator.printAverageScore(students);

    }
}
