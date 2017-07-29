/**
 * Created by yongchizhang on 17/7/13.
 */
public class Math_isPowerof3 {
    public class Solution {
        public boolean isPowerOfThree(int n) {
            if(n <= 0){
                return false;
            }
            if(n == 1){
                return true;
            }
            while(n > 1){
                if(n % 3 != 0){
                    return false;
                }
                n /= 3;
            }
            return true;
        }
    }


    public class Solution2 {
        public boolean isPowerOfThree(int n) {
            // 1162261467 is 3^19,  3^20 is bigger than int
            return (n > 0 && 1162261467 % n == 0);
        }


/*
    class Solution {
        public:
        int const Max3PowerInt = 1162261467; // 3^19, 3^20 = 3486784401 > MaxInt32
        int const MaxInt32 = 2147483647; // 2^31 - 1
        bool isPowerOfThree(int n) {
            if (n <= 0 || n > Max3PowerInt) return false;
            return Max3PowerInt % n == 0;
        }
    };
*/
    }


    public class Solution_isPoweroftwo {
        public boolean isPowerOfTwo(int n) {
            return (n > 0 && 1073741824 % n == 0);
        }
    }



    public class SolutionPowerTwo {
        public boolean isPowerOfTwo(int n) {
            if(n <= 0){
                return false;
            }

            //这个括号不能括错位置！！！！ == 的优先级比 & 高！！
            return (n & (n - 1) )== 0 ;
        }
    }
}
