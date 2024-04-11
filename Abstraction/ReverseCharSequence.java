package Abstraction.Interfaces;

public class ReverseCharSequence implements CharSequence {
    private String str;

    public ReverseCharSequence(String str) {
        this.str = str;
    }

    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int index) {
        return str.charAt(str.length() - 1 - index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new ReverseCharSequence(str.substring(start, end));
    }

    @Override
    public String toString() {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    // Small main method to test the class
    public static void main(String[] args) {
        String sentence = "Write a class that implements the CharSequence interface.";
        ReverseCharSequence reversedSequence = new ReverseCharSequence(sentence);
        System.out.println("Original: " + sentence);
        System.out.println("Reversed: " + reversedSequence);
    }
}
