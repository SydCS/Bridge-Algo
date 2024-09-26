参数按值传递：

- 基本类型：传的是值的拷贝，对拷贝变量的修改不影响原变量；
- 引用类型：传的是引用地址的拷贝，但是拷贝的地址和真实地址指向的都是同一个真实数据，因此可以修改原变量中的值。

---

复制数组：

`arr2 = arr1.clone();`

`System.arraycopy(arr1, 0, arr2, 0, arr1.length);`

---

求数组 min/max：

`int min = Arrays.stream(arr).min().getAsInt();`

---

数组排序：

默认升序 `Arrays.sort(arr);`

降序 `Arrays.sort(arr, Collections.reverseOrder());` (Integer[] arr)

---

HashMap:

`put(k, v)`

`get(k)`

`containsKey(k)`

`remove(k)`

---

HashSet:

`add()`

`contains()`

`remove()`

---

Queue 接口 `Queue< > queue = new LinkedList<>();`

`add()` or `offer()`

`peek()`

`poll()`

Deque 接口 `Deque< > deque = new LinkedList<>();`

https://blog.csdn.net/devnn/article/details/82716447

PriorityQueue `PriorityQueue< > queue = new PriorityQueue<>();`

默认小根

---

Stack

`push()`

`pop()`

`peek()`
