class TrieNode{
    public char val;
    public TrieNode[] children=new TrieNode[28];
    public boolean isWord;
    public TrieNode(char val){
        this.val=val;
        this.isWord=false;
        for(int i=0;i<26;i++){
            children[i]=null;
        }
    }
}
class Trie {
    public TrieNode root;

    public Trie() {
        root=new TrieNode(' ');
    }
    
    public void insert(String word) {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            int index=c-'a';
            //TrieNode temp=cur.children[index];
            if(cur.children[index] == null){
                TrieNode temp=new TrieNode(c);
                cur.children[index] = temp;
            }
            cur=cur.children[index];
        }
        cur.isWord=true;
    }
    
    public boolean search(String word) {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            int index=c-'a';
            if(cur.children[index] == null)
                return false;
            cur=cur.children[index];
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur=root;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            int index=c-'a';
            if(cur.children[index] == null)
                return false;
            cur=cur.children[index];
        }
        return true;
    }
}

public class TrieImplementation{
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
        obj.insert("app");
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
    }
}