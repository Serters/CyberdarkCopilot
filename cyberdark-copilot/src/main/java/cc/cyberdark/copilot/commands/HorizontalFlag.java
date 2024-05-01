package cc.cyberdark.copilot.commands;

import cc.cyberdark.copilot.flags.DiscordHorizontalFlag;
import cc.cyberdark.copilot.utils.Utils;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class HorizontalFlag {

	public static String horizontalFlag(OptionMapping messageOption) {

		String userColors = messageOption.getAsString();
		String[] flagColors = Utils.colorsParser(userColors);

		DiscordHorizontalFlag horizontalFlag = new DiscordHorizontalFlag(flagColors);
		String flag = horizontalFlag.gen();

		return flag;

	}

}
