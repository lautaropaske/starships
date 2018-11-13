package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigurationReader {
    private static final String FILENAME = ".\\util\\starships.conf";
    private static final Pattern playerPattern = Pattern.compile("^(Player)[0-9]+");
    private Set<int[]> keySet = new HashSet<>();

    public ConfigurationReader(){
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                if(playerPattern.matcher(sCurrentLine).matches()){
                    int[] keys = new int[6];

                    br.readLine(); // Skip '-'
                    keys[0] = getKeyCode(br.readLine()); // move_up
                    keys[1] = getKeyCode(br.readLine()); // move_left
                    keys[2] = getKeyCode(br.readLine()); // move_down
                    keys[3] = getKeyCode(br.readLine()); // move_right
                    keys[4] = getKeyCode(br.readLine()); // fire_gun
                    keys[5] = getKeyCode(br.readLine()); // change_gun
                    br.readLine(); // Skip '\n'

                    keySet.add(keys);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getKeyCode(String readLine){
        String[] splitted = readLine.split(":");
        return java.awt.event.KeyEvent.getExtendedKeyCodeForChar((splitted[1].charAt(0)));
    }

    public Set<int[]> getKeySet(){return keySet;}
}
