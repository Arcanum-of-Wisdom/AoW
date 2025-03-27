package net.bcm.arcanumofwisdom.procedures;

import java.awt.Desktop;
import java.net.URI;
import com.mojang.blaze3d.audio.OpenAlUtil;

public class OpenCurseforgeProcedure {
    public static void execute() {
        String url = "https://www.curseforge.com/members/benl4b/projects";

        try {
            System.out.println("[AoW][OpenCurseforgeProcedure] Attempting to open the website: " + url);

            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(new URI(url));
                    System.out.println("[AoW][OpenCurseforgeProcedure] Website successfully opened.");
                } else {
                    System.err.println("[AoW][OpenCurseforgeProcedure] BROWSE action is not supported!");
                }
            } else {
                System.err.println("[AoW][OpenCurseforgeProcedure] Desktop is not supported! Trying alternative method...");
                openWithRuntime(url);
            }
        } catch (Exception e) {
            System.err.println("[AoW][OpenCurseforgeProcedure] Error while opening the website:");
            e.printStackTrace();
            openWithRuntime(url);
        }
    }

    private static void openWithRuntime(String url) {
        try {
            System.out.println("[AoW][OpenCurseforgeProcedure] Attempting to open browser via Runtime...");
            
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (os.contains("mac")) {
                Runtime.getRuntime().exec("open " + url);
            } else if (os.contains("nix") || os.contains("nux") || os.contains("bsd")) {
                Runtime.getRuntime().exec("xdg-open " + url);
            } else {
                System.err.println("[AoW][OpenCurseforgeProcedure] Operating system not recognized. Opening failed.");
            }
        } catch (Exception e) {
            System.err.println("[AoW][OpenCurseforgeProcedure] Alternative method failed:");
            e.printStackTrace();
        }
    }
}
