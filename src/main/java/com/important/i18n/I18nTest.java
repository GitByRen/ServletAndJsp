package com.important.i18n;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class I18nTest {

	/**
	 * ResourceBundle:资源包类
	 * 1.在类路径下需要有对应的资源文件
	 * 2.要求所有资源的key必须完全一致
	 */
	public void testResourceBundle() {
		// 根据Locale动态的定位资源文件 i18n_en_US.properties  i18n_zh_CN.properties
		Locale locale = Locale.US;
		ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n", locale);
		System.out.println(resourceBundle.getString("date"));
		System.out.println(resourceBundle.getString("salary"));
	}
	
	/**
	 * 可以格式化模式字符串
	 */
	@Test
	public void testMessageFormat() {
		String str = "Date:{0},Salary:{1}";
		Date date = new Date();
		double sal = 12345.12;
		// String result = MessageFormat.format(str, date, sal);

		Locale locale = Locale.CHINA;
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		String dateFor = dateFormat.format(date);

		NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
		String numFor = currencyInstance.format(sal);

		String result = MessageFormat.format(str, dateFor, numFor);
		System.out.println(result);
	}
	
	/**
	 * NumberFormat：格式化数字到数字字符串，或货币字符串的工具类.
	 * @throws ParseException 
	 */
	@Test
	public void testNumberFormat() throws ParseException {
		double d = 123456789.123d;
		Locale locale = Locale.FRANCE;
		
		// 仅格式化为数字的字符串
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
		String format = numberFormat.format(d);
		System.out.println(format);
		
		// 格式为货币的字符串
		NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance(locale);
		format = numberFormat2.format(d);
		System.out.println(format);
		
		// 将字符串解析为Numer类型
		format = "123456789,123";
		d = (Double) numberFormat.parse(format);
		System.out.println(d);
	}
	
	/**
	 * 1. 可以获取只格式化Date的DateFormat对象：getDateInstance(int style, Locale aLocale)
	 * 2. 可以获取只格式化Time的DateFormat对象：getTimeInstance(int style, Locale aLocale)
	 * 3. 可以获取既格式化Date,也格式化Time的DateFormat对象：getDateTimeInstance(int dateStyle, int timeStyle, Locale aLocale)
	 * 4. 其中style可以取值为：DateFormat的常量：SHORT, MEDIUM, LONG, FULL
	 */
	@Test
	public void testDateFormat() {
		Locale locale = Locale.CHINA;
		Date date = new Date();
		// 获取DateFormat对象
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, locale);
		String format = dateFormat.format(date);
		System.out.println(format);
	}

	/**
	 * Locale：Java中表示国家或地区的类，JDK中提供了很多常量.
	 */
	@Test
	public void testLocale() {
		Locale locale = Locale.CHINA;
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getLanguage());
	}

}
