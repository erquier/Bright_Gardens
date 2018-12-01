package brightgardens

import grails.gorm.services.Service

@Service(Contratista)
interface ContratistaService {

    Contratista get(Serializable id)

    List<Contratista> list(Map args)

    Long count()

    void delete(Serializable id)

    Contratista save(Contratista contratista)

}