package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'POST'
		url '/createEntity'
		headers {
			contentType(applicationJson())
		}
		body (
			value: $(regex('[a-z]+'))
		)
	}
	response {
		status 200
		headers {
			contentType(applicationJson())
		}
		body (
		  value: $(regex('[a-z]+')),
		  timeSet: $(regex("[0-9]{2}:[0-9]{2}:[0-9]{2}.[0-9]{3}"))
		)
	}
}