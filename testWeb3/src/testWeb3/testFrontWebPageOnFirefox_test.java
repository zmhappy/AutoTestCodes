package testWeb3;

import static org.junit.Assert.*;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.sql.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testFrontWebPageOnFirefox_test {
	private WebDriver driver;
	private String baseUrl = "http://ci2.tuotiansudai.com:6002/";
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private double iTotalNum = 212.3;
	private Connection conn = null;
	private ResultSet rs = null;
	private String backUrl = "http://118.187.56.164:6003/";
	private String dbUrl = null;
	private String newComer= "test001";
	private String referrer="gaoyinglong";
	private String mobile_register="13699160001";
	private String mobile_change_password="13699160940";
	String newPassword = "123abcd";
	String oldPassword = "123abc";

	@Before
	public void setUp() throws Exception {
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:/Tools/chromedriver.exe");

		driver = new ChromeDriver();

		baseUrl = readValue("baseUrl");
		backUrl = readValue("backUrl");
		dbUrl = readValue("dbUrl");
		System.out.println("baseUrl:" + baseUrl);
		System.out.println("backUrl:" + backUrl);
		System.out.println("dbUrl:" + dbUrl);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		connectDB();
	}

	@After
	public void tearDown() throws Exception {
		closeDB();
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		
	}

	
	private void connectDB() throws Exception {

		// ����������
		String driver = "com.mysql.jdbc.Driver";

		// URLָ��Ҫ���ʵ����ݿ���scutcs
		String url = "jdbc:mysql://"+dbUrl + ":3306/aa";

		// MySQL����ʱ���û���
		String user = "root";

		// MySQL����ʱ������
		String password = "";

		try {
			// ������������
			Class.forName(driver);

			// �������ݿ�
			conn = DriverManager.getConnection(url, user, password);

			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			

		} catch (ClassNotFoundException e) {

			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
		} 

	}


	private void closeDB() throws Exception
	{
		if(rs != null){
		rs.close();
		}
		conn.close();
		System.out.println("Close Database!");
	}
	
	private String getCaptcha(String strMobile, String strCaptchaType) throws Exception {

		try {

			// statement����ִ��SQL���
			Statement statement = conn.createStatement();

			// Ҫִ�е�SQL���
			String sql = "SELECT captcha FROM sms_captcha WHERE mobile = '" + strMobile
					+ "' and captcha_type= '" + strCaptchaType + "'";

			// �����
			rs = statement.executeQuery(sql);

			String name = null;

			while (rs.next()) {

				// ѡ��captcha��������
				name = rs.getString("captcha");
			}

			return name;

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
		} 

		return null;
	}

	
	private String getReferrer() throws Exception {

		try {
			// ������������

			// statement����ִ��SQL���
			Statement statement = conn.createStatement();

			// Ҫִ�е�SQL���
			String sql = "SELECT referrer FROM user WHERE mobile = '" + this.mobile_register + "'";

			// �����
			rs = statement.executeQuery(sql);

			System.out.println("-----------------");
			System.out.println("ִ�н��������ʾ:");
			System.out.println("-----------------");
			System.out.println(" referrer");
			System.out.println("-----------------");

			String name = null;

			if (rs.next()) {

				// ѡ��captcha��������
				name = rs.getString("referrer");

				// ������
				System.out.println(name);
			}

			return name;

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
		} 

		return null;
	}
	
	private String getLoginName() throws Exception {

		try {
			// ������������

			// statement����ִ��SQL���
			Statement statement = conn.createStatement();

			// Ҫִ�е�SQL���
			String sql = "SELECT login_name FROM user WHERE mobile = '" + mobile_register + "'";

			// �����
			rs = statement.executeQuery(sql);

			System.out.println("-----------------");
			System.out.println("ִ�н��������ʾ:");
			System.out.println("-----------------");
			System.out.println(" login_name");
			System.out.println("-----------------");

			String name = null;

			if (rs.next()) {

				// ѡ��captcha��������
				name = rs.getString("login_name");

				// ������
				System.out.println(name);
			}

			return name;

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
		} 

		return null;
	}

	private void connectDB1() throws Exception {

		// ����������
		String driver = "com.mysql.jdbc.Driver";

		// URLָ��Ҫ���ʵ����ݿ���scutcs
		String url = "jdbc:mysql://192.168.1.132:3306/aa";

		// MySQL����ʱ���û���
		String user = "root";

		// MySQL����ʱ������
		String password = "";
		Connection conn = null;
		ResultSet rs = null;

		try {
			// ������������
			Class.forName(driver);

			// �������ݿ�
			conn = DriverManager.getConnection(url, user, password);

			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");

			// statement����ִ��SQL���
			Statement statement = conn.createStatement();

			// Ҫִ�е�SQL���
			String sql = "select id,login_name from user";

			// �����
			rs = statement.executeQuery(sql);

			System.out.println("-----------------");
			System.out.println("ִ�н��������ʾ:");
			System.out.println("-----------------");
			System.out.println(" ѧ��" + "\t" + " ����");
			System.out.println("-----------------");

			String name = null;

			while (rs.next()) {

				// ѡ��login_name��������
				name = rs.getString("login_name");

				// ����ʹ��ISO-8859-1�ַ�����name����Ϊ�ֽ����в�������洢�µ��ֽ������С�
				// Ȼ��ʹ��GB2312�ַ�������ָ�����ֽ�����
				name = new String(name.getBytes("ISO-8859-1"), "GB2312");

				// ������
				System.out.println(rs.getString("id") + "\t" + name);
			}
			
			rs.close();
			conn.close();
			System.out.println("Close Database!");

		} catch (ClassNotFoundException e) {

			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
		} finally{
		
			rs.close();
			conn.close();
			System.out.println("Close Database!");
			
		}

	}

	private void loginBackend() throws Exception {
		driver.findElement(By.id("user")).clear();
		driver.findElement(By.id("user")).sendKeys("mintest");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("123abc");
		driver.findElement(By.id("yzm")).clear();
		driver.findElement(By.id("yzm")).sendKeys("kkkkk");
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(1000);
		
	}

	/**
	 * @param key
	 * <br>
	 * @return key's value<br>
	 *         Get the property's value by given key.
	 */
	private static String readValue(String key) {
		String filePath = "webconfig.properties";
		Properties props = new Properties();
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(filePath));
			props.load(in);
			String strValue = props.getProperty(key);
			return strValue;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void clearCache() throws Exception{
	    driver.get(baseUrl + "/login");
	    driver.findElement(By.id("user")).clear();
	    driver.findElement(By.id("user")).sendKeys("mintest");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("123abc");
	    driver.findElement(By.id("yzm")).clear();
	    driver.findElement(By.id("yzm")).sendKeys("kkkkk");
	    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	    driver.findElement(By.linkText("��ȫ����")).click();
		Thread.sleep(3000);
	    driver.findElement(By.linkText("���DB Cache")).click();
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@value='һ�����Mybatis DB Cache']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	    driver.findElement(By.id("logout-link")).click();
		Thread.sleep(3000);

	    //assertEquals("ȷ��Ҫ������ݿ⻺����", closeAlertAndGetItsText());
	    //assertEquals("���ݿ⻺���Ѿ������", closeAlertAndGetItsText());
		
	}
	

	//@Test
	public void deleteExistedUser() throws Exception{

		try {
			// ������������

			// statement����ִ��SQL���
			Statement statement = conn.createStatement();

			// Ҫִ�е�SQL���
			statement.executeUpdate("delete from user_role where login_name='" + newComer + "'");
			statement.executeUpdate("delete from login_log_201605 where login_name='" + newComer + "'");
			statement.executeUpdate("delete from login_log_201606 where login_name='" + newComer + "'");
			statement.executeUpdate("delete from login_log_201607 where login_name='" + newComer + "'");
			statement.executeUpdate("delete from login_log_201608 where login_name='" + newComer + "'");
			statement.executeUpdate("delete from login_log_201609 where login_name='" + newComer + "'");
			statement.executeUpdate("delete from login_log_201610 where login_name='" + newComer + "'");
			statement.executeUpdate("delete from user_op_log where login_name='" + newComer + "'");
			statement.executeUpdate("delete from referrer_relation where login_name='" + newComer + "'");
			statement.executeUpdate("delete from user_coupon where  invest_id in (select id from invest where login_name='"+ newComer + "')");
			statement.executeUpdate("delete from user_coupon where  invest_id in (select id  from invest where loan_id in (select id from loan where agent_login_name='"+ newComer + "'))");
			statement.executeUpdate("delete from invest_repay where invest_id in (select id from invest where login_name='"+ newComer + "')");
			statement.executeUpdate("delete from invest where login_name='" + newComer + "'");
			statement.executeUpdate("delete from user_coupon where login_name='" + newComer + "'");
			statement.executeUpdate("delete from user_point_task where login_name='" + newComer + "'");
			statement.executeUpdate("delete from point_bill where login_name='" + newComer + "'");
			statement.executeUpdate("delete from account where login_name='" + newComer + "'");
			statement.executeUpdate("delete from user_bill where login_name='" + newComer + "'");
			statement.executeUpdate("delete from recharge where login_name='" + newComer + "'");
			statement.executeUpdate("delete from bank_card where login_name='" + newComer + "'");
			statement.executeUpdate("delete from user_membership where login_name='" + newComer + "'");
			statement.executeUpdate("delete from membership_experience_bill where login_name='" + newComer + "'");
			statement.executeUpdate("delete from user_message where login_name='" + newComer + "'");
			statement.executeUpdate("delete from user where login_name='" + newComer + "'");

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
		} 
		clearCache();
		
	}

	
	private void doUserInvest() throws Exception {
		
		Thread.sleep(1000);
//	    driver.findElement(By.id("getFree")).click();
//		Thread.sleep(1000);
//	    driver.findElement(By.cssSelector("div.model-project-precess > div.right-operat > div.rest-amount > a.btn-invest.btn-normal")).click();
	    //	    driver.findElement(By.cssSelector("div.rest-amount")).click();
		closeCoupon();
		
		Thread.sleep(2000);
	    driver.findElement(By.id("investSubmit")).click();
		Thread.sleep(1000);
	    driver.findElement(By.linkText("����ʹ��")).click();
		Thread.sleep(3000);
		
		
		if(this.isElementPresent(By.linkText("����ʹ��")))
		{
		    driver.findElement(By.linkText("����ʹ��")).click();
			Thread.sleep(3000);
		    driver.findElement(By.linkText("��ҪͶ��")).click();
			Thread.sleep(3000);
		}
		
	    driver.findElement(By.xpath("//li[2]/div[2]/div[3]/i")).click();
		Thread.sleep(3000);
		
//	    driver.findElement(By.cssSelector("div.account-info.fl")).click();
//		Thread.sleep(1000);
	    driver.findElement(By.id("investSubmit")).click();
		Thread.sleep(10000);
		assertTrue(driver.getTitle().equals("�����ٴ�-ʵ����֤"));
		Thread.sleep(1000);

//	    driver.findElement(By.name("userName")).click();
//	    driver.findElement(By.name("userName")).clear();
//	    driver.findElement(By.name("userName")).sendKeys("������");
//	    driver.findElement(By.name("identityNumber")).clear();
//	    driver.findElement(By.name("identityNumber")).sendKeys("130725199702051618");
//	    driver.findElement(By.name("userName")).click();
//	    
//		Thread.sleep(1000);
//	    driver.findElement(By.cssSelector("input.register-account.btn-success")).click();
//	    
//	    driver.findElement(By.name("amount")).clear();
//	    driver.findElement(By.name("amount")).sendKeys("1");
//	    driver.findElement(By.id("investSubmit")).click();
//	    driver.findElement(By.linkText("����Ͷ��")).click();
//		Thread.sleep(1000);
//	    driver.findElement(By.id("investSubmit")).click();
//		Thread.sleep(1000);
//	    driver.findElement(By.id("investSubmit")).click();
//	    
//	    driver.findElement(By.cssSelector("div.tc.clear-blank-m > input.btn.btn-normal")).click();

	}

	@Test
	public void testWithdrawAndRecharge() throws Exception {
		driver.get(backUrl + "");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));

	    driver.findElement(By.linkText("��¼")).click();
		Thread.sleep(1000);
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("gaoyinglong");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("123abc");
	    driver.findElement(By.name("captcha")).click();
	    driver.findElement(By.name("captcha")).sendKeys("kkkkk");
		Thread.sleep(1000);
	    driver.findElement(By.cssSelector("button.login-submit.btn-normal")).click();
		Thread.sleep(3000);

		closeCoupon();
		
	    driver.findElement(By.linkText("�ҵ��˻�")).click();
		Thread.sleep(1000);
	    driver.findElement(By.linkText("����")).click();
		Thread.sleep(2000);
	    driver.findElement(By.cssSelector("input.amount-display")).clear();
	    driver.findElement(By.className("amount-display")).sendKeys("3");
		Thread.sleep(3000);
		
	    driver.findElement(By.cssSelector("button.withdraw-submit.btn-normal")).click();
		Thread.sleep(6000);
		switchWindowWithdrawAndRecharge("�˻�����");
		Thread.sleep(2000);
	    driver.findElement(By.linkText("ȷ�ϳɹ�")).click();
		Thread.sleep(1000);
	    driver.findElement(By.linkText("��ֵ")).click();
		Thread.sleep(1000);
	    driver.findElement(By.cssSelector("input.amount")).clear();
	    driver.findElement(By.className("amount")).sendKeys("12");
		Thread.sleep(3000);
	    driver.findElement(By.cssSelector("button.btn.btn-normal")).click();
		Thread.sleep(8000);
		switchWindowWithdrawAndRecharge("��ǿ���ֵ");
		Thread.sleep(2000);
	    driver.findElement(By.linkText("ȷ�ϳɹ�")).click();
		Thread.sleep(1000);

	}


	private void closeCoupon() throws Exception{
		
		if(this.isElementPresent(By.id("getFree")))
		{
			driver.findElement(By.id("getFree")).click();
			Thread.sleep(1000);
		    driver.findElement(By.cssSelector("div.model-project-precess > div.right-operat > div.rest-amount > a.btn-invest.btn-normal")).click();
			Thread.sleep(1000);
		}

	}
	
	@Test
	public void testDeleteUser() throws Exception {
		//this.getReferrer();
		newComer=this.getLoginName();
		deleteExistedUser();
		//		clearCache();

	}
	
	@Test
	public void testSignUpWithReferrer() throws Exception {
		newComer=this.getLoginName();
		//deleteExistedUser();

		driver.get(backUrl + "");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));

		driver.findElement(By.linkText("ע��")).click();
