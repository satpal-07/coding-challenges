def decimal_digit_sum(number):
  # this will hold the total
  total = 0
  # this will hold the decimal digit values
  incremented_decimal = number
  """ this is responsible for adding the digit to a specified decimal places
  i.e. value is 4 so passed number is 3 so this function will return sum of 3+33+333+3333
  """
  decimal_places = 4
  # we loop through to generate the total of specified decimal places
  for _ in range(decimal_places):
    total += incremented_decimal
    incremented_decimal = incremented_decimal * 10 + number
  return total

print("The sum of 3 when added like 3+33+333+3333 is: " + str(decimal_digit_sum(3)))
print("The sum of 5 when added like 5+55+555+5555 is: " + str(decimal_digit_sum(5)))