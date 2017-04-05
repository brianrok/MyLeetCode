package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
	
	public static void main(String[] args) {
		int[][] prerequisites = new int[2][];
		prerequisites[0] = new int[] {2, 0};
		prerequisites[1] = new int[] {2, 1};
		int[] result = new CourseScheduleII().findOrder(3, prerequisites);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] incLinkCounts = new int[numCourses];
		List<List<Integer>> adjs = new ArrayList<>();
		buildGraph(incLinkCounts, adjs, prerequisites);
		int[] order = new int[numCourses];
		Queue<Integer> toVisit = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (incLinkCounts[i] == 0) {
				toVisit.offer(i);
			}
		}
		int visited = 0;
		while(!toVisit.isEmpty()) {
			int from = toVisit.poll();
			order[visited++] = from;
			for (int to: adjs.get(from)) {
				incLinkCounts[to]--;
				if (incLinkCounts[to] == 0) {
					toVisit.offer(to);
				}
			}
		}
		return visited == numCourses? order: new int[0];
    }
	
	private void buildGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites) {
		int n = incLinkCounts.length;
		while(n-- > 0) {
			adjs.add(new ArrayList<>());
		}
		for (int[] edge: prerequisites) {
			incLinkCounts[edge[0]]++;
			adjs.get(edge[1]).add(edge[0]);
		}
	}
}
