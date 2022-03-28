package rip.hippo.consolefilter;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Locale;

/**
 * @author Hippo
 */
public final class ConsoleFilter extends JavaPlugin {

  @Override
  public void onEnable() {
    saveDefaultConfig();
    List<String> list = getConfig().getStringList("blocked");
    getServer().getLogger().setFilter(record -> {
      for (String line : list) {
        if (record.getMessage().toLowerCase(Locale.ROOT).startsWith(line.toLowerCase(Locale.ROOT))) {
          return true;
        }
      }
      return false;
    });
  }
}
