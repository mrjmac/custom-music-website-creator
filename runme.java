import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.io.FileWriter;


public class runme {
    public static void main(String args[]) throws IOException {

        // Grab the names of all music
        File folder = new File("music");
        File[] files = folder.listFiles();

        // Grab the original code and prepare our additional string
        Path music = Path.of("music.html");
        String code = Files.readString(music);
        String addition = "";

        //create additional code needed to support music
        for (int i = 0; i < files.length; i++)
        {
            addition += "<li data-scr=\"" + files[i].getAbsolutePath().substring(files[i].getAbsolutePath().indexOf("music/" + files[i].getName())) + "\" data-name=\"" + files[i].getName().substring(0, files[i].getName().length() - 4) + "\" data-index=\"" + i + "\"><span>" + files[i].getName().substring(0, files[i].getName().length() - 4) + "</span></li>\n";
        }
        
        //write end result to music.html
        FileWriter FileWriter = new FileWriter("music.html", false);
        FileWriter.write(code.substring(0, code.indexOf("song-list\">") + 11) + addition + code.substring(code.indexOf("<audio src=") - 22));
        FileWriter.close();
    }
}