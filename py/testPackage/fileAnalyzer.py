def countChars(text,char):
    count=0
    for ch in text:
        if char==ch:
            count+=1
    return count

fileName = "c:\\temp\\py\\testPackage\\python.txt"

count=0
try:
    with open(fileName,"r") as f:
        text=f.read()
    textLength= len(text)
    print ("                                   Text analyser")
    print ("In file {0} was found {1} symbols summary".format(fileName,textLength))
    for c in "abcdefghijklmnopqrstuvwxyz":
        cnt = countChars(text,c)
        perc = 100*cnt/textLength
        print("{0} - {1} symbols = {2}%".format(c,cnt,round(perc,2)))
finally:
    if not f.closed:
        f.close()