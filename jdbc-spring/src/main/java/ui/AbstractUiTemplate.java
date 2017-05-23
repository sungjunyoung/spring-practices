package ui;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * Created by junyoung on 2017. 5. 23..
 */
public abstract class AbstractUiTemplate extends AbstractUi {
	public void show(){
		showMenu();
		String inputedString = getInputedString();
		if(isValidNumber(inputedString)){
			execute(NumberUtils.toInt(inputedString));
		}
	}

	abstract protected void showMenu();
	abstract protected int getMaxMenuNumber();
	abstract protected int getMinMenuNumber();
	abstract protected void execute(int number);
	protected boolean isValidNumber(String str){
		if(StringUtils.isEmpty(str)){
			return false;
		} else if(!StringUtils.isNumeric(str)){
			return false;
		}

		int number = NumberUtils.toInt(str);
		if(getMinMenuNumber() <= number  && number <= getMaxMenuNumber()){
			return true;
		}
		return false;
	}
}
