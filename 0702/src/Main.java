import java.util.*;

public class Main {
    public static int countNum(int n) {
        if (n <= 9) return n;
        return n%10 + countNum(n/10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String strIp = sc.nextLine();
            long numIp = Long.parseLong(sc.nextLine());
            System.out.println(ipToNum(strIp));
            System.out.println(numToIp(numIp));
        }
    }

    public static long ipToNum(String str){
        String[] strlist = str.split("\\.");
        StringBuilder sbAll = new StringBuilder();
        for (String s : strlist) {
            StringBuilder sb = new StringBuilder();
            sb.append(Long.toBinaryString(Long.parseLong(s)));
            while (sb.length() < 8) {
                sb.insert(0, 0);
            }
            sbAll.append(sb);
        }
        return Long.valueOf(sbAll.toString(), 2);
    }

    public static String numToIp(long n){
        StringBuilder sb = new StringBuilder();
        StringBuilder numSb = new StringBuilder();
        sb.append(Long.toBinaryString(n));
        while(sb.length()<32){
            sb.insert(0, 0);
        }
        for(int i=0;i<4;i++){
            String temp = sb.substring(i*8, i*8+8);
            numSb.append(Long.valueOf(temp, 2));
            numSb.append(".");
        }
        numSb.deleteCharAt(numSb.length()-1);
        return numSb.toString();
    }

    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(in.nextInt(),i);
            }
            int k = in.nextInt();
            if (map.containsKey(k)) {
                System.out.println(map.get(k));
            }else {
                System.out.println(-1);
            }
        }
    }
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            LinkedHashMap<String ,Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(in.next(),0);
            }
            map.put("Invalid",0);
            int m = in.nextInt();
            for (int i = 0; i < m; i++) {
                String s = in.next();
                if (map.containsKey(s)) {
                    map.put(s,map.get(s)+1);
                }else {
                    map.put("Invalid",map.get("Invalid")+1);
                }
            }
            for (String s1: map.keySet()) {
                System.out.println(s1+" : "+map.get(s1));
            }

            for (Map.Entry<String, Integer> set : map.entrySet()) {
                System.out.println(set.getKey()+" : "+set.getValue());
            }
        }
    }
    public static void main1(String[] args) {
        Scanner in =new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (in.hasNext()) {
            list.add(in.nextInt());
        }
        for (int n : list) {
            int k1 = countNum(n);
            int k2 = countNum(n*n);
            System.out.println(k1 + " " + k2);
        }
    }
}
