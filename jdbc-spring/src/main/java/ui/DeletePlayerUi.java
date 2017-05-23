package ui;

import dao.PlayerDao;
import model.Player;
import org.apache.commons.lang.StringUtils;

/**
 * Created by junyoung on 2017. 5. 23..
 */
public class DeletePlayerUi extends AbstractUi {

	private PlayerDao playerDao;


	public void show() {
		showMenu();
		String id = getInputedString();
		if (StringUtils.isEmpty(id)) {
			return;
		} else if (UiUtils.isNumeric(id, "선수ID")) {
			Player player = this.playerDao.getPlayer(Integer.valueOf(id));
			if (player == null) {
				System.out.printf("입력한 선수 ID '%s'인 선수는 존재하지 않습니다.%n", id);
				show();
			} else {
				this.playerDao.deletePlayer(player);
				System.out.printf("선수ID '%s' 라는 선수를 삭제합니다.", id);
			}
		} else {
			show();
		}
	}

	public void showMenu(){
		System.out.println("--------------");
		System.out.println("선수 명단       선수 삭제");
		System.out.println("");
		System.out.println("선수 ID 를 입력한 후 Enter 를 눌러주세요");
		System.out.println("아무것도 입력하지 않고 Enter 를 누르면 메뉴로 돌아갑니다.");
	}

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
}
