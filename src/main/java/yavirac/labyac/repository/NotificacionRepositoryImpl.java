package yavirac.labyac.repository;



import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import yavirac.labyac.entity.Notificacion;

import java.util.List;

public class NotificacionRepositoryImpl implements NotificacionRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Notificacion> findNotificacionesByUsuarioId(Long usuarioId) {
        String jpql = "SELECT n FROM Notificacion n WHERE n.maestro.id = :usuarioId";
        TypedQuery<Notificacion> query = entityManager.createQuery(jpql, Notificacion.class);
        query.setParameter("usuarioId", usuarioId);
        return query.getResultList();
    }
}