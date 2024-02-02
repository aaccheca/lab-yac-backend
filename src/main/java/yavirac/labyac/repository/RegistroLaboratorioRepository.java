package yavirac.labyac.repository;
import yavirac.labyac.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroLaboratorioRepository extends JpaRepository<RegistroLaboratorio, Long>, RegistroLaboratorioRepositoryCustom {
    
}
