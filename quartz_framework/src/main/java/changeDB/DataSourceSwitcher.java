package changeDB;

public class DataSourceSwitcher {
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	/**
	  * <p>
	  * Title: setDataSource <br>
	  * Description: TODO  <br>
	  * @param locationCode    �趨�ļ�  <br>
	  * void    ��������  <br>
	  * @throws
	 */
	public static void setDataSource(String locationCode) {
		contextHolder.set("dataSource_sh");
	}

	/**
	  * <p>
	  * Title: setMaster <br>
	  * Description: TODO  <br>    �趨�ļ�  <br>
	  * void    ��������  <br>
	  * @throws
	 */
	public static void setMaster() {
		clearDataSource();
	}

	/**
	  * <p>
	  * Title: setSlave <br>
	  * Description: TODO  <br>
	  * @param locationCode    String
	  * void    ��������  <br>
	  * @throws
	 */
	public static void setSlave(String locationCode) {
		setDataSource(locationCode);
	}

	/**
	  * <p>
	  * Title: getDataSource <br>
	  * Description: TODO  <br>
	  * @return    �趨�ļ�  <br>
	  * String    ��������  <br>
	  * @throws
	 */
	public static String getDataSource() {
		return (String) contextHolder.get();
	}

	/**
	  * <p>
	  * Title: clearDataSource <br>
	  * Description: TODO  <br>    �趨�ļ�  <br>
	  * void    ��������  <br>
	  * @throws
	 */
	public static void clearDataSource() {
		contextHolder.remove();
	}

}
