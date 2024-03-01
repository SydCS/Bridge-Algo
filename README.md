https://space.bilibili.com/1402562141/channel/collectiondetail?sid=2213878

# 基础数学

乘法小心爆 int ---> 改 long

---

LCM = a / GCD \* b

辗转相除法

https://acm.hdu.edu.cn/showproblem.php?pid=1019

---

找规律，循环节

https://acm.hdu.edu.cn/showproblem.php?pid=1021

https://acm.hdu.edu.cn/showproblem.php?pid=1005

---

快速幂
带模运算

# 贪心

局部最优 $\longrightarrow$ 全局最优

---

sort()
默认升序

浮点数判等：$fabs(a-b) < \epsilon$

---

https://acm.hdu.edu.cn/showproblem.php?pid=1009

---

田忌赛马

https://acm.hdu.edu.cn/showproblem.php?pid=1052

---

最长事件序列：按结束时刻排序

---

https://acm.hdu.edu.cn/showproblem.php?pid=1050

---

删数：找逆序对

https://www.luogu.com.cn/problem/P1106

---

度序列可简单图化判定：Havel-Hakimi 定理

https://acm.hdu.edu.cn/showproblem.php?pid=2454

---

https://acm.hdu.edu.cn/showproblem.php?pid=1007

# 并查集 Disjoint Set

操作：合并，查找

实现：set[i]

- 用编号最小的元素标记所在集合
  - 查找 $O(1)$
  - 合并 $O(N)$
- 每个集合一棵树
  - 合并 $O(1)$
  - 查找：最坏 $O(N) \rightarrow O(\log N)$
    - 避免最坏情况：
      - 合并时，将深度小的数合并到大的树
      - 查找时，带路径压缩

https://acm.hdu.edu.cn/showproblem.php?pid=1232

---

Kruskal 算法求最小生成树 Minimum Spanning Tree

MST 性质：存在一棵最小生成树包含最小权值的边

选最小，查，并

时间复杂度 $O(e \log e)$

https://acm.hdu.edu.cn/showproblem.php?pid=2988

https://acm.hdu.edu.cn/showproblem.php?pid=1102

# 递推

递推公式 - 状态转移方程

---

Fibonacci:
$$F(n) = F(n-1) + F(n-2)$$
$$F(n) = \frac{\phi^n - (1-\phi)^n}{\sqrt{5}}$$

---

合法/非法

https://acm.hdu.edu.cn/showproblem.php?pid=1297

---

Catalan:
$$C_{n+1} = \sum_{i=0}^{n} C_i \cdot C_{n-i} $$
$$C_n = \frac{1}{n+1} \binom{2n}{n}$$

https://acm.hdu.edu.cn/showproblem.php?pid=1023

# Dynamic Programming

数塔问题：自顶向下分析，自底向上计算

$$
dp[i][j] = \mathop{\max}(dp[i+1][j],dp[i+1][j+1]) + a[i][j]
$$

https://leetcode.cn/problems/triangle/description/

以时间作为维度的数塔：

https://acm.hdu.edu.cn/showproblem.php?pid=1176

---

最长递增子序列 Longest Increasing Subsequence:

$$
dp[i] = \mathop{\max}(dp[j] + 1, dp[i]) \quad {\forall} 0 ≤ j < i 且 a[j] < a[i]
$$

https://leetcode.cn/problems/longest-increasing-subsequence/description/

Dilworth 定理：对于一个偏序集，最少链划分数 = 最长反链长度

https://acm.hdu.edu.cn/showproblem.php?pid=1257

---

$$
dp[n][k] = \mathop{\min}(dp[n-1][k], dp[n-2][k-1] + (a[n]-a[n-1])^2)
$$

https://acm.hdu.edu.cn/showproblem.php?pid=1421

---

DP 问题特性：重叠子问题，最优子结构，无后效性

## 背包 Knapsack

01 背包：

$$
dp[i][w] = \max \begin{cases}
dp[i-1][w], & \text{if not taking item \(i\)} \\
dp[i-1][w-w_i] + v_i, & \text{if taking item \(i\) and} \ w \geq w_i
\end{cases}
$$

滚动数组优化空间复杂度：$O(N W) \rightarrow O(W)$

$$
dp[w] = \max(dp[w], dp[w−w_i]+v_i)
$$

```python
for i in range(1, N + 1):
    for w in range(W, w[i] - 1, -1):
        dp[w] = max(dp[w], dp[w - w[i]] + v[i])
```

https://acm.hdu.edu.cn/showproblem.php?pid=2602

---

完全背包：

```python
for i in range(1, N + 1):
    for w in range(w[i], W + 1):
        dp[w] = max(dp[w], dp[w - w[i]] + v[i])
```

若必须装满？

https://acm.hdu.edu.cn/showproblem.php?pid=1114

---

多重背包：
转化为 01 背包 - 二进制优化

---

二维费用背包：

$$
dp[i][j][k] = \max \begin{cases} dp[i-1][j][k] \\ dp[i-1][j-w_i][k-c_i] + v_i \end{cases}
$$

# BFS

队列

二叉树层次遍历

https://leetcode.cn/problems/binary-tree-level-order-traversal/description/

图 BFS

特点：层次性，适合求最少几步能找到目标的问题

解题重点：定义节点信息（状态）

状态（节点），转移（边），构成隐式图，开搜！

剪枝：做标记，已经访问过的节点不再访问

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

网格地图的四方访问：定义一个二维数组全局变量

https://acm.hdu.edu.cn/showproblem.php?pid=1372

---

优先队列

# DFS

# 二分图

# 最短路

# 组合博弈
