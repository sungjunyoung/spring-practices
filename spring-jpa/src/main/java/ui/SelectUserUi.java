package ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import model.Ticket;
import model.User;

import org.apache.commons.lang3.StringUtils;

import dao.TicketDao;
import dao.UserDao;

public class SelectUserUi extends AbstractUi {

	private UserDao userDao;

	private TicketDao ticketDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	public void show() {
		showHeader();
		showMenu("유저명");
		String userName = getInputedString();
		if (StringUtils.isEmpty(userName)) {
			return;
		}
		User user = this.userDao.getUser(userName);
		if (user == null) {
			System.out.printf("입력된 유저명 '%s'는 존재하지 않습니다.%n", userName);
			show();
			return;
		}
		showUser(user);
		List<Ticket> ticketList = this.ticketDao.getBookedTicketList(user.getUserId());
		showBookedTikectList(ticketList);

	}

	protected void showBookedTikectList(List<Ticket> ticketList) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		System.out.println("ID   이벤트명     날짜   가격    예약일시");
		for (Ticket ticket : ticketList) {
			System.out.printf("%s  %s  %s  %s  %s%n", ticket.getTicketId(), ticket.getEvent().getName(), dateFormat
					.format(ticket.getEvent().getDate()), ticket.getRank().getPrice(), dateFormat.format(ticket
					.getReservation().getTimestamp()));
		}
	}

	protected void showUser(User user) {
		System.out.println("--------------------");
		System.out.println("티켓예약      예약완료티켓목록");
		System.out.println("ID    �이름");
		System.out.printf("%s  %s%n", user.getUserId(), user.getName());
	}

	protected void showHeader() {
		System.out.println("--------------------");
		System.out.println("티켓예약        예약완료티켓목록");
		System.out.println("");
	}

	protected void showMenu(String wanted) {
		System.out.printf("%s를 입력하신 후 Enter를 눌러주세요.%n", wanted);
		System.out.println("아무것도 입력하지 않고 Enter 를 누르면 메뉴로 돌아갑니다.");
	}
}
