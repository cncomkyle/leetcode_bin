package main

import (
	"fmt"
)

func trap(height []int) int {
    sum := 0
	if len(height)==0 {
		return 0
	}
	left :=0
	right := len(height)-1
	maxLeft := 0
	maxRight := 0
	for ;left < right; {
		if height[left] < height[right] {
			if maxLeft < height[left] {
				maxLeft = height[left]
			} else {
				sum = sum + (maxLeft - height[left])
			}
			
			left++
		} else {
			if maxRight < height[right] {
				maxRight = height[right]
			} else {
				sum = sum + (maxRight - height[right])
			}

			right--
		}
	}
	return sum
}

func main() {
	height := []int{0,1,0,2,1,0,1,3,2,1,2,1}
	fmt.Println(trap(height))
}
