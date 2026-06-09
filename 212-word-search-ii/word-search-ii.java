class Solution {
    char[][] board;
    boolean[][] vis;
    List<String> res = new ArrayList<>();

    class trienode {
        trienode[] child = new trienode[26];
        String word;

        void insert(String s) {
            trienode curr = this;

            for (char c : s.toCharArray()) {
                int ind = c - 'a';

                if (curr.child[ind] == null) {
                    curr.child[ind] = new trienode();
                }

                curr = curr.child[ind];
            }

            curr.word = s;
        }
    }

    trienode root = new trienode();

    void search(int i, int j, trienode curr) {

        if (i < 0 || j < 0 || i >= vis.length || j >= vis[0].length || vis[i][j]) {
            return;
        }

        int ind = board[i][j] - 'a';

        if (curr.child[ind] == null) {
            return;
        }

        curr = curr.child[ind];

        if (curr.word != null) {
            res.add(curr.word);
            curr.word = null;
        }

        vis[i][j] = true;

        search(i + 1, j, curr);
        search(i - 1, j, curr);
        search(i, j + 1, curr);
        search(i, j - 1, curr);

        vis[i][j] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {

        this.board = board;

        for (String s : words) {
            root.insert(s);
        }

        int m = board.length;
        int n = board[0].length;

        vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int ind = board[i][j] - 'a';

                if (root.child[ind] != null) {
                    search(i, j, root);
                }
            }
        }

        return res;
    }
}