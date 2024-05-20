import java.util.ArrayList;
public class Pilot {

    private ArrayList<String> planeDialogue;

    public Pilot () {
        planeDialogue = new ArrayList<>();
        planeDialogue.add("As you flew above the horizons, you watched the clouds whizz by.");
        planeDialogue.add("The island slowly came into view. The jet started lowering in altitude.");
        planeDialogue.add("The pilot cleared his throat over the headphone intercom."); //2
        planeDialogue.add("\"Landing soon. Please fasten your seatbelt, miss.\"");
        planeDialogue.add("Fascinated by the view, you didn't hear the pilot. He sighs, frustrated."); //4
        planeDialogue.add("\"" + GraphicsPanel.getPlayer().getName() + ", please fasten your seatbelt!\"");
        planeDialogue.add("\"We are landing on the island soon. " + GraphicsPanel.getTown().getName() + ".\""); //6
        planeDialogue.add("\"Thank you. Sorry, didn't mean to yell. I'm just... on edge about Micheal.\""); //choice 7
        planeDialogue.add("\"Be happy I'm even flying you here in the first place.\""); //choice 8

        planeDialogue.add("The radio chirps alive."); //9
        planeDialogue.add("A static muffles the audio. The pilot turns a knob to clear the signal."); // pink 10
        planeDialogue.add("Attention all units of the flight agency."); //11
        planeDialogue.add("On March 9, 2121, a Sound Moon will occur again.");
        planeDialogue.add("All pilots, please hold caution.");
        planeDialogue.add("As confirmed by the Vengeance Agency, the werewolves have evolved.");
        planeDialogue.add("Subjects may take the form of a living being to look human.");
        planeDialogue.add("All units are to report any suspicious activities regarding these notions.");
        planeDialogue.add("That is all."); //17
        planeDialogue.add("The radio goes silent. The pilot sighs."); //pink 18
        planeDialogue.add("\"This is insane.\""); //19
        planeDialogue.add("\"Werewolves? Oh yeah, long story, I think.\""); //20
        planeDialogue.add("\"Something about some dark yellow moon and monsters going nuts. They eat humans and stuff.\"");
        planeDialogue.add("\"But don't worry, we won't have to deal with any of that.\"");
        planeDialogue.add("\"Well. I hope.\"");
        planeDialogue.add("An awkward silence falls over the cabin."); //pink 24
        planeDialogue.add("Only the muffled sounds of the engine can be heard."); // pink 25
        planeDialogue.add("\"Hey missy? Keep an eye on Micheal for me, would you?\"");
        planeDialogue.add("\"He's just acting weird lately. Been mad a whole lot of times more than I remember.\"");
        planeDialogue.add("After a while of a long, pondering silence between the two, the jet lands."); //27
    }

    public int getPlaneDialogueLength() {
        return planeDialogue.size();
    }

    public String getDialogue(int idx) {
        return planeDialogue.get(idx);
    }
}
