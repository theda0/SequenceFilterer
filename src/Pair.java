import java.util.Comparator;

public class Pair implements Comparable<Pair> {
    private Integer first;
    private String second;

    public Pair(int a, String b){
        this.first = a;
        this.second = b;
    }

    public int first(){
        return this.first;
    }

    public String second(){
        return this.second;
    }

    public void modifyString(String s){
        this.second = s;
    }

    @Override
    public int compareTo(Pair other) {
        int firstComparison = this.first.compareTo(other.first);
        if (firstComparison != 0) {
            return firstComparison;
        }
        return this.second.compareTo(other.second);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
