import com.shan.scanner.Scanner;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ScannerTest {

    @Test
    public void testScanner_datatypes() throws IOException {
        Scanner scanner = new Scanner();
        List<String> tokens = scanner.scan(
                "पब्लिक क्लास अ { प्राइवेट स्टाटिक इन्ट क्ष;प्राइवेट स्टाटिक इन्ट य;पब्लिक अ(){}पब्लिक स्टाटिक वोयड योजन(){इन्ट ज = क्ष + य;छाप(ज);} पब्लिक स्टाटिक वोयड मेन(स्ट्रिंग[] अर्ग्स){क्ष = 3;य = 4;योजन();}}");

        System.out.println(tokens);
        StringBuffer stringBuffer = new StringBuffer();
        tokens.stream().forEach(x -> {stringBuffer.append(x);stringBuffer.append(" ");});

        File file = new File("hello.java");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(stringBuffer.toString());

        bw.close();
    }

    @Test
    public void test(){
        char c = 'अ';
        System.out.println(Character.isJavaIdentifierStart(c));
        System.out.println(Character.isJavaIdentifierPart(c));
        /*System.out.println(Character.is(c));*/
    }
}
