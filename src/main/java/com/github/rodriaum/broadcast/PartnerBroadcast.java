package com.github.rodriaum.broadcast;

import com.github.rodriaum.broadcast.command.DivulgarCommand;
import com.google.common.io.ByteStreams;
import lombok.Getter;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.*;

@Getter
public final class PartnerBroadcast extends Plugin {

    @Getter
    private static PartnerBroadcast plugin;
    private Configuration configuration;



    @Override
    public void onEnable() {
        plugin = this;
        this.getLogger().info("Initializing plugin...");
        loadConfigurations();

        getProxy().getPluginManager().registerCommand(this, new DivulgarCommand("divulgar"));
        this.getLogger().info("plugin Initialized");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("plugin disabled");
    }

    private void loadConfigurations() {
        try {

            if (!getDataFolder().exists()) {
                getDataFolder().mkdir();
            }

            File file = new File(getDataFolder(), "config.yml");

            if (!file.exists()) {
                try {
                    file.createNewFile();
                    try (InputStream is = getResourceAsStream("config.yml");
                         OutputStream os = new FileOutputStream(file)) {
                        ByteStreams.copy(is, os);
                    }
                } catch (IOException e) {
                    throw new RuntimeException("Não é possível criar o arquivo de configuração", e);
                }
            }

            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
