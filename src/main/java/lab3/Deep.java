package lab3;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface Deep {
    int deep() default 0;
}
