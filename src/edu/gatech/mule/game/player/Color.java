package edu.gatech.mule.game.player;

/**
 * A nice wrapper for colors, really.
 * @author tshields
 *
 */
public enum Color {
	PURPLE (145, 85, 134),
	BLUE (83, 99, 141),
	TEAL (66, 110, 125),
	SEAFOAM (86, 136, 126),
	GREEN (97, 149, 75),
	GOLD (143, 142, 74),
	ORANGE (157, 108, 56),
	MAROON (123, 63, 59);

	private java.awt.Color color;

	private Color(int red, int green, int blue) {
		this.color = new java.awt.Color(red, green, blue);
	}

	/**
	 * Get's the java.awt.Color color.
	 * @return the java.awt.Color representation
	 */
	public java.awt.Color getRGB() {
		return this.color;
	}

}
