public class primeCount{
    public static int countPrimes(int n){
        boolean[] primes= new boolean[n+1];
        int count=0;
        for(int i=0;i<n;i++){
            primes[i]=false;
        }
        for(int i=2;i<n;i++){
            if(primes[i] == false){
                count++;
                System.out.println(i);
            }
                
            for(int j=2;i*j<=n;j++){
                primes[i*j]=true;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPrimes(50));
    }
}