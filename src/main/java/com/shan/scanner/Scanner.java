package com.shan.scanner;
import org.apache.commons.lang3.EnumUtils;
import java.util.ArrayList;
import java.util.Iterator;
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

    public List<String> getTokens() {
        return tokens;
    }

    private List<String> tokens = new ArrayList<>();
    public void scan(String inputCodeSnippet) {
        char[] inputCodeSnippetCharacters = inputCodeSnippet.toCharArray();
        StringBuffer runningString = new StringBuffer();
        for (char character : inputCodeSnippetCharacters) {
            if (!Character.isWhitespace(character)) {

                if(Character.isJavaIdentifierStart(character) || Character.isJavaIdentifierPart(character)){
                    runningString.append(character);
                    String tempString = runningString.toString();
                    if(EnumUtils.isValidEnum(DngToEngPairEnum.class, tempString)){
                        tokens.add(DngToEngPairEnum.valueOf(tempString).engMappedName);
                        runningString.setLength(0);
                    }
                }    else{
                    tokens.add(runningString.toString());
                    runningString.setLength(0);
                    tokens.add(String.valueOf(character));
                }
            }   else{
                if(runningString.length() > 0){
                    String tempString = runningString.toString();
                    if(EnumUtils.isValidEnum(DngToEngPairEnum.class, tempString)){
                        tokens.add(DngToEngPairEnum.valueOf(tempString).engMappedName);
                    }   else{
                        tokens.add(tempString);
                    }
                    runningString.setLength(0);
                }
            }
        }
    }

    public String getMainClassName(){
        var tokenIterator = tokens.iterator();
        while(tokenIterator.hasNext()){
            if(tokenIterator.next().equals("class")){
                return tokenIterator.next();
            }
        }

        return null;
    }

    public String getTranslatedCodeAsString(){
        StringBuffer stringBuffer = new StringBuffer();
        tokens.stream().forEach(x -> {stringBuffer.append(x);stringBuffer.append(" ");});

        return stringBuffer.toString();
    }
}
