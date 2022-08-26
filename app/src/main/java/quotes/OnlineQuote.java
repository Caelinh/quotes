package quotes;

import java.util.ArrayList;

public class OnlineQuote {
    String quoteText;
    String quoteAuthor;

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public void setQuoteAuthor(String quoteAuthor) {
        this.quoteAuthor = quoteAuthor;
    }

    public OnlineQuote(String quoteText, String quoteAuthor) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
    }

    @Override
    public String toString() {
        return "OnlineQuote{" +
                "quoteText='" + quoteText + '\'' +
                ", quoteAuthor='" + quoteAuthor + '\'' +
                '}';
    }
}
