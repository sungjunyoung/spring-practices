//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ui;

import dao.TeamDao;
import model.Team;

import java.util.Iterator;
import java.util.List;

public class SelectTeamUi extends AbstractUi {
  private TeamDao teamDao;

  public SelectTeamUi() {
  }

  public void setTeamDao(TeamDao var1) {
    this.teamDao = var1;
  }

  public void show() {
    this.showTeamList(this.teamDao.getTeamList());
    System.out.println("Enter를 눌러 주세요.");
    this.getInputedString();
  }

  protected void showTeamList(List<Team> var1) {
    System.out.println("--------------------");
    System.out.println("『선수 명단』「팀 목록」");
    System.out.println("ID    이름");
    Iterator var2 = var1.iterator();

    while(var2.hasNext()) {
      Team var3 = (Team)var2.next();
      System.out.printf("%d  %s%n", new Object[]{var3.getId(), var3.getName()});
    }

  }
}
