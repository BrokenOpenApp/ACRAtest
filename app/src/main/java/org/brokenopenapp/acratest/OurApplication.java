package org.brokenopenapp.acratest;

import android.app.Application;
import android.content.Context;
import android.os.DropBoxManager;

import org.acra.*;
import org.acra.annotation.*;
import static org.acra.ReportField.*;


@ReportsCrashes(formUri = "http://example.com/crash/add?project=ey",
		includeDropBoxSystemTags = true,additionalDropBoxTags = {"your_own_tag", "another_additional_tag"},customReportContent = {
		ANDROID_VERSION,
		APP_VERSION_CODE,
		APP_VERSION_NAME,
		APPLICATION_LOG,
		AVAILABLE_MEM_SIZE,
		BRAND,
		BUILD,
		BUILD_CONFIG,
		CRASH_CONFIGURATION,
		CUSTOM_DATA,
		DEVICE_FEATURES,
		DEVICE_ID,
		DISPLAY,
		DROPBOX,
		DUMPSYS_MEMINFO,
		ENVIRONMENT,
		EVENTSLOG,
		FILE_PATH,
		INITIAL_CONFIGURATION,
		INSTALLATION_ID,
		IS_SILENT,
		LOGCAT,
		MEDIA_CODEC_LIST,
		PACKAGE_NAME,
		PHONE_MODEL,
		PRODUCT,
		RADIOLOG,
		REPORT_ID,
		SETTINGS_GLOBAL,
		SETTINGS_SECURE,
		SETTINGS_SYSTEM,
		SHARED_PREFERENCES,
		STACK_TRACE,
		THREAD_DETAILS,
		TOTAL_MEM_SIZE,
		USER_APP_START_DATE,
		USER_COMMENT,
		USER_CRASH_DATE,
		USER_EMAIL
		})
public class OurApplication extends Application {


	@Override
	public void onCreate() {
		super.onCreate();


		ACRA.init(this);
		ACRA.getErrorReporter().putCustomData("test1","a b c");
		ACRA.getErrorReporter().putCustomData("testNewlines","a\nb\nc");

		DropBoxManager db=(DropBoxManager)getSystemService(Context.DROPBOX_SERVICE);
		db.addText("your_own_tag","your_own_tag\n1\n2\n3");
		db.addText("another_additional_tag","another_additional_tag\n1\n2\n3");

	}


}
