import java.util.ArrayList;

public class Subject {
    String name;
    String region;
    String placement;
    public ArrayList<String> goal;
    public ArrayList<String> confirmation;

    public Subject(String nm, String rg, String pl){
        name = nm;
        region = rg;
        placement = pl;
        goal = new ArrayList<String>();
        confirmation = new ArrayList<String>();
    }
}
