import java.util.*;

// https://www.luogu.com.cn/problem/P8687
public class Candy {
    static final int POPULATION = 1000;
    static final int TIMES = 20;
    static final int N = 110, M = 21;
    static int[][] a = new int[N][M];
    static int n, m, K;
    static int ans = Integer.MAX_VALUE;
    static Random rand = new Random();

    static int random(int l, int r) {
        return rand.nextInt(r - l + 1) + l;
    }

    static class Individual implements Comparable<Individual> {
        ArrayList<Integer> p;
        int fitness;

        public Individual(ArrayList<Integer> p) {
            this.p = new ArrayList<>(p);
            this.fitness = calc_fitness();
        }

        public Individual mate() { // 自交
            ArrayList<Integer> _p = new ArrayList<>(this.p);
            int n = random(0, 3);
            for (int i = 1; i <= n; i++) {
                int pos1 = random(0, n - 1), pos2 = random(0, n - 1);
                Collections.swap(_p, pos1, pos2);
            }
            return new Individual(_p);
        }

        public int calc_fitness() {
            int state = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < K; j++)
                    state |= (1 << a[p.get(i)][j] - 1);
                if (state == (1 << m) - 1)
                    return i + 1;
            }
            System.out.println("-1");
            System.exit(0);
            return Integer.MAX_VALUE; // This line is unreachable but required for compilation
        }

        @Override
        public int compareTo(Individual o) {
            return Integer.compare(this.fitness, o.fitness);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        K = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < K; j++)
                a[i][j] = sc.nextInt();

        ArrayList<Individual> population = new ArrayList<>();
        ArrayList<Integer> seq = new ArrayList<>();
        for (int i = 0; i < n; i++)
            seq.add(i);

        for (int i = 1; i <= POPULATION; i++) {
            Collections.shuffle(seq);
            population.add(new Individual(seq));
        }

        for (int i = 0; i < TIMES; i++) {
            Collections.sort(population);
            ans = Math.min(ans, population.get(0).fitness);

            ArrayList<Individual> new_population = new ArrayList<>();
            int s = (10 * POPULATION) / 100;
            for (int j = 0; j < s; j++)
                new_population.add(population.get(j));

            s = POPULATION - s;
            for (int j = 0; j < s; j++) {
                Individual p = population.get(random(0, 50));
                new_population.add(p.mate());
            }
            population = new_population;
        }

        System.out.println(ans);
        sc.close();
    }
}
