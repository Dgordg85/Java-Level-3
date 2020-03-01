package Lesson_08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Tree> treeList = new ArrayList<>();
    private boolean isChildAdd = false;

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/main/java/Lesson_08/1.txt"))));
        reader.readLine();

        while (reader.ready()){
            String[] array;
            array = reader.readLine().split("  ");

            int parentId;
            if ((parentId = Integer.parseInt(array[1])) == 0){
                main.treeList.add(new Tree(Integer.parseInt(array[0]), parentId));
            } else {
                main.addChildToParent(main.treeList, Integer.parseInt(array[0]), parentId);
            }
        }
        reader.close();
    }

    private void addChildToParent(List<Tree> treeParam, int id, int parentId){
        for (Tree tree : treeParam){
            if (isChildAdd){
                isChildAdd = false;
                break;
            }

            if (tree.getId() == parentId){
                tree.addChild(id, parentId);
                isChildAdd = true;
                break;
            } else if (tree.hasChildren()){
                this.addChildToParent(tree.getChildrenList(), id, parentId);
            }
        }
    }
}
