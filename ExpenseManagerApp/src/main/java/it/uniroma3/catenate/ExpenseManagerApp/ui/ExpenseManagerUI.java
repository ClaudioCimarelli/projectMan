package it.uniroma3.catenate.ExpenseManagerApp.ui;

import it.uniroma3.catenate.ExpenseManagerApp.views.DashBoardView;

import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.event.Transferable;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Title("Expense Manager")
@SuppressWarnings("serial")
@Theme("dashboard")
public class ExpenseManagerUI extends UI {

	private static final long serialVersionUID = 1L;
	
	@WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = ExpenseManagerUI.class)
	@Widgetset("it.uniroma3.catenate.ExpenseManagerApp.DashboardWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

	CssLayout root = new CssLayout();
	CssLayout menu = new CssLayout();
	CssLayout content = new CssLayout();

	HashMap<String, Class<? extends View>> routes = new HashMap<String, Class<? extends View>>() {
		{
			put("/dashboard", DashBoardView.class);

		}
	};
	HashMap<String, Button> viewNameToMenuButton = new HashMap<String, Button>();
	private Navigator nav;

	@Override
	protected void init(VaadinRequest request) {
		setContent(root);
		root.addStyleName("root");
		root.setSizeFull();
		buildMainView();
	}

	private void buildMainView() {

		nav = new Navigator(this, content);

		for (String route : routes.keySet()) {
			nav.addView(route, routes.get(route));
		}

		root.addComponent(new HorizontalLayout() {
			{
				setSizeFull();
				addStyleName("main-view");
				addComponent(new VerticalLayout() {
					// Sidebar
					{
						addStyleName("sidebar");
						setWidth(null);
						setHeight("100%");

						// Branding element
						addComponent(new CssLayout() {
							{
								addStyleName("branding");
								Label logo = new Label(
										"<span>Lanificio</span> Expense Manager",
										ContentMode.HTML);
								logo.setSizeUndefined();
								addComponent(logo);
								// addComponent(new Image(null, new
								// ThemeResource(
								// "img/branding.png")));
							}
						});

						// Main menu
						addComponent(menu);
						setExpandRatio(menu, 1);

						// User menu
						addComponent(new VerticalLayout() {
							{
								setSizeUndefined();
								addStyleName("user");
								Image profilePic = new Image(
										null,
										new ThemeResource("img/profile-pic.png"));
								profilePic.setWidth("34px");
								addComponent(profilePic);
								Label userName = new Label("Username");
								userName.setSizeUndefined();
								addComponent(userName);

								Command cmd = new Command() {
									@Override
									public void menuSelected(
											MenuItem selectedItem) {
										Notification
												.show("Not implemented yet");
									}
								};
								MenuBar settings = new MenuBar();
								MenuItem settingsMenu = settings.addItem("",
										null);
								settingsMenu.setStyleName("icon-cog");
								settingsMenu.addItem("Settings", cmd);
								settingsMenu.addItem("Preferences", cmd);
								settingsMenu.addSeparator();
								settingsMenu.addItem("My Account", cmd);
								addComponent(settings);

								Button exit = new NativeButton("Exit");
								exit.addStyleName("icon-cancel");
								exit.setDescription("Sign Out");
								addComponent(exit);
								exit.addClickListener(new ClickListener() {
									@Override
									public void buttonClick(ClickEvent event) {
										// buildLoginView(true);
									}
								});
							}
						});
					}
				});
				// Content
				addComponent(content);
				content.setSizeFull();
				content.addStyleName("view-content");
				setExpandRatio(content, 1);
			}

		});

		menu.removeAllComponents();

		for (final String view : new String[] { "dashboard", "sales",
				"transactions", "reports", "schedule" }) {
			Button b = new NativeButton(view.substring(0, 1).toUpperCase()
					+ view.substring(1).replace('-', ' '));
			b.addStyleName("icon-" + view);
			b.addClickListener(new ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
					clearMenuSelection();
					event.getButton().addStyleName("selected");
					if (!nav.getState().equals("/" + view))
						nav.navigateTo("/" + view);
				}
			});
			menu.addComponent(b);
			viewNameToMenuButton.put("/" + view, b);
		}
		menu.addStyleName("menu");
		menu.setHeight("100%");

		/*viewNameToMenuButton.get("/dashboard").setHtmlContentAllowed(true);
		viewNameToMenuButton.get("/dashboard").setCaption(
				"Dashboard<span class=\"badge\">2</span>");*/

		String f = Page.getCurrent().getUriFragment();
		if (f != null && f.startsWith("!")) {
			f = f.substring(1);
		}
		if (f == null || f.equals("") || f.equals("/")) {
			nav.navigateTo("/dashboard");
			menu.getComponent(0).addStyleName("selected");
		} else {
			nav.navigateTo(f);
			viewNameToMenuButton.get(f).addStyleName("selected");
		}
		

		nav.addViewChangeListener(new ViewChangeListener() {

			@Override
			public boolean beforeViewChange(ViewChangeEvent event) {
				return true;
			}

			@Override
			public void afterViewChange(ViewChangeEvent event) {
				View newView = event.getNewView();				
			}
		});

	}

	private Transferable items;

	private void clearMenuSelection() {
		for (Iterator<Component> it = menu.getComponentIterator(); it.hasNext();) {
			Component next = it.next();
			if (next instanceof NativeButton) {
				next.removeStyleName("selected");
			} 
		}
	}

	void updateReportsButtonBadge(String badgeCount) {
		viewNameToMenuButton.get("/reports").setHtmlContentAllowed(true);
		viewNameToMenuButton.get("/reports").setCaption(
				"Reports<span class=\"badge\">" + badgeCount + "</span>");
	}

	void clearDashboardButtonBadge() {
		viewNameToMenuButton.get("/dashboard").setCaption("Dashboard");
	}

	boolean autoCreateReport = false;
	Table transactions;

	public void openReports(Table t) {
		transactions = t;
		autoCreateReport = true;
		nav.navigateTo("/reports");
		clearMenuSelection();
		viewNameToMenuButton.get("/reports").addStyleName("selected");
	}

}