def shellsort(arr, n):
    gap = n // 2
    while gap > 0:
        for i in range(gap, n):
            temp = arr[i]
            j = i
            while j >= gap and arr[j - gap] > temp:
                arr[j] = arr[j - gap]
                j -= gap
            arr[j] = temp
        gap //= 2
    return arr


if __name__ == "__main__":
    arr = [5, 2, 9, 1, 7, 6, 3, 8, 4]
    print("原始数组:", arr)
    shellsort(arr, len(arr))
    print("排序后的数组:", arr)
