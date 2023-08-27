package com.github.rodriaum.broadcast.command;

import com.github.rodriaum.broadcast.PartnerBroadcast;
import com.github.rodriaum.broadcast.util.FormattedMessage;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class DivulgarCommand extends Command {

    public DivulgarCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(FormattedMessage.setString(sender, "messages.is-console"));
            return;
        }

        if (!sender.hasPermission((FormattedMessage.setString(sender, "permissions.broadcast-partner")))) {
            sender.sendMessage(FormattedMessage.setString(sender, "messages.without-permission"));
            return;
        }

        if (args.length == 0) {
            sender.sendMessage(FormattedMessage.setString(sender, "messages.usage-correct"));
            return;
        }

        PartnerBroadcast.getPlugin().getProxy().broadcast(
                FormattedMessage.setString(sender, "messages.broadcast-partner").replace("%link%", args[0]));

    }
}
