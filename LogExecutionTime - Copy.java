//package amalitech;
//
//import java.lang.reflect.InvocationTargetException;
//import java.sql.Timestamp;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//@MyAnnotation(name = "LogExecutionTime")
//public class LogExecutionTime {
//    public void logExecTime() {
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        System.out.println("Method executed at: " + timestamp);
//
//    }
//
//    public static void main(String[] args)
//            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//
//        Class<?> orderProcessorClass = OrderProcessor.class;
//
//    }
//
//}
//@interface MyAnnotation {
//    String name();
//}
//
