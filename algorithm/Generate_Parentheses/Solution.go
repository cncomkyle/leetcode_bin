package main

import (
	"fmt"
)

func genPairs(rltList *[]string, beginCnt int, endCnt int, preStr string, cnt int) {
	if beginCnt == cnt {
		for i:=0;i<cnt - endCnt;i++ {
			preStr = preStr + ")"
		}
		*rltList = append(*rltList, preStr)
		return
	}

	genPairs(rltList, beginCnt + 1, endCnt, preStr + "(", cnt)
	if endCnt != beginCnt {
		genPairs(rltList, beginCnt, endCnt +1, preStr + ")", cnt)
	}
}

func generateParenthesis(n int) []string {
    var rltList []string
	genPairs(&rltList, 1, 0, "(", n)
	return rltList
}


func main() {
	rltList := generateParenthesis(3)

	for _, tmpStr := range rltList {
		fmt.Println(tmpStr)
	}
}