//		driver.findElement(By.name("loginName")).click();
//		driver.findElement(By.name("loginName")).clear();
//		driver.findElement(By.name("loginName")).sendKeys(newComer);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("123abc");
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys(mobile_register);
		Thread.sleep(5000);
		driver.findElement(By.name("captcha")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button.fetch-captcha")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("imageCaptcha")).clear();
		driver.findElement(By.name("imageCaptcha")).sendKeys("kkkkk");
		driver.findElement(
				By.cssSelector("input.image-captcha-confirm.btn-normal"))
				.click();
		Thread.sleep(10000);
		driver.findElement(By.name("captcha")).clear();
		driver.findElement(By.name("captcha")).sendKeys(this.getCaptcha(mobile_register,"REGISTER_CAPTCHA"));
		driver.findElement(By.cssSelector("i.sprite-register-arrow-right"))
				.click();
		driver.findElement(By.name("referrer")).clear();
		driver.findElement(By.name("referrer")).sendKeys(referrer);
		driver.findElement(By.cssSelector("i.sprite-register-arrow-right"))
				.click();
	    driver.findElement(By.cssSelector("i.sprite-register-arrow-bottom")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("i.sprite-register-arrow-right"))
		.click();
//		driver.findElement(By.cssSelector("label.check-label")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("label.check-label.checked")).click();
//		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.register-user.btn-success"))
				.click();
		Thread.sleep(10000);
		
		assertTrue(this.getReferrer().equals(referrer));
		//assertTrue(this.getLoginName().equals(newComer));
		
		doUserInvest();
		
		newComer=this.getLoginName();
		Thread.sleep(3000);
		deleteExistedUser();
		
	}
	
	@Test
	public void testSignUpNoReferrer() throws Exception {
		driver.get(backUrl + "");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));

		driver.findElement(By.linkText("ע��")).click();
