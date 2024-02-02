package yavirac.labyac.repository;

import java.util.List;
import yavirac.labyac.entity.*;

public interface NotificacionRepositoryCustom {
    List<Notificacion> findNotificacionesByUsuarioId(Long usuarioId);
}