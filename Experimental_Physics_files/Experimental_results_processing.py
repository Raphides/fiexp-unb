import math


def avrg(num_ls: list):
    # avrg = average
    return float(sum(num_ls) / len(num_ls))


def stdve(num_ls: list):
    # stdve = standard deviation error.
    var_avrg = avrg(num_ls)
    for num in num_ls:
        ind = num_ls.index(num)
        num = pow(num - var_avrg, 2)
        num_ls[ind] = num
    return math.sqrt(sum(num_ls) / (len(num_ls) * (len(num_ls) - 1)))


def systematic_error(precision: float or int, electronic_measurement: bool):
    if electronic_measurement is False:
        return precision / 2
    elif electronic_measurement is True:
        return precision


def experimental_error(num_ls: list, precision: float or int, electronic_measurement: bool):
    return stdve(num_ls) + systematic_error(precision, electronic_measurement)


def experimental_result(num_ls: list, precision: float or int, electronic_measurement: bool):
    avrg_var, exp_error = float(avrg(num_ls)), experimental_error(num_ls, precision, electronic_measurement)
    signif_digit_pos = 0
    for digit in str(exp_error):
        if digit != "0" and digit != ".":
            if exp_error < 1:
                exp_error = round(exp_error, signif_digit_pos - 1)
                avrg_var = round(avrg_var, signif_digit_pos - 1)
                break
            elif exp_error >= 1:
                decimal_places = -1 * (str(exp_error).index("."))
                exp_error = round(exp_error * pow(10, decimal_places), 1)
                exp_error *= pow(10, abs(decimal_places))
                avrg_var = round(avrg_var * pow(10, decimal_places), 1)
                avrg_var *= pow(10, abs(decimal_places))
                break
        signif_digit_pos += 1
    return dict(result=avrg_var, result_error=exp_error)
