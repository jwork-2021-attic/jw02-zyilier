package S191220174;

public class MonsterSorter implements Sorter{
    private int[] a;
    private String plan = "";

    @Override
    public void load(int[] a){
        this.a=a;
    }

    private void swap(int i,int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";        
    }
    @Override
    public void sort1() {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                    sorted = false;
                }
            }
        }
    }
    @Override
    public String getPlan() {
        return this.plan;
    }
    @Override
    public void sort2(){
        quickSort(a, 0, a.length-1);
        // for(int i=a.length-1;i>=0;i--){
        //     int t= i;
        //     for(int j=i;j>=0;j--){
        //         if(a[t] < a[i]){
        //             t=i;
        //         }
        //     }
        //     if(t!=i){
        //         swap(i,t);
        //     }
        // }
    }
    public void quickSort(int[] arr,int low,int high){
        int i,j,temp;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        temp = arr[low];
        while (i<j) {
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            if (i<j) {
                swap(i, j);
            }
 
        }
        swap(i, low);
        quickSort(arr, low, j-1);
        quickSort(arr, j+1, high);
    }
 
}