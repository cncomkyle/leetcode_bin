package main

import(
	"fmt"
)

func getEdgePoint(nums []int, target int, leftFlag bool) int {
	left := 0
	right := len(nums)
	mid := -1

	for ;left < right; {
		mid = (left + right) / 2

		if nums[mid] > target || (leftFlag && nums[mid] == target) {
			right = mid
		} else {
			left = mid + 1
		}
	}

	return left
}

func searchRange(nums []int, target int) []int {
    rlt := []int{-1, -1}

	start := getEdgePoint(nums, target, true)

	if start == len(nums) || nums[start] != target {
		return rlt
	}

	rlt[0] = start
	rlt[1] = getEdgePoint(nums, target, false) - 1

	return rlt
}

func main() {
	nums := []int{5, 7, 7, 8, 8, 10}

	rlt := searchRange(nums, 8)

	for _, tmp := range rlt {
		fmt.Println(tmp)
	}
}
