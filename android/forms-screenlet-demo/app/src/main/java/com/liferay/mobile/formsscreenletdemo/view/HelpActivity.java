package com.liferay.mobile.formsscreenletdemo.view;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.liferay.mobile.formsscreenletdemo.R;
import com.liferay.mobile.formsscreenletdemo.view.sessions.BlogPostingsActivity;

/**
 * @author Luísa Lima
 */
public class HelpActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);

		LinearLayout faq = findViewById(R.id.faq);
		faq.setOnClickListener(v -> startActivity());
	}

	private void startActivity() {
		Intent intent = new Intent(this, BlogPostingsActivity.class);
		startActivity(intent);
	}
}
