public class Main {
    public static void main (String[] args){

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println(a);
        System.out.println(b);

        int tmp;
        while (a % b !=0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }

        System.out.println(b);

        if (b == 1)
            System.out.println("prime");
        else
            System.out.println("not prime");


    }

}
