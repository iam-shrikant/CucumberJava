package StepDefinitions;

public class Mobile implements Comparable<Mobile> {
	
	private String deviceModel;
	private double devicePrice;
	private int deviceRating;
	private int deviceStorage;
	
	public Mobile(String deviceModel, int deviceRating, int deviceStorage,double devicePrice) {
		this.deviceModel = deviceModel;
		this.devicePrice = devicePrice;
		this.deviceRating = deviceRating;
		this.deviceStorage = deviceStorage;
	}
	
	
    public String getDeviceModel()   {  return deviceModel; }
    public double getDevicePrice()      {  return devicePrice;  }
    public int getRating() { return deviceRating; }
    public int getDeviceStorage() { return deviceStorage; }

    // Used to sort movies by Rating
	public int compareTo(Mobile m) {
		// TODO Auto-generated method stub
		if(this.devicePrice > m.devicePrice) {
			return -1;
		}else if(this.devicePrice < m.devicePrice) {
			return 1;
		}else if(this.deviceStorage > m.deviceStorage) {
			return -1;
		}else if(this.deviceStorage < m.deviceStorage) {
			return 1;
		}else if(this.deviceRating > m.deviceRating) {
			return -1;
		}else if(this.deviceRating < m.deviceRating) {
			return 1;
		}else{
			return 0;
		}
	}
	
	

}
