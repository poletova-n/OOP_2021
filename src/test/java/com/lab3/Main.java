package com.lab3;

import lab3.Queue;
import lab3.animals.classification.*;
import lab3.exceptions.QueueOverFlow;
import lab3.exceptions.QueueUnderFlow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class Main {

    @Test
    @DisplayName("Queue Underflow Exception")
    public void QueueUnderflowExceptionTest() {
        Queue<DomesticCat> queue = new Queue<>(5);

        Throwable throwable1 = catchThrowable(()->{
            queue.pop();
        });
        assertThat(throwable1).isInstanceOf(QueueUnderFlow.class);
        assertThat(throwable1.getMessage()).isNotBlank();

        Throwable throwable2 = catchThrowable(()->{
            queue.add(new DomesticCat("a"));
            queue.pop();
            queue.pop();
        });
        assertThat(throwable2).isInstanceOf(QueueUnderFlow.class);
        assertThat(throwable2.getMessage()).isNotBlank();

    }

    @Test
    @DisplayName("Queue Overflow Exception")
    public void QueuevOverflowExceptionTest() {
        Queue<DomesticCat> queue = new Queue<DomesticCat>(5);

        Throwable throwable1 = catchThrowable(()->{
            queue.add(new DomesticCat("a"));
            queue.add(new DomesticCat("a"));
            queue.add(new DomesticCat("a"));
            queue.add(new DomesticCat("a"));
            queue.add(new DomesticCat("a"));
            queue.add(new DomesticCat("a"));
        });
        assertThat(throwable1).isInstanceOf(QueueOverFlow.class);
        assertThat(throwable1.getMessage()).isNotBlank();

    }

    @Test
    @DisplayName("Correct Job Of Queue")
    public void CorrectJobOfQueue() throws QueueOverFlow, QueueUnderFlow {
        Queue<DomesticCat> queue = new Queue<DomesticCat>(5);

        queue.add(new DomesticCat("a"));
        queue.add(new DomesticCat("b"));
        queue.add(new DomesticCat("c"));
        queue.add(new DomesticCat("d"));
        queue.pop();
        queue.pop();
        queue.pop();
        queue.add(new DomesticCat("e"));
        queue.add(new DomesticCat("f"));

        Assertions.assertEquals(queue.toString(), "Elements=[d, e, f]");
    }
}

