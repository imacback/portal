package com.imac.Tree;

/**
 * Created by ab054857 on 2017/8/17.
 * 二叉树实现
 */
public class TreeNode {

	private int id;
	private String name;

	private TreeNode left;

	private TreeNode right;

	public TreeNode(int id, String value, TreeNode left, TreeNode right) {
		this.id = id;
		this.name = value;
		this.left = left;
		this.right = right;
	}

	public TreeNode(int key) {
		this.id = key;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	/**
	 * 前序
	 * @param treeNode
	 */
	public static void preOrder(TreeNode treeNode) {

		if (treeNode != null) {
			System.out.println(treeNode.getName());
			preOrder(treeNode.getLeft());
			preOrder(treeNode.getRight());
		}

	}

	/**
	 * 中序
	 * @param treeNode
	 */
	public static void inOrder(TreeNode treeNode) {
		if (treeNode != null) {
			inOrder(treeNode.getLeft());
			System.out.print(treeNode.getId() + " ");
			inOrder(treeNode.getRight());
		}
	}

	/**
	 * 后序
	 * @param treeNode
	 */
	public static void postOrder(TreeNode treeNode) {
		if (treeNode != null) {
			postOrder(treeNode.getLeft());
			postOrder(treeNode.getRight());
			System.out.println(treeNode.getName());
		}
	}


	public static void main(String[] args) {

		TreeNode left = new TreeNode(2,"b",null, null);
		TreeNode right = new TreeNode(3,"c", null, null);

		TreeNode root = new TreeNode(1,"a", left, right);

//		preOrder(root);
		inOrder(root);
//		postOrder(root);
	}

	@Override
	public String toString() {
		return "TreeNode{" +
				"id=" + id +
				'}';
	}
}
