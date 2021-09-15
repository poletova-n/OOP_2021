package com.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Example {
    @Test
    @Disabled("Not implemented yet")
    void shouldShowSimpleAssertion(){
        Assertions.assertEquals(1,2);
    }
}
