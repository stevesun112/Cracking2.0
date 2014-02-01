/* Leetcode: Given n points on a 2D plane, 
 * find the maximum number of points that lie on the same straight line.*/

/* I adopted Siyuan's algorithm, instead of calculating the slope for each two nodes, we
 * transform the slope equation into comparing whether (x1 - x2)*(y2 - y3) == (y1 - y2)*(x2 - x3),
 * in this case, we don't need to worry about the cases when the denominator is zero. */

public class findMaxPoints {
	   public static int maxPoints(Point[] points) {
			int max = 0;
			if(points.length == 0){
				max = 0;
			}
			else if(points.length == 1){
				max = 1;
			}
			else if(points.length == 2){
				max = 2;
			}
			else if(points.length == 3){
				max = 2;
				if((points[0].x - points[1].x)*(points[1].y - points[2].y) == 
						(points[0].y - points[1].y)*(points[1].x - points[2].x)){
					max++;
				}
			}
			else {
				int maxPoints[][] = new int[points.length][points.length];
				for(int i = 0; i < points.length; i++){
					for(int j = 0; j < points.length && j != i; j++){
						maxPoints[i][j] = 2 ;
					}
				}

				for(int i = 0; i < points.length; i++){
					for(int j = 0; (j < points.length) && (j != i); j++){
						if(((points[i].x == points[j].x) && (points[i].y == points[j].y))){
							for(int k = 0; (k < points.length); k++){
								if((k!=i) && (k!=j)){
								if(((points[k].x == points[i].x) && (points[k].y == points[i].y))){
									maxPoints[i][j]++;
								}
								}
							}
						}
						else for(int k = 0; (k < points.length); k++){
							if((k!=i) && (k!=j)){
							if(((points[k].x == points[i].x) && (points[k].y == points[i].y)))
							{
								maxPoints[i][j]++;
							}
							else if(((points[k].x == points[j].x) && (points[k].y == points[j].y))){
								maxPoints[i][j]++;
							}
							else if((points[i].x - points[j].x)*(points[k].y - points[j].y) == 
									(points[i].y - points[j].y)*(points[k].x - points[j].x)){
								maxPoints[i][j]++;
								//						System.out.println(maxPoints[i][j]);
							}
							}
						}
					}
				}
				for(int m = 0; m < points.length; m++){
					for(int n = 0; n < points.length; n++){
						if(maxPoints[m][n] > max)
							//System.out.print("maxPoints[" + m + "][" + n +"]:" + maxPoints[m][n] + "\t");
							max = maxPoints[m][n];
					}
				}
			}
			return max; 
	    }
	   public static void main(String args[]){
		   Point[] points = new Point[4];
		   points[0] = new Point(1, 2);
		   points[1] = new Point(1, 3);
		   points[2] = new Point(2, 5);
		   points[3] = new Point(2, 4);
		   System.out.println(maxPoints(points));
	   }
}
