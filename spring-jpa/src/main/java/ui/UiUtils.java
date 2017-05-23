package ui;

import org.apache.commons.lang3.StringUtils;

public class UiUtils {

    public static boolean isSmallLength(String name, String fieldName, int length) {

        if (name == null) {
            return true;
        }

        if (length < name.length()) {
            System.out.printf( "%s��%s�������Ϸ� �Է����ּ���.%n", fieldName, length);
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String str, String fieldName) {
        // ��������?
        if (!StringUtils.isNumeric(str)) {
            System.out.printf("%s�� ���ڷ� �Է����ּ���.%n", fieldName);
            return false;
        }
        return true;
    }

}
