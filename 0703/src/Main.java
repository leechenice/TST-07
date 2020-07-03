import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        int[] value = new int[n];
        long[] dp = new long[sum + 1];
        dp[0] = 1;
        int i,j;
        for (i = 0; i < n; i++) {
            value[i] = in.nextInt();
            for (j = sum; j >= value[i]; j--) {
                dp[j] += dp[j - value[i]];
            }
        }
        System.out.println(dp[sum]);
    }
    public static double errSort(int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        return (n-1)*(errSort(n-1) + errSort(n-2));
    }
    public static double factorial(int n) {
        if(n == 1) return 1;
        return n*factorial(n-1);
    }

    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            double k = errSort(n) / factorial(n) * 100;
            System.out.println(String.format("%.2f",k)+"%");
        }
    }
    public static boolean numEight(String s) {
        return s.length() > 8;
    }
    public static boolean repeatTwo(String s) {
        for (int i = 0; i < s.length()-3; i++) {
            if (s.substring(i+1).contains(s.substring(i,i+3))) {
                return false;
            }
        }
        return true;
    }
    public static boolean containStr(String s) {
        int a = 0,b = 0,c = 0,d = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                a = 1;
            }else if (ch >= 'a' && ch <= 'z') {
                b = 1;
            }else if (ch >= 'A' && ch <= 'Z') {
                c = 1;
            }else {
                d = 1;
            }
        }
        return a+b+c+d >= 3;
    }
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (numEight(s) && repeatTwo(s) && containStr(s)) {
                System.out.println("OK");
            }else {
                System.out.println("NG");
            }
        }
    }
    public static boolean conservativeNum(int n) {
        String s1 = String.valueOf(n);
        String s2 = String.valueOf(n*n);
        String s3 = s2.substring(s2.length()-s1.length());
        return s1.equals(s3);
    }
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (in.hasNext()) {
            arrayList.add(in.nextInt());
        }
        for (int i : arrayList) {
            if (conservativeNum(i)) {
                System.out.println("Yes!");
            }else {
                System.out.println("No!");
            }
        }
    }
}
