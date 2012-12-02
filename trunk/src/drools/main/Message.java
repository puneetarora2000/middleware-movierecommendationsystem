package drools.main;

public class Message {
	public static final int GENERATE   = 0;
    public static final int EMAIL = 1;
    
    public int status;
    
	public Message(int status) {
		super();
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
}
