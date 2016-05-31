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

		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";

		// URL指向要访问的数据库名scutcs
		String url = "jdbc:mysql://"+dbUrl + ":3306/aa";

		// MySQL配置时的用户名
		String user = "root";

		// MySQL配置时的密码
		String password = "";

		try {
			// 加载驱动程序
			Class.forName(driver);

			// 连续数据库
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

			// statement用来执行SQL语句
			Statement statement = conn.createStatement();

			// 要执行的SQL语句
			String sql = "SELECT captcha FROM sms_captcha WHERE mobile = '" + strMobile
					+ "' and captcha_type= '" + strCaptchaType + "'";

			// 结果集
			rs = statement.executeQuery(sql);

			String name = null;

			while (rs.next()) {

				// 选择captcha这列数据
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
			// 加载驱动程序

			// statement用来执行SQL语句
			Statement statement = conn.createStatement();

			// 要执行的SQL语句
			String sql = "SELECT referrer FROM user WHERE mobile = '" + this.mobile_register + "'";

			// 结果集
			rs = statement.executeQuery(sql);

			System.out.println("-----------------");
			System.out.println("执行结果如下所示:");
			System.out.println("-----------------");
			System.out.println(" referrer");
			System.out.println("-----------------");

			String name = null;

			if (rs.next()) {

				// 选择captcha这列数据
				name = rs.getString("referrer");

				// 输出结果
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
			// 加载驱动程序

			// statement用来执行SQL语句
			Statement statement = conn.createStatement();

			// 要执行的SQL语句
			String sql = "SELECT login_name FROM user WHERE mobile = '" + mobile_register + "'";

			// 结果集
			rs = statement.executeQuery(sql);

			System.out.println("-----------------");
			System.out.println("执行结果如下所示:");
			System.out.println("-----------------");
			System.out.println(" login_name");
			System.out.println("-----------------");

			String name = null;

			if (rs.next()) {

				// 选择captcha这列数据
				name = rs.getString("login_name");

				// 输出结果
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

		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";

		// URL指向要访问的数据库名scutcs
		String url = "jdbc:mysql://192.168.1.132:3306/aa";

		// MySQL配置时的用户名
		String user = "root";

		// MySQL配置时的密码
		String password = "";
		Connection conn = null;
		ResultSet rs = null;

		try {
			// 加载驱动程序
			Class.forName(driver);

			// 连续数据库
			conn = DriverManager.getConnection(url, user, password);

			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");

			// statement用来执行SQL语句
			Statement statement = conn.createStatement();

			// 要执行的SQL语句
			String sql = "select id,login_name from user";

			// 结果集
			rs = statement.executeQuery(sql);

			System.out.println("-----------------");
			System.out.println("执行结果如下所示:");
			System.out.println("-----------------");
			System.out.println(" 学号" + "\t" + " 姓名");
			System.out.println("-----------------");

			String name = null;

			while (rs.next()) {

				// 选择login_name这列数据
				name = rs.getString("login_name");

				// 首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
				// 然后使用GB2312字符集解码指定的字节数组
				name = new String(name.getBytes("ISO-8859-1"), "GB2312");

				// 输出结果
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
	    driver.findElement(By.linkText("安全管理")).click();
		Thread.sleep(3000);
	    driver.findElement(By.linkText("清除DB Cache")).click();
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@value='一键清空Mybatis DB Cache']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	    driver.findElement(By.id("logout-link")).click();
		Thread.sleep(3000);

	    //assertEquals("确定要清除数据库缓存吗？", closeAlertAndGetItsText());
	    //assertEquals("数据库缓存已经清除。", closeAlertAndGetItsText());
		
	}
	

	//@Test
	public void deleteExistedUser() throws Exception{

		try {
			// 加载驱动程序

			// statement用来执行SQL语句
			Statement statement = conn.createStatement();

			// 要执行的SQL语句
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
	    driver.findElement(By.linkText("立即使用")).click();
		Thread.sleep(3000);
		
		
		if(this.isElementPresent(By.linkText("立即使用")))
		{
		    driver.findElement(By.linkText("立即使用")).click();
			Thread.sleep(3000);
		    driver.findElement(By.linkText("我要投资")).click();
			Thread.sleep(3000);
		}
		
	    driver.findElement(By.xpath("//li[2]/div[2]/div[3]/i")).click();
		Thread.sleep(3000);
		
//	    driver.findElement(By.cssSelector("div.account-info.fl")).click();
//		Thread.sleep(1000);
	    driver.findElement(By.id("investSubmit")).click();
		Thread.sleep(10000);
		assertTrue(driver.getTitle().equals("拓天速贷-实名验证"));
		Thread.sleep(1000);

//	    driver.findElement(By.name("userName")).click();
//	    driver.findElement(By.name("userName")).clear();
//	    driver.findElement(By.name("userName")).sendKeys("张旭卫");
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
//	    driver.findElement(By.linkText("继续投资")).click();
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
		assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));

	    driver.findElement(By.linkText("登录")).click();
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
		
	    driver.findElement(By.linkText("我的账户")).click();
		Thread.sleep(1000);
	    driver.findElement(By.linkText("提现")).click();
		Thread.sleep(2000);
	    driver.findElement(By.cssSelector("input.amount-display")).clear();
	    driver.findElement(By.className("amount-display")).sendKeys("3");
		Thread.sleep(3000);
		
	    driver.findElement(By.cssSelector("button.withdraw-submit.btn-normal")).click();
		Thread.sleep(6000);
		switchWindowWithdrawAndRecharge("账户提现");
		Thread.sleep(2000);
	    driver.findElement(By.linkText("确认成功")).click();
		Thread.sleep(1000);
	    driver.findElement(By.linkText("充值")).click();
		Thread.sleep(1000);
	    driver.findElement(By.cssSelector("input.amount")).clear();
	    driver.findElement(By.className("amount")).sendKeys("12");
		Thread.sleep(3000);
	    driver.findElement(By.cssSelector("button.btn.btn-normal")).click();
		Thread.sleep(8000);
		switchWindowWithdrawAndRecharge("借记卡充值");
		Thread.sleep(2000);
	    driver.findElement(By.linkText("确认成功")).click();
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
		assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));

		driver.findElement(By.linkText("注册")).click();
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
		assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));

		driver.findElement(By.linkText("注册")).click();
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
		assertTrue(driver.getTitle().equals("登录"));

		loginBackend();
		
		driver.findElement(By.linkText("项目管理")).click();

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
		assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));

	    driver.findElement(By.linkText("我要投资")).click();
		Thread.sleep(1000);
			    driver.findElement(By.linkText("180天以上")).click();
			    //driver.findElement(By.linkText("91-180天")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//dl[3]/dd")).click();
		Thread.sleep(3000);
	    driver.findElement(By.id("investSubmit")).click();
		Thread.sleep(2000);
		
		login("mintest", this.oldPassword);

		closeCoupon();

		
		if(this.isElementPresent(By.linkText("立即使用")))
		{
		    driver.findElement(By.linkText("立即使用")).click();
			Thread.sleep(3000);
		}

	    driver.findElement(By.linkText("我要投资")).click();
		Thread.sleep(3000);
	    driver.findElement(By.linkText("180天以上")).click();
		Thread.sleep(3000);
	    driver.findElement(By.cssSelector("i.btn-invest.btn-normal")).click();
		Thread.sleep(3000);
	    driver.findElement(By.id("investSubmit")).click();
		Thread.sleep(3000);
	    driver.findElement(By.linkText("确认")).click();
		Thread.sleep(3000);
	}
	
	//@Test
	public void doRepayment() throws Exception {
		try {
			driver.get(baseUrl + "/login");
			driver.manage().window().maximize();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("登录"));

			loginBackend();
			
		    driver.findElement(By.linkText("项目管理")).click();
			Thread.sleep(2000);
		    driver.findElement(By.linkText("编辑")).click();
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
		assertTrue(driver.getTitle().equals("登录"));

		loginBackend();
		
		driver.findElement(By.linkText("项目管理")).click();

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
		driver.findElement(By.linkText("发起借款")).click();
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
		
		//加息
	    driver.findElement(By.id("extra")).click();

	    
        driver.findElement(By.xpath("(//input[@type='text'])[10]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("gaoyinglong");
	    driver.findElement(By.xpath("(//input[@type='text'])[11]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("11");
	    
	    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		Thread.sleep(2000);
	    driver.findElement(By.linkText("女")).click();

	    driver.findElement(By.xpath("(//input[@type='text'])[12]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys(strID);
	    
	    driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		Thread.sleep(2000);
	    driver.findElement(By.linkText("已婚")).click();

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
		driver.findElement(By.linkText("编辑")).click();
		Thread.sleep(10000);

	    driver.findElement(By.xpath("(//button[@type='button'])[10]")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		// driver.findElement(By.linkText("所有的借款")).click();
		// Thread.sleep(1000);

	}
	
	public void testCreateProjectForUser(String strDay, String strName,
			String strID) throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.linkText("发起借款")).click();
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
		driver.findElement(By.linkText("编辑")).click();
		Thread.sleep(10000);

	    driver.findElement(By.xpath("(//button[@type='button'])[10]")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		// driver.findElement(By.linkText("所有的借款")).click();
		// Thread.sleep(1000);

	}


	public void testCreateProjectForNewComer(String strDay, String strName,
			String strID) throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.linkText("发起借款")).click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("房产抵押借款")).click();
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

		// 新手专享
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		driver.findElement(By.linkText("新手专享")).click();

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
		driver.findElement(By.linkText("编辑")).click();

		Thread.sleep(8000);

		driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

	}


	public void verifyFirstPage(String strContent) {
		assertTrue(strContent
				.contains("客服电话：400-169-1188<time>（服务时间：9:00－20:00）"));
		assertTrue(strContent.contains("'16顶部导航','首页'"));
		assertTrue(strContent.contains("'17顶部导航','我要投资'"));
		assertTrue(strContent.contains("'18顶部导航','我的账户'"));
		assertTrue(strContent.contains("新手指引"));
		assertTrue(strContent.contains("关于我们"));
		assertTrue(strContent.contains("最新公告"));
		// assertTrue(strContent.contains("生日月投资收益翻倍"));
		// assertTrue(strContent.contains("推荐奖励：0元投资赚收益，呼朋唤友抢佣金"));
		// assertTrue(strContent.contains("拓天上市"));
		// assertTrue(strContent.contains("招募代理"));
		// assertTrue(strContent.contains("App下载"));
		assertTrue(strContent.contains("活期存款收益"));
		assertTrue(strContent.contains("最高46倍活期存款收益，最低投资门槛50元"));
		assertTrue(strContent.contains("第三方资金托管，第三方支付"));
		assertTrue(strContent.contains("上市企业投资，资金数据均安全"));
		assertTrue(strContent.contains("新手加息券"));
		assertTrue(strContent.contains("30</i>天"));
		assertTrue(strContent.contains("90</i>天"));
		assertTrue(strContent.contains("180</i>天"));
		assertTrue(strContent.contains("360</i>天"));
		assertTrue(strContent.contains("服务费用"));
		assertTrue(strContent.contains("地址：北京市丰台区洋桥12号天路蓝图大厦8层"));
		assertTrue(strContent.contains("投资产品"));
		assertTrue(strContent.contains("我的帐户"));
		assertTrue(strContent.contains("推荐奖励"));
		assertTrue(strContent.contains("运营数据"));
		assertTrue(strContent.contains("客服邮箱：kefu@tuotiansudai.com"));
		assertTrue(strContent.contains("拓天伟业(北京)金融信息服务有限公司 版权所有"));
		assertTrue(strContent.contains("友情链接"));
		assertTrue(strContent.contains("京ICP备15035567号-1"));

	}

	@Test
	public void testFirstPage() throws Exception {
		driver.get(backUrl);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));
		String strContent = driver.getPageSource();
		verifyFirstPage(strContent);

		driver.findElement(By.cssSelector("div.media-logo-list.fr")).click();

		driver.findElement(By.cssSelector("div.icon-hover.img-icon-off-1"))
				.click();
		Thread.sleep(2000);
		switchWindow("安全保障");
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("div.icon-hover.img-icon-off-2"))
				.click();
		Thread.sleep(2000);
		switchWindow("安全保障");
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("div.icon-hover.img-icon-off-3"))
				.click();
		Thread.sleep(2000);
		switchWindow("安全保障");
		Thread.sleep(2000);

		// driver.findElement(By.cssSelector("div.page-width.clearfix > img.page-img")).click();

		driver.findElement(By.cssSelector("div.company-up > a")).click();
		Thread.sleep(3000);
		switchWindow("新手福利_拓天新手投资_拓天速贷");
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("i.img-jingdu")).click();
		Thread.sleep(3000);
		switchWindow("首页_京都律师事务所");
		Thread.sleep(2000);

		driver.findElement(By.linkText("投资产品")).click();
		Thread.sleep(2000);
		assertTrue(driver.getTitle().equals("投资列表_投资产品_拓天速贷"));
		driver.navigate().back();
		Thread.sleep(2000);

