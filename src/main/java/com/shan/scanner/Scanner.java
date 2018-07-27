package com.shan.scanner;
import org.apache.commons.lang3.EnumUtils;
import java.util.ArrayList;
import java.util.List;

public class Scanner {
    public enum DngToEngPairEnum {
        स्ट्रिंग("String"),
        इन्ट("int"),
        डबल("double"),
        बूलियन("boolean"),
        क्लास("class"),
        प्राइवेट("private"),
        पब्लिक("public"),
        वोयड("void"),
        छाप("System.out.println"),
        स्टाटिक("static"),
        मेन("main"),
        न्यू("new");
        String engMappedName;
        DngToEngPairEnum(String stringStringImmutablePair) {
            this.engMappedName = stringStringImmutablePair;
        }
    }
    public List<String> scan(String inputCodeSnippet) {
        char[] inputCodeSnippetCharacters = inputCodeSnippet.toCharArray();
        StringBuffer runningString = new StringBuffer();
        List<String> listOfTokens = new ArrayList<>();
        for (char character : inputCodeSnippetCharacters) {
            if (!Character.isWhitespace(character)) {

                if(Character.isJavaIdentifierStart(character) || Character.isJavaIdentifierPart(character)){
                    runningString.append(character);
                    String tempString = runningString.toString();
                    if(EnumUtils.isValidEnum(DngToEngPairEnum.class, tempString)){
                        listOfTokens.add(DngToEngPairEnum.valueOf(tempString).engMappedName);
                        runningString.setLength(0);
                    }
                }    else{
                    if(listOfTokens.get(listOfTokens.size()-1).equals("class")){
                        String origToken = runningString.toString();
                        listOfTokens.add("hello");
                        runningString.setLength(0);
                    }   else{
                        listOfTokens.add(runningString.toString());
                        runningString.setLength(0);
                    }
                    listOfTokens.add(String.valueOf(character));
                }
            }
        }
        return listOfTokens;
    }
}
