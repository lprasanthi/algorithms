public class stockbuysellonce{
    public static int getMostProfit(int[] stocks){
        if(stocks.length <= 1)
            return 0;
        int buy=stocks[0]; 
        int profit=0;
        for(int i=0;i<stocks.length;i++){
            if(stocks[i] < buy){
                buy= stocks[i];
            }else{
                profit=Math.max(profit,stocks[i]-buy);
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        int arr[]={7,3,8,1,4,9,1,11};
        System.out.println(getMostProfit(arr));
    }
}