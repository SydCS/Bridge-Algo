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

Kruskal 算法

最小生成树 Minimum Spanning Tree：权重和最小的无环连通子图

MST 性质：存在一棵最小生成树包含最小权值的边

选最小，查，并

时间复杂度 $O(e \log e)$

https://acm.hdu.edu.cn/showproblem.phhp?pid=2988

https://acm.hdu.edu.cn/showproblem.php?pid=1102
