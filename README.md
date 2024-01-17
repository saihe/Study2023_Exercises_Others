[![Test workflow](https://github.com/saihe/Study2023_Exercises_Others/actions/workflows/test.yml/badge.svg)](https://github.com/saihe/Study2023_Exercises_Others/actions/workflows/test.yml)
# 総合演習を自分が実装したら

## 実行方法

### makeコマンドが使える場合

``` bash
make build && make run app=${command}
```

### makeコマンドが使えない場合

``` bash
./gradlew app:shadowJar && java -jar ./app/build/libs/app-all.jar ${command}
```

## コマンド早見表

| コマンド     | 実行されるアプリ |
|----------|----------|
| nozaki   | 収支管理     |
| nakamaki | おみくじ     |
| murata   | サブスク管理   |
| gohara   | 献立提案     |
