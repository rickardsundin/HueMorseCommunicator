package se.citerus.labs;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static se.citerus.labs.Morse.Pulse.LONG;
import static se.citerus.labs.Morse.Pulse.PAUSE;
import static se.citerus.labs.Morse.Pulse.SHORT;

public class Morse {

    public enum Pulse {
        SHORT,
        LONG,
        PAUSE
    }

    private static Pulse[] pulsesFor(char ch) {
        switch (ch) {
            case 'a': return new Pulse[] {SHORT, LONG};
            case 'b': return new Pulse[] {LONG, SHORT, SHORT, SHORT};
            case 'c': return new Pulse[] {LONG, SHORT, LONG, SHORT};
            case 'd': return new Pulse[] {LONG, SHORT, SHORT};
            case 'e': return new Pulse[] {SHORT};
            case 'f': return new Pulse[] {SHORT, SHORT, LONG, SHORT};
            case 'g': return new Pulse[] {LONG, LONG, SHORT};
            case 'h': return new Pulse[] {SHORT, SHORT, SHORT, SHORT};
            case 'i': return new Pulse[] {SHORT, SHORT};
            case 'j': return new Pulse[] {SHORT, LONG, LONG, LONG};
            case 'k': return new Pulse[] {LONG, SHORT, LONG};
            case 'l': return new Pulse[] {SHORT, LONG, SHORT, SHORT};
            case 'm': return new Pulse[] {LONG, LONG};
            case 'n': return new Pulse[] {LONG, SHORT};
            case 'o': return new Pulse[] {LONG, LONG, LONG};
            case 'p': return new Pulse[] {SHORT, LONG, LONG, SHORT};
            case 'q': return new Pulse[] {LONG, LONG, SHORT, LONG};
            case 'r': return new Pulse[] {SHORT, LONG, SHORT};
            case 's': return new Pulse[] {SHORT, SHORT, SHORT};
            case 't': return new Pulse[] {LONG};
            case 'u': return new Pulse[] {SHORT, SHORT, LONG};
            case 'v': return new Pulse[] {SHORT, SHORT, SHORT, LONG};
            case 'w': return new Pulse[] {SHORT, LONG, LONG};
            case 'x': return new Pulse[] {LONG, SHORT, SHORT, LONG};
            case 'y': return new Pulse[] {LONG, SHORT, LONG, LONG};
            case 'z': return new Pulse[] {LONG, LONG, SHORT, SHORT};
            default: return new Pulse[] {PAUSE};
        }
    }

    public static List<Pulse> asMorse(String message) {
        List<Pulse> pulses = new ArrayList<Pulse>();
        for (char ch : message.toLowerCase().toCharArray()) {
            pulses.addAll(asList(pulsesFor(ch)));
            pulses.add(PAUSE);
        }
        return pulses;
    }

}
