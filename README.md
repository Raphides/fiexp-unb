# **Experimental_physics_1_tools**
These are some tools I made to check my answers on Experimental Physics 1's homeworks. I hope this can help others too.


**Experimental_results_processing.py** is a .py file with many functions available to help you measure the following concepts: average, standard error, instrumental error, experimental error and the whole result on a experimental formatting. Therefore, **Error_spreading.py** has the ErrorSpreading class, with methods capable of measuring sum, subtraction, multiplication, division and powering between experimental results.





## **Physical Experimental concepts and functions**
### Simple Arithmetic Average:
It is the sum of all measures taken, divided by the quantity of measures inserted. On Experimental Physics, these averages also represent the "best value" on experimental results. There is a function `avrg(num_ls)` in Experimental_results_processing.py that calculates the average of a sequence of numbers, requiring the user to insert them on `num_ls` parameter, into a list type.


### Standard Error:
Describes the random error related with the experiment. Calculated by dividing the standard deviation by the square root of the average, standard error has its own function: `stdve(num_ls)`, requiring the same as Average, the values found on the many tries of the experiment on a list as the parameter.


### Systematic Error:
Represents the human erros during the experiment. To use its function `systematic_error(precision, electronic_measurement)`, the user has to insert the minimal value possible on the measurement tool (e.g systematic error of a common ruler is 0.1 cm), as known as intrumental precision, and a bool saying if the tool used to measure is electronic or not (analog).

### Experimental Error:
Standard Error/Random Error + Systematic Error. It is the total error related to the experiment and it is the error represented on experiment results.

### Experimental Results:
Represented by *Average +/- Experimental Error*, it is the value used to estimate results made on experiments. As erros could have dozens of digits, it is made an rounding with the significant error digit as the reference. This function returns a dictionary `dict(result=bestx, result_error=exp_error)`
Note: Significant error is the first digit of a number different from zero.




## Operations with experimental results
- Sum and Subtraction: z = x ± y =⇒ δz = δx + δy
- Multiplication: z = xy =⇒ δz = |y| . δx + |x| . δy
- Division: z = x y =⇒ δz = (|y|. δx + |x| . δy)/ y^2
- Powering: z = x^m =⇒ δz = δx . m . |x|^m−1

To execute these operations, you have to create an object from `ErrorSpreading()`class, with the first experimental result: `value` and `value_error` as parameters and access the methods with it. An example: 

```
result1 = ErrorSpreading(19.527, 0.003)
result1.multiplication(3.53039, 0.0008)
```

All `ErrorSpreading()` methods need a second experimental result (`value2` and `value2_error`) as parameters and return a dictionary: `dict(result=self.value, result_error=self.value_error)`


## Keywords:
- `avrg(num_ls : list)` returns a number.
- `stdve(num_ls : list)` returns a number.
- `systematic_error(precision: float or int, electronic_measurement: bool)` returns a number.
- `experimental_error(num_ls: list, precision: float or int, electronic_measurement: bool)` returns a number.
- `experimental_result(num_ls: list, precision: float or int, electronic_measurement: bool)` returns a dictionary.
- `ErrorSpreading(value: float or int, value_error: float or int)` class
  - `ErrorSpreading(...).check()` returns a dict.
  - `ErrorSpreading(...).sum(self, value2: float or int, value2_error: float or int)` returns a dict.
  - `ErrorSpreading(...).subtraction(self, value2: float or int, value2_error: float or int)` returns a dict.
  - `ErrorSpreading(...).multiplication(self, value2: float or int, value2_error: float or int)` returns a dict.
  - `ErrorSpreading(...).division(self, value2: float or int, value2_error: float or int)` returns a dict.
  - `ErrorSpreading(...).pow_by_constant(self, constant: float or int)` returns a dict.


