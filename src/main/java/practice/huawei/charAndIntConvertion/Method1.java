package practice.huawei.charAndIntConvertion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class Method1 {
    public static void main111(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = new String();
        while (sc.hasNext()) {
            str = sc.nextLine();
            convertTo26(str);
            return;
        }

    }

    private static  void convertTo26 (String str) {
        int result = 0;

        if(str.matches("[a-z]+")){  // 将字母转化为数字
            int count = str.length();
            for(int m =  count-1;  m >= 0; m--){
                    result += (int)Math.pow(26L, m)* (int)(str.charAt(count- (m + 1)) - 96);
            }
            System.out.println(result);

        }else if (str.matches("[0-9]+")){  //将数字转化为字母
            int num=Integer.parseInt(str);
            int mod=0;
            List<Integer> list=new ArrayList<>();
            while(num!=0){
                mod=num%26;
                num=num/26;
                list.add(mod);
            }
            Collections.reverse(list);
            StringBuffer fb = new StringBuffer();
            for (Integer item : list){
                fb.append((char) item.intValue());
            }
            fb.reverse().toString();
            String resultStr = new String();
            for (int i = 0; i < list.size(); i++) {
                resultStr+=String.valueOf((char)(list.get(i)+96));
            }
            System.out.println(resultStr);
        } else { //  不符合的情况
            System.out.println("ERROR");
        }
    }

}
