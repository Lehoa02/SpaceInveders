package com.zetcode.sprite;

import javax.swing.ImageIcon;

public class Back extends Sprite{
	public Back() {

		initBack();
	}

	private void initBack() {

		var playerImg = "src\\images\\back.png";
		var ii = new ImageIcon(playerImg);

		setImage(ii.getImage());
}}
