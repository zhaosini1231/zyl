package Model;

/**
 * AbstractPark entity provides the base persistence definition of the Park
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPark implements java.io.Serializable {

	// Fields

	private String parkId;
	private String parkStatic;
	private Double price;

	// Constructors

	/** default constructor */
	public AbstractPark() {
	}

	/** minimal constructor */
	public AbstractPark(String parkId) {
		this.parkId = parkId;
	}

	/** full constructor */
	public AbstractPark(String parkId, String parkStatic, Double price) {
		this.parkId = parkId;
		this.parkStatic = parkStatic;
		this.price = price;
	}

	// Property accessors

	public String getParkId() {
		return this.parkId;
	}

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}

	public String getParkStatic() {
		return this.parkStatic;
	}

	public void setParkStatic(String parkStatic) {
		this.parkStatic = parkStatic;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}