package lab1;

public class Point {

    private static int x = 0;
    private static int y = 0;

    public Point(){
    }

    public Point(int x, int y){
        this.x += x;
        this.y += y;
    }

    public Point getcheckpoint(){
        return new Point();
    }

    public void get(){
        System.out.print(this.x + " ");
        System.out.println(this.y);
    }

}
