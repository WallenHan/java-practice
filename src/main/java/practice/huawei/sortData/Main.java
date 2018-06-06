package practice.huawei.sortData;


import java.util.*;

/**
 * Created by Wallen on 2018/06/01.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[12];
//        int[]  nums = {5, 2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // 将数据存入数组
        for(int i=0; i <nums.length; i++){
            if(sc.hasNextInt()){
                nums[i] = sc.nextInt();
            }
        }
        // 存储结果集 hashmap
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (int i = 2; i< nums.length; i++) {
            int sumByte = (nums[i] >> 24)
                    + (nums[i] & 0x00FFFFFF >> 16)
                    + (nums[i] & 0x0000FFFF >> 8)
                    + (nums[i] & 0x000000FF);
            int remain = sumByte % nums[1];
            if( remain < nums[0]){
                result.put(remain, result.containsKey(remain) ?  result.get(remain) + 1 :  1);
            }
        }
        //取出 value 最大值 输出
        int maxTime = result.values().stream()
                .max(Comparator.<Integer>naturalOrder())
                .get();
        System.out.println(maxTime);
    }
}
