def get_intersection_numbers(array1, array2):
  # convert the array to set so its easily accessible with 0(1) complexity
  first_set = set(array1)
  second_set = set(array2)
  # now we create the intersection of two sets and return an array
  return set_intersection(first_set, second_set)

def set_intersection(first_set, second_set):
  # check if value in first is in second and add it to the array
  return [x for x in first_set if x in second_set]


print("The intersection numbers are: " + str(set_intersection([1,2,3,4], [3,4,5])))