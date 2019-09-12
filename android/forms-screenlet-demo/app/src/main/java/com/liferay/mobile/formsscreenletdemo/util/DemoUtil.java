package com.liferay.mobile.formsscreenletdemo.util;

import android.content.Context;
import android.graphics.Color;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.content.ContextCompat;
import android.view.View;
import android.view.Window;
import com.liferay.mobile.formsscreenletdemo.R;
import com.liferay.mobile.screens.context.SessionContext;
import com.liferay.mobile.screens.util.AndroidUtil;

/**
 * @author Luísa Lima
 * @author Victor Oliveira
 */
public class DemoUtil {

	public static String getCredentials() {
		try {
			return SessionContext.getCredentialsFromCurrentSession();
		} catch (Exception e) {
			return "";
		}
	}

	public static String getResourcePath(String serverURL, long id, ResourceType resourceType) {
		String resourceEndpoint = "";

		switch (resourceType) {
			case BLOGS:
				resourceEndpoint = Constants.BLOG_POSTING_ENDPOINT;
				break;
			case FORMS:
				resourceEndpoint = Constants.FORM_ENDPOINT;
				break;
			case PERSON:
				resourceEndpoint = Constants.PERSON_ENDPOINT;
				break;
		}

		return serverURL + String.format(resourceEndpoint, id);
	}

	public static void setLightStatusBar(Context context, Window window) {
		window.setStatusBarColor(ContextCompat.getColor(context, R.color.login_status_bar_color));
		window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
	}

	public static void showErrorSnackBar(Context context, View layout) {
		int icon = R.drawable.default_error_icon;
		int backgroundColor =
			ContextCompat.getColor(context, com.liferay.mobile.screens.viewsets.lexicon.R.color.lightRed);
		String message = context.getString(R.string.request_failed);

		AndroidUtil.showCustomSnackbar(layout, message, Snackbar.LENGTH_LONG, backgroundColor, Color.WHITE,
			icon);
	}
}
