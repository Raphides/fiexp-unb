import math


def avrg(num_ls: list):
    # avrg = average
    return float(sum(num_ls) / len(num_ls))


def avstdv(num_ls: list):
    # avstdv = average standard deviation
    var_avrg = avrg(num_ls)
    for num in num_ls:
        ind = num_ls.index(num)
        num = pow(num - var_avrg, 2)
        num_ls[ind] = num
    return math.sqrt(sum(num_ls) / (len(num_ls) * (len(num_ls) - 1)))


def instrumental_error(tool_minimal_value: float or int, electronic_measurement: bool):
    if electronic_measurement is False:
        return tool_minimal_value / 2
    elif electronic_measurement is True:
        return tool_minimal_value


def experimental_error(num_ls: list, tool_minimal_value: float or int, electronic_measurement: bool):
    return avstdv(num_ls) + instrumental_error(tool_minimal_value, electronic_measurement)


def experimental_result(num_ls: list, tool_minimal_value: float or int, electronic_measurement: bool):
    bestx, exp_error = float(avrg(num_ls)), experimental_error(num_ls, tool_minimal_value, electronic_measurement)
    signif_digit_pos = 0
    for digit in str(exp_error):
        if digit != "0" and digit != ".":
            if exp_error < 1:
                exp_error = round(exp_error, signif_digit_pos - 1)
                bestx = round(bestx, signif_digit_pos - 1)
                break
            elif exp_error >= 1:
                decimal_places = -1 * (str(exp_error).index("."))
                exp_error = round(exp_error * pow(10, decimal_places), 1)
                exp_error *= pow(10, abs(decimal_places))
                bestx = round(bestx * pow(10, decimal_places), 1)
                bestx *= pow(10, abs(decimal_places))
                break
        signif_digit_pos += 1
    return dict(result=bestx, result_error=exp_error)
