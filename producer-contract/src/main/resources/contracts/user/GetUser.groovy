package contracts.user

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label '사용자 상세 조회'
    description('사용자 id 로 사용자를 조회할 수 있다.')
    input {
        triggeredBy('getUser()')
    }
    request {
        method 'GET'
        url '/get/1'
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