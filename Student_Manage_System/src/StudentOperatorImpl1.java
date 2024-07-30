import java.util.ArrayList;
//第一套方案的实现类
public class StudentOperatorImpl1 implements StudentOperator {

    @Override
    public void printAllInfo(ArrayList<Student> students) {
        System.out.println("----------------全部学生信息如下----------------");
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println("姓名：" + s.getName() + "性别：" + s.getSex() + "成绩：" + s.getScore());
        }
        System.out.println("---------------------------------------------");
    }

    @Override
    public void printAverageScore(ArrayList<Student> students) {
        double allScore = 0;
        for (int i = 0; i < students.size(); i++) {
//            Student s = students.get(i);
            allScore += students.get(i).getScore();
        }
        System.out.println("平均成绩是：" + allScore / students.size());
    }
}
