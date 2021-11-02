import java.lang.*;
import java.util.*;

public class ComputePostfixFormula 
{
  /*
   * Method for processing a postfix boolean formula. See assignment description for an overview for how to evaluate a postfix formula.
   */
  public static String processPostfixBooleanFormula( Queue<String> symbolQueue ) throws IllegalArgumentException
  {
    Stack<String> postFix = new Stack<>();  
    Boolean a, b;
    String str;
    while (symbolQueue.peek() != null) {
        try {
            switch (symbolQueue.poll()) {
                case "true":
                    postFix.push("true");
                     break;
                case "false":
                    postFix.push("false");
                    break;
                case "NOT":
                    a = !Boolean.valueOf(postFix.pop());
                    str = String.valueOf(a);
                    postFix.push(str);
                    break;
                case "AND":
                    b = Boolean.valueOf(postFix.pop());
                    a = Boolean.valueOf(postFix.pop());
                    str = String.valueOf(a && b);
                    postFix.push(str);
                    break;
                case "NAND":
                    b = Boolean.valueOf(postFix.pop());
                    a = Boolean.valueOf(postFix.pop());
                    str = String.valueOf(!(a && b));
                    postFix.push(str);
                    break;
                case "OR":
                    b = Boolean.valueOf(postFix.pop());
                    a = Boolean.valueOf(postFix.pop());
                    str = String.valueOf(a || b);
                    postFix.push(str);
                    break;
                case "NOR":
                    b = Boolean.valueOf(postFix.pop());
                    a = Boolean.valueOf(postFix.pop());
                    str = String.valueOf(!(a || b));
                    postFix.push(str);
                    break;
                case "XOR":
                    b = Boolean.valueOf(postFix.pop());
                    a = Boolean.valueOf(postFix.pop());
                    str = String.valueOf(a != b);
                    postFix.push(str);
                    break;
                case "COND":
                    b = Boolean.valueOf(postFix.pop());
                    a = Boolean.valueOf(postFix.pop());
                    str = String.valueOf(!a || b);
                    postFix.push(str);
                    break;
                case "BICOND":
                    b = Boolean.valueOf(postFix.pop());
                    a = Boolean.valueOf(postFix.pop());
                    str = String.valueOf(a == b);
                    postFix.push(str);
                    break;
                }
            }
            catch (Exception EmptyStackException) {
                return("error");
            }
    }
    /* Use the following to throw an exception when the postfix string is formatted incorrectly */
    String postReturn = "error";
    if(postFix.empty()) {
        throw new IllegalArgumentException( "Postfix String is formatted incorrectly" );
    }
    else {
        postReturn = postFix.pop();
        if(!(postFix.empty())) {
            return("error");
        }
    }
    return(postReturn);
    
    /* Return the top element of the stack after processing the postfix string */
    //return "";
  }
 
}
