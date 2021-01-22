public class CommonErrors {
    public static void main(String[]args){
        //infiniteLoop1();
        //infiniteLoop2();
        infiniteLoop3();
        //neverEnterLoop();
    }

    public static void infiniteLoop1(){
        int count=0;
        while(count<10){
            System.out.println("Count: "+count);
        }
        System.out.println("LoopDone!");
    }

    public static void infiniteLoop2(){
        int count=10;
        while(count>0){
            System.out.println("Count: "+count);
            count++;
        }
        System.out.println("LoopDone!");
    }

    public static void infiniteLoop3(){
        int count=10;
        while(count>0)
            System.out.println("Count: "+count);
        count--;
        System.out.println("LoopDone!");

    }

    public static void neverEnterLoop(){
        int count=10;
        while(count<0){
            System.out.println("Count: "+count);
            count++;
        }
        System.out.println("LoopDone!");
    }
}
