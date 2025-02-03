# 일정 관리 앱

## API 목록

|    기능    | Method | URL      | request                                         | response                                                                                                                                   | 상태코드                                                                                                               |
|:--------:|:------:|----------|-------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|
|  일정 생성   |  Post  | /sm      | {<br>`"name": "이름",`<br>`"pw": "비밀번호",`<br>`"todo":"할일"`<br>} | `{<br>`"id":"식별자",`<br>`"name": "이름",`<br>`"todo": "할일",`<br>`"createDateTime": "생성일",`<br>`"updateDateTime": "생성일"`<br>}                  | 200: 정상생성                                                                                                          |
| 전체 일정 조회 |  Get   | /sm      | { }                                             | {<br>{<br>`"id":"식별자",`<br>`"name": "이름",`<br>`"todo": "할일",`<br>`"createDateTime": "생성일",`<br>`"updateDateTime": "수정일"`<br>},<br>...<br>} | 200: 정상조회 |
| 선택 일정 조회 |  Get   | /sm/{id} | { }                                             | {<br>`"id":"식별자",`<br>`"name": "이름",`<br>`"todo": "할일",`<br>`"createDateTime": "생성일",`<br>`"updateDateTime": "수정일"`<br>}                   | 200: 정상조회                                                                                                          |
| 선택 일정 수정 |  Put   | /sm/{id} | {<br>`"name": "이름",`<br>`"pw": "비밀번호",`<br>`"todo":"할일"`<br>} | {<br>`"id":"식별자",`<br>`"name": "이름",`<br>`"todo": "할일",`<br>`"createDateTime": "생성일",`<br>`"updateDateTime": "수정일"`<br>}                   | 200: 정상수정                                                                                                          |
| 선택 일정 삭제 | Delete | /sm/{id} | {<br>`"pw": "비밀번호"`<br>}                                  | { }                                                                                                                                        | 200: 정상삭제                                                                                                          |

## ERD
![asd](/imges/img.png)