package algorithm;


//输入：
//        ["a","a","b","b","c","c","c"]
//
//        输出：
//        返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
//
//        说明：
//        "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。

public class StrCompress {
    public static int compress(char[] chars) {
        int k = 0;
        int write = 0;
        int start = 0;
        int check = 1;
        int num = 1;
        int i = chars.length;
        while (i > 1){
            if (chars[start]==chars[check]){
                num++;
                check++;
                k++;
            } else if (num == 1) {
                chars[write] = chars[start];
                System.out.println("验错");
                write++;
                start++;
                check = start+1;
            } else {
                System.out.println("验错1");
                chars[write++] = chars[start];
                String strnum = String.valueOf(num);
                int strlen = strnum.length();
                for (int j = 0; j < strlen; j++){
                    chars[ write++ ] = strnum.charAt(j);
                }
                start = check++;
                num = 1;
            }
            i--; System.out.println("i:"+i);System.out.println("write:"+write+"start:"+start+"check:"+check);
        }
        System.out.println("k:"+k);
        System.out.println("num:"+num);
        return write;
    }

    public static void main(String[] args) {
        char[] chars = {'c','c','a','d','f','f','b','b','b','b','b','b','b','b','b','b',' '}; //'a','a','b','b','c','c','c'
        System.out.println("数组长度："+chars.length);
        int newnum = compress(chars);
        System.out.println("newnum:"+newnum);
        for (int i=0; i<chars.length; i++){
            System.out.print(chars[i]);
        }
    }
}
