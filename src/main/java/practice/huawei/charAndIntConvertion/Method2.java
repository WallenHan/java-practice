package practice.huawei.charAndIntConvertion;

import java.util.*;

public class Method2 {
    public static void main (String[] args){
//        Scanner sc = new Scanner(System.in);
//        String str = new String();
//        while (sc.hasNext()) {
//            str = sc.nextLine();
//            convert(str);
//            return ;
//        }
        convert("27");
    }

    private static void convert( String str ){
        int result = 0;
        if(str.matches("[a-z]+")){  // 字母到数字
            int length = str.length();
            // 从 str 正序 x 进制换算 char 到 int 得到对应的asc码值 - 96
            for(int m=length-1;  m >= 0; m--){
                result += (int)Math.pow(26L, m)* (int)(str.charAt(length - (m + 1)) - 96);
            }
            System.out.println(result);
        }else if(str.matches("[0-9]+")){  // 数字到字母
            // 先将 数字字符串转化成 int
            int  num =  Integer.parseInt(str, 10);
            // 处理成每个26 进制 上字母的对应 asc 码
            List<Integer> intList  = new ArrayList<Integer>();
            while( num > 0){
                intList.add(num%26 + 96);
                num= num/26;
            }
            StringBuffer fb = new StringBuffer();
            for (Integer item : intList){
                fb.append((char) item.intValue());
            }
            System.out.println(fb.reverse()); //倒序输出
        } else {  //异常情况
            System.out.println("ERROR");
        }
    }
}
