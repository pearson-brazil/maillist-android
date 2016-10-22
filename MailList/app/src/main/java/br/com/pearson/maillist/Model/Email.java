package br.com.pearson.maillist.Model;

/**
 * Created by pearson on 29/09/16.
 */
public class Email {
    private String subject;
    private String from;
    private String to;
    private String message;
    private String imageUrl;

    public Email(String subject, String from, String message, String imageUrl) {
        this.subject = subject;
        this.from = from;
        this.message = message;
        this.imageUrl = imageUrl;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subjetct) {
        this.subject = subjetct;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFirstLetter() {
        return from.substring(0,1);
    }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}