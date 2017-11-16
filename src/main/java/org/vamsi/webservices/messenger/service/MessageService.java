/**
 * 
 */
package org.vamsi.webservices.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.vamsi.webservices.messenger.database.DatabaseClass;
import org.vamsi.webservices.messenger.model.Message;

/**
 * @author vamsi
 *
 */
public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();

	/**
	 * 
	 */
	public MessageService() {
		messages.put(1L, new Message(1L, "Hello World!", "Vamsi"));
		messages.put(2L, new Message(2L, "Hello Jersey!", "Vamsi"));
	}

	public List<Message> getAllMessages() {
		
		/*Message m1 = new Message(1L, "Hello World!", "Vamsi");
		Message m2 = new Message(2L, "Hello Jersey!", "Vamsi");
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;*/
		
		return new ArrayList<Message>(messages.values());
		
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> messageForPaginated = new ArrayList<Message>(messages.values());
		if(start+size > messageForPaginated.size()){
			return new ArrayList<Message>();
		}
		return messageForPaginated.subList(start, start+size);
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
}
