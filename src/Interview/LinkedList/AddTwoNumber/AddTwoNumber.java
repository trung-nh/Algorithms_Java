package Interview.LinkedList.AddTwoNumber;

public class AddTwoNumber {
	public static void main(String[] args) {

	}
}


//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode preRoot = new ListNode();
		ListNode cur = preRoot;
		int rem = 0;
		while (l1 != null || l2 != null) {
			int x = (l1 == null) ? 0 : l1.val;
			int y = (l2 == null) ? 0 : l2.val;
			int val = x + y + rem;
			rem = val / 10;
			cur.next = new ListNode(val % 10);
			cur = cur.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (rem != 0) {
			cur.next = new ListNode(1);
		}
		return preRoot.next;
	}
}