"""
Синтаксис команд
"""
5 // 2  # деление без остатка
print("\t\"\n")  # спецсимволы и знаки переноса
print(""" многострочный
текст""")
print("con" + "cate" + "nation")  # сложение слов
print("spam" * 3)  # spamspamspam
print(2 * "A")  # АА
user = "James"  # variable переменная
A_name_ofVariable = 0  # имя переменной
x = input()  # ввод текста
x = input("Введите имя")  # сообщение перед вводом текста
age = int(input("Введите свой возраст"))  # string to int
age += 1  # in-place operation
print(2 == 3)  # False
print(2 != 3)  # True
print(1 > 1.0)  # False
print("Annie" > 'Andy')
spisok = ["s1", "s2"]  # создание списка
print(spisok[1])  # вызов элемента списка
# 25. операции со списками
[1, 2, 3] + [4, 5, 6] == [1, 2, 3, 4, 5, 6]
# проверить наличие элемента в списке
words = ["A", "B", "C"]
print("A" in words)
print(not "X" in words)
# 26. Функции списков
words.append(4)
words.extend('67')
len(words)
print(words)
words.insert(1, "8")  # вставить элемент вместо 1го элемента со сдвигом вправо
print(words.index("B"))
list.remove(2)
words.reverse()
for word in words:
    print(word)
# Когда число итераций зафиксировано, логичнее использовать for

# 29. Range
n1 = list(range(10))  # 0..9
n2 = list(range(3, 10))  # 3..9
n3 = list(range(3, 10, 2))  # 3..9 с шагом 2
n4 = list(range(10, 3, -2))  # 10..2 с шагом -2
list1 = [1, 2, 3]
for car in list1:
    print(car)


# 32.функции
# Don’t Repeat Yourself
# параметры - это переменные в теле функции, а аргументы - значения, присваиваемые параметрам при вызове функции.
# 35. Возврат из функций
# 36. Документация и комментарии #""""тут""
# 37. Функции как объекты

def funx():
    return 5


x = funx()


# пример функционального программирования
def add(x, y):
    return x + y


def do_twice(func, x, y):
    return func(func(x, y), func(x, y))


a = 5
b = 10
print(do_twice(add, a, b))

# 38.модули
# Import random
# Random.randint(1,6) случайные числа в диапазоне от 1 до 6
# From math import pi,sqrt

# 39. Модули
# 1. Модули, написанные мной
# 2. Взятые из внешних источников pypi, python package index. Приложение  Pip для установки библиотек.
# 3. Встроенные: string, re, datetime, math, random, os, multiprocessing, subprocess, socket, em, json, doctest, unittest, pdf, argparse, sys.

# 40. Исключения
# искл - это ошибка по причине неправильного кода или ввода
# виды исключений: importError, IndexError, NameError, SyntaxError, TypeError, ValueError.
try:
    print(1 / 0)
except ZeroDivisionError:
    print("Division by zero")
except (ValueError, TypeError):
    print("Value or Type error")
except:
    print("Перехват всех остальных исключений")
finally:
    print("This code will run no matter what")

#45 Вызов исключений
print(1)
raise ZeroDivisionError
#or
raise NameError("Моё описание исключения")

#46 Утверждения
# это проверка правильности кода, если выражение ложное - вызыва-
# ется исключение.
print(1)
assert 2 + 2 == 4
assert 1 + 1 == 3

temp=-10
assert (temp>=0), "Colder than absolute zero"

#47. Открытий файлов

myfile = open("file.txt","r") # чтение
myfile = open("file.txt","w") # перезапись
myfile = open("file.txt","a") # дописать в конце
myfile = open("file.txt","wb") # двоичный файл
myfile = open("file.txt","r+") # чтение и запись
myfile.close()

#48. Чтение файлов

text = myfile.read()
read5bytes = myfile.read(5)
myfile.read() #повторное чтение вернет пустую строку
  #читаем одну строку и выводим ее содержимое и длину
file = open("python.txt")
line = file.readline().replace("\n","")
print(line)
print(len(line))
file.close()
  #читаем и выводим строки по одной
file = open("python.txt")
for line in file:
    print(line.replace("\n",""))
print(len(line))
file.close()

#49. Запись в файл
49. Запись в файл

Len=File.Write("hello") # len=5

File.close()

#50. Работа с файлами

with open("file.txt") as f: # файл автоматически закроется без close.
    None
#53. None

#Объект указывает на отсутствие значения.
#Функция без return возвращает None

#54. Словари {} - структуры данных для хранения ключей и значений. Если искомого ключа нет, возвращается значение keyError.

ages ={"Dave":5,"Mary":8}
Print(ages["Dave"]) # вызывает keyError
i = "23" not in ages:
i2 = 22 in nums:

