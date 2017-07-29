import java.util.*;
/**
 * Created by yongchizhang on 17/6/27.
 */
public class HUAWEI {


        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            while(in.hasNext()){
                String s1 = in.next();
                String s2 = in.next();
                String s = s1 + s2;
                StringBuffer sb1 = new StringBuffer();
                StringBuffer sb2 = new StringBuffer();
                for(int i=0;i<s.length();i++){
                    if(i%2==0){
                        sb1.append(s.charAt(i));
                    }else{
                        sb2.append(s.charAt(i));
                    }
                }
                char[] chs1 = sb1.toString().toCharArray();
                char[] chs2 = sb2.toString().toCharArray();
                Arrays.sort(chs1);
                Arrays.sort(chs2);


                char [] cha = new char[chs1.length+chs2.length];
                int j = 0, k = 0;
                for (int i=0; i<cha.length; i++)
                {
                    if (i%2 == 0)
                    {
                        cha[i] = chs1[j];
                        j++;
                    }
                    else
                    {
                        cha[i] = chs2[k];
                        k++;
                    }

                }

                for (int i=0; i<cha.length; i++)
                {
                    cha[i] = change(cha[i]);
                }

                System.out.println(cha);
            }

            in.close();
        }

        //     不明觉厉
        public static char change(char a) {
            char res;
            switch (a) {
                case '0': res='0';break;
                case '1': res='8';break;
                case '2': res='4';break;
                case '3': res='C';break;
                case '4': res='2';break;
                case '5': res='A';break;
                case '6': res='6';break;
                case '7': res='E';break;
                case '8': res='1';break;
                case '9': res='9';break;

                case 'A': res='5';break;
                case 'B': res='D';break;
                case 'C': res='3';break;
                case 'D': res='B';break;
                case 'E': res='7';break;
                case 'F': res='F';break;

                case 'a': res='5';break;
                case 'b': res='D';break;
                case 'c': res='3';break;
                case 'd': res='B';break;
                case 'e': res='7';break;
                case 'f': res='F';break;
                default :res=a;
            }
            return res;
        }



}
