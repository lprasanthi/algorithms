import java.util.ArrayList;
import java.util.List;

//import com.oracle.HttpClientBuilder;
class Accounts{
    int account_id;
    String status;
    String created_on;
    public Accounts(int account_id,String status,String created_on){
        this.account_id=account_id;
        this.status=status;
        this.created_on=created_on;
    }
    public String toString(){
        return "account_id"+account_id;
    }
}

public class invokeRestService{
    public static void main(String[] args) {
        
        // HttpClient client = HttpClientBuilder.getInstance().build();
        // HttpRequest request = client.build("http://interview.wpengine.io/v1/accounts")
        //         .setMethod(HttpMethod.GET)
        //         .build();
        // HttpResponse response = request.invoke();
        // System.out.println(response.getResponseCode());
        List<Accounts> accounts=new ArrayList<Accounts>();
        for(int i=0;i<10;i++){
            accounts.add(new Accounts(i,"good","Jan-28-2019"));
        }
        List<Accounts> newAccounts=new ArrayList<Accounts>();
        accounts.parallelStream().forEach(a->newAccounts.add(a));
        for(int i=0;i<10;i++){
            System.out.println(newAccounts.get(i));
        }
    }
}