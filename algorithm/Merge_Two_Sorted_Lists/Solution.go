package main
import (
	"fmt"
)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
type ListNode struct {
	Val int
	Next *ListNode
}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
    var head, tmpNode, nextNode *ListNode

	for ;l1 != nil && l2 !=nil; {
		if l1.Val <= l2.Val {
			tmpNode = l1
			l1 = l1.Next
		} else {
			tmpNode = l2
			l2 = l2.Next
		}

		if head == nil {
			head = tmpNode
			nextNode = head
		} else {
			nextNode.Next = tmpNode
			nextNode = tmpNode
		}
	}
	tmpNode = nil

	if l1 != nil {
		tmpNode = l1
	} else if l2 != nil {
		tmpNode = l2
	}

	if nextNode == nil {
		head = tmpNode
	} else {
		nextNode.Next = tmpNode
	}
		
	return head
}

func main() {
	head1 := &ListNode{Val:1}
	head1.Next = &ListNode{Val:2}
	head1.Next.Next = &ListNode{Val:4}

	head2 := &ListNode{Val:1}
	head2.Next = &ListNode{Val:3}
	head2.Next.Next = &ListNode{Val:4}

	result := mergeTwoLists(head1, head2)

	for ;result != nil; {
		fmt.Printf("%d->", result.Val)
		result = result.Next
	}

}
