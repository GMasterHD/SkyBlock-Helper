package io.github.gmasterhd.skyblockhelper.utils;

import lombok.Getter;

public class EnumUtils {
	public enum Floor {
		F1(0, "Bonzo"),
		F2(1, "Scarf"),
		F3(2, "The Professor"),
		F4(3, "Thorn"),
		F5(4, "Livid"),
		F6(5, "Sadan"),
		F7(6, "Necron")
		;
		
		@Getter int id;
		@Getter String bossName;
		
		Floor(int id, String bossName) {
			this.id = id;
			this.bossName = bossName;
		}
	}
	
	public enum Gui {
		FEATURES
	}
}
