# BFS

队列

二叉树层次遍历

https://leetcode.cn/problems/binary-tree-level-order-traversal/description/

图 BFS

特点：层次性，适合求最少几步能找到目标的问题

解题重点：定义节点信息（状态）

状态（节点），转移（边），构成隐式图，开搜！

**剪枝**：做标记，已经访问过的节点不再访问

```java
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
```

https://acm.hdu.edu.cn/showproblem.php?pid=1548

https://acm.hdu.edu.cn/showproblem.php?pid=1495

网格地图的四方访问：开一个全局变量二维方向数组

https://acm.hdu.edu.cn/showproblem.php?pid=1372

---

优先队列

堆

siftDown()

Top-K:

https://blog.csdn.net/z50L2O08e2u4afToR9A/article/details/82837278

https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
