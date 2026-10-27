from functools import reduce

marks = [45, 80, 52, 98, 35, 60, 49, 95]

passed_students = list(filter(lambda x: x >= 50, marks))
print("a) Students scoring 50+:", passed_students)

updated_marks = list(map(lambda x: min(100, x + 5), marks))
print("b) Marks after graceing (max 100):", updated_marks)

total_marks = reduce(lambda a, b: a + b, marks)
print("c) Total marks:", total_marks)