//		driver.findElement(By.name("loginName")).click();
//		driver.findElement(By.name("loginName")).clear();
//		driver.findElement(By.name("loginName")).sendKeys(newComer);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("123abc");
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys(mobile_register);
		Thread.sleep(5000);
		driver.findElement(By.name("captcha")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button.fetch-captcha")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("imageCaptcha")).clear();
		driver.findElement(By.name("imageCaptcha")).sendKeys("kkkkk");
		driver.findElement(
				By.cssSelector("input.image-captcha-confirm.btn-normal"))
				.click();
		Thread.sleep(8000);
		driver.findElement(By.name("captcha")).clear();
		driver.findElement(By.name("captcha")).sendKeys(this.getCaptcha(mobile_register,"REGISTER_CAPTCHA"));
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("i.sprite-register-arrow-right"))
				.click();
		driver.findElement(By.cssSelector("i.sprite-register-arrow-right"))
				.click();
	    driver.findElement(By.cssSelector("i.sprite-register-arrow-bottom")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("i.sprite-register-arrow-right"))
		.click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input.register-user.btn-success"))
				.click();
		Thread.sleep(3000);
		assertTrue(this.getReferrer()==null);
//		assertTrue(this.getLoginName().equals(newComer));

		
		doUserInvest();
		
		Thread.sleep(3000);
		newComer=this.getLoginName();
		deleteExistedUser();
		

	}


	@Test
	public void testCreate360ProjectandInvest() throws Exception {
		driver.get(baseUrl + "/login");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("��¼"));

		loginBackend();
		
		driver.findElement(By.linkText("��Ŀ����")).click();

		testCreateProjectForUser("360", "gaoyinglong", "370105199512046531");
		//testCreateProjectForUser("360", "mintest", "152502197906230926");

	    driver.findElement(By.id("logout-link")).click();
		Thread.sleep(60000);
		
		testInvestNow();
		
		doRepayment();

	}

	//@Test
	public void testInvestNow() throws Exception {
		driver.get(backUrl);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));

	    driver.findElement(By.linkText("��ҪͶ��")).click();
		Thread.sleep(1000);
			    driver.findElement(By.linkText("180������")).click();
			    //driver.findElement(By.linkText("91-180��")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//dl[3]/dd")).click();
		Thread.sleep(3000);
	    driver.findElement(By.id("investSubmit")).click();
		Thread.sleep(2000);
		
		login("mintest", this.oldPassword);

		closeCoupon();

		
		if(this.isElementPresent(By.linkText("����ʹ��")))
		{
		    driver.findElement(By.linkText("����ʹ��")).click();
			Thread.sleep(3000);
		}

	    driver.findElement(By.linkText("��ҪͶ��")).click();
		Thread.sleep(3000);
	    driver.findElement(By.linkText("180������")).click();
		Thread.sleep(3000);
	    driver.findElement(By.cssSelector("i.btn-invest.btn-normal")).click();
		Thread.sleep(3000);
	    driver.findElement(By.id("investSubmit")).click();
		Thread.sleep(3000);
	    driver.findElement(By.linkText("ȷ��")).click();
		Thread.sleep(3000);
	}
	
	//@Test
	public void doRepayment() throws Exception {
		try {
			driver.get(baseUrl + "/login");
			driver.manage().window().maximize();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("��¼"));

			loginBackend();
			
		    driver.findElement(By.linkText("��Ŀ����")).click();
			Thread.sleep(2000);
		    driver.findElement(By.linkText("�༭")).click();
			Thread.sleep(3000);
		    driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			
		} catch (Exception e) {
			File img = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(img, new File("c:/test/doRepayment.jpg"));
			e.printStackTrace();
			assertTrue(false);

		}
	}

	@Test
	public void testCreateAllProjects() throws Exception {
		driver.get(baseUrl + "/login");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("��¼"));

		loginBackend();
		
		driver.findElement(By.linkText("��Ŀ����")).click();

		// for(int i=1;i<10;i++)
		//		testCreateProjectForUser("90", "gaoyinglong", "370105199512046531");
//		testCreateProjectForUser("180", "gaoyinglong", "370105199512046531");
//		testCreateProjectForUser("360", "gaoyinglong", "370105199512046531");
//		testCreateProjectForNewComer("30", "gaoyinglong","370105199512046531");
		testCreateProjectIncreaseInterests("90", "gaoyinglong", "370105199512046531");

	}

	public void testCreateProjectIncreaseInterests(String strDay, String strName,
			String strID) throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.linkText("������")).click();
		Thread.sleep(10000);
		iTotalNum += 373.11;
		iTotalNum=0.01;

