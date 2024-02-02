package yavirac.labyac.repository;

import yavirac.labyac.entity.RegistroLaboratorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class RegistroLaboratorioRepositoryImpl implements RegistroLaboratorioRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RegistroLaboratorio> findAllWithNovedadesNotNull() {
        String jpql = "SELECT r FROM RegistroLaboratorio r WHERE r.novedades IS NOT NULL";
        TypedQuery<RegistroLaboratorio> query = entityManager.createQuery(jpql, RegistroLaboratorio.class);
        return query.getResultList();
    }
}
