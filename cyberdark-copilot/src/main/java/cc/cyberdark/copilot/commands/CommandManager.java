package cc.cyberdark.copilot.commands;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class CommandManager extends ListenerAdapter{
	
	@Override
	public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
		String command = event.getName();
		if (command.equals("welcome")) { //welcome
			String userTag = event.getUser().getAsTag();
			event.reply("Welcome " + userTag+ "!").queue();
		}
	}
	
	@Override
	public void onGuildReady(@NotNull GuildReadyEvent event) {
		List<CommandData> commandData = new ArrayList<>();
		commandData.add(Commands.slash("welcome", "welcome!"));
		event.getGuild().updateCommands().addCommands(commandData).queue();
	}
}
