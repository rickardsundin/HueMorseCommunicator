package se.citerus.labs;

public class Main {
    public static void main(String[] args) {
        int lightId = 2;
        new HueMorseCommunicator(lightId).send("citerus");
    }
}