ages.get("Dave") # возвращает None

56. Кортежи tuple  отличаются от списков тем, что не могут быть изменены

Kor=(6,7,8,True)

Kor2=1,2,3

57. Срезы - способ получения данных со списка.

srez1[2:4] берёт 2 и 3 элементы

Srez1=kor[:2] [3:] [::2]

[-5:-1] с -5 до -2 включительно

[6::-2])с 6 по 0 включая с шагом 2

[6:0:-2]) с 6 по 1 включая с шагом 2

[-2:-6:-2]) с -2 по -5 с шагом -2

58.  Списковое включение - способ создания списков, которые подчиняются какому-то условию.

[I**3 for I in range(5)]

[i**2 for i in range(10) if i**2 % 2 == 0]

59. Форматирование строк

msg = "Numbers: {0} {1} {2}". format(nums[0], nums[1], nums[2])

"{x}{y}".format(x=5,y=10)

60. Функции обработки строк

Join "-:-".join(x) разделяет список символами

Replace  "Привет".replace("в","В")

StartsWith "hello boys".startsWith("hel") -> true

Endswith "hello".endswith("lol") -> true

Upper "hi".upper() -> HI

Lower "HELLO".lower() -> hello

print("spam, eggs, ham".split(", ")) -> list of

min(2,53,55)

max(1,3,6)

abs(-76)

round(4.5) =4  4.51=5

sum(5,3)

all([a>0 for a in list]) возвращает Boolean

any([a%0==0 for a in list]) возвращает Boolean

nums = [1, 55, 44, 33, 22, 11]

for (a in enumerate(nums))

Print(a)

64. Функциональное программирование

Ключевое понятие - функции высшего порядка . Они принимают другие функции в качестве аргументов или возвращают их как результат.

Цель ФП - использовать чистые функции. Чистые функции не имеют побочных эффектов и возвращают результат, зависящий только от своих аргументов.

Мемоизация - процесс сохранения и поворотного использования результатов функции.

Плюсы чистых функций:

    ...лёгкость тестирования

    ...мемоизация

    ...легко обрабатывается параллельно

Минусы:

...усложняется алгоритм и понимание

    ... усложняется синтаксис

65. Лямбда

При создании функции она привязывается к переменной автоматически. А строки и целые числа создаются в момент выполнения не присваивая им переменные. Аналогично создаются лямбда функции(анонимные)



def myfunc(func, x):

    Return func(x)



myfunc((lambda x: 2*x*x),5)



Print((lambda x: x*x+2*x+5) (-6))



xx=lambda x: x*x+2*x+5

print(xx(6))



66.  Map и Filter



def fabs(x):

    return abs(x)

nums2=[-x*2 for x in range (10)]

print (list(map(fabs,nums2)))



Nums=[1,2,3]

A=list(map(lambda x: x*2,nums))

Предикат это функция которая возвращает логическую переменную.

Filter для фильтрования итерируемого объекта

b=list(filter(lambda x: x>=20, nums))



67. Генераторы не имеют ограничений по памяти и могут выполняться бесконечно.



def countup(x):

    for i in range(10):

        yield round(i*i+i/x,2)

for i in countup (3):

    print (i)



Преобразование генератора в список:

list(countup(10))

+ Ленивая генерация (генерация по требованию) - сниженное потребление памяти.

+ Результатом можно пользоваться до окончания работы функции.



68. Декораторы

Расширяют функции.



def decor(func):

    def rap():

        print("<h1>")

        func()

        print("</h1>")

    return rap



def print_text():

    print("Hello world!")



decorhello = decor (print_text )

decorhello ()

print_text  = decor(print_text)

print_text()



@decor

def print_tex():

    print(5+7)



print_tex();



69. Рекурсия

Саморефлексия- когда функция вызывает саму себя. Базовый случай - когда функция не требует вычислений (вызовов функции).

def fak(x):

    if x==1:

        return 1

    else:

        return x*fak(x-1)

print (fak(5))





70. Множества -  структура данных. В отличие от словаря она не может быть проиндексирована. Не может содержать дубликаты. Проверить их на наличие элемента быстрее, чем список.

Множества применяются для проверки на вхождение и устранение дубликатов.

Способы создания:

M1={1,21,39}

m2=set([5,3,1])

emptySet=set()



add .. добавить новый элемент:

remove.. удаляет значение

pop .. удаляет первое значение



nums = {10, 2, 1, 34, 1, 4, 5, 6}

nums.add(-7)

nums.remove(1)

nums.pop()



Операции над множествами:

first | second - оператор объединения. объединяет множества.

first & second - оператор Перечисления. Возвращает элементы, находящиеся в обоих множествах.

