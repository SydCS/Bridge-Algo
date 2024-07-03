class Edge:
    def __init__(self, u=0, v=0, w=0):
        self.u = u
        self.v = v
        self.w = w


INF = float("inf")


def bellman_ford(n, edges, s):
    dis = [INF] * n
    dis[s] = 0

    for i in range(1, n):
        flag = False
        for e in edges:
            u, v, w = e.u, e.v, e.w
            if dis[u] != INF and dis[v] > dis[u] + w:
                dis[v] = dis[u] + w
                flag = True
        if not flag:
            break

    # 检查负权回路
    for e in edges:
        u, v, w = e.u, e.v, e.w
        if dis[u] != INF and dis[v] > dis[u] + w:
            return False, []  # 存在负权回路

    return True, dis


if __name__ == "__main__":
    MAXN = 5
    edge = [
        Edge(0, 1, -1),
        Edge(0, 2, 4),
        Edge(1, 2, 3),
        Edge(1, 3, 2),
        Edge(1, 4, 2),
        Edge(3, 2, 5),
        Edge(3, 1, 1),
        Edge(4, 3, -3),
    ]

    # 调用Bellman-Ford算法
    is_possible, shortest_distances = bellman_ford(MAXN, edge, 0)

    if is_possible:
        print("最短路径数组：", shortest_distances)
    else:
        print("图中存在负权回路")
