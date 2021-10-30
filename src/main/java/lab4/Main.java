package lab4;

import java.lang.reflect.Method;

// Walking must be executed 4 times
// Sitting must be executed 3 times
// Greeting must be executed 2 times
// Talking must be executed once as default annotation execCount value

public class Main {

    public static void main(String[] args) {

        try{

            Method[] methods = Human.class.getDeclaredMethods();
            Human human = new Human();

            for (Method method : methods) {

                if (method.isAnnotationPresent(privateExec.class)){

                    method.setAccessible(true);

                    int count = method.getAnnotation(privateExec.class).execCount();

                    while (count > 0){

                        method.invoke(human);
                        count--;

                    }

                }
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }

    }
}