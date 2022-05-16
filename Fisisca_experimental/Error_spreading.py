class ErrorSpreading:
    def __init__(self, value: float or int, value_error: float or int):
        self.value = value
        self.value_error = value_error

    def check(self):
        return dict(result=self.value, result_error=self.value_error)

    def sum(self, value2: float or int, value2_error: float or int):
        self.value_error += value2_error
        self.value += value2
        return self.check()

    def subtraction(self, value2: float or int, value2_error: float or int):
        self.value_error += value2_error
        self.value -= value2
        return self.check()

    def multiplication(self, value2: float or int, value2_error: float or int):
        self.value_error = abs(self.value) * value2_error + abs(value2) * self.value_error
        self.value *= value2
        return self.check()

    def division(self, value2: float or int, value2_error: float or int):
        self.value_error = self.multiplication(value2, value2_error)["result_error"] / pow(value2, 2)
        self.value /= value2
        return self.check()

    def pow_by_constant(self, constant: float or int):
        self.value_error *= constant * pow(abs(self.value), (constant - 1))
        self.value **= constant
        return self.check()
    
