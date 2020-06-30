public class BinarySearchTree<E extends Comparable<E>> {
	class Node {
		E value;
		Node leftChild = null;
		Node rightChild = null;
		Node(E value) {
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof BinarySearchTree.Node) == false)
				return false;
			@SuppressWarnings("unchecked")
			Node other = (BinarySearchTree<E>.Node)obj;
			return other.value.compareTo(value) == 0 &&
					other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}
	
	protected Node root = null;
	
	protected void visit(Node n) {
		System.out.println(n.value);
	}
	
	public boolean contains(E val) {
		return contains(root, val);
	}
	
	protected boolean contains(Node n, E val) {
		if (n == null) return false;
		
		if (n.value.equals(val)) {
			return true;
		} else if (n.value.compareTo(val) > 0) {
			return contains(n.leftChild, val);
		} else {
			return contains(n.rightChild, val);
		}
	}
	
	public boolean add(E val) {
		if (root == null) {
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}
	
	protected boolean add(Node n, E val) {
		if (n == null) {
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0) {
			return false; // this ensures that the same value does not appear more than once
		} else if (cmp < 0) {
			if (n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			} else {
				return add(n.leftChild, val);
			} 	
		} else {
			if (n.rightChild == null) {
				n.rightChild = new Node(val);
				return true;
			} else {
				return add(n.rightChild, val);
			} 	
		}
	}	
	
	public boolean remove(E val) {
		return remove(root, null, val);
	}
	
	protected boolean remove(Node n, Node parent, E val) {
		if (n == null) return false;

		if (val.compareTo(n.value) == -1) {
				return remove(n.leftChild, n, val);
		} else if (val.compareTo(n.value) == 1) {
				return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null){
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n){
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
	    } else {
	       return maxValue(n.rightChild);
	    }
	}

	
	/*********************************************
	 * 
	 * IMPLEMENT THE METHODS BELOW!
	 *
	 *********************************************/
	
	
	// Method #1.
	public Node findNode(E val) {
		if (val == null) return null;
		return findNode(root, val);
	}
		
	protected Node findNode(Node n, E val) {
		if (n == null) return null;
			if (n.value.equals(val)) {
			return n;
		} else if (n.value.compareTo(val) > 0) {
			return findNode(n.leftChild, val);
		} else {
			return findNode(n.rightChild, val);
		}
	}

	// Method #2.
	protected int depth(E val) {
		if (val == null) return -1;
		if (!contains(val)) return -1;
		Node tempNode=root;
		boolean found=false;
		int i=0;
		while(!found) {
			if (tempNode.value.equals(val))
				found=true;
			else if (tempNode.value.compareTo(val) > 0) {
				tempNode=tempNode.leftChild;
				i++;
			}
			else {
				tempNode=tempNode.rightChild;
				i++;
			}
		}
		return i;
	}
	
	// Method #3.
	protected int height(E val) {
		if (val == null) return -1;
		if (!contains(val)) return -1;
		Node tempNode=findNode(val);
		int temp_height=get_height(tempNode);
		return temp_height;	
	}
	//Tree t = Tree(1,Tree(2,Tree(4),Tree(5)),Tree(3));
			
	int get_height(Node node) {
		if (node == null) 
			return 0;
		else if (node.leftChild == null && node.rightChild == null)
			return 0;		
		else return 1 + max(get_height(node.leftChild), get_height(node.rightChild));
	}
	int max(int leftN, int rightN) {
		if (leftN>=rightN) return leftN;
		else return rightN;
	}
	// Method #4.
	protected boolean isBalanced(Node n) {
		if (n == null) return false;
		if (!contains(n.value)) return false;
		int height_left_value=0;
		int height_right_value=0;
		if(n.leftChild == (null))
			height_left_value=-1;
		 else
			height_left_value=height(n.leftChild.value);
		if(n.rightChild == (null))
			height_right_value=-1;
		 else
			height_right_value=height(n.rightChild.value);
		
		if (Math.abs(height_left_value-height_right_value)<2)
			return true;
		return false;
	}
	
	// Method #5. .
	public boolean isBalanced() {
     /* Base case - Empty tree is always balanced */
	     if(root == null)
	          return true;

	     /* Compute height of the left and right subtree and their difference */
	    int heightDifference = computeHeight(root.leftChild) - computeHeight(root.rightChild);

	    if(Math.abs(heightDifference)  <= 1)
	          return isBalanced(root.leftChild)  && 
	                 isBalanced(root.rightChild);
	    else
	          return false;
	    
	 }

	public int computeHeight(Node root){

	      /* Base case - Tree is empty */
	      if(root == null)
	           return 0;
	      /* Calculate recursively */
	      return Math.max(computeHeight(root.leftChild), computeHeight(root.rightChild)) + 1;
	 }
}
	

