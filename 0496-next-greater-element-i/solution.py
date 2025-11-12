class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n = len(nums2)
        temp = {}
        stk = []
        for i in range(n-1, -1, -1):
            if(len(stk) == 0):
                temp[nums2[i]] = -1
                stk.append(nums2[i])
                continue
            while(len(stk)!= 0 and stk[-1] < nums2[i]):
                stk.pop()
            if(len(stk) == 0):
                temp[nums2[i]] = -1
            else:
                temp[nums2[i]] = stk[-1]
            stk.append(nums2[i])
        for i in range(len(nums1)):
            nums1[i] = temp[nums1[i]]
        return nums1
