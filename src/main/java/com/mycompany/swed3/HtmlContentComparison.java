package com.mycompany.swed3;

public class HtmlContentComparison implements ComparisonStrategy {
    @Override
    public boolean compare(String oldContent, String newContent) {
/*         System.out.println("HtmlContentComparison:");
        System.out.println("Old content: " + oldContent);
        System.out.println("New content: " + newContent); */
        boolean is_same = oldContent.equals(newContent);
        System.out.println("Same = " + is_same);
        return is_same;
    }
}


