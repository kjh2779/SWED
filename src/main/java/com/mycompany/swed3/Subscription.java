
package com.mycompany.swed3;

public class Subscription {
    private String url;
    private int frequencyInSeconds;
    private String communicationChannel;
    private ComparisonStrategy comparisonStrategy;
    private String lastContent;

    public Subscription(String url, int frequencyInSeconds, String communicationChannel, ComparisonStrategy comparisonStrategy) {
        this.url = url;
        this.frequencyInSeconds = frequencyInSeconds;
        this.communicationChannel = communicationChannel;
        this.comparisonStrategy = comparisonStrategy;
        this.lastContent = ""; // Initial content
    }

    public String getUrl() {
        return url;
    }

    public int getFrequencyInSeconds() {
        return frequencyInSeconds;
    }

    public String getCommunicationChannel() {
        return communicationChannel;
    }

    public ComparisonStrategy getComparisonStrategy() {
        return comparisonStrategy;
    }

    public String getLastContent() {
        return lastContent;
    }

    public void setLastContent(String lastContent) {
        this.lastContent = lastContent;
    }
}
