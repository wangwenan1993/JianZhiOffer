import java.util.Stack;

/**
 * @Author wangwenan
 * @data 2018/8/15 10:10
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class _20_RealizeStackWithO1MinMethod {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        if (stack2.empty()) {
            stack2.push(node);
        } else if (node < stack2.peek()){
            stack2.push(node);
        }
    }

    public void pop() {
        if(stack1.peek() == stack2.peek()) {
            stack2.pop();
        }
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
