/*Написать аннотацию с целочисленным параметром. Создать класс,
        содержащий только приватные методы (3–4 шт.), аннотировать любые
        из них. Вызвать из другого класса все аннотированные методы столько
        раз, сколько указано в параметре аннотации.

        @Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface CanRun{
    int count();
}

абираем аннотацию у метода и в цикле вызываем метод нужное количество раз. В самом простом примере должно быть примерно так:

Method method = myInstance.getClass().getMethod("methodName", methodParams);
CanRun annotation = method.getAnnotation(CanRun.class);
if (annotation != null) {
    int count = annotation.count();
    for (int i = 0; i < count; i++) {
        method.invoke(myInstance, parameters);
    }
}
где

myInstance - объект, у которого будут искаться методы

methodParams - классы параметров

parameters - список параметров, с которыми запустить метод*/
package lab4;

import java.lang.reflect.InvocationTargetException;
import static lab4.Run.run;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       Felings felings=new Felings();
        run(felings);

    }
}