package test;

class Solution {

    public static void main(String[] args) {

        int[] a = new int[] { 1, 2, 3, 4 };
        int[] b = new int[] { 3, 4, 5 };
        System.out.println(findMedianSortedArrays(a, b));
        System.out.println(find_kth(a, 4, b, 3, 7));
    }

    /**
     * @param A
     *            : An integer array.
     * @param B
     *            : An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    static double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length)
            return findMedianSortedArrays(B, A);
        int m = A.length, n = B.length;
        int imin = 0, imax = m, half_len = (m + n + 1) / 2, i = 0, j = 0, max_of_left = 0, min_of_right = 0;
        while (imin <= imax) {
            i = (imin + imax) / 2;
            j = half_len - i;
            if (i < m && j > 0 && B[j - 1] > A[i])
                imin = i + 1;
            else if (i > 0 && j < n && B[j] < A[i - 1])
                imax = i - 1;
            else {
                if (i == 0)
                    max_of_left = B[j - 1];
                else if (j == 0)
                    max_of_left = A[i - 1];
                else
                    max_of_left = Math.max(A[i - 1], B[j - 1]);
                break;
            }
        }
        if ((m + n) % 2 == 1)
            return max_of_left;
        if (i == m)
            min_of_right = B[j];
        else if (j == n)
            min_of_right = A[i];
        else
            min_of_right = Math.min(A[i], B[j]);
        return (max_of_left + min_of_right) / 2.0;
    }
    
    
    
    //找到A,B组合中第k小的值: AB[k-1]
   static int find_kth(int []A, int m,int[] B, int n, int k) {
        //假设m都小于n
        if (m > n)
            return find_kth(B, n, A, m, k);
        if (m == 0)
            return B[k-1];
        if (k == 1) //终止条件
            return Math.min(A[0], B[0]);
       
        if(k > (m + n)){
          return -1;
        }

        int i_a = Math.min(m, k/2);
        int i_b = k - i_a;

        if (A[i_a-1] < B[i_b-1]){
            int [] aa = new int[m- i_a];
            int j = 0;
            for(int i = i_a; i < m; i++){
                aa[j++] = A[i];
            }
            return find_kth(aa, m-i_a, B, n, k-i_a);
        }
        else if (A[i_a-1] > B[i_b-1]){
            int [] bb = new int[n-i_b];
            int j = 0;
            for(int i = i_b; i < n; i++){
                bb[j++] = B[i];
            }
            return find_kth(A, m, bb, n-i_b, k-i_b);
        }
        else
            return A[i_a-1];
    }
};