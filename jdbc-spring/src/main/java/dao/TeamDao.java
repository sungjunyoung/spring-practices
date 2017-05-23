package dao;

import model.Team;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by junyoung on 2017. 5. 23..
 */
public interface TeamDao {
	List<Team> getTeamList() throws DataAccessException;
	Team getTeam(Integer teamId) throws DataAccessException;
}
