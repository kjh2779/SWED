package com.mycompany.swed3;

public class TextContentComparison implements ComparisonStrategy {
    @Override
    public boolean compare(String oldContent, String newContent) {
        String oldText = oldContent.replaceAll("\\<.*?\\>", "");
        String newText = newContent.replaceAll("\\<.*?\\>", "");
        boolean is_same = oldText.equals(newText);
        if (!is_same) {
            System.out.println("TextContentComparison:");
            String diff = getDifference(oldText, newText);
            System.out.println("Differences:");
            System.out.println(diff);
        }
        return is_same;
    }

    private String getDifference(String oldText, String newText) {
        StringBuilder oldDiff = new StringBuilder();
        StringBuilder newDiff = new StringBuilder();
        
        int maxLength = Math.max(oldText.length(), newText.length());
        
        for (int i = 0; i < maxLength; i++) {
            char oldChar = i < oldText.length() ? oldText.charAt(i) : '\0';
            char newChar = i < newText.length() ? newText.charAt(i) : '\0';
            
            if (oldChar != newChar) {
                if (oldChar != '\0') {
                    oldDiff.append(oldChar);
                }
                if (newChar != '\0') {
                    newDiff.append(newChar);
                }
            }
        }
        
        return "Old: " + oldDiff.toString() + "\n\n\nNew: " + newDiff.toString();
    }
}


