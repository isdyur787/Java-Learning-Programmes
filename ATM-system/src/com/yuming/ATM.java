package com.yuming;
import java.io.ObjectInputStream;
import java.io.StringReader;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
//ATM类 负责业务需求
public class ATM {
    //存储账户集合
    private ArrayList<Account> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private Account loginAcc;//用于记录登陆后的用户账户
    public void start(){
        while(true){
            System.out.println("======欢迎您进入ATM系统======");
            System.out.println("1.用户登陆");
            System.out.println("2.用户开户");
            System.out.println("3.退出系统");
            System.out.println("请输入您的选择：");
            int cho = sc.nextInt();
            switch (cho){
                case 1:
                    login();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("您的输入有误");
            }
        }
    }

    private void login(){
        System.out.println("======系统登陆======");
        //判断账户中是否存在账户
        if(accounts.size() == 0){
            System.out.println("当前系统中无账号，请先开户");
            return;
        }
        //存在账户可以登陆
        while (true) {
            System.out.println("请您输入您的登陆卡号：");
            String carId = sc.next();
            Account acc = getAccountByCardId(carId);
            if (acc == null) {
                System.out.println("您输入的登陆卡号不存在");
            } else {
                while (true){
                    System.out.println("请您输入登陆密码：");
                    String password = sc.next();
                    if(acc.getPassword().equals(password)){
                        loginAcc = acc;
                        System.out.println(acc.getUserName() + "登陆成功，卡号：" + acc.getCardId());
                        //显示登陆后的操作界面
                        showUserCommond();
                        return;
                    } else System.out.println("您输入的密码错误");
                }
            }
        }

    }

