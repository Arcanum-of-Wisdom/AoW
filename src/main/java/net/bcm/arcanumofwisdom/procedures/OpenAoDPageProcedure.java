package net.bcm.arcanumofwisdom.procedures;

import java.awt.Desktop;
import java.net.URI;
import com.mojang.blaze3d.audio.OpenAlUtil;

public class OpenAoDPageProcedure {
    public static void execute() {
        String url = "https://github.com/Arcanum-of-Wisdom/AoW/discussions/2#discussioncomment-12584509";

        try {
            System.out.println("[AoW][OpenAoDPageProcedure] Attempting to open the website: " + url);

            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(new URI(url));
                    System.out.println("[AoW][OpenAoDPageProcedure] Website successfully opened.");
                } else {
                    System.err.println("[AoW][OpenAoDPageProcedure] BROWSE action is not supported!");
                }
            } else {
                System.err.println("[AoW][OpenAoDPageProcedure] Desktop is not supported! Trying alternative method...");
                openWithRuntime(url);
            }
        } catch (Exception e) {
            System.err.println("[AoW][OpenAoDPageProcedure] Error while opening the website:");
            e.printStackTrace();
            openWithRuntime(url);
        }
    }

    private static void openWithRuntime(String url) {
        try {
            System.out.println("[AoW][OpenAoDPageProcedure] Attempting to open browser via Runtime...");
            
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (os.contains("mac")) {
                Runtime.getRuntime().exec("open " + url);
            } else if (os.contains("nix") || os.contains("nux") || os.contains("bsd")) {
                Runtime.getRuntime().exec("xdg-open " + url);
            } else {
                System.err.println("[AoW][OpenAoDPageProcedure] Operating system not recognized. Opening failed.");
            }
        } catch (Exception e) {
            System.err.println("[AoW][OpenAoDPageProcedure] Alternative method failed:");
            e.printStackTrace();
        }
    }
}
