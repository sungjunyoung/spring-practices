package ui;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public abstract class AbstractUiTemplate extends AbstractUi {

    public void show() {
        // �޴� ǥ��
        showMenu();
        // �ֿܼ� �Էµ� ���� ���
        String inputedString = getInputedString();
        // �Էµ� ���ڿ��� ����
        if (isValidNumber(inputedString)) {
            // ó���� �⵿
            execute(NumberUtils.toInt(inputedString));
        }     
    }

    abstract protected void showMenu();

    abstract protected int getMaxMenuNumber();

    abstract protected int getMinMenuNumber();

    abstract protected void execute(int number);

    protected boolean isValidNumber(String str) {
        
        // ���ڿ��� �ԷµǾ�����?
        if (StringUtils.isBlank(str)) {
            return false;
        // ��������?
        } else if (!StringUtils.isNumeric(str)) {
            return false;
        }
        // �����̹Ƿ� int�� ��ȯ
        int number = NumberUtils.toInt(str);
        // ���ڰ� �޴��� ǥ�õ� ��ȣ�� ��������?
        if (getMinMenuNumber() <= number && number <= getMaxMenuNumber()) {
            return true;
        }
        return false;
    }
}
