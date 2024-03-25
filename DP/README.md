# Dynamic Programming

数塔问题：自顶向下分析，自底向上计算

$$
dp[i][j] = \mathop{\max} (dp[i+1][j], dp[i+1][j+1]) + a[i][j]
$$

https://leetcode.cn/problems/triangle/

以时间作为维度的数塔：

https://acm.hdu.edu.cn/showproblem.php?pid=1176

---

最长递增子序列 Longest Increasing Subsequence:

$$
dp[i] = \mathop{\max}(dp[j] + 1, dp[i]) \quad {\forall} 0 ≤ j < i 且 a[j] < a[i]
$$

https://leetcode.cn/problems/longest-increasing-subsequence/

Dilworth 定理：对于一个偏序集，最少链划分数 = 最长反链长度

https://acm.hdu.edu.cn/showproblem.php?pid=1257

---

最长公共子序列 Longest Common Subsequence:

https://leetcode.cn/problems/longest-common-subsequence/description/

---

DP 问题特性：重叠子问题，最优子结构，无后效性

## 背包 Knapsack

https://github.com/tianyicui/pack

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
    for w in range(W, w_i - 1, -1):
        dp[w] = max(dp[w], dp[w - w_i] + v[i])
```

https://acm.hdu.edu.cn/showproblem.php?pid=2602

---

完全背包：

```python
for i in range(1, N + 1):
    for w in range(w_i, W + 1):
        dp[w] = max(dp[w], dp[w - w_i] + v[i])
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

## 区间 DP

石子合并：

$$
dp(i,j) = \min \{ dp(i,k) + dp(k+1,j) + cost \} \quad {\forall} i ≤ k < j
$$

https://www.luogu.com.cn/problem/P1880

## 树形 DP

## 状态压缩 DP
