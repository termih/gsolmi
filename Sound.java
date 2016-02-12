import java.util.ArrayList;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class Sound {
    public static ArrayList<String> note = new ArrayList<String>();
    public static ArrayList<String> extendedNote = new ArrayList<String>();
    Sequencer sequencer;

	public Sound() {
		try {
				sequencer = MidiSystem.getSequencer();
				sequencer.open();
			} catch (Exception ex) {
				ex.printStackTrace();
			}		
			
	}
    public void play(int octave, String button, int instrument) {
        String[] preNote = {"C", "D", "E", "F", "G", "A", "B"};
        for (int i = 0; i < 7; i++) {
            note.add(preNote[i]);
        }

        String[] preExtendedNote = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        for (int i = 0; i < 12; i++) {
            extendedNote.add(preExtendedNote[i]);
        }
        
        int finalNote = 0;
        finalNote = (octave * 12) + extendedNote.indexOf(button);
        System.out.print(" (" + finalNote + ")\n");
        playNote(finalNote, instrument);
    }
    
    public void playNote(int finalNote, int finalInstrument) {
        try {
            tryPlayNote(finalNote, finalInstrument);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void tryPlayNote(int finalNote, int finalInstrument) 
            throws MidiUnavailableException, InvalidMidiDataException
            {
		sequencer.stop();
        
        
        Sequence sequence = new Sequence(Sequence.PPQ, 4);
        Track track = sequence.createTrack();

        MidiEvent event = null;

        ShortMessage first = new ShortMessage();
        
        first.setMessage(192, 1, finalInstrument, 0);

        MidiEvent changeInstrument = new MidiEvent(first, 1);
        track.add(changeInstrument);

        ShortMessage a = new ShortMessage();
        a.setMessage(144, 1, finalNote, 100);
        MidiEvent noteOn = new MidiEvent(a, 1);
        track.add(noteOn);

        ShortMessage b = new ShortMessage();
        b.setMessage(128, 1, finalNote, 100);
        MidiEvent noteOff = new MidiEvent(b, 16);
        track.add(noteOff);

        sequencer.setSequence(sequence);
        sequencer.start();
        

    }
}
