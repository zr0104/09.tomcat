package Emtity;

public class Goods {
	//商品ID
	private int goodsId;
	//商品名称
	private String goodsName;
	//成本价
	private int costPrice;
	//售价
	private int selling;
	//制造商
	private String manufacturer;
	
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}
	public int getSelling() {
		return selling;
	}
	public void setSelling(int selling) {
		this.selling = selling;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
}
