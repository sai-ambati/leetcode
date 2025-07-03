class Solution:
    def kthCharacter(self, k: int) -> str:
        word = 'a'
        while len(word) <k:
            new_word = ''
            for i in word:
                if i == 'z':
                    ch = 'a'
                else:
                    ch = chr(ord(i) + 1)
                new_word = new_word + ch
            word = word + new_word
        print(word)
        return word[k-1]
        
