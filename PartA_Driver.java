import java.util.Scanner;

public class DecisionDriver{
/**
 * Write a description of class PartA_Driver here.
 *
 * Emhenya Supreme
 * 
 */
    public static void main(String[] args) {
        // Create the decision tree
        LinkedBinaryTree<String> tree = MakeTree();

        // Display the content of the tree
        System.out.println("Tree");
        System.out.println("----");
        System.out.println(tree);
        System.out.println("Tree Interaction");
        System.out.println("----");
        
    

        
        // Start the interactive session
        traverseTree(tree);
    }

private static LinkedBinaryTree<String> MakeTree() {
    LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
    Position<String> root = tree.addRoot("Are you a music lover? (yes/no)");

    // Level 1
    Position<String> noNode = tree.addLeft(root, "is Afrobeat your better genre? (yes/no)");
    Position<String> yesNode = tree.addRight(root, "Is Amapiano your better genre? (yes/no)");

    // Level 2
    Position<String> FurtherNoNode = tree.addLeft(noNode, "you should reconsider!");
    Position<String> FurtherYesNode = tree.addRight(noNode, "Great taste!");
    Position<String> AgreeNoNode = tree.addLeft(yesNode, "would you like to make amapiano beats? (yes/no)");
    Position<String> SecondQuestionNode = tree.addRight(yesNode, "You make good decisions");
    Position<String> PositiveNode = tree.addLeft(AgreeNoNode, "You should be a singer instead!");
    Position<String> NegativeNode = tree.addRight(AgreeNoNode, "You would make a good DJ!");
    
    return tree;
}

public static void traverseTree(LinkedBinaryTree<String> tree) {
    Scanner scanner = new Scanner(System.in);
    Position<String> current = tree.root();

    while (true) {
        System.out.println(current.getElement());

        Position<String> left = tree.left(current);
        Position<String> right = tree.right(current);
        if (left!= null && right!= null) {
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("yes")) {
                current = right;
            } else if (answer.equals("no")) {
                current = left;
            } else {
                System.out.println("Invalid input. Please answer with 'yes' or 'no'.");
            }
        } else {
            break;
        }
    }

    System.out.println("Final Decision: " + current.getElement());
    scanner.close();
}
}
