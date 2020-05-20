901. Online Stock Span

class StockSpanner {
    Stack<int[]> stack;
    
    public StockSpanner() {
        this.stack = new Stack<>();    
    }
    
    public int next(int price) {
        int res = 1;
        
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            res += stack.pop()[1];
        }
        stack.push(new int[]{price, res});
        
        return res;
    }
}
