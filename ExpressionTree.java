public class ExpressionTree {
  private char op;
  private double value;
  private ExpressionTree left,right;
  public ExpressionTree(double value){
    this.value = value;
    op = '~';
  }
  public ExpressionTree(char op,ExpressionTree l, ExpressionTree r){
    this.op = op;
    left = l;
    right = r;
  }

  public char getOp(){
    return op;
  }

  /* accessor method for Value, precondition is that isValue() is true.*/
  private double getValue(){
    return value;
  }
  /* accessor method for left, precondition is that isOp() is true.*/
  private ExpressionTree getLeft(){
    return left;
  }
  /* accessor method for right, precondition is that isOp() is true.*/
  private ExpressionTree getRight(){
    return right;
  }

  private boolean isOp(){
    return hasChildren();
  }
  private boolean isValue(){
    return !hasChildren();
  }

  private boolean hasChildren(){
    return left != null && right != null;
  }
  public String toString() {
    if (isValue()) return "" + getValue();
    else return "(" + getLeft().toString() + " " + getOp() + getRight().toString() + ")";
  }
  public String toStringPrefix() {
    if (isValue()) return "" + getValue();
    else return getOp() + " " + getLeft().toStringPrefix() + " " + getRight().toStringPrefix();
  }
  public double evaluate() {
    if (isValue()) {
      return getValue();
    }
    else {
      return apply(getOp(), getLeft().evaluate(), getRight().evaluate());
    }
  }
  private double apply(char op, double a, double b) {
    double output = 0;
    if (op == '+') output = a + b;
    if (op == '-') output = a - b;
    if (op == '*') output = a * b;
    if (op == '/') output = a / b;
    if (op == '%') output = a % b;
    return output;
  }
}
