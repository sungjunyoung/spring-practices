package ui;

import dao.PlayerDao;
import dao.TeamDao;
import model.Player;
import model.Team;
import org.apache.commons.lang.StringUtils;

/**
 * Created by junyoung on 2017. 5. 23..
 */
public class UpdatePlayerUi extends AbstractUi {

	private PlayerDao playerDao;
	private TeamDao teamDao;


	public void show() {
		Player player = getPlayer();
		if (player == null) {
			return;
		}
		String name = getName(player);
		if (StringUtils.isNotEmpty(name)) {
			player.setName(name);
		}


		Team team = getTeam(player);
		if (team != null) {
			player.setTeam(team);
		}

		this.playerDao.updatePlayer(player);
		System.out.printf("선수ID '%s' 인 선수를, 선수명 '%s', 팀 '%s'로 수정합니다.%n", player.getId(), player.getName(), player.getTeam().getName());

	}

	protected Player getPlayer() {
		final String playerId = "선수ID";
		showMenu(playerId);
		System.out.println("아무것도 입력하지 않고 Enter 를 누르면 메뉴로 돌아갑니다.");
		String id = getInputedString();
		if (StringUtils.isEmpty(id)) {
			return null;
		} else if (UiUtils.isNumeric(id, playerId)) {
			Player player = this.playerDao.getPlayer(Integer.valueOf(id));
			if (player == null) {
				System.out.printf("입력한 선수 ID '%s'인 선수는 존재하지 않습니다.%n", id);
				return getPlayer();
			}
			return player;
		}
		return getPlayer();
	}

	protected String getName(Player player) {
		final String playerName = "선수명";
		showMenu(playerName);
		System.out.println("아무것도 입력하지 않고 Enter 를 누르면 변경되지 않습니다.");
		System.out.printf("원래 값: %s%n", player.getName());
		String name = getInputedString();
		if(StringUtils.isEmpty(name)){
			return null;
		}

		if(UiUtils.isSmallLength(name, playerName, 128)){
			return name;
		}
		return getName(player);
	}

	protected Team getTeam(Player player){
		final String teamId = "팀ID";
		showMenu(teamId);
		System.out.println("아무것도 입력하지 않고 Enter 를 누르면 변경되지 않습니다.");
		System.out.printf("원래 값: %s %s%n", player.getTeam().getId(), player.getTeam().getName());
		String id = getInputedString();
		if(StringUtils.isEmpty(id)){
			return null;
		}

		if(UiUtils.isNumeric(id, teamId)){
			Team team = this.teamDao.getTeam(Integer.valueOf(id));
			if(team == null){
				System.out.printf("입력하신 팀명이 '%s' 인 팀은 존재하지 않습니다.%n", id);
				return getTeam(player);
			}
			return team;
		}
		return getTeam(player);
	}

	protected void showMenu(String wanted){
		System.out.println("-------------------");
		System.out.println("선수명단    선수갱신");
		System.out.println("");
		System.out.printf("%s 를 입력하신 후 Enter 를 눌렂쉐요", wanted);

	}

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}
}
