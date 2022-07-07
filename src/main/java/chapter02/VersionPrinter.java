package chapter02;

public class VersionPrinter {
	private int major;
	private int minor;

	public void setMajor(int major) {
		this.major = major;
	}

	public void setMinor(int minor) {
		this.minor = minor;
	}

	public void printVerSion() {
		String fullVersion = major + "." + minor;

		System.out.println("프로그램 버전 : " + fullVersion);
		System.out.println();
	}

}
