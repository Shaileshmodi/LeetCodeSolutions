package may29;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 *
 *
 *
 */

/**
 * @author shailesh.modi
 * @version 1.0.0
 * @since 5/29/2020
 */
public class May29CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // base case:Leetcode wants this to be true    :)

        if(prerequisites.length==0)
            return true;

        Graph graph = new Graph(numCourses);
        for(int i=0;i<prerequisites.length;i++){
            graph.addEdge(prerequisites[i][0],prerequisites[i][1]);
        }

        //If graph does not contain cycle,Means the courses can be completed
        return !graph.hasCycle();
    }




    class Graph {
        int numberOfV;
        List<List<Integer>> adjacenyList;

        public Graph(int numberOfV){
            this.numberOfV = numberOfV;
            this.adjacenyList = new ArrayList<List<Integer>>(numberOfV);
            for (int i = 0; i < numberOfV; i++)
                adjacenyList.add(new LinkedList<>());
        }

        public void addEdge(int s,int d){
            adjacenyList.get(s).add(d);
        }


        public boolean hasCycle(){
            boolean visited[]=new boolean[numberOfV];
            boolean rec[]=new boolean[numberOfV];
            for(int i=0;i<numberOfV;i++){
                if(visited[i])//dont check if already visited
                    continue;

                if(hasCycle(i,visited,rec))
                    return true;
            }
            return false;
        }



        private boolean hasCycle(int i,boolean[] visited,boolean[] rec){
            if(rec[i])
                return true;

            visited[i]=true;
            rec[i]=true;
            List<Integer> list= adjacenyList.get(i);

            for(int j=0;j<list.size();j++){
                if(hasCycle(list.get(j),visited,rec))
                    return true;
            }
            rec[i]=false;
            return false;
        }
    }


    public static void main(String[] args) {
        May29CourseSchedule object=new May29CourseSchedule();
        System.out.println(object.canFinish(32,new int[][]{{0,1}}));
        System.out.println(object.canFinish(32,new int[][]{{0,1},{1,0}}));
    }
}