//	    driver.findElement(By.id("ui-id-4")).click();
	    driver.findElement(By.xpath("//input[@type='text']")).clear();
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(strName);
	    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	    driver.findElement(By.linkText(strDay)).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(String.valueOf(iTotalNum));
	    driver.findElement(By.xpath("//input[@value='50.00']")).clear();
	    driver.findElement(By.xpath("//input[@value='50.00']")).sendKeys("0.01");
	    driver.findElement(By.xpath("(//input[@value='50.00'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@value='50.00'])[2]")).sendKeys("0.01");
	    driver.findElement(By.xpath("//input[@value='999999.00']")).clear();
	    driver.findElement(By.xpath("//input[@value='999999.00']")).sendKeys(String.valueOf(iTotalNum));
	    driver.findElement(By.xpath("(//input[@type='text'])[6]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("6");
	    driver.findElement(By.id("baseRate")).clear();
	    driver.findElement(By.id("baseRate")).sendKeys("1");
	    driver.findElement(By.cssSelector("span.glyphicon.glyphicon-calendar")).click();
	    //driver.findElement(By.cssSelector("#datetimepicker7 > span.input-group-addon > span.glyphicon.glyphicon-calendar")).click();
	    //driver.findElement(By.xpath("//div[@id='datetimepicker7']/div/ul/li/div/div/table/tbody/tr[2]/td[5]")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys(
				"2016-09-30 23:00");
		
		//��Ϣ
	    driver.findElement(By.id("extra")).click();

	    
        driver.findElement(By.xpath("(//input[@type='text'])[10]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("gaoyinglong");
	    driver.findElement(By.xpath("(//input[@type='text'])[11]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("11");
	    
	    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		Thread.sleep(2000);
	    driver.findElement(By.linkText("Ů")).click();

	    driver.findElement(By.xpath("(//input[@type='text'])[12]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys(strID);
	    
	    driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		Thread.sleep(2000);
	    driver.findElement(By.linkText("�ѻ�")).click();

	    driver.findElement(By.xpath("(//input[@type='text'])[13]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[13]")).sendKeys("13");
	    driver.findElement(By.xpath("(//input[@type='text'])[14]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys("14");
	    driver.findElement(By.xpath("(//input[@type='text'])[15]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[15]")).sendKeys("15");
	    driver.findElement(By.xpath("(//input[@type='text'])[16]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[16]")).sendKeys("16");
	    driver.findElement(By.xpath("(//input[@type='text'])[17]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[17]")).sendKeys("17");
	    driver.findElement(By.xpath("(//input[@type='text'])[18]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[18]")).sendKeys("18");
	    driver.findElement(By.xpath("(//input[@type='text'])[19]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[19]")).sendKeys("19");
	    driver.findElement(By.xpath("(//input[@type='text'])[20]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[20]")).sendKeys("20");
	    driver.findElement(By.xpath("(//input[@type='text'])[21]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[21]")).sendKeys("21");
	    driver.findElement(By.xpath("(//input[@type='text'])[22]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[22]")).sendKeys("22");
	    driver.findElement(By.xpath("(//input[@type='text'])[23]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[23]")).sendKeys("23");
	    driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		
		
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.linkText("�༭")).click();
		Thread.sleep(10000);

	    driver.findElement(By.xpath("(//button[@type='button'])[10]")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		// driver.findElement(By.linkText("���еĽ��")).click();
		// Thread.sleep(1000);

	}
	
	public void testCreateProjectForUser(String strDay, String strName,
			String strID) throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.linkText("������")).click();
		Thread.sleep(10000);
		iTotalNum += 373.11;
		iTotalNum=0.01;

//	    driver.findElement(By.id("ui-id-4")).click();
	    driver.findElement(By.xpath("//input[@type='text']")).clear();
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(strName);
	    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	    driver.findElement(By.linkText(strDay)).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(String.valueOf(iTotalNum));
	    driver.findElement(By.xpath("//input[@value='50.00']")).clear();
	    driver.findElement(By.xpath("//input[@value='50.00']")).sendKeys("0.01");
	    driver.findElement(By.xpath("(//input[@value='50.00'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@value='50.00'])[2]")).sendKeys("0.01");
	    driver.findElement(By.xpath("//input[@value='999999.00']")).clear();
	    driver.findElement(By.xpath("//input[@value='999999.00']")).sendKeys(String.valueOf(iTotalNum));
	    driver.findElement(By.xpath("(//input[@type='text'])[6]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("6");
	    driver.findElement(By.id("baseRate")).clear();
	    driver.findElement(By.id("baseRate")).sendKeys("1");
	    driver.findElement(By.cssSelector("span.glyphicon.glyphicon-calendar")).click();
	    //driver.findElement(By.cssSelector("#datetimepicker7 > span.input-group-addon > span.glyphicon.glyphicon-calendar")).click();
	    //driver.findElement(By.xpath("//div[@id='datetimepicker7']/div/ul/li/div/div/table/tbody/tr[2]/td[5]")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys(
				"2016-09-30 23:00");
        driver.findElement(By.xpath("(//input[@type='text'])[10]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("gaoyinglong");
	    driver.findElement(By.xpath("(//input[@type='text'])[11]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("11");
	    driver.findElement(By.xpath("(//input[@type='text'])[12]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys(strID);
	    driver.findElement(By.xpath("(//input[@type='text'])[13]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[13]")).sendKeys("13");
	    driver.findElement(By.xpath("(//input[@type='text'])[14]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys("14");
	    driver.findElement(By.xpath("(//input[@type='text'])[15]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[15]")).sendKeys("15");
	    driver.findElement(By.xpath("(//input[@type='text'])[16]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[16]")).sendKeys("16");
	    driver.findElement(By.xpath("(//input[@type='text'])[17]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[17]")).sendKeys("17");
	    driver.findElement(By.xpath("(//input[@type='text'])[18]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[18]")).sendKeys("18");
	    driver.findElement(By.xpath("(//input[@type='text'])[19]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[19]")).sendKeys("19");
	    driver.findElement(By.xpath("(//input[@type='text'])[20]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[20]")).sendKeys("20");
	    driver.findElement(By.xpath("(//input[@type='text'])[21]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[21]")).sendKeys("21");
	    driver.findElement(By.xpath("(//input[@type='text'])[22]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[22]")).sendKeys("22");
	    driver.findElement(By.xpath("(//input[@type='text'])[23]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[23]")).sendKeys("23");
	    driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		
		
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.linkText("�༭")).click();
		Thread.sleep(10000);

	    driver.findElement(By.xpath("(//button[@type='button'])[10]")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		// driver.findElement(By.linkText("���еĽ��")).click();
		// Thread.sleep(1000);

	}


	public void testCreateProjectForNewComer(String strDay, String strName,
			String strID) throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.linkText("������")).click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("������Ѻ���")).click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(strName);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(
				strName);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(
				strID);
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[4]"))
				.sendKeys("1");
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		driver.findElement(By.linkText(strDay)).click();
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[5]"))
				.sendKeys("1");
		// driver.findElement(By.xpath("//input[@value='10.00']")).clear();
		// driver.findElement(By.xpath("//input[@value='10.00']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@value='50.00']")).clear();
		driver.findElement(By.xpath("//input[@value='50.00']")).sendKeys("1");
		driver.findElement(By.xpath("(//input[@value='50.00'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@value='50.00'])[2]")).sendKeys(
				"0.01");
		driver.findElement(By.xpath("//input[@value='999999.00']")).clear();
		driver.findElement(By.xpath("//input[@value='999999.00']")).sendKeys(
				"1");

		// ����ר��
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		driver.findElement(By.linkText("����ר��")).click();

		driver.findElement(By.xpath("(//input[@type='text'])[9]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[9]"))
				.sendKeys("1");
		driver.findElement(By.id("baseRate")).clear();
		driver.findElement(By.id("baseRate")).sendKeys("1");

		// Start time
		driver.findElement(By.cssSelector("span.glyphicon.glyphicon-calendar"))
				.click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//div[@id='datetimepicker6']/div/ul/li/div/div/table/tbody/tr[2]/td[4]"))
				.click();
		Thread.sleep(1000);

		// End time
		driver.findElement(By.xpath("(//input[@type='text'])[12]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys(
				"2017-06-30 23:00");

		driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		Thread.sleep(500);
		driver.switchTo().alert().accept();
		driver.findElement(By.linkText("�༭")).click();

		Thread.sleep(8000);

		driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

	}


	public void verifyFirstPage(String strContent) {
		assertTrue(strContent
				.contains("�ͷ��绰��400-169-1188<time>������ʱ�䣺9:00��20:00��"));
		assertTrue(strContent.contains("'16��������','��ҳ'"));
		assertTrue(strContent.contains("'17��������','��ҪͶ��'"));
		assertTrue(strContent.contains("'18��������','�ҵ��˻�'"));
		assertTrue(strContent.contains("����ָ��"));
		assertTrue(strContent.contains("��������"));
		assertTrue(strContent.contains("���¹���"));
		// assertTrue(strContent.contains("������Ͷ�����淭��"));
		// assertTrue(strContent.contains("�Ƽ�������0ԪͶ��׬���棬��������Ӷ��"));
		// assertTrue(strContent.contains("��������"));
		// assertTrue(strContent.contains("��ļ����"));
		// assertTrue(strContent.contains("App����"));
		assertTrue(strContent.contains("���ڴ������"));
		assertTrue(strContent.contains("���46�����ڴ�����棬���Ͷ���ż�50Ԫ"));
		assertTrue(strContent.contains("�������ʽ��йܣ�������֧��"));
		assertTrue(strContent.contains("������ҵͶ�ʣ��ʽ����ݾ���ȫ"));
		assertTrue(strContent.contains("���ּ�Ϣȯ"));
		assertTrue(strContent.contains("30</i>��"));
		assertTrue(strContent.contains("90</i>��"));
		assertTrue(strContent.contains("180</i>��"));
		assertTrue(strContent.contains("360</i>��"));
		assertTrue(strContent.contains("�������"));
		assertTrue(strContent.contains("��ַ�������з�̨������12����·��ͼ����8��"));
		assertTrue(strContent.contains("Ͷ�ʲ�Ʒ"));
		assertTrue(strContent.contains("�ҵ��ʻ�"));
		assertTrue(strContent.contains("�Ƽ�����"));
		assertTrue(strContent.contains("��Ӫ����"));
		assertTrue(strContent.contains("�ͷ����䣺kefu@tuotiansudai.com"));
		assertTrue(strContent.contains("����ΰҵ(����)������Ϣ�������޹�˾ ��Ȩ����"));
		assertTrue(strContent.contains("��������"));
		assertTrue(strContent.contains("��ICP��15035567��-1"));

	}

	@Test
	public void testFirstPage() throws Exception {
		driver.get(backUrl);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));
		String strContent = driver.getPageSource();
		verifyFirstPage(strContent);

		driver.findElement(By.cssSelector("div.media-logo-list.fr")).click();

		driver.findElement(By.cssSelector("div.icon-hover.img-icon-off-1"))
				.click();
		Thread.sleep(2000);
		switchWindow("��ȫ����");
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("div.icon-hover.img-icon-off-2"))
				.click();
		Thread.sleep(2000);
		switchWindow("��ȫ����");
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("div.icon-hover.img-icon-off-3"))
				.click();
		Thread.sleep(2000);
		switchWindow("��ȫ����");
		Thread.sleep(2000);

		// driver.findElement(By.cssSelector("div.page-width.clearfix > img.page-img")).click();

		driver.findElement(By.cssSelector("div.company-up > a")).click();
		Thread.sleep(3000);
		switchWindow("���ָ���_��������Ͷ��_�����ٴ�");
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("i.img-jingdu")).click();
		Thread.sleep(3000);
		switchWindow("��ҳ_������ʦ������");
		Thread.sleep(2000);

		driver.findElement(By.linkText("Ͷ�ʲ�Ʒ")).click();
		Thread.sleep(2000);
		assertTrue(driver.getTitle().equals("Ͷ���б�_Ͷ�ʲ�Ʒ_�����ٴ�"));
		driver.navigate().back();
		Thread.sleep(2000);

//		driver.findElement(By.linkText("�����ʲ�")).click();
//		Thread.sleep(3000);
//		switchWindow("����ΰҵ���������ʲ��������޹�˾");
//		Thread.sleep(2000);

	}

	@Test
	public void testLogo() throws Exception {
		try {
			driver.get(backUrl);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));
			driver.findElement(By.cssSelector("a.logo")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));
		} catch (Exception e) {
			File img = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(img, new File("c:/test/logo.jpg"));
			e.printStackTrace();
			assertTrue(false);

		}

	}


	@Test
	public void testActivityAndMembership() throws Exception {
		driver.get(backUrl);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));

		driver.findElement(By.linkText("��Ա����")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("��Ա����_��Ա����_�����ٴ�"));

		driver.findElement(By.linkText("������ҳ")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));
		driver.findElement(By.linkText("�����")).click();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("�����_Ͷ�ʻ_�����ٴ�"));
	}

	@Test
	public void testLogin() throws Exception {

		try {
			driver.get(backUrl);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));

			driver.findElement(By.linkText("��¼")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("��¼�����ٴ�_�����ٴ�"));


		    login(this.mobile_change_password,newPassword);
////			driver.findElement(By.id("logout-link")).click();
////			Thread.sleep(3000);
//
			driver.findElement(By.linkText("���ע��")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("�����ٴ�ע��_�û�ע��_�����ٴ�"));
			driver.navigate().back();

			Thread.sleep(3000);
			driver.findElement(By.linkText("�������룿")).click();
			Thread.sleep(2000);
			driver.findElement(By.name("mobile")).click();
			driver.findElement(By.name("mobile")).clear();
			driver.findElement(By.name("mobile")).sendKeys(this.mobile_change_password);
			
			
			driver.findElement(By.name("captcha")).click();
			Thread.sleep(2000);
//		    driver.findElement(By.cssSelector("button.fetch-captcha.btn")).click();
		    driver.findElement(By.cssSelector("button.fetch-captcha.btn-normal")).click();
			Thread.sleep(3000);
		    
		    driver.findElement(By.cssSelector("input.verification-code-text.input-control")).clear();
		    driver.findElement(By.cssSelector("input.verification-code-text.input-control")).sendKeys("kkkkk");
		    driver.findElement(By.cssSelector("button.image-captcha-confirm.btn-success")).click();

			Thread.sleep(10000);
			driver.findElement(By.name("captcha")).clear();
			driver.findElement(By.name("captcha")).sendKeys(this.getCaptcha(this.mobile_change_password,"RETRIEVE_PASSWORD_CAPTCHA"));
			Thread.sleep(2000);

			driver.findElement(
			By.cssSelector("input.btn-send-form.btn-success")).click();

			Thread.sleep(2000);
		    driver.findElement(By.id("newPassword")).click();
		    driver.findElement(By.id("newPassword")).clear();
		    driver.findElement(By.id("newPassword")).sendKeys(newPassword);
		    driver.findElement(By.name("repeatPassword")).clear();
		    driver.findElement(By.name("repeatPassword")).sendKeys(newPassword);
		    driver.findElement(By.cssSelector("input.btn-send-form-second.btn-success")).click();

		    login(this.mobile_change_password,newPassword);
		    
			if(this.isElementPresent(By.linkText("����ʹ��")))
			{
			    driver.findElement(By.linkText("����ʹ��")).click();
				Thread.sleep(3000);
			    driver.findElement(By.linkText("��ҪͶ��")).click();
				Thread.sleep(3000);
			}

		    
		    driver.findElement(By.linkText("�ҵ��˻�")).click();
			Thread.sleep(3000);
		    driver.findElement(By.linkText("��������")).click();
			Thread.sleep(3000);
		    driver.findElement(By.cssSelector("a.setlink.setPass")).click();
			Thread.sleep(3000);
		    driver.findElement(By.id("originalPassword")).clear();
		    driver.findElement(By.id("originalPassword")).sendKeys(newPassword);
		    driver.findElement(By.id("newPassword")).clear();
		    driver.findElement(By.id("newPassword")).sendKeys(oldPassword);
		    driver.findElement(By.id("newPasswordConfirm")).clear();
		    driver.findElement(By.id("newPasswordConfirm")).sendKeys(oldPassword);
			Thread.sleep(3000);
		    driver.findElement(By.cssSelector("form[name=\"changePasswordForm\"] > button.btn.btn-normal")).click();
			Thread.sleep(3000);

			driver.findElement(By.linkText("��¼")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("��¼�����ٴ�_�����ٴ�"));
			
		    login(this.mobile_change_password,oldPassword);

//			driver.findElement(By.id("logout-link")).click();
//			Thread.sleep(3000);

//			driver.findElement(By.name("captcha")).clear();
//			driver.findElement(By.name("captcha")).sendKeys("kkkkk");
//			Thread.sleep(2000);
//
//			driver.findElement(
//					By.cssSelector("input.btn-send-form.btn-success")).click();
//			assertTrue(driver.findElement(By.id("mobile-error")).getText()
//					.equals("�ֻ��Ų�����"));
//			assertTrue(driver.findElement(By.id("captcha-error")).getText()
//					.equals("��֤���ʽ����ȷ"));
			
			
		} catch (Exception e) {
			File img = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(img, new File("c:/test/login.jpg"));
			e.printStackTrace();
			assertTrue(false);

		}

	}

	private void login(String mobile, String password) throws Exception{
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(mobile);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("captcha")).clear();
		driver.findElement(By.name("captcha")).sendKeys("kkkkk");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.login-submit.btn-normal"))
				.click();
		Thread.sleep(3000);

	}

	@Test
	public void test5888banner() throws Exception {
		driver.get(backUrl + "activity/landing-page");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("���ָ���_��������Ͷ��_�����ٴ�"));

		// driver.findElement(By.id("login-name")).click();
		// driver.findElement(By.id("login-name")).clear();
		// driver.findElement(By.id("login-name")).sendKeys("mintest");
		try {
			driver.findElement(By.id("login-name")).click();			
			assertTrue(false);
		} catch (Exception e) {
			System.out.println("No username");
		}

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a > img")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("Ͷ���б�_Ͷ�ʲ�Ʒ_�����ٴ�"));
		Thread.sleep(2000);
		
		driver.navigate().back();
		Thread.sleep(2000);
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("123abc");
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys(mobile_register);
		driver.findElement(By.id("appCaptcha")).click();
		driver.findElement(By.id("appCaptcha")).clear();
		driver.findElement(By.id("appCaptcha")).sendKeys("kkkkk");
		driver.findElement(By.name("captcha")).click();
		Thread.sleep(2000);
	    driver.findElement(By.cssSelector("button.fetch-captcha.btn")).click();
		Thread.sleep(10000);
		driver.findElement(By.name("captcha")).clear();
		driver.findElement(By.name("captcha")).sendKeys(this.getCaptcha(mobile_register,"REGISTER_CAPTCHA"));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.register-user")).click();
		Thread.sleep(2000);
		doUserInvest();
		Thread.sleep(2000);

		newComer=this.getLoginName();
		deleteExistedUser();


	}

	@Test
	public void test5888bannerApp() throws Exception {
		driver.get(backUrl + "activity/landing-page-app");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("����5888Ԫ�����"));

		// driver.findElement(By.id("login-name")).click();
		// driver.findElement(By.id("login-name")).clear();
		// driver.findElement(By.id("login-name")).sendKeys("mintest");
		try {
			driver.findElement(By.id("login-name")).click();
			
			assertTrue(false);
		} catch (Exception e) {
			System.out.println("No user");
		}

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("123abc");
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys("13699160900");
		Thread.sleep(1000);
		driver.findElement(By.id("appCaptcha")).click();
		driver.findElement(By.id("appCaptcha")).clear();
		driver.findElement(By.id("appCaptcha")).sendKeys("kkkkk");
		Thread.sleep(1000);
		// driver.findElement(By.cssSelector("a > img")).click();
		// Thread.sleep(1000);
		// assertTrue(driver.getTitle().equals("Ͷ���б�_Ͷ�ʲ�Ʒ_�����ٴ�"));
	}

	@Test
	public void test5888bannerApp2() throws Exception {
		driver.get(backUrl + "activity/landing-page?from=singlemessage&isappinstalled=1");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("���ָ���_��������Ͷ��_�����ٴ�"));

		try {
			driver.findElement(By.id("login-name")).click();
			
			assertTrue(false);
		} catch (Exception e) {
			System.out.println("No user");
		}

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a > img")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("Ͷ���б�_Ͷ�ʲ�Ʒ_�����ٴ�"));
		Thread.sleep(2000);
		
		driver.navigate().back();
		Thread.sleep(2000);

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("123abc");
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys(mobile_register);
		driver.findElement(By.id("appCaptcha")).click();
		driver.findElement(By.id("appCaptcha")).clear();
		driver.findElement(By.id("appCaptcha")).sendKeys("kkkkk");
		driver.findElement(By.name("captcha")).click();
		Thread.sleep(2000);
	    driver.findElement(By.cssSelector("button.fetch-captcha.btn")).click();
		Thread.sleep(10000);
		driver.findElement(By.name("captcha")).clear();
		driver.findElement(By.name("captcha")).sendKeys("kkkkk");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.register-user")).click();
		Thread.sleep(2000);

	}

	@Test
	public void testShareReward() throws Exception {
		driver.get(backUrl + "activity/share-reward");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("�Ƽ�����_�����ٴ�"));

		driver.findElement(By.linkText("�����Ƽ�")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("��¼�����ٴ�_�����ٴ�"));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("gaoyinglong");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("123abc");
		driver.findElement(By.name("captcha")).clear();
		driver.findElement(By.name("captcha")).sendKeys("kkkkk");
		Thread.sleep(1000);

	}

	@Test
	public void testAppDownload() throws Exception {
		driver.get(backUrl + "activity/app-download");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("�����ٴ��ֻ��ͻ���_��ƿͻ���_�����ٴ�"));

		driver.findElement(By.cssSelector("a.ios")).click();
		Thread.sleep(1000);

		switchWindow("�����ٴ����� App Store �ϵ�����");
		Thread.sleep(1000);
	}

	@Test
	public void testInvestAchievement() throws Exception {
		driver.get(backUrl + "activity/invest-achievement");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("Ͷ�ʳƺ�_����ƺ�_�����ٴ�"));
		driver.findElement(By.linkText("��Ҫ���ƺ�")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("Ͷ���б�_Ͷ�ʲ�Ʒ_�����ٴ�"));

	}

	@Test
	public void testBirthMonth() throws Exception {
		try {
			driver.get(backUrl + "activity/birth-month");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("��������Ȩ_����_�����ٴ�"));

			driver.findElement(
					By.xpath("//a[contains(@href, '/loan-list?durationStart=181&durationEnd=366&name=&status=&rateStart=0&rateEnd=0')]"))
					.click();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("Ͷ���б�_Ͷ�ʲ�Ʒ_�����ٴ�"));

			driver.navigate().back();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//a[contains(@href, '/loan-list?durationStart=91&durationEnd=180&name=&status=&rateStart=0&rateEnd=0')]"))
					.click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("Ͷ���б�_Ͷ�ʲ�Ʒ_�����ٴ�"));

			driver.navigate().back();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("a.click-btn.time-btn")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("Ͷ���б�_Ͷ�ʲ�Ʒ_�����ٴ�"));
		} catch (Exception e) {
			File img = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(img, new File("c:/test/birthmonth.jpg"));
			e.printStackTrace();
			assertTrue(false);

		}

	}

	@Test
	public void testOnline() throws Exception {
		try {
			driver.get(backUrl + "");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));

			WebElement element = driver
					.findElement(By
							.xpath("//div[@id='productFrame']/div[2]/div/ul/li/div/div[2]/dl[2]/dd"));
			assertTrue(element.getText().equals("30��"));
			driver.findElement(
					By.xpath("//div[@id='productFrame']/div[2]/div/ul/li/div/div[2]/dl[2]/dd/em"))
					.click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("�������"));
			driver.findElement(By.cssSelector("li.active")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//div/div[2]/div/ul/li[2]")).click(); // //div[3]/div/ul/li[2]
			Thread.sleep(4000);
			driver.findElement(By.cssSelector("li.active")).click();
			Thread.sleep(4000);
			driver.navigate().back();

			Thread.sleep(2000);
			element = driver
					.findElement(By
							.xpath("//div[@id='productFrame']/div[3]/div/ul/li/div/div[2]/dl[2]/dd"));
			// System.out.println("*********" + element.getText());
			Thread.sleep(4000);
			assertTrue(element.getText().equals("90��"));
			driver.findElement(
					By.xpath("//div[@id='productFrame']/div[3]/div/ul/li/div/div[2]/dl[2]/dd"))
					.click();
			Thread.sleep(4000);
			assertTrue(driver.getTitle().equals("�������"));

			driver.navigate().back();

			Thread.sleep(2000);
			element = driver
					.findElement(By
							.xpath("//div[@id='productFrame']/div[3]/div/ul/li[2]/div/div[2]/dl[2]/dd"));
			assertTrue(element.getText().equals("180��"));
			driver.findElement(
					By.xpath("//div[@id='productFrame']/div[3]/div/ul/li[2]/div/div[2]/dl[2]/dt"))
					.click();
			Thread.sleep(4000);
			assertTrue(driver.getTitle().equals("�������"));
			driver.navigate().back();

			Thread.sleep(2000);
			element = driver
					.findElement(By
							.xpath("//div[@id='productFrame']/div[3]/div/ul/li[3]/div/div[2]/dl[2]/dd"));
			assertTrue(element.getText().equals("360��"));
			driver.findElement(
					By.xpath("//div[@id='productFrame']/div[3]/div/ul/li[3]/div/div[2]/dl[2]/dt"))
					.click();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("�������"));
			driver.navigate().back();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));

			driver.findElement(
					By.cssSelector("dl.transfer-one > dd"))
					.click();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("�������"));
			driver.findElement(
					By.xpath("//div[3]/div/div[2]/div/ul/li[2]"))
					.click();
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));
			
		    driver.findElement(By.linkText("��ҪͶ��")).click();
			Thread.sleep(2000);
		    driver.findElement(By.linkText("ת����Ŀ")).click();
			Thread.sleep(2000);
		    driver.findElement(By.xpath("//dl[3]/dt")).click();
			Thread.sleep(2000);
		    driver.findElement(By.xpath("//div[3]/div/div[2]/div/ul/li[2]")).click();
			Thread.sleep(2000);

		} catch (Exception e) {
			File img = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(img, new File("c:/test/online.jpg"));
			e.printStackTrace();
			assertTrue(false);

		}

	}

	@Test
	public void testInvestPage() throws Exception {
		driver.get(backUrl + "");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));

		// try {
		driver.findElement(By.linkText("��ҪͶ��")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("Ͷ���б�_Ͷ�ʲ�Ʒ_�����ٴ�"));

		driver.findElement(By.linkText("ת����Ŀ")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("ծȨת��_ת����Ŀ_�����ٴ�"));
		driver.findElement(By.linkText("ת����")).click();
		Thread.sleep(1000);
		String strContent = driver.getPageSource();
		assertFalse(strContent.contains("��ת��"));
		driver.findElement(By.linkText("�����")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div.pagination")).click();

		driver.findElement(By.linkText("ֱͶ��Ŀ")).click();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("Ͷ���б�_Ͷ�ʲ�Ʒ_�����ٴ�"));
		driver.findElement(By.linkText("������Ѻ���")).click();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("������Ѻ���_Ͷ���б�_�����ٴ�"));
		strContent = driver.getPageSource();
		strContent = strContent.substring(8000);
		// System.out.println("*********" + strContent);
		assertFalse(strContent.contains("������Ѻ���"));

		driver.findElement(By.linkText("������Ѻ���")).click();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("������Ѻ���_Ͷ���б�_�����ٴ�"));
		strContent = driver.getPageSource();
		strContent = strContent.substring(8000);
		assertFalse(strContent.contains("������Ѻ���"));

		Thread.sleep(1000);
		driver.findElement(By.linkText("30������")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("31-90��")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("91-180��")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("180������")).click();

		Thread.sleep(1000);
		driver.findElement(By.linkText("��Ͷ��")).click();
		Thread.sleep(1000);
		strContent = driver.getPageSource();
		strContent = strContent.substring(9100);
		assertFalse(strContent.contains("������"));

		Thread.sleep(1000);
		driver.findElement(By.linkText("������")).click();
		Thread.sleep(1000);
		strContent = driver.getPageSource();
		strContent = strContent.substring(9100);
		assertFalse(strContent.contains("����Ͷ��"));

		Thread.sleep(1000);
		driver.findElement(By.linkText("�������")).click();
		Thread.sleep(1000);
		strContent = driver.getPageSource();
		strContent = strContent.substring(9100);
		assertFalse(strContent.contains("����Ͷ��"));

		Thread.sleep(1000);
		driver.findElement(By.linkText("Ԥ����")).click();
		Thread.sleep(1000);
		strContent = driver.getPageSource();
		strContent = strContent.substring(10100);
		assertFalse(strContent.contains("����Ͷ��"));
		assertFalse(strContent.contains("������"));

		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'ȫ��')])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'ȫ��')])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("10-12%")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("12-14%")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("14%����")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'ȫ��')])[4]")).click();

		// } catch (Exception e) {
		// File img = ((TakesScreenshot) driver)
		// .getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(img, new File("c:/test/i.jpg"));
		// assertTrue(false);
		// note
		// }
	}

	@Test
	public void testAccount() throws Exception {
		driver.get(backUrl + "");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));

		try {
			driver.findElement(By.linkText("�ҵ��˻�")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("��¼�����ٴ�_�����ٴ�"));
			
			login(this.mobile_change_password,this.oldPassword);

//			closeCoupon();
//			
//			if(this.isElementPresent(By.linkText("����ʹ��")))
//			{
//			    driver.findElement(By.linkText("����ʹ��")).click();
//				Thread.sleep(3000);
//			}
			
		    driver.findElement(By.linkText("�ҵ��˻�")).click();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("�˻�����"));
		    driver.findElement(By.linkText("����ʹ�ð�")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("�ҵı���"));
			
