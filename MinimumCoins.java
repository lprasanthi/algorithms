import java.util.Arrays;

public class MinimumCoins{
    private static int[] items=new int[30];
    private static int index=0;
    private static int coinChangeHelper(int[] coins, int amount) {
        int sum=0;
        if(amount == 0){
            return sum;
        }
        for(int i=coins.length-1;i>=0;i--){
            if(coins[i]<=amount){
                int partialSum=coinChangeHelper(coins, amount-coins[i]);
                if(partialSum >= 0){
                    items[index++]=coins[i];
                    return partialSum+1;
                }
            }
        }
        return -1;
    }
    public static int coinChange(int[] coins, int amount) {
       Arrays.sort(coins);
       int sum=coinChangeHelper(coins, amount); 
       return sum;
    }
    public static void main(String[] args) {
        int coins[]={83,186,408,419};
        System.out.println(coinChange(coins,6249));
    }
}