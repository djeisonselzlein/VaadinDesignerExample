package com.example.hellodesigner;

import javax.servlet.annotation.WebServlet;

import com.example.hellodesigner.views.LoginView;
import com.example.hellodesigner.views.MainView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 * 
 * @author djeisonselzlein
 * 
 *         This is the main class for this application. It instantiates all
 *         views and add them to a Navigator which allows the user to switch
 *         between them
 *
 */
@SuppressWarnings("serial")
@Theme("hellodesigner")
public class HelloDesignerUI extends UI {

	private Navigator navigator;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = HelloDesignerUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		// Navigator that will manage views
		navigator = new Navigator(this, this);

		// Adding views to the Navigator
		navigator.addView("", new LoginView(navigator));
		navigator.addView("main", new MainView(navigator));

	}

}