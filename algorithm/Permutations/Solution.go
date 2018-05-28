package main

import(
	"fmt"
)

func generate(nums []int, flags []int, prefix []int, length int, rltList *[][]int) {
	length++

	for i, tmpVal := range nums {
		if flags[i] == 1 {
			continue;
		}
		flags[i]=1
		prefix[length-1]=tmpVal
		if length < len(nums) {
			generate(nums, flags, prefix, length, rltList)
		} else {
			tmpList := make([]int, len(nums))
			copy(tmpList[:], prefix)
			*rltList=append(*rltList, tmpList)
		}
		flags[i]=0
	}
}

func permute(nums []int) [][]int {
	var rltList [][]int
    if len(nums) == 0 {
		return rltList
	}
	flags := make([]int, len(nums))
	prefix := make([]int, len(nums))
	length := 0
	generate(nums, flags, prefix, length, &rltList)
	
	return rltList
}

func main() {
	nums := []int{1, 2, 3}
	rltList := permute(nums)
	for _, tmpList := range rltList {
		for _, tmp := range tmpList {
			fmt.Printf("%d,", tmp)
		}
		fmt.Printf("\n")
	}
}