first - second - оператор разности. Возвращает элементы из первого множествах.

first ^ second - оператор симметричной разности. Возвращает элементы, находящиеся в обоих множествах кроме элементов из обоих множества одновременно.



Выбор структуры данных:

Словарь:

- когда требуется установить логическую связь между значением и ключом.

- когда нужно провести быстрый поиск по данным используется ключ.

- когда данные нужно спасибо изменять

Списки:

- когда есть база данных к которой не нужен произвольный доступ. Когда нужно простая, итерируемая часто модифицируемая коллекция.

Множества:

- когда нужны уникальные элементы.

Кортежи:

- когда данные не будут изменяться.

70. Модуль itertool

Count - бесконечный счётчик от заданного значения

from itertools import count

for i in count(1):

    print(i)

    if i >=11:

        break



Cycle - бесконечное число раз перебирает итерируемый объект.



from itertools import cycle

x=[i for i in range(10)]

y=0

for i in cycle(x):

    print(i)

    y+=1

    if y ==100:

        break



Repeat -



from itertools import count,repeat

x=list(repeat('lp',100))

print (x)



Takewhile

Возвращает элементы из итерируемые го объекта которые удовлетворяют предикатной функции



Accumulate - возвращает сумму значений внутри  итерируемого объекта





from itertools import accumulate, takewhile



nums = list(accumulate(range(8)))

print(nums)

print(list(takewhile(lambda x: x<= 6, nums)))



Chain -объединяет несколько итерируемых объектов в один



from itertools import accumulate, chain

x=list(range(9))

y=list(range(8,13))

z=chain(x,y,x)

for i in z:

    print (i)



Permutations перебираются все комбинации множества.

Product . Перебираются комбинации каждого элемент множества a с каждым элементом множества b.

Используется , Когда нужно выполнить задачу со всеми возможными комбинациями некоторых элементов.





letters = ("A", "B","X")

print(list(product(letters, range(3))))

print(list(permutations(letters)))

74. Классы

Парадигмы программирования:

Императивная - использование инструкции циклов функций в качестве подпрограмм.

Функциональная парадигма-использование чистых функций, функции высшего порядка и рекурсии в качестве подпрограмм.

Парадигма ооп -объекты создаются с помощью классов.



class Dog:

    def __init__(self, name, color):

        self.name = name

        self.color = color



    def bark(self):

        print("Woof!")



fido = Dog("Fido", "brown")

print(fido.name)

fido.bark()



75. Наследование включает понятия суперкласс и подкласс.



class Wolf:

    def __init__(self, name, color):

        self.name = name

        self.color = color



    def bark(self):

        print("Grr...")



class Dog(Wolf):

    def bark(self):

        print("Woof")



husky = Dog("Max", "grey")

husky.bark()



Суперкласс

class A:

    def spam(self):

        print(1)



class B(A):

    def spam(self):

        print(2)

        super().spam()



B().spam()



76. Магические методы и переопределение операторов.

Это операторы с __а__, применяемые для переопределения методов.

Метод __add__ позволяет определить проведение для +.

class Vector2D:

    def __init__(self, x, y):

        self.x = x

        self.y = y

    def __add__(self, other):

        return Vector2D(self.x + other.x, self.y + other.y)



first = Vector2D(5, 7)

second = Vector2D(3, 9)

result = first + second

print(result.x)

print(result.y)



__add__ x.__add__(x)

__sub__ -

__mul__ *

__truedev__ /

__floordev__ //

__mod__ %

__pow__ **

__or__ |

__xor__ ^

__and__ &



class SpecialString:

    def __init__(self, cont):

        self.cont = cont



    def __truediv__(self, other):

        line = "=" * len(other.cont)

        return "\n".join([self.cont, line, other.cont])



spam = SpecialString("spam")

hello = SpecialString("Hello world!")

print(spam / hello)

print (hello / spam)



class SpecialString:

    def __init__(self, cont):

        self.cont = cont



    def __gt__(self, other):

        for index in range(len(other.cont)+1):

            result = other.cont[:index] + ">" + self.cont

            result += ">" + other.cont[index:]

            print(result)



spam = SpecialString("spam")

eggs = SpecialString("eggs")

spam > eggs



import random



class VagueList:

    def __init__(self, cont):

        self.cont = cont



    def __getitem__(self, index):

        return self.cont[index + random.randint(-1, 1)]



    def __len__(self):

        return random.randint(0, len(self.cont)*2)



vague_list = VagueList(["A", "B", "C", "D", "E"])

print(len(vague_list))

print(len(vague_list))

print(vague_list[2])

print(vague_list[2])



Другие методы, которые задают функциональность контейнерам:

