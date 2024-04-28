package cc.cyberdark.copilot.commands;

import cc.cyberdark.copilot.flags.*;
import cc.cyberdark.copilot.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

public class CommandManager extends ListenerAdapter {

	@Override
	public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
		String command = event.getName();
		if (command.equals("welcome")) { // welcome
			event.reply("welcome").queue();
		} else if (command.equals("parrot")) {
			OptionMapping messageOption = event.getOption("message");
			event.reply(messageOption.getAsString()).queue();
		} else if (command.equals("flagtest")) {
			System.out.println("cat1");
			DiscordHorizontalFlag dhf = new DiscordHorizontalFlag("BlueishBlack", "LightGray", "RustBrown");
			String temp = dhf.gen();
			event.reply(temp).queue();
		} else if (command.equals("horizontalflag")) {
			OptionMapping messageOption = event.getOption("colors");
			String userColors = messageOption.getAsString();
			String[] flagColors = Utils.colorsParser(userColors);
			
			DiscordHorizontalFlag dhf = new DiscordHorizontalFlag(flagColors);
			String dhfs = dhf.gen();
			event.reply(dhfs).queue();
		} else if (command.equals("verticalflag")) {
			OptionMapping messageOption = event.getOption("colors");
			String userColors = messageOption.getAsString();
			String[] flagColors = Utils.colorsParser(userColors);
			
			DiscordVerticalFlag dvf = new DiscordVerticalFlag(flagColors);
			String dvfs = dvf.gen();
			event.reply(dvfs).queue();
		}
		
	}

	@Override
	public void onGuildReady(@NotNull GuildReadyEvent event) {
		List<CommandData> commandData = new ArrayList<>();
		commandData.add(Commands.slash("welcome", "welcome!"));

		OptionData option1 = new OptionData(OptionType.STRING, "message", "your message", true);
		commandData.add(Commands.slash("parrot", "parrot!").addOptions(option1));

		OptionData option2 = new OptionData(OptionType.STRING, "hv", "h/v", true);
		commandData.add(Commands.slash("flagtest", "FlagTest!"));
		
		OptionData option3 = new OptionData(OptionType.STRING, "colors", "Pick flag colors!", true);
		commandData.add(Commands.slash("horizontalflag", "Horizontal flag!").addOptions(option3));
		
		OptionData option4 = new OptionData(OptionType.STRING, "colors", "Pick flag colors!", true);
		commandData.add(Commands.slash("verticalflag", "Vertical flag!").addOptions(option4));
		
		event.getGuild().updateCommands().addCommands(commandData).queue();
	}

}
