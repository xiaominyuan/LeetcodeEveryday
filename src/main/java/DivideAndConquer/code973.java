//973. 最接近原点的 K 个点
//        我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
//
//        （这里，平面上两点之间的距离是欧几里德距离。）
//
//        你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
//
//         
//
//        示例 1：
//
//        输入：points = [[1,3],[-2,2]], K = 1
//        输出：[[-2,2]]
//        解释：
//        (1, 3) 和原点之间的距离为 sqrt(10)，
//        (-2, 2) 和原点之间的距离为 sqrt(8)，
//        由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//        我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
//        示例 2：
//
//        输入：points = [[3,3],[5,-1],[-2,4]], K = 2
//        输出：[[3,3],[-2,4]]
//        （答案 [[-2,4],[3,3]] 也会被接受。）
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DivideAndConquer;

public class code973 {
    public int[][] kClosest(int[][] points, int K) {

        int len = points.length;

        int[] dist = new int[len];


        int left = 0;
        int right = len-1;

        // int[][] pointsTmp = points;


        quickSort(points, left, right);

        int[][] result = new int[K][2];

        for (int i = 0; i<K; i++){
            result[i][0] = points[i][0];
            result[i][1] = points[i][1];
        }


        return result;
    }


    public void quickSort(int[][] points, int left, int right){

        if (left>right){
            return;
        }

        int[] tmp2 = new int[2];
        for (int i =0; i<2; i++){
            tmp2[i] = points[left][i];
        }

        // int tmp = dist[left];
        int tmp = points[left][0]*points[left][0] + points[left][1]*points[left][1];
        int low = left+1;
        int high = right;

        while (low <= high){

            // int lowDist = points[low][0]*points[low][0] + points[low][1]*points[low][1];
            // int highDist = points[high][0]*points[high][0] + points[high][1]*points[high][1];

            while (low< high && (points[low][0]*points[low][0] + points[low][1]*points[low][1]) <= tmp){
                low++;
            }
            while ((points[high][0]*points[high][0] + points[high][1]*points[high][1])>tmp){
                high--;
            }
            if (low < high){

                int[] tmpSub = new int[2];
                for (int i =0; i<2; i++){
                    tmpSub[i] = points[low][i];
                }

                for (int i =0; i<2; i++){
                    points[low][i] = points[high][i];
                }

                for (int i =0; i<2; i++){
                    points[high][i] = tmpSub[i];
                }

            }else{
                break;
            }


        }
        for (int i =0; i<2; i++){
            points[left][i] = points[high][i];
        }

        for (int i =0; i<2; i++){
            points[high][i] = tmp2[i];
        }


        quickSort(points, left, high-1);
        quickSort(points, high+1, right);
    }




//     public int[][] kClosest(int[][] points, int K) {

//         int len = points.length;

//         int[] dist = new int[len];

//         for (int i = 0; i<len; i++){
//             dist[i] = points[i][0]*points[i][0] + points[i][1]*points[i][1];
//         }
//         // System.out.println(dist[0]);

//         int left = 0;
//         int right = len-1;

//         int[][] pointsTmp = points;


//         quickSort(pointsTmp, dist, left, right);

//         int[][] result = new int[K][2];

//         for (int i = 0; i<K; i++){
//             result[i][0] = pointsTmp[i][0];
//             result[i][1] = pointsTmp[i][1];
//         }

//         // System.out.println(dist[0]);

//         return result;
//     }



//     public void quickSort(int[][] points, int[] dist, int left, int right){
//         // int[] tmp2 = points[left];

//         if (left>right){
//             return;
//         }

//         int[] tmp2 = new int[2];
//         for (int i =0; i<2; i++){
//             tmp2[i] = points[left][i];
//         }

//         int tmp = dist[left];
//         int low = left+1;
//         int high = right;

//         while (low <= high){
//             while (low< high && dist[low]<=tmp){
//                 low++;
//             }
//             while (dist[high]>tmp){
//                 high--;
//             }
//             if (low < high){

//                 int[] tmpSub = new int[2];
//                 for (int i =0; i<2; i++){
//                     tmpSub[i] = points[low][i];
//                 }

//                 for (int i =0; i<2; i++){
//                     points[low][i] = points[high][i];
//                 }

//                 for (int i =0; i<2; i++){
//                     points[high][i] = tmpSub[i];
//                 }


//                 int tmpSub2 = dist[low];
//                 dist[low] = dist[high];
//                 dist[high] = tmpSub2;
//             }else{
//                 break;
//             }


//         }
//         for (int i =0; i<2; i++){
//             points[left][i] = points[high][i];
//         }

//         for (int i =0; i<2; i++){
//             points[high][i] = tmp2[i];
//         }

//         System.out.println(points[high][1]);

//         dist[left] = dist[high];
//         dist[high] = tmp;


//         quickSort(points, dist, left, high-1);
//         quickSort(points, dist, high+1, right);
//     }
}
