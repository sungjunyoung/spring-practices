package dao.impl;

import dao.TeamDao;
import model.Team;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by junyoung on 2017. 5. 23..
 */
public class TeamDaoImpl extends NamedParameterJdbcDaoSupport implements TeamDao {

	public List<Team> getTeamList() throws DataAccessException {
		RowMapper<Team> rowMapper = new TeamRowMapper();
		return getJdbcTemplate().query("SELECT team_id, name FROM team", rowMapper);
	}

	public Team getTeam(Integer teamId) throws DataAccessException {
		final String sql = "SELECT team_id, name FROM team WHERE team_id =:teamId";
		SqlParameterSource parameterSource = new MapSqlParameterSource("teamId", teamId);
		return getNamedParameterJdbcTemplate().query(sql, parameterSource, new TeamResultSetExtractor());
	}

	protected class TeamResultSetExtractor implements ResultSetExtractor<Team> {

		public Team extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			if(resultSet.next()){
				Team team = new Team();
				team.setId(resultSet.getInt("team_id"));
				team.setName(resultSet.getString("name"));
				return team;
			} else {
				return null;
			}
		}
	}

	private List<Team> teamList = new ArrayList<Team>();

	public List<Team> getResults() {
		return teamList;
	}

	protected class TeamRowMapper implements RowMapper<Team> {

		public Team mapRow(ResultSet resultSet, int i) throws SQLException {
			Team team = new Team();
			team.setId(resultSet.getInt("team_id"));
			team.setName(resultSet.getString("name"));

			return team;
		}
	}
}
