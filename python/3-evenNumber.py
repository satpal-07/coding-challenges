def is_number_even(number):
  string_number = str(number)
  for i in range(len(string_number)):
    # return false if we found the number is not even, including 0
    if int(string_number[i]) % 2 != 0 or int(string_number[i]) == 0:
      return False
  # if none of the decimal digit is odd then all the nums are even and we return true
  return True

print("This should return true as 2468 contains all even digits: " + str(is_number_even(2468)))

print("This should return false as 12468 contains 1 and its odd digit: " + str(is_number_even(12468)))