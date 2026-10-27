from functools import reduce

salaries = [35000, 45000, 38000, 55000, 39000, 42000]

eligible_salaries = list(filter(lambda s: s < 40000, salaries))
print("b) Salaries eligible for increment:", eligible_salaries)

revised_salaries = list(map(lambda s: int(s * 1.10) if s < 40000 else s, salaries))
print("a) Revised salaries:", revised_salaries)

total_expenditure = reduce(lambda a, b: a + b, revised_salaries)
print("c) Total salary expenditure after revision: ₹", total_expenditure)