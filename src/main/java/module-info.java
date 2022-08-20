module me.knightswhosayni.knightvision {
	requires javafx.controls;
	requires javafx.fxml;

	requires org.controlsfx.controls;

	opens me.knightswhosayni.knightvision to javafx.fxml;
	exports me.knightswhosayni.knightvision;
}