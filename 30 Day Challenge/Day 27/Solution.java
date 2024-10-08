class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        if (root.left == null && root.right == null) {
            return 0;
        }
    
        Map<Integer, HashSet<Integer>> adj = new HashMap<>();
        createGraph(root, adj);
        return BFS(adj, target);
    }
    
    static int BFS(Map<Integer, HashSet<Integer>> adj, int src) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;
    
        queue.offer(src);
        visited.add(src);
    
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
    
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int neighbor : adj.get(node)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
    
        return count - 1;
    }
    
    static void createGraph(Node root, Map<Integer, HashSet<Integer>> adj) {
        if (root == null) {
            return;
        }
    
        if (root.left != null) {
            adj.computeIfAbsent(root.data, k -> new HashSet<>()).add(root.left.data);
            adj.computeIfAbsent(root.left.data, k -> new HashSet<>()).add(root.data);
            createGraph(root.left, adj);
        }
    
        if (root.right != null) {
            adj.computeIfAbsent(root.data, k -> new HashSet<>()).add(root.right.data);
            adj.computeIfAbsent(root.right.data, k -> new HashSet<>()).add(root.data);
            createGraph(root.right, adj);
        }
    }
}