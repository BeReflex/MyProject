package com.common;

import java.util.ArrayList;
import java.util.List;

public class sort {

	/**
	 * 
	 * 
	 */
	
	//---------------------------------------------------------------------------------------------------
	 /**
     * 1、冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。  
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。  
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。 
     * @param numbers 需要排序的整型数组
     */
    public static void bubbleSort(int[] numbers)
    {
        int temp = 0;
        int size = numbers.length;
        for(int i = 0 ; i < size-1; i ++)
        {
	        for(int j = 0 ;j < size-1-i ; j++)
	        {
	            if(numbers[j] > numbers[j+1])  //交换两数位置
	            {
		            temp = numbers[j];
		            numbers[j] = numbers[j+1];
		            numbers[j+1] = temp;
	            }
	        }
        }
    }
    /**
     * 2、快速排序
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     * 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，则分别对这两部分继续进行排序，直到整个序列有序
     * 快速排序是通常被认为在同数量级（O(nlog2n)）的排序方法中平均性能最好的。但若初始序列按关键码有序或基本有序时，快排序反而蜕化为冒泡排序。
     * 为改进之，通常以“三者取中法”来选取基准记录，即将排序区间的两个端点与中点三个记录关键码居中的调整为支点记录。快速排序是一个不稳定的排序方法。
     * @param numbers 带查找数组
     * @param low   开始位置
     * @param high  结束位置
     * @return  中轴所在位置
     */
    public static int getMiddle(int[] numbers, int low,int high)
    {
        int temp = numbers[low]; //数组的第一个作为中轴
        while(low < high)
        {
        while(low < high && numbers[high] > temp)
        {
            high--;
        }
        numbers[low] = numbers[high];//比中轴小的记录移到低端
        while(low < high && numbers[low] < temp)
        {
            low++;
        }
        numbers[high] = numbers[low] ; //比中轴大的记录移到高端
        }
        numbers[low] = temp ; //中轴记录到尾
        return low ; // 返回中轴的位置
    } 
    /**
     * 快速排序
     * @param numbers 带排序数组
     */
    public static void quick(int[] numbers)
    {
        if(numbers.length > 0)   //查看数组是否为空
        {
        quickSort(numbers, 0, numbers.length-1);
        }
    }
    /**
     * 快速排序
     * @param numbers 带排序数组
     * @param low  开始位置
     * @param high 结束位置
     */
    public static void quickSort(int[] numbers,int low,int high)
    {
        if(low < high)
        {
        	int middle = getMiddle(numbers,low,high); //将numbers数组进行一分为二
        	quickSort(numbers, low, middle-1);   //对低字段表进行递归排序
        	quickSort(numbers, middle+1, high); //对高字段表进行递归排序
        }
    
    }
    
    /**
     * 3、选择排序算法
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置  
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。 
     * 以此类推，直到所有元素均排序完毕。 
     * @param numbers
     */
    public static void selectSort(int[] numbers)
    {
	    int size = numbers.length; //数组长度
	    int temp = 0 ; //中间变量
	    
	    for(int i = 0 ; i < size ; i++)
	    {
	        int k = i;   //待确定的位置
	        //选择出应该在第i个位置的数
	        for(int j = size -1 ; j > i ; j--)
	        {
		        if(numbers[j] < numbers[k])
		        {
		            k = j;
		        }
	        }
	        //交换两个数
	        temp = numbers[i];
	        numbers[i] = numbers[k];
	        numbers[k] = temp;
	    }
    }
    
    /**  
     * 4、插入排序(直接排序)
     * 
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描 
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置  
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置  
     * 将新元素插入到该位置中  
     * 重复步骤2  
     * @param numbers  待排序数组
     */  
    public static void insertSort(int[] numbers)
    {
	    int size = numbers.length;
	    int temp = 0 ;
	    int j =  0;
	    
	    for(int i = 0 ; i < size ; i++)
	    {
	        temp = numbers[i];
	        //假如temp比前面的值小，则将前面的值后移
	        for(j = i ; j > 0 && temp < numbers[j-1] ; j --)
	        {
	        	numbers[j] = numbers[j-1];
	        }
	        numbers[j] = temp;
	    }
    }
    /**
     * 5、希尔排序
     * 希尔排序的原理:根据需求，如果你想要结果从大到小排列，它会首先将数组进行分组，然后将较大值移到前面，较小值到后面，
     * 移最后将整个数组进行插入排序，这样比起一开始就用插入排序减少了数据交换和移动的次数，可以说希尔排序是加强版的插入排序
     * 拿数组5, 2, 8, 9, 1, 3，4来说，数组长度为7，当increment为3时，数组分为两个序列
     * 5，2，8和9，1，3，4，第一次排序，9和5比较，1和2比较，3和8比较，4和比其下标值小increment的数组值相比较
     * 此例子是按照从大到小排列，所以大的会排在前面，第一次排序后数组为9, 2, 8, 5, 1, 3，4
     * 第一次后increment的值变为3/2=1,此时对数组进行插入排序，
     * 实现数组从大到小排
     */

