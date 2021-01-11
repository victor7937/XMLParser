package by.victor.jwd.dao.utils.parser.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NodeParser {

    private String xmlForParse;
    private String nodeData;
    private String content;

    private boolean isFinal;
    private String childrenSubstring;
    private String siblingSubstring;
    private Map<String, String> attributes;

    private final String NODE_PATTERN = "<\\s*([a-zA-Z0-9-_]+)([-_a-zA-Z0-9=\" \\.]*)>";
    private final String SPACES_OR_NTH_PATTERN = "\\s*";
    private final String ATTRIBUTES_PATTERN = "([a-zA-Z0-9]+)=\"([-_a-zA-Z0-9 \\.]+)\"";

    public String getNodeData() {
        return nodeData;
    }

    public String getContent() {
        return content;
    }

    public boolean isFinal() {
        return this.isFinal;
    }

    public boolean isContent() {
        return this.isFinal() && !(content == null || content.matches(SPACES_OR_NTH_PATTERN));
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String getChildrenSubstring() {
        return childrenSubstring;
    }

    public String getSiblingSubstring() {
        return siblingSubstring;
    }

    private NodeParser(String xmlForParse){
        this.xmlForParse = xmlForParse;
        parsingProcess();
    }

    public static NodeParser parse (String xmlForParse) {
        return new NodeParser(xmlForParse);
    }

    private void parsingProcess () {
        Pattern pattern = Pattern.compile(NODE_PATTERN);
        Matcher matcher = pattern.matcher(xmlForParse);
        if (matcher.find()) {
            nodeData = matcher.group(1);
            attributes = parseAttributes(matcher.group(2));
            childrenSubstring = createChildrenSubstring(matcher.end(), matcher.group(1));
            siblingSubstring = createSiblingSubstring(matcher.group(1));
        }
        else {
            isFinal = true;
            content = xmlForParse;
        }
    }

    private String createChildrenSubstring (int tagEndingIndex, String tagName) {
        Matcher matcher = createClosingTagMather(tagName);
        int closingTagIndex;
        if (matcher.find())
            closingTagIndex = matcher.start();
        else
            return null;
        return xmlForParse.substring(tagEndingIndex, closingTagIndex);
    }

    private String createSiblingSubstring (String tagName) {
        Matcher matcher = createClosingTagMather(tagName);
        int closingTagEndIndex;
        if (matcher.find())
            closingTagEndIndex = matcher.end();
        else
            return null;
        return xmlForParse.substring(closingTagEndIndex);

    }

    private Matcher createClosingTagMather (String tagName) {
        String closingTagPtr = createClosingTagPattern(tagName);
        Pattern pattern = Pattern.compile(closingTagPtr);
        return pattern.matcher(xmlForParse);
    }

    private String createClosingTagPattern (String tagName){
        return "</" + "\\s*(" + tagName + ")\\s*>";
    }

    private Map<String,String> parseAttributes(String attributesString){
        if (attributesString.matches(SPACES_OR_NTH_PATTERN)) {
            return null;
        }
        Pattern pattern = Pattern.compile(ATTRIBUTES_PATTERN);
        Matcher matcher = pattern.matcher(attributesString);
        Map<String,String> attributesMap = new LinkedHashMap<>();
        while (matcher.find()){
            attributesMap.put(matcher.group(1), matcher.group(2));
        }
        return attributesMap;
    }
}
