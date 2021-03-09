package com.medical.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.medical.pojo.Order;

public class OrderDAO implements IOrderDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional
	public int insert(Order order) {
		Integer modifiedColoums=(Integer) hibernateTemplate.save(order);
		return modifiedColoums;
	}
	public List<Order> getAll() {
		return hibernateTemplate.loadAll(Order.class);
	}

	public List<Order> getAllPending() {
		Order order=new Order();
		order.setStatus("Not received");
		return hibernateTemplate.findByExample(order);
	}

	public Order getById(int id) {
		/*
		 * String query = "select * from Order_stock where id =?"; RowMapper<Order>
		 * rowMapper = new OrderMapper(); return jdbcTemplate.queryForObject(query,
		 * rowMapper, id);
		 */
		Order order=new Order();
		order.setStatus("Not received");
		List<Order> orders= hibernateTemplate.findByExample(order);
		return orders.get(0);
	}

	public void updateStatus(Order order) {
		//String query = "update Order_stock set Delivery_status = 'Deliverd' where id ="+id+" ";
		hibernateTemplate.update(order);
	}

	

}
