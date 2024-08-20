package Labs;
import solutions.pack2.*;

public class Lab2_IsPrimeMain {
    public static void main(String[] args) {
        testIsPrime012();
        L2_IsPrimeInterface obj = new L2_IsPrime0();
        L2_IsPrimeInterface obj2 = new L2_IsPrime1();
        L2_IsPrimeInterface obj3 = new L2_IsPrime2();
        // System.out.println("Isprime0");
        // bench_isPrime(obj);
        System.out.println("Isprime1");
        bench_isPrime(obj2);
        System.out.println("Isprime2");
        bench_isPrime(obj3);
    }
    private static void testIsPrime012() {
        int N = 100;
        int count = 0;
        L2_IsPrimeInterface obj = new L2_IsPrime0();
        for (int n = 1; n < N; n++) {
            if (obj.isPrime(n)) count++;
        }
        System.out.println("Pi ("+ N + ")= " + count);
        count = 0;
        obj = new L2_IsPrime1();
        for (int n = 1; n < N; n++) {
            if (obj.isPrime(n)) count++;
        }
        System.out.println("Pi ("+ N + ")= " + count);
        count = 0;
        obj = new L2_IsPrime2();    
        for (int n = 1; n < N; n++) {
            if (obj.isPrime(n)) count++;
        }
        System.out.println("Pi ("+ N + ")= " + count);
    }
    public static void bench_isPrime(L2_IsPrimeInterface obj) { 
        int your_cpu_factor = 1; /* increase by 10 times */
        int N = 100;
        int count = 0;
        System.out.printf("%8s%9s%9s\n", "N", "Prime", "Time" );
        for (N = 100_000; N <= 1_000_000 * your_cpu_factor; N+= 100_000 * your_cpu_factor) {
            long start = System.currentTimeMillis();
            for (int n = 1; n < N; n++) {
                if (obj.isPrime(n)) count++;
            }
            long time = (System.currentTimeMillis() - start);
            System.out.printf("%8s%9s%9s", N, count, time);
            System.out.println();
        }
    }
}