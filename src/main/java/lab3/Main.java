package lab3;

import lab3.exceptions.*;
import lab3.animals.*;

public class Main {
	public static void main(String[] args) throws QueueOverflow, QueueUnderflow
	{
		Queue<? extends Chordates> queueFifteen = new Queue<>(15);
		queueFifteen = queueFifteen.produce();
		queueFifteen.print();
		queueFifteen.consume(Deer.class);
		queueFifteen.print();

		System.out.println();

		Queue<? extends Chordates> queueTen = new Queue<>(10);
		queueTen.add(new Tunicates());
		queueTen.add(new Pseudusa());
		queueTen.add(new Boa());
		queueTen.print();
		queueTen = queueTen.produce();
		queueTen.print();
		queueTen.consume(Clavelinids.class);
		queueTen.print();
		
		System.out.println();
		
		Queue<? extends Chordates> queueFull = new Queue<>(48);
		queueFull = queueFull.produce();
		queueFull.print();
		queueFull.consume(Pseudusa.class);
		queueFull.print();
		queueFull = queueFull.produce();
		queueFull.consume(Pseudusa.class);
		queueFull.print();
	}
}
