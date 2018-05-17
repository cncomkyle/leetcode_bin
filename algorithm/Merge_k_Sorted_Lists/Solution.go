package main

import(
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
func mergeKLists(lists []*ListNode) *ListNode {
    if len(lists)==0 {
		return nil
	}

	return merge(0, len(lists) - 1, lists)
}

func merge(start int, end int, lists []*ListNode) *ListNode {
	if start == end {
		return lists[start]
	}
	mid := start + (end - start)/2
	left := merge(start, mid, lists)
	right := merge(mid+1, end, lists)
	head := &ListNode{Val:0}
	nextNode := head
	
	
	for ;left!=nil&&right!=nil; {
		if left.Val < right.Val {
			nextNode.Next = left
			left = left.Next
		} else {
			nextNode.Next = right
			right = right.Next
		}
		nextNode = nextNode.Next
	}

	if left != nil {
		nextNode.Next = left
	} else if(right != nil) {
		nextNode.Next = right
	}

	return head.Next
}

func main() {
	var lists []*ListNode
	l1 := &ListNode{Val:1}
	l1.Next = &ListNode{Val:4}
	lists = append(lists, l1)

	l2 := &ListNode{Val:1}
	l2.Next = &ListNode{Val:3}
	lists = append(lists, l2)

	
	rlt := mergeKLists(lists)

	for ;rlt!=nil; {
		fmt.Printf("%d->", rlt.Val)
		rlt = rlt.Next
	}
}
