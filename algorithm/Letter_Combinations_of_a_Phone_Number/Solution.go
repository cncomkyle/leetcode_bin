package main

import(
	"fmt"
)

var digitMap = []string{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}

func getStringForDigit(digit string) []string {
	var result []string
	for _, tmp := range digitMap[digit[0] - '2'][:] {
		result = append(result, string(tmp))
	}
	return result	
}

func letterCombinations(digits string) []string {
    var result []string
	if len(digits) == 0 {
		return result
	}

	if len(digits) == 1 {
		return getStringForDigit(digits)
	}
	postResult := letterCombinations(digits[1:])
	preResult := getStringForDigit(string(digits[0:1]))

	for _, tmpPre := range preResult {
		for _, tmpPost := range postResult {
			result = append(result, tmpPre+tmpPost)
		}
	}

	return result
}

func main() {
	testData := "23"
	fmt.Println(letterCombinations(testData))
}
