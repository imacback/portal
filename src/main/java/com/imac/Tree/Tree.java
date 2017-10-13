package com.imac.Tree;

import java.util.Random;

/**
 * Created by ab054857 on 2017/8/28.
 */
public class Tree {

	private static TreeNode root;

	public TreeNode find(int key) {
		TreeNode current = root;

		while (current != null && current.getId() != key) {
			if (key > current.getId()) {
				current = current.getRight();
			} else {
				current = current.getLeft();
			}
		}

		if (current != null) {
			System.out.println("find key in:" + current);
		} else {
			System.out.println("not find key!" + key);
		}

		return current;
	}

	public boolean delete(int key) {
		boolean result = false;

		TreeNode current = root;
		TreeNode parent = root;
		boolean isleft = false;

		while (current != null && current.getId() != key) {
			parent = current;

			if (key > current.getId()) {
				current = current.getRight();
				isleft = false;
			} else {
				isleft = true;
				current = current.getLeft();
			}

			if (current == null) {
				return false;
			}
		}

		if (current.getLeft() == null && current.getRight() == null) {
			if (current == root) {
				root = null;
			} else if (isleft) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
		} else if (current.getLeft() == null) {
			if (current == root) {
				root = current.getRight();
			} else if (isleft) {
				parent.setLeft(current.getRight());
			} else {
				parent.setRight(current.getRight());
			}
		} else if (current.getRight() == null) {
			if (current == root) {
				root = current.getLeft();
			} else if (isleft) {
				parent.setLeft(current.getLeft());
			} else {
				parent.setRight(current.getLeft());
			}
		} else {
			/**
			 * 后继结点是delNode的右子节点的左后代
			 *
			 * 如查 sunncessor 是要删除结点的右子结点的左后代，执行删除操作需要四个步骤
			 *
			 * 1、把 sunncessor 父结点的 leftChild 设置为后继的右子结点
			 * 2、把 sunncessor 的右子结点设置为 delNode 的右子结点
			 * 3、把 delNode 从它父结点的右子结点删除，把这个设置为 sunncessor
			 * 4、把 delNode 的左子结点从要删除结点移除， 后继结点的leftChild设置为delNode的左子结点
			 *
			 *
			 */

			TreeNode sunncessor = getSuccessor(current);

			if (sunncessor == root) {
				root = sunncessor;
			} else if(isleft) {
				parent.setLeft(sunncessor); //
			} else {
				parent.setRight(sunncessor); //3、把 delNode 从它父结点的右子结点删除，把这个设置为 sunncessor
				sunncessor.setLeft(current.getLeft()); //4、把 delNode 的左子结点从要删除结点移除， 后继结点的leftChild设置为delNode的左子结点
			}
		}

		return result;
	}

	private TreeNode getSuccessor(TreeNode delNode) {
		TreeNode successor = delNode;
		TreeNode successorParent = delNode;

		TreeNode current = delNode.getRight();

		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.getLeft();
		}

		if (successor != delNode.getRight()) {
			successorParent.setLeft(successor.getRight());  // 1、把 sunncessor 父结点的 leftChild 设置为后继的右子结点
			successor.setRight(delNode.getRight()); // 2、把 sunncessor 的右子结点设置为 delNode 的右子结点
		}

		return successor;
	}

	public void insert(int id, String name) {

		if (root == null) {
			TreeNode node1 = new TreeNode(id, name, null, null);
			root = node1;
			return;
		}

		TreeNode current = root;
		TreeNode parent = root;

		while (current != null) {//遍历右子树

			if (id >= current.getId()) {
				parent = current;
				current = current.getRight();
			} else {
				parent = current;
				current = current.getLeft();
			}
		}

		if (id >= parent.getId()) {
			TreeNode node1 = new TreeNode(id, name, null, null);
			parent.setRight(node1);
		} else {
			TreeNode node1 = new TreeNode(id, name, null, null);
			parent.setLeft(node1);
		}
	}

	public static int min() {
		if (root != null) {
			TreeNode current = root;
			TreeNode parent = root;

			while (current != null) {
				parent = current;
				current = current.getLeft();
			}

			return parent.getId();
		}
		return 0;
	}

	public static int max() {
		if (root != null) {
			TreeNode current = root;
			TreeNode parent = root;

			while (current != null) {
				parent = current;
				current = current.getRight();
			}

			return parent.getId();
		}
		return 0;
	}

	public static void main(String args[]) {
		Tree tree = new Tree();
		Random random = new Random();

		for (int i=0; i<10; i++) {
			int r = random.nextInt(100);
			tree.insert(r, String.valueOf(i));
		}

		TreeNode.inOrder(root);

		System.out.println("=============================");

		int min = min();

		System.out.println("min id:" + min);

		int max = max();

		System.out.println("max id:" + max);

		int key = random.nextInt(100);
		TreeNode treeNode = tree.find(key);

		if (treeNode != null) {
			tree.delete(key);

			TreeNode.inOrder(root);
		}


	}
}
