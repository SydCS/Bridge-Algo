# 图

图的存储：

- 邻接矩阵
- 邻接表
- 链式前向星

## 最短路

![Path](Path.png)

https://drrany.github.io/ShortestPathAlgorithm/

---

单源 无负权 Dijkstra

朴素

堆优化

- https://leetcode.cn/problems/network-delay-time/
- https://leetcode.cn/problems/number-of-restricted-paths-from-first-to-last-node/

---

Bellman-Ford

SPFA

---

多源汇 Floyd

- https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
- https://leetcode.cn/problems/evaluate-division/

## 最小生成树 Minimum Spanning Tree

切分定理

Kruskal 加边法

Prim 加点法

## 二分图 Bipartite

- https://leetcode.cn/problems/is-graph-bipartite/

---

最大匹配

_Hungarian Algorithm_ 找增广路增加匹配边

---

最小顶点覆盖

https://acm.hdu.edu.cn/showproblem.php?pid=1150

Konig 定理：二分图中，最小顶点覆盖数 = 最大匹配数

最大独立集数 = 节点数 - 最小顶点覆盖数

---

DAG 图的最小路径覆盖数 = 节点数 - 最大匹配数

https://acm.hdu.edu.cn/showproblem.php?pid=1151

## 拓扑排序

AOV

- https://leetcode.cn/problems/course-schedule/
  - https://leetcode.cn/problems/course-schedule-ii/
- https://leetcode.cn/problems/find-eventual-safe-states/

---

AOE