//		driver.findElement(By.linkText("拓天资产")).click();
//		Thread.sleep(3000);
//		switchWindow("拓天伟业（北京）资产管理有限公司");
//		Thread.sleep(2000);

	}

	@Test
	public void testLogo() throws Exception {
		try {
			driver.get(backUrl);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));
			driver.findElement(By.cssSelector("a.logo")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));
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
		assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));

		driver.findElement(By.linkText("会员中心")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("会员中心_会员福利_拓天速贷"));

		driver.findElement(By.linkText("返回首页")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));
		driver.findElement(By.linkText("活动中心")).click();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("活动中心_投资活动_拓天速贷"));
	}

	@Test
	public void testLogin() throws Exception {

		try {
			driver.get(backUrl);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));

			driver.findElement(By.linkText("登录")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("登录拓天速贷_拓天速贷"));


		    login(this.mobile_change_password,newPassword);
////			driver.findElement(By.id("logout-link")).click();
////			Thread.sleep(3000);
//
			driver.findElement(By.linkText("免费注册")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("拓天速贷注册_用户注册_拓天速贷"));
			driver.navigate().back();

			Thread.sleep(3000);
			driver.findElement(By.linkText("忘记密码？")).click();
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
		    
			if(this.isElementPresent(By.linkText("立即使用")))
			{
			    driver.findElement(By.linkText("立即使用")).click();
				Thread.sleep(3000);
			    driver.findElement(By.linkText("我要投资")).click();
				Thread.sleep(3000);
			}

		    
		    driver.findElement(By.linkText("我的账户")).click();
			Thread.sleep(3000);
		    driver.findElement(By.linkText("个人资料")).click();
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

			driver.findElement(By.linkText("登录")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("登录拓天速贷_拓天速贷"));
			
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
//					.equals("手机号不存在"));
//			assertTrue(driver.findElement(By.id("captcha-error")).getText()
//					.equals("验证码格式不正确"));
			
			
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
		assertTrue(driver.getTitle().equals("新手福利_拓天新手投资_拓天速贷"));

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
		assertTrue(driver.getTitle().equals("投资列表_投资产品_拓天速贷"));
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
		assertTrue(driver.getTitle().equals("送您5888元体验金"));

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
		// assertTrue(driver.getTitle().equals("投资列表_投资产品_拓天速贷"));
	}

	@Test
	public void test5888bannerApp2() throws Exception {
		driver.get(backUrl + "activity/landing-page?from=singlemessage&isappinstalled=1");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("新手福利_拓天新手投资_拓天速贷"));

		try {
			driver.findElement(By.id("login-name")).click();
			
			assertTrue(false);
		} catch (Exception e) {
			System.out.println("No user");
		}

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a > img")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("投资列表_投资产品_拓天速贷"));
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
		assertTrue(driver.getTitle().equals("推荐奖励_拓天速贷"));

		driver.findElement(By.linkText("立即推荐")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("登录拓天速贷_拓天速贷"));
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
		assertTrue(driver.getTitle().equals("拓天速贷手机客户端_理财客户端_拓天速贷"));

		driver.findElement(By.cssSelector("a.ios")).click();
		Thread.sleep(1000);

		switchWindow("拓天速贷：在 App Store 上的内容");
		Thread.sleep(1000);
	}

	@Test
	public void testInvestAchievement() throws Exception {
		driver.get(backUrl + "activity/invest-achievement");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("投资称号_拓天称号_拓天速贷"));
		driver.findElement(By.linkText("我要抢称号")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("投资列表_投资产品_拓天速贷"));

	}

	@Test
	public void testBirthMonth() throws Exception {
		try {
			driver.get(backUrl + "activity/birth-month");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("生日月特权_拓天活动_拓天速贷"));

			driver.findElement(
					By.xpath("//a[contains(@href, '/loan-list?durationStart=181&durationEnd=366&name=&status=&rateStart=0&rateEnd=0')]"))
					.click();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("投资列表_投资产品_拓天速贷"));

			driver.navigate().back();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//a[contains(@href, '/loan-list?durationStart=91&durationEnd=180&name=&status=&rateStart=0&rateEnd=0')]"))
					.click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("投资列表_投资产品_拓天速贷"));

			driver.navigate().back();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("a.click-btn.time-btn")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("投资列表_投资产品_拓天速贷"));
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
			assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));

			WebElement element = driver
					.findElement(By
							.xpath("//div[@id='productFrame']/div[2]/div/ul/li/div/div[2]/dl[2]/dd"));
			assertTrue(element.getText().equals("30天"));
			driver.findElement(
					By.xpath("//div[@id='productFrame']/div[2]/div/ul/li/div/div[2]/dl[2]/dd/em"))
					.click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("标的详情"));
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
			assertTrue(element.getText().equals("90天"));
			driver.findElement(
					By.xpath("//div[@id='productFrame']/div[3]/div/ul/li/div/div[2]/dl[2]/dd"))
					.click();
			Thread.sleep(4000);
			assertTrue(driver.getTitle().equals("标的详情"));

			driver.navigate().back();

			Thread.sleep(2000);
			element = driver
					.findElement(By
							.xpath("//div[@id='productFrame']/div[3]/div/ul/li[2]/div/div[2]/dl[2]/dd"));
			assertTrue(element.getText().equals("180天"));
			driver.findElement(
					By.xpath("//div[@id='productFrame']/div[3]/div/ul/li[2]/div/div[2]/dl[2]/dt"))
					.click();
			Thread.sleep(4000);
			assertTrue(driver.getTitle().equals("标的详情"));
			driver.navigate().back();

			Thread.sleep(2000);
			element = driver
					.findElement(By
							.xpath("//div[@id='productFrame']/div[3]/div/ul/li[3]/div/div[2]/dl[2]/dd"));
			assertTrue(element.getText().equals("360天"));
			driver.findElement(
					By.xpath("//div[@id='productFrame']/div[3]/div/ul/li[3]/div/div[2]/dl[2]/dt"))
					.click();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("标的详情"));
			driver.navigate().back();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));

			driver.findElement(
					By.cssSelector("dl.transfer-one > dd"))
					.click();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("标的详情"));
			driver.findElement(
					By.xpath("//div[3]/div/div[2]/div/ul/li[2]"))
					.click();
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));
			
		    driver.findElement(By.linkText("我要投资")).click();
			Thread.sleep(2000);
		    driver.findElement(By.linkText("转让项目")).click();
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
		assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));

		// try {
		driver.findElement(By.linkText("我要投资")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("投资列表_投资产品_拓天速贷"));

		driver.findElement(By.linkText("转让项目")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("债权转让_转让项目_拓天速贷"));
		driver.findElement(By.linkText("转让中")).click();
		Thread.sleep(1000);
		String strContent = driver.getPageSource();
		assertFalse(strContent.contains("已转让"));
		driver.findElement(By.linkText("已完成")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div.pagination")).click();

		driver.findElement(By.linkText("直投项目")).click();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("投资列表_投资产品_拓天速贷"));
		driver.findElement(By.linkText("房产抵押借款")).click();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("房产抵押借款_投资列表_拓天速贷"));
		strContent = driver.getPageSource();
		strContent = strContent.substring(8000);
		// System.out.println("*********" + strContent);
		assertFalse(strContent.contains("车辆抵押借款"));

		driver.findElement(By.linkText("车辆抵押借款")).click();
		Thread.sleep(3000);
		assertTrue(driver.getTitle().equals("车辆抵押借款_投资列表_拓天速贷"));
		strContent = driver.getPageSource();
		strContent = strContent.substring(8000);
		assertFalse(strContent.contains("房产抵押借款"));

		Thread.sleep(1000);
		driver.findElement(By.linkText("30天以内")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("31-90天")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("91-180天")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("180天以上")).click();

		Thread.sleep(1000);
		driver.findElement(By.linkText("可投资")).click();
		Thread.sleep(1000);
		strContent = driver.getPageSource();
		strContent = strContent.substring(9100);
		assertFalse(strContent.contains("已售罄"));

		Thread.sleep(1000);
		driver.findElement(By.linkText("还款中")).click();
		Thread.sleep(1000);
		strContent = driver.getPageSource();
		strContent = strContent.substring(9100);
		assertFalse(strContent.contains("马上投资"));

		Thread.sleep(1000);
		driver.findElement(By.linkText("还款完成")).click();
		Thread.sleep(1000);
		strContent = driver.getPageSource();
		strContent = strContent.substring(9100);
		assertFalse(strContent.contains("马上投资"));

		Thread.sleep(1000);
		driver.findElement(By.linkText("预热中")).click();
		Thread.sleep(1000);
		strContent = driver.getPageSource();
		strContent = strContent.substring(10100);
		assertFalse(strContent.contains("马上投资"));
		assertFalse(strContent.contains("已售罄"));

		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'全部')])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'全部')])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("10-12%")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("12-14%")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("14%以上")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'全部')])[4]")).click();

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
		assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));

		try {
			driver.findElement(By.linkText("我的账户")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("登录拓天速贷_拓天速贷"));
			
			login(this.mobile_change_password,this.oldPassword);

//			closeCoupon();
//			
//			if(this.isElementPresent(By.linkText("立即使用")))
//			{
//			    driver.findElement(By.linkText("立即使用")).click();
//				Thread.sleep(3000);
//			}
			
		    driver.findElement(By.linkText("我的账户")).click();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("账户总览"));
		    driver.findElement(By.linkText("快来使用吧")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("我的宝藏"));
			
