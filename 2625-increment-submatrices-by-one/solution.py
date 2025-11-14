class Solution:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        ans = [[0]*n for _ in range(n)]
        for temp in queries:
            x1 = temp[0]
            y1 = temp[1]
            x2 = temp[2]
            y2 = temp[3]
            ans[x1][y1] += 1
            
            if(x2 != n-1 and y2 != n-1):
                ans[x1][y2+1] -= 1
                ans[x2+1][y1] -= 1
                ans[x2+1][y2+1] += 1
            elif(x2 != n-1 and y2 == n-1):
                ans[x2+1][y1] -= 1
            elif(x2 == n-1 and y2 != n-1):
                ans[x1][y2+1] -= 1
        
        for i in range(n):
            for j in range(n):
                if(i == 0 and j == 0):
                    continue
                elif(i != 0 and j != 0):
                    ans[i][j] += ans[i-1][j] + ans[i][j-1] - ans[i-1][j-1]
                elif(i == 0 and j != 0):
                    ans[i][j] = ans[i][j-1] + ans[i][j]
                elif(i != 0 and j == 0):
                    ans[i][j] = ans[i][j] + ans[i-1][j]
        
        return ans

                
