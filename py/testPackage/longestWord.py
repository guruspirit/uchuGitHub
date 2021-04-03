txt = input()

#your code goes here

splittedText = txt.split()
maxLen = 0
word =""
for s in splittedText:
    if len(s)>maxLen:
        maxLen=len(s)
        word=s
print(word)