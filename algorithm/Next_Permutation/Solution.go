package main
import (
	"fmt"
)

func nextPermutation(nums []int)  {
    breakIdx := -1

	for i:=len(nums)-1;i>0;i-- {
		if nums[i] > nums[i-1] {
			breakIdx = i -1 
			break
		}
	}

	if(breakIdx >= 0) {

		start := breakIdx+1
		end := len(nums)-1

		for ;; {
			mid := start+(end-start)/2

			if nums[mid] > nums[breakIdx] && (mid+1 == len(nums) || nums[mid+1] <= nums[breakIdx]) {
				nums[mid], nums[breakIdx] = nums[breakIdx], nums[mid]
				break
			}

			if nums[mid] > nums[breakIdx] {
				start = mid + 1
			} else {
				end = mid - 1
			}

		}
	}

	j:=len(nums)-1
	for i:=breakIdx+1;i<j;i++ {
		nums[i], nums[j] = nums[j], nums[i]
		j--
	}
}


func main() {
	nums := []int{1, 3, 2}
	nums = []int{1, 5, 1}
	nums = []int{1}
	nextPermutation(nums)
	for _, tmpVal := range nums {
		fmt.Printf("%d->", tmpVal)
	}
}
