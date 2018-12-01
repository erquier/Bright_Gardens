package brightgardens

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ContratistaServiceSpec extends Specification {

    ContratistaService contratistaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Contratista(...).save(flush: true, failOnError: true)
        //new Contratista(...).save(flush: true, failOnError: true)
        //Contratista contratista = new Contratista(...).save(flush: true, failOnError: true)
        //new Contratista(...).save(flush: true, failOnError: true)
        //new Contratista(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //contratista.id
    }

    void "test get"() {
        setupData()

        expect:
        contratistaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Contratista> contratistaList = contratistaService.list(max: 2, offset: 2)

        then:
        contratistaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        contratistaService.count() == 5
    }

    void "test delete"() {
        Long contratistaId = setupData()

        expect:
        contratistaService.count() == 5

        when:
        contratistaService.delete(contratistaId)
        sessionFactory.currentSession.flush()

        then:
        contratistaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Contratista contratista = new Contratista()
        contratistaService.save(contratista)

        then:
        contratista.id != null
    }
}
