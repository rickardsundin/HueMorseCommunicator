package se.citerus.labs;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static se.citerus.labs.Morse.Pulse.LONG;
import static se.citerus.labs.Morse.Pulse.PAUSE;
import static se.citerus.labs.Morse.Pulse.SHORT;

public class MorseTest {

    @Test
    public void testLetterS() {
        List<Morse.Pulse> pulses = Morse.asMorse("s");
        assertThat(pulses.size(), is(4));
        assertThat(pulses.get(0), is(SHORT));
        assertThat(pulses.get(1), is(SHORT));
        assertThat(pulses.get(2), is(SHORT));
        assertThat(pulses.get(3), is(PAUSE));
    }

    @Test
    public void testLetterO() {
        List<Morse.Pulse> pulses = Morse.asMorse("o");
        assertThat(pulses.size(), is(4));
        assertThat(pulses.get(0), is(LONG));
        assertThat(pulses.get(1), is(LONG));
        assertThat(pulses.get(2), is(LONG));
        assertThat(pulses.get(3), is(PAUSE));
    }

    @Test
    public void testSos() {
        List<Morse.Pulse> pulses = Morse.asMorse("sos");
        assertThat(pulses.size(), is(12));
        assertThat(pulses.get(0), is(SHORT));
        assertThat(pulses.get(1), is(SHORT));
        assertThat(pulses.get(2), is(SHORT));
        assertThat(pulses.get(3), is(PAUSE));
        assertThat(pulses.get(4), is(LONG));
        assertThat(pulses.get(5), is(LONG));
        assertThat(pulses.get(6), is(LONG));
        assertThat(pulses.get(7), is(PAUSE));
        assertThat(pulses.get(8), is(SHORT));
        assertThat(pulses.get(9), is(SHORT));
        assertThat(pulses.get(10), is(SHORT));
        assertThat(pulses.get(11), is(PAUSE));
    }

}
