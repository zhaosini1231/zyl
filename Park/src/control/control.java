package control;
import java.util.List;

import org.hibernate.Session;
import Dao.ParkDAO;
import Factory.HibernateSessionFactory;
import Model.Park;
public class control {
	
	private static control control = null; 
	public static control getControl(){
		if(null==control){
			control = new control();
		}
		return control;
	}
	

	private ParkDAO ParkDAO = null;
	private Session session = null;
	private control(){
		ParkDAO = new ParkDAO();
		session = HibernateSessionFactory.getSession();
	}
	

	public Park save(String parkID,String parkStatic,Double price){
		Park park = new Park(parkID,parkStatic,price);
		ParkDAO.save(park);
		session.beginTransaction().commit();
		session.flush();
		return park;
	}
    
	public Park findById(String id){
		
		try {
			Park park = ParkDAO.findById(id);
			return park;
		} catch (Exception e) {
			return null;
		}
	}
	public List findByParkStatic(String parkStatic)
	{
		try
		{
			return ParkDAO.findByParkStatic(parkStatic);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	
	
	
	public List findALL()
	{
		return ParkDAO.findAll();
	}
	public Boolean delete(Park park) {
		try {

			ParkDAO.delete(park);
			session.beginTransaction().commit();
			session.flush();
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	
	
	public Boolean merge(Park park) {
		try {

			ParkDAO.merge(park);
			session.beginTransaction().commit();
			session.flush();
			return true;

		} catch (Exception e) {
			return false;
		}
	}
}



