public class Calculations {
    public static void main(String[]args){
        int iResult;
        double dResult;
        int i1=2, i2=16, i3=7;
        double d1=2.5, d2=3.25, d3=12.5;

        //add subtract
        iResult=i1+i2;
        System.out.println("iresult=i1+i2: "+iResult);
        iResult=i1-i2;
        System.out.println("iresult=i1-i2: "+iResult);

        //multiply divide
        dResult=d1*d2;
        System.out.println("dresult=d1*d2: "+dResult);
        dResult=d1/d2;
        System.out.println("dresult=d1/d2: "+dResult);

        //modulus %
        iResult=i2%i3;
        System.out.println("iresult=i2%i3: "+iResult);
        iResult=i2%i1;
        System.out.println("iresult=i2%i1: "+iResult);

        //compound operators += -= *= /= ++ --
        dResult+=d2; // dResult=dResult+d2;
        System.out.println("dResult+=d2: "+dResult);

        iResult++;
        System.out.println("iresult++: "+iResult);
        iResult--;
        System.out.println("iresult--: "+iResult);

        //int problems!!
        iResult=i2/i3;
        System.out.println("iresult=i2/i3: "+iResult);
        iResult=i1/i3;
        System.out.println("iresult=i1/i3: "+iResult);

        //Operator Precedence
        //PMDAS - sort of. . .
        dResult=(i2/i1+(i2-d3*i3))*(d1+d2/i3);
        System.out.println("dresult=(i2/i1+(i2-d3*i3))*(d1+d2/i3): "+dResult);


    }
}
