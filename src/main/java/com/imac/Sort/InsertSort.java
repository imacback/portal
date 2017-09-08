package com.imac.Sort;

/**
 * Created by ab054857 on 2017/8/21.
 * 插入排序
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
		System.out.println("排序之前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		//直接插入排序
		for (int i = 1; i < a.length; i++) {
			//待插入元素
			int temp = a[i];
			int j;
            /*for (j = i-1; j>=0 && a[j]>temp; j--) {
                //将大于temp的往后移动一位
                a[j+1] = a[j];
            }*/
			for (j = i-1; j>=0; j--) {
				//将大于temp的往后移动一位
				if(a[j]>temp){
					a[j+1] = a[j];
				}else{
					break;
				}
			}
			a[j+1] = temp;
		}
		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}

//	public static void main(String[] args) {
//		int[] a = new int[5];
//		a[0] = 7;
//		a[1] = 12;
//		a[2] = 5;
//		a[3] = 8;
//		a[4] = 10;
//
//		a = insertSort(a);
//
//		for (int i= 0; i < a.length; i++ ) {
//			System.out.println(a[i]);
//		}
//	}

	public static int[] insertSort(int[] a) {

		int in,out;

		for (out=1; out< a.length; out++) {
			int tmp = a[out];

			in = out;

			while (in > 0 && a[in -1] >= tmp) {
				a[in] = a[in - 1];
				--in;
			}

			a[in] = tmp;
		}
		return a;
	}


	public static int[] insertSort1(int[] a) {

		for (int i = 1; i< a.length; i++) {
			int tmp = a[i];

			int j  = i;
			while (j > 0 && a[j -1] >= tmp) {
				a[j] = a[j-1];
				--j;
			}

			a[j] = tmp;
		}
		return a;
	}
}
