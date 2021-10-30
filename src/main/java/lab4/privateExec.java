package lab4;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface privateExec {
    int execCount() default 1;
}
