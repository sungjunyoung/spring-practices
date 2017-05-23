package ui;

/**
 * Created by junyoung on 2017. 5. 23..
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {
	private SelectTeamUi selectTeamUi;
	private InsertPlayerUi insertPlayerUi;
	private SelectPlayerUi selectPlayerUi;

	public SelectTeamUi getSelectTeamUi() {
		return selectTeamUi;
	}

	public InsertPlayerUi getInsertPlayerUi() {
		return insertPlayerUi;
	}

	public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
		this.selectTeamUi = selectTeamUi;
	}

	public void setInsertPlayerUi(InsertPlayerUi insertPlayerUi) {
		this.insertPlayerUi = insertPlayerUi;
	}

	public void setSelectPlayerUi(SelectPlayerUi selectPlayerUi) {
		this.selectPlayerUi = selectPlayerUi;
	}


	protected void showMenu() {
		System.out.println("--------------");
		System.out.println("선수명단  메뉴");
		System.out.println("");
		System.out.println("1. 종료");
		System.out.println("2. 팀 목록");
		System.out.println("3. 선수 추가");
		System.out.println("4. 선수 목록");
		System.out.println("");
		System.out.println("번호를 입력한 후 Enter 키를 누르세요");
	}

	protected int getMaxMenuNumber() {
		return 4;
	}

	protected int getMinMenuNumber() {
		return 1;
	}

	protected void execute(int number) {
		switch (number) {
			case 1:
				System.out.println("종료되었습니다.");
				System.exit(0);
				break;
			case 2:
				this.selectTeamUi.show();
				break;
			case 3:
				this.insertPlayerUi.show();
				break;
			case 4:
				this.selectPlayerUi.show();
				break;
		}
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MenuUi menuUi = context.getBean(MenuUi.class);
		while (true) {
			menuUi.show();
		}
	}

}

