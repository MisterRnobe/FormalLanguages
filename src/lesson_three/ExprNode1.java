package lesson_three;

import lesson_two.Token;

public class ExprNode1
{
    public final boolean isNumber; //True for a number, false for an operation
    public final boolean isUnary;
    //Fields for a number
    public final Token number;
    //Fields for an operation
    public final ExprNode1 left;
    public final ExprNode1 right;
    public final Token operation;

    private ExprNode1(boolean isNumber, Token number, ExprNode1 left, ExprNode1 right, Token operation, boolean isUnary) {
        this.isNumber = isNumber;
        this.number = number;
        this.left = left;
        this.right = right;
        this.operation = operation;
        this.isUnary = isUnary;
    }
    public ExprNode1(Token number)
    {
        this(true, number, null, null,null, false);
    }
    public ExprNode1(ExprNode1 left, ExprNode1 right, Token operation)
    {
        this(false, null, left, right, operation, false);
    }
    public ExprNode1(ExprNode1 left, Token operation)
    {
        this(false, null, left, null, operation, true);
    }
    public double compute()
    {
        if (isNumber)
            return Double.parseDouble(number.text);
        else
            return operation.type.compute(left.compute(), isUnary? 0: right.compute());
    }

    @Override
    public String toString() {
        if (isNumber)
            return number.text;
        if (!isUnary)
            return "(" + left.toString()+" "+operation.text+" "+ right.toString() + ")";
        else
            return operation.text+"("+left.toString()+")";
    }
}
