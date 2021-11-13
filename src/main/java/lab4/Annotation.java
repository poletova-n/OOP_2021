package lab4;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Annotation {
    public int value() default 1;
    //int value();
}
