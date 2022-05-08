import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.LinkedList;
import java.util.TimerTask;

public class MainFrame extends JFrame {

    private Snake snake;//蛇
    private JPanel jPanel;//棋盘
    private Timer timer;//定时器,指定时间调用蛇移动
    private Node food;//食物
    public static int score=0;
    public static int length=3;


    public MainFrame() throws HeadlessException {
        //窗体
        initFrame();
        //棋盘
        initGamePanel();
        //蛇
        initSnake();
        //定时器
        initTimer();
        //键盘设置
        setKeyListener();
        //食物
        initFood();
    }
    //窗体
    private void initFrame(){
        setTitle("贪吃蛇");
        setVisible(true);
        setSize(600,750);
        setLocation(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    //棋盘
    private void initGamePanel(){
        jPanel= new JPanel(){

            @Override
            public void paint(Graphics g){
                //清空棋盘
                g.clearRect(0,0,600,600);

                g.setColor(Color.black);
                //横线
                for (int i=0;i<40;i++){
                    g.drawLine(0,i*15,600,i*15);
                }
                //竖线
                for (int j=0;j<40;j++){
                    g.drawLine(j*15,0,j*15,600);
                }
                //蛇
                LinkedList<Node> body =snake.getBody();
                for (Node node : body){
                    g.fillRect(node.getX()*15,node.getY()*15,15,15);
                }
                //判断吃食物
                Node head=snake.getBody().getFirst();
                if(head.getX()== food.getX() && head.getY()==food.getY()){
                    snake.eat(food);
                    food.radom();
                    score=score+100;
                    length=length+1;
                }


                //食物
                g.fillRect(food.getX()*15, food.getY()*15,15,15);

                //积分
                g.clearRect(0,600,600,700);
                g.setColor(Color.blue);
                g.setFont(new Font("微软雅黑",Font.BOLD,18));
                g.drawString("长度:"+length,400,630);
                g.drawString("分数:"+score,400,680);

            }

        };
        add(jPanel);
    }

    //蛇
    private void initSnake(){
          snake=new Snake();
    }

    //定时器
    private void initTimer(){
        timer=new Timer();
        //初始化定时任务
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                snake.move();


                //重绘游戏棋盘
                jPanel.repaint();
            }
        };
        //每100ms执行一次
        timer.scheduleAtFixedRate(timerTask,0,100);
    }

    //键盘控制
    private void setKeyListener(){
        //键盘按下调用
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //键盘的键有编号
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        if(snake.getDirection()!=Direction.DOWN)
                        snake.setDirection(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        if(snake.getDirection()!=Direction.UP)
                        snake.setDirection(Direction.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        if(snake.getDirection()!=Direction.RIGHT)
                        snake.setDirection(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(snake.getDirection()!=Direction.LEFT)
                        snake.setDirection(Direction.RIGHT);
                        break;
                }
            }
        });
    }
    //食物
    private void initFood(){
        food=new Node();
        food.radom();

    }


    public static void main(String[] args) {
        new MainFrame().setVisible(true);


    }
}