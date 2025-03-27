package net.bcm.arcanumofwisdom.procedures;

import java.awt.Desktop;
import java.net.URI;

public class OpenGithubProcedure {
    public static void execute() {
        String url = "https://github.com/benl4b";

        try {
            System.out.println("[AoW][OpenGithubProcedure] Attempting to open the website: " + url);

            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(new URI(url));
                    System.out.println("[AoW][OpenGithubProcedure] Website successfully opened.");
                } else {
                    System.err.println("[AoW][OpenGithubProcedure] BROWSE action is not supported!");
                }
            } else {
                System.err.println("[AoW][OpenGithubProcedure] Desktop is not supported! Trying alternative method...");
                openWithRuntime(url);
            }
        } catch (Exception e) {
            System.err.println("[AoW][OpenGithubProcedure] Error while opening the website:");
            e.printStackTrace();
            openWithRuntime(url);
        }
    }

    private static void openWithRuntime(String url) {
        try {
            System.out.println("[AoW][OpenGithubProcedure] Attempting to open browser via Runtime...");
            
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (os.contains("mac")) {
                Runtime.getRuntime().exec("open " + url);
            } else if (os.contains("nix") || os.contains("nux") || os.contains("bsd")) {
                Runtime.getRuntime().exec("xdg-open " + url);
            } else {
                System.err.println("[AoW][OpenGithubProcedure] Operating system not recognized. Opening failed.");
            }
        } catch (Exception e) {
            System.err.println("[AoW][OpenGithubProcedure] Alternative method failed:");
            e.printStackTrace();
        }
    }
}
