import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Scratch {
    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("[&](.*?)[=]").matcher(str);
        String res = "";
        while (matcher.find())
            res = matcher.group(1);
    }
}
