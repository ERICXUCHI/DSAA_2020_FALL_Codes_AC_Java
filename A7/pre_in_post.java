package A7;
import java.io.*;
import java.util.*;

class treeNode{
    int key;
    treeNode left;
    treeNode right;

    treeNode(int k){
        key = k;
    }
}

public class pre_in_post {

    static ArrayList<Integer> arrayList = new ArrayList<>(1010);
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        int case_number = input.nextInt();
        for (int i = 0; i < case_number; i++) {
            int nodes_number = input.nextInt();
            int[] preorder = new int[nodes_number];
            int[] inOrder = new int[nodes_number];

            HashMap<Integer, Integer> inorder = new HashMap<>(nodes_number);

            for (int j = 0; j < nodes_number; j++) {
                preorder[j] = input.nextInt();
            }
            for (int j = 0; j < nodes_number; j++) {
                inOrder[j] = input.nextInt();
                inorder.put(inOrder[j], j);
            }


            treeNode Tree = tree(preorder, inorder, 0, nodes_number - 1, 0, nodes_number - 1);

//            treeNode Tree = new treeNode(1);
//            Tree.left = new treeNode(2);
//            Tree.left.right = new treeNode(4);
//            Tree.right = new treeNode(3);
//            Tree.right.left = new treeNode(5);


            print_postorder(Tree);
            for (int j = 0; j < nodes_number-1; j++) {
                System.out.print(arrayList.get(j) + " ");
            }
            System.out.println(arrayList.get(nodes_number-1));
            arrayList.clear();

        }

////////
        System.out.close();
    }

    ////@override

    static treeNode tree (int[] preorder, HashMap<Integer,Integer> inorder, int preleft, int preright, int inleft, int inright){

        if (preleft > preright || inleft > inright){
            return null;
        }

        treeNode root = new treeNode(preorder[preleft]);

        int node_index = inorder.get(root.key);

        root.left = tree(preorder,inorder,preleft+1,node_index-inleft+preleft,inleft,node_index-1);

        root.right = tree(preorder,inorder,node_index-inleft+preleft+1,preright,node_index+1,inright);

        return root;


    }

    static void print_postorder(treeNode root){

        if(root.left!=null) {
            print_postorder(root.left);
        }
        if(root.right!=null) {
            print_postorder(root.right);
        }
        arrayList.add(root.key);
    }

    ////////
}

