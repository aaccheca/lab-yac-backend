package yavirac.labyac.repository;

import java.util.List;
import yavirac.labyac.entity.*;

public interface RegistroLaboratorioRepositoryCustom {
    List<RegistroLaboratorio> findAllWithNovedadesNotNull();
}
