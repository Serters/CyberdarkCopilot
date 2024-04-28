package cc.cyberdark.copilot.flags;

import cc.cyberdark.flags.VerticalPlainFlag;

public class DiscordVerticalFlag extends VerticalPlainFlag {
	public DiscordVerticalFlag(String... colors) {
		super(21, 12, colors);
	}

	@Override
	public String[] generate() {
		String[] output = new String[14];
		String[] flag = super.generate();

		output[0] = "```ANSI";
		for (int i = 1; i < 13; ++i) {
			output[i] = flag[i - 1];
		}
		output[13] = "```";

		return output;
	}

	public String gen() {
		return String.join("\n", generate());
	}

}
