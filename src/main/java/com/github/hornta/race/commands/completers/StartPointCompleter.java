package com.github.hornta.race.commands.completers;

import com.github.hornta.BaseTabCompleter;
import com.github.hornta.race.RacingManager;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class StartPointCompleter implements BaseTabCompleter {
  private RacingManager racingManager;

  public StartPointCompleter(RacingManager plugin) {
    this.racingManager = plugin;
  }

  @Override
  public List<String> getItems(CommandSender sender, String[] arguments) {
    return racingManager.getRace(arguments[0]).getStartPoints().stream()
      .filter(point -> String.valueOf(point.getPosition()).toLowerCase(Locale.ENGLISH).startsWith(arguments[1].toLowerCase(Locale.ENGLISH)))
      .map(p -> String.valueOf(p.getPosition()))
      .collect(Collectors.toList());
  }
}