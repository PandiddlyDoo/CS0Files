public class MixingTypes {
    public static void main(String[]args){
        byte b1=127; //8 bits -128==>127
        short s1=12345; //16bit -32768==>32767
        int i1=12;//32bit -2,147,483,648==>2,147,483,647
        long l1=12345678L;//64bit -9.223372e+18==>9.223372e+18
        char ch1='A';//16bit

        //floating point types
        float f1=12.3f;//32bit floating point
        double d1=12.3;//64bit floating point

        //widening conversions
        d1=f1+i1;
        System.out.println(d1);

        f1=i1-b1;
        System.out.println(f1);

        //s1=i1*l1;does not work!

        //cast conversions
        s1=(short)(i1*l1);
    }
}
