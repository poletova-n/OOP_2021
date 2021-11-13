package lab4;

public class Felings {

    private String fell ;
    private int count ;

    public Felings(){
    this.count=0;
    this.fell="Nothing";
    }

    @About
    private void vois() {
        System.out.println("I fill "+fell);
        System.out.println("Count: "+count);
    }

    @About
    private void sun() {
        Felings felings=new Felings();
        felings.count = felings.count + 1;
        felings.fell = felings.fell + ", hot";
    }

    @About
    private void winter() {
        this.count = this.count + 1;
        this.fell = this.fell + ", cold";
    }

    @About
    private void rain() {
        Felings felings=new Felings();
        felings.count = felings.count + 1;
        felings.fell = felings.fell + ", rain";
    }

}
