import java.util.ArrayList;

//第二套方案
public class StudentOperatorImpl2 implements StudentOperator{
    @Override
    public void printAllInfo(ArrayList<Student> students) {
        System.out.println("----------------全部学生信息如下----------------");
        int count1 = 0;//记录男生的人数
        int count2 = 0;//女生
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println("姓名：" + s.getName() + "性别：" + s.getSex() + "成绩：" + s.getScore());
            if(s.getSex() == '男'){
                count1++;
            } else count2++;
        }
        System.out.println("男生人数：" + count1 + "，女生人数：" + count2);
        System.out.println("班级总人数：" + students.size());
        System.out.println("---------------------------------------------");
    }

    @Override
    public void printAverageScore(ArrayList<Student> students) {
        double allScore = 0;
        double max = students.get(0).getScore();
        double min = students.get(0).getScore();
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if(s.getScore() > max) max = s.getScore();
            if(s.getScore() < min) min = s.getScore();
            allScore += s.getScore();
        }
        System.out.println("学生的最高分是：" + max);
        System.out.println("学生的最低分是：" + min);
        System.out.println("平均成绩是：" + (allScore - max -min) / (students.size() - 2));
    }
}
