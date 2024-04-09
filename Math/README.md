# 基础数学

乘法小心爆 int (-2147483648 ~ 2147483647) ---> 改 long

“三年 OI 一场空，不开 long long 见祖宗”

## Greatest Common Divisor

LCM = a / GCD \* b

辗转相除法 $O(\log n)$

https://acm.hdu.edu.cn/showproblem.php?pid=1019

##

找规律，循环节

https://acm.hdu.edu.cn/showproblem.php?pid=1021

https://acm.hdu.edu.cn/showproblem.php?pid=1005

## 快速幂

带模运算

https://www.luogu.com.cn/problem/P1226

## 筛法

Sieve of Eratosthenes $O(n \log \log n)$

Euler $O(n)$

https://leetcode.cn/problems/count-primes/

## 欧拉函数 Euler's totient function

若在算数基本定理中，$N = p_1^{a_1} p_2^{a_2} \dots p_m^{a_m}$，

则 1 ~ N 中与 N 互质的数的个数 $\varphi(N) = N \times \left(1 - \frac{1}{p_1}\right) \times \left(1 - \frac{1}{p_2}\right) \times \dots \times \left(1 - \frac{1}{p_m}\right)$
