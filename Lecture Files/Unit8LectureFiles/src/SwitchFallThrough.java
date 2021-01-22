
public class SwitchFallThrough{

    public static void main(String[]args){
        int number=8;
        switch(number){
            case 1:
            case 2:
            case 3:
                System.out.println("first third");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("second third");
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                System.out.println("last third");
                break;
        }

        switch(number){
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
            case 3:
                System.out.println("three");
                break;
            case 4:
                System.out.println("four");
            case 5:
                System.out.println("five");
            case 6:
                System.out.println("six");
                break;
            case 7:
                System.out.println("seven");
            case 8:
                System.out.println("eight");
            case 9:
                System.out.println("nine");
            case 10:
                System.out.println("ten");
                break;
        }
    }
}
