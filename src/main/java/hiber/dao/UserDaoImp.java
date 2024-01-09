package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
   private final SessionFactory sessionFactory;

   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void createUser(User user) {

      if (user.getCar() != null) {
         sessionFactory.getCurrentSession().save(user.getCar());
      }
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> getAllUsers() {
      String hql = "FROM User";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql, User.class);
      return query.getResultList();
   }

   @Override
   public List<User> getUsersByCar(String model, int series) {
      String hql = "FROM User u LEFT OUTER JOIN FETCH u.car WHERE u.car.model=:model and u.car.series=:series";

      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql, User.class);
      query.setParameter("model", model);
      query.setParameter("series", series);

      return query.getResultList();
   }

}
