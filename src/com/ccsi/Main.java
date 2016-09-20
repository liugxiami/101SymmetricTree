package com.ccsi;

public class Main {

    public static void main(String[] args) {
	    TreeNode root=buildTree();
        System.out.println(isSymmetric(root));
    }
    //Given a binary tree,check whether it is a mirror of itself(ie,sysmetric around its center)
    //1.bfs, in-order bfs,将left和right对换一下，并将值分别压到queue里去，比较两queue弹出的值是否一样。
    //2.对调left和right，比较两树是否一样
    //3.regular method
    public static boolean isSymmetric(TreeNode root){
        if(root==null)return true;
        return dfs(root.left,root.right);
    }
    public static boolean dfs(TreeNode left,TreeNode right){
        if(left==null&&right==null)return true;
        else if(left==null&&right!=null)return false;
        else if(left!=null&&right==null)return false;
        else{
            if(left.val!=right.val)return false;
            else if(!dfs(left.left,right.right)||!dfs(left.right,right.left))return false;
            return true;
        }
    }
    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(3);
        return root;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
