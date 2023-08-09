프로젝트 열기전에 폴더에서 `.git` 폴더랑 `.gitignore` 라는 파일 삭제하기

--------------------------------------------

프로젝트 열어서 `build.gradle.kts` 파일로 간다음에 7번줄에 `group = "io.github.lucystudio.example` 있는데 `example` 만 플러그인 이름으로 바꾸면됨(띄어쓰기X ,대문자X) 혹시 버전 바꾸려면 `version = "1.0"` 에서 `1.0` 만 버전으로 바꾸면됨

`gradle.properties` 에서 `testServerDir=C:\\Users\\itskimlot..` 있는데 `C:\\Users\\itskimlot..` 만 테스트서버 주소로 바꾸면됨

`settings.gradle.kts` 에서 `rootProject.name = "ExamplePlugin` 있는데 `ExamplePlugin` 플러그인 이름으로 바꾸기

--------------------------------------------

`main -> kotlin -> resources -> plugin.yml` 에서 `name` 은 플러그인 이름, `main`은 `example`만 아까 group에서 바꾼거로 변경, `version`은 피룡하면 변경 `api-version`은 수정하면 안됨

`main -> kotlin -> io.github.lucystudio.example` 있는데 `io.github.lucystudio.example` 을 한번 클릭하고 `Shift+F6` 누른다음에 `example` 부분만 아까 group에서 바꾼거로 변경

`main -> kotlin -> io.github.lucystudio.(바꾼거) -> Main` 으로 가서 `onEnable`이랑 `onDisable`만 수정(그 위에거는 필요하면 수정)

https://github.com/itsk1mlot/ExamplePlugin
