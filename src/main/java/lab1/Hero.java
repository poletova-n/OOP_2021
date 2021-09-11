package lab1;

public class Hero {
    private Move m;
    private Point p;
    private String move;

    public Hero() {
        m = new Walk();
        p = new Point();
    }

    public void choise(String move){
        this.move = move;
        switch (move){
            case("Walk"):m = new Walk();break;
            case("Horse"):m = new Horse();break;
            case("Fly"):m = new Fly();break;
            case("Swim"):m = new Swim();break;
            case("Avto"):m = new Avto();break;
            default:m = new Walk();break;
        }
    }

    public void move(){
        switch (move){
            case("Walk"):m.move(p.getcheckpoint(), new Point(1,1));p.get();break;
            case("Horse"):m.move(p.getcheckpoint(), new Point(3,3));p.get();break;
            case("Fly"):m.move(p.getcheckpoint(), new Point(10,10));p.get();break;
            case("Swim"):m.move(p.getcheckpoint(), new Point(5,5));p.get();break;
            case("Avto"):m.move(p.getcheckpoint(), new Point(7,7));p.get();break;
            default:m.move(p.getcheckpoint(), new Point(1,1));p.get();break;
        }
    }
}
