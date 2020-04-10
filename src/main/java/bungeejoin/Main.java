package bungeejoin;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class Main extends Plugin implements Listener {
    @Override
    public void onEnable() {
        // You should not put an enable message in your plugin.
        // BungeeCord already does so
    	getProxy().getPluginManager().registerListener(this,this);
        getLogger().info("Yay! It loads!");
    }
    @EventHandler
    public void onPostLogin(PostLoginEvent event) {
    	for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
            player.sendMessage(new TextComponent(event.getPlayer().getName() + " さんがログインしました。"));
        }

    	getLogger().info("Yay! It login!");
    	//getProxy().broadcast(new TextComponent( event.getPlayer().getName() + "Your Text here"));
    }
    @EventHandler
    public void onQuit(PlayerDisconnectEvent event) {
    	for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
            player.sendMessage(new TextComponent(event.getPlayer().getName() + " さんがログアウトしました。"));
        }

    	getLogger().info("Yay! It logout!");
    	//getProxy().broadcast(new TextComponent( event.getPlayer().getName() + "Your Text here"));
    }
}