        public static void shellSort(int[] data) 
        {
            int j = 0;
            int temp = 0;
            //每次将步长缩短为原来的一半
            for (int increment = data.length / 2; increment > 0; increment /= 2)
            {
	            for (int i = increment; i < data.length; i++) 
	            {
	                temp = data[i];
	                for (j = i; j >= increment; j -= increment) 
	                {
		                if(temp < data[j - increment])//如想从小到大排只需修改这里
		                {   
		                    data[j] = data[j - increment];
		                }
		                else
		                {
		                    break;
		                }
		                
	                } 
	                data[j] = temp;
	            }
        
            }
        }
        /**
         * 6、归并排序
         * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
         * 时间复杂度为O(nlogn)
         * 稳定排序方式
         * @param nums 待排序数组
         * @return 输出有序数组
         */
        public static int[] mergeSort(int[] nums, int low, int high) {
            int mid = (low + high) / 2;
            if (low < high) {
                // 左边
            	mergeSort(nums, low, mid);
                // 右边
            	mergeSort(nums, mid + 1, high);
                // 左右归并
                merge(nums, low, mid, high);
            }
            return nums;
        }

        /**
         * 将数组中low到high位置的数进行排序
         * @param nums 待排序数组
         * @param low 待排的开始位置
         * @param mid 待排中间位置
         * @param high 待排结束位置
         */
        public static void merge(int[] nums, int low, int mid, int high) {
            int[] temp = new int[high - low + 1];
            int i = low;// 左指针
            int j = mid + 1;// 右指针
            int k = 0;

            // 把较小的数先移到新数组中
            while (i <= mid && j <= high) {
                if (nums[i] < nums[j]) {
                    temp[k++] = nums[i++];
                } else {
                    temp[k++] = nums[j++];
                }
            }

            // 把左边剩余的数移入数组
            while (i <= mid) {
                temp[k++] = nums[i++];
            }

            // 把右边边剩余的数移入数组
            while (j <= high) {
                temp[k++] = nums[j++];
            }

            // 把新数组中的数覆盖nums数组
            for (int k2 = 0; k2 < temp.length; k2++) {
                nums[k2 + low] = temp[k2];
            }
        }
        
