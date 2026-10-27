from functools import reduce

consumption = [8, 12, 15, 9, 11, 7, 14, 18]

high_consumption_days = list(filter(lambda x: x > 10, consumption))
print("a) Days with consumption > 10 units:", high_consumption_days)

daily_costs = list(map(lambda x: x * 6, consumption))
print("b) Daily electricity costs (₹):", daily_costs)

total_consumption = reduce(lambda a, b: a + b, consumption)
print("c) Total electricity consumption (units):", total_consumption)

def calculate_bill(data, rate=6):
    return sum(map(lambda units: units * rate, data))

print("d) Total Electricity Bill: ₹", calculate_bill(consumption))