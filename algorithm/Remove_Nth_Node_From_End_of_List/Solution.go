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

func removeNthFromEnd(head *ListNode, n int) *ListNode {

    if head == nil {
		return nil
	}
	var newHead *ListNode
	newHead = head
	var tmpNode, nextNode *ListNode = nil, head
	nextNode = head
	count := 0
	for ;nextNode != nil; {
		count++
		if count == (n+1) {
			if tmpNode == nil {
				tmpNode = head
			} else {
				tmpNode = tmpNode.Next
			}
			count--
		}
		nextNode = nextNode.Next
	}

	if tmpNode == nil {
		newHead = newHead.Next
	} else {
		tmpNode.Next = tmpNode.Next.Next;
	}
	
	return newHead
}

func main() {
	var head *ListNode = &ListNode{Val:1}
	head.Next =  &ListNode{Val:2}
	head.Next.Next =  &ListNode{Val:3}
	head.Next.Next.Next =  &ListNode{Val:4}
	head.Next.Next.Next.Next =  &ListNode{Val:5}

	newHead := removeNthFromEnd(head, 2)
	
	for ;newHead != nil; {
		fmt.Printf("%d->",newHead.Val)
		newHead = newHead.Next
	}
}
