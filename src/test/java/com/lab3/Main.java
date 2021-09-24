package com.lab3;

import lab3.Queue;
import lab3.animals.classification.Cat;
import lab3.animals.classification.Chorda;
import lab3.animals.classification.DomesticCat;
import lab3.animals.classification.ForestCat;
import lab3.exceptions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Main {

    @Test
    @DisplayName("Queue Underflow Exception")
    public void QueueUnderflowExceptionTest() {
        Queue<Integer> queue = new Queue<>(10, Integer.class);

        Throwable throwable1 = catchThrowable(queue::pop);
        assertThat(throwable1).isInstanceOf(QueueUnderFlow.class);
        assertThat(throwable1.getMessage()).isNotBlank();

        Throwable throwable2 = catchThrowable(()->{
            queue.add(5);
            queue.pop();
            queue.pop();
        });
        assertThat(throwable2).isInstanceOf(QueueUnderFlow.class);
        assertThat(throwable2.getMessage()).isNotBlank();
    }

    @Test
    @DisplayName("Queue OverFlow Exception")
    public void QueueOverFlowExceptionTest() {
        Queue<Integer> queue = new Queue<>(5, Integer.class);

        Throwable throwable2 = catchThrowable(()->{
            queue.add(1);
            queue.add(2);
            queue.add(3);
            queue.add(4);
            queue.add(5);
            queue.add(6);
        });
        assertThat(throwable2).isInstanceOf(QueueOverFlow.class);
        assertThat(throwable2.getMessage()).isNotBlank();
    }

    @Test
    public void QueueIsEmptyTest() throws QueueOverFlow, QueueUnderFlow {
        Queue<String> queue = new Queue<>(10, String.class);
        queue.add("lol");
        queue.add("mem");
        queue.add("trash");

        Assertions.assertFalse(queue.isFull());

        queue.pop();
        queue.pop();
        queue.add("vk");
        queue.pop();
        queue.pop();

        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void QueueIsFullTest() throws QueueOverFlow, QueueUnderFlow {
        Queue<String> queue = new Queue<>(3, String.class);
        queue.add("lol");
        queue.add("mem");
        queue.add("trash");
        queue.pop();
        queue.pop();
        queue.add("vk");
        queue.add("inst");
        Assertions.assertTrue(queue.isFull());
    }

    @Test
    @DisplayName("Correct Job Of Queue")
    public void CorrectJobOfQueue() throws QueueUnderFlow, QueueOverFlow {
        Queue<Cat> queue = new Queue<>(10, Cat.class);

        queue.add(new DomesticCat("a"));
        queue.add(new ForestCat("b"));
        queue.add(new DomesticCat("c"));
        queue.add(new DomesticCat("d"));
        queue.pop();
        queue.pop();
        queue.pop();
        queue.add(new DomesticCat("e"));
        queue.add(new DomesticCat("f"));

        Assertions.assertEquals("Elements=[DomesticCat d, DomesticCat e, DomesticCat f]", queue.toString());
    }

    @Test
    @DisplayName("Illegal class Test")
    public void ClassCastExceptionTest() throws QueueOverFlow {
        Queue<Integer> queue = new Queue<>(10, Integer.class);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        Throwable throwable = catchThrowable(()-> queue.add(1.0d));

        assertThat(throwable).isInstanceOf(ClassCastException.class);
        assertThat(throwable.getMessage()).isNotBlank();
    }

    @Test
    @DisplayName("Legal class наследник Test")
    public void ClassCastLegalTest() throws QueueOverFlow {
        Queue<Cat> queue = new Queue<>(10, Cat.class);
        queue.add(new DomesticCat("lol1"));
        queue.add(new ForestCat("lol2"));
        queue.add(new Cat("lol3"));
        Throwable throwable = catchThrowable( ()->{
                    queue.add(new Chorda("lol4"));
        });
        assertThat(throwable).isInstanceOf(ClassCastException.class);
        assertThat(throwable.getMessage()).isNotBlank();
    }
}
