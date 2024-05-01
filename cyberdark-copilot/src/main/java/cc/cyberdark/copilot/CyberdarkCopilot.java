package cc.cyberdark.copilot;

import cc.cyberdark.utils.ColorUtils;
import cc.cyberdark.copilot.commands.CommandManager;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

public class CyberdarkCopilot {

	private ShardManager shardManager;

	public CyberdarkCopilot() throws LoginException {

		DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(System.getenv("TOKEN"));
		builder.setStatus(OnlineStatus.ONLINE);
		builder.setActivity(Activity.watching("you!"));

		this.shardManager = builder.build();
		this.shardManager.addEventListener(new CommandManager());
	}

	public static void main(String[] args) {

		ColorUtils.importBackgroundColors("discord_colors");

		try {
			System.out.println("Cyberdark Copilot:");
			CyberdarkCopilot cyberdarkCopilot = new CyberdarkCopilot();
		} catch (LoginException e) {
			e.printStackTrace();
		}

	}

}
