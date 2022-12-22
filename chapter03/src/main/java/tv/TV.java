package tv;

public class TV {

	private int channel; // 1~255
	private int volume; // 0~100
	private boolean power;

	public TV(int i, int j, boolean b) {
		this.channel=i;
		this.volume=j;
		this.power=b;
				
		// TODO Auto-generated constructor stub
	}
	void power(boolean on) {
		this.power = on;
	}

	void status() {
		System.out.println("TV[power=" + (power ? "on" : "off") +", channel = "+ channel+", volume = "+volume+"]");
	}
	public void volume(int i) {
		this.volume=i;
		
	}
	public void volume(boolean b) {
		// TODO Auto-generated method stub
		if(b) {
			this.volume++;
		}else {
			this.volume--;
		}
		
	}
	public void channel(int i) {
		this.channel=i;
		
	}
	public void channel(boolean b) {
		if(b) {
			this.channel++;
		}else {
			this.channel--;
		}
	}

}
