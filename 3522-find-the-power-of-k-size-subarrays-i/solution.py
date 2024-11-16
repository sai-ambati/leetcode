class Solution:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        ans = [0] * (n-k+1)
        for i in range(n-k+1):
            power = nums[i+k-1]
            for j in range(i+1, i+k):
                if(nums[j] != nums[j-1]+1):
                    power = -1
                    break
            ans[i] = power
        return ans