//			if(this.isElementPresent(By.linkText("立即使用")))
//			{
//			    driver.findElement(By.linkText("立即使用")).click();
//				Thread.sleep(3000);
//			    driver.findElement(By.linkText("我的账户")).click();
//				Thread.sleep(2000);
//				assertTrue(driver.getTitle().equals("账户总览"));
//			}

		    driver.findElement(By.linkText("账户总览")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("账户总览"));

		    driver.findElement(By.linkText("账户总览")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("账户总览"));
		    driver.findElement(By.xpath("(//a[contains(text(),'更多...')])[3]")).click();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("投资记录"));
		    driver.findElement(By.linkText("账户总览")).click();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("账户总览"));
		    driver.findElement(By.linkText("本月待收回款")).click();
		    driver.findElement(By.linkText("本月已收回款")).click();
		    driver.findElement(By.cssSelector("a.user-info")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("个人资料"));

			driver.findElement(By.linkText("我的投资")).click();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("投资记录"));
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
			
		    driver.findElement(By.linkText("债权转让")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("债权转让"));
			
		    driver.findElement(By.linkText("转让中债权")).click();
			Thread.sleep(1000);
		    driver.findElement(By.linkText("转让中债权")).click();
			Thread.sleep(1000);
			
		    driver.findElement(By.linkText("资金管理")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("资金管理"));
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
		    driver.findElement(By.linkText("投资")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("投资列表_投资产品_拓天速贷"));
			driver.navigate().back();
			Thread.sleep(1000);
			
		    driver.findElement(By.linkText("消息中心")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("消息中心"));
			
		    driver.findElement(By.linkText("我的财豆")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("我的财豆"));
		    driver.findElement(By.id("beansDetail")).click();
			Thread.sleep(1000);
		    driver.findElement(By.linkText("我的财豆")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("我的财豆"));
			//去投资
		    driver.findElement(By.cssSelector("span.btn-invest")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("投资列表_投资产品_拓天速贷"));
			driver.navigate().back();
			Thread.sleep(1000);
			//做任务
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

			
		    driver.findElement(By.linkText("个人资料")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("个人资料"));
			Thread.sleep(2000);
		    driver.findElement(By.linkText("关闭")).click();
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
		    driver.findElement(By.linkText("开启")).click();
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
		assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));

