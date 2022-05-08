import java.util.ArrayList;
import java.util.Collections;

public class Doudizhu {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<String>();

        ArrayList<String> xiaoming = new ArrayList<String>();
        ArrayList<String> xiaohong = new ArrayList<String>();
        ArrayList<String> xiaolan = new ArrayList<String>();
        ArrayList<String> dpPoker = new ArrayList<String>();
        String[] color = {"♣","♥","♠","♦"};
        String[] numbers = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        for (String color1 : color){
            for (String number : numbers){
                array.add(color1 + number);
            }
        }
        array.add("大王");
        array.add("小王");

        Collections.shuffle(array);

        for (int i = 0;i < array.size();i++){
            if (i >= array.size() - 3){
                dpPoker.add(array.get(i));
            } else if (i % 3 == 0){
                xiaoming.add(array.get(i));
            } else if (i % 3 == 1){
                xiaohong.add(array.get(i));
            } else if (i % 3 == 2){
                xiaolan.add(array.get(i));
            }
        }

        LookPoker("小明",xiaoming);
        LookPoker("小红",xiaohong);
        LookPoker("小蓝",xiaolan);

    }

    public static void LookPoker(String name,ArrayList<String> arrayList){
        System.out.print(name + "的牌是：");
        for (String poker : arrayList){
            System.out.print(poker+ " ");
        }
        System.out.println();
    }
}
