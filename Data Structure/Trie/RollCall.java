import java.util.Scanner;

// https://www.luogu.com.cn/problem/P2580
public class RollCall {
    enum State {
        INIT, END, VISITED
    }

    static class TrieNode {
        private TrieNode[] children;
        private State s;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.s = State.INIT;
        }

        public void insert(String word) {
            TrieNode node = this;
            for (int i = 0; i < word.length(); i++) {
                int ch = word.charAt(i) - 'a';
                if (node.children[ch] == null) {
                    node.children[ch] = new TrieNode();
                }
                node = node.children[ch];
            }
            node.s = State.END;
        }

        public int search(String word) {
            TrieNode node = this;
            for (int i = 0; i < word.length(); i++) {
                int ch = word.charAt(i) - 'a';
                if (node.children[ch] == null) {
                    return 0;
                }
                node = node.children[ch];
            }

            if (node.s == State.INIT) {
                return 0;
            } else if (node.s == State.END) {
                node.s = State.VISITED;
                return 1;
            } else {
                return 2;
            }
        }
    }

    public static void main(String[] args) {
        TrieNode trie = new TrieNode();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            trie.insert(scanner.next());
        }

        int m = scanner.nextInt();
        while (m-- > 0) {
            switch (trie.search(scanner.next())) {
                case 0:
                    System.out.println("WRONG");
                    break;
                case 1:
                    System.out.println("OK");
                    break;
                case 2:
                    System.out.println("REPEAT");
                    break;
            }
        }
        scanner.close();
    }
}