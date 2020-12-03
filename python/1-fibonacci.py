# number of even number to be added
even_numbers = 100
# variables for calculating fib numbers
number1, number2 = 0, 1
count = 0
sum_of_even = 0
# run the loop while we reach the desired fibonacci even number
while count < even_numbers:
  # check if the next fibonacci number is even
  if number2 % 2 == 0:
    # add the even fibonacci to total
    sum_of_even += number2
    count += 1
  # calculate the next fibonacci number
  next_number = number1 + number2
  number1 = number2
  number2 = next_number

print("The sum of " + str(even_numbers)+" even fibonacci numbers is "+ str(sum_of_even))