# DFS

二叉树的遍历：

- 先序
- 中序
- 后序

唯一确定二叉树：

- 先 + 中
- 后 + 中

---

递归实现：

- 分析问题的递归特征
- 先写出口
- 开递

---

数字的全排列：

**回溯**

https://leetcode.cn/problems/permutations/description/

---

迷宫搜索：

- 每个 block 只能走一次
- 要求恰好在给点的时刻到达出口

剪枝条件：

- 可达的 block 总数 < 时间
- Manhattan 距离 > 时间
- 奇偶剪枝： 时间 - Manhattan 距离 奇
  - $0 \rightarrow 0, 1 \rightarrow 1$ 奇
  - $0 \rightarrow 1, 1 \rightarrow 0$ 偶

https://acm.hdu.edu.cn/showproblem.php?pid=1010

---

记忆化 DFS
