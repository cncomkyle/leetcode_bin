package main

import (
	"fmt"
	"sort"
)

func threeSum(nums []int) [][]int {
    sort.Ints(nums)

	var result [][]int
	var tmpArray []int
	var p1, p2, tmp, tmp1 int
	for i:=0;i< len(nums) - 2;i++ {
		tmp1 = -1 * nums[i]
		p1 = i+1
		p2 = len(nums) - 1

		for ;p1 < p2; {
			tmp = nums[p1] + nums[p2]

			if tmp==tmp1 {
				result = append(result, append(tmpArray, nums[i], nums[p1], nums[p2]))

				for ;p1<p2 && nums[p1+1]==nums[p1]; {
					p1++
				}
				p1++

				for ;p1<p2&& nums[p2 -1]==nums[p2]; {
					p2--
				}
				p2--;
			} else if tmp < tmp1 {
				p1++
			} else {
				p2--
			}
		}

		for ;i < len(nums) -2 && nums[i+1] == nums[i]; {
			i++
		}
	}

	return result
}

func main() {
	nums := []int{-1, 0, 1, 2, -1, -4}
	result := threeSum(nums)
	for _, tmpArray := range result {
		for _, tmp := range tmpArray {
			fmt.Printf("%d ", tmp)
		}
		fmt.Println("")
	}
}
