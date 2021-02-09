package by.victor.jwd.tree;
import java.util.*;

public class XMLTree {
    private Node root;
    private String dashIncrement;
    private StringBuilder treeViewStringBuilder;

    public static class Node {
        private String data;
        private String content;
        private List<Node> childNodes;
        private Map<String, String> attributes;

        public Node(String data) {
            this.data = data;
            this.childNodes = new ArrayList<>();
            this.content = "";
        }

        public void setContent(String content) { this.content = content; }

        public String getContent() { return content; }

        public void setAttributes(Map<String, String> attributes) { this.attributes = attributes; }

        public Map<String, String> getAttributes() { return attributes; }

        public void setData(String data) { this.data = data; }

        public String getData() { return data; }

        public boolean hasAttributes (){ return !(attributes == null || attributes.isEmpty()); }

        public boolean hasChildren() { return !childNodes.isEmpty(); }

        public List<Node> getChildNodes() { return childNodes; }

        public void addChild(Node node) { childNodes.add(node); }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(data, node.data) &&
                    Objects.equals(content, node.content) &&
                    Objects.equals(childNodes, node.childNodes) &&
                    Objects.equals(attributes, node.attributes);
        }

        @Override
        public int hashCode() { return Objects.hash(data, content, childNodes, attributes); }

        @Override
        public String toString() { return content.isEmpty() ? data : data + ": " + content; }
    }

    public XMLTree() {}

    public void setRoot(Node root) { this.root = root; }

    public Node getRoot() { return root; }

    private void DFS(Node node) {
        if (node != null) {
            List<Node> childNodes = node.getChildNodes();
            treeViewStringBuilder.append(dashIncrement).append(node.toString()).append(" ")
                    .append(node.hasAttributes() ? node.getAttributes() : "").append("\n");
            if (node.hasChildren()) {
                dashIncrement = dashIncrement + "--";
            }
            if (node.hasChildren()) {
                for (Node tempNode : childNodes) {
                    this.DFS(tempNode);
                }
                dashIncrement = dashIncrement.substring(0, dashIncrement.length() - 2);
            }
        }
    }

    public String toTreeStructureString() {
        dashIncrement = "";
        treeViewStringBuilder = new StringBuilder("");
        DFS(root);
        return treeViewStringBuilder.toString();
    }

}


