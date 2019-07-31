package jvm.understandingjvm.executionsubsystem.ch08;

public class TestGC2{
public static void main(String[] args)() {
	{
		byte[] placeholder = new byte[64 * 1024 * 1024];
	}
	System.gc();
}
}

