import java.util.Stack;

class BracketCheck {  

  /**
	 * Main method
	 */
  public static void main(String args[]) {
    System.out.println("This is balanced brackets: " + isBracketsBalanced("{[{()}]}{()}"));
    System.out.println("This is balanced brackets: " + isBracketsBalanced("{[3{(2)}]4}{()5}"));
    System.out.println("This is imbalanced brackets: " + isBracketsBalanced("{{[{()}]}}}{()}"));
  }
  
  /**
   * Checks if the provided string has balanced bracket set
   * @param stringParam - string param containing the bracket expression
   * @return true is provided string contains balanced bracket combination otherwise false 
   */
  public static boolean isBracketsBalanced(String stringParam) {
    Stack<Character> charStack = new Stack<>();
    for (char character : stringParam.toCharArray()) {
      switch (character) {
        // add the closing brackets
        case '{': charStack.push('}'); break;
        case '(': charStack.push(')'); break;
        case '[': charStack.push(']'); break;
        // remove the closing brackets
        case '}':
        case ']':
        case ')':
          // if the stack is empty or the closing bracket is not in stack then passes param is imbalanced
          if (charStack.isEmpty() || character != charStack.peek()) return false;
          charStack.pop();
          break;
      }
    }
    return charStack.isEmpty();
  }
}