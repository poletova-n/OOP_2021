package lab3;
import lab3.Hierarchy.*;

public class Main {
    public static void main(String[] args) {
        //Hierarchy hierarchy = new Hierarchy();
        Queue<Chordata> queue = new Queue(30);

        //queue.add(new Chordata("Chordata"));

        //queue.add(new Hierarchy.Mammalia("Mammalia"));
        queue.add(new Perissodactyla("Perissodactyla"));
        queue.add(new Carnivora("Carnivora"));
        queue.add(new Equidae("Equidae"));
        queue.add(new Canidae("Canidae"));
        queue.add(new Equus("Equus"));
        queue.add(new Canis("Canis"));
        queue.add(new EquusCaballus("EquusCaballus"));
        queue.add(new CanisFamiliaris("CanisFamiliaris"));


        //queue.add(new Aves("Aves"));
        queue.add(new Falconiformes("Falconiformes"));
        queue.add(new Psittaciformes("Psittaciformes"));
        queue.add(new Falconidae("Falconidae"));
        queue.add(new Psittacidae("Psittacidae"));
        queue.add(new Falco("Falco"));
        queue.add(new Amazona("Amazona"));
        queue.add(new FalcoPeregrinus("FalcoPeregrinus"));
        queue.add(new AmazonaOratrix("AmazonaOratrix"));

        //Hierarchy.Chordata chordata = new Hierarchy.Chordata("Chordata");
        System.out.println("1)");
        Queue q = queue.produce(new Falconidae("Falconidae"));
        q.print();

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("2)");
        Queue q1 = q.consume(new FalcoPeregrinus("FalcoPeregrinus"));
        q1.print();
    }
}
