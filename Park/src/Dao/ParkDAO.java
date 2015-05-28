package Dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Model.Park;

/**
 * A data access object (DAO) providing persistence and search support for Park
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see Dao.Park
 * @author MyEclipse Persistence Tools
 */
public class ParkDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ParkDAO.class);
	// property constants
	public static final String PARK_STATIC = "parkStatic";
	public static final String PRICE = "price";

	public void save(Park transientInstance) {
		log.debug("saving Park instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Park persistentInstance) {
		log.debug("deleting Park instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Park findById(java.lang.String id) {
		log.debug("getting Park instance with id: " + id);
		try {
			Park instance = (Park) getSession().get("Model.Park", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Park instance) {
		log.debug("finding Park instance by example");
		try {
			List results = getSession().createCriteria("Model.Park")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Park instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Park as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByParkStatic(Object parkStatic) {
		return findByProperty(PARK_STATIC, parkStatic);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findAll() {
		log.debug("finding all Park instances");
		try {
			String queryString = "from Park";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Park merge(Park detachedInstance) {
		log.debug("merging Park instance");
		try {
			Park result = (Park) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Park instance) {
		log.debug("attaching dirty Park instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Park instance) {
		log.debug("attaching clean Park instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}