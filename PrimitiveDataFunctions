package controller.primitive;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;





@Stateless
public class PrimitiveDataFunctions {

	public Date addHoursToDateFormat(String dateInput,int quantity) throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateOutput = dateFormat.parse(dateInput);
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateOutput);
		cal.add(Calendar.HOUR, quantity);//quante ore aggiungo 
		dateOutput = cal.getTime();//qui alla fine ha aggiunto tot mesi
		return dateOutput;
	}

	public Date addDaysToDateFormat(String dateStringInput,Date dateInput, int quantity) throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateOutput = null;
		if(!dateStringInput.equals("")){
			dateFormat.parse(dateStringInput);
		}

		else
			dateOutput=dateInput;
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateOutput);
		cal.add(Calendar.DATE, quantity);//quante ore aggiungo 
		dateOutput = cal.getTime();//qui alla fine ha aggiunto tot mesi
		return dateOutput;
	}

	//Cambia ora minuti e secondi di una data
	public Date changeDateTime(Date date ,int minOrMax) {    
		Calendar cal = Calendar.getInstance();  
		cal.setTime(date);  
		if(minOrMax==0){
			cal.set(Calendar.HOUR_OF_DAY, 0);  
			//			cal.set(Calendar.MINUTE, 0);  
			//			cal.set(Calendar.SECOND, 0);  
			//			cal.set(Calendar.MILLISECOND, 0);  	
		}
		if(minOrMax==59)
		{
			cal.set(Calendar.HOUR_OF_DAY, 23);  
			//			cal.set(Calendar.MINUTE, 59);  
			//			cal.set(Calendar.SECOND, 59);  
			//			cal.set(Calendar.MILLISECOND, 59);  	
		}
		cal.set(Calendar.MINUTE, minOrMax);  
		cal.set(Calendar.SECOND, minOrMax);  
		cal.set(Calendar.MILLISECOND, minOrMax); 

		return cal.getTime(); 
	}


	public java.util.Date convertFromSQLDateToJAVADate(java.sql.Date sqlDate) {
		java.util.Date javaDate = null;
		if (sqlDate != null) {
			javaDate = new Date(sqlDate.getTime());
		}
		return javaDate;
	}
	public java.sql.Date convertFromJAVADateToSQLDate(java.util.Date utilDate) {
		java.sql.Date sqlDate =null;
		if (utilDate != null) {
        sqlDate = new java.sql.Date(utilDate.getTime());
		}
		return sqlDate;
	}
	
	
	

	//fa il parser Di una data in stringa e ritorna un Date,con tot mesi aggiunti.
	//con All hai un dateTime, con noTime hai un date senza time
	public Date parserDateFormat(Date dateInput,int month,String typeParse) throws ParseException
	{
		if(typeParse.equals("all")){
			Date dateOutput = dateInput;
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateOutput);
			cal.add(Calendar.MONTH, month);//devo rimuovere un mese, perchÃ¨ devo vedere se quelle del mese prima sono uguali alle correnti
			dateOutput = cal.getTime();//qui alla fine ha aggiunto tot mesi
			return dateOutput;
		}
		if(typeParse.equals("noTime")){
			Date dateOutput = dateInput;
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateOutput);
			cal.add(Calendar.MONTH, month);//devo rimuovere un mese, perchÃ¨ devo vedere se quelle del mese prima sono uguali alle correnti
			dateOutput = cal.getTime();//qui alla fine ha aggiunto tot mesi
			return dateOutput;
		}


		return null;
	}


	//fa il parse di un Date e lo trasforma nell'int di anno,mese o giorno 
	public int parserDateFormatToInt(Date dateInput,String typeParse)
	{
		if(typeParse.equals("year")){
			SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
			int yearOut = Integer.parseInt(yearFormat.format(dateInput));
			return yearOut;
		}
		if(typeParse.equals("month")){
			SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
			int monthOut = Integer.parseInt(monthFormat.format(dateInput));
			return monthOut;
		}
		if(typeParse.equals("day")){
			SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
			int dayOut = Integer.parseInt(dayFormat.format(dateInput));
			return dayOut;
		}

		return 0;
	}

	//Fa il parse di un Date e lo trasforma in una Stringa di anno,mese o giorno
	public String parserDateFormatToString(Date dateInput,String typeParse) throws ParseException
	{

		if(typeParse.equals("year")){
			SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
			String yearOut = yearFormat.format(yearFormat.format(dateInput));
			return yearOut;
		}
		if(typeParse.equals("month")){
			SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
			String monthOut = monthFormat.format(monthFormat.format(dateInput));
			return monthOut;
		}
		if(typeParse.equals("day")){
			SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
			String dayOut = dayFormat.format(dayFormat.format(dateInput));
			return dayOut;
		}
		if(typeParse.equals("italian")){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");//dd/MM/yyyy
			Date now = new Date();
			String strDate = sdfDate.format(now);
			String str = strDate.replace("-", "");
			//log.info(" initial string : " +str);
			StringBuilder sb = new StringBuilder(str);
			//01012017 --> lunghezza 8, 7 Ã¨ l'ultimo
			sb.delete(str.length()-4, str.length()-2);
			//log.info(" final subString: "+sb);
			String a = String.valueOf(sb);
			return a;
		}
		if(typeParse.equals("italianBirthDate")){
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");//dd/MM/yyyy
			String strDate = sdfDate.format(dateInput);
			String str = strDate.replace("-", "/");
			//log.info(" initial string : " +str);
			StringBuilder sb = new StringBuilder(str);
			//01012017 --> lunghezza 8, 7 Ã¨ l'ultimo
			//sb.delete(str.length()-4, str.length()-2);
			//log.info(" final subString: "+sb);
			String a = String.valueOf(sb);
			return a;
		}
		
		
		return null;
	}

	public String parseStringFormat(String dateInput,String typeParse) throws ParseException 
	{
		DateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		Date date = inputFormatter.parse(dateInput);
		String output ="";
		if(typeParse.equals("noTime")){
			DateFormat outputFormatter = new SimpleDateFormat("yyyy/MM/dd");
			output = outputFormatter.format(date);
		}
		if(typeParse.equals("italian")){
			DateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.S");
			output = outputFormatter.format(date);
		}
		
		

		return output; 
	}

	public Date parseSpecificStringFormatToDate(String inputDateString,String typeParse) throws ParseException
	{
		Date outPutDate =new Date();
		if(typeParse.equals("italian")){
			DateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss");
			outPutDate= outputFormatter.parse(inputDateString);
			//output = outputFormatter.format(date);
		}
			return outPutDate; 
	}
	
	
	//data di oggi
	private Calendar getCalendarForNow() {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(new Date());
		return calendar;
	}

	//Ritorna il nome del mese(int) passato in input a seconda della lingua
	public String getNameMonth(int month, Locale locale) {
		//DateFormatSymbols.getInstance(locale).getMonths()[month-1]; 
		//He does need month-1, because the month is the 1-based month number which needs to be converted to the zero-based array position

		Calendar c= Calendar.getInstance();
		c.add(Calendar.MONTH, month);
		return c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ITALIAN ) ;
		//return new DateFormatSymbols().getInstance().getMonths()[month-1];
	}

	//setta ora/minuti/secondi del giorno iniziale a 0
	private void setTimeToBeginningOfDay(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}

	//setta ora/minuti/secondi del giorno finale a 23:59:59:999
	private void setTimeToEndofDay(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
	}

	//Setta a 0 ora minuti secondi del primo giorno del mese corrente(qualsiasi esso sia)
	public Date setFirstDayOfThisCurrentMonth(){
		Date firstDay;
		Calendar calendar = getCalendarForNow();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		setTimeToBeginningOfDay(calendar);
		firstDay = calendar.getTime();
		return firstDay;

	}

	//Setta a 0 ora minuti secondi del primo giorno del mese passato in input
	public Date setFirstDayOfMonth(Date dateInput)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateInput);
		cal.add(Calendar.MONTH, 0);//devo rimuovere un mese, perchÃ¨ devo vedere se quelle del mese prima sono uguali alle correnti
		cal.set(Calendar.DAY_OF_MONTH,
				cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		setTimeToBeginningOfDay(cal); // Aggiunto altrimenti l'ora minuti e secodni erano sballati
		dateInput = cal.getTime();//qui alla fine ha aggiunto tot mesi
		return dateInput;
	}

	//Setta a 23:59:59 ora minuti secondi dell'ultimo giorno del mese corrente(qualsiasi esso sia)
	public Date setLastDayOfThisCurrentMonth(){
		Date lastDay;
		Calendar calendar = getCalendarForNow();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		setTimeToEndofDay(calendar);
		lastDay = calendar.getTime();	
		return lastDay;
	}

	//Setta a 23:59:59 ora minuti secondi dell'ultimo giorno del mese passato in input
	public Date setLastDayOfMonth(Date dateInput)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateInput);    
		cal.add(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH,
				cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		setTimeToEndofDay(cal);
		dateInput = cal.getTime();//qui alla fine ha aggiunto tot mesi
		return dateInput;
	}

	//ritorna la data di oggi
	public Date todayDate() throws MessagingException{
		Date now;
		Calendar c = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dataAttuale = dateFormat.format(c.getTime());

		try {
			now = dateFormat.parse(dataAttuale);
		} catch (ParseException e) {
			throw new MessagingException();
		}
		//log.info(" Date now: " +now);
		return now;
	}

	public XMLGregorianCalendar getXmlGregoriamFromDate(Date input) throws DatatypeConfigurationException{
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(new Date(System.currentTimeMillis()));
		XMLGregorianCalendar xmlGrogerianCalendarOutput = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		return xmlGrogerianCalendarOutput;
	}

	public Date nowGMT() throws Exception{
		Date now;
		Calendar c = Calendar.getInstance();
		
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));

		//Local time zone   
		SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");

		//Time in GMT
		try {
			now = dateFormatLocal.parse( dateFormatGmt.format(c.getTime()) );
		} catch (ParseException e) {
			
			throw new Exception();
		}
		
		return now;
	}
	
	
	
	//Verifica che La data finale non puo' essere antecedente alla data odierna
	public void verifyTimeInterval(Date to_start,Date to_end) throws Exception{
		to_start=setFirstDayOfMonth(to_start);
		to_end=setFirstDayOfMonth(to_end);
		long inizio = to_start.getTime();
		long fine = to_end.getTime();
		long differenza = fine-inizio;
		if(differenza < 0){
			throw new Exception();
//			logF.errorForThrowNewException("La data finale non puo' essere antecedente alla data odierna", WSErrorCode.ERR_GENERIC, "nam.ws.controller.GestioneMarche", ", data finale immessa: " + to_start);
//			String msg = "La data finale non puo' essere antecedente alla data odierna";
//			int error = WSErrorCode.ERR_GENERIC;
//			log.error(msg + " (" + error + "), data finale immessa: " + to_start);
//			throw new WSException(error, msg);
		}

	}

}
