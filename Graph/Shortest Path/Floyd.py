INF = float("inf")


def floyd_warshall(graph):
    """
    Floyd-Warshall算法计算所有点对之间的最短路径。

    参数:
    graph: 二维列表，表示带权重的图，graph[i][j]表示从顶点i到顶点j的距离。若i=j，则graph[i][j]=0，若不直接相连，则为INF。

    返回值:
    shortest_paths: 二维列表，shortest_paths[i][j]表示从顶点i到顶点j的最短路径长度。
    """
    n = len(graph)
    shortest_paths = [row[:] for row in graph]  # Make a copy of the input graph

    # 核心算法，逐步更新最短路径信息
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if shortest_paths[i][j] > shortest_paths[i][k] + shortest_paths[k][j]:
                    shortest_paths[i][j] = shortest_paths[i][k] + shortest_paths[k][j]

    return shortest_paths


if __name__ == "__main__":
    # 图的邻接矩阵表示
    graph = [[0, 5, INF, 10], [INF, 0, 3, INF], [INF, INF, 0, 1], [INF, INF, INF, 0]]

    shortest_paths = floyd_warshall(graph)

    print("最短路径矩阵:")
    for row in shortest_paths:
        print(row)
