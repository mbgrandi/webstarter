package com.example.webstarter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.webstarter.model.Chart;
import com.example.webstarter.model.Order;

public class General {
	
	public static final String[] MONTHS = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	
	public static final Integer CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	
	public static String currencyFormat(BigDecimal n) {
	    return NumberFormat.getCurrencyInstance().format(n);
	}
	
	public static boolean isNumeric(String str) {
		NumberFormat formatter = NumberFormat.getInstance();
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(str, pos);
		return str.length() == pos.getIndex();
	}
	
	public static Chart buildChartMonths(List<Order> orders, Integer year) {
		Calendar cal = Calendar.getInstance();
		String[] data = new String[12];
		BigDecimal[] sum = new BigDecimal[12];
		Arrays.fill(sum, new BigDecimal(0));
		
		for (Order order : orders) {
			Date orderDate = order.getOrderDate(order.getOrderDate(), "yyyy-MM-dd HH:mm:ss");
			cal.setTime(orderDate);
			if (cal.get(Calendar.YEAR) == year) {
				for (int j = 0; j < MONTHS.length; j++) {
					if (cal.get(Calendar.MONTH) == j) {
						sum[j] = sum[j].add(order.getOrderTotal());
					}
				}
			}
		}
		
		for (int i = 0; i < sum.length; i++) {
			data[i] = sum[i].toString();
		}
		
		Chart chart = new Chart(MONTHS, data);
		return chart;
	}
}
