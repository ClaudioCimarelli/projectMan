package it.uniroma3.catenate.ExpenseManagerApp.widgets;



import it.uniroma3.catenate.ExpenseManagerApp.model.Event;

import java.util.Date;

import com.vaadin.addon.calendar.event.CalendarEvent;
import com.vaadin.ui.components.calendar.event.EditableCalendarEvent;

public class CustomCalendarEvent implements EditableCalendarEvent {
	
	private Event event= new Event();

	protected Event getEvent() {
		return event;
	}

	protected void setEvent(Event event) {
		this.event = event;
		
	}

	@Override
	public Date getStart() {
		return this.event.getDate();
	}

	@Override
	public Date getEnd() {
		return this.event.getDate();
	}

	@Override
	public String getCaption() {
		return this.event.getName();
	}

	@Override
	public String getDescription() {
		
		return this.event.getNotes();
	}

	@Override
	public String getStyleName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAllDay() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setCaption(String caption) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnd(Date end) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStart(Date start) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStyleName(String styleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAllDay(boolean isAllDay) {
				
	}

}
