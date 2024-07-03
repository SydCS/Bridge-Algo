import heapq


def dijkstra(graph, start):
    # 初始化距离字典，用来存储从起点到每个顶点的最短距离
    distances = {vertex: float("infinity") for vertex in graph}
    distances[start] = 0  # 起点到自身的距离为0

    priority_queue = [(0, start)]  # 使用优先队列（最小堆）来辅助选择当前最短距离的顶点

    while priority_queue:
        current_distance, current_vertex = heapq.heappop(priority_queue)

        # 如果当前距离大于已知最短距离，则忽略
        if current_distance > distances[current_vertex]:
            continue

        # 遍历当前顶点的邻居
        for neighbor, weight in graph[current_vertex].items():
            distance = current_distance + weight

            # 如果通过当前顶点到邻居的路径更短，则更新最短距离
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(priority_queue, (distance, neighbor))

    return distances


# 示例图的邻接表表示
graph = {
    "A": {"B": 1, "C": 4},
    "B": {"A": 1, "C": 2, "D": 5},
    "C": {"A": 4, "B": 2, "D": 1},
    "D": {"B": 5, "C": 1},
}

start_vertex = "A"
print(f"从顶点 {start_vertex} 到其他顶点的最短距离:")
print(dijkstra(graph, start_vertex))
