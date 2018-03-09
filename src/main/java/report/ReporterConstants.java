package report;

public interface ReporterConstants {
	String configReporterFile = "resources/gallopReporter.properties";

	/*
	 * Whether Being Run On Single Browser Or Multiple Browser In Multiple
	 * Threads
	 */
	/* browserName */
	String BROWSER_NAME = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "browserName");
	
	String PLATFORM_TYPE = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "platform");
	String APPIUM_URL = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "appiumURL");
	String APP_PACKAGE = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "appPackage");
	String APP_ACTIVITY = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "appActivity");
	String DEVICE_ID = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "deviceID");
	String DEVICE_NAME = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "deviceName");
	String PLATFORM_NAME = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "platformName");
	String PLATFORM_VERSION = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "platformVersion");
	String Timeout = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "timeoutInSec");
	String bitBucket_usr = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "bitBucket_usr");
	String bitBucket_pswd = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "bitBucket_pswd");
	String bitBucket_source = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "bitBucket_source");
	String bitBucket_destination = ConfigFileReadWrite.read(ReporterConstants.configReporterFile,
			"bitBucket_destination");
	String packagename_libs = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "packageName_libs");
	String testRailUrl = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "testRailUrl");
	String testRail_userName = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "testRail_userName");
	String testRail_paswd = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "testRail_paswd");
	String db_ExecutionComments = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "db_ExecutionComments");
	String downloaded_file_path = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "downloaded_file_path");
	String rackspace_loc = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "rackspace_loc");
	String Jenkins_path = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "Jenkins_path");
	String envUrl = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "testenv");
	String smoke_TT_IE = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "TTSmokeIE");
	String smoke_TT_FF= ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "TTSmokeFirefox");
	String smoke_TT_Chrome= ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "TTSmokeChrome");
	String Reg_TT_IE = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "TTRegressionIE");
	String Reg_TT_FF= ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "TTRegressionFirefox");
	String Reg_TT_Chrome= ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "TTRegressionChrome");	
	String smoke_ECMS_IE = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "ECMSSmokeIE");
	String smoke_ECMS_FF= ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "ECMSSmokeFirefox");
	String smoke_ECMS_Chrome= ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "ECMSSmokeChrome");
	String Reg_ECMS_IE = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "ECMSSmokeIE");
	String Reg_ECMS_FF= ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "ECMSSmokeFirefox");
	String Reg_ECMS_Chrome= ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "ECMSSmokeChrome");
}