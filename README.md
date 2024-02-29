https://space.bilibili.com/1402562141/channel/collectiondetail?sid=2213878

# 基础数学

乘法小心爆 int ---> 改 long

---

LCM = a / GCD \* b

https://acm.hdu.edu.cn/showproblem.php?pid=1019

---

找规律，循环节

https://acm.hdu.edu.cn/showproblem.php?pid=1021

https://acm.hdu.edu.cn/showproblem.php?pid=1005

---

快速幂
带模运算

# 贪心

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

---

sort()
默认升序

浮点数判等：$fabs(a-b) < \epsilon$

# 并查集（最小生成树）

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

# 背包

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

# DFS

# 二分图

# 最短路

# 组合博弈
