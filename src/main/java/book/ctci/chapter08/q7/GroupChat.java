package book.ctci.chapter08.q7;

public class GroupChat extends Conversation {
	public void removeParticipant(User user) {
		participants.remove(user);
	}
	
	public void addParticipant(User user) {
		participants.add(user);
	}
}
