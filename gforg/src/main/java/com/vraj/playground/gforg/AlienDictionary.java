package com.vraj.playground.gforg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Given a sorted dictionary of an alien language having N words and k starting
 * alphabets of standard dictionary the task is to complete the function which
 * returns a string denoting the order of characters in the language..
 * 
 * Note: Many orders may be possible for a particular test case, thus you may
 * return any valid order. <br>
 * 
 * <b>Example:</b>
 * 
 * <pre>
 * 	Input:  Dict[] = { "baa", "abcd", "abca", "cab", "cad" }, k = 4
 *	Output: Function returns "bdac" 
 *	Here order of characters is 'b', 'd', 'a', 'c' 
 *	Note that words are sorted and in the given language "baa" 
 *	comes before "abcd", therefore 'b' is before 'a' in output.
 *	Similarly we can find other orders.
 *
 *	Input:  Dict[] = { "caa", "aaa", "aab" }, k = 3
 *	Output: Function returns "cab"
 * </pre>
 * 
 * @author vrajori
 *
 */
public class AlienDictionary {

	// list of list verteces
	Map<Vertex, Set<Vertex>> directedGraph = new HashMap<>();
	Map<Character, Vertex> mapNode = new HashMap<>();

	private static class Vertex {
		char nodeName;
		int rank;

		Vertex(char nodeName) {
			this.nodeName = nodeName;
			this.rank = 0;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + nodeName;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vertex other = (Vertex) obj;
			if (nodeName != other.nodeName)
				return false;
			return true;
		}

		public char getNodeName() {
			return nodeName;
		}

		public void setNodeName(char nodeName) {
			this.nodeName = nodeName;
		}

		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}

		@Override
		public String toString() {
			return "Vertex [nodeName=" + nodeName + ", rank=" + rank + "]";
		}

	}

	public static void main(String[] args) {
		AlienDictionary adic = new AlienDictionary();

		String[] dic = { "baa", "abcd", "abca", "cab", "cad" };
		int N = 5;
		int k = 4;
		adic.printOrder(dic, N, k);

	}

	private char[] printOrder(String[] dic, int n, int k) {
		for (int i = 0; i < dic.length - 1; i++) {
			compare(dic[i], dic[i + 1]);
			// System.out.println(mapNode);
		}
		directedGraph = reconsileEdges(directedGraph);
		System.out.println(directedGraph);
		return null;
	}

	private Map<Vertex, Set<Vertex>> reconsileEdges(Map<Vertex, Set<Vertex>> graph) {
		Map<Vertex, Set<Vertex>> reconsiledGraph = new HashMap<>();
		for (Entry<Vertex, Set<Vertex>> graphEntry : graph.entrySet()) {
			reconsiledGraph.put(graphEntry.getKey(), graphEntry.getValue());
			for (Vertex vertex : graphEntry.getValue()) {
				Set<Vertex> potentialNewEdges = directedGraph.get(vertex);
				int currentEdgeCount = reconsiledGraph.get(graphEntry.getKey()).size();
				reconsiledGraph.get(graphEntry.getKey()).addAll(potentialNewEdges);
				int reconsiledEdgeCount = reconsiledGraph.get(graphEntry.getKey()).size();
				// entry.getKey().setRank(entry.getKey().getRank() +
				// (reconsiledEdgeCount - currentEdgeCount));
				// for (Vertex v : potentialNewEdges) {
				// v.setRank(v.getRank() - 1);
				// }
			}
		}
		return reconsiledGraph;
	}

	private void compare(String a, String b) {
		for (int i = 0; i < a.length(); i++) {
			// string lengths may not be same.
			if (i + 1 > b.length()) {
				break;
			}

			if (a.charAt(i) == b.charAt(i)) {
				continue;
			}

			// create edge a.charAt(i) to b.charAt(i) and break.
			createEdge(a.charAt(i), b.charAt(i));
			break;
		}
	}

	private void createEdge(char a, char b) {
		Vertex vertexA = mapNode.get(a);
		if (vertexA == null) {
			vertexA = new Vertex(a);
			mapNode.put(a, vertexA);
		}

		Vertex vertexB = mapNode.get(b);
		if (vertexB == null) {
			vertexB = new Vertex(b);
			mapNode.put(b, vertexB);
		}

		Set<Vertex> edgesFromA = directedGraph.get(vertexA);
		if (edgesFromA == null) {
			edgesFromA = new HashSet<>();
			directedGraph.put(vertexA, edgesFromA);
		}

		edgesFromA.add(vertexB);
		// increment rank for outgoing
		vertexA.setRank(vertexA.getRank() + 1);
		// decrement rank for incoming
		vertexB.setRank(vertexB.getRank() - 1);

	}

}
