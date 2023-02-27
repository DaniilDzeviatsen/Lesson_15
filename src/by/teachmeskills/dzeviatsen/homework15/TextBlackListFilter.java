package by.teachmeskills.dzeviatsen.homework15;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlackListFilter {
    private String[] badWords;

    public TextBlackListFilter(String badWordss) {
        this.badWords = badWordss.split(", ");
    }

    public boolean ifContainsBadWords(String userText) {
        for (int i = 0; i < badWords.length; i++) {
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(badWords[i]) + "\\b",
                    Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(userText);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }


    public int badWordsCount(String userText) {
        int count = 0;
        for (int i = 0; i < badWords.length; i++) {
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(badWords[i]) + "\\b",
                    Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(userText);
            if (matcher.find()) {
                count++;
            }
        }
        return count;
    }

    public String toSencoredText(String userText) {
        for (int i = 0; i < badWords.length; i++) {

            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(badWords[i]) + "\\b",
                    Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(userText);
            if (matcher.find()) {
                if (userText.contains((badWords[i]))) {
                    userText = matcher.replaceAll("####");
                }
            }

        }return userText;
    }
}