    private void showUserCommond(){
        while (true) {
            System.out.println("======" + loginAcc.getUserName() + "您可以选择如下功能进行账户处理======");
            System.out.println("1.查询账户");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转账");
            System.out.println("5.修改密码");
            System.out.println("6.退出账户");
            System.out.println("7.注销当前账户");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    showLoginAcc();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    drawMoney();
                    break;
                case 4:
                    transferMoney();
                    break;
                case 5:
                    if (updatePassword()) {
                        return;
                    }
                    break;
                case 6:
                    System.out.println(loginAcc.getUserName() + "退出成功");
                    return;
                case 7:
                    if(deleteAccount()){//true
                        //销户成功
                        return;//回到欢迎页面
                    }
                    break;//销户失败还在登陆页面
                default:
                    System.out.println("输入有误，请重新输入");
            }
        }

    }

    private boolean updatePassword() {
        while (true) {
            System.out.println("请输入当前账户密码：");
            String password = sc.next();
            if (loginAcc.getPassword().equals(password)) {
                while (true){
                    System.out.println("请输入新的密码：");
                    String updatePassword = sc.next();
                    System.out.println("请您再次输入此密码：");
                    String comfirmPassword = sc.next();
                    if (!updatePassword.equals(comfirmPassword)) {
                        System.out.println("两次密码不一致，请重新输入：");
                    } else if (updatePassword.equals(loginAcc.getPassword())) {
                        System.out.println("您更改的密码与原密码相同，请重新输入：");
                    } else if (updatePassword.length() < 6) {
                        System.out.println("密码长度小于6位，请重新输入：");
                    } else {
                        loginAcc.setPassword(updatePassword);
                        System.out.println("密码修改成功，请您重新登录");
                        return true;
                    }
                }
            } else {
                System.out.println("密码错误");
            }
        }
    }

    private boolean deleteAccount() { //销户成功返回true 失败返回false
        System.out.println("您确定要进行销户操作吗? 请输入Y（确认）或N（不确认）");
        String command = sc.next();
        switch (command){
            case "Y":
                if (loginAcc.getMoney() == 0){
                    accounts.remove(loginAcc);
                    System.out.println("销户成功");
                    return true;
                } else {
                    System.out.println("当前账户中存在金额，销户失败 ");
                    return false;
            }
            default:
                System.out.println("输入有误");
                return false;
        }
    }

    private void transferMoney() {
        if(accounts.size() < 2) {
            System.out.println("当前系统中账户数量不足，无法转账");
            return;
        }
        if(loginAcc.getMoney() == 0){
            System.out.println("您当前余额为0，无法转账");
            return;
        }
        while (true) {
            System.out.println("请输入对方的卡号：");
            String cardId = sc.next();
            Account acc = getAccountByCardId(cardId);
            if (acc == null) {
                System.out.println("当前卡号不存在，请重新输入：");
            } else {
                String name = "*" + acc.getUserName().substring(1);//隐藏姓氏：* 加上 去掉第一个字符的名字
                System.out.println("请输入" + "「" + name + "」" + "的姓氏：");
                String userName = sc.next();
                if(acc.getUserName().startsWith(userName)){
                    System.out.println("认证通过");
                    while (true) {
                        System.out.println("请您输入转账金额：");
                        double amount = sc.nextDouble();
                        if (loginAcc.getMoney() < amount) {
                            System.out.println("余额不足，您的当前余额为：" + loginAcc.getMoney());
                        } else {
                            loginAcc.setMoney(loginAcc.getMoney() - amount);
                            acc.setMoney(acc.getMoney() + amount);
                            System.out.println("转账成功");
                            return;
                        }
                    }
                } else {
                    System.out.println("姓氏认证错误");
                }
            }
        }
    }

    private void drawMoney() {
        //取款
        if(loginAcc.getMoney() < 100){
            System.out.println("账户余额不足100元，不能进行取款操作");
            return;
        }
        while (true) {
            System.out.println("请输入您要取款的金额：");
            double amount = sc.nextDouble();
            if (loginAcc.getMoney() >= amount) {
                if(amount > loginAcc.getLimit()){
                    System.out.println("您的取款金额大于限额，您每次最多可取：" + loginAcc.getLimit());
                } else {
                    loginAcc.setMoney(loginAcc.getMoney() - amount);
                    System.out.println("取款" + amount + "元成功，您的余额为：" + loginAcc.getMoney());
                    break;
                }
            } else {
                System.out.println("余额不足，您的余额为：" + loginAcc.getMoney());
            }
        }
    }

    private void depositMoney() {
        System.out.println("请输入您要存入的金额：");
        double amount = sc.nextDouble();
        loginAcc.setMoney(loginAcc.getMoney() + amount);
        System.out.println("存入" + amount + "元成功，您的余额为" + loginAcc.getMoney());
    }

    private void showLoginAcc(){
        //显示当前账户信息
        System.out.println("======当前您的账户信息如下：======");
        System.out.println("卡号：" + loginAcc.getCardId());
        System.out.println("户主：" + loginAcc.getUserName());
        System.out.println("余额：" + loginAcc.getMoney());
        System.out.println("性别：" + loginAcc.getSex());
        System.out.println("每次提现额度：" + loginAcc.getLimit());

    }


    private void createAccount(){
        System.out.println("======系统开户操作======");
        //创建一个账户对象 用于封装用户的开户信息
        Account acc = new Account();

        //用户输入信息传给对象
        System.out.println("请输入您的账户名称：");
        String name = sc.next();
        acc.setUserName(name);
        while(true) {
            System.out.println("请您输入您的性别：");
            char sex = sc.next().charAt(0);
            // charAt（0）：返回输入的第一个字符
            if (sex == '男' || sex == '女'){
                acc.setSex(sex);
                break;
            }
            else System.out.println("性别只能是男/女");
        }
        while (true) {
            String password;
            while (true) {
                System.out.println("请您输入您的6位账户密码：");
                password = sc.next();
                if (password.length() < 6) {
                    System.out.println("此密码长度不是6位，请重新输入");
                } else break;
            }
            System.out.println("请再次输入此密码：");
            String okPassword = sc.next();
            if (okPassword.equals(password)) {
                acc.setPassword(password);
                System.out.println("设置成功");
                break;
            } else System.out.println("两次密码不一致，请重新输入");
        }
        System.out.println("请输入您的取现额度：");
        double amount = sc.nextDouble();
        acc.setLimit(amount);

        acc.setCardId(creatCardId());

        //把这个账户对象存入到集合中
        accounts.add(acc);
        System.out.println("恭喜您，" + acc.getUserName() + "开户成功，您的卡号是：" + acc.getCardId());
    }

    //自动生成八位卡号  不能与其他账号重复
    private String creatCardId(){
        while (true){
            String CardId = "";
            Random random = new Random();
            for (int i = 0; i < 8; i++){
                CardId += random.nextInt(10);//0-9的数字范围
            }

            //判断卡号是否唯一
            Account acc = getAccountByCardId(CardId);
            if(acc == null){
                return CardId;
            }
        }
    }

    // 根据卡号查询账户对象返回 account = [c1, c2,....]
    private Account getAccountByCardId(String cardId){
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            //判断
            if(acc.getCardId().equals(cardId))
                return acc;
        }
        return null;
    }
}