//		try {
			driver.findElement(By.linkText("我的账户")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("登录拓天速贷_拓天速贷"));
			
			login(this.mobile_change_password,this.oldPassword);

//			if(this.isElementPresent(By.linkText("立即使用")))
//			{
//			    driver.findElement(By.linkText("立即使用")).click();
//				Thread.sleep(3000);
//			}
//			
//			closeCoupon();
			
		    driver.findElement(By.linkText("我的账户")).click();
			Thread.sleep(2000);
			assertTrue(driver.getTitle().equals("账户总览"));

			
		    driver.findElement(By.linkText("自动投标")).click();
			Thread.sleep(3000);
			assertTrue(driver.getTitle().equals("自动投标"));
			
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
		    driver.findElement(By.linkText("个人资料")).click();
			Thread.sleep(1000);
		    driver.findElement(By.linkText("自动投标")).click();
			Thread.sleep(1000);
		    driver.findElement(By.cssSelector("label.radio")).click();
			Thread.sleep(2000);
		    driver.findElement(By.xpath("//form[@id='signPlanForm']/dl[5]/dd/span[5]")).click();
			Thread.sleep(2000);
		    driver.findElement(By.id("saveInvestPlan")).click();
			Thread.sleep(2000);
		    driver.findElement(By.linkText("个人资料")).click();
			Thread.sleep(2000);
		    driver.findElement(By.linkText("自动投标")).click();
			Thread.sleep(2000);
		    driver.findElement(By.id("editSetting")).click();
			Thread.sleep(2000);
			
		    driver.findElement(By.linkText("推荐管理")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("推荐管理"));
			
		    driver.findElement(By.linkText("我的宝藏")).click();
			Thread.sleep(1000);
			assertTrue(driver.getTitle().equals("我的宝藏"));
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
		assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));
		String strContent = "";

		// try {
		driver.findElement(By.linkText("关于我们")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("拓天速贷公司介绍_拓天理念_拓天资质_拓天速贷"));
		strContent = driver.getPageSource();
		assertTrue(strContent
				.contains("拓天速贷是基于互联网的金融信息服务平台，由拓天伟业（北京）资产管理有限公司旗下的拓天伟业（北京）金融信息服务有限公司运营"));
		assertTrue(strContent.contains("以安全、诚信、专业、创新、长远为核心价值观"));

		driver.findElement(By.linkText("团队介绍")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("拓天团队_金融精英_拓天速贷"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("拓天为海，拓天要做一片海"));
		assertTrue(strContent.contains("时代蕴含机遇，创新成就伟业"));

		driver.findElement(By.linkText("拓天公告")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("拓天公告_拓天活动_拓天速贷"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("拓天公告"));

		driver.findElement(By.linkText("媒体报道")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("拓天最新媒体报道_拓天速贷"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("媒体报道"));

		driver.findElement(By.linkText("推荐奖励")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("推荐奖励_拓天速贷"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("每级奖励金额为被推荐人投资本金预期年化收益的1%"));
		assertTrue(strContent.contains("发生二级以上的推荐，小张不获得奖励"));

		driver.findElement(By.linkText("服务费用")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("拓天速贷服务_拓天速贷"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("投资所得预期收益的10%"));
		assertTrue(strContent.contains("每笔提现手续费2.00元，费用由投资人承担"));

		driver.findElement(By.linkText("常见问题")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("拓天速贷解答_专业的P2P理财_网络贷款咨询解答平台"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("目前仅支持大陆地区身份认证"));
		assertTrue(strContent
				.contains("原则上支持T+0日到账，当天16：00前提现当天到账，当日16:00后提现次日11:00前到账，节假日则推迟至下一个工作日"));

		driver.findElement(By.linkText("联系我们")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("联系我们_拓天速贷地址_拓天速贷联系方式"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("客服热线：400-169-1188"));
		assertTrue(strContent.contains("北京市丰台区洋桥12号天路蓝图大厦8层"));

		driver.findElement(By.linkText("运营数据")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("运营数据_信息安全数据_拓天速贷"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("安全运营时间"));
		assertTrue(strContent.contains("注册投资用户"));
		assertTrue(strContent.contains("累计交易金额"));
		assertTrue(strContent.contains("平台累计投资"));
		assertTrue(strContent.contains("平台投资明细"));

		driver.findElement(By.linkText("会员中心")).click();
		Thread.sleep(2000);
		assertTrue(driver.getTitle().equals("会员中心_会员福利_拓天速贷"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("亲，成为会员可享受多种特权哦~"));
		assertTrue(strContent.contains("会员福利"));

		driver.findElement(By.linkText("成长体系")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("会员体系_会员中心_拓天速贷"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("拓天速贷会员介绍"));
		assertTrue(strContent.contains("成长值明细"));

		driver.findElement(By.linkText("会员特权")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("会员特权_会员中心_拓天速贷"));
		strContent = driver.getPageSource();
		assertTrue(strContent.contains("会员特权"));
		assertTrue(strContent.contains("特权说明"));

		driver.findElement(By.linkText("运营数据")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("运营数据_信息安全数据_拓天速贷"));
		driver.findElement(By.linkText("活动中心")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("活动中心_投资活动_拓天速贷"));

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
		assertTrue(driver.getTitle().equals("拓天速贷-互联网金融信息服务平台"));

		// try {
		driver.findElement(By.linkText("我的账户")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("登录拓天速贷_拓天速贷"));

		driver.findElement(By.linkText("问答")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("拓天速贷"));
		driver.findElement(By.linkText("待解决问题")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("热门问题")).click();
		Thread.sleep(1000);

		driver.findElement(By.linkText("我要提问")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("拓天速贷"));
		// click 登录
		driver.findElement(By.cssSelector("span.isAnonymous.ask-con > a"))
				.click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("登录拓天速贷_拓天速贷"));
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'注册')])[2]")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("拓天速贷注册_用户注册_拓天速贷"));
		driver.navigate().back();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//a[contains(text(),'注册')])[2]")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("拓天速贷注册_用户注册_拓天速贷"));
		driver.navigate().back();
		Thread.sleep(1000);
		// click 登录
		driver.findElement(By.cssSelector("a.btn")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("登录拓天速贷_拓天速贷"));
		//driver.navigate().back();
		Thread.sleep(1000);
		
		login("mintest", this.oldPassword);

	    driver.findElement(By.linkText("问答")).click();
		Thread.sleep(1000);
	    driver.findElement(By.linkText("我要提问")).click();
		Thread.sleep(1000);
	    driver.findElement(By.name("question")).clear();
	    driver.findElement(By.name("question")).sendKeys("接下来有什么活动");
	    driver.findElement(By.name("addition")).clear();
	    driver.findElement(By.name("addition")).sendKeys("中秋到了，有月饼吗");
		Thread.sleep(3000);
	    driver.findElement(By.name("captcha")).clear();
	    driver.findElement(By.name("captcha")).sendKeys("kkkkk");
		Thread.sleep(2000);
	    driver.findElement(By.xpath("(//a[contains(text(),'我的回答')])[2]")).click();
		Thread.sleep(1000);
	    driver.findElement(By.cssSelector("#my-questions-tab > li > a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("问答")).click();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("拓天速贷"));
		driver.findElement(By.linkText("待解决问题")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("热门问题")).click();
		Thread.sleep(1000);

		// } catch (Exception e) {
		// File img = ((TakesScreenshot) driver)
		// .getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(img, new File("D:/javatest/asksystem.jpg"));
		// assertTrue(false);
		// }
	}


	private void switchWindow(String strTitle) {
		String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
		Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
				continue;
			}
			WebDriver window = driver.switchTo().window(it.next());// 切换到新窗口
			assertTrue(window.getTitle().equals(strTitle));
			window.close();// 关闭新窗口
		}
		driver.switchTo().window(currentWindow);// 回到原来页面
	}

	
	private void switchWindowWithdrawAndRecharge(String strTitle) throws Exception{
		String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
		Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
				continue;
			}
			WebDriver window = driver.switchTo().window(it.next());// 切换到新窗口
			assertTrue(window.getTitle().equals(strTitle));
			Thread.sleep(2000);
			
			driver.findElement(By.id("btn")).click();
			Thread.sleep(2000);
		
			window.close();// 关闭新窗口
		}
		driver.switchTo().window(currentWindow);// 回到原来页面
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
