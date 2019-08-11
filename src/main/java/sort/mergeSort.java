package sort;

public class mergeSort {
    public int[] sort(int[] a, int low, int high){
        int mid = (low + high)/2;
        if (low < high){
            sort(a, low, mid);
            sort(a, mid+1, high);
            merge(a, low, mid, high);
        }

        return a;
    }

    public void merge(int[] a , int low, int mid, int high){
        int[] tmp = new int[high-low+1];
        int i = low;
        int j = mid +1;
        int k = 0;

        while (i <= mid && j<= high){
            if (a[i] < a[j]){
                tmp[k++] = a[i++];
            }else{
                tmp[k++] = a[j++];
            }
        }

        while (i <= mid){
            tmp[k++] = a[i++];
        }

        while (j <= high){
            tmp[k++] = a[j++];
        }

        for (int x = 0; x<tmp.length; x++){
            a[x+low] = tmp[x];
        }

    }
}
