//软工202李泽群 202012900222
package Homework3_2;
public class Main {
    public static void main(String[] args){
        //用类创造出一个个对象，让这些对象“动起来”
        //我们如何让两个对象产生关联？
        //把对象作为参数，传给另外一个对象的方法中
        LiHuaCat xiaoLi = new LiHuaCat(2,5.0);
        Mouse mouse = new Mouse();
        mouse.speed = 3.0;

        xiaoLi.catchMouse(mouse);
        System.out.println(mouse.speed);
    }
}
//(1)猫 老鼠 猫抓老鼠
//(2)描述类
class LiHuaCat{
    int leg=4;
    int age;
    double speed;
    //构造方法
    LiHuaCat(int _age,double _speed){
        age = _age;
        speed = _speed;
    }
    void catchMouse(Mouse m){
        m.speed = 6.0;
        if(speed > m.speed){
            System.out.println("抓的到老鼠");
        }else{
            System.out.println("抓不到老鼠");
        }
    }
}
class Mouse{
    int leg = 4;
    double speed;
}