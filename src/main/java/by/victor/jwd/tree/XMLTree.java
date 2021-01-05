package by.victor.jwd.tree;

import java.util.*;

public class XMLTree {
    private Node root;

    public static class Node {
        private String data;
        private List<Node> childNodes;
        private boolean finalNode;

        public boolean isFinalNode() {
            return finalNode;
        }

        public void setFinalNode(boolean finalNode) {
            this.finalNode = finalNode;
        }

        HashMap<String, String> attributes; //optional

        public Node(String data) {
            this.data = data;
            this.childNodes = new ArrayList<>();
        }

        public void setData(String data) {
            this.data = data;
        }

        public List<Node> getChildNodes() {
            return childNodes;
        }

        public void addChild(Node node) {
            childNodes.add(node);
        }

        @Override
        public String toString() {
            return data;
        }
    }

    public XMLTree() {}

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private List<Node> getDfsNodeList() {
        List<Node> dfsNodeLIst = new LinkedList<>();
        fillDFSNodeList(root, dfsNodeLIst);
        return dfsNodeLIst;
    }

    private void fillDFSNodeList(Node node, List<Node> nodesList) {
        if (node != null) {
            List<Node> childNodes = node.getChildNodes();
            if (childNodes.isEmpty()){
                node.setFinalNode(true);
            }
            nodesList.add(node);

            if (!childNodes.isEmpty()) {
                for (Node temp : childNodes) {
                    this.fillDFSNodeList(temp, nodesList);
                }
            }
        }
    }

    @Override
    public String toString() {
        List<Node> dfsNodeList = getDfsNodeList();
        StringBuilder nodesBuilder= new StringBuilder("");
        String spaceIncrement = "";
        for (Node node: dfsNodeList) {
            if (!node.isFinalNode()){
                nodesBuilder.append("\n").append(spaceIncrement).append(node).append(": ");
                spaceIncrement = spaceIncrement + "--";
            }
            else {
                spaceIncrement = spaceIncrement.substring(0, spaceIncrement.length() - 2);
                nodesBuilder.append(node);
            }
        }
        return nodesBuilder.toString();
    }

}


