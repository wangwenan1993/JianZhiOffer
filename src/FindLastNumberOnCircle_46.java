/**
 * Created by Administrator on 2018/8/19.
 */
public class FindLastNumberOnCircle_46 {
    /*
    *���������������ģ�⻷��˼·���ǱȽϼ򵥣����Ǹ����±�Ҫ����
    */
    public static int findLastNumber(int n,int m){
        if(n<1||m<1) return -1;
        int[] array = new int[n];
        int i = -1,step = 0, count = n;
        while(count>0){   //����ѭ��ʱ�����һ��Ԫ��Ҳ����Ϊ��-1
            i++;          //ָ����һ����ɾ���������һ��Ԫ�ء�
            if(i>=n) i=0;  //ģ�⻷��
            if(array[i] == -1) continue; //������ɾ���Ķ���
            step++;                     //��¼���߹��ġ�
            if(step==m) {               //�ҵ���ɾ���Ķ���
                array[i]=-1;
                step = 0;
                count--;
            }
        }
        return i;//��������ѭ��ʱ��i,�����һ��������Ϊ-1��Ԫ��
    }
}
