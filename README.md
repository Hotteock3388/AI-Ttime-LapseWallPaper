# TimeLapse

TimeLapse는 **휴대전화의 배경화면에 시간의 변화를 입혀주는** 서비스입니다.<br>
인공지능을 전공하는 친구가 발견한 AI 모델이 멋있고, 재미있어 보여서 이를 활용할 수 있는 프로젝트를 제작하게 되었습니다!<br>
사용자가 고른 사진 1장을 앱에서 서버로 전송하면, 서버에서 AI가 사진을 여러 시간대에 맞게 변환, 앱으로 전송합니다.<br>
앱은 해당 사진들을 저장하고, 주기적으로 현재 시각에 맞는 사진으로 휴대전화의 배경화면을 변경합니다. <br><br>


**이미지 변환 예시**

<img src="https://user-images.githubusercontent.com/57486593/121773000-1877fa80-cbb4-11eb-8f0b-91e81197eb5b.png" width="200"> <br> 원본 이미지 샘플<br><br>


<img src="https://user-images.githubusercontent.com/57486593/121773019-39d8e680-cbb4-11eb-8fb3-008a4862b9b3.png" width="200"><img src="https://user-images.githubusercontent.com/57486593/121773022-3d6c6d80-cbb4-11eb-8b84-10752876410b.png" width="200"><img src="https://user-images.githubusercontent.com/57486593/121773020-3ba2aa00-cbb4-11eb-886a-00b6c2685819.png" width="200"><img src="https://user-images.githubusercontent.com/57486593/121773018-380f2300-cbb4-11eb-9ef5-3bbf8a753281.png" width="200">
<br>변환 이미지 샘플 <br><br>


## 기능
현재 적용중인 사진들 보기<br>
시간의 변화를 입힐 사진 선택(사용자 갤러리에서 OR 추천)<br>
변환된 이미지 적용 전 미리보기<br><br><br>



## 맡은 역할 & 한 일 

Kotlin을 사용한 Android 앱 개발을 담당했습니다. 

`Foreground Service`를 사용해 죽지 않는 서비스(`Immortal service`)를 구현했고, 

`SharedPreferences`를 사용해 AI가 변환한 이미지를 저장, 일정 시간마다 `WallPaperManager`를 사용해 휴대전화의 배경화면을 `ArrayList`에 저장된 이미지로 변경하는 기능을 구현했습니다.
<br><br><br>

<img src="https://user-images.githubusercontent.com/57486593/121773446-f9c73300-cbb6-11eb-9384-cc029e9f387a.png" width="200"> <img src="https://user-images.githubusercontent.com/57486593/121773444-f8960600-cbb6-11eb-9ae1-20e9b012a715.png" width="200"> <img src="https://user-images.githubusercontent.com/57486593/121773441-f6cc4280-cbb6-11eb-8d00-49333eb0a4f3.png" width="200">
<br>
<img src="https://user-images.githubusercontent.com/57486593/121773440-f59b1580-cbb6-11eb-898d-3a758d2f9ab9.png" width="200">
<img src="https://user-images.githubusercontent.com/57486593/121773447-fa5fc980-cbb6-11eb-9980-25694bb72072.png" width="200">
<br><br>
Gif는 곧 추가 예정입니다!


## 📂 Library

[ViewPager](https://developer.android.com/jetpack/androidx/releases/viewpager2?hl=ko)

[DataBinding](https://developer.android.com/topic/libraries/data-binding?hl=ko)

[AAC ViewModel](https://developer.android.com/reference/androidx/lifecycle/ViewModel?hl=ko)

[Retrofit2](https://square.github.io/retrofit/)

[Glide](https://github.com/bumptech/glide)

