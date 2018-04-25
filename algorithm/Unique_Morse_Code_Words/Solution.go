package main
import (
	"fmt"
)

var charMorseArray =[...]string {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}

func getWordNum(word string) uint64 {
	var result uint64 = 1

	for _, tmpChar := range word[:] {
		for _, tmpMorse := range charMorseArray[tmpChar - 'a'][:] {
			result = result <<1
			if tmpMorse == '-' {
				result |= 1
			}
		}
	}
	return result
}

func uniqueMorseRepresentations(words []string) int {
	result := 0
	wordNum := make([]uint64, len(words))
	
	for i, tmpWord := range words[:] {
		wordNum[i] = getWordNum(tmpWord)
	}

	for i:=0;i<len(wordNum);i++ {
		if wordNum[i] == 0 {
			continue
		}
		for j:=i+1;j<len(wordNum);j++ {
			if wordNum[j] == 0 {
				continue
			}
			if wordNum[i] == wordNum[j] {
				wordNum[j] = 0
			}
		}
		result++
	}
	return result
}

func main() {
	var words = []string {"gin", "zen", "gig", "msg"}
	fmt.Println(uniqueMorseRepresentations(words))
}
