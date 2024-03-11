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

HashMap

`put(, )`

`get()`

---

HashSet

`add()`

`contains()`

---

PriorityQueue

`add()`

`peek()`

`poll()`
