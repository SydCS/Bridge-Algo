import java.util.*;

// https://www.luogu.com.cn/problem/P8687
public class CandyGen {
    static final int POPULATION = 2000;
    static final int TIMES = 2000;
    static int N, M, K;
    static int[][] bag;
    static Random rand = new Random();

    static int random(int l, int r) {
        return rand.nextInt(r - l + 1) + l;
    }

    static class Individual implements Comparable<Individual> {
        ArrayList<Integer> seq; // 品尝每包糖果的顺序
        int fitness; // 品尝过所有糖果的糖果包数的最小值

        public Individual(ArrayList<Integer> p) {
            this.seq = new ArrayList<>(p);
            this.fitness = calcFitness();
        }

        public int calcFitness() {
            int state = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < K; j++)
                    state |= (1 << bag[seq.get(i)][j] - 1);
                if (state == (1 << M) - 1) // 已品尝过所有糖果
                    return i + 1;
            }
            System.out.println("-1");
            System.exit(0);
            return Integer.MAX_VALUE; // This line is unreachable but required for compilation
        }

        public Individual mate() { // 自交
            ArrayList<Integer> s = new ArrayList<>(this.seq);
            int n = random(0, 3);
            for (int i = 1; i <= n; i++) {
                int pos1 = random(0, n - 1), pos2 = random(0, n - 1);
                Collections.swap(s, pos1, pos2); // 随机选两个位置交换
            }
            return new Individual(s);
        }

        @Override
        public int compareTo(Individual i) {
            return Integer.compare(this.fitness, i.fitness);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        bag = new int[N][K];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < K; j++)
                bag[i][j] = sc.nextInt();

        ArrayList<Individual> population = new ArrayList<>();
        ArrayList<Integer> seq = new ArrayList<>();
        for (int i = 0; i < N; i++)
            seq.add(i);
        for (int i = 1; i <= POPULATION; i++) {
            Collections.shuffle(seq);
            population.add(new Individual(seq)); // 随机初始化种群
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < TIMES; i++) {
            Collections.sort(population);
            ans = Math.min(ans, population.get(0).fitness);

            ArrayList<Individual> newPopulation = new ArrayList<>();

            int s = (10 * POPULATION) / 100;
            for (int j = 0; j < s; j++)
                newPopulation.add(population.get(j)); // 保留前10%

            s = POPULATION - s;
            for (int j = 0; j < s; j++)
                newPopulation.add(population.get(random(0, 50)).mate());// 随机选择前50%的自交

            population = newPopulation;
        }
        System.out.println(ans);
        sc.close();
    }
}
