package fr.catsuri33.lguhc.tools;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ScoreboardLib {

    private Scoreboard scoreboard;

    private String title;
    private Map<String, Integer> scores;
    private List<Team> teams;

    public ScoreboardLib(String title){

        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        this.title = title;
        this.scores = Maps.newLinkedHashMap();
        this.teams = Lists.newArrayList();

    }

    public void blank(){

        add("  ");

    }

    public void add(String arg0){

        add(arg0, null);

    }

    public void add(String arg0, Integer score){

        Preconditions.checkArgument(arg0.length() < 48, "Text cannot be over 48 characters in length !");
        arg0 = fixDuplicates(arg0);
        scores.put(arg0, score);

    }

    private String fixDuplicates(String arg0){

        while(scores.containsKey(arg0)){
            arg0 += "§r";
        }

        if(arg0.length() > 48){
            arg0 = arg0.substring(0, 47);
        }
        return arg0;
    }

    public Team newTeam(String name){

        Team team = scoreboard.registerNewTeam(name);
        return team;

    }

    private Map.Entry<Team, String> createTeam(String text){

        String result = "";
        if(text.length() <= 16){
            return new AbstractMap.SimpleEntry<>(null, text);
        }
        Team team = scoreboard.registerNewTeam("text-" + scoreboard.getTeams().size());
        Iterator<String> iterator = Splitter.fixedLength(16).split(text).iterator();
        team.setPrefix(iterator.next());
        if(text.length() > 32){
            team.setSuffix(iterator.next());
        }
        teams.add(team);
        return new AbstractMap.SimpleEntry<>(team, result);
    }

    @SuppressWarnings("deprecation")
    public void build(){

        final Objective objective = scoreboard.registerNewObjective(title.length() > 16 ? title.substring(0, 15) : title, "dummy");
        objective.setDisplayName(title);
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        int index = scores.size();
        for(final Map.Entry<String, Integer> text : scores.entrySet()){
            final Map.Entry<Team, String> team = createTeam(text.getKey());
            Integer score = text.getValue() != null ? text.getValue() : index;
            String value = team.getValue();
            if(team.getKey() != null){
                team.getKey().addEntry(value);
            }
            objective.getScore(value).setScore(score);
        }

    }

    public void reset(){

        title = null;
        scores.clear();
        for(Team t : teams){
            t.unregister();
        }
        teams.clear();
    }

    public Scoreboard getScoreboard(){ return scoreboard; }

    public void send(Player... onlinePlayers){

        for(Player onlinePlayer : onlinePlayers){
            onlinePlayer.setScoreboard(scoreboard);
        }

    }

}