        /**
         * 7、堆排序
         * 堆排序是一种树形选择排序，是对直接选择排序的有效改进。
 		 * 堆的定义下：具有n个元素的序列 （h1,h2,...,hn),当且仅当满足（hi>=h2i,hi>=2i+1）或（hi<=h2i,hi<=2i+1） (i=1,2,...,n/2)时称之为堆。
 		 * 在这里只讨论满足前者条件的堆。由堆的定义可以看出，堆顶元素（即第一个元素）必为最大项（大顶堆）。完全二 叉树可以很直观地表示堆的结构。堆顶为根，其它为左子树、右子树。
         * 思想:初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个 堆，这时堆的根节点的数最大。然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。依此类推，直到只有两个节点的堆，并对 它们作交换，最后得到有n个节点的有序序列。从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
         * @author Administrator
         *
         */
        //对data数组从0到lastIndex建大顶堆
        public static void buildMaxHeap(int[] data, int lastIndex){
             //从lastIndex处节点（最后一个节点）的父节点开始 
            for(int i=(lastIndex-1)/2;i>=0;i--){
                //k保存正在判断的节点 
                int k=i;
                //如果当前k节点的子节点存在  
                while(k*2+1<=lastIndex){
                    //k节点的左子节点的索引 
                    int biggerIndex=2*k+1;
                    //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                    if(biggerIndex<lastIndex){  
                        //若果右子节点的值较大  
                        if(data[biggerIndex]<data[biggerIndex+1]){  
                            //biggerIndex总是记录较大子节点的索引  
                            biggerIndex++;  
                        }  
                    }  
                    //如果k节点的值小于其较大的子节点的值  
                    if(data[k]<data[biggerIndex]){  
                        //交换他们  
                        swap(data,k,biggerIndex);  
                        //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值  
                        k=biggerIndex;  
                    }else{  
                        break;  
                    }  
                }
            }
        }
        //交换
        private static void swap(int[] data, int i, int j) {  
            int tmp=data[i];  
            data[i]=data[j];  
            data[j]=tmp;  
        } 
        /**
         * 8、基数排序
         * 用于大量数，很长的数进行排序时。
         * 将所有的数的个位数取出，按照个位数进行排序，构成一个序列。
         * 将新构成的所有的数的十位数取出，按照十位数进行排序，构成一个序列
         * @param a
         */
        public static void baseSort(int[] a) {
            //首先确定排序的趟数;    
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            int time = 0;
            //判断位数;    
            while (max > 0) {
                max /= 10;
                time++;
            }
            //建立10个队列;    
            List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < 10; i++) {
                ArrayList<Integer> queue1 = new ArrayList<Integer>();
                queue.add(queue1);
            }
            //进行time次分配和收集;    
            for (int i = 0; i < time; i++) {
                //分配数组元素;    
                for (int j = 0; j < a.length; j++) {
                    //得到数字的第time+1位数;  
                    int x = a[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                    ArrayList<Integer> queue2 = queue.get(x);
                    queue2.add(a[j]);
                    queue.set(x, queue2);
                }
                int count = 0;//元素计数器;    
                //收集队列元素;    
                for (int k = 0; k < 10; k++) {
                    while (queue.get(k).size() > 0) {
                        ArrayList<Integer> queue3 = queue.get(k);
                        a[count] = queue3.get(0);
                        queue3.remove(0);
                        count++;
                    }
                }
            }
     }         
    public static void main(String[] args) {
	  
    	 
        int[] numbers = {10,20,15,0,6,7,2,1,-5,55,33,123,34,72,23,45,789,12,5,8,37,9,3,38,124};
        System.out.print("排序前：");
        printArr(numbers);
        
        int[] numbers1 = {10,20,15,0,6,7,2,1,-5,55,33,123,34,72,23,45,789,12,5,8,37,9,3,38,124};
        bubbleSort(numbers1);
        System.out.print("冒泡排序后：");
        printArr(numbers1);
        
        int[] numbers2 = {10,20,15,0,6,7,2,1,-5,55,33,123,34,72,23,45,789,12,5,8,37,9,3,38,124}; 
        quick(numbers2);
        System.out.print("快速排序后：");
        printArr(numbers2);
        
        int[] number3 = {10,20,15,0,6,7,2,1,-5,55,33,123,34,72,23,45,789,12,5,8,37,9,3,38,124};      
        selectSort(number3);
        System.out.print("选择排序后：");
        printArr(number3);
        
        int[] numbers4 = {10,20,15,0,6,7,2,1,-5,55,33,123,34,72,23,45,789,12,5,8,37,9,3,38,124};
        insertSort(numbers4);
        System.out.print("插入排序后：");
        printArr(numbers4);
        
        int[] numbers5 = {10,20,15,0,6,7,2,1,-5,55,33,123,34,72,23,45,789,12,5,8,37,9,3,38,124};
        shellSort(numbers5);
        System.out.print("希尔排序后：");
        printArr(numbers5);
        
        int[] numbers6 = {10,20,15,0,6,7,2,1,-5,55,33,123,34,72,23,45,789,12,5,8,37,9,3,38,124};
        mergeSort(numbers6,0,9);
        System.out.print("归并排序后：");
        printArr(numbers6);
        
        int[] numbers7 = {10,20,15,0,6,7,2,1,-5,55,33,123,34,72,23,45,789,12,5,8,37,9,3,38,124};
        System.out.print("堆排序后：");
        for(int i=0;i<numbers.length-1;i++){  
            //建堆  
            buildMaxHeap(numbers7,numbers7.length-1-i);  
            //交换堆顶和最后一个元素  
            swap(numbers7,0,numbers.length-1-i);  
        }     
        printArr(numbers7);
         
        int[] numbers8 = {10,20,15,0,6,7,2,1,-5,55,33,123,34,72,23,45,789,12,5,8,37,9,3,38,124};
        baseSort(numbers8);
        System.out.print("基数排序后：");
        printArr(numbers8);
	}
    
    //打印函数
    public static void printArr(int[] numbers)
    {
        for(int i = 0 ; i < numbers.length ; i ++ )
        {
        System.out.print(numbers[i] + ",");
        }
        System.out.println("");
    }
}