//			if(this.isElementPresent(By.linkText("����ʹ��")))
//			{
//			    driver.findElement(By.linkText("����ʹ��")).click();
//				Thread.sleep(3000);
//			    driver.findElement(By.linkText("�ҵ��˻�")).click();
//				Thread.sleep(2000);
//				assertTrue(driver.getTitle().equals("�˻�����"));
//			}

		    driver.findElement(By.linkText("�˻�����")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("�˻�����"));

		    driver.findElement(By.linkText("�˻�����")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("�˻�����"));
		    driver.findElement(By.xpath("(//a[contains(text(),'����...')])[3]")).click();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("Ͷ�ʼ�¼"));
		    driver.findElement(By.linkText("�˻�����")).click();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("�˻�����"));
		    driver.findElement(By.linkText("���´��ջؿ�")).click();
		    driver.findElement(By.linkText("�������ջؿ�")).click();
		    driver.findElement(By.cssSelector("a.user-info")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("��������"));

			driver.findElement(By.linkText("�ҵ�Ͷ��")).click();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("Ͷ�ʼ�¼"));
		    driver.findElement(By.xpath("//span[3]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//span[5]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//span[6]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[2]/span[3]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[2]/span[4]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[2]/span[5]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[2]/span[6]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//a[2]/em")).click();
			Thread.sleep(1000);
		    driver.findElement(By.cssSelector("span.select-item.current")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//span[3]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//span[5]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//span[6]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[2]/span[3]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[2]/span[4]")).click();
			Thread.sleep(1000);
			
		    driver.findElement(By.linkText("ծȨת��")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("ծȨת��"));
			
		    driver.findElement(By.linkText("ת����ծȨ")).click();
			Thread.sleep(1000);
		    driver.findElement(By.linkText("ת����ծȨ")).click();
			Thread.sleep(1000);
			
		    driver.findElement(By.linkText("�ʽ����")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("�ʽ����"));
		    driver.findElement(By.cssSelector("span.select-item.current")).click();
			Thread.sleep(1000);
		    driver.findElement(By.cssSelector("span.select-item.current")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//span[3]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//span[5]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//span[6]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[4]/span[3]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[4]/span[4]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[4]/span[5]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[4]/span[6]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//span[7]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//span[8]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.linkText("Ͷ��")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("Ͷ���б�_Ͷ�ʲ�Ʒ_�����ٴ�"));
			driver.navigate().back();
			Thread.sleep(1000);
			
		    driver.findElement(By.linkText("��Ϣ����")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("��Ϣ����"));
			
		    driver.findElement(By.linkText("�ҵĲƶ�")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("�ҵĲƶ�"));
		    driver.findElement(By.id("beansDetail")).click();
			Thread.sleep(1000);
		    driver.findElement(By.linkText("�ҵĲƶ�")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("�ҵĲƶ�"));
			//ȥͶ��
		    driver.findElement(By.cssSelector("span.btn-invest")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("Ͷ���б�_Ͷ�ʲ�Ʒ_�����ٴ�"));
			driver.navigate().back();
			Thread.sleep(1000);
			//������
		    driver.findElement(By.id("taskBtn")).click();
			Thread.sleep(1000);
		    driver.findElement(By.cssSelector("div.tc.button-more > a > span")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//em[2]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//em[3]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//em[4]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.cssSelector("span.select-item.current")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//span[3]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//span[5]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//span[6]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[2]/span[3]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[2]/span[4]")).click();
			Thread.sleep(1000);

			
		    driver.findElement(By.linkText("��������")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("��������"));
			Thread.sleep(2000);
		    driver.findElement(By.linkText("�ر�")).click();
			Thread.sleep(1000);
		    driver.findElement(By.name("imageCaptcha")).clear();
		    driver.findElement(By.name("imageCaptcha")).sendKeys("kkkkk");
		    driver.findElement(By.name("captcha")).click();
			Thread.sleep(1000);
		    driver.findElement(By.cssSelector("button.btn-normal.get-captcha")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.name("captcha")).clear();
		    driver.findElement(By.name("captcha")).sendKeys(getCaptcha(this.mobile_change_password,"TURN_OFF_NO_PASSWORD_INVEST"));
		    driver.findElement(By.xpath("(//button[@type='submit'])[5]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.linkText("����")).click();
			Thread.sleep(1000);

		} catch (Exception e) {
			File img = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(img, new File("c:/test/account1.jpg"));
			e.printStackTrace();
			assertTrue(false);
		}
	}

	@Test
	public void testAccount2() throws Exception {
		driver.get(backUrl + "");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));

//		try {
			driver.findElement(By.linkText("�ҵ��˻�")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("��¼�����ٴ�_�����ٴ�"));
			
			login(this.mobile_change_password,this.oldPassword);

//			if(this.isElementPresent(By.linkText("����ʹ��")))
//			{
//			    driver.findElement(By.linkText("����ʹ��")).click();
//				Thread.sleep(3000);
//			}
//			
//			closeCoupon();
			
		    driver.findElement(By.linkText("�ҵ��˻�")).click();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("�˻�����"));

			
		    driver.findElement(By.linkText("�Զ�Ͷ��")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("�Զ�Ͷ��"));
			
			if(this.isElementPresent(By.id("editSetting")))
			{
			    driver.findElement(By.id("editSetting")).click();
				Thread.sleep(2000);
			}
			
		    driver.findElement(By.name("minInvestAmount")).click();
		    driver.findElement(By.name("minInvestAmount")).clear();
		    driver.findElement(By.name("minInvestAmount")).sendKeys("1");
		    driver.findElement(By.name("maxInvestAmount")).click();
		    driver.findElement(By.name("maxInvestAmount")).clear();
		    driver.findElement(By.name("maxInvestAmount")).sendKeys("2");
		    driver.findElement(By.name("retentionAmount")).click();
		    driver.findElement(By.name("retentionAmount")).clear();
		    driver.findElement(By.name("retentionAmount")).sendKeys("3");
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//form[@id='signPlanForm']/dl[5]/dd/span[2]")).click();
		    driver.findElement(By.xpath("//form[@id='signPlanForm']/dl[5]/dd/span[3]")).click();
		    driver.findElement(By.xpath("//form[@id='signPlanForm']/dl[5]/dd/span[7]")).click();
		    driver.findElement(By.id("saveInvestPlan")).click();
			Thread.sleep(2000);
		    driver.findElement(By.id("editSetting")).click();
			Thread.sleep(3000);
		    driver.findElement(By.xpath("//form[@id='signPlanForm']/dl/dd/label[2]")).click();
			Thread.sleep(2000);
//			driver.findElement(By.id("plan-close")).click();
//			Thread.sleep(3000);
		    driver.findElement(By.linkText("��������")).click();
			Thread.sleep(1000);
		    driver.findElement(By.linkText("�Զ�Ͷ��")).click();
			Thread.sleep(1000);
		    driver.findElement(By.cssSelector("label.radio")).click();
			Thread.sleep(2000);
		    driver.findElement(By.xpath("//form[@id='signPlanForm']/dl[5]/dd/span[5]")).click();
			Thread.sleep(2000);
		    driver.findElement(By.id("saveInvestPlan")).click();
			Thread.sleep(2000);
		    driver.findElement(By.linkText("��������")).click();
			Thread.sleep(2000);
		    driver.findElement(By.linkText("�Զ�Ͷ��")).click();
			Thread.sleep(2000);
		    driver.findElement(By.id("editSetting")).click();
			Thread.sleep(2000);
			
		    driver.findElement(By.linkText("�Ƽ�����")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("�Ƽ�����"));
			
		    driver.findElement(By.linkText("�ҵı���")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("�ҵı���"));
		    driver.findElement(By.cssSelector("body")).click();
			Thread.sleep(1000);
		    driver.findElement(By.id("couponByCode")).clear();
		    driver.findElement(By.id("couponByCode")).sendKeys("DMMV4Z3NEPXXVQ");
			Thread.sleep(1000);
		    driver.findElement(By.id("submitCode")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[3]/div[2]/ul/li[2]")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[3]/div[2]/ul/li[3]")).click();
			Thread.sleep(1000);
}

	@Test
	public void testAbout() throws Exception {
		driver.get(backUrl + "");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));
		String strContent = "";

		// try {
		driver.findElement(By.linkText("��������")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("�����ٴ���˾����_��������_��������_�����ٴ�"));
		strContent = driver.getPageSource();
		assertTrue(strContent
				.contains("�����ٴ��ǻ��ڻ������Ľ�����Ϣ����ƽ̨��������ΰҵ���������ʲ��������޹�˾���µ�����ΰҵ��������������Ϣ�������޹�˾��Ӫ"));
		assertTrue(strContent.contains("�԰�ȫ�����š�רҵ�����¡���ԶΪ���ļ�ֵ��"));

		driver.findElement(By.linkText("�Ŷӽ���")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("�����Ŷ�_���ھ�Ӣ_�����ٴ�"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("����Ϊ��������Ҫ��һƬ��"));
		assertTrue(strContent.contains("ʱ���̺����������³ɾ�ΰҵ"));

		driver.findElement(By.linkText("���칫��")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("���칫��_����_�����ٴ�"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("���칫��"));

		driver.findElement(By.linkText("ý�屨��")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("��������ý�屨��_�����ٴ�"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("ý�屨��"));

		driver.findElement(By.linkText("�Ƽ�����")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("�Ƽ�����_�����ٴ�"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("ÿ���������Ϊ���Ƽ���Ͷ�ʱ���Ԥ���껯�����1%"));
		assertTrue(strContent.contains("�����������ϵ��Ƽ���С�Ų���ý���"));

		driver.findElement(By.linkText("�������")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("�����ٴ�����_�����ٴ�"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("Ͷ������Ԥ�������10%"));
		assertTrue(strContent.contains("ÿ������������2.00Ԫ��������Ͷ���˳е�"));

		driver.findElement(By.linkText("��������")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("�����ٴ����_רҵ��P2P���_���������ѯ���ƽ̨"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("Ŀǰ��֧�ִ�½���������֤"));
		assertTrue(strContent
				.contains("ԭ����֧��T+0�յ��ˣ�����16��00ǰ���ֵ��쵽�ˣ�����16:00�����ִ���11:00ǰ���ˣ��ڼ������Ƴ�����һ��������"));

		driver.findElement(By.linkText("��ϵ����")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("��ϵ����_�����ٴ���ַ_�����ٴ���ϵ��ʽ"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("�ͷ����ߣ�400-169-1188"));
		assertTrue(strContent.contains("�����з�̨������12����·��ͼ����8��"));

		driver.findElement(By.linkText("��Ӫ����")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("��Ӫ����_��Ϣ��ȫ����_�����ٴ�"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("��ȫ��Ӫʱ��"));
		assertTrue(strContent.contains("ע��Ͷ���û�"));
		assertTrue(strContent.contains("�ۼƽ��׽��"));
		assertTrue(strContent.contains("ƽ̨�ۼ�Ͷ��"));
		assertTrue(strContent.contains("ƽ̨Ͷ����ϸ"));

		driver.findElement(By.linkText("��Ա����")).click();
		Thread.sleep(2000);
		assertTrue(driver.getTitle().equals("��Ա����_��Ա����_�����ٴ�"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("�ף���Ϊ��Ա�����ܶ�����ȨŶ~"));
		assertTrue(strContent.contains("��Ա����"));

		driver.findElement(By.linkText("�ɳ���ϵ")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("��Ա��ϵ_��Ա����_�����ٴ�"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("�����ٴ���Ա����"));
		assertTrue(strContent.contains("�ɳ�ֵ��ϸ"));

		driver.findElement(By.linkText("��Ա��Ȩ")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("��Ա��Ȩ_��Ա����_�����ٴ�"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("��Ա��Ȩ"));
		assertTrue(strContent.contains("��Ȩ˵��"));

		driver.findElement(By.linkText("��Ӫ����")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("��Ӫ����_��Ϣ��ȫ����_�����ٴ�"));
		driver.findElement(By.linkText("�����")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("�����_Ͷ�ʻ_�����ٴ�"));

		// } catch (Exception e) {
		// File img = ((TakesScreenshot) driver)
		// .getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(img, new File("D:/javatest/i.jpg"));
		// assertTrue(false);
		//
		// }
	}

	@Test
	public void testAskSystem() throws Exception {
		driver.get(backUrl + "");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("�����ٴ�-������������Ϣ����ƽ̨"));

		// try {
		driver.findElement(By.linkText("�ҵ��˻�")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("��¼�����ٴ�_�����ٴ�"));

		driver.findElement(By.linkText("�ʴ�")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("�����ٴ�"));
		driver.findElement(By.linkText("���������")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("��������")).click();
		Thread.sleep(1000);

		driver.findElement(By.linkText("��Ҫ����")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("�����ٴ�"));
		// click ��¼
		driver.findElement(By.cssSelector("span.isAnonymous.ask-con > a"))
				.click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("��¼�����ٴ�_�����ٴ�"));
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'ע��')])[2]")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("�����ٴ�ע��_�û�ע��_�����ٴ�"));
		driver.navigate().back();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//a[contains(text(),'ע��')])[2]")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("�����ٴ�ע��_�û�ע��_�����ٴ�"));
		driver.navigate().back();
		Thread.sleep(1000);
		// click ��¼
		driver.findElement(By.cssSelector("a.btn")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("��¼�����ٴ�_�����ٴ�"));
		//driver.navigate().back();
		Thread.sleep(1000);
		
		login("mintest", this.oldPassword);

	    driver.findElement(By.linkText("�ʴ�")).click();
		Thread.sleep(1000);
	    driver.findElement(By.linkText("��Ҫ����")).click();
		Thread.sleep(1000);
	    driver.findElement(By.name("question")).clear();
	    driver.findElement(By.name("question")).sendKeys("��������ʲô�");
	    driver.findElement(By.name("addition")).clear();
	    driver.findElement(By.name("addition")).sendKeys("���ﵽ�ˣ����±���");
		Thread.sleep(3000);
	    driver.findElement(By.name("captcha")).clear();
	    driver.findElement(By.name("captcha")).sendKeys("kkkkk");
		Thread.sleep(2000);
	    driver.findElement(By.xpath("(//a[contains(text(),'�ҵĻش�')])[2]")).click();
		Thread.sleep(1000);
	    driver.findElement(By.cssSelector("#my-questions-tab > li > a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("�ʴ�")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("�����ٴ�"));
		driver.findElement(By.linkText("���������")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("��������")).click();
		Thread.sleep(1000);

		// } catch (Exception e) {
		// File img = ((TakesScreenshot) driver)
		// .getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(img, new File("D:/javatest/asksystem.jpg"));
		// assertTrue(false);
		// }
	}


	private void switchWindow(String strTitle) {
		String currentWindow = driver.getWindowHandle();// ��ȡ��ǰ���ھ��
		Set<String> handles = driver.getWindowHandles();// ��ȡ���д��ھ��
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
				continue;
			}
			WebDriver window = driver.switchTo().window(it.next());// �л����´���
			assertTrue(window.getTitle().equals(strTitle));
			window.close();// �ر��´���
		}
		driver.switchTo().window(currentWindow);// �ص�ԭ��ҳ��
	}

	
	private void switchWindowWithdrawAndRecharge(String strTitle) throws Exception{
		String currentWindow = driver.getWindowHandle();// ��ȡ��ǰ���ھ��
		Set<String> handles = driver.getWindowHandles();// ��ȡ���д��ھ��
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
				continue;
			}
			WebDriver window = driver.switchTo().window(it.next());// �л����´���
			assertTrue(window.getTitle().equals(strTitle));
			Thread.sleep(2000);
			
			driver.findElement(By.id("btn")).click();
			Thread.sleep(2000);
		
			window.close();// �ر��´���
		}
		driver.switchTo().window(currentWindow);// �ص�ԭ��ҳ��
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}


}
