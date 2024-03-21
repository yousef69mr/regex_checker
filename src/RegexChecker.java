import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChecker {
    private String regex_pattern;
    private Pattern pattern;

    public RegexChecker(String regex){
        setRegex_pattern(regex);
    }

    public Matcher check(String test){
        return pattern.matcher(test);
    }



    public void setRegex_pattern(String regex_pattern) {
        this.regex_pattern = regex_pattern;
        this.pattern = Pattern.compile(regex_pattern);

    }

    public String getRegex_pattern() {
        return regex_pattern;
    }
}

