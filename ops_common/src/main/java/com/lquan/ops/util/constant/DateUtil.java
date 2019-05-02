package com.lquan.ops.util.constant;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
	public static final long HOUR_MILLI = 3600000L;
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	public static final String YYYYNMMYDDR = "yyyy年MM月dd日";
	public static final String YYYYMMDD_HHMMSS = "yyyyMMdd_HHmmss";
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String YYYYMMDD_HHMM = "yyyyMMdd HHmm";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYY_MM = "yyyy-MM";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String YYYYMM = "yyyyMM";
	public static final String YYYY = "yyyy";
	public static final String MM_dd = "MM-dd";
	public static final String MMdd = "MMdd";
	public static final String MM = "MM";
	public static final String HH_mm = "HH:mm";
	public static final String HH_mm_ss = "HH:mm:ss";
	public static final String HHmm = "HHmm";
	public static final String MM_dd_HH_mm = "MM-dd HH:mm";

	public DateUtil() {
	}

	public static String date2String(Date dDate, String sFormat) {
		if (dDate == null) {
			return "";
		} else {
			if (StringUtil.isEmpty(sFormat)) {
				sFormat = "yyyy-MM-dd";
			}

			SimpleDateFormat sdf = new SimpleDateFormat(sFormat);
			return sdf.format(dDate);
		}
	}

	public static Date getAfterMonth(Date date, int month) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(2, month);
		date = c.getTime();
		return date;
	}

	public static long daysBetweenForHour(Date t1, Date t2) {
		Timestamp time1 = new Timestamp(t1.getTime());
		Timestamp time2 = new Timestamp(t2.getTime());
		return daysBetweenForHour(time1, time2);
	}

	public static long daysBetweenForHour(Timestamp t1, Timestamp t2) {
		return (t2.getTime() - t1.getTime()) / 3600000L;
	}

	public static Date string2Date(String str, String format) {
		if (StringUtil.isEmpty(str)) {
			return null;
		} else {
			Date result = null;
			if (StringUtil.isEmpty(format)) {
				return string2Date(str);
			} else {
				try {
					SimpleDateFormat e = new SimpleDateFormat(format);
					result = e.parse(str);
				} catch (Exception var4) {
					var4.printStackTrace();
				}

				return result;
			}
		}
	}

	public static long daysDiff(Date startDate, Date endDate) {
		Date start = string2Date(date2String(startDate, "yyyy-MM-dd"), "yyyy-MM-dd");
		Date end = string2Date(date2String(endDate, "yyyy-MM-dd"), "yyyy-MM-dd");
		long startTime = start.getTime();
		long endTime = end.getTime();
		return (endTime - startTime) / 86400000L;
	}

	public static int daysDiff2(Date startDate, Date endDate) {
		Date start = string2Date(date2String(startDate, "yyyy-MM-dd"), "yyyy-MM-dd");
		Date end = string2Date(date2String(endDate, "yyyy-MM-dd"), "yyyy-MM-dd");
		long startTime = start.getTime();
		long endTime = end.getTime();
		return (int) ((endTime - startTime) / 86400000L);
	}

	public static long dayDiff2(Date date1, Date date2) {
		return (date2.getTime() - date1.getTime()) / 86400000L;
	}

	public static Date string2Date(String s) {
		if (StringUtil.isEmpty(s)) {
			return null;
		} else {
			Date result = null;

			try {
				SimpleDateFormat e = null;
				if (s.length() > 15) {
					e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				} else if (s.length() > 8) {
					e = new SimpleDateFormat("yyyy-MM-dd");
				} else if (s.length() > 4) {
					e = new SimpleDateFormat("yyyy-MM");
				} else {
					e = new SimpleDateFormat("yyyy");
				}

				result = e.parse(s);
			} catch (Exception var3) {
				var3.printStackTrace();
			}

			return result;
		}
	}

	public static java.sql.Date str2SqlDate(String str, String sFormat) {
		Date date = string2Date(str, sFormat);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}

	public static String getMillisecond() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmsssss");
		String result = sdf.format(calendar.getTime());
		return result;
	}

	public static String getCurrentYearMonth() {
		String res = "";
		Calendar caldTmp = Calendar.getInstance();
		caldTmp.setTime(new Date());
		if (caldTmp.get(2) + 1 < 10) {
			res = caldTmp.get(1) + "0" + (caldTmp.get(2) + 1);
		} else {
			res = caldTmp.get(1) + "" + (caldTmp.get(2) + 1);
		}

		return res;
	}

	public static String getCurrentData() {
		return getCurrentTimeFormated("yyyy-MM-dd");
	}

	public static String getCurrentDataTime() {
		return getCurrentTimeFormated("yyyy-MM-dd HH:mm:ss");
	}

	public static String getCurrentMonth() {
		return getCurrentTimeFormated("MM");
	}

	public static String getCurrentYear() {
		return getCurrentTimeFormated("yyyy");
	}

	public static String getCurrentTimeFormated(String format) {
		return date2String(new Date(), format);
	}

	public static Date addMonths(Date dateInput, int numberOfMonth) {
		if (dateInput == null) {
			return null;
		} else {
			Calendar c = Calendar.getInstance();
			c.setTime(dateInput);
			c.add(2, numberOfMonth);
			return c.getTime();
		}
	}

	public static Date addSecond(Date dInput, int numberOfSecond) {
		if (dInput == null) {
			return null;
		} else {
			Calendar c = Calendar.getInstance();
			c.setTime(dInput);
			c.add(13, numberOfSecond);
			return c.getTime();
		}
	}

	public static long minuteDistance(String beginTim, String endTime) {
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long between = 0L;

		try {
			Date ex = dfs.parse(beginTim);
			Date end = dfs.parse(endTime);
			between = end.getTime() - ex.getTime();
		} catch (Exception var7) {
			var7.printStackTrace();
		}

		return between / 1000L;
	}

	public static Date nextDate(Date date, int day) {
		if (date == null) {
			return null;
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(5, calendar.get(5) + day);
			return calendar.getTime();
		}
	}

	public static boolean isLeapYear(int theYear) {
		return theYear % 4 == 0 && theYear % 100 != 0 || theYear % 400 == 0;
	}

	public static boolean compareDate(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);
		int result = c1.compareTo(c2);
		return result >= 0;
	}

	// 大于
	public static boolean compareDate2(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);
		int result = c1.compareTo(c2);
		return result > 0;
	}

	public static int dateDiff(String type, Date fromDate, Date toDate) {
		Calendar fromCalendar = Calendar.getInstance();
		fromCalendar.setTime(fromDate);
		Calendar toCalendar = Calendar.getInstance();
		toCalendar.setTime(toDate);
		int fromDay = fromCalendar.get(6);
		int toDay = toCalendar.get(6);
		int fromMonth = fromCalendar.get(2);
		int toMonth = toCalendar.get(2);
		int fromYear = fromCalendar.get(1);
		int toYear = toCalendar.get(1);
		int fromHour = fromCalendar.get(11);
		int toHour = toCalendar.get(11);
		int fromMinute = fromCalendar.get(12);
		int toMinute = toCalendar.get(12);
		int fromSecond = fromCalendar.get(13);
		int toSecond = toCalendar.get(13);
		int day = 0;
		int month = 0;
		int minute = 0;
		int second = 0;
		int hour = 0;

		int daydiff;
		for (daydiff = fromYear; daydiff < toYear; ++daydiff) {
			short hourdiff;
			if (isLeapYear(daydiff)) {
				hourdiff = 366;
			} else {
				hourdiff = 365;
			}

			day += hourdiff;
			hour += hourdiff * 24;
			minute += hourdiff * 24 * 60;
			second += minute * 60;
			month += 12;
		}

		daydiff = toDay - (fromDay - day);
		int var26 = toHour - (fromHour - hour) + daydiff * 24;
		int minutediff = toMinute - (fromMinute - minute) + var26 * 60;
		int secdiff = toSecond - (fromSecond - second) + minutediff * 60;
		if ("yyyy".equalsIgnoreCase(type)) {
			return toYear - fromYear;
		} else if ("m".equalsIgnoreCase(type)) {
			return toMonth - (fromMonth - month);
		} else if ("d".equalsIgnoreCase(type)) {
			return daydiff;
		} else if ("h".equalsIgnoreCase(type)) {
			return var26;
		} else if ("n".equalsIgnoreCase(type)) {
			return minutediff;
		} else if ("s".equalsIgnoreCase(type)) {
			return secdiff;
		} else {
			return 0;
		}
	}

	public static int dateDiffNoTime(Date fromDate, Date toDate) {
		Calendar fromCalendar = Calendar.getInstance();
		fromCalendar.setTime(fromDate);
		Calendar toCalendar = Calendar.getInstance();
		toCalendar.setTime(toDate);
		int fromDay = fromCalendar.get(6);
		int toDay = toCalendar.get(6);
		int fromMonth = fromCalendar.get(2);
		int toMonth = toCalendar.get(2);
		int fromYear = fromCalendar.get(1);
		int toYear = toCalendar.get(1);
		int fromDateVal = fromYear * 10000 + fromMonth * 100 + fromDay * 1;
		int toDateVal = toYear * 10000 + toMonth * 100 + toDay * 1;
		return fromDateVal - toDateVal;
	}

	public static String getFirstDateOfMonth(String strYYYYMMDD) {
		Calendar caldTmp = Calendar.getInstance();
		caldTmp.set(getIntYearOfDate(strYYYYMMDD), getIntMonthOfDate(strYYYYMMDD) - 1, 1);
		return date2String(caldTmp.getTime(), "yyyy-MM-dd");
	}

	public static String getLastDateOfMonth(String strYYYYMMDD) {
		Calendar caldTmp = Calendar.getInstance();
		caldTmp.set(getIntYearOfDate(strYYYYMMDD), getIntMonthOfDate(strYYYYMMDD) - 1, 1);
		caldTmp.add(2, 1);
		caldTmp.add(5, -1);
		return date2String(caldTmp.getTime(), "yyyy-MM-dd");
	}

	public static String getMondayOfThisWeek(String strYYYYMMDD) {
		Calendar caldTmp = Calendar.getInstance();
		caldTmp.set(getIntYearOfDate(strYYYYMMDD), getIntMonthOfDate(strYYYYMMDD) - 1, getIntDayOfDate(strYYYYMMDD));
		int nDayOfWeek = caldTmp.get(7);
		caldTmp.add(5, -(caldTmp.get(7) - 1));
		if (nDayOfWeek == 1) {
			caldTmp.add(5, -6);
		} else {
			caldTmp.add(5, 1);
		}

		return date2String(caldTmp.getTime(), "yyyy-MM-dd");
	}

	public static String getSundayOfThisWeek(String strYYYYMMDD) {
		String strThisWeekFirstDate = getMondayOfThisWeek(strYYYYMMDD);
		return date2String(getOffsetDate(strThisWeekFirstDate, 6, "day"), "yyyy-MM-dd");
	}

	public static String getMondayOfWeek(String strYYYYMMDD, int weekIndex) {
		boolean nYear = false;
		boolean nMonth = false;
		boolean nDay = false;
		Calendar caldTmp = Calendar.getInstance();
		int nYear1 = getIntYearOfDate(strYYYYMMDD);
		int nMonth1 = getIntMonthOfDate(strYYYYMMDD);
		caldTmp.set(nYear1, nMonth1 - 1, 1);
		int dayOfWeek = caldTmp.get(7);
		if (dayOfWeek != 1 && dayOfWeek != 2) {
			caldTmp.set(4, weekIndex + 1);
		} else {
			caldTmp.set(4, weekIndex);
		}

		caldTmp.set(7, 2);
		String tmpDate = date2String(caldTmp.getTime(), "yyyy-MM-dd");
		return tmpDate;
	}

	public static int getWeekCountOfMonth(String strYYYYMMDD) {
		boolean res = true;
		String lastDate = getLastDateOfMonth(strYYYYMMDD);
		int res1 = getWeekIndexOfMonth(lastDate);
		return res1;
	}

	public static int getDaysOfMonth(int yyyy, int mm) {
		Calendar iCal = Calendar.getInstance();
		iCal.set(yyyy, mm, 1);
		iCal.add(5, -1);
		return iCal.get(5);
	}

	public static int getDaysOfCurMonth() {
		int curyear = (new Integer(getCurrentYear())).intValue();
		int curMonth = (new Integer(getCurrentMonth())).intValue();
		int[] mArray = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (curyear % 400 == 0 || curyear % 100 != 0 && curyear % 4 == 0) {
			mArray[1] = 29;
		}

		return mArray[curMonth - 1];
	}

	public static int getDayIndexOfWeek(int yyyy, int mm, int dd) {
		Calendar iCal = Calendar.getInstance();
		iCal.set(yyyy, mm - 1, dd - 1);
		return iCal.get(7);
	}

	public static int getDayIndexOfWeek(String strYYYYMMDD) {
		boolean res = true;
		boolean nYear = false;
		boolean nMonth = false;
		boolean nDay = false;
		Calendar caldTmp = Calendar.getInstance();
		int nYear1 = getIntYearOfDate(strYYYYMMDD);
		int nMonth1 = getIntMonthOfDate(strYYYYMMDD);
		int nDay1 = getIntDayOfDate(strYYYYMMDD);
		caldTmp.set(nYear1, nMonth1 - 1, nDay1);
		int res1 = caldTmp.get(7) - 1;
		if (res1 == 0) {
			res1 = 7;
		}

		return res1;
	}

	public static int getWeekIndexOfMonth(String strYYYYMMDD) {
		Calendar caldTmp = Calendar.getInstance();
		caldTmp.setFirstDayOfWeek(2);
		caldTmp.set(getIntYearOfDate(strYYYYMMDD), getIntMonthOfDate(strYYYYMMDD) - 1, getIntDayOfDate(strYYYYMMDD));
		int nWeekOfMonth = caldTmp.get(4);
		boolean nDateDiffNoTime = false;
		String strFirstDayOfThisMonth = getFirstDateOfMonth(strYYYYMMDD);
		String strLastDateOfPreMonth = date2String(getOffsetDate(strFirstDayOfThisMonth, -1, "day"), "yyyy-MM-dd");
		String strSundayOfLastWeekOfPreMonth = getSundayOfThisWeek(strLastDateOfPreMonth);
		Date dParam = string2Date(strYYYYMMDD, "yyyy-MM-dd");
		Date dSundayOfLastWeekOfPreMonth = string2Date(strSundayOfLastWeekOfPreMonth);
		int nDateDiffNoTime1 = dateDiffNoTime(dParam, dSundayOfLastWeekOfPreMonth);
		if (nDateDiffNoTime1 <= 0) {
			return 0;
		} else {
			String strSundayOfFirstDayOfThisMonth = getSundayOfThisWeek(strFirstDayOfThisMonth);
			Date dTmp = string2Date(strYYYYMMDD, "yyyy-MM-dd");
			String strStdYYYYMMDD = date2String(dTmp, "yyyy-MM-dd");
			if (strStdYYYYMMDD.compareToIgnoreCase(strSundayOfFirstDayOfThisMonth) == 0) {
				return nWeekOfMonth;
			} else {
				Date dFistDayOfThisMonth = string2Date(strFirstDayOfThisMonth, "yyyy-MM-dd");
				nDateDiffNoTime1 = dateDiffNoTime(dFistDayOfThisMonth, dSundayOfLastWeekOfPreMonth);
				return nDateDiffNoTime1 > 0 ? nWeekOfMonth : nWeekOfMonth - 1;
			}
		}
	}

	public static int getIntYearOfDate(String strYYYYMMDD) {
		return Integer.parseInt(strYYYYMMDD.substring(0, 4));
	}

	public static int getIntMonthOfDate(String strYYYYMMDD) {
		String strIntervalMark = "";
		if (strYYYYMMDD.indexOf("/") > 0) {
			strIntervalMark = "/";
		} else if (strYYYYMMDD.indexOf("-") > 0) {
			strIntervalMark = "-";
		}

		String strMonth = "";
		String strTmp = "";
		boolean nFirstMarkNum = false;
		boolean nSecondMarkNum = false;
		int nFirstMarkNum1 = strYYYYMMDD.indexOf(strIntervalMark);
		strTmp = strYYYYMMDD.substring(nFirstMarkNum1 + 1);
		int nSecondMarkNum1 = nFirstMarkNum1 + strTmp.indexOf(strIntervalMark);
		if ("".equals(strIntervalMark)) {
			strMonth = strYYYYMMDD.substring(4, 6);
		} else {
			strMonth = strYYYYMMDD.substring(nFirstMarkNum1 + 1, nSecondMarkNum1 + 1);
		}

		return Integer.parseInt(strMonth);
	}

	public static int getIntDayOfDate(String strYYYYMMDD) {
		String strIntervalMark = "";
		if (strYYYYMMDD.indexOf(" ") > 0) {
			strYYYYMMDD = strYYYYMMDD.substring(0, strYYYYMMDD.indexOf(" "));
		}

		if (strYYYYMMDD.indexOf("/") > 0) {
			strIntervalMark = "/";
		} else if (strYYYYMMDD.indexOf("-") > 0) {
			strIntervalMark = "-";
		}

		String strDay = "";
		boolean nLastMarkNum = false;
		int nLastMarkNum1 = strYYYYMMDD.lastIndexOf(strIntervalMark);
		if (strIntervalMark.compareTo("") == 0) {
			strDay = strYYYYMMDD.substring(6);
		} else {
			strDay = strYYYYMMDD.substring(nLastMarkNum1 + 1);
		}

		return Integer.parseInt(strDay);
	}

	public static String getMonthName(int mm) {
		return mm == 1 ? "jan"
				: (mm == 2 ? "feb"
						: (mm == 3 ? "mar"
								: (mm == 4 ? "apr"
										: (mm == 5 ? "may"
												: (mm == 6 ? "jun"
														: (mm == 7 ? "jul"
																: (mm == 8 ? "aug"
																		: (mm == 9 ? "sep"
																				: (mm == 10 ? "oct"
																						: (mm == 11 ? "nov"
																								: (mm == 12 ? "dec"
																										: null)))))))))));
	}

	public static Vector sortDateVectorAsc(Vector vDate) {
		Vector vSortedDate = new Vector();
		boolean nSmallestIndex = false;

		while (vDate.size() > 0) {
			Date dDate = getSmallestDate(vDate);
			if (dDate != null) {
				vSortedDate.addElement(dDate);
			}
		}

		return vSortedDate;
	}

	private static Date getSmallestDate(Vector vDate) {
		int nDeleteIndex = -1;
		Date dDate = getDateObj(2999, 12, 31);

		for (int i = 0; i < vDate.size(); ++i) {
			Date dCurrDate = (Date) vDate.elementAt(i);
			if (dCurrDate.before(dDate)) {
				dDate = dCurrDate;
				nDeleteIndex = i;
			}
		}

		if (nDeleteIndex > -1) {
			return (Date) vDate.remove(nDeleteIndex);
		} else {
			return null;
		}
	}

	public static Date trimMillis(Date dDate) {
		if (dDate == null) {
			return null;
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(dDate);
			cal.set(14, 0);
			return cal.getTime();
		}
	}

	public static Date getOffsetDate(String strYYYYMMDD, int nOffsetNum, String strOffsetUnit) {
		boolean nYear = false;
		boolean nMonth = false;
		boolean nDay = false;
		Calendar caldTmp = Calendar.getInstance();
		int nYear1 = getIntYearOfDate(strYYYYMMDD);
		int nMonth1 = getIntMonthOfDate(strYYYYMMDD);
		int nDay1 = getIntDayOfDate(strYYYYMMDD);
		caldTmp.set(nYear1, nMonth1 - 1, nDay1);
		if ("day".equalsIgnoreCase(strOffsetUnit)) {
			caldTmp.add(5, nOffsetNum);
		} else if ("week".equalsIgnoreCase(strOffsetUnit)) {
			caldTmp.add(5, nOffsetNum * 7);
		} else if ("month".equalsIgnoreCase(strOffsetUnit)) {
			caldTmp.add(2, nOffsetNum);
		} else if ("year".equalsIgnoreCase(strOffsetUnit)) {
			caldTmp.add(1, nOffsetNum);
		}

		return caldTmp.getTime();
	}

	public static String[] getDayList(String beginDate, String endDate) {
		ArrayList theList = new ArrayList();
		int beginYear = getIntYearOfDate(beginDate);
		int endYear = getIntYearOfDate(endDate);
		int beginMonth = getIntMonthOfDate(beginDate) - 1;
		int endMonth = getIntMonthOfDate(endDate) - 1;
		int beginDay = getIntDayOfDate(beginDate);
		int endDay = getIntDayOfDate(endDate);
		GregorianCalendar bCal = new GregorianCalendar(beginYear, beginMonth, beginDay);
		GregorianCalendar eCal = new GregorianCalendar(endYear, endMonth, endDay);
		Date eDate = eCal.getTime();

		for (Date bDate = bCal.getTime(); bDate.compareTo(eDate) <= 0; bDate = bCal.getTime()) {
			String tmpDate = date2String(bDate, "yyyy-MM-dd");
			theList.add(tmpDate);
			bCal.add(5, 1);
		}

		String[] res = new String[theList.size()];
		res = (String[]) ((String[]) theList.toArray(res));
		return res;
	}

	public static String[] getWeekList(String beginDate, String endDate, int beginWeek, int endWeek) {
		ArrayList theList = new ArrayList();
		int beginYear = getIntYearOfDate(beginDate);
		int endYear = getIntYearOfDate(endDate);
		int beginMonth = getIntMonthOfDate(beginDate) - 1;
		int endMonth = getIntMonthOfDate(endDate) - 1;
		byte beginDay = 10;
		byte endDay = 10;
		GregorianCalendar bCal = new GregorianCalendar(beginYear, beginMonth, beginDay);
		GregorianCalendar eCal = new GregorianCalendar(endYear, endMonth, endDay);
		Date eDate = eCal.getTime();

		int weekCntOfMonth;
		int tmpInt;
		Date bDate;
		String tmpDate;
		String tmpStr;
		for (bDate = bCal.getTime(); bDate.compareTo(eDate) < 0; bDate = bCal.getTime()) {
			tmpDate = date2String(bDate, "yyyy-MM-dd");
			weekCntOfMonth = getWeekCountOfMonth(tmpDate);

			for (tmpInt = beginWeek; tmpInt <= weekCntOfMonth; ++tmpInt) {
				tmpStr = tmpDate.substring(0, 7) + "|" + tmpInt;
				theList.add(tmpStr);
			}

			beginWeek = 1;
			bCal.add(2, 1);
		}

		if (bDate.compareTo(eDate) == 0) {
			tmpDate = date2String(bDate, "yyyy-MM-dd");
			weekCntOfMonth = getWeekCountOfMonth(tmpDate);
			if (endWeek > weekCntOfMonth) {
				endWeek = weekCntOfMonth;
			}

			for (tmpInt = beginWeek; tmpInt <= endWeek; ++tmpInt) {
				tmpStr = tmpDate.substring(0, 7) + "|" + tmpInt;
				theList.add(tmpStr);
			}
		}

		String[] res = new String[theList.size()];
		res = (String[]) ((String[]) theList.toArray(res));
		return res;
	}

	public static String[] getMonthList(String beginDate, String endDate) {
		ArrayList theList = new ArrayList();
		int beginYear = getIntYearOfDate(beginDate);
		int endYear = getIntYearOfDate(endDate);
		int beginMonth = getIntMonthOfDate(beginDate) - 1;
		int endMonth = getIntMonthOfDate(endDate) - 1;
		byte beginDay = 10;
		byte endDay = 10;
		GregorianCalendar bCal = new GregorianCalendar(beginYear, beginMonth, beginDay);
		GregorianCalendar eCal = new GregorianCalendar(endYear, endMonth, endDay);
		Date eDate = eCal.getTime();

		for (Date bDate = bCal.getTime(); bDate.compareTo(eDate) <= 0; bDate = bCal.getTime()) {
			String tmpDate = date2String(bDate, "yyyy-MM-dd");
			String tmpStr = tmpDate.substring(0, 7);
			theList.add(tmpStr);
			bCal.add(2, 1);
		}

		String[] res = new String[theList.size()];
		res = (String[]) ((String[]) theList.toArray(res));
		return res;
	}

	public static String[] getYearList(String beginDate, String endDate) {
		ArrayList theList = new ArrayList();
		int beginYear = getIntYearOfDate(beginDate);
		int endYear = getIntYearOfDate(endDate);
		byte beginMonth = 10;
		byte endMonth = 10;
		byte beginDay = 10;
		byte endDay = 10;
		GregorianCalendar bCal = new GregorianCalendar(beginYear, beginMonth, beginDay);
		GregorianCalendar eCal = new GregorianCalendar(endYear, endMonth, endDay);
		Date eDate = eCal.getTime();

		for (Date bDate = bCal.getTime(); bDate.compareTo(eDate) <= 0; bDate = bCal.getTime()) {
			String tmpDate = date2String(bDate, "yyyy-MM-dd");
			String tmpStr = tmpDate.substring(0, 4);
			theList.add(tmpStr);
			bCal.add(1, 1);
		}

		String[] res = new String[theList.size()];
		res = (String[]) ((String[]) theList.toArray(res));
		return res;
	}

	public static String formatDate(String date) {
		String res = "";
		if (date == null) {
			return res;
		} else {
			try {
				int month;
				if (date.length() == 5) {
					month = Integer.parseInt(date.substring(0, 2));
					int day = Integer.parseInt(date.substring(3));
					res = month + "-" + day;
				} else if (date.length() == 7) {
					int year = Integer.parseInt(date.substring(0, 4));
					month = Integer.parseInt(date.substring(5));
					res = year + "-" + month;
				}
			} catch (Exception var6) {
				res = date;
			}

			return res;
		}
	}

	public static String formatDateToCN(String date) {
		String res = "";
		if (date == null) {
			return res;
		} else {
			try {
				int month;
				int day;
				if (date.length() == 5) {
					month = Integer.parseInt(date.substring(0, 2));
					day = Integer.parseInt(date.substring(3));
					res = month + "月" + day + "日";
				} else {
					int year;
					if (date.length() == 7) {
						year = Integer.parseInt(date.substring(0, 4));
						month = Integer.parseInt(date.substring(5, 7));
						res = year + "年" + month + "月";
					} else if (date.length() == 10) {
						year = Integer.parseInt(date.substring(0, 4));
						month = Integer.parseInt(date.substring(5, 7));
						day = Integer.parseInt(date.substring(8));
						res = year + "年" + month + "月" + day + "日";
					} else {
						res = date;
					}
				}
			} catch (Exception var6) {
				res = date;
			}

			return res;
		}
	}

	public static Date getDateObj(int year, int month, int day) {
		int mon = month - 1;
		Calendar rightNow = Calendar.getInstance();
		int ye;
		if (year >= 0 && year < 80) {
			ye = year + 2000;
		} else if (year > 100) {
			ye = year;
		} else {
			ye = year + 1900;
		}

		rightNow.set(11, 0);
		rightNow.set(12, 0);
		rightNow.set(13, 0);
		rightNow.set(ye, mon, day);
		Date db = rightNow.getTime();
		return db;
	}

	public static Date getDateObj(String argsDate, String split) {
		String[] temp = argsDate.split(split);
		int year = (new Integer(temp[0])).intValue();
		int month = (new Integer(temp[1])).intValue();
		int day = (new Integer(temp[2])).intValue();
		return getDateObj(year, month, day);
	}

	public static String addMonth(String str, int i) {
		int n_year = Integer.parseInt(str) / 100;
		int n_month = Integer.parseInt(str) % 100;
		int aY = i / 12;
		int aM = i % 12;
		n_year += aY;
		n_month += aM;
		if (n_month > 12) {
			++n_year;
			n_month -= 12;
		}

		if (n_month < 0) {
			--n_year;
			n_month += 12;
		}

		String issue;
		if (n_month < 10) {
			issue = Integer.toString(n_year).trim() + '0' + Integer.toString(n_month).trim();
		} else {
			issue = Integer.toString(n_year).trim() + Integer.toString(n_month).trim();
		}

		return issue;
	}

	public static boolean verifyDate(int yyyy, int MM, int dd) {
		boolean flag = false;
		if (MM >= 1 && MM <= 12 && dd >= 1 && dd <= 31) {
			if (MM != 4 && MM != 6 && MM != 9 && MM != 11) {
				if (MM == 2) {
					if ((yyyy % 100 == 0 || yyyy % 4 != 0) && yyyy % 400 != 0) {
						if (dd <= 28) {
							flag = true;
						}
					} else if (dd <= 29) {
						flag = true;
					}
				} else {
					flag = true;
				}
			} else if (dd <= 30) {
				flag = true;
			}
		}

		return flag;
	}

	public static String getToday() {
		return date2String(new Date(), "yyyy-MM-dd");
	}

	public static java.sql.Date getStepDay(java.sql.Date date, int step) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(6, step);
		return new java.sql.Date(calendar.getTime().getTime());
	}

	public static java.sql.Date getStepMonth(Date date, int intBetween) {
		Calendar calo = Calendar.getInstance();
		calo.setTime(date);
		calo.add(2, intBetween);
		return new java.sql.Date(calo.getTime().getTime());
	}

	public static java.sql.Date getStepYear(Date date, int intBetween) {
		Calendar calo = Calendar.getInstance();
		calo.setTime(date);
		calo.add(1, intBetween);
		return new java.sql.Date(calo.getTime().getTime());
	}

	public static boolean IsLeapYear(int year) {
		return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
	}

	public static int getAllDays(int year) {
		return IsLeapYear(year) ? 366 : 365;
	}

	public static int getMaxDay(int year, int month) {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 2:
			return IsLeapYear(year) ? 29 : 28;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			return -1;
		}
	}

	public static int getDays(int year, int month, int day) {
		int sum = 0;

		for (int i = 1; i < month; ++i) {
			if (getMaxDay(year, i) < day) {
				return -1;
			}

			sum += getMaxDay(year, i);
		}

		return sum + day;
	}

	public static int getNextDay(int year, int month, int day) {
		if (day != getMaxDay(year, month)) {
			++day;
		} else if (month != 12) {
			++month;
			day = 1;
		} else {
			++year;
			day = 1;
			boolean var3 = true;
		}

		return day;
	}

	public static int getPreDay(int year, int month, int day) {
		if (day != 1) {
			--day;
		} else if (month != 1) {
			--month;
			day = getMaxDay(year, month);
		} else {
			--year;
			boolean var3 = true;
			day = 31;
		}

		return day;
	}

	public static void getXDay(int year, int month, int day, int x) {
		for (int i = 1; i <= x; ++i) {
			if (day != getMaxDay(year, month)) {
				++day;
			} else if (month != 12) {
				++month;
				day = 1;
			} else {
				++year;
				day = 1;
				month = 1;
			}
		}

		System.out.println(x + "天后是：" + year + "-" + month + "-" + day);
	}

	public static int compareDay(int year1, int month1, int day1, int year2, int month2, int day2) {
		return year1 != year2 ? year1 - year2 : (month1 != month2 ? month1 - month2 : day1 - day2);
	}

	static int getDateDiff1(int year1, int month1, int day1, int year2, int month2, int day2) {
		int sum = getAllDays(year1) - getDays(year1, month1, day1);

		for (int i = year1 + 1; i < year2; ++i) {
			sum += getAllDays(i);
		}

		sum += getDays(year2, month2, day2);
		return sum;
	}

	public static int getDateDiff(int year1, int month1, int day1, int year2, int month2, int day2) {
		return compareDay(year1, month1, day1, year2, month2, day2) > 0
				? -getDateDiff1(year2, month2, day2, year1, month1, day1)
				: (compareDay(year1, month1, day1, year2, month2, day2) < 0
						? getDateDiff1(year1, month1, day1, year2, month2, day2) : 0);
	}

	public static boolean isBetween(String startTime, String endTime) {
		Date startDate = string2Date(startTime, "yyyy-MM-dd HH:mm:ss");
		Date endDate = string2Date(endTime, "yyyy-MM-dd HH:mm:ss");
		Date newDate = new Date();
		return startDate.getTime() <= newDate.getTime() && newDate.getTime() <= endDate.getTime();
	}

	public static boolean isBetween2(String startTime, String endTime) {
		Date startDate = string2Date(startTime, "yyyy-MM-dd HH:mm:ss");
		Date endDate = string2Date(endTime, "yyyy-MM-dd HH:mm:ss");
		Date newDate = new Date();
		return startDate.getTime() < newDate.getTime() && newDate.getTime() < endDate.getTime();
	}

	public static int getBetweenToNextMonth() {
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:OO"));
		int day = c.get(5);
		int last = c.getActualMaximum(5);
		int result = last - day + 1;
		return result;
	}

	public static Date getStepDay(Date date, int step) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(6, step);
		return new Date(calendar.getTime().getTime());
	}

	public static Date getMaxTimeOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getMinTimeOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/*
	 * 将时间转换为时间戳
	 */
	public static long dateToStamp(String s) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = simpleDateFormat.parse(s);
		long ts = date.getTime();
		return ts;
	}

	/*
	 * 将时间戳转换为时间
	 */
	public static String stampToDate(Long s) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(s);
		String res = simpleDateFormat.format(date);
		return res;
	}

}
