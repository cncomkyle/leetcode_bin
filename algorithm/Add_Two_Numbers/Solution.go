/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var head, tail *ListNode
	head = &ListNode{Val:0}
	tail = head
	zeroNode := &ListNode{Val:0}
	add1, add2 := l1, l2

	var newNode *ListNode
	newVal, nextAddition := 0, 0

	for {
		newVal = add1.Val + add2.Val + nextAddition
		nextAddition = newVal / 10
		newVal = newVal % 10

		newNode = &ListNode{Val:newVal}

		tail.Next = newNode
		tail = newNode

		if add1.Next == nil {
			add1 = zeroNode
		} else {
			add1 = add1.Next
		}

		if add2.Next == nil {
			add2 = zeroNode
		} else {
			add2 = add2.Next
		}

		if add1 == zeroNode && add2 == zeroNode && nextAddition == 0 {
			break;
		}
	}
	
	return head.Next
}
