class DoublyLinkedList {

	/**
	 * Node class - nested class to be used as Node for Doubly Linked list 
	 */
	class Node { 
		private int data; 
		private Node previous; 
		private Node next;

		// Constructor for creating node
		Node(int data) { 
			this.data = data;
		}

		int getData() {
			return data;
		}

		void setNextNode(Node node){
			this.next = node;
		}

		Node getNextNode(){
			return next;
		}

		void setPreviousNode(Node node){
			this.previous = node;
		}

		Node getPreviousNode(){
			return previous;
		}
	}


	private Node firstNode;
  private Node lastNode;
	private int length;
	
	/**
	 * Constructor to initialise the list
	 */ 
	DoublyLinkedList () {
		length = 0;
	}

	/**
	 * Adds the provided data at the front of the list
	 * @param newData data to be added
	 */
	public void addFirst(int newData) { 
		// create new node with new data
		Node newNode = new Node(newData); 

		// change the reference of the new node
		newNode.setNextNode(firstNode);
		newNode.setPreviousNode(null);

		// update reference of previous node
		if (firstNode != null) {
			firstNode.setPreviousNode(newNode);
			
		}
        if(newNode.getNextNode() == null){
			lastNode = newNode;
		}
		// change the first node to new node
		firstNode = newNode;
		
		length++;
	}

	/**
	 * Adds the provided data at the end of the list
	 * @param newData data to be added
	 */
	public void addLast(int newData) { 

		// create new node with new data
		Node newNode = new Node(newData);
		
		// change the reference of the new node
		newNode.setNextNode(null);    
        newNode.setPreviousNode(lastNode);

		// update reference of previous node to last node
		if (lastNode != null) {
			lastNode.setNextNode(newNode);
			
		}
        if(newNode.getPreviousNode() == null){
			firstNode = newNode;
		}
		
		// change the last node to new node
		lastNode = newNode;
		length++;
	}

	/**
	 * Removes the specified node from the list
	 * @param deleteNode node to be removed
	 * @return returns true if specified node is removed
	 */
	public boolean removeNode(Node deleteNode) {
		// return false if list is empty or provided node is null
		if(deleteNode == null || firstNode == null) return false;

		// if to be deleted node is first node or last node then change reference respectively
		if(firstNode == deleteNode) firstNode = deleteNode.getNextNode();
		if(lastNode == deleteNode) lastNode = deleteNode.getPreviousNode();

		// adjust the reference to remove the to be deleted node
		Node previousNode = deleteNode.getPreviousNode();
		Node nextNode = deleteNode.getNextNode();

		// before adjusting the reference ensure that they are not null
		if(previousNode != null) previousNode.setNextNode(nextNode);
		if(nextNode != null) nextNode.setPreviousNode(previousNode);
		length--;
		return true;
	}

	/**
	 * Getter method that returns the first node in the list
	 * @return returns the first node
	 */
	public Node getFirstNode(){
    return firstNode;
  }

	/**
	 * Getter method that returns the last node in the list
	 * @return returns the last node
	 */
  public Node getLastNode(){
    return lastNode;
  }

	/**
	 * Getter method that returns the length of the list
	 * @return returns the length
	 */
  public int getLength(){
    return length;
  }

	/**
	 * Prints the data in all the nodes in the list starting with first node
	 */ 
	public void printList() {
		if(getLength() == 0) {
			System.out.println("List is empty");
			return;
		}
		Node node = firstNode;
		System.out.println("Printing the list data...");
		while(node != null) {
			System.out.println("List data: " + node.getData());
			node = node.getNextNode();
		}
		System.out.println("End of the list data...");
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) { 
		// create the list
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

		// add data to the front
		doublyLinkedList.addFirst(7);
		doublyLinkedList.addLast(6);
		doublyLinkedList.addFirst(1);

		// get the last node from the list - should be 6
		DoublyLinkedList.Node extractedLastNode = doublyLinkedList.getLastNode();

		/* print the list 
		 * should print data in following order 1, 7, 6
		*/
		doublyLinkedList.printList();

		// add data at the end of the list 
		doublyLinkedList.addLast(4);

		// add data at the front of the list 
		doublyLinkedList.addFirst(5);

		// get the last node from the list - should be 5
		DoublyLinkedList.Node extractedFirstNode = doublyLinkedList.getFirstNode();

		/* print the list 
		 * should print data in following order 5, 1, 7, 6, 4
		*/
		doublyLinkedList.printList();

		// remove the node - should remove 6
		doublyLinkedList.removeNode(extractedLastNode);

		/* print the list 
		 * should print data in following order 5, 1, 7, 4
		*/
		doublyLinkedList.printList();

		// remove the node - should remove 5
		doublyLinkedList.removeNode(extractedFirstNode);

		/* print the list 
		 * should print data in following order 1, 7, 4
		*/
		doublyLinkedList.printList();
	} 
}
