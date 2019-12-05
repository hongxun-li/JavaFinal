package com.prog;

public class Item {
	private String iid;
	private String iname;
	private int stock;
	
	Item(String iid, String iname, int stock)
	{
		this.iid = iid;
		this.iname = iname;
		this.stock = stock;
	}

	public String getIid() {
		return iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
}
