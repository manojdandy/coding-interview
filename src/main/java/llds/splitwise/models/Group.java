package llds.splitwise.models;

import java.util.List;

public class Group {
    private final String name;
    private final String imageURL;
    private final String description;
    private final List<String> userList;

    public Group(String name, String imageURL, String description, List<String> userList) {
        this.name = name;
        this.imageURL = imageURL;
        this.description = description;
        this.userList = userList;
    }
}
