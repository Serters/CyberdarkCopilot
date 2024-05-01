package cc.cyberdark.copilot.commands;

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

		switch (command) {
		case "horizontalflag":
			OptionMapping horizontalFlagOption = event.getOption("colors");
			event.reply(HorizontalFlag.horizontalFlag(horizontalFlagOption)).queue();
			break;
		case "verticalflag":
			OptionMapping verticalFlagOption = event.getOption("colors");
			event.reply(VerticalFlag.verticalFlag(verticalFlagOption)).queue();
			break;
		case "coloroptions":
			event.reply(ColorOptions.colorOptions()).queue();
			break;
		default:
			break;
		}
	}

	@Override
	public void onGuildReady(@NotNull GuildReadyEvent event) {
		List<CommandData> commandData = new ArrayList<>();

		commandData.add(Commands.slash("coloroptions", "Check out avalable colors for creating flags!"));

		OptionData option3 = new OptionData(OptionType.STRING, "colors", "Pick flag colors!", true);
		commandData.add(Commands.slash("horizontalflag", "Horizontal flag!").addOptions(option3));

		OptionData option4 = new OptionData(OptionType.STRING, "colors", "Pick flag colors!", true);
		commandData.add(Commands.slash("verticalflag", "Vertical flag!").addOptions(option4));

		event.getGuild().updateCommands().addCommands(commandData).queue();
	}

}
