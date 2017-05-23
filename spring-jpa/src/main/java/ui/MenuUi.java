package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {
    
    private SelectEventUi selectEventUi;
    
    private SelectUserUi selectUserUi;
    
    public void setSelectEventUi(SelectEventUi selectEventUi) {
        this.selectEventUi = selectEventUi;
    }
    
    public void setSelectUserUi(SelectUserUi selectUserUi) {
        this.selectUserUi = selectUserUi;
    }

    protected void execute(int number) {
        switch (number) {
        case 1:
            System.out.println("종료되었습니다.");
            System.exit(0);
        case 2:
            this.selectEventUi.show();
            break;
        case 3:
            this.selectUserUi.show();
            break;
        }
    }

    protected int getMaxMenuNumber() {
        return 3;
    }

    protected int getMinMenuNumber() {
        return 1;
    }

    protected void showMenu() {
        System.out.println("--------------------");
        System.out.println("티켓예약            메뉴");
        System.out.println("");
        System.out.println("1.종료");
        System.out.println("2.이벤트 검색");
        System.out.println("3.예약완료 티켓 목록");
        System.out.println("");
        System.out.println("번호를 입력한 후 Enter 를 눌러주세요.");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuUi menuUi = context.getBean(MenuUi.class);
        while (true) {
            menuUi.show();
        }
    }
}
