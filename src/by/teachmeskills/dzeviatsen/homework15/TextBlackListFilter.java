package by.teachmeskills.dzeviatsen.homework15;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlackListFilter {
    private final String[] badWords;
    private final Pattern[] pattern;

    public TextBlackListFilter(String badWordss) {
        this.badWords = badWordss.trim().split("\\s*,\\s*");
        this.pattern = new Pattern[badWords.length];
        for (int i = 0; i < badWords.length; i++) {
            pattern[i] = getPattern(badWords[i]);
        }
    }

    public Pattern getPattern(String badWord) {
        return Pattern.compile("\\b" + Pattern.quote(badWord) + "\\b",
                Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
    }

    public boolean ifContainsBadWords(String userText) {
        for (Pattern suitablePattern : pattern) {
            Matcher matcher = suitablePattern.matcher(userText);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }


    public int badWordsCount(String userText) {
        int count = 0;
        for (Pattern suitablePattern : pattern) {
            Matcher matcher = suitablePattern.matcher(userText);
            while(matcher.find()) {
                count++;
            }
        }
        return count;
    }

    public String toSencoredText(String userText) {
        for (Pattern suitablePattern : pattern) {
            Matcher matcher = suitablePattern.matcher(userText);
            userText = matcher.replaceAll("####");
        }
        return userText;
    }
}
