class Solution:
    def secondsBetweenTimes(self, startTime: str, endTime: str) -> int:
        h1, m1, s1 = map(int, startTime.split(":"))
        h2, m2, s2 = map(int, endTime.split(":"))

        return ((h2-h1) * 60 + (m2-m1))*60 + s2-s1
        
