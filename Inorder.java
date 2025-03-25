package abc;

import java.io.*;
import java.util.*;

class  Node{
	int data;
	Node left;
	Node right;
	Node(int v)
	{
		this.data=v;
		this.left=this.right=null;
	}
}

class Inorder{
	//InOrder Traversal
	public static void printInorder(Node node) {
		if(node==null)
			return;
		printInorder(node.left);
		System.out.println(node.data);
		printInorder(node.right);
	}
	
	public static void main(String[] args) {
		//Build the tree
		Node root=new Node(100);
		root.left=new Node(20);
		root.right=new Node(200);
		root.left.left=new Node(10);
		root.left.right=new Node(30);
		root.right.left=new Node(150);
		root.right.right=new Node(300);
		
		//Function call
		System.out.println("Inorder Traversal:");
		printInorder(root);
	}
}

