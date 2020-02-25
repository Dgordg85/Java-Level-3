package Lesson_08;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private int id;
    private int parentId;
    private List<Tree> children;

    public Tree(int id, int parentId) {
        this.id = id;
        this.parentId = parentId;
        children = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addChild(int id, int parentId){
        children.add(new Tree(id, parentId));
    }

    public boolean hasChildren(){
        return children.size() > 0;
    }

    public List<Tree> getChildrenList() {
        return children;
    }
}
