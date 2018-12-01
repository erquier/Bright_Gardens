package brightgardens

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ContratistaController {

    static layout = 'tuculitosacallama'

    ContratistaService contratistaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond contratistaService.list(params), model:[contratistaCount: contratistaService.count()]
    }

    def show(Long id) {
        respond contratistaService.get(id)
    }

    def create() {
        respond new Contratista(params)
    }

    def save(Contratista contratista) {
        if (contratista == null) {
            notFound()
            return
        }

        try {
            contratistaService.save(contratista)
        } catch (ValidationException e) {
            respond contratista.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'contratista.label', default: 'Contratista'), contratista.id])
                redirect contratista
            }
            '*' { respond contratista, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond contratistaService.get(id)
    }

    def update(Contratista contratista) {
        if (contratista == null) {
            notFound()
            return
        }

        try {
            contratistaService.save(contratista)
        } catch (ValidationException e) {
            respond contratista.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'contratista.label', default: 'Contratista'), contratista.id])
                redirect contratista
            }
            '*'{ respond contratista, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        contratistaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'contratista.label', default: 'Contratista'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'contratista.label', default: 'Contratista'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
