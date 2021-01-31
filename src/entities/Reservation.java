package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getcheckIn() {
		return checkIn;
	}


	public Date getcheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	public void updateDate(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}

	@Override
	public String toString() {
		return "Room" + roomNumber
				+",Check In:"+sdf.format(checkIn)
				+",Check Out:"+sdf.format(checkOut)+
				", "
				+duration()
				+ "nights:";
	}

	

}