__len__

__setitem__

__getitem__

__delitem__

__iter__

__contains__ для in



77. Жизненный цикл объекта

Создание, использование, уничтожение



Первый этап жц объекта- определение класса к которому он принадлежит, Инстанцирование, вызов __init__, выделение памяти.

Использование: вызов методов и использование атрибутов. Удаление экземпляра класса.

Объект уничтожается когда количество ссылок на него становится равным 0.



78. Сокрытие данных



Инкапсуляция - упаковка связанных переменных и функций в один объект(экземпляр класса).

Частный метод - который не рекомендуется использовать с остальной частью программы.

Частные методы оформляются так _hiddenlist



class Queue:

    def __init__(self, contents):

        self._hiddenlist = list(contents)



    def push(self, value):

        self._hiddenlist.insert(0, value)



    def pop(self):

        return self._hiddenlist.pop(-1)



    def __repr__(self):

        return "Queue({})".format(self._hiddenlist)



queue = Queue([1, 2, 3])

print(queue)

queue.push(0)

print(queue)

queue.pop()

print(queue)

print(queue._hiddenlist)



Строго частные методы



class Spam:

    __egg = 7

    def print_egg(self):

        print(self.__egg)



s = Spam()

s.print_egg()

print(s._Spam__egg)

print(s.__egg)



79. Методы класса и статические методов



New_square - метод класса, вызывается для класса. Вызывается для класса, а не для экземпляра класса. Возвращает новый объект.



class Rectangle:

    def __init__(self, width, height):

        self.width = width

        self.height = height



    def calculate_area(self):

        return self.width * self.height



    @classmethod

    def new_square(cls, side_length):

        return cls(side_length, side_length)



square = Rectangle.new_square(5)

print(square.calculate_area())



Статические методов не берут дополнительных аргументов (self, cls). Оформляются декоратором @staticmethod



class Pizza:

    def __init__(self, toppings):

        self.toppings = toppings



    @staticmethod

    def validate_topping(topping):

        if topping == "pineapple":

            raise ValueError("No pineapples!")

        else:

            return True



ingredients = ["cheese", "onions", "pineapple"]

if all(Pizza.validate_topping(i) for i in ingredients):

    pizza = Pizza(ingredients)



80. Свойства



Можем настроить доступ к атрибутами экземпляра класса.  Перед методом помещается оператор @property







class Pizza:

    def __init__(self, toppings):

        self.toppings = toppings



    @property

    def pineapple_allowed(self):

        return False



pizza = Pizza(["cheese", "tomato"])

print(pizza.pineapple_allowed)

pizza.pineapple_allowed = True



Свойства можно задать с помощью getter/setter



class Pizza:

    def __init__(self, toppings):

        self.toppings = toppings

        self._pineapple_allowed = False



    @property

    def pineapple_allowed(self):

        return self._pineapple_allowed



    @pineapple_allowed.setter

    def pineapple_allowed(self, value):

        if value:

            password = input("Enter the password: ")

            if password == "Sw0rdf1sh!":

                self._pineapple_allowed = value

            else:

                raise ValueError("Alert! Intruder!")



pizza = Pizza(["cheese", "tomato"])

print(pizza.pineapple_allowed)

pizza.pineapple_allowed = True

print(pizza.pineapple_allowed)



60. Простая игра



def get_input():

    command = input(": ").split()

    verb_word = command[0]

    if verb_word in verb_dict:

        verb = verb_dict[verb_word]

    else:

        print("Unknown verb {}". format(verb_word))

        return



    if len(command) >= 2:

        noun_word = command[1]

        print (verb(noun_word))

    else:

        print(verb())



def say(noun):

    return 'You said "{}"'.format(noun)



verb_dict = {

    "say": say,

}



while True:

    get_input()



84. Регулярные выражения



Представляют собой предметно-ориннтированный язык и доступны как библиотека в большинстве яп.

Используются, чтобы определить соответствует ли строка определенному набору символов






for char in "abcdefghijklmnopqrstuvwxyz":  # поиск символа в наборе символов
    print(char)
ages = {"Dave": 50, "Eva": 20, "Stas": 30}
print(ages["Dave"])
50 in ages  # -- True or False
ages.get("Dave")  # -- gets 50



print((lambda x, y: x * y)(2, 3))  # lambda function
xy = lambda x: x * 2
print(xy(10))


# map - карта функций принимает функцию и итерацию и возвращает
# новую итерацию примененную к каждому аргументу.
def add_five(x):
    return x + 5


nums = [11, 22, 33, 44, 55]
result = list(map(add_five, nums))
print(result)
# легче
result2 = list(map((lambda x: x + 5), (nums)))
print(result2)

