package Common;

import java.util.Random;

/**
 * @author Amph
 * Equivalent to Chromosome class but instead of a array is in a binary tree structure
 */
public class BinaryTree {
	public String[] Functions= {
		"add",
		"sub",
		"mul"
	};
	public String[] Terminals= {
		"x",
		"-2",
		"-1",
		"0",
		"1",
		"2"
	};
	
	protected String root = null;
	
	protected BinaryTree left = null; //left child
	protected BinaryTree right = null; //right child
	
	protected int numNodes = 0;
	protected int depth = 0;
	
	private boolean amIRoot=false;
	private boolean amILeaf=false;
	
	private Random rnd;
	public BinaryTree(boolean root) {
		this.amIRoot=root;
		rnd= new Random();
	}
	
	public void init(int depth) {
		if(depth > 0) {
			int index=-1;
			this.numNodes=(int)Math.pow(2, depth) -1;
			this.depth=depth;
			
			//terminal leaf
			if(depth==1) {
				this.amILeaf=true;
				index=(int)rnd.nextInt(0,Terminals.length);
				this.root=Terminals[index];
			
			}
			//recursive case
			else {
				index=(int)rnd.nextInt(0,Functions.length);
				this.root=Functions[index];
				
				//create children
				this.left=new BinaryTree(false);//child so not a root
				this.right=new BinaryTree(false);//child so not a root
				
				//initialize children
				this.left.init(depth-1);
				this.right.init(depth-1);
			}
			
			
		}
	}
	public void growinit(int depth) {
		
	}
	
	public void setRoot(String root, boolean isRoot, boolean isLeaf) {
		this.root=root;
		this.amIRoot=isRoot;
		this.amILeaf=isLeaf;
	}
	
	public void setLeft(BinaryTree left, boolean isRoot, boolean isLeaf) {
		this.left=left;
		this.amIRoot=isRoot;
		this.amILeaf=isLeaf;
	}
	
	public void setRight(BinaryTree right, boolean isRoot, boolean isLeaf) {
		this.right=right;
		this.amIRoot=isRoot;
		this.amILeaf=isLeaf;
	}
	
	
	
}
