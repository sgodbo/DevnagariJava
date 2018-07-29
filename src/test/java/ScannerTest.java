import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//import static com.shan.scanner.अ.योजन;

public class ScannerTest {

    @Test
    public void testScanner_datatypes() throws IOException {
        /*Scanner scanner = new Scanner();
        List<String> tokens = scanner.scan(
                "पब्लिक क्लास अ { प्राइवेट स्टाटिक इन्ट क्ष;प्राइवेट स्टाटिक इन्ट य;पब्लिक अ(){}पब्लिक स्टाटिक वोयड योजन(){इन्ट ज = क्ष + य;छाप(ज);} पब्लिक स्टाटिक वोयड मेन(स्ट्रिंग[] अर्ग्स){क्ष = 3;य = 4;योजन();}}");

        System.out.println(tokens);
        StringBuffer stringBuffer = new StringBuffer();
        tokens.stream().forEach(x -> {stringBuffer.append(x);stringBuffer.append(" ");});

        File file = new File("अ.java");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(stringBuffer.toString());

        bw.close();*/
        //अ example = new अ();
        //अ.main(new String[]{});
    }

    @Test
    public void test() throws MalformedURLException {
        char c = 'अ';
        System.out.println(Character.isJavaIdentifierStart(c));
        System.out.println(Character.isJavaIdentifierPart(c));
        /*System.out.println(Character.is(c));*/
        File file = new File("C:/generatedClasses/अ");
        URL url = file.toURI().toURL();
        System.out.println(url.toString());

    }
}
