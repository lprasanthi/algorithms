import java.util.ArrayList;
import java.util.HashMap;

class AmountDenom{
	public int amount;
	public int index;
	public AmountDenom(int amount,int index){
		this.amount=amount;
		this.index=index;
	}
}
public class representCents{
    public static int getPossibleDenominations(int[] set, int amount, int count,int index){
        if(index >= set.length-1){
            return 1;
        }
        System.out.println("index-->"+index+",set-->"+set[index]+",amount-->"+amount+",count-->"+count);
        count=0;
        for(int i=0;i*set[index]<amount;i++){
            int amountRemaining=amount - i*set[index];
            System.out.println("i-->"+i+"amountRemaining-->"+amountRemaining);
            count= count+getPossibleDenominations(set, amountRemaining, count, index+1);
        }
        return count;
    }
    private static int makeChange(int total, int denom) {
    	int nextCoin = 0;
    	switch (denom) {
    	case 25:
    		nextCoin = 10;
    		break;
    	case 10:
    		nextCoin = 5;
    		break;
    	case 5:
    		nextCoin = 1;
    		break;
    	case 1:
    		return 1; // Found a combination.Base case.
    	default:
    		return 0;
    	}
    	
    	int ways = 0;
    	for (int count = 0; count*denom <= total; ++count) {
    		ways += makeChange(total-count*denom, nextCoin);
    	}
    	return ways;
    }
    
    public static int makeChange(int total) {
    	if (total < 0) return 0;
    	// Select coins with the biggest denomination first.
    	return makeChange(total, 25);
    }
    public static int makeChangeIterative(int total) {
    	int ways = 0;
    	for (int count25 = 0; count25 * 25 <= total; ++count25) {
    		for (int count10 = 0; count10*10 <= total; ++count10) {
    			for (int count5 = 0; count5*5 <=total; ++count5) {
    				int sum = count25*25 + count10*10 + count5*5;
    				// when the first three types of coins are selected, the way of selecting coins
    				// with denomination 1 cent has already known.
    				if (sum <= total) {
    					++ways;
    				}
    			}
    		}
    	}
    	return ways;
	}
	private static int makeChangeRecursive(int total,int[] deno,HashMap<AmountDenom,Integer> map,int index) {
		if(index >= deno.length-1){
			return 1;
		}
		AmountDenom key=new AmountDenom(total, index);
		if(map.containsKey(key)){
			return map.get(key);
		}
		int ways=0;
		int denomination= deno[index];
		for(int i=0;i*denomination<=total;i++){
			int remainingAmount=total-i*denomination;
			AmountDenom keyRem=new AmountDenom(remainingAmount, index+1);
			if(!map.containsKey(keyRem)){
				int subWays=makeChangeRecursive(remainingAmount, deno,map,index+1);
				map.put(keyRem, subWays);
			}
			ways= ways+map.get(keyRem);
		}
		// OR ANOTHER SIMPLIFIED METHOD
		// for(int i=0;i*denomination<=total;i++){
		// 	int remainingAmount=total-i*denomination;
		// 	ways=ways+makeChangeRecursive(remainingAmount, deno, map, index+1);
		// }
		// map.put(key, ways);
    	return ways;
    }
    
    public static int calculate(int value,int[] deno){
        return makeChange(value);
	}
	public static int calculateRecursive(int value,int[] deno){
		HashMap<AmountDenom,Integer> map=new HashMap<AmountDenom,Integer>();
        return makeChangeRecursive(value,deno,map,0);
	}
	
    public static void main(String[] args) {
        int deno[]={25,10,5,1};
		int count = calculate(100,deno);
		int count1= calculateRecursive(100, deno);
        System.out.println("after calculate "+count1);
    }
}