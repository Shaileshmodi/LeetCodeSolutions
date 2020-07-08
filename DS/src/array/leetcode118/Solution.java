package array.leetcode118;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> mainList=new LinkedList<>();
        if(numRows==0)
            return mainList;
        List<Integer> firstRow=new ArrayList<>(1);
        firstRow.add(1);
        mainList.add(firstRow);
        
        List<Integer> prev=firstRow;
        for(int i=2;i<=numRows;i++){
           List<Integer> list=new ArrayList<>(i);
           list.add(1);
            
           int first=1;
           int last=i-1;
           while(first<last){
                list.add(prev.get(first)+prev.get(first-1));
                first++;
            }
           
            list.add(1);        
            prev=list;
            mainList.add(list);
       }
        return mainList;
    }


    public static void main(String[] args) {
        System.out.println(BigDecimal.valueOf(14.567).setScale(2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)).setScale(0));
    }
}