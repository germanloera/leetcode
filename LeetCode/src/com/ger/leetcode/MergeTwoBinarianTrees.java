package com.ger.leetCode;

import com.ger.leetcode.Main;

public class MergeTwoBinarianTrees {

// https://leetcode.com/problems/merge-two-binary-trees/description/
//
// Given two binary trees and imagine that when you put one of them to cover the other,
// some nodes of the two trees are overlapped while the others are not.
//
// You need to merge them into a new binary tree.
// The merge rule is that if two nodes overlap,
// then sum node values up as the new value of the merged node.
// Otherwise, the NOT null node will be used as the node of new tree.
//
//            Example 1:
//    Input:
//    Tree 1                     Tree 2
//             1                         2
//            / \                       / \
//           3   2                     1   3
//          /                           \   \
//         5                             4   7
//    Output:
//    Merged tree:
//            3
//           / \
//          4   5
//         / \   \
//        5   4   7
//    Note: The merging process must start from the root nodes of both trees.



   static TreeNode root;
   //static TreeNode current;

    public static void insertNewNode(int value, TreeNode _root){

        if(_root == null){
            _root = new TreeNode(value);
        return;
        }
        else if(value < _root.val ){


            if(_root.left == null){
                _root.left = new TreeNode(value);

            }else {
                insertNewNode(value, _root.left);
            }


        }else{
            if(_root.right == null){
                _root.right = new  TreeNode(value);

            }else {
                insertNewNode(value, _root.right);
            }
        }


    }




    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2){


        if(t1 ==  null && t2 == null){
            return null;
        }else if(t1 == null && t2 != null){
            return t2;
        }else if(t1 != null && t2 == null ){

            return t1;

        }
          preOrder(t1, t2, 0, root);

        return  root;

    }



    public static void preOrder(TreeNode t1, TreeNode t2, int left, TreeNode current){

        if(t1 ==  null && t2 == null){
            return;
        }else if(t1 == null && t2 != null){
            current.left = t2;
            return;
        }else if(t1 != null && t2 == null ){

            current.right = t1;
return;
        }



        TreeNode n =new TreeNode(t1.val + t2.val);
        if( left == 1 ){
            current.left = n;
            current = current.left;
        }else if(left == 2){
            current.right = n;
            current = current.right;
        }else{
            root = n;
current = root;
        }


        preOrder(t1.left, t2.left, 1, current);
        preOrder(t1.right, t2.right, 2, current);


    }















public static void main(String[] args){

    TreeNode t1 = new TreeNode(1);
    TreeNode t2= new TreeNode(2);;


    insertNewNode(2, t1);
    insertNewNode(3, t1);
    insertNewNode(5, t1);



    insertNewNode(1, t2);
    insertNewNode(3, t2);
    insertNewNode(4, t2);
    insertNewNode(7, t2);


TreeNode t = mergeTrees(t1, t2);
Main.p("");


}


}


 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
