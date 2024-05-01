package cc.cyberdark.copilot.commands;

public class ColorOptions {
	
	public static String colorOptions() {
		
		String colors = "```ANSI\r\n"
				+ "\033[2;40m BlueishBlack \r\n"
				+ "\033[2;41m RustBrown    \r\n"
				+ "\033[2;42m Gray         \r\n"
				+ "\033[2;46m LightGray    \r\n"
				+ "\033[2;45m Blurple      \r\n"
				+ "\033[2;47m CreamWhite   \r\n"
				+ "```";
		return colors;
		
	}

}
