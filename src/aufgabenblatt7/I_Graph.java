package aufgabenblatt7;

import java.util.List;

/**
 * This interface describes a graph
 * 
 * @author cao
 *
 */
public interface I_Graph {
	/**
	 * This method adds a new node in the graph.
	 *@param name: name of node
	 */
	public void addNode(String name);

	/**
	 * This method removes the node with index n
	 *@param n: index of node
	 */
	public void removeNode(int n);

	/**
	 * This method adds a new edge from node i to node j
	 * 
	 *@param i: start node
	 *@param j: destination node
	 *@param value: distance from start node to destination node(weight of edge)
	 */

	public void addEdge(int i, int j, int value);

	/**
	 * This method removes the edge from node i to node j
	 * 
	 *@param i: start node
	 *@param j: destination node
	 */

	public void removeEdge(int i, int j);

	/**
	 * This method checks out if a edge from node i to node j is available or
	 * not. If yes, return the value of the edge
	 * 
	 *@param i: start node
	 *@param j: destination node
	 *@return value of the edge
	 */

	public int hasEdge(int i, int j);

	/**
	 * This method returns a list of all nodes out from node n
	 * 
	 *@param n: index of node
	 *@return a list of nodes
	 */
	public List<Integer> outEdges(int n);

	/**
	 * This method return a list of all nodes going in node n
	 * 
	 *@param n: index of node
	 *@return a list of nodes
	 */
	public List<Integer> inEdges(int n);

	/**
	 * This method counts the shortest way after the dijktra algorithms.
	 */
	public void dijktraValue();

	/**
	 * This method return a list of Content of each nodes according to its index
	 * 
	 *@return an String array of index and content
	 */
	public String[] tableOfContent();
}
