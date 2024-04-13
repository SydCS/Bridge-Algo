# 组合博弈 Game Theory

组合游戏 Impartial Combinatorial Games

必胜点 N
必败点 P

属性：

- 所有终结点都是必败点
- 从必胜点操作，至少有一种方法可以到达必败点
- 从必败点无论如何操作，都只能进入必胜点

取子游戏算法实现：

- 将所有终结位置标记为 P
- 将所有一步操作能进入 P 的位置标记为 N
- 如果从某个点开始的所有一步操作都只能进入 N，则将该点标记为 P

https://acm.hdu.edu.cn/showproblem.php?pid=1846

https://acm.hdu.edu.cn/showproblem.php?pid=2147

---

Nim

**Sprague-Grundy**

$mex$
