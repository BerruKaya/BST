package assignment_3;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class BSTPrinter {

    public static <T extends Comparable<?>> void printNode(Node root) {
        int maxLevel = BSTPrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BSTPrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BSTPrinter.printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.key);
                newNodes.add(node.leftNode);
                newNodes.add(node.rightNode);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BSTPrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BSTPrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BSTPrinter.printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).leftNode != null)
                    System.out.print("/");
                else
                    BSTPrinter.printWhitespaces(1);

                BSTPrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).rightNode != null)
                    System.out.print("\\");
                else
                    BSTPrinter.printWhitespaces(1);

                BSTPrinter.printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(BSTPrinter.maxLevel(node.leftNode), BSTPrinter.maxLevel(node.rightNode)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}
