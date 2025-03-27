package net.bcm.arcanumofwisdom.procedures;

import net.bcm.arcanumofwisdom.network.ArcanumOfWisdomModVariables;

public class StartupInfoMessageTeaserDisplayOverlayIngameProcedure {
	public static boolean execute() {
		return ArcanumOfWisdomModVariables.startup_message_teaser == true;
	}
}
