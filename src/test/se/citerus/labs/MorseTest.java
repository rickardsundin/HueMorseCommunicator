package se.citerus.labs;

import org.junit.Test;
import se.citerus.labs.Morse;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MorseTest {

    @Test
    public void testLetterS() {
        List<Morse.Pulse> pulses = Morse.asMorse("s");
        assertThat(pulses.size(), is(4));
        assertThat(pulses.get(0), is(Morse.Pulse.SHORT));
        assertThat(pulses.get(1), is(Morse.Pulse.SHORT));
        assertThat(pulses.get(2), is(Morse.Pulse.SHORT));
        assertThat(pulses.get(3), is(Morse.Pulse.PAUSE));
    }

    @Test
    public void testLetterO() {
        List<Morse.Pulse> pulses = Morse.asMorse("o");
        assertThat(pulses.size(), is(4));
        assertThat(pulses.get(0), is(Morse.Pulse.LONG));
        assertThat(pulses.get(1), is(Morse.Pulse.LONG));
        assertThat(pulses.get(2), is(Morse.Pulse.LONG));
        assertThat(pulses.get(3), is(Morse.Pulse.PAUSE));
    }

    @Test
    public void testSos() {
        List<Morse.Pulse> pulses = Morse.asMorse("sos");
        assertThat(pulses.size(), is(12));
        assertThat(pulses.get(0), is(Morse.Pulse.SHORT));
        assertThat(pulses.get(1), is(Morse.Pulse.SHORT));
        assertThat(pulses.get(2), is(Morse.Pulse.SHORT));
        assertThat(pulses.get(3), is(Morse.Pulse.PAUSE));
        assertThat(pulses.get(4), is(Morse.Pulse.LONG));
        assertThat(pulses.get(5), is(Morse.Pulse.LONG));
        assertThat(pulses.get(6), is(Morse.Pulse.LONG));
        assertThat(pulses.get(7), is(Morse.Pulse.PAUSE));
        assertThat(pulses.get(8), is(Morse.Pulse.SHORT));
        assertThat(pulses.get(9), is(Morse.Pulse.SHORT));
        assertThat(pulses.get(10), is(Morse.Pulse.SHORT));
        assertThat(pulses.get(11), is(Morse.Pulse.PAUSE));
    }

}
