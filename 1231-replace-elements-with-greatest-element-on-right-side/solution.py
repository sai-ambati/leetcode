class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        n = len(arr)
        temp = [0]*n
        temp[n-1] = -1
        for i in range(n-2, -1, -1) :
            temp[i] = max(temp[i+1], arr[i+1])
        return temp
