import java.util.ArrayList;

/**
 * @Author wangwenan
 * @data 2018/8/16 19:06
 */
public class _29_GetLeastNumbers {
    public static void main(String[] args) {

    }
    // 1.先排序，取前k个

    // 2.快排思想
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        int size = input.length - 1;
        ArrayList<Integer> res = new ArrayList<>();
        if(input.length == 0) return res;
        if(input.length == k) {
            for (int i = 0; i < size; i++) {
                res.add(input[i]);
            }
            return res;
        }
        int index = partition(input, 0, size-1);
        while(index != k) {
            if(index > k) {
                index = partition(input, 0, index-1);
            } else {
                index = partition(input, index+1, size-1);
            }
        }

        for(int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }
    public static int partition(int[] input, int begin, int end) {
        int low = begin, high = end;
        int p_key = input[low];
        while(low < high) {
            while((high > low) && input[high] >= p_key) high--;
            input[low] = input[high];
            while((low < high) && input[low] <= p_key) low++;
            input[high] = input[low];
        }
        input[low] = p_key;
        return low;
    }

    // 3. 最大堆
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        //检查输入的特殊情况
        if(input==null || input.length<=0 || input.length<k){
            return list;
        }
        //构建最大堆
        for(int len=k/2-1; len>=0; len--){
            adjustMaxHeapSort(input,len,k-1);
        }
        //从第k个元素开始分别与最大堆的最大值做比较，如果比最大值小，则替换并调整堆。
        //最终堆里的就是最小的K个数。
        int tmp;
        for(int i=k; i<input.length; i++){
            if(input[i]<input[0]){
                tmp=input[0];
                input[0]=input[i];
                input[i]=tmp;
                adjustMaxHeapSort(input,0,k-1);
            }
        }
        for(int j=0; j<k; j++){
            list.add(input[j]);
        }
        return list;
    }

    public void adjustMaxHeapSort(int[] input, int pos, int length){
        int temp;
        int child;
        for(temp=input[pos]; 2*pos+1<=length; pos=child){
            child=2*pos+1;
            if(child<length && input[child]<input[child+1]){
                child++;
            }
            if(input[child]>temp){
                input[pos]=input[child];
            }else{
                break;
            }
        }
        input[pos]=temp;
    }
}
