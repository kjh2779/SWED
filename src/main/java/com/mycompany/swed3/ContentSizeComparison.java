package com.mycompany.swed3;

public class ContentSizeComparison implements ComparisonStrategy {
    @Override
    public boolean compare(String oldContent, String newContent) {
/*         System.out.println("ContentSizeComparison:");
        System.out.println("Old content: " + oldContent);
        System.out.println("New content: " + newContent); */
        boolean is_same = oldContent.length() == newContent.length();
        System.out.println("Old length = " + oldContent.length() + ", New length = " + newContent.length() + ", Same = " + is_same);
        return is_same;
    }
}

