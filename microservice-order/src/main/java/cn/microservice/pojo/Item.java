package cn.microservice.pojo;

public class Item {

	private long id;  
	private String title;
	private String pic;
	private String desc;
	private long price;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", pic=" + pic + ", desc=" + desc + ", price=" + price
				+ ", getId()=" + getId() + ", getTitle()=" + getTitle() + ", getPic()=" + getPic() + ", getDesc()="
				+ getDesc() + ", getPrice()=" + getPrice() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	public Item(long id, String title, String pic, String desc, long price) {
		super();
		this.id = id;
		this.title = title;
		this.pic = pic;
		this.desc = desc;
		this.price = price;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
