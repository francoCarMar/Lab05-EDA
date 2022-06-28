import java.util.*;
public class Test{
  public static void main(String[] args) {
    try {
      //dadas n cadenas de corchetes 
      String [] strs = {"{[()]}", "" , null, "(" , "[[]", "{{}", "{{" ,"{{}}", "{}","[]","()","{}}}}","[]]]" ,"}}"};
      // denermino si la secuencia de corches esta balanceada
      System.out.println("Balance de n cadenas de corchetes\n" + isBalancedMultiple(strs));
      System.out.println("Balance de una cadena de corchetes => {[()]}: " + isBalanced("{[()]}"));
      System.out.println("Balance de una cadena de corchetes => {[(]]}: " + isBalanced("{[(]]}"));
   } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  public static boolean isNegative(Character c){
    return c == ')' || c == '}' || c == ']';
  }

  public static boolean arePairs(Character a, Character b){
    return (a == '{' && b =='}') || (a == '[' && b ==']') || (a == '(' && b ==')');
  }

  public static String isBalanced(String s) throws ExceptionIsEmpty{
    if(s == null || s.isEmpty() || s.length()%2 == 1) return "NO";
    StackLink<Character> stack = new StackLink<>();
    int i = 0;
    while(i < s.length() && !isNegative(s.charAt(i)))
      stack.push(s.charAt(i++));
    while(i < s.length() && !stack.isEmpty() && arePairs(stack.top(), s.charAt(i++)))
      stack.pop();
    if(stack.isEmpty() && i == s.length()) return "SI";
    return "NO";
  }

  public static String isBalancedMultiple(String [] strs) throws ExceptionIsEmpty{
    String str = "";
    for (String i: strs) {
      str  += i + ": " + isBalanced(i) + "\n"; 
    }
    return str;
  }
}
