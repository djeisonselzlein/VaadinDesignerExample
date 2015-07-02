package com.example.hellodesigner.listeners;

import com.example.hellodesigner.views.LoginView;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

/**
 * 
 * @author djeisonselzlein
 * 
 *         This class basically simulates a simple login. Security is not what I
 *         am achieving here.
 *
 */
public class MyClickListener implements ClickListener {

	/**
     * 
     **/
	private static final long serialVersionUID = 1L;
	private String page;
	private Navigator navigator;
	private TextField username;
	private PasswordField password;

	public MyClickListener(String uri, Navigator nav) {
		this.page = uri;
		this.navigator = nav;
	}

	public MyClickListener(String uri, LoginView login) {
		this.page = uri;
		this.navigator = login.getNavigator();
		this.username = login.getUserTextField();
		this.password = login.getPasswordTextField();
	}

	@Override
	public void buttonClick(ClickEvent event) {
		// Navigate to a specific state
		if (!page.equals("")
				&& (username.getValue().equals("admin") && password.getValue()
						.equals("admin"))) {
			navigator.navigateTo(page);
		} else {
			navigator.navigateTo("");
		}
	}

}
