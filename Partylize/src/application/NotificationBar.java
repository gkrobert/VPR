package application;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;

import java.util.LinkedList;

public class NotificationBar
{
	// Returns an Anchorpane that saves and displays Notifications
	public static AnchorPane createBenachrichtigungsleiste()
	{
		LinkedList<Notification> elements = new LinkedList<Notification>();
		double baseAnchorval = 151; // -fx-pref-width +1: VERIFY WHENEVER
										// .Notification CHANGES IN CSS
		double cumulativeAnchorval = 0;

		// TODO Notifications are generated by hand for now, they should be generated somewhere else
		Notification btn = new Notification(0, "Einladung von Horst");
		Notification ban = new Notification(1, "Freundschaftsanfrage von Partylizer123");
		ban.setWrapText(true);
		elements.add(btn);
		elements.add(ban);

		// placeholder event handlers
		EventHandler<MouseEvent> mouseHandlerEnter = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
			}
		};

		EventHandler<MouseEvent> mouseHandlerExit = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
			}
		};

		// placeholder event handlers are assigned
		//for (Notification n : elements)	@editor Daniel Hecker : 24.12.2017
		for (int i = 0; i < elements.size(); i++) {
			elements.get(i).setOnMouseEntered(mouseHandlerEnter);
			elements.get(i).setOnMouseExited(mouseHandlerExit);
		}

		// generates return value
		AnchorPane notifications = new AnchorPane();
		for (int i = 0; i < elements.size(); i++) {
			Node temp = elements.get(i);
			notifications.getChildren().add(temp);
			AnchorPane.setRightAnchor(temp, cumulativeAnchorval);
			AnchorPane.setBottomAnchor(temp, 0.0);
			cumulativeAnchorval += baseAnchorval;
		}

		notifications.setMinHeight(100);
		notifications.setMaxHeight(100);

		return notifications;
	}
}













