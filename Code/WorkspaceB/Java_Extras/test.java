import java.util.*;

class test{
   public static void main(String[] args){

     Timer t = new Timer();
     MyTask mTask = new MyTask();
     // This task is scheduled to run every 10 seconds

     t.scheduleAtFixedRate(mTask, 0, 10000);
     System.out.println("YOLO");
   }

}