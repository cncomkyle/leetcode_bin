package main

import (
	"fmt"
)

func numJewelsInStones(J string, S string) int {
    result := 0
	var upperFlag, lowerFlag uint32

	for _, tmpChar := range J[:] {
		if tmpChar >= 'a' && tmpChar <= 'z' {
			lowerFlag = lowerFlag | (1 << (uint32)(tmpChar - 'a'))
		} else {
			upperFlag = upperFlag | (1 << (uint32)(tmpChar - 'A'))
		} 
	}

	tmpFlg := false
	for _, tmpChar := range S[:] {
		// fmt.Printf("%c\n",tmpChar)
		tmpFlg = false

		if tmpChar >= 'a' && tmpChar <='z' {
			tmpFlg = (lowerFlag & (1 << (uint32)(tmpChar - 'a'))) > 0
		} else if tmpChar >= 'A' && tmpChar <= 'Z' {
			tmpFlg = (upperFlag & (1 << (uint32)(tmpChar - 'A'))) > 0
		}

		if tmpFlg {
			result++
		}
	}

	return result
}

func main() {
	fmt.Println(numJewelsInStones("aA", "aAAbbbb"))
}

