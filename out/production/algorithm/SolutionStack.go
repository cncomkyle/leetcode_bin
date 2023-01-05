package main

import(
	"fmt"
)

func longestValidParentheses(s string) int {
    if len(s) < 2 {
		return 0;
	}
	maxLength := 0
	var stack = make([]int, len(s) + 1)
	stackIndex := -1

	stackIndex++
	stack[stackIndex] = -1

	var tmpStr string
	for i, tmpChar := range s[:] {
		tmpStr = string(tmpChar)

		if tmpStr == "(" {
			stackIndex++
			stack[stackIndex] = i

		} else {
			stackIndex--

			if stackIndex < 0 {
				stackIndex++
				stack[stackIndex] = i
			} else {
				if (i - stack[stackIndex]) > maxLength {
					maxLength = i - stack[stackIndex]
				}
			}
		}
	}

	return maxLength
}

func main() {
	fmt.Println(longestValidParentheses(")()())"));
	fmt.Println(longestValidParentheses("(()"));
	fmt.Println(longestValidParentheses("()(()"));
	fmt.Println(longestValidParentheses("(()((((()"));
	fmt.Println(longestValidParentheses(")(())))(())())"));
	fmt.Println(longestValidParentheses("()(()()"));
	fmt.Println(longestValidParentheses("()(())"));
	fmt.Println(longestValidParentheses(""));
	fmt.Println(longestValidParentheses("("));

}
