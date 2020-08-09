package ru.geekbrains.sample.dao;

import org.springframework.stereotype.Repository;
import ru.geekbrains.sample.persistence.entity.Tutor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

@Repository
public class TutorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Tutor> findAllTutors() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tutor> query = builder.createQuery(Tutor.class);
        Root<Tutor> root = query.from(Tutor.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public Tutor findById(UUID uuid) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tutor> query = builder.createQuery(Tutor.class);
        Root<Tutor> root = query.from(Tutor.class);
        query.select(root).where(builder.and(builder.equal(root.get("uuid"), uuid)));
        return entityManager.createQuery(query).getSingleResult();
    }

    public void addTutor(Tutor tutor) {
        if (tutor != null) {
            entityManager.getTransaction().begin();
            entityManager.persist(tutor);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }
}
