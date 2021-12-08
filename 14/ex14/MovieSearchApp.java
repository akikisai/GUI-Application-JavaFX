package ex14;

import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MovieSearchApp extends Application {

	public static String gakuban = "19EC043"; // 学籍番号を入力すること
	public static String yourname = "蔡晟輝"; // 氏名を入力すること

	@Override
	public void start(Stage stage) {
		// プログラムを作成

		//ラベル作成
		Label lbl_from = new Label("From");
		Label lbl_to = new Label("To");
		Label lbl_rank = new Label("順位");
		Label lbl_py = new Label("公開年");

		//テキストフィールド作成
		TextField tf1 = new TextField("");
		TextField tf2 = new TextField("");
		TextField tf3 = new TextField("");
		TextField tf4 = new TextField("");

		//ボタン作成
		Button btn_search = new Button("検索");
		Button btn_reset = new Button("リセット");

		//table
		TableView<Movie> table = new TableView<>();
		ObservableList<Movie> data = FXCollections.observableArrayList();

		TableColumn<Movie, String> rankCol = new TableColumn<>("順位");
		rankCol.setCellValueFactory(new PropertyValueFactory<>("rank"));
		TableColumn<Movie, String> yearCol = new TableColumn<>("公開年");
		yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
		TableColumn<Movie, String> titleCol = new TableColumn<>("タイトル");
		titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
		table.getColumns().addAll(rankCol, yearCol, titleCol);
		table.setItems(data);
		table.setPrefWidth(415);

		//MovieDataを分けて、初期状態のデータを表に追加    
		String[] md = MovieData.data;
		int num = md.length;
		int[] arrayRank =new int[num];
		String[] arrayTitle =new String[num];
		int[] arrayYear =new int[num];
		String[] n =new String[3];               
		for(int i = 0; i < num; i++) {
			n = md[i].split(",");
			arrayRank[i] = seisu(n[0].trim());
			arrayTitle[i] = n[1].trim();
			arrayYear[i] = seisu(n[2].trim());
			//表の初期化(すべてのデータを表示)
			data.add(new Movie(
					arrayRank[i],
					arrayTitle[i],
					arrayYear[i]
					));
		}

		//円グラフ宣言
		PieChart pieChart = new PieChart();
		pieChart.setClockwise(true);
		pieChart.setStartAngle(90);    

		//検索ボタンの動作
		btn_search.setOnAction((ActionEvent event) -> {
			//テキストフィールドの値が正の整数もしくは空白になっているかを判定
			if(
					(tf1.getText().matches("^[0-9]+$") || tf1.getText().isEmpty()) &&
					(tf2.getText().matches("^[0-9]+$") || tf2.getText().isEmpty()) &&
					(tf3.getText().matches("^[0-9]+$") || tf3.getText().isEmpty()) &&
					(tf4.getText().matches("^[0-9]+$") || tf4.getText().isEmpty()) ) {

				//テキストフィールド条件判定
				int rank_from, rank_to, year_from, year_to;
				if(tf1.getText().isEmpty()) rank_from = 1;
				else rank_from = seisu(tf1.getText());
				if(tf2.getText().isEmpty()) rank_to = 100;
				else rank_to = seisu(tf2.getText());
				if(tf3.getText().isEmpty()) year_from = 1970;
				else year_from = seisu(tf3.getText());
				if(tf4.getText().isEmpty()) year_to = 2021;
				else year_to = seisu(tf4.getText());
				
				//fromの値はtoの値より小さいか
				if(rank_from <= rank_to && year_from <= year_to) {
					//データのリセット
					data.removeAll(data);
					pieChart.getData().clear();
					
					//条件を満たすMovieDataのインデクスを格納する
					ArrayList<Integer> result = new ArrayList<Integer>();
					//条件を満たすMovieDataの公開年を格納する
					ArrayList<Integer> result_year = new ArrayList<Integer>();

					for(int i = 0; i < num; i++) {
						if(rank_from <= arrayRank[i] && arrayRank[i] <= rank_to &&
								year_from <= arrayYear[i] && arrayYear[i] <= year_to) {
							result.add(i);
						}
					}
					for(int i = 0; i < result.size(); i++) {
						//条件に合うデータを表に追加する
						data.add(new Movie(
								arrayRank[result.get(i)],
								arrayTitle[result.get(i)],
								arrayYear[result.get(i)]
								));
						result_year.add(arrayYear[result.get(i)]);
					}
					Collections.sort(result_year);//リストresult_yearをソートする

					//円グラフのデータ準備 公開年及びその年のMovieの数
					ArrayList<Integer> pie_year = new ArrayList<Integer>();
					ArrayList<Integer> pie_year_count = new ArrayList<Integer>();
					for (int i=1970; i<=2021; i++) {
						int k = 0;
						for (int t = 0; t < result_year.size(); t++) { 
							if (result_year.get(t) == i) k++; 
						}
						if(k > 0) {
							pie_year.add(i);
							pie_year_count.add(k);
						}
					}

					//円グラフにデータを追加
					PieChart.Data[] pieChartData = new PieChart.Data[pie_year.size()];
					for(int i = 0; i < pie_year.size(); i++) {
						pieChartData[i] = new PieChart.Data(moji(pie_year.get(i)), pie_year_count.get(i));
					}
					pieChart.getData().addAll(pieChartData);
				}else {
					error();
				}
			}else {
				error();
			}
		});

		//リセットボタンの動作
		btn_reset.setOnAction((ActionEvent event) -> {
			data.removeAll(data);
			for(int i = 0; i < num; i++) {
				//表の初期化(すべてのデータを表示)
				data.add(new Movie(
						arrayRank[i],
						arrayTitle[i],
						arrayYear[i]
						));
			}
			pieChart.getData().clear();
			tf1.clear();
			tf2.clear();
			tf3.clear();
			tf4.clear();
		});

		//レイアウト
		//gridpane
		GridPane gridpane = new GridPane();
		gridpane.add(lbl_from, 1, 0);
		gridpane.add(lbl_to, 2, 0 );
		gridpane.add(lbl_rank, 0, 1 );
		gridpane.add(tf1, 1, 1 );
		gridpane.add(tf2, 2, 1 );
		gridpane.add(lbl_py, 0, 2 );
		gridpane.add(tf3, 1, 2 );
		gridpane.add(tf4, 2, 2 );
		gridpane.setHgap(10);
		gridpane.setVgap(10);

		//stackpane
		StackPane stackPane = new StackPane(pieChart);

		//hbox & vbox
		HBox hbox1 = new HBox(20, btn_search, btn_reset );
		VBox vbox2 = new VBox(10, gridpane, hbox1, stackPane);
		hbox1.setPadding(new Insets(10));
		vbox2.setPadding(new Insets(25));
		hbox1.setAlignment(Pos.CENTER);
		gridpane.setAlignment(Pos.CENTER);
		stackPane.setAlignment(Pos.CENTER);

		//borderpane
		BorderPane bp = new BorderPane();
		bp.setCenter(vbox2);
		bp.setRight(table);

		stage.setResizable(false);
		stage.setScene(new Scene(bp, 830, 500));
		stage.setTitle("Ex14");
		stage.show();
	}
	//文字列を数値に変換するメソッド
	public static int seisu(String s){
		return Integer.parseInt(s);
	}
	//数値を文字列に変換するメソッド
	public static String moji(int n){
		return String.valueOf(n);
	}
	//アラート(エラー)
	void error() {
		Alert alert = new Alert(Alert.AlertType.ERROR,
				"注意：\n"
				+ "1. fromの入力値をtoより小さくすること\n"
				+ "2. 正の整数以外は入力しない");
		alert.showAndWait();
	}
	public static void main(String[] args) {
		// アプリケーションを起動する
		Application.launch(args);
		System.out.println("完了--MovieSearchApp");
	}
}

/* 考察 -- 調査したこと、考慮したこと、工夫したことを記述
調査したことはtable、円グラフ、arraylistの使い方、文字列をどうやってカンマで区切って抽出するか、
文字列の端っこの空白除去方法、gridpaneなどです。
苦心したことは、最初はデータの""の間にスペースがあるのに気付かず順番及び公開年をうまく整数に変換できずエラーが出て、
これを見つけるのに時間がかかったのと、構造やコードの問題で円グラフのデータ追加＆表示がなかなかうまくいかない。
工夫したことは、コードをなるべくきれいに書いて、コメントを付けたのと、メソッドも使用した。またプログラムの構造をしっかりし、
エラーがもれず判定される、この判定にアラートを使用し、さらにアラートに注意点も記入したことでユーザにどこで間違ったかを知らせる。
出来栄えは、見た目を重視し、gridpaneなどを使い間隔などもしっかり決めたのと、問題なくアプリが動いたのでいいと思うが、
機能定義のほうで、fromやtoの値は必ず小さい値から大きい値か、そうでないか、また片方のテキストフィールドは空白の場合、
それは上限値になるか下限値になるかがはっきりしていないので、もしかしたらこれよりプログラムを変更すべき点が出てくるかもしれないと思った。

 */
