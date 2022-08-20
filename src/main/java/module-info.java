module me.knightswhosayni.knightvision {
	requires javafx.controls;
	requires javafx.fxml;

	requires org.controlsfx.controls;
	requires artnet4j;

	opens me.knightswhosayni.knightvision to javafx.fxml;
	exports me.knightswhosayni.knightvision;
}