// 着せかえ可能な携帯プレーヤ

class PortablePlayer implements Player, Skinnable {
	private int skin = BLACK;

	public PortablePlayer() { }										// コンストラクタ

	public void play() {													// ○再生
		System.out.println("◆再生開始！"); 
	}

	public void stop() {													// ○停止
		System.out.println("◆再生終了！"); 
	}

	public void changeSkin(int skin) {								// ★スキン変更
		System.out.print("スキンを");
		switch (skin) {
		 case BLACK:   System.out.print("漆黒");	break;
		 case RED:     System.out.print("深紅");	break;
		 case GREEN:   System.out.print("柳葉");	break;
		 case BLUE:    System.out.print("露草");	break;
		 case LEOPARD: System.out.print("豹柄");	break;
		 default:		System.out.print("無地");	break;
		}
		System.out.println("に変更しました。");
	}	
}