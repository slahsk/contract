package contracts.user

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/users/1'
    }
    response {
        status 200
        headers {
            header('Content-Type': 'application/json')
        }
        body('''{
                     "id" : 1, 
                     "name" : "홍길동", 
                     "email": "my@email.com", 
                     "address": {
                        "id": "600", 
                        "address": "서울시", 
                        "message": "다 내땅"
                      }
                 }''')
    }
}