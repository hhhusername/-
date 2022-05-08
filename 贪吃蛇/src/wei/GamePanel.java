package wei;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    int length;//蛇长
    int[] snakeX = new int[600];//蛇的坐标x
    int[] snakey = new int[600];//蛇的坐标y
    String fx;//R 右，L 左 U 上 D 下
    int foodx;
    int foody;//定义食物坐标
    Random random = new Random();
    boolean isfaied=false;//死亡判定
    int score;
    boolean isSTART = false;//游戏是否开始
    Timer timer = new Timer(100,this);//定时器
//构造器
    public GamePanel() {
        init();//初始化
        this.setFocusable(true);
        this.addKeyListener(this);//获取监听事件
        timer.start();
    }

//初始化
    public void init() {
        length = 3;
        snakeX[0] = 100;
        snakey[0] = 100;//头部坐标

        snakeX[1] = 75;
        snakey[1] = 100;//第一个身体坐标

        snakeX[2] = 50;
        snakey[2] = 100;//第二个身体坐标
        fx = "R";
        foodx= 25+25*random.nextInt(34);
        foody= 25+25*random.nextInt(23);
        score=0;
    }


    @Override
    //画蛇
    //graphis画笔
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
        this.setBackground(Color.WHITE);//设置背景窗口
        g.fillRect(15, 15, 870, 680);//绘制游戏区域
        //画蛇
        if (fx.equals("R")) {
            Date.right.paintIcon(this, g, snakeX[0], snakey[0]);
        } else if (fx.equals("L")) {
            Date.left.paintIcon(this, g, snakeX[0], snakey[0]);
        } else if (fx.equals("U")) {
            Date.up.paintIcon(this, g, snakeX[0], snakey[0]);
        } else if (fx.equals("D")) {
            Date.down.paintIcon(this, g, snakeX[0], snakey[0]);
        }


        for (int i = 1; i < length; i++)//通过length控制身体长度。
        {
            Date.body.paintIcon(this, g, snakeX[i], snakey[i]);

        }
        Date.food.paintIcon(this,g,foodx,foody);
        //游戏提升，是否开始
        if (isSTART == false) {
            //画一个文字
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("按下空格开始游戏", 300, 300);

        }   if (isfaied == true) {
            //画一个文字
            g.setColor(Color.red);//设置画笔的颜色
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));//设置字体
            g.drawString("游戏失败，按下空格重新开始", 300, 300);

        }

    g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑",Font.BOLD,18));
        g.drawString("长度"+length,750,35);
        g.drawString("分数"+score,650,35);


    }




    @Override//接收键盘的输入
    public void keyPressed(KeyEvent e) {
        //获取按下的键盘的是哪个键
        int keyCode = e.getKeyCode();
        if(keyCode==KeyEvent.VK_SPACE) {
            //如果按下的是空格键
            if(isfaied){
                isfaied=false;
                init();//重新初始化游戏

            }else{
            isSTART = !isSTART;}
            repaint();//刷新界面

        }
        if(keyCode==KeyEvent.VK_LEFT){
            fx="L";
        }else if (keyCode==KeyEvent.VK_RIGHT){
            fx="R";
        }else if (keyCode==KeyEvent.VK_UP){
            fx="U";
        }else if (keyCode==KeyEvent.VK_DOWN){
            fx="D";
        }




    }
    //定时器

    @Override//定时器
    public void actionPerformed(ActionEvent e) {
        //如果游戏处于初始状态
        if(isSTART&&isfaied==false){//身体移动
            for(int i=length-1 ;i>0;i--){
            snakeX[i]=snakeX[i-1];
            snakey[i]=snakey[i-1];
            }
            if(fx.equals("R")){
            snakeX[0] = snakeX [0] + 25;//头部移动
            if(snakeX[0]>870){
            isfaied=true;
            }}else if(fx.equals("D")){
                snakey[0] = snakey [0] + 25;//头部移动
                if(snakey[0]>650){
                    isfaied=true;
                }}
               else  if (fx.equals("L")){
                    snakeX[0] = snakeX [0] - 25;//头部移动
                    if(snakeX[0]<15){
                        isfaied=true;
                    }}else if (fx.equals("U")){
                        snakey[0] = snakey[0] - 25;//头部移动
                        if(snakey[0]<15){
                            isfaied=true;
                        }}
            if (snakeX[0]==foodx&&snakey[0]==foody) {
                length++;
                score+=100;
                foodx= 25+25*random.nextInt(34);
                foody= 75+25*random.nextInt(23);
            }
            for(int i=1;i<length;i++){
                if (snakeX[0]==snakeX[i]&&snakey[0]==snakey[i]){
                    isfaied=true;
                }
                
            }

            //刷新界面
            repaint();
        }
        timer.start();//时间动起来

    }//执行定时操作






    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }


}