# 堆

入堆 siftUp() $O(\log N)$

出堆 siftDown() $O(\log N)$

建堆 $O(N)$

---

Top-K:

https://blog.csdn.net/z50L2O08e2u4afToR9A/article/details/82837278

https://leetcode.cn/problems/kth-largest-element-in-an-array/

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
      - 合并时，按秩合并：将深度小的数合并到大的树
      - 查找时，路径压缩

https://acm.hdu.edu.cn/showproblem.php?pid=1232

---

Kruskal

最小生成树 **Minimum Spanning Tree**：边权之和最小的无环连通子图

MST 性质：存在一棵最小生成树包含最小权值的边

选最小，查，并

时间复杂度 $O(e \log e)$

https://acm.hdu.edu.cn/showproblem.php?pid=2988

https://acm.hdu.edu.cn/showproblem.php?pid=1102

# 单调栈

Next Greater Element: 在数组中，找每个数左/右边第一个比它大/小的数 $O(n)$

https://leetcode.cn/problems/daily-temperatures/

https://leetcode.cn/problems/largest-rectangle-in-histogram/

# 单调队列

滑动窗口：求区间最值 $O(n)$

https://leetcode.cn/problems/sliding-window-maximum/

# 前缀树 Trie

https://blog.csdn.net/m0_46202073/article/details/107253959

https://leetcode.cn/problems/implement-trie-prefix-tree/

https://leetcode.cn/problems/replace-words/

https://www.luogu.com.cn/problem/P2580

# 树状数组 Binary Indexed Tree

单点修改 & 区间求和 $O(\log n)$

# 线段树 Segment Tree
