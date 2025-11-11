class Solution:
    def isValid(self, s: str) -> bool:
        open_brackets = ['(', '[', '{']
        comp = {')':'(', ']':'[', '}':'{'}

        stack = []
        for i in s:
            if(len(stack) == 0):
                if(i in open_brackets):
                    stack.append(i)
                    continue
                else:
                    return False
            if(i in open_brackets):
                stack.append(i)
            elif(stack[-1] == comp[i]):
                stack.pop()
            else:
                return False

        return (len(stack) == 0)

