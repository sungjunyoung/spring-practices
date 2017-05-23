package dao.impl;

import model.Player;
import model.Team;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by junyoung on 2017. 5. 23..
 */
public class PlayerQuery extends MappingSqlQuery<Player> {
	private static String SQL_PLAYER_QUERY = "SELECT player_id, player.name AS playerName, " +
					"team.team_id, team.name AS teamName " +
					"FROM player, team WHERE player.team_id = team.team_id AND player_id = ?";

	public PlayerQuery(DataSource ds){
		super(ds, SQL_PLAYER_QUERY);
		super.declareParameter(new SqlParameter("player_id", Types.INTEGER));
		compile();
	}


	protected Player mapRow(ResultSet resultSet, int i) throws SQLException {
		Player player = new Player();
		player.setId(resultSet.getInt("player_id"));
		player.setName(resultSet.getString("playerName"));
		Team team = new Team();
		team.setId(resultSet.getInt("team_id"));
		team.setName(resultSet.getString("teamName"));
		player.setTeam(team);

		return player;
	}
}
