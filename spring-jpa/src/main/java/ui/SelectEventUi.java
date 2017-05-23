package ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.Event;

import org.apache.commons.lang3.StringUtils;

import dao.EventDao;

public class SelectEventUi extends AbstractUi {

	private static final String DATE_FORMAT_MESSAGE = "날짜는 YYYYMMDD 형식으로 입력해 주세요 (예: 20121229)";

	private EventDao eventDao;

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	public void show() {

		showHeader();
		showMenu("검색개시일");
		Date start = getDate();
		if (start == null) {
			return;
		}
		showMenu("검색종료일");
		Date end = getDate();
		if (end == null) {
			return;
		}
		if (start.compareTo(end) > 0) {
			System.out.println("검색 종료일에는 검색 개시일 이후의 날짜를 입력해주세요.");
			show();
			return;
		}
		List<Event> eventList = this.eventDao.getEventList(start, end);
		showEventList(eventList);

	}

	protected void showEventList(List<Event> eventList) {
		System.out.println("--------------------");
		System.out.println("티켓예약          이벤트 목록");
		System.out.println("ID    이름    날짜");

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

		for (Event event : eventList) {
			System.out.printf("%s  %s  %s%n", event.getEventId(), event.getName(), dateFormat.format(event.getDate()));
		}

	}

	protected Date getDate() {

		String dateString = getInputedString();
		if (StringUtils.isEmpty(dateString)) {
			return null;
		}

		if (dateString.length() != 8) {
			System.out.println(DATE_FORMAT_MESSAGE);
			return getDate();
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

		Date date;
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			System.out.println(DATE_FORMAT_MESSAGE);
			return getDate();
		}

		if (new Date().after(date)) {
			System.out.println("현재 기준으로 과거 날짜는 입력할 수 없습니다. 다시 입력하세요");
			return getDate();
		}

		return date;

	}

	protected void showHeader() {
		System.out.println("--------------------");
		System.out.println("티켓예약          이벤트 검색");
		System.out.println("");
	}

	protected void showMenu(String wanted) {
		System.out.printf("%s를 입력한 후 Enter 를 눌러주세요.%n", wanted);
		System.out.println("아무것도 입력하지 않고 Enter 를 누르면 메뉴로 돌아갑니다.");
		System.out.println(DATE_FORMAT_MESSAGE);
	}

}
