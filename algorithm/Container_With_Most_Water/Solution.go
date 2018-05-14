package main
import (
	"fmt"
)
func maxArea(height []int) int {
    var maxArea int = 0
	left := 0
	right := len(height) -1
	tmp := 0
	for ;left < right; {
		if height[left] <= height[right] {
			tmp = (right - left) * height[left]
			left +=1
		} else {
			tmp = (right - left) * height[right]
			right -=1
		}

		if maxArea < tmp {
			maxArea = tmp
		}
	}
	return maxArea
}

func main() {
	var datas = []int {1, 2 , 3, 4}
	fmt.Println(maxArea(datas))
}
