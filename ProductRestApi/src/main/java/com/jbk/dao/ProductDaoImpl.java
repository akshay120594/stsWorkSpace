package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Product;
import com.jbk.model.Product_Supplier;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean saveProduct(Product product) {
		Session session=null;
		Transaction transaction=null;
		boolean isAdded=false;
		try {
			
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Product prd=session.get(Product.class,product.getProductId());
			if(prd==null) {
				session.save(product);
			transaction.commit();
			isAdded=true;}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}

		return isAdded;
	}

	@Override
	public Product getProduct(int productId) {
		Session session=null;
		Product product=null;
		try {
			session = sessionFactory.openSession();
			product = session.get(Product.class,productId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		Session session=null;
		List<Product> list=null;
		try {
			session=sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			list=criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();}
		}
		
		return list;
	}

	@Override
	public boolean deleteProduct(int productId) {
		Session session=null;
		Transaction transaction=null;
		boolean isDeleted=false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Product prd=session.get(Product.class,productId);
			if (prd!=null) {
				session.delete(prd);
				isDeleted=true;				
			}
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();}
		}
		return isDeleted;
	}

	@Override
	public boolean updateProduct(Product product) {
		Session session=null;
		Transaction transaction=null;
		boolean isUpdated=false;
		try {
			int productId=2;
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Product prd=session.get(Product.class,productId);
			if (prd!=null) {
				session.evict(prd);
				session.update(product);
				isUpdated=true;				
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();}
		}
		return isUpdated;

}

	@Override
	public Product_Supplier getProductWithSupplierByProductId(int productId) {
		// TODO Auto-generated method stub
		return null;
	}}
