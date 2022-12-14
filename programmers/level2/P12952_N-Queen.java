class Solution {
    public class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    
    public class Board {
        private int[] board;

        public Board(int boardSize) {
            board = new int[boardSize];
        }

        public boolean isQueenPlaceable(Point point) {
            for(int x = 0; x < point.getX(); x++) {
                if(isQueenPlaced(x, point)) return false;
            }
            return true;
        }

        public void placeQueen(Point point) {
            board[point.getX()] = point.getY();
        }

        public int size() {
            return board.length;
        }

        private boolean isQueenPlaced(int x, Point point) {
            return hasSameColumn(x, point) || hasDiagonal(x, point);
        }

        private boolean hasDiagonal(int x, Point point) {
            return Math.abs(x - point.getX()) == Math.abs(board[x] - point.getY());
        }

        private boolean hasSameColumn(int x, Point point) {
            return board[x] == point.getY();
        }
    }
    
    public class NQueens {
        private Board board;
        private int answer;

        public NQueens(int boardSize) {
            board = new Board(boardSize);
            answer = 0;
        }

        public void placeQueen(int x) {
            for(int y = 0; y < board.size(); y++) {
                Point point = new Point(x, y);

                if(board.isQueenPlaceable(point)) {
                    board.placeQueen(point);

                    if(x == board.size() - 1) {
                        answer++;
                    }

                    placeQueen(x + 1);
                }
            }
        }

        public int getAnswer() {
            return answer;
        }
    }
    
    public int solution(int n) {
        NQueens nQueens = new NQueens(n);
        nQueens.placeQueen(0);
        return nQueens.getAnswer();
    }
}