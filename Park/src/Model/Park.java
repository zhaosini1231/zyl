package Model;

/**
 * Park entity. @author MyEclipse Persistence Tools
 */
public class Park extends AbstractPark implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Park() {
	}

	/** minimal constructor */
	public Park(String parkId) {
		super(parkId);
	}

	/** full constructor */
	public Park(String parkId, String parkStatic, Double price) {
		super(parkId, parkStatic, price);
	}

}
