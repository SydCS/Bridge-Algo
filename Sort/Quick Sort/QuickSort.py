def partition(arr, low, high):
    # # 实现1 - 腾挪：
    # # 选择第一个元素作为基准
    # pivot = arr[low]
    # # 挖坑的初始位置
    # l = low
    # r = high

    # while l < r:
    #     # 从右边开始找小于基准的元素
    #     while l < r and arr[r] >= pivot:
    #         r -= 1
    #     # 将小于基准的元素填入左边的坑
    #     arr[l] = arr[r]

    #     # 从左边开始找大于基准的元素
    #     while l < r and arr[l] <= pivot:
    #         l += 1
    #     # 将大于基准的元素填入右边的坑
    #     arr[r] = arr[l]

    # # 基准元素放入最后的坑
    # arr[l] = pivot
    # # 返回基准元素的索引
    # return l

    # 实现2 - 滑窗：
    pivot = arr[high]
    l = low - 1
    for r in range(low, high):
        if arr[r] <= pivot:
            l += 1
            arr[l], arr[r] = arr[r], arr[l]
    arr[l + 1], arr[high] = arr[high], arr[l + 1]
    return l + 1


def quicksort(arr, low, high):
    if low < high:
        # 找到分割点
        pivot_index = partition(arr, low, high)
        # 递归对分割点左侧部分进行快速排序
        quicksort(arr, low, pivot_index - 1)
        # 递归对分割点右侧部分进行快速排序
        quicksort(arr, pivot_index + 1, high)


if __name__ == "__main__":
    arr = [5, 2, 9, 1, 7, 6, 3, 8, 4]
    print("原始数组:", arr)
    quicksort(arr, 0, len(arr) - 1)
    print("排序后的数组:", arr)
