/**
 * Created by yongchizhang on 17/7/26.
 */
import java.util.*;
public class Array_PascalTriangle {


    public class Solution_getKthRow {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> result = new ArrayList<>();
            if(rowIndex < 0){
                return result;
            }
            for(int i = 0; i <= rowIndex; i++){
                result.add(0, 1);
                for(int j = 1; j < result.size() - 1; j++){
                    result.set(j, result.get(j) + result.get(j + 1));
                }
            }
            return result;
        }
    }


    public class Solution_best {
        public List<List<Integer>> generate(int numRows)
        {
            List<List<Integer>> allrows = new ArrayList<List<Integer>>();
            List<Integer> row = new ArrayList<Integer>();
            for(int i=0;i<numRows;i++)
            {
                row.add(0, 1);
                for(int j=1;j<row.size()-1;j++)
                    row.set(j, row.get(j)+row.get(j+1));
                allrows.add(new ArrayList<Integer>(row));
            }
            return allrows;

        }
    }



    public class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            if(numRows <= 0){
                return result;
            }
            List<Integer> element = new ArrayList<>();
            element.add(1);
            result.add(new ArrayList<Integer>(element));
            if(numRows == 1){
                return result;
            }
            element.add(1);
            result.add(element);
            int i = 2;
            while(i < numRows){
                List<Integer> temp = result.get(i - 1);
                List<Integer> ele = new ArrayList<>();
                int num = -1;
                for(int e: temp){
                    if(num == -1){
                        ele.add(e);
                        num = e;
                    }else{
                        ele.add(num + e);
                        num = e;
                    }
                }
                ele.add(1);
                result.add(ele);
                i++;
            }
            return result;
        }
    }
}
