import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

/**
 * Solution
 */
public class Solution {

    public Node bfs(Node source, Node target) {
        HashMap<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(source);
        visited.put(source, true);
        while (!q.isEmpty()) {
            Node a = q.poll();
            if (a.equals(target)) {
                return a;
            }
            for (Node b : a.successors()) {
                if (!visited.getOrDefault(b, false)) {
                    q.add(b);
                    visited.put(b, true);
                }
            }
        }
        return null;
    }

}