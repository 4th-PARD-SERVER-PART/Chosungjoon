안녕하세요? 시험 기간 동안 바쁜 탓에 이리저리 미루다가 비로소 어제야 시작을 해버린 저 자신을 탓하며.. 부랴부랴 과제를 해보았습니다.
급하게 하느라 멘붕이 오긴 했지만 그래도 열심히 밤 낮 고민하며 시간을 쏟았기에 과제를 해낼 수 있었네요.

우선은 swagger을 사용하여 제가 구현한 것들을 소개해보겠습니다
과제에서 요구한 내용은 블로그 구현하기 였는데요
1.작성자별 게시글 목록 조회
2.새로운 게시글 작성 시 작성자 선택
3.게시글 수정 및 삭제

이렇게 3가지였네요
우선은 작성자를 만들어봐야겠죠?

<img width="1435" alt="스크린샷 2024-10-25 오전 11 41 44" src="https://github.com/user-attachments/assets/f7256f9b-4168-45d6-ab44-281d4bb72d32">
<img width="1435" alt="스크린샷 2024-10-25 오전 11 42 03" src="https://github.com/user-attachments/assets/d88c2207-a351-4bf5-b1bb-010308b94883">

조성준과 천주현이라는 사용자를 만들어보았습니다.

<img width="1435" alt="스크린샷 2024-10-25 오전 11 55 53" src="https://github.com/user-attachments/assets/89cc1620-024b-4b59-a7f2-dd3f966cee6c">

사용자들이 이렇게 만들어졌네요
그럼 이제 새로운 게시글을 만들어봐야겠죠? 과제에서 요구한대로 사용자 별로 게시글을 만들어 볼 겁니다.

<img width="1435" alt="스크린샷 2024-10-25 오전 11 57 24" src="https://github.com/user-attachments/assets/2ad2c591-921b-41fe-8d08-8cd1e082d6a2">

<img width="1435" alt="스크린샷 2024-10-25 오전 11 57 44" src="https://github.com/user-attachments/assets/35e1b140-bd55-4d97-a988-3709ddd0b5cc">

<img width="1435" alt="스크린샷 2024-10-25 오전 11 58 05" src="https://github.com/user-attachments/assets/acc7d732-7563-4cd6-a4a9-9cea31e28410">

사용자들 별로 이렇게 게시물들도 각각 만들어보았습니다.

그렇다면 작성자별 게시글 목록 조회를 해보도록 하죠.

<img width="1435" alt="스크린샷 2024-10-25 오전 11 58 50" src="https://github.com/user-attachments/assets/87170ef4-6035-4232-935e-48b7a06e9edb">

<img width="1435" alt="스크린샷 2024-10-25 오전 11 59 01" src="https://github.com/user-attachments/assets/1d7ca8bd-bd4d-4d33-89ce-69dbadd83b3c">

사용자 아이디별로 각각 작성한 글들을 확인할 수 있습니다.

그렇다면 게시글을 수정 및 삭제 해보도록 하겠습니다.
사용자 별로 수정과 삭제가 가능하도록 만들어보겠습니다.
그렇게 하기 위해서는 자신의 사용자 아이디와 포스트 아이디를 모두 가지고 있어야 하겠죠?

<img width="1435" alt="스크린샷 2024-10-25 오후 12 02 15" src="https://github.com/user-attachments/assets/9d5f772f-32ed-4c64-816e-5ee169c3802c">

<img width="1435" alt="스크린샷 2024-10-25 오후 12 02 32" src="https://github.com/user-attachments/assets/e9bd89c5-dc1d-4bd6-9d54-5e95ed746481">

이렇게 수정을 한 다음에 DB를 확인해보면 

<img width="1435" alt="스크린샷 2024-10-25 오후 12 03 21" src="https://github.com/user-attachments/assets/5c0d9b22-6af9-4ea3-b8cf-74f95b2adb33">

이렇게 수정이 완료되었습니다


삭제 기능도 구현을 해볼텐데요

수정 기능과 동일하겠죠?

<img width="1435" alt="스크린샷 2024-10-25 오후 12 04 28" src="https://github.com/user-attachments/assets/8e89dd90-be77-41c7-921a-b0fc239a71fa">

이렇게 사용자 아이디와 그에 맞는 게시물 아이디를 입력해주면 

<img width="1435" alt="스크린샷 2024-10-25 오후 12 04 51" src="https://github.com/user-attachments/assets/1d117272-58d0-48b8-b1c0-1a33dc5974d9">

짜잔! 이렇게 삭제가 완료되었습니다.

<img width="1435" alt="스크린샷 2024-10-25 오후 12 05 28" src="https://github.com/user-attachments/assets/cbc8d451-1b72-41a3-99fb-1a39b7d87207">

이건 추가로 제가 문제를 잘 읽지 않아서 잘 못 만든 기능인데요.. 그냥 게시물 아이디로도 게시물을 조회할 수 있는 기능입니다.

좋아요 기능도 만들어보고 싶은데..
사실 어렵진 않은데 시간이 없는 관계로 이번 주말에 구현을 해보고 다시 업데이트 해볼게요

그럼 바이바이!!!






