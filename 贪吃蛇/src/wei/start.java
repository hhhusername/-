package wei;

import javax.swing.*;
import java.awt.*;

public class start {
    public static void main(String[] args) {
        JFrame frame = new JFrame();//绘制窗口
        frame.setBounds(10,10,900,720);//窗口大小
        frame.setResizable(false);//窗口不可改变
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口
       frame.add(  new GamePanel()); //2面板
        frame.setVisible(true);//设置窗口是否显现

    }
}