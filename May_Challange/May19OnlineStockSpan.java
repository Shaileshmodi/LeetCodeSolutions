class StockSpanner {

    Stack<Integer> spans=new Stack<Integer>();
    
    List<Integer> prices= new ArrayList<>(10000);
    int index=0;
    
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        prices.add(price);
        
       /* if(spans.isEmpty()){
           spans.push(index);
        }*/
        
        while(!spans.isEmpty() && prices.get(spans.peek())<=price){
            spans.pop();
        }
        int result=0;
        if(spans.isEmpty())
            result= index+1;
        else{
            result= index-spans.peek();
        }
        spans.push(index);
        index++;
        return result;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */