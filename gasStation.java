public class gasStation{
    public static int canCompleteCircuit(int[] gas, int[] cost){
        int start=0,available=0,gasNeeded=0; 
        for(int i=0;i<gas.length;i++){
            available=available+(gas[i]-cost[i]);
            if(available < 0){
                gasNeeded=gasNeeded+available;
                start=i+1;
                available=0;
            }
        }
        return (available + gasNeeded >= 0) ? start : -1;
        // int debt = 0, remain = 0;
        // int start = 0;
        // for (int i = 0; i < gas.length; i++) {
        //     remain += gas[i] - cost[i];
        //     if (remain < 0) {
        //         debt += remain;
        //         start = i + 1;
        //         remain = 0;
        //     }
        // }
        // return remain + debt < 0 ? -1 : start;
    }
    public static void main(String[] args) {
        int gas[]= {1,2,3,4,3,2,4,1,5,3,2,4};
        int cost[]={1,1,1,3,2,4,3,6,7,4,3,1};
        int index=canCompleteCircuit(gas,cost);
        System.out.println(index);
    }
}