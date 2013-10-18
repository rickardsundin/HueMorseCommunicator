package se.citerus.labs;

public class HueMorseCommunicator {

    public static final int TIMEUNIT = 300;

    private final HueController hue;

    public HueMorseCommunicator(int lightId) {
        hue = new HueController("http://192.168.3.103/api/", "rickardsundin", lightId);
    }

    public void send(String message) {
        hue.off(); // Make sure the light is off before sending message
        for (Morse.Pulse pulse : Morse.asMorse(message)) {
            send(pulse);
        }
    }

    /**
     * Each character (letter or numeral) is represented by a unique sequence of dots and dashes.
     * The duration of a dash is three times the duration of a dot.
     * Each dot or dash is followed by a short silence, equal to the dot duration.
     * The letters of a word are separated by a space equal to three dots.
     * The dot duration is the basic unit of time measurement in code transmission.
     * @param pulse
     */
    private void send(Morse.Pulse pulse) {
        switch (pulse) {
            case PAUSE:
                wait(TIMEUNIT * 2);
                break;
            case SHORT:
                hue.on();
                wait(TIMEUNIT);
                hue.off();
                wait(TIMEUNIT);
                break;
            case LONG:
                hue.on();
                wait(TIMEUNIT * 3);
                hue.off();
                wait(TIMEUNIT);
                break;
        }
    }

    private void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
