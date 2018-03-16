package com.imac.Sort;

/**
 * java 背包问题
 *
 *  背包问题 背包问题是计算机科学里的经典问题。在最简单的形式中，包括试图将不同重量的数据项放到

 背包中．以使背包最后达到指定的总重量。不需要把所有的选项都放入背包中。 举例来说，假设想要背包精确地承重20磅，并且有5个可以选择   放入的数据项，它们的重量

 依次为11磅、8磅、7磅、6磅和5磅。对于选择放入的数据项数量不大时，人类很善于通过观察

 就可以解决这个问题。于是大概可以计算出只有8磅、7磅和5磅的数据项加在一起和为20磅。 如果想要计算机来解决这个问题，就需要给计算     机更详细的指令。



 算法如下：

 1．如果在这个过程中的任何时刻，选择的数据项的总和符合目标重量，工作就完成了。

 2．从选择第一个数据项开始。剩余的数据项的加和必须符合背包的目标重量减去第一个数据 项的重量；这是一个新的目标重量。

 3．逐个地试每种剩余数据顶组合的可能性。但是，注意并不需要去试所有的组合，因为只要 数据顶朗和大于目标重量的时候，就停止添加数据项。

 4．如果设有组合合适的话，放弃第—‘个数据项，并且从第二个数据项开始再重复一边整个 过程。

 5．继续从第三个数据项开始，如此下去直到你已经试过所有的组合，这时知道没有解决答案。
 */
public class BeiBao {

	static int[] a = new int[5]; // 背包重量
	static int[] b = new int[5]; // 结果数组
	static int flag = 0; // 下一个候选项
	static int bound = 20; // 总重量
	static int totle = 0; // 每次选择后的总重量

	/**
	 * 背包
	 *
	 * @param i
	 *            元素坐标
	 * @param leftbound
	 *            目标重量
	 * @param t
	 */
	public static void inserttry(int i, int leftbound, int t) {
		if (i < 5 && leftbound <= totle) {
			if (a[i] < leftbound) { // 当前的所选的数小于已选数的总和，将当前所选的数放入结果数组，从目标重量减掉当前所选数，递归，选择后的重量数减掉当前所选数
				b[t++] = a[i];
				totle = totle - a[i];
				leftbound = leftbound - a[i];
				i++;
				inserttry(i, leftbound, t);
			} else if (a[i] > leftbound) { // 当前的所选的数大于已选数的总和，不符合条件，选择后的重量数减掉当前所选数，递归
				totle = totle - a[i];
				i++;
				inserttry(i, leftbound, t);
			} else { // 当前所选的数等于已选数的总和
				b[t] = a[i];
				return;
			}
		} else { // 数组中没有符合当前条件的元素，将前一个数值移除，递归
			leftbound = leftbound + b[--t];
			for (int f = 0; f < 5; f++) {
				if (a[f] == b[t]) {
					flag = ++f;
					break;
				}
			}
			b[t] = 0;
			totle = 0;
			for (int m = flag; m < 5; m++) {
				totle += a[m];
			}
			inserttry(flag, leftbound, t);
		}
		return;
	}
	public static void main(String[] args) {
		a[0] = 11;
		a[1] = 8;
		a[2] = 6;
		a[3] = 7;
		a[4] = 5;
		for (int i = 0; i < 5; i++) {
			b[i] = 0;
		}
		for (int i = 0; i < 5; i++) {
			totle += a[i];
		}
		inserttry(0, 20, 0);
		for (int i = 0; i < 5; i++) {
			System.out.println(b[i]);
		}
	}
}
