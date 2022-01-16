import java.util.*;

public class User {

    public User(String name,String type) {
        this.name = name;
        this.type = type;
        this.predefinedNum = 0;
    }

    public User(String name,String type,int predefinedNum) {
        this.name = name;
        this.type = type;
        this.predefinedNum = predefinedNum;
    }

    private String name;

    private String type;

    private int predefinedNum;

    public String getType() {
        return type;
    }
}