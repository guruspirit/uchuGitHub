words = ["A", "B", "C"]
print("A" in words)
words.insert(1, "0") #вставить элемент вместо 1го элемента со сдвигом вправо
print(words)
print(words.index("B")) #returns 2 in list [A,0,B,C]
print(max(words)) #returnd C
print(min(words)) #return 0
print(words.count("0")) #возвращает количество элементов "0" в списке words


