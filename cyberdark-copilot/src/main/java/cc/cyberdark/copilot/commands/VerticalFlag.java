package cc.cyberdark.copilot.commands;

import cc.cyberdark.copilot.flags.DiscordVerticalFlag;
import cc.cyberdark.copilot.utils.Utils;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class VerticalFlag {

	public static String verticalFlag(OptionMapping messageOption) {

		String userColors = messageOption.getAsString();
		String[] flagColors = Utils.colorsParser(userColors);

		DiscordVerticalFlag verticalFlag = new DiscordVerticalFlag(flagColors);
		String flag = verticalFlag.gen();

		return flag;

	}

}
