package Abstraction.Interfaces;

interface Searchable {
    boolean search(String string);
}

class Document implements Searchable {
    String initialString;

    public Document(String initialString) {
        this.initialString = initialString;
    }

    @Override
    public boolean search(String string) {
        return initialString.contains(string);
    }
}

class WebPage implements Searchable {
    String initialString;

    public WebPage(String initialString) {
        this.initialString = initialString;
    }

    @Override
    public boolean search(String string) {
        return initialString.contains(string);
    }
}

public class Searching {
    public static void main(String[] args) {
        System.out.println("Document class - object.");
        String s1 = "Vandit and Alok are good friends.";
        System.out.println("String to be search");
        Document document = new Document(s1);
        System.out.println(document.search("are good"));

        System.out.println("WebPage class - object.");
        WebPage webPage = new WebPage("This is a sample webpage for Searching programming. No is 23");
        System.out.println(webPage.search("25"));
    }
}
