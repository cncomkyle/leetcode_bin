package main
import "fmt"
func isValid(s string) bool {
	if len(s) % 2 == 1 {
		return false
	}

	stackArray := make([]string, len(s)/2)
	lastIndex := -1
	var checkChar string
	for _, tmp := range s[:] {
		tmpChar := string(tmp)

		// fmt.Println(stackArray)
		checkChar = "0"
		switch tmpChar {
		case "{":
			fallthrough
		case "(":
			fallthrough
		case "[":
			if lastIndex + 1 >= len(stackArray) {
				return false
			}
			lastIndex++
			stackArray[lastIndex] = string(tmpChar)
		case "}":
			checkChar = "{"
		case ")":
			checkChar = "("
		case "]":
			checkChar = "["
		}

		if checkChar != "0" {
			if lastIndex < 0 {
				return false
			}
			if stackArray[lastIndex] != checkChar {
				return false
			}
			lastIndex--
		}
	}

	if lastIndex >= 0 {
		return false
	}
	return true
}

func main() {
	fmt.Println(isValid("(("))
	fmt.Println(isValid("()[]{}"))
}
