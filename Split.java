/**
 * Created by yongchizhang on 17/7/4.
 */
public class Split {

    public static void main(String[] args) {
        String str1 = "a-b";
        String str2 = "a-b-";
        String str3 = "-a-b";
        String str4 = "-a-b-";
        String str5 = "a";
        String str6 = "-";
        String str7 = "--";
        String str8 = "";

        split(str1);
        split(str2);
        split(str3);
        split(str4);
        split(str5);
        split(str6);
        split(str7);
        split(str8);
    }
    public static void split(String demo){
        String[] array = demo.split("-");
        int len = array.length;
        System.out.print("\"" + demo + "\" 分割后的长度为：" + len);
        if(len >= 0)
        {
            System.out.print(",分割后的结果为：");
            for(int i=0; i<len; i++)
            {
                System.out.print(" \""+array[i]+"\"");
            }
        }
        System.out.println();
    }



    /*
    *

运行结果为：
"a-b" 分割后的长度为：2,分割后的结果为： "a" "b"
"a-b-" 分割后的长度为：2,分割后的结果为： "a" "b"
"-a-b" 分割后的长度为：3,分割后的结果为： "" "a" "b"
"-a-b-" 分割后的长度为：3,分割后的结果为： "" "a" "b"
"a" 分割后的长度为：1,分割后的结果为： "a"
"-" 分割后的长度为：0,分割后的结果为：
"--" 分割后的长度为：0,分割后的结果为：
"" 分割后的长度为：1,分割后的结果为： ""
由此可以得出来：
当字符串只包含分隔符时，返回数组没有元素；
当字符串不包含分隔符时，返回数组只包含一个元素（该字符串本身）；
字符串最尾部出现的分隔符可以看成不存在，不影响字符串的分隔；
字符串最前端出现的分隔符将分隔出一个空字符串以及剩下的部分的正常分隔；


1、如果用“.”作为分隔的话,必须是如下写法,String.split("\\."),这样才能正确的分隔开,不能用String.split(".");

2、如果用“|”作为分隔的话,必须是如下写法,String.split("\\|"),这样才能正确的分隔开,不能用String.split("|");

“.”和“|”都是转义字符,必须得加"\\";

3、如果在一个字符串中有多个分隔符,可以用“|”作为连字符,比如,“acount=? and uu =? or n=?”,把三个都分隔出来,可以用String.split("and|or");



    *
    * */

}
