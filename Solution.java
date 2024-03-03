import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 用于存储所有可能的排列组合
    private List<List<Integer>> result = new ArrayList<>();
    // 用于标记数字是否已经被访问过
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        // 开始深度优先搜索，从空列表开始
        dfs(nums, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, List<Integer> current) {
        // 如果当前排列的长度等于原始数组的长度，说明找到了一个完整的排列
        if (current.size() == nums.length) {
            // 将当前排列添加到结果列表中，注意要新建一个列表，因为Java是引用传递
            result.add(new ArrayList<>(current));
            return;
        }

        // 遍历每个数字
        for (int i = 0; i < nums.length; i++) {
            // 如果该数字未被访问过
            if (!visited[i]) {
                // 标记为已访问
                visited[i] = true;
                // 添加到当前排列中
                current.add(nums[i]);
                // 继续搜索下一个数字
                dfs(nums, current);
                // 回溯，撤销之前的选择
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}
