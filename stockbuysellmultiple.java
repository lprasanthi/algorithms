public class stockbuysellmultiple{
    public static int getMostProfit(int[] prices){
        if(prices.length <= 1)
            return 0;
        int profit=0;    
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit=profit+(prices[i]-prices[i-1]);
            }
        }
        return profit;    
    }
    public static void main(String[] args) {
        int arr[]={7,3,4,2,8,16};
    }
}