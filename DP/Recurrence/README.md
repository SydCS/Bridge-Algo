# 递推

递推公式 - 状态转移方程

---

Fibonacci: 1, 1, 2, 3, 5, 8, 13, ...
$$F(n) = F(n-1) + F(n-2)$$
$$F(n) = \frac{\phi^n - (1-\phi)^n}{\sqrt{5}}$$

---

合法/非法

https://acm.hdu.edu.cn/showproblem.php?pid=1297

---

Catalan: 1, 1, 2, 5, 14, 42, 132, 429, ...
$$C_{n+1} = \sum_{i=0}^{n} C_i \cdot C_{n-i}$$
$$C_n = \binom{2n}{n} - \binom{2n}{n-1}= \frac{1}{n+1} \binom{2n}{n}$$
$$C_n = \frac{4n−2}{n+1} C_{n-1}$$

https://acm.hdu.edu.cn/showproblem.php?pid=1023
