package com.github.rodriaum.broadcast.util;

import com.github.rodriaum.broadcast.PartnerBroadcast;
import net.md_5.bungee.api.CommandSender;

public class FormattedMessage {

    public static String setString(CommandSender sender, String path, String... replacements) {
        String message = PartnerBroadcast.getPlugin().getConfiguration().getString(path);
        for (int i = 0; i < replacements.length; i += 2) {
            message = message.replace(replacements[i], replacements[i + 1]);
        }

        return message.replace("&", "§").replace("%player%", sender.getName());
    }
}
