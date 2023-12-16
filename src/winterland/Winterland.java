package winterland;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import winterland.windows.TitleWindow;

public class Winterland {
    public static Step[] steps;

    public static void main(String[] args) throws IOException {
        TitleWindow titleWindow = new TitleWindow();
        titleWindow.setVisible(true);

        steps = loadSteps();

    }

    public static Step[] loadSteps() throws IOException {
        //We need to find count of the lines to make an array
        FileReader fr = new FileReader("res/steps.txt");
        BufferedReader br = new BufferedReader(fr);
        int count = 0;
        while (true){
            String s = br.readLine();
            if (s == null) break;
            count++;
        }
        fr.close();

        // Now we can read lines, make Step and store them in array
        Step[] steps = new Step[count];
        fr = new FileReader("res/steps.txt");
        br = new BufferedReader(fr);
        int i = 0;
        while (true){
            String s = br.readLine();
            if (s == null) break;
            Step step = new Step(s);
            steps[i++] = step;
        }
        fr.close();

        return steps;
    }
}