class Solution {
    public double minAreaFreeRect(int[][] points) {
        double ans = Integer.MAX_VALUE;
        HashSet<Point> set = new HashSet<>();
        for (int[] point : points) {
            set.add(new Point(point[0],point[1]));
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                int delta_x1 = points[j][0] - points[i][0];
                int delta_y1 = points[j][1] - points[i][1];
                for (int k = j+1; k < points.length; k++) {
                    int delta_x2 = points[k][0] - points[i][0];
                    int delta_y2 = points[k][1] - points[i][1];
                    int delta_x3 = points[k][0] - points[j][0];
                    int delta_y3 = points[k][1] - points[j][1];
                    if (delta_x1 * delta_x2 + delta_y1 * delta_y2 == 0) {
                        if (set.contains(new Point(points[j][0] + points[k][0] - points[i][0],
                                points[j][1] + points[k][1] - points[i][1])))
                            ans = Math.min(ans,
                                Math.sqrt(Math.pow(delta_x1,2)+Math.pow(delta_y1,2)) *
                                        Math.sqrt(Math.pow(delta_x2,2)+Math.pow(delta_y2,2)));
                    } else if (delta_x1 * delta_x3 + delta_y1 * delta_y3 == 0) {
                        if (set.contains(new Point(points[i][0] + points[k][0] - points[j][0],
                                points[i][1] + points[k][1] - points[j][1])))
                            ans = Math.min(ans,
                                    Math.sqrt(Math.pow(delta_x1,2)+Math.pow(delta_y1,2)) *
                                            Math.sqrt(Math.pow(delta_x3,2)+Math.pow(delta_y3,2)));
                    } else if (delta_x2 * delta_x3 + delta_y2 * delta_y3 == 0) {
                        if (set.contains(new Point(points[i][0] + points[j][0] - points[k][0],
                                points[i][1] + points[j][1] - points[k][1])))
                            ans = Math.min(ans,
                                    Math.sqrt(Math.pow(delta_x2,2)+Math.pow(delta_y2,2)) *
                                            Math.sqrt(Math.pow(delta_x3,2)+Math.pow(delta_y3,2)));
                    }

                }
            }
        }
        if (ans == Integer.MAX_VALUE) return 0;
        return ans;
    }
    class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            return this.x == ((Point)(o)).x && this.y == ((Point)(o)).y;
        }

        @Override
        public int hashCode() {
            return 40001*x+y;
        }
    }
}
