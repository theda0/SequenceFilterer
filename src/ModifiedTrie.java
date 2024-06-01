import java.util.ArrayList;
import java.util.List;

public class ModifiedTrie {

    private WordNode sentinel = new WordNode('A');

    private int length; //The total number of unique sequences entered
    public ModifiedTrie(List<String> lines){
        this.length = 0;
        for(String x : lines){
            this.addString(x);
        }
    }

    //Add the given string to our modified trie
    public void addString(String string){
        if (string.isEmpty()){
            throw new IllegalArgumentException("String must not be empty");
        }
        WordNode tracker = sentinel;

        //Iterate over everything but the last character of the string
        for(int i  = 0; i < string.length()-1; ++i){

            char letter = string.charAt(i);
            WordNode potentialNextNode = tracker.getBranches().get(letter);
            //If the next character is not in the trie yet
            if (potentialNextNode == null){
                WordNode node = new WordNode(letter);
                tracker.attachNode(node);
                tracker = node;
            } else {
                tracker = potentialNextNode;
            }
        }

        //Now we look at the cae of the final letter
        char letter = string.charAt(string.length() - 1);
        WordNode potentialNextNode = tracker.getBranches().get(letter);

        if (potentialNextNode == null){
            WordNode node = new WordNode(letter, true);
            tracker.getBranches().put(letter, node);
            this.length += 1; //Another unique string has been given
        } else {
            if (potentialNextNode.isEnd()){
                potentialNextNode.increase();
            } else{
                potentialNextNode.changeToEnd();
                this.length += 1; //Another unique substring of a give string has been given
            }
        }

    }

    public List<String> modifiedList(){
        List<String> returnList = new ArrayList<>();

        return returnList;
    }
}
