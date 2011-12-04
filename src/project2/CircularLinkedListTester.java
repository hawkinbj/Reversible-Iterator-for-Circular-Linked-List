package project2;

public class CircularLinkedListTester {

	public enum TYPE {
		STRING, INTEGER;
	}

	public static void main(String[] args) {
		System.out.println("This project was written by Brandon Hawkins\n");

		// BEGIN TESTING INTEGERS
		System.out.println("***BEGIN INTEGER TESTS***\n");

		CircularList<Integer> list = new CircularLinkedList<Integer>();
		for (int i = 1; i <= 4; i++) {
			list.add(i);
		}

		// testing RIForCircularList
		currentList(list);
		testerOne(list);
		testerTwo(list);

		// testing setFront()
		list.setFront(3);
		System.out.println("***FRONT HAS BEEN SET TO 3***\n");
		currentList(list);
		testerOne(list);
		testerTwo(list);

		// testing remove()
		list.remove(3);
		System.out.println("***3 (front) HAS BEEN REMOVED***\n");
		currentList(list);
		testerOne(list);
		testerTwo(list);
		System.out.println("***2 (back) HAS BEEN REMOVED***\n");
		list.remove(2);
		currentList(list);
		testerOne(list);
		testerTwo(list);

		// reset list to original contents (1234)
		System.out.println("***LIST RESET TO ORIGINAL CONTENTS***");
		list.add(2);
		list.add(3);
		list.setFront(1);
		currentList(list);
		System.out.println();

		// testing contains()
		System.out.println("Testing contains()");
		System.out.println("Does list contain 1?: " + list.contains(1));
		System.out.println("Does list contain 2?: " + list.contains(2));
		System.out.println("Does list contain 3?: " + list.contains(3));
		System.out.println("Does list contain 4?: " + list.contains(4));
		System.out.println("Does list contain 5?: " + list.contains(5));
		System.out.println();

		// tesing size() with help of add() and remove() many elements
		System.out.println("***NEW LIST***");
		System.out
				.println("Testing size() by adding and removing many elements");
		addRemoveMany(50, TYPE.INTEGER);
		System.out.println();
		System.out.println("***END INTEGER TESTS***\n");
		System.out.println("*****************************************\n");

		// BEGIN STRING TESTS
		System.out.println("***BEGIN STRING TESTS***\n");

		CircularList<String> listS = new CircularLinkedList<String>();
		for (int i = 1; i <= 4; i++) {
			listS.add(Integer.toString(i));
		}

		// testing RIForCircularList
		currentList(listS);
		testerOne(listS);
		testerTwo(listS);

		// testing setFront()
		listS.setFront("3");
		System.out.println("***FRONT HAS BEEN SET TO \"3\"***\n");
		currentList(listS);
		testerOne(listS);
		testerTwo(listS);

		// testing remove()
		listS.remove("3");
		System.out.println("***\"3\" (front) HAS BEEN REMOVED***\n");
		currentList(listS);
		testerOne(listS);
		testerTwo(listS);
		System.out.println("***\"2\" (back) HAS BEEN REMOVED***\n");
		listS.remove("2");
		currentList(listS);
		testerOne(listS);
		testerTwo(listS);

		// reset listS to original contents (1234)
		System.out.println("***LIST RESET TO ORIGINAL CONTENTS***");
		listS.add("2");
		listS.add("3");
		listS.setFront("1");
		currentList(listS);
		System.out.println();

		// testing contains()
		System.out.println("Testing contains()");
		System.out.println("Does list contain \"1\"?: " + listS.contains("1"));
		System.out.println("Does list contain \"2\"?: " + listS.contains("2"));
		System.out.println("Does list contain \"3\"?: " + listS.contains("3"));
		System.out.println("Does list contain \"4\"?: " + listS.contains("4"));
		System.out.println("Does list contain \"5\"?: " + listS.contains("5"));
		System.out.println();

		// tesing size() with help of add() and remove() many elements
		System.out.println("***NEW LIST***");
		System.out
				.println("Testing size() by adding and removing many elements");
		addRemoveMany(50, TYPE.STRING);
	}

	// Test1 iterates from front to back + 1 additional node and backwards to
	// front + 1 additional node
	public static <T> void testerOne(CircularList<T> list) {
		RIForCircularList<T> iter = new RIForCircularList<T>(list);
		System.out.print("Should iterate from " + list.getList().front.element
				+ " to " + list.getList().back.next.element + ": ");
		for (int i = 0; iter.hasNext() && i < list.size() + 1; i++) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		System.out.print("Should iterate back from "
				+ list.getList().back.element + " to "
				+ list.getList().front.previous.element + ": ");
		for (int i = 0; iter.hasPrevious() && i < list.size() + 1; i++) {
			System.out.print(iter.previous() + " ");
		}
		System.out.println();
		System.out.println();
	}

	// Test 2 iterates forwards through the list size*2 times, then backwards to
	// the start + one additional node
	public static <T> void testerTwo(CircularList<T> list) {
		RIForCircularList<T> iter = new RIForCircularList<T>(list);
		System.out.print("Should iterate up through the list twice : ");
		for (int i = 0; iter.hasNext() && i < list.size() * 2; i++) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		System.out
				.print("Should iterate back down plus one additional previous() call: ");
		for (int i = 0; iter.hasPrevious() && i < list.size() * 2 + 1; i++) {
			System.out.print(iter.previous() + " ");
		}
		System.out.println();
		System.out.println();
	}

	// tests size by adding specified # of elements of Object enum TYPE,
	// removing half, and showing size() along the way
	public static <T> void addRemoveMany(int num, TYPE type) {
		if (type == TYPE.STRING) {
			CircularList<String> list = new CircularLinkedList<String>();
			System.out.println("Testing size() while list is empty: "
					+ list.size());
			for (int i = 1; i <= num; i++) {
				list.add(Integer.toString(i));
			}
			System.out.println("After adding " + num + " elements, size is: "
					+ list.size());
			currentList(list);
			for (int i = 1; i <= num / 2; i++) {
				list.remove(Integer.toString(i));
			}
			System.out.println("After removing first " + num / 2
					+ " elements, size is: " + list.size());
			currentList(list);
			return;
		}
		if (type == TYPE.INTEGER) {
			CircularList<Integer> list = new CircularLinkedList<Integer>();
			System.out.println("Testing size() while list is empty: "
					+ list.size());
			for (int i = 1; i <= num; i++) {
				list.add(i);
			}
			System.out.println("After adding " + num + " elements, size is: "
					+ list.size());
			currentList(list);
			for (int i = 1; i <= num / 2; i++) {
				list.remove(i);
			}
			System.out.println("After removing elements first " + num / 2
					+ " elements, size is: " + list.size());
			currentList(list);
			return;
		} else
			throw new IllegalArgumentException(
					"Parameter must one of declared enumerated types");
	}

	public static <T> void currentList(CircularList<T> list) {
		System.out.print("Current state of list from front to back: ");
		RIForCircularList<T> iter = new RIForCircularList<T>(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(" " + iter.next());
		}
		System.out.println();
	}
}