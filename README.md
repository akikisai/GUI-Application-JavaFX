# GUI-Application-JavaFX
## 初めに
こちらは大学の授業で勉強し、作成したものです。各回を通して、レイアウト配置方法や、グラフの表示方法など一通り触れ、GUIアプリケーションについて理解が深めました。また出された問題についてどのようにプログラムを書けば、条件に合うエラーが出ないきれいなコードが書けるか試行錯誤して書き、少しでも成長できたと思いました。

## 作成したもの(gif付)

### 金銀銅ボタン判定
最初に金銀銅のボタンどれかを押し、後の質問に答えることで、嘘をついているかどうかを判定するアプリです。

1回でも異なる解答があれば、嘘をついていることになります。

<img src="https://user-images.githubusercontent.com/85460645/152732843-358709eb-90fc-4983-8da8-89291f664fb8.gif" width="400">

### 魔法陣
問題は文字列として与えられ（これは簡単に追加できる）問題を選択した後、縦、斜めの数の合計が15になるように穴埋めします。

<img src="https://user-images.githubusercontent.com/85460645/152732847-3fe1310b-891a-422d-bfa1-437dd0ad559c.gif" width="400">

### アルファベットゲーム

アルファベットが画面上にランダムで生成し表示され、アルファベットをA-Zの順でタッチして速さを競うゲームである。間違ったものをタッチするとお手付きが1増えます。

<img src="https://user-images.githubusercontent.com/85460645/152732850-565f26e9-3697-4080-9e76-abc08e9d41ba.gif" width="400">

### 映画検索
与えられていた映画情報（順位、公開年、タイトル）をもとに、一覧表に表示されるとともに、順位や公開年の条件を限定することで条件に合う映画だけを取り出すことができます。またそれに対応する公開年の割合を円グラフに表示できます。

<img src="https://user-images.githubusercontent.com/85460645/152732851-dd00c321-b4ed-4e48-8192-77fd18977e56.gif" width="800">

## その他

### ex01
名前を出力できるものです。

![ex01](https://user-images.githubusercontent.com/85460645/152732966-69602b56-0234-4652-b5a7-fb58cb5c8812.png)

### ex02
学籍番号を正しく判定できるかを表示できます。

![ex02](https://user-images.githubusercontent.com/85460645/152732970-2c3cd005-2d3a-432a-9b50-808253bcab6a.png)

### ex03
税抜き価格を入力し、税込み価格へ変換できます。

![ex03](https://user-images.githubusercontent.com/85460645/152732972-aa3b805b-4db7-4086-be7d-23afb3769a35.png)

### ex04
カウント値を設定し、それに応じてカウントアップやカウントダウンを押すと値が変わります。

![ex04](https://user-images.githubusercontent.com/85460645/152732975-c8299b50-e396-4931-8b26-6da632345f29.png)

### ex06
割り勘を想定したアプリで、条件は以下のようになります。
- 入力
1. 前回からの繰越額：before (>= 0)
2. 全体の支払い額：total (>= 0)
3. 人数：n >= 1
- 出力
1. 各人の支払い額：each (>= 0 かつ100の倍数)	※100円単位
2. 次回への繰越額：after (>= 0)
- 制約条件
1. before + (n × each) = total + after	※収入と支出が一致する
2. after < (100 * n)	※次回への繰越額を最小化する

![ex06](https://user-images.githubusercontent.com/85460645/152732976-e87cd234-8c6e-42ad-b0b1-f9688dd5c913.png)

### ex07
ラジオボタンやチェックボックスを利用したランチ計算機です。

![ex07](https://user-images.githubusercontent.com/85460645/152732977-93010d83-9d43-4bf5-8eaa-20f38c4b7149.png)

### ex08
枚数や1枚の金額で合計金額を計算できる発券機です。

![ex08](https://user-images.githubusercontent.com/85460645/152732978-87e61fbf-ac10-4f33-bf7d-c24020f567f5.png)

### ex09
選択された年月によって、カレンダーを表示できます。こちらはgridpaneを使用した。

![ex09](https://user-images.githubusercontent.com/85460645/152732979-a9341b68-8fc1-4f1e-8d1a-785b64ddd972.png)

### ex10
日付を表示できるものです。
- ファイル
1. 今日：今日の日付を表示。
2. 終了：ウィンドウ終了。
- 過去：「前年」「前月」「前日」があり押すとそれぞれ切り替わります。
- 未来：「翌年」「翌月」「翌日」があり押すとそれぞれ切り替わります。
- 日付で右クリック：西暦や和暦の変換ができます。

![ex10](https://user-images.githubusercontent.com/85460645/152732981-d22b86f9-be9e-4606-a142-4a6281af3a75.png)

### ex13
2020年の東京の月別降雨量の情報を用いて、棒グラフや円グラフに表示するものとなります。
![ex13](https://user-images.githubusercontent.com/85460645/152732985-481ed231-081a-4e19-8340-9ea6f062b03d.png)
