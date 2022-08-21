package me.knightswhosayni.knightvision.objects.fixture.impl;

import me.knightswhosayni.knightvision.artnet.ArtnetUtil;
import me.knightswhosayni.knightvision.objects.fixture.Fixture;

import java.util.List;

public class TestFixture extends Fixture {

	public TestFixture(ArtnetUtil artnet, int universe, int dmxAddr) {
		super(artnet, 7, universe, dmxAddr);
	}

	@Override
	public void setDimmer(double value) {
		this.dmxData[6] = (byte)(value*255);
	}

	@Override
	public void setRGB(double r, double g, double b) {
		this.dmxData[0] = (byte)(r*255);
		this.dmxData[1] = (byte)(g*255);
		this.dmxData[2] = (byte)(b*255);
	}

	@Override
	public void setStrobe(double value) {
		this.dmxData[4] = (byte)(value*255);
	}


}
