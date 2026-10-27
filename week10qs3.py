prices = [800, 1500, 2200, 950, 1200, 3000]

def calculate_discount(price):
    if price > 1000:
        return price * 0.80
    return price

expensive_products = list(filter(lambda p: p > 1000, prices))
print("c) Products costing > ₹1,000:", expensive_products)

discounted_prices = list(map(calculate_discount, prices))
print("b) All prices after applying discount rule:", discounted_prices)