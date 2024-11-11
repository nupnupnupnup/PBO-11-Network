import java.util.ArrayList;

public class MessagePost {
    private String username;
    private String message;
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;

    public MessagePost(String author, String text) {
        username = author;
        message = text;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<String>();
    }

    public void like() {
        likes++;
    }

    public void unlike() {
        if (likes > 0) {
            likes--;
        }
    }

    public void addComment(String text) {
        comments.add(text);
    }

    public String getText() {
        return message;
    }

    public long getTimeStamp() {
        return timestamp;
    }

    public void display() {
        System.out.println(username);
        System.out.println(message);
        System.out.print(timeString(timestamp));
        if (likes > 0) {
            System.out.println(" — " + likes + " people like this.");
        } else {
            System.out.println();
        }
        if (comments.isEmpty()) {
            System.out.println(" No comments.");
        } else {
            System.out.println(" " + comments.size() + " comment(s). Click here to view.");
        }
    }

    private String timeString(long time) {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;
        long seconds = pastMillis / 1000;
        long minutes = seconds / 60;
        if (minutes > 0) {
            return minutes + " minutes ago";
        } else {
            return seconds + " seconds ago";
        }
    }
}

class PhotoPost {
    private String username;
    private String filename;
    private String caption;
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;

    public PhotoPost(String author, String filename, String caption) {
        username = author;
        this.filename = filename;
        this.caption = caption;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<String>();
    }

    public void like() {
        likes++;
    }

    public void unlike() {
        if (likes > 0) {
            likes--;
        }
    }

    public void addComment(String text) {
        comments.add(text);
    }

    public String getImageFile() {
        return filename;
    }

    public String getCaption() {
        return caption;
    }

    public long getTimeStamp() {
        return timestamp;
    }

    public void display() {
        System.out.println(username);
        System.out.println(" [" + filename + "]");
        System.out.println(" " + caption);
        System.out.print(timeString(timestamp));
        if (likes > 0) {
            System.out.println(" — " + likes + " people like this.");
        } else {
            System.out.println();
        }
        if (comments.isEmpty()) {
            System.out.println(" No comments.");
        } else {
            System.out.println(" " + comments.size() + " comment(s). Click here to view.");
        }
    }

    private String timeString(long time) {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;
        long seconds = pastMillis / 1000;
        long minutes = seconds / 60;
        if (minutes > 0) {
            return minutes + " minutes ago";
        } else {
            return seconds + " seconds ago";
        }
    }
}

class NewsFeed {
    private ArrayList<MessagePost> messages;
    private ArrayList<PhotoPost> photos;

    public NewsFeed() {
        messages = new ArrayList<MessagePost>();
        photos = new ArrayList<PhotoPost>();
    }

    public void addMessagePost(MessagePost message) {
        messages.add(message);
    }

    public void addPhotoPost(PhotoPost photo) {
        photos.add(photo);
    }

    public void show() {
        for (MessagePost message : messages) {
            message.display();
            System.out.println();
            delay(2000); // Delay for 2 seconds between posts
        }
        for (PhotoPost photo : photos) {
            photo.display();
            System.out.println();
            delay(2000); // Delay for 2 seconds between posts
        }
    }

    private void delay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        NewsFeed newsFeed = new NewsFeed();
        
        MessagePost message1 = new MessagePost("Rifqy", "Hello, Semuanya!");
        message1.like(); // message1.addComment("Nice to see you!");
        message1.addComment("Halo, Rifqy!");
        
        MessagePost message2 = new MessagePost("Febryan", "Gimana Kabarnya Semua!");
        message2.like();
        message2.like();
        message2.addComment("Baik!");
        
        PhotoPost photo1 = new PhotoPost("Toni", "image1.jpg", "Istriku Cantik ya.");
        photo1.like();
        photo1.addComment("Mantap!");
        
        newsFeed.addMessagePost(message1);
        newsFeed.addMessagePost(message2);
        newsFeed.addPhotoPost(photo1);
        
        newsFeed.show();
    }
}
