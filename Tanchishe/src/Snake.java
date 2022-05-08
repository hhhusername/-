import java.awt.*;
import java.util.LinkedList;

public class Snake {
    //身体
    private LinkedList<Node> body;
    //蛇头运动方向 默认向左
    private Direction direction=Direction.LEFT;
    //蛇死活
    private boolean isliving=true;

    public void setBody(LinkedList<Node> body) {
        this.body = body;
    }

    //身体
    public Snake(){
        initSnake();
    }

    private void initSnake(){
        body=new LinkedList<>();

        body.add(new Node(20,20));
        body.add(new Node(21,20));
        body.add(new Node(22,20));

    }

    //以蛇头方向动
    //给蛇运动方向加节点，去除最后一个节点
    public void move(){
        if(isliving) {
            //获取蛇头
            Node head = body.getFirst();
            switch (direction) {
                case UP:
                    body.addFirst(new Node(head.getX(), head.getY() - 1));
                    break;
                case DOWN:
                    body.addFirst(new Node(head.getX(), head.getY() + 1));
                    break;
                case RIGHT:
                    body.addFirst(new Node(head.getX() + 1, head.getY()));
                    break;
                case LEFT:
                    body.addFirst(new Node(head.getX() - 1, head.getY()));
                    break;
            }
            //删除最后节点
            body.removeLast();

            //判断撞墙
            head=body.getFirst();
            if(head.getX()<0||head.getY()<0||head.getX()>=40||head.getY()>=40){
                isliving=false;
            }
            //是否碰到身体
            for (int i=1;i<body.size();i++) {
                Node node=body.get(i);
                if(head.getX()==node.getX() && head.getY()==node.getY()){
                    isliving=false;
                }

            }

        }
    }

    public LinkedList<Node> getBody() {
        return body;
    }
    public Direction getDirection(){
        return direction;
    }

    public void setDirection(Direction direction){
        this.direction=direction;
    }
    //吃食物 蛇头方向+节点
    public void eat(Node food){
        Node head = body.getFirst();
        switch (direction) {
            case UP:
                body.addFirst(new Node(head.getX(), head.getY() - 1));
                break;
            case DOWN:
                body.addFirst(new Node(head.getX(), head.getY() + 1));
                break;
            case RIGHT:
                body.addFirst(new Node(head.getX() + 1, head.getY()));
                break;
            case LEFT:
                body.addFirst(new Node(head.getX() - 1, head.getY()));
                break;
        }

    }
}