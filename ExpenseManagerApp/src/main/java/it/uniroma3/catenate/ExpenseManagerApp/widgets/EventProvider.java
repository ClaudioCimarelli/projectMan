package it.uniroma3.catenate.ExpenseManagerApp.widgets;





import it.uniroma3.catenate.ExpenseManagerApp.data.EventHome;
import it.uniroma3.catenate.ExpenseManagerApp.model.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;









import javax.ejb.EJB;

import com.vaadin.addon.calendar.event.CalendarEditableEventProvider;
import com.vaadin.addon.calendar.event.CalendarEvent;

public class EventProvider implements CalendarEditableEventProvider {
	
	@EJB(name="eventRepo")EventHome home;


    @Override
    public List<CalendarEvent> getEvents(Date startDate, Date endDate) {
    	List<CalendarEvent> calendarEvents = new ArrayList<CalendarEvent>();
    	List<Event> events =(home!=null? home.findBetweenDates(startDate, endDate): null);
    	if(events!=null){
    	for(Event e : home.findBetweenDates(startDate, endDate)){
    		CustomCalendarEvent event = new CustomCalendarEvent();
    		event.setEvent(e);    		
    	}}
    	return calendarEvents;
    }

	@Override
	public void addEvent(CalendarEvent event) {
		Event newEvent = new Event();
		newEvent.setDate(event.getStart());
		newEvent.setName(event.getCaption());
		home.persist(newEvent);
		
	}

	@Override
	public void removeEvent(CalendarEvent event) {
		if(event instanceof CustomCalendarEvent){
			
		}
		
	}

}
