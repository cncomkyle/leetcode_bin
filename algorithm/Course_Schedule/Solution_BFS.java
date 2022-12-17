import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Solution_BFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) {
            return true;
        }
        int[] degrees = new int[numCourses];
        List<List<Integer>> courseDepList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int checkCnt = 0;
        for(int i=0;i<numCourses;i++) {
            courseDepList.add(new ArrayList<>());
        }
        
        for(int i=0;i<prerequisites.length;i++) {
            courseDepList.get(prerequisites[i][0]).add(prerequisites[i][1]);
            degrees[prerequisites[i][1]]++;
        }

        for(int i=0;i<numCourses;i++) {
            if(degrees[i] == 0) {
                queue.add(i);
                checkCnt++;
            }
        }

        Integer tmp;
        while((tmp = queue.poll()) != null) {
            List<Integer> tmpList = courseDepList.get(tmp);
            if(tmpList.size() == 0) {
                continue;
            }
            for(int i=0;i<tmpList.size();i++) {
                int index = tmpList.get(i);
                degrees[index]--;

                if(degrees[index] == 0) {
                    queue.add(index);
                    checkCnt++;
                }
            }
        }

        if(checkCnt == numCourses) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_BFS ins = new Solution_BFS();

        int[][] data_9 = {{0,1}};
        System.out.println(ins.canFinish(2, data_9));

        int[][] data_1 = {{1, 0}};
        System.out.println(ins.canFinish(2, data_1));

        int[][] data_2 = {{1, 0}, {0, 1}};
        System.out.println(ins.canFinish(2, data_2));

        int[][] data_3 = {{1, 0}, {0, 2}, {2, 1}};
        System.out.println(ins.canFinish(3, data_3));

        int[][] data_6 = {{0,1}, {2,3}, {1,2}, {3, 0}};
        System.out.println(ins.canFinish(4, data_6));

        int[][] data_8 = {{1,0}, {2,0}, {3, 1}, {3, 2}};
        System.out.println(ins.canFinish(4, data_8));

    }
}
