package june13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
             if(nums.length==0)
                return Collections.emptyList();

            int maxIndex=0;
            int maxLength=0;

            Arrays.sort(nums);
            List<Integer>[] result=new ArrayList[nums.length];

            for(int i=0;i<result.length;i++){
                result[i]= new ArrayList<Integer>(result.length);
            }

            for(int i=0;i<nums.length;i++){
                for(int j=0;j<i;j++){

                    if((nums[i]%nums[j]==0) && result[j].size()>result[i].size()){             
                        result[i].clear();
                        result[i].addAll(result[j]);
                    }
                }
                  result[i].add(nums[i]);
                    if(result[i].size()>maxLength){
                        maxLength=result[i].size();
                        maxIndex=i;
                    }

            }

            return result[maxIndex];   
        }




    